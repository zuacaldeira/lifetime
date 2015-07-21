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
package old.ui.menu;

import com.vaadin.event.FieldEvents;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;
import java.util.HashMap;
import java.util.Map;
import old.ui.action.UserLanguages;
import old.ui.button.AddJobOfferButton;
import old.ui.button.AddPhotoButton;
import old.ui.button.FacebookPostButton;
import old.ui.button.LifetimeButton;
import old.ui.button.LifetimeButtonLink;
import old.ui.button.LightsOnOffButton;
import old.ui.button.LogoutButton;
import old.ui.button.ShowAchievementsButton;
import old.ui.button.ShowCertificatesButton;
import old.ui.button.TranslateButton;
import old.ui.button.ViewCVButton;
import old.ui.button.ViewJobApplicationsButton;
import old.ui.button.ViewJobOfferButton;
import old.ui.button.ViewOrganizationsButton;

/**
 *
 * @author lifetime
 */
public class OldLifetimeMenu extends HorizontalLayout implements ClickListener, FocusListener {

    private Integer userId;
    private String language;
    private LifetimeButton menuButton;
    private UserLanguages languages;
    private LifetimeButton profileButton;
    private LifetimeButton achievementsButton;
    private LifetimeButton jobOffersButton;
    private LifetimeButton jobApplicationsButton;
    private LifetimeButtonLink helpButton;
    private LifetimeButtonLink shareButton;
    private LifetimeButtonLink languageButton;
    private Map<LifetimeButton, VerticalLayout> menu;
    private VerticalLayout profileView;
    private final VerticalLayout achievementView;
    private final VerticalLayout jOfferView;
    private final VerticalLayout jApplicationView;
    private final VerticalLayout socialView;
    private final VerticalLayout helpView;
    private TranslateButton missingTranslationsButton;
    private final VerticalLayout moreView;
    private final VerticalLayout languageView;
    private LogoutButton logoutButton;
    private LightsOnOffButton lightsOnButton;
    private LifetimeButtonLink organizationsButton;
    private final VerticalLayout organizationsView;

    public OldLifetimeMenu(Integer userId, String language) {
        super();
        setWidth("100%");
        this.userId = userId;
        this.language = language;
        //
        menu = new HashMap();
        // 
        // Account
        initProfileOptions();
        initAchievementsOptions();
        initOrganizationsOptions();
        initJobOffersOptions();
        initJobApplicationsOptions();
        initShareOptions();
        initHelpOptions();
        initLanguageOptions();
        initMoreMenuOptions();
        //
        profileView = new VerticalLayout(profileButton, menu.get(profileButton));
        profileView.setStyleName("v-menu");
        // Achievements
        achievementView = new VerticalLayout(achievementsButton, menu.get(achievementsButton));
        achievementView.setStyleName("v-menu");
        // Organizations
        organizationsView = new VerticalLayout(organizationsButton, menu.get(organizationsButton));
        organizationsView.setStyleName("v-menu");
        // Job Offers
        jOfferView = new VerticalLayout(jobOffersButton, menu.get(jobOffersButton));
        jOfferView.setStyleName("v-menu");
        // Job Applications
        jApplicationView = new VerticalLayout(jobApplicationsButton, menu.get(jobApplicationsButton));
        jApplicationView.setStyleName("v-menu");
        // Social
        socialView = new VerticalLayout(shareButton, menu.get(shareButton));
        socialView.setStyleName("v-menu");
        // Documentation
        helpView = new VerticalLayout(helpButton, menu.get(helpButton));
        helpView.setStyleName("v-menu");

        languageView = new VerticalLayout(languageButton, menu.get(languageButton));
        languageView.setStyleName("v-menu");

        moreView = new VerticalLayout(menuButton, menu.get(menuButton));
        moreView.setStyleName("v-menu");

        // Packibg Body
        // secondary.setVisible(false);
        //
        addComponents(profileView, achievementView, organizationsView,
                jOfferView, jApplicationView, socialView, helpView, languageView, moreView);
        profileView.setComponentAlignment(profileButton, Alignment.TOP_CENTER);
        achievementView.setComponentAlignment(achievementsButton, Alignment.TOP_CENTER);
        organizationsView.setComponentAlignment(organizationsButton, Alignment.TOP_CENTER);
        jOfferView.setComponentAlignment(jobOffersButton, Alignment.TOP_CENTER);
        jApplicationView.setComponentAlignment(jobApplicationsButton, Alignment.TOP_CENTER);
        socialView.setComponentAlignment(shareButton, Alignment.TOP_CENTER);
        helpView.setComponentAlignment(helpButton, Alignment.TOP_CENTER);
        languageView.setComponentAlignment(languageButton, Alignment.TOP_CENTER);
        moreView.setComponentAlignment(menuButton, Alignment.TOP_CENTER);
        setStyleName("M-menu");
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }

