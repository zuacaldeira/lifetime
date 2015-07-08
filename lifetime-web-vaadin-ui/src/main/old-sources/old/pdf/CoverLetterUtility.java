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
package old.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.vaadin.server.StreamResource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.business.persistence.CoverLetter;
import lifetime.business.persistence.JobOffer;
import lifetime.business.persistence.User;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class CoverLetterUtility {

    private final String language;
    private final Integer userId;
    private ByteArrayOutputStream baos;
    private final JobOffer jobOffer;
    private CoverLetter letter;

    public CoverLetterUtility(Integer userId, String language, JobOffer jobOffer, CoverLetter letter) {
        this.language = language;
        this.userId = userId;
        this.jobOffer = jobOffer;
        this.letter = letter;
    }

    public void createPdf() {
        System.out.println("Creating cover letter...");
        Document document = new Document();
        document.setPageSize(PageSize.A4);
        document.setMargins(62, 48, 36, 36);
        baos = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(document, baos);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        document.open();
        document.addAuthor("vitaelifetime@gmail.com");
        document.addCreationDate();

        addTitle(document);
        addReference(document);
        addSalutation(document);
        addIntroduction(document);
        addWhyMe(document);
        addWhyYou(document);
        addConclusion(document);
        document.close();
    }

    private void addTitle(Document document) {
        Paragraph titleParagraph = new Paragraph();
        titleParagraph.setAlignment(Paragraph.ALIGN_CENTER);

        TitlePhrase name = new TitlePhrase(getUserFullname(), LifetimeFonts.FONT_HEADER);
        TitlePhrase email = new TitlePhrase(getUserEmail(), LifetimeFonts.FONT_KEY);

        titleParagraph.add(name);
        titleParagraph.add(Chunk.NEWLINE);
        titleParagraph.add(email);
        titleParagraph.add(Chunk.NEWLINE);
        try {
            document.add(titleParagraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addReference(Document document) {
        ValuePhrase position = new ValuePhrase("Position:" + jobOffer.getPosition(), LifetimeFonts.FONT_ORG);
        ValuePhrase reference = new ValuePhrase("Reference:" + jobOffer.getReference(), LifetimeFonts.FONT_DEFAULT);

        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Paragraph.ALIGN_RIGHT);
        //current.setSpacingBefore(10f);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(position);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(reference);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        try {
            document.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addIntroduction(Document document) {
        TitlePhrase introTitle = new TitlePhrase("Introduction", LifetimeFonts.FONT_BOLD);
        ValuePhrase introduction = new ValuePhrase(letter.getIntroduction(), LifetimeFonts.FONT_DEFAULT);

        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        //current.setSpacingBefore(10f);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(introTitle);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(introduction);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        try {
            document.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addSalutation(Document document) {
        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        //current.setSpacingBefore(10f);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(new ValuePhrase("Dear " + jobOffer.getContactTitle() + " " + jobOffer.getContactName()));
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        try {
            document.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addWhyMe(Document document) {
        TitlePhrase title = new TitlePhrase("Why Me", LifetimeFonts.FONT_BOLD);
        ValuePhrase text = new ValuePhrase(letter.getWhyMe(), LifetimeFonts.FONT_DEFAULT);

        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        //current.setSpacingBefore(10f);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(title);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(text);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        try {
            document.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addWhyYou(Document document) {
        TitlePhrase title = new TitlePhrase("Why You", LifetimeFonts.FONT_BOLD);
        ValuePhrase text = new ValuePhrase(letter.getWhyYou(), LifetimeFonts.FONT_DEFAULT);

        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        //current.setSpacingBefore(10f);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(title);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(text);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        try {
            document.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addConclusion(Document document) {
        TitlePhrase title = new TitlePhrase("Conclusion", LifetimeFonts.FONT_BOLD);
        ValuePhrase text = new ValuePhrase(letter.getConclusion(), LifetimeFonts.FONT_DEFAULT);

        Paragraph paragraph = new Paragraph();
        paragraph.setAlignment(Paragraph.ALIGN_JUSTIFIED);
        //current.setSpacingBefore(10f);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(title);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(text);
        paragraph.add(Chunk.NEWLINE);
        paragraph.add(Chunk.NEWLINE);
        try {
            document.add(paragraph);
        } catch (DocumentException ex) {
            Logger.getLogger(CoverLetterUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getUserFullname() {
        User u = ServiceLocator.findLifetimeService().getUser(userId);
        return u.getFirstname() + " " + u.getLastname();
    }

    private String getUserEmail() {
        User u = ServiceLocator.findLifetimeService().getUser(userId);
        return u.getEmail();
    }

    public StreamResource getStreamResource() {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                // Here we return the pdf contents as a byte-array
                return new ByteArrayInputStream(baos.toByteArray());
            }
        }, "coverLetter_" + userId + "_" + language + ".pdf");
    }

    public byte[] getBytes() {
        return baos.toByteArray();
    }

    public void setLetter(CoverLetter value) {
        this.letter = value;
    }

}
