/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.tabsheet;

import old.ui.list.AllNotTranslatedAchievementList;
import old.ui.list.AllAchievementList;
import old.ui.list.AcademicList;
import old.ui.list.CertificationList;
import old.ui.list.LinguisticList;
import old.ui.list.ProfessionalList;
import old.ui.list.EntrepeneurshipList;
import old.ui.list.SocialList;
import old.ui.list.OtherList;
import com.vaadin.ui.TabSheet.Tab;
import lifetime.business.persistence.Academic;
import lifetime.business.persistence.Achievement;
import lifetime.business.persistence.Certification;
import lifetime.business.persistence.Entrepeneurship;
import lifetime.business.persistence.Linguistic;
import lifetime.business.persistence.Other;
import lifetime.business.persistence.Professional;
import lifetime.business.persistence.Social;
import old.ui.list.LifetimeList;
import old.util.Translator;

/**
 *
 * @author azc
 */
public class UserTabSheet extends LifetimeTabSheet {

    private LifetimeList<Academic> academicList;
    private LifetimeList<Professional> professionalList;
    private LifetimeList<Certification> certificationList;
    private LifetimeList<Entrepeneurship> entrepeneurshipList;
    private LifetimeList<Social> socialList;
    private LifetimeList<Other> otherList;
    private LifetimeList<Linguistic> linguisticList;
    private LifetimeList<Achievement> overviewList;
    private final Integer userId;
    private final String language;
    private final AllNotTranslatedAchievementList notTranslatedList;

    public UserTabSheet(Integer userId, String language) {
        this.userId = userId;
        this.language = language;
        //
        /**/
        overviewList = new AllAchievementList(userId, language);
        overviewList.setEnabled(false);
        if(overviewList.getSelected() != null) {
            overviewList.getSelected().unselect();
        }

        notTranslatedList = new AllNotTranslatedAchievementList(userId, language);
        notTranslatedList.setEnabled(false);
        if(notTranslatedList.getSelected() != null) {
            notTranslatedList.getSelected().unselect();
        }
        academicList = new AcademicList(userId, language);
        professionalList = new ProfessionalList(userId, language);
        certificationList = new CertificationList(userId, language);
        entrepeneurshipList = new EntrepeneurshipList(userId, language);
        linguisticList = new LinguisticList(userId, language);
        socialList = new SocialList(userId, language);
        otherList = new OtherList(userId, language);
        Tab t = addTab(overviewList, getTranslation("All", language));
        Tab t2 = addTab(notTranslatedList, getTranslation("Need Translation", language));
        addTab(academicList, getTranslation("Academic Degrees", language));
        addTab(professionalList, getTranslation("Professional Experience", language));
        addTab(certificationList, getTranslation("Certification Path", language));
        addTab(entrepeneurshipList, getTranslation("Entrepeneurship", language));
        addTab(linguisticList, getTranslation("Linguistic Skills", language));
        addTab(socialList, getTranslation("Social Engagement", language));
        addTab(otherList, getTranslation("Other", language));
    }

    public LifetimeList getList() {
        return (LifetimeList) getSelectedTab();
    }

    public void update() {
        overviewList.update();
        notTranslatedList.update();
        academicList.update();
        professionalList.update();
        certificationList.update();
        entrepeneurshipList.update();
        linguisticList.update();
        socialList.update();
        otherList.update();
    }

    private String getTranslation(String word, String to) {
        return Translator.getTranslation(word, to);
    }


}
