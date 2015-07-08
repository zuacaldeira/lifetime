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
package old.ui.wizard;

import com.vaadin.data.Property;
import com.vaadin.ui.Component;
import old.pdf.CoverLetterUtility;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import lifetime.business.persistence.CoverLetter;
import lifetime.business.persistence.JobOffer;
import old.ui.combo.CoverLetterComboBox;

/**
 *
 * @author lifetime
 */
public class CreateLetterStep extends LifetimeWizardStep implements Property.ValueChangeListener {

    private final JobOffer jobOffer;
    private CoverLetterUtility cUtility;
    private CoverLetterComboBox coverLetterComboBox;
    private PdfLayout pdfView;

    public CreateLetterStep(Integer userId, String language, JobOffer jobOffer) {
        super(userId, language);
        this.jobOffer = jobOffer;
    }

    @Override
    public String getCaption() {
        return "Cover Letter";
    }

    @Override
    public Component getContent() {
        coverLetterComboBox = new CoverLetterComboBox(getLanguage());
        coverLetterComboBox.addValueChangeListener(this);
        pdfView = new PdfLayout(getUserId(), getLanguage());
        HorizontalLayout view = new HorizontalLayout(coverLetterComboBox, pdfView);
        view.setSpacing(true);
        view.setMargin(true);
        view.setSizeFull();
        return view;
    }

    @Override
    public boolean onAdvance() {
        return true;
    }

    @Override
    public boolean onBack() {
        return true;
    }

    public byte[] getBytes() {
        return cUtility.getBytes();
    }

    public CoverLetter getCoverLetter() {
        return coverLetterComboBox.getValue();
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        String s = "Property Type: " + event.getProperty().getType() + "\nProperty Value:" + event.getProperty().getValue();
        Notification.show("Value Change Event", s, Notification.Type.HUMANIZED_MESSAGE);
        if (coverLetterComboBox.getValue() != null) {
            CoverLetter letter = coverLetterComboBox.getValue();
            if(cUtility == null) {
                cUtility = new CoverLetterUtility(getUserId(), getLanguage(), jobOffer, letter);
            }
            else {
                cUtility.setLetter(letter);
            }
            cUtility.createPdf();
            pdfView.addPdf(cUtility.getBytes());
        }
    }

}
