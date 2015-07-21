/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.helper;

import old.util.ServiceLocator;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import lifetime.business.persistence.Academic;
import lifetime.business.persistence.Achievement;
import lifetime.business.persistence.Certification;
import lifetime.business.persistence.Linguistic;
import lifetime.business.persistence.Professional;
import lifetime.business.persistence.Entrepeneurship;
import lifetime.business.persistence.Social;
import lifetime.business.persistence.Other;

/**
 *
 * @author azc
 * @param <T>
 */
public class TaskView<T extends Achievement> extends HorizontalLayout {

    private final T achievement;
    private int total;
    private int totalNotNull;
    private int totalEquivalenceClass;
    private int totalNotNullEquivalenceClass;

    public TaskView(T achievement) {
        this.achievement = achievement;
        setSizeFull();
        initTotals();

        Label value = new Label(String.valueOf(Math.round((totalNotNull / (double) total) * 100)) + "%");
        value.setStyleName("h1");

        Label valueAll = new Label(String.valueOf(Math.round((totalNotNullEquivalenceClass / (double) totalEquivalenceClass) * 100)) + "%");
        valueAll.setStyleName("h2");

        addComponents(value, valueAll);
    }

    private void initTotals() {
        total = 0;
        totalNotNull = 0;
        totalEquivalenceClass = 0;
        totalNotNullEquivalenceClass = 0;
        if (achievement instanceof Academic) {
            initAcademicTotals();
        }
        if (achievement instanceof Professional) {
            initProfessionalTotals();
        }
        if (achievement instanceof Certification) {
            initCertificationTotals();
        }
        if (achievement instanceof Entrepeneurship) {
            initEntrepeneurshipTotals();
        }
        if (achievement instanceof Social) {
            initSocialTotals();
        }
        if (achievement instanceof Other) {
            initOtherTotals();
        }
        if (achievement instanceof Linguistic) {
            initLinguisticTotals();
        }
    }

    private void initAcademicTotals() {
        Academic original = ((Academic) achievement).getOriginalId();
        if (original == null) {
            original = (Academic) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Academic> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void initProfessionalTotals() {
        Professional original = ((Professional) achievement).getOriginalId();
        if (original == null) {
            original = (Professional) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Professional> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void initCertificationTotals() {
        Certification original = ((Certification) achievement).getOriginalId();
        if (original == null) {
            original = (Certification) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Certification> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void initEntrepeneurshipTotals() {
        Entrepeneurship original = ((Entrepeneurship) achievement).getOriginalId();
        if (original == null) {
            original = (Entrepeneurship) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Entrepeneurship> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void initSocialTotals() {
        Social original = ((Social) achievement).getOriginalId();
        if (original == null) {
            original = (Social) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Social> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void initOtherTotals() {
        Other original = ((Other) achievement).getOriginalId();
        if (original == null) {
            original = (Other) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Other> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void initLinguisticTotals() {
        Linguistic original = ((Linguistic) achievement).getOriginalId();
        if (original == null) {
            original = (Linguistic) achievement;
        }
        updateOriginalTotals(original);
        // get the translations
        totalEquivalenceClass = total;
        totalNotNullEquivalenceClass = totalNotNull;

        List<Linguistic> translations = ServiceLocator.findLifetimeService().getTranslations(original);
        updateTranslationTotals(translations);
        Set<String> missedTranslations = ServiceLocator.findLifetimeService().getNotTranslatedLanguages(original.getUserId(), original);
        totalEquivalenceClass += missedTranslations.size() * total;
    }

    private void updateTranslationTotals(List translations) {
        for (Object translation : translations) {
            for (Method m : translation.getClass().getDeclaredMethods()) {
                try {
                    if (m.getName().startsWith("get")) {
                        totalEquivalenceClass++;
                        if (m.invoke(translation, new Object[]{}) != null) {
                            totalNotNullEquivalenceClass++;
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException ex) {
                    Logger.getLogger(TaskView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void updateOriginalTotals(Object original) {
        for (Method m : original.getClass().getDeclaredMethods()) {
            try {
                if (m.getName().startsWith("get")) {
                    total++;
                    if (m.invoke(original, new Object[]{}) != null) {
                        totalNotNull++;
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(TaskView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