    private void initProfileOptions() {
        profileButton = new LifetimeButtonLink("Account", FontAwesome.USER);
        profileButton.addClickListener(this);
        profileButton.addFocusListener(this);
        AddPhotoButton addPhotoButton = new AddPhotoButton(userId, language);

        VerticalLayout options = new VerticalLayout();
        options.setStyleName("v-menu-options");
        options.addComponent(addPhotoButton);
        options.setComponentAlignment(addPhotoButton, Alignment.MIDDLE_CENTER);
        menu.put(profileButton, options);
        //secondary.addComponent(profileOptions);
    }

    private void initAchievementsOptions() {
        achievementsButton = new LifetimeButtonLink("Achievements", FontAwesome.TROPHY);
        achievementsButton.addClickListener(this);
        achievementsButton.addFocusListener(this);

        ShowAchievementsButton showAchievements = new ShowAchievementsButton(userId, language);
        ViewCVButton cvButton = new ViewCVButton(userId, language);
        ShowCertificatesButton certsButton = new ShowCertificatesButton(userId, language);

        VerticalLayout options = new VerticalLayout();
        options.setStyleName("v-menu-options");
        options.addComponent(showAchievements);
        options.addComponent(cvButton);
        options.addComponent(certsButton);
        menu.put(achievementsButton, options);
        //secondary.addComponent(achievementOptions);
    }

    private void initJobOffersOptions() {
        jobOffersButton = new LifetimeButtonLink("Job Offers", FontAwesome.SUITCASE);
        jobOffersButton.addClickListener(this);
        jobOffersButton.addFocusListener(this);

        ViewJobOfferButton viewJobOffersButton = new ViewJobOfferButton(userId, language);
        AddJobOfferButton addJobOfferButton = new AddJobOfferButton(userId, language);
        VerticalLayout options = new VerticalLayout(viewJobOffersButton, addJobOfferButton);
        options.setStyleName("v-menu-options");
        menu.put(jobOffersButton, options);
    }

    private void initJobApplicationsOptions() {
        jobApplicationsButton = new LifetimeButtonLink("Job Applications", FontAwesome.ARCHIVE);
        jobApplicationsButton.addClickListener(this);
        jobApplicationsButton.addFocusListener(this);

        ViewJobApplicationsButton viewJobApplicationButton = new ViewJobApplicationsButton(userId, language);
        VerticalLayout options = new VerticalLayout();
        options.setStyleName("v-menu-options");
        options.addComponent(viewJobApplicationButton);
        menu.put(jobApplicationsButton, options);
    }

    private void initOrganizationsOptions() {
        organizationsButton = new LifetimeButtonLink("Organizations", FontAwesome.BUILDING);
        organizationsButton.addClickListener(this);
        organizationsButton.addFocusListener(this);

        ViewOrganizationsButton viewOrganizationsButton = new ViewOrganizationsButton(userId, language);
        VerticalLayout options = new VerticalLayout();
        options.setStyleName("v-menu-options");
        options.addComponent(viewOrganizationsButton);
        menu.put(organizationsButton, options);
    }

    private void initShareOptions() {
        shareButton = new LifetimeButtonLink("Share", FontAwesome.SHARE);
        shareButton.addClickListener(this);
        shareButton.addFocusListener(this);
        FacebookPostButton facebookPostButton = new FacebookPostButton(userId, language);
        VerticalLayout options = new VerticalLayout();
        options.setStyleName("v-menu-options");
        options.addComponent(facebookPostButton);
        menu.put(shareButton, options);
    }

    private void initHelpOptions() {
        helpButton = new LifetimeButtonLink("Help", FontAwesome.QUESTION);
        helpButton.addClickListener(this);
        helpButton.addFocusListener(this);
        VerticalLayout options = new VerticalLayout();
        options.setStyleName("v-menu-options");
        menu.put(helpButton, options);
    }

    private void initLanguageOptions() {
        languageButton = new LifetimeButtonLink("Languages", FontAwesome.FLAG);
        languageButton.addClickListener(this);
        languageButton.addFocusListener(this);
        missingTranslationsButton = new TranslateButton(userId, language);
        missingTranslationsButton.addClickListener(this);
        missingTranslationsButton.addFocusListener(this);
        languages = new UserLanguages(userId, language);
        VerticalLayout options = new VerticalLayout(missingTranslationsButton, languages);
        options.setStyleName("v-menu-options");
        menu.put(languageButton, options);
    }

    private void initMoreMenuOptions() {
        menuButton = new LifetimeButtonLink("More", FontAwesome.NAVICON);
        menuButton.addClickListener(this);
        logoutButton = new LogoutButton(userId, language);
        lightsOnButton = new LightsOnOffButton(language);
        VerticalLayout options = new VerticalLayout(logoutButton, lightsOnButton);
        options.setStyleName("v-menu-options");
        menu.put(menuButton, options);
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        Notification.show("Menu VISIBLE");
    }

    @Override
    public void focus(FieldEvents.FocusEvent event) {
        Notification.show("Focus", Type.HUMANIZED_MESSAGE);
    }

}
