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
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import old.pdf.PdfUtility;
import old.ui.form.CVConfigForm;
import old.ui.user.CVType;
import old.util.AscendingEndComparator;
import old.util.AscendingStartComparator;
import old.util.DescendingEndComparator;
import old.util.DescendingStartComparator;

/**
 *
 * @author lifetime
 */
public class CVStep extends LifetimeWizardStep implements ValueChangeListener {

    private CVConfigForm cvConfigForm;
    private PdfLayout pdfLayout;
    private PdfUtility pdfUtility;

    public CVStep(Integer userId, String language) {
        super(userId, language);
    }

    @Override
    public String getCaption() {
        return "Configure CV output";
    }

    @Override
    public Component getContent() {
        if (cvConfigForm == null) {
            cvConfigForm = new CVConfigForm(getUserId(), getLanguage());
            cvConfigForm.getCvType().addValueChangeListener(this);
            cvConfigForm.getStartDate().addValueChangeListener(this);
            cvConfigForm.getEndDate().addValueChangeListener(this);
        }
        if (pdfUtility == null) {

            pdfUtility = new PdfUtility(getUserId(), getLanguage(),
                    cvConfigForm.getComparator(),
                    cvConfigForm.getStartDate().getValue(),
                    cvConfigForm.getEndDate().getValue());

            pdfUtility.createPdf();
        }
        if (pdfLayout == null) {
            pdfLayout = new PdfLayout(getUserId(), getLanguage());
            pdfLayout.addPdf(pdfUtility.getBytes());
        }
        HorizontalLayout view = new HorizontalLayout(cvConfigForm, pdfLayout);
        view.setSpacing(true);
        view.setMargin(true);
        view.setSizeFull();

        return view;
    }

    @Override
    public boolean onAdvance() {
        return true;
    }

    public byte[] getBytes() {
        return pdfUtility.getBytes();
    }

    public byte[][] getDocuments() {
        return pdfUtility.getDocuments();
    }

    @Override
    public boolean onBack() {
        return true;
    }

    @Override
    public void valueChange(Property.ValueChangeEvent event) {
        String s = "Property Type: " + event.getProperty().getType() + "\nProperty Value:" + event.getProperty().getValue();
        Notification.show("Value Change Event", s, Notification.Type.ERROR_MESSAGE);

        if (cvConfigForm.getCvType().getValue().equals(CVType.CHRONO_ASCENDING_END)) {
            cvConfigForm.setComparator(new AscendingEndComparator());
        } else if (cvConfigForm.getCvType().getValue().equals(CVType.CHRONO_ASCENDING_START)) {
            cvConfigForm.setComparator(new AscendingStartComparator());
        } else if (cvConfigForm.getCvType().getValue().equals(CVType.CHRONO_DESCENDING_END)) {
            cvConfigForm.setComparator(new DescendingEndComparator());
        } else if (cvConfigForm.getCvType().getValue().equals(CVType.CHRONO_DESCENDING_START)) {
            cvConfigForm.setComparator(new DescendingStartComparator());
        }

        pdfUtility = new PdfUtility(getUserId(), getLanguage(),
                cvConfigForm.getComparator(),
                cvConfigForm.getStartDate().getValue(),
                cvConfigForm.getEndDate().getValue());

        pdfUtility.createPdf();
        pdfLayout.addPdf(pdfUtility.getBytes());

    }

}
