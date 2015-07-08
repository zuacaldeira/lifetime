/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.Phrase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author azc
 */
public class DatePhrase extends Phrase {

    private final Date start;
    private final Date end;
    private SimpleDateFormat df;

    public DatePhrase(Date start, Date end, String language) {
        super();
        this.df = new SimpleDateFormat("MMMM yyyy", new Locale(language));
        this.start = start;
        this.end = end;
        setFont(LifetimeFonts.FONT_DATE);
        add(getPhraseString(start, end));
    }

    private String getPhraseString(Date start, Date end) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (start != null) {
            builder.append(df.format(start));
        } else {
            builder.append("s");
        }

        builder.append(" - ");

        if (end != null) {
            builder.append(df.format(end));
        } else {
            builder.append("u");
        }
        builder.append("]");
        return builder.toString();
    }

}
