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

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import lifetime.business.persistence.JobOffer;
import old.ui.window.LifetimeWindow;
import old.util.ServiceLocator;

/**
 *
 * @author lifetime
 */
public class DeleteButton extends LifetimeButtonLink implements ClickListener {

    private final JobOffer job;

    public DeleteButton(Integer userId, String language, JobOffer job) {
        super(userId, language, "Delete job", FontAwesome.TRASH_O);
        this.job = job;
        addClickListener(this);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        final LifetimeWindow window = new LifetimeWindow(getUserId(), job.getLanguage(), "Delete job offer");
        OKButton ok = new OKButton(getUserId(), getLanguage());
        ok.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                ServiceLocator.findLifetimeService().delete(job);
                if(getData() instanceof Object[]) {
                    Object[] oo = (Object[])getData();
                    //((JobOfferListV2)oo[0]).removeComponent((ItemView<JobOffer>)oo[1]);
                }
                window.close();
            }
        });
        CancelButton cancel = new CancelButton(getUserId(), getLanguage());
        cancel.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                window.close();
            }
        });
        HorizontalLayout controls = new HorizontalLayout(ok, cancel);
        controls.setSpacing(true);
        window.setContent(controls);
        getUI().addWindow(window);
    }

}
