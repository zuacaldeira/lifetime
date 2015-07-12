/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

/**
 *
 * @author azc
 */
public class LifetimeFonts {

    public static final Font FONT_DEFAULT = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.NORMAL);
    public static final Font FONT_BOLD = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.BOLD);
    public static final Font FONT_ITALIC = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC);

    public static final Font FONT_HEADER = FontFactory.getFont(FontFactory.TIMES_ROMAN, 24, Font.BOLD);
    public static final Font FONT_KEY = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD, BaseColor.RED);
    public static final Font FONT_DATE = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.BOLD, BaseColor.LIGHT_GRAY);
    public static final Font FONT_TOOLS = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.GREEN);
    public static final Font FONT_GRADE = FontFactory.getFont(FontFactory.COURIER, 11, Font.NORMAL, BaseColor.RED);
    public static final Font FONT_ORG = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.ITALIC, BaseColor.DARK_GRAY);
    public static final Font FONT_URL = FONT_ITALIC;
    public static final Font FONT_PAUSED = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.LIGHT_GRAY);
    public static final Font FONT_CREATED = FONT_DEFAULT;
    public static final Font FONT_STARTED = FONT_DEFAULT;
    public static final Font FONT_RUNNING = FONT_DEFAULT;
    public static final Font FONT_FINISHED = FONT_DEFAULT;

}
