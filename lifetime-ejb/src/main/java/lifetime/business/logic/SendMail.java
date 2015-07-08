/*
 * Copyright 2015 lifetime.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package lifetime.business.logic;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import lifetime.business.persistence.JobApplication;
import lifetime.business.persistence.JobOffer;
import lifetime.business.persistence.User;

/**
 *
 * @author lifetime
 */
@Stateless
public class SendMail {

    private final boolean debug = true;

    @Resource(name = "mail/lifetime")
    private Session session;

    public void sendMail(String to, String subject, String body) {
        session.setDebug(debug);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(session.getProperty("mail.from")));
            InternetAddress[] toAddress = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMail(String from, String to, String subject, String text, byte[] coverLetter, byte[] cv, byte[][] documents) {
        session.setDebug(debug);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(session.getProperty("mail.from")));
            InternetAddress[] toAddress = {new InternetAddress(to)};
            InternetAddress[] ccAddress = {new InternetAddress(from)};
            message.setRecipients(Message.RecipientType.TO, toAddress);
            message.setRecipients(Message.RecipientType.CC, ccAddress);
            message.setSubject(subject);
            //message.setText(text);

            // Mulipart message
            Multipart multipart = new MimeMultipart();

            // Text
            DataSource textDataSource = new ByteArrayDataSource(text, "text/html");
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setDataHandler(new DataHandler(textDataSource));
            //textPart.setText(text, textPart.getEncoding(), "html");
            multipart.addBodyPart(textPart);

            // Attachements
            DataSource coverDataSource = new ByteArrayDataSource(coverLetter, "application/pdf");
            MimeBodyPart coverPdfBodyPart = new MimeBodyPart();
            coverPdfBodyPart.setDataHandler(new DataHandler(coverDataSource));
            coverPdfBodyPart.setFileName("coverLetter.pdf");
            multipart.addBodyPart(coverPdfBodyPart);

            DataSource cvDataSource = new ByteArrayDataSource(cv, "application/pdf");
            MimeBodyPart cvPdfBodyPart = new MimeBodyPart();
            cvPdfBodyPart.setDataHandler(new DataHandler(cvDataSource));
            cvPdfBodyPart.setFileName("cv.pdf");
            multipart.addBodyPart(cvPdfBodyPart);

            int i = 1;
            for (byte[] doc : documents) {
                DataSource docDataSource = new ByteArrayDataSource(doc, "application/pdf");
                MimeBodyPart docPdfBodyPart = new MimeBodyPart();
                docPdfBodyPart.setDataHandler(new DataHandler(docDataSource));
                docPdfBodyPart.setFileName("doc"+i+".pdf");
                multipart.addBodyPart(docPdfBodyPart);
                i++;
            }

            // Add multipart as message content
            message.setContent(multipart);
            message.setSentDate(new Date());

            //
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Asynchronous
    public void sendMail(User u, JobApplication jobApplication, JobOffer jOffer, byte[][] documents) {
        String contact = jOffer.getContactName();
        String contactEmail = jOffer.getContactEmail();
        String subject = jOffer.getPosition() + "(" + jOffer.getReference() + ")";
        String message = jobApplication.getEmailText();
        sendMail(u.getEmail(), contactEmail, subject, message, jobApplication.getCoverLetterImage(), jobApplication.getResumeeImage(), documents);      
    }

}
