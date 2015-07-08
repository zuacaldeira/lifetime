/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.item;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author azc
 * @param <T>
 */
public abstract class InfoView<T> extends VerticalLayout {

    private InfoTitle title;
    private InfoBody body;
    private final QAView<T> qa;

    private final T item;
    private final Integer userId;
    private final String language;

    public InfoView(Integer userId, String language, T item) {
        //setSizeFull();
        this.userId = userId;
        this.language = language;
        setMargin(true);
        setMargin(new MarginInfo(false, true, false, true));
        setImmediate(true);
        this.item = item;
        this.title = new InfoTitle();
        this.body = new InfoBody();
        this.qa = getQAView();

        addComponents(title, body, qa);
        qa.setVisible(false);
        //setComponentAlignment(qa, Alignment.MIDDLE_RIGHT);

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

    public void collapse() {
        body.setVisible(false);
        qa.setVisible(false);
    }

    public void expand() {
        body.setVisible(true);
        qa.setVisible(true);
    }

    public void unselect() {
        qa.setVisible(false);
    }

    public void select() {
        qa.setVisible(true);
    }

    public T getItem() {
        return item;
    }

    public QAView getQa() {
        return qa;
    }

    protected abstract QAView<T> getQAView();

    public Integer getUserId() {
        return userId;
    }

    public String getLanguage() {
        return language;
    }


    
}
