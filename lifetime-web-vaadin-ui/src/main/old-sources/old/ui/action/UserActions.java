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
package old.ui.action;

import old.ui.button.CollapseButton;
import old.ui.button.ShowCertificatesButton;
import old.ui.button.ShowAchievementsButton;
import old.ui.button.TranslateButton;
import old.ui.button.ViewCVButton;
import old.ui.button.ExpandButton;
import old.ui.button.AddJobOfferButton;
import old.ui.button.LifetimeButton;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import old.ui.button.AddPhotoButton;
import old.ui.button.CommentButton;
import old.ui.menu.Desk;
import old.ui.button.LifetimeHomeButton;
import old.ui.button.LightsOnOffButton;
import old.ui.button.LogoutButton;
import old.ui.button.LoginButton;
import old.ui.admin.UserManagerButton;
import old.ui.button.AddCoverLetterButton;
import old.ui.button.ViewCoverLettersButton;
import old.ui.button.ViewJobApplicationsButton;
import old.ui.button.ViewJobOfferButton;

/**
 *
 * @author lifetime
 */
public final class UserActions extends HorizontalLayout implements Button.ClickListener {

    private final Integer userId;
    private final String language;
    private boolean collapsed;
    private final LifetimeHomeButton lifetimeHomeButton;
    private final LoginButton userHome;
    private UserManagerButton userManager;
    private LifetimeButton addPhotoButton;
    private final ViewCVButton saveCV;
    private final CommentButton comment;
    private final LightsOnOffButton lightsOn;
    private final LogoutButton logoutButton;
    private final ShowAchievementsButton showAchievemets;
    private final ExpandButton expand;
    private final CollapseButton collapse;
    private final HorizontalActionBar environment;
    private final HorizontalActionBar achievements;
    private final HorizontalActionBar others;
    private final HorizontalActionBar controls;
    private final TranslateButton translate;
    private final ShowCertificatesButton showCertificates;
    private final HorizontalActionBar jobs;
    private final AddJobOfferButton addJobOfferButton;
    private final ViewJobOfferButton viewJobOffersButton;
    private final ViewJobApplicationsButton viewJobApplicationsButton;
    private final AddCoverLetterButton addCoverLetterButton;
    private final ViewCoverLettersButton viewCoverLettersButton;

    public UserActions(final Integer userId, final String language, Desk desk) {
        this.userId = userId;
        this.language = language;

        lifetimeHomeButton = new LifetimeHomeButton(language);
        userHome = new LoginButton(language);
        userManager = new UserManagerButton(userId, language);
        addPhotoButton = new AddPhotoButton(userId, language);
        
        environment = new HorizontalActionBar(userId, language);
        environment.addAction(lifetimeHomeButton);
        environment.addAction(userHome);
        environment.addAction(userManager);
        environment.addAction(addPhotoButton);
        environment.setStyleName("action-bar-environment");

        // Achievement
        showAchievemets = new ShowAchievementsButton(userId, language);
        showCertificates = new ShowCertificatesButton(userId, language);
        saveCV = new ViewCVButton(userId, language);

        achievements = new HorizontalActionBar(userId, language);
        achievements.addAction(showAchievemets);
        achievements.addAction(saveCV);
        achievements.addAction(showCertificates);
        achievements.setStyleName("action-bar-achievement");



        // jobs
        addJobOfferButton = new AddJobOfferButton(userId, language);
        addCoverLetterButton = new AddCoverLetterButton(userId, language);
        viewJobOffersButton = new ViewJobOfferButton(userId, language);
        viewJobApplicationsButton = new ViewJobApplicationsButton(userId, language);
        viewCoverLettersButton = new ViewCoverLettersButton(userId, language);

        jobs = new HorizontalActionBar(userId, language);
        jobs.addAction(addJobOfferButton);
        jobs.addAction(addCoverLetterButton);
        jobs.addAction(viewJobOffersButton);
        jobs.addAction(viewJobApplicationsButton);
        jobs.addAction(viewCoverLettersButton);
        jobs.setStyleName("action-bar-job");
                
        

        // Others
        lightsOn = new LightsOnOffButton(language);
        comment = new CommentButton(userId, language);
        translate = new TranslateButton(userId, language);
        logoutButton = new LogoutButton(userId, language);

        others = new HorizontalActionBar(userId, language);
        others.addAction(lightsOn);
        others.addAction(comment);
        others.addComponent(translate);
        others.addAction(logoutButton);
        others.setStyleName("action-bar-other");

        // Controls
        expand = new ExpandButton(userId, language);
        expand.addClickListener(this);
        expand.setVisible(false);

        collapse = new CollapseButton(userId, language);
        collapse.addClickListener(this);
     
        controls = new HorizontalActionBar(userId, language);
        controls.addAction(expand);
        controls.addAction(collapse);

        //collapse();
        addComponents(environment, achievements, jobs, others, controls);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if (event.getButton() == expand) {
            expand();
            expand.setVisible(false);
            collapse.setVisible(true);
        } else if (event.getButton() == collapse) {
            collapse();
            collapse.setVisible(false);
            expand.setVisible(true);
        }
    }

    private void expand() {
        for (int i = 1; i < environment.getComponentCount(); i++) {
            environment.getComponent(i).setVisible(true);
        }
        for (int i = 1; i < achievements.getComponentCount(); i++) {
            achievements.getComponent(i).setVisible(true);
        }
        for (int i = 1; i < jobs.getComponentCount(); i++) {
            jobs.getComponent(i).setVisible(true);
        }
        for (int i = 1; i < others.getComponentCount(); i++) {
            others.getComponent(i).setVisible(true);
        }
        for (int i = 1; i < controls.getComponentCount(); i++) {
            controls.getComponent(i).setVisible(true);
        }
    }

    private void collapse() {
        for (int i = 1; i < environment.getComponentCount(); i++) {
            environment.getComponent(i).setVisible(false);
        }
        for (int i = 1; i < achievements.getComponentCount(); i++) {
            achievements.getComponent(i).setVisible(false);
        }
        for (int i = 1; i < jobs.getComponentCount(); i++) {
            jobs.getComponent(i).setVisible(false);
        }
        for (int i = 1; i < others.getComponentCount(); i++) {
            others.getComponent(i).setVisible(false);
        }
        for (int i = 1; i < controls.getComponentCount(); i++) {
            controls.getComponent(i).setVisible(false);
        }
    }

}
