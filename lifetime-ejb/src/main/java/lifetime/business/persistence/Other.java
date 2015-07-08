/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "other")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Other.findAll", query = "SELECT o FROM Other o"),
    @NamedQuery(name = "Other.findById", query = "SELECT o FROM Other o WHERE o.id = :id"),
    @NamedQuery(name = "Other.findByStart", query = "SELECT o FROM Other o WHERE o.start = :start"),
    @NamedQuery(name = "Other.findByEnd", query = "SELECT o FROM Other o WHERE o.end = :end"),
    @NamedQuery(name = "Other.findByStatus", query = "SELECT o FROM Other o WHERE o.status = :status"),
    @NamedQuery(name = "Other.findByUserId", query = "SELECT o FROM Other o WHERE o.userId = :userId"),
    @NamedQuery(name = "Other.findByCategory", query = "SELECT o FROM Other o WHERE o.category = :category"),
    @NamedQuery(name = "Other.findByTitle", query = "SELECT o FROM Other o WHERE o.title = :title"),
    @NamedQuery(name = "Other.findByUrl", query = "SELECT o FROM Other o WHERE o.url = :url"),
    @NamedQuery(name = "Other.findByLanguage", query = "SELECT o FROM Other o WHERE o.language = :language"),
    @NamedQuery(name = "Other.findByUserIdAndLanguage", query = "SELECT o FROM Other o WHERE o.userId = :userId AND o.language = :language"),
    @NamedQuery(name = "Other.findByOriginalId", query = "SELECT o FROM Other o WHERE o.originalId = :originalId"),
    @NamedQuery(name = "Other.findByDescription", query = "SELECT o FROM Other o WHERE o.description = :description"),
    @NamedQuery(name = "Other.findByOrganization", query = "SELECT o FROM Other o WHERE o.organization = :organization"),
    @NamedQuery(name = "Other.findByCreatedAt", query = "SELECT o FROM Other o WHERE o.createdAt = :createdAt")})
public class Other extends Achievement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Size(max = 45)
    @Column(name = "category")
    private String category;
    
    @Size(max = 100)
    @Column(name = "title")
    private String title;
    
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Other originalId;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "other_tool",
            joinColumns = {@JoinColumn(name = "other", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;

    public Other() {
    }

    public Other(Integer id) {
        super(id);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.Other[ id=" + getId() + " ]";
    }

    public Other getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Other originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
    
}
