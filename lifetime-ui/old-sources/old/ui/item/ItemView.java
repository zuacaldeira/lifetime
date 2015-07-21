/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import old.ui.helper.DateView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import java.util.Date;
import ui.LifetimeUI;

/**
 *
 * @author azc
 */
public abstract class ItemView<T> extends HorizontalLayout {

    private final DateView date;
    private final InfoView info;
    private final T achievement;

    public ItemView(InfoView<T> info, Date start, Date end, String language) {
        achievement = info.getItem();
        this.info = info;
        this.date = new DateView(start, end, language);
        setSizeFull();
        setSpacing(true);
        setStyleName("item");
        addComponents(date, info);
        setExpandRatio(date, .1f);
        setExpandRatio(this.info, .9f);
        setComponentAlignment(date, Alignment.MIDDLE_CENTER);
        setComponentAlignment(this.info, Alignment.MIDDLE_CENTER);
    }

    public InfoView getInfo() {
        return info;
    }


    public void unselect() {
        info.collapse();
        setStyleName("item");
    }

    public void select() {
        info.expand();
        setStyleName("item-selected");
    }

    public T getAchievement() {
        return achievement;
    }

    public DateView getDate() {
        return date;
    }

    private LifetimeUI getMyUI() {
        return (LifetimeUI) UI.getCurrent();
    }    

}
