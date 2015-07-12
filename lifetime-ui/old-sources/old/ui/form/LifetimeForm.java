/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old.ui.form;

import old.ui.combo.CourseComboBox;
import old.ui.combo.DegreeComboBox;
import old.ui.combo.ProjectComboBox;
import old.ui.combo.GradeComboBox;
import old.ui.combo.LifetimeComboBox;
import old.ui.textField.LifetimeDateField;
import old.ui.label.LifetimeLabel;
import old.ui.combo.OrganizationComboBox;
import old.ui.combo.StatusComboBox;
import old.ui.button.LifetimeButtonSmall;
import old.ui.combo.LanguageComboBox;
import old.ui.combo.LinguisticSkillsComboBox;
import old.ui.combo.PositionComboBox;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import lifetime.business.persistence.Course;
import lifetime.business.persistence.Degree;
import lifetime.business.persistence.Organization;
import lifetime.business.persistence.Position;
import lifetime.business.persistence.Project;
import old.ui.button.LifetimeButtonLink;
import old.ui.data.AllLanguagesDataContainer;
import old.ui.list.LifetimeList;
import old.ui.list.TaskList;
import old.ui.list.ToolsList;
import old.ui.textField.LifetimeTextArea;
import old.ui.textField.LifetimeTextField;

/**
 *
 * @author azc
 */
public abstract class LifetimeForm<T> extends Panel implements Button.ClickListener {

    private Integer userId;
    private String language;
    private Button cancel;
    private Button save;
    private T item;
    private LifetimeComboBox originalId;
    private FormLayout controls;
    private FormLayout main;
    private LifetimeDateField end;
    private LifetimeDateField start;
    private LifetimeTextArea description;
    private LifetimeTextField title;
    private StatusComboBox status;
    private OrganizationComboBox organization;
    private CourseComboBox course;
    private DegreeComboBox degree;
    private LanguageComboBox languageComboBox;
    private LinguisticSkillsComboBox read;
    private LinguisticSkillsComboBox talk;
    private LinguisticSkillsComboBox write;
    private PositionComboBox position;
    private final LifetimeList<T> list;
    private ProjectComboBox project;
    private GradeComboBox grade;
    private LanguageComboBox skills;
    private TaskList tasks;
    private ToolsList tools;
    private LifetimeTextField reference;
    private LifetimeTextField contactName;
    private LifetimeTextField contactEmail;
    private LifetimeButtonLink ok;
    private LifetimeTextArea introduction;
    private LifetimeTextArea whyMe;
    private LifetimeTextArea whyYou;
    private LifetimeTextArea conclusion;
    private LifetimeComboBox contactTitle;
    private LifetimeTextArea emailText;

    public LifetimeForm(Integer userId, String language, T data, LifetimeList<T> list) {
        this.item = data;
        this.userId = userId;
        this.language = language;
        this.list = list;
        //
        setSizeFull();
        setImmediate(true);
        initMain();
        initControls();
        VerticalLayout base = new VerticalLayout(main, controls);
        setContent(base);
        setStyleName("a-form");
    }

    private void initMain() {
        main = new FormLayout();
        main.setMargin(true);
        main.setImmediate(true);
    }

    private void initControls() {
        cancel = new LifetimeButtonSmall("Cancel", null);
        cancel.addClickListener(this);
        cancel.setCaption(cancel.getDescription());
        save = new LifetimeButtonSmall("Save/Edit/Translate", FontAwesome.LANGUAGE);
        save.addClickListener(this);
        save.setCaption(save.getDescription());
        controls = new FormLayout(new LifetimeLabel("Action", language), new HorizontalLayout(cancel, save));
        controls.setMargin(true);
        controls.setSpacing(true);
    }

    public abstract void fillItem();

    protected abstract void commitItem();

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public LifetimeComboBox getOriginalId() {
        return originalId;
    }

    public void setOriginalId(LifetimeComboBox originalId) {
        this.originalId = originalId;
    }

    public Button getSave() {
        return save;
    }

    public FormLayout getControls() {
        return controls;
    }

    public FormLayout getMain() {
        return main;
    }

