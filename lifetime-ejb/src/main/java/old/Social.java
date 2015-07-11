/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

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
@Table(name = "social")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Social.findAll", query = "SELECT s FROM Social s"),
    @NamedQuery(name = "Social.findById", query = "SELECT s FROM Social s WHERE s.id = :id"),
    @NamedQuery(name = "Social.findByTitle", query = "SELECT s FROM Social s WHERE s.title = :title"),
    @NamedQuery(name = "Social.findByDescription", query = "SELECT s FROM Social s WHERE s.description = :description"),
    @NamedQuery(name = "Social.findByOrganization", query = "SELECT s FROM Social s WHERE s.organization = :organization"),
    @NamedQuery(name = "Social.findByStart", query = "SELECT s FROM Social s WHERE s.start = :start"),
    @NamedQuery(name = "Social.findByEnd", query = "SELECT s FROM Social s WHERE s.end = :end"),
    @NamedQuery(name = "Social.findByUserId", query = "SELECT s FROM Social s WHERE s.userId = :userId"),
    @NamedQuery(name = "Social.findByStatus", query = "SELECT s FROM Social s WHERE s.status = :status"),
    @NamedQuery(name = "Social.findByUserIdAndLanguage", query = "SELECT a FROM Social a WHERE a.userId = :userId AND a.language = :language"),
    @NamedQuery(name = "Social.findByLanguage", query = "SELECT s FROM Social s WHERE s.language = :language"),
    @NamedQuery(name = "Social.findByOriginalId", query = "SELECT s FROM Social s WHERE s.originalId = :originalId")})
public class Social extends Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(max = 50)
    @Column(name = "title")
    private String title;

    @Size(max = 250)
    @Column(name = "description")
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Social originalId;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "social_tool",
            joinColumns = {@JoinColumn(name = "social", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;
    

    public Social() {
    }

    public Social(Integer id) {
        super(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Social getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Social originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
    
    
    

}
