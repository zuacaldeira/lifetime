/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Chapter;
import static com.itextpdf.text.Chunk.NEWLINE;
import com.itextpdf.text.Paragraph;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lifetime.business.persistence.Academic;
import lifetime.business.util.AchievementStatus;

/**
 *
 * @author azc
 */
public class AcademicSection extends Chapter {
    private final List<Academic> achievements;

    public AcademicSection(List<Academic> achievements) {
        super("Academic", 0);
        this.achievements = achievements;
        setNumberDepth(0);
        setTriggerNewPage(false);
        System.out.println("Will iterate over " + achievements.size() + " entries");
        for (Academic achievement : achievements) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 1986);
            Date d86 = cal.getTime();
            if (achievement.getStart().after(d86)) {
                if (AchievementStatus.FINISHED.name().equals(achievement.getStatus())) {
                    addSection(new AcademicParagraph(achievement), 0);
                }
            }
        }
    }

    private static Paragraph getSectionTitle(String title) {
        Paragraph result = new Paragraph(title, LifetimeFonts.FONT_DEFAULT);
        result.add(PdfUtility.LINE_SEPARATOR);
        result.add(NEWLINE);
        result.add(NEWLINE);
        return result;
    }

}
