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
package old.ui.button;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;
import old.pdf.PdfUtility;
import old.util.Translator;
import old.util.DescendingStartComparator;

/**
 *
 * @author lifetime
 */
public class ViewCVButton extends LifetimeButtonLink implements Button.ClickListener {
    private final Integer userId;
    private final String language;

    public ViewCVButton(final Integer userId, final String language) {
        super(Translator.getTranslation("Download CV", language), FontAwesome.FILE_PDF_O);
        addClickListener(this);
        this.userId = userId;
        this.language = language;
        setImmediate(true);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        PdfUtility pdfUtility = new PdfUtility(userId, language, 
                new DescendingStartComparator(), null, null);
        pdfUtility.createPdf();
        StreamResource streamResource = pdfUtility.getStreamResource();
        FileDownloader downloader = new FileDownloader(streamResource);
        downloader.extend(this);
    }

}
