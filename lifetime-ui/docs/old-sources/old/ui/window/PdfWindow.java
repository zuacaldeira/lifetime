/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.window;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Window;
import old.ui.button.LifetimeButtonLink;
import java.util.Date;
import old.pdf.PdfUtility;
import old.util.DescendingEndComparator;

/**
 *
 * @author azc
 */
public class PdfWindow extends Window {

    public PdfWindow(Integer userId, String language) {
        setCaption("Save CV");
        setSizeFull();
        setResizable(true);
        setWidth("25%");
        setHeight("25%");
        center();
        PdfUtility pdfUtility = new PdfUtility(userId, language, new DescendingEndComparator(), null, new Date());
        pdfUtility.createPdf();
        StreamResource streamResource = pdfUtility.getStreamResource();
        FileDownloader downloader = new FileDownloader(streamResource);
        LifetimeButtonLink downloadButton = new LifetimeButtonLink("Save CV", FontAwesome.SAVE);
        downloader.extend(downloadButton);
        // Here we create a new StreamResource which downloads our StreamSource,
        // which is our pdf.
        setContent(downloadButton);
    }

}