    protected void addDegree(Degree value) {
        degree = new DegreeComboBox(getLanguage());
        if (value != null) {
            degree.setValue(value);
        }
        getMain().addComponent(degree);
    }

    protected void addCourse(Course value) {
        course = new CourseComboBox(getLanguage());
        if (value != null) {
            course.setValue(course);
        }
        getMain().addComponent(course);
    }

    protected void addOrganization(Organization value) {
        organization = new OrganizationComboBox(getLanguage());
        if (value != null) {
            organization.setValue(value);
        }
        getMain().addComponent(organization);
    }

    protected void addProject(Project value) {
        project = new ProjectComboBox(getLanguage());
        if (value != null) {
            project.setValue(value);
        }
        getMain().addComponent(project);
    }

    protected void addLinguisticSkillName(String value) {
        skills = new LanguageComboBox(getLanguage());
        if (value != null) {
            skills.setValue(value);
        }
        getMain().addComponent(skills);
    }

    public LanguageComboBox getSkills() {
        return skills;
    }

    protected void addStatus(String value) {
        status = new StatusComboBox(getLanguage());
        if (value != null) {
            status.setValue(value);
        }
        getMain().addComponent(status);
    }

    protected void addGrade(String value) {
        grade = new GradeComboBox(getLanguage());
        if (value != null) {
            grade.setValue(value);
        }
        getMain().addComponent(grade);
    }

    protected void addDescription(String value) {
        description = new LifetimeTextArea("Description");
        if (value != null) {
            description.setValue(value);
        }
        getMain().addComponent(description);
    }

    protected void addEmailText(String value) {
        emailText = new LifetimeTextArea("Email Text");
        if (value != null) {
            emailText.setValue(value);
        }
        getMain().addComponent(emailText);
    }

    protected void addContactEmail(String value) {
        contactEmail = new LifetimeTextField("Contact Email");
        if (value != null) {
            contactEmail.setValue(value);
        }
        getMain().addComponent(contactEmail);
    }

    protected void addContactTitle(String value) {
        contactTitle = new LifetimeComboBox("Salutation", getLanguage(), Arrays.asList(ContactTitle.values())) {
        };
        contactTitle.setRequired(true);
        contactTitle.setImmediate(true);
        contactTitle.setNewItemsAllowed(false);
        contactTitle.setNullSelectionAllowed(false);

        if (value != null && ContactTitle.valueOf(value) != null) {
            contactTitle.setValue(ContactTitle.valueOf(value));
        }
        getMain().addComponent(contactTitle);
    }

    protected void addContactName(String value) {
        contactName = new LifetimeTextField("Contact Name");
        contactName.setRequired(true);

        if (value != null) {
            contactName.setValue(value);
        }
        getMain().addComponent(contactName);
    }

    protected void addReference(String value) {
        reference = new LifetimeTextField("Reference");
        if (value != null) {
            reference.setValue(value);
        }
        getMain().addComponent(reference);
    }

    protected void addTitle(String value) {
        title = new LifetimeTextField("Title");
        if (value != null) {
            title.setValue(value);
        }
        getMain().addComponent(title);
    }

    protected void addStart(Date value) {
        start = new LifetimeDateField("Start", getLanguage());
        if (value != null) {
            start.setValue(value);
        }
        getMain().addComponent(start);
    }

    protected void addEnd(Date value) {
        end = new LifetimeDateField("End", getLanguage());
        if (value != null) {
            end.setValue(value);
        }
        getMain().addComponent(end);
    }

    protected void addLanguage(String value) {
        languageComboBox = new LanguageComboBox(getLanguage());
        languageComboBox.setRequired(true);
        languageComboBox.setImmediate(true);
        languageComboBox.setNewItemsAllowed(false);
        languageComboBox.setNullSelectionAllowed(false);
        getMain().addComponent(languageComboBox);
        if (value != null) {
            String v = AllLanguagesDataContainer.getInternalName(new Locale(value));
            languageComboBox.select(v);
        }
    }

    protected void addReadLevel(String value) {
        read = new LinguisticSkillsComboBox("Level", getLanguage());
        if (value != null) {
            read.setValue(value);
        }
        getMain().addComponent(read);
    }

