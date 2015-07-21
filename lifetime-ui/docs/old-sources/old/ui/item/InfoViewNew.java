/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import old.ui.button.LifetimeButton;
import old.ui.button.LifetimeButtonSmall;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import ui.LifetimeUI;
import old.ui.user.UserUI;
import old.ui.visitor.VisitorUI;

/**
 *
 * @author azc
 * @param <T> A system wide recognizable achievement.
 */
public abstract class InfoViewNew<T> extends VerticalLayout implements Button.ClickListener {

    private InfoTitle title;
    private InfoBody body;
    private InfoActions actions;
    private LifetimeButton edit;
    private LifetimeButton delete;
    private LifetimeButton hide;
    private LifetimeButton translate;
    private LifetimeButton participate;

    private final T achievement;

    public InfoViewNew(T achievement) {
        setSizeFull();
        setMargin(true);
        setMargin(new MarginInfo(false, true, false, true));
        this.achievement = achievement;
        this.title = new InfoTitle();
        this.body = new InfoBody();
        addComponents(title, body);

        actions = new InfoActions();
        if ((this.getMyUI()instanceof UserUI) && !(this.getMyUI()instanceof VisitorUI)) {
            edit = new LifetimeButtonSmall("edit", FontAwesome.EDIT);
            delete = new LifetimeButtonSmall("delete", FontAwesome.TRASH_O);
            hide = new LifetimeButtonSmall("hide", FontAwesome.EYE);
            translate = new LifetimeButtonSmall("translate", FontAwesome.FLAG);
            participate = new LifetimeButtonSmall("e-participate", FontAwesome.FLAG);
            edit.addClickListener(this);
            delete.addClickListener(this);
            hide.addClickListener(this);
            translate.addClickListener(this);
            participate.addClickListener(this);
            actions.addComponents(edit, delete, hide, translate, participate);
            addComponent(actions);
            actions.setEnabled(false);
        }
        setStyleName("info");
    }

    public InfoTitle getTitle() {
        return title;
    }

    public void setTitle(InfoTitle title) {
        this.title = title;
    }

    public InfoBody getBody() {
        return body;
    }

    public void setBody(InfoBody body) {
        this.body = body;
    }

    public InfoActions getActions() {
        return actions;
    }

    public void setActions(InfoActions actions) {
        this.actions = actions;
    }

    public LifetimeButton getEdit() {
        return edit;
    }

    public LifetimeButton getDelete() {
        return delete;
    }

    public LifetimeButton getHide() {
        return hide;
    }

    public LifetimeButton getTranslate() {
        return translate;
    }

    public LifetimeButton getParticipate() {
        return participate;
    }

    public void setEdit(LifetimeButton edit) {
        this.edit = edit;
    }

    public void setDelete(LifetimeButton delete) {
        this.delete = delete;
    }

    public void setHide(LifetimeButton hide) {
        this.hide = hide;
    }

    public void setTranslate(LifetimeButton translate) {
        this.translate = translate;
    }

    public void setParticipate(LifetimeButton participate) {
        this.participate = participate;
    }

    public void collapse() {
        body.setVisible(false);
        actions.setVisible(false);
        actions.setEnabled(false);
    }

    public void expand() {
        body.setVisible(true);
        actions.setVisible(true);
        actions.setEnabled(true);
    }

    public void unselect() {
        disableActions();
    }

    public void select() {
        enableActions();
    }

    public void disableActions() {
        if (actions != null) {
            actions.setEnabled(false);
            actions.setVisible(false);
        }
    }

    private void enableActions() {
        if (actions != null) {
            actions.setEnabled(true);
            actions.setVisible(true);
        }
    }

    public T getAchievement() {
        return achievement;
    }

    private LifetimeUI getMyUI() {
        return (LifetimeUI) UI.getCurrent();
    }

}
