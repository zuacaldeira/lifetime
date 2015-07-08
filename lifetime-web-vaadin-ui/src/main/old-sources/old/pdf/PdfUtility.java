/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Chapter;
import static com.itextpdf.text.Chunk.NEWLINE;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.vaadin.server.StreamResource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.business.persistence.Academic;
import lifetime.business.persistence.Certification;
import lifetime.business.persistence.Linguistic;
import lifetime.business.persistence.Professional;
import lifetime.business.persistence.Entrepeneurship;
import lifetime.business.persistence.Social;
import lifetime.business.persistence.Other;
import lifetime.business.persistence.User;
import old.util.ServiceLocator;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import lifetime.business.persistence.Achievement;
import lifetime.business.persistence.Certificate;
import old.util.Translator;
import old.util.AchievementComparator;

/**
 *
 * @author azc
 */
public class PdfUtility {

    private final String username;
    private final List<Achievement> achievements;
    public static final LineSeparator LINE_SEPARATOR = new LineSeparator();
    private final String language;
    private ByteArrayOutputStream baos;
    private final Integer userId;
    private final String SPACE = " ";
    private final String filename;
    private final User user;
    private Date endDate;
    private Date startDate;
    private AchievementComparator comparator;

    public PdfUtility(Integer userId, String language, AchievementComparator comparator, Date startDate, Date endDate) {
        this.language = language;
        this.userId = userId;
        user = ServiceLocator.findLifetimeService().getUser(userId);
        this.comparator = comparator;
        this.startDate = startDate;
        this.endDate = endDate;
        filename = user.getLastname() + ".pdf";
        this.username = user.getUsername();
        this.achievements = new LinkedList<>();
        baos = new ByteArrayOutputStream();
        LINE_SEPARATOR.setOffset(-5f);
    }

    public void createPdf() {
        Logger.getLogger(PdfUtility.class.getName()).log(Level.INFO, "Creating pdf...");
        Document document = new Document();
        try {
            document.setPageSize(PageSize.A4);
            document.setMargins(62, 48, 36, 36);
            baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            document.open();
            addTitle(document);
            addData(document);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PdfUtility.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            document.close();
        }
    }

    private Paragraph getSectionTitle(String title) {
        Paragraph result = new Paragraph(title, LifetimeFonts.FONT_DEFAULT);
        result.add(LINE_SEPARATOR);
        result.add(NEWLINE);
        // result.add(NEWLINE);
        return result;
    }

    public StreamResource getStreamResource() {
        return new StreamResource(new StreamResource.StreamSource() {
            @Override
            public InputStream getStream() {
                // Here we return the pdf contents as a byte-array
                return new ByteArrayInputStream(baos.toByteArray());
            }
        }, filename);
    }