    protected void addConversationLevel(String value) {
        talk = new LinguisticSkillsComboBox("Conversation", getLanguage());
        if (value != null) {
            talk.setValue(value);
        }
        getMain().addComponent(talk);
    }

    protected void addWriteLevel(String value) {
        write = new LinguisticSkillsComboBox("Write", getLanguage());
        if (value != null) {
            write.setValue(value);
        }
        getMain().addComponent(write);
    }

    protected void addPosition(Position value) {
        position = new PositionComboBox(getLanguage());
        if (value != null) {
            position.setValue(value);
        }
        getMain().addComponent(position);
    }

    public LifetimeDateField getEnd() {
        return end;
    }

    public LifetimeDateField getStart() {
        return start;
    }

    public LifetimeTextArea getDesc() {
        return description;
    }

    public GradeComboBox getGrade() {
        return grade;
    }

    public StatusComboBox getStatus() {
        return status;
    }

    public OrganizationComboBox getOrganization() {
        return organization;
    }

    public CourseComboBox getCourse() {
        return course;
    }

    public DegreeComboBox getDegree() {
        return degree;
    }

    public LanguageComboBox getLanguageComboBox() {
        return languageComboBox;
    }

    public LinguisticSkillsComboBox getRead() {
        return read;
    }

    public LinguisticSkillsComboBox getTalk() {
        return talk;
    }

    public LinguisticSkillsComboBox getWrite() {
        return write;
    }

    public PositionComboBox getPosition() {
        return position;
    }

    public LifetimeTextField getTitle() {
        return title;
    }

    public LifetimeComboBox getContactTitle() {
        return contactTitle;
    }

    @Override
    public void buttonClick(Button.ClickEvent event) {
        if (event.getButton() == getCancel()) {
            closeWindow();
        } else if (event.getButton() == getSave()) {
            fillItem();
            commitItem();
            if (list != null) {
                list.initMain();
            }
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

    public LifetimeList<T> getList() {
        return list;
    }

    public ProjectComboBox getEntrepeneurship() {
        return project;
    }

    public ProjectComboBox getProject() {
        return project;
    }

    public void setProject(ProjectComboBox project) {
        this.project = project;
    }

    public TaskList getTasks() {
        return tasks;
    }

    public void setTasks(TaskList tasks) {
        this.tasks = tasks;
    }

    public ToolsList getTools() {
        return tools;
    }

    public void setTools(ToolsList tools) {
        this.tools = tools;
    }

    public LifetimeTextField getReference() {
        return reference;
    }

    public void setReference(LifetimeTextField reference) {
        this.reference = reference;
    }

    public LifetimeTextField getContactName() {
        return contactName;
    }

    public void setContactName(LifetimeTextField contactName) {
        this.contactName = contactName;
    }

    public LifetimeTextField getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(LifetimeTextField contactEmail) {
        this.contactEmail = contactEmail;
    }

    public LifetimeButtonLink getOk() {
        return ok;
    }

    public void setOk(LifetimeButtonLink ok) {
        this.ok = ok;
    }

    void addIntroduction(String value) {
        introduction = new LifetimeTextArea("Introduction");
        if (value != null) {
            introduction.setValue(value);
        }
        getMain().addComponent(introduction);
    }

    void addWhyMe(String value) {
        whyMe = new LifetimeTextArea("Why Me");
        if (value != null) {
            whyMe.setValue(value);
        }
        getMain().addComponent(whyMe);
    }

    void addWhyYou(String value) {
        whyYou = new LifetimeTextArea("Why You");
        if (value != null) {
            whyYou.setValue(value);
        }
        getMain().addComponent(whyYou);
    }

    void addConclusion(String value) {
        conclusion = new LifetimeTextArea("Conclusion");
        if (value != null) {
            conclusion.setValue(value);
        }
        getMain().addComponent(conclusion);
    }

    public LifetimeTextArea getIntroduction() {
        return introduction;
    }

    public LifetimeTextArea getWhyMe() {
        return whyMe;
    }

    public LifetimeTextArea getWhyYou() {
        return whyYou;
    }

    public LifetimeTextArea getConclusion() {
        return conclusion;
    }

    public LifetimeTextArea getEmailText() {
        return emailText;
    }

}
