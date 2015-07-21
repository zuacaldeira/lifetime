/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import old.ui.button.LifetimeButtonLink;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 *
 * @author azc
 */
public abstract class AchievementFormTranslate<T> extends Panel implements Button.ClickListener {

    private final LifetimeForm<T> original;
    private final LifetimeForm<T> translation;
    private HorizontalLayout main;
    private final LifetimeButtonLink cancel;
    private final LifetimeButtonLink translate;

    public AchievementFormTranslate(LifetimeForm<T> original, LifetimeForm<T> translation) {
        this.original = original;
        this.translation = translation;
        setUpOriginalForm();
        setUpTranslation();
        setSizeFull();
        initBase();
        cancel = new LifetimeButtonLink("Cancel", FontAwesome.TIMES);
        translate = new LifetimeButtonLink("Translate", FontAwesome.LANGUAGE);
        cancel.addClickListener(this);
        translate.addClickListener(this);
        VerticalLayout base = new VerticalLayout(main, new HorizontalLayout(cancel, translate));
        setContent(base);
    }

    private void initBase() {
        main = new HorizontalLayout(original, translation);
        main.setSpacing(true);
    }

    private void setUpOriginalForm() {
        //original.setEnabled(false);
        original.getStart().setVisible(false);
        original.getEnd().setVisible(false);
        //original.getStatus().setVisible(false);
        original.getControls().setVisible(false);
    }

    private void setUpTranslation() {
        translation.getStart().setVisible(false);
        translation.getEnd().setVisible(false);
        //translation.getStatus().setVisible(false);
        translation.getControls().setVisible(false);
    }

    public LifetimeForm<T> getOriginal() {
        return original;
    }

    public LifetimeForm<T> getTranslation() {
        return translation;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if (event.getButton() == cancel) {
            closeWindow();
        } else if (event.getButton() == translate) {
            getTranslation().fillItem();
            commitData();
            getOriginal().getList().update();
            closeWindow();
        }
    }

    protected void closeWindow() {
        Window w = getWindow();
        w.close();
    }

    public Window getWindow() {
        HasComponents hc = getParent();
        while (hc != null && !(hc instanceof UI)) {
            if (hc instanceof Window) {
                return (Window) hc;
            }
            hc = hc.getParent();
        }
        return null;
    }

    protected abstract void commitData();

}