    private void addTitle(Document document) {
        try {
            // Create a phrase
            Phrase namePhrase = new TitlePhrase(getFullname(), LifetimeFonts.FONT_HEADER);
            Phrase emailPhrase = new TitlePhrase(user.getEmail(), LifetimeFonts.FONT_DEFAULT);
            // Wrap it into a centered paragraph
            Paragraph title = new Paragraph();
            title.setAlignment(Element.ALIGN_CENTER);
            title.add(namePhrase);
            title.add(NEWLINE);
            title.add(emailPhrase);
            if (user.getBirthdate() != null) {
                title.add(NEWLINE);
                title.add(new TitlePhrase(formatDate(user.getBirthdate()), LifetimeFonts.FONT_DEFAULT));
            }
            if (user.getBirthplace() != null) {
                title.add(NEWLINE);
                title.add(new TitlePhrase(user.getBirthplace(), LifetimeFonts.FONT_DEFAULT));
            }
            // return the paragraph to be added into de document
            document.add(title);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getTranslation(String word, String language) {
        return Translator.getTranslation(word, language);
    }

    private String getFullname() {
        return user.getFirstname() + " " + user.getLastname();
    }

    private String formatDate(Date date) {
        Locale l = new Locale(language);
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, l);
        return df.format(date);
    }

    private void addData(Document document) {
        List<? extends Achievement> allData = ServiceLocator.findLifetimeService().getAchievements(userId, language);
        Collections.sort(allData, comparator);

        Chapter info = new Chapter(getSectionTitle(getTranslation("Achievements", language)), 0);
        info.setNumberDepth(0);
        info.setTriggerNewPage(false);

        boolean first = true;
        for (Achievement a : allData) {
            if (isInRange(a)) {
                achievements.add(a);
                Paragraph current = addTableEntry(a);
                if (first) {
                    current.setSpacingBefore(5f);
                }
                info.addSection(current, 0);
            }
        }
        //info.add(Chunk.NEWLINE);
        try {
            document.add(info);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Paragraph addTableEntry(Achievement a) {
        PdfPTable mainTable = new PdfPTable(new float[]{1f, 5f});
        mainTable.setWidthPercentage(100f);
        mainTable.setSpacingBefore(0f);
        mainTable.setSpacingAfter(0f);

        PdfPCell datesCell = getDateCell(a);
        PdfPCell summaryCell = getSummaryCell(a);
        mainTable.addCell(datesCell);
        mainTable.addCell(summaryCell);

        Paragraph current = new Paragraph();
        current.setAlignment(Paragraph.ALIGN_LEFT);
        //current.setSpacingBefore(10f);
        current.add(mainTable);
        return current;
    }

    private PdfPCell getDateCell(Achievement a) {
        DatePhrase dates = new DatePhrase(a.getStart(), a.getEnd(), a.getLanguage());
        PdfPCell datesCell = new PdfPCell(dates);
        datesCell.setBorder(PdfPCell.NO_BORDER);

        return datesCell;
    }

    private PdfPCell getSummaryCell(Achievement a) {
        PdfPCell summaryCell = new PdfPCell();
        summaryCell.setBorder(PdfPCell.NO_BORDER);

        Phrase summaryPhrase = null;
        if (a instanceof Academic) {
            Academic aux = (Academic) a;
            summaryPhrase = new SummaryPhrase(aux);
        } else if (a instanceof Professional) {
            Professional aux = (Professional) a;
            summaryPhrase = new SummaryPhrase(aux);
        } else if (a instanceof Certification) {
            Certification aux = (Certification) a;
            summaryPhrase = new SummaryPhrase(aux);
        } else if (a instanceof Linguistic) {
            Linguistic aux = (Linguistic) a;
            summaryPhrase = new SummaryPhrase(aux);
        } else if (a instanceof Entrepeneurship) {
            Entrepeneurship aux = (Entrepeneurship) a;
            summaryPhrase = new SummaryPhrase(aux);
        } else if (a instanceof Social) {
            Social aux = (Social) a;
            summaryPhrase = new SummaryPhrase(aux);
        } else if (a instanceof Other) {
            Other aux = (Other) a;
            summaryPhrase = new SummaryPhrase(aux);
        }
        summaryCell.setPhrase(summaryPhrase);

        return summaryCell;
    }

    private boolean isInRange(Achievement a) {
        return isAfterMin(a.getStart()) && isBeforeMax(a.getEnd());
    }

    private boolean isAfterMin(Date start) {
        if(start == null && startDate == null) {
            return true;
        }
        
        else if(start == null && startDate != null) {
            return false;
        }
        
        else if(start != null && startDate == null) {
            return true;
        }
        else {
            return start.compareTo(startDate) >= 0;
        }
    }

    private boolean isBeforeMax(Date end) {
        if(end == null && endDate == null) {
            return true;
        }
        
        else if(end == null && endDate != null) {
            return false;
        }
        
        else if(end != null && endDate == null) {
            return true;
        }
        else {
            return end.compareTo(endDate) <= 0;
        }
    }

    public byte[] getBytes() {
        return baos.toByteArray();
    }

    public byte[][] getDocuments() {
        List<byte[]> documents = new LinkedList();
        for(Achievement a: achievements) {
            List<Certificate> certificates = ServiceLocator.findLifetimeService().getCertificates(a.getId());
            for(Certificate c: certificates) {
                if(c.getImage() != null) {
                    documents.add(c.getImage());
                }
            }
        }
        
        byte[][] result = new byte[documents.size()][];
        int i = 0;
        for(byte[] doc: documents) {
            result[i] = doc;
            i++;
        }
        return result;
    }
}
