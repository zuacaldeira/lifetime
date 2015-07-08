/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
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
@Table(name = "entrepeneurship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrepeneurship.findAll", query = "SELECT e FROM Entrepeneurship e"),
    @NamedQuery(name = "Entrepeneurship.findById", query = "SELECT e FROM Entrepeneurship e WHERE e.id = :id"),
    @NamedQuery(name = "Entrepeneurship.findByStart", query = "SELECT e FROM Entrepeneurship e WHERE e.start = :start"),
    @NamedQuery(name = "Entrepeneurship.findByEnd", query = "SELECT e FROM Entrepeneurship e WHERE e.end = :end"),
    @NamedQuery(name = "Entrepeneurship.findByProject", query = "SELECT e FROM Entrepeneurship e WHERE e.project = :project"),
    @NamedQuery(name = "Entrepeneurship.findByPosition", query = "SELECT e FROM Entrepeneurship e WHERE e.position = :position"),
    @NamedQuery(name = "Entrepeneurship.findByOrganization", query = "SELECT e FROM Entrepeneurship e WHERE e.organization = :organization"),
    @NamedQuery(name = "Entrepeneurship.findByDescription", query = "SELECT e FROM Entrepeneurship e WHERE e.description = :description"),
    @NamedQuery(name = "Entrepeneurship.findByUrl", query = "SELECT e FROM Entrepeneurship e WHERE e.url = :url"),
    @NamedQuery(name = "Entrepeneurship.findByUserId", query = "SELECT e FROM Entrepeneurship e WHERE e.userId = :userId"),
    @NamedQuery(name = "Entrepeneurship.findByLanguage", query = "SELECT e FROM Entrepeneurship e WHERE e.language = :language"),
    @NamedQuery(name = "Entrepeneurship.findByUserIdAndLanguage", query = "SELECT e FROM Entrepeneurship e WHERE e.userId = :userId AND e.language = :language"),
    @NamedQuery(name = "Entrepeneurship.findByNameAndLanguage", query = "SELECT e FROM Entrepeneurship e WHERE e.project = :project AND e.language = :language"),
    @NamedQuery(name = "Entrepeneurship.findByOriginalId", query = "SELECT e FROM Entrepeneurship e WHERE e.originalId = :originalId"),
    @NamedQuery(name = "Entrepeneurship.findByStatus", query = "SELECT e FROM Entrepeneurship e WHERE e.status = :status"),
    @NamedQuery(name = "Entrepeneurship.findByCreatedAt", query = "SELECT e FROM Entrepeneurship e WHERE e.createdAt = :createdAt")})
public class Entrepeneurship extends Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project")
    private Project project;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position")
    private Position position;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @Size(max = 255)
    @Column(name = "url")
    private String url;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Entrepeneurship originalId;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "entrepeneurship_tool",
            joinColumns = {@JoinColumn(name = "entrepeneurship", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;
    

    public Entrepeneurship() {
    }

    public Entrepeneurship(Integer id) {
        super(id);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrepeneurship)) {
            return false;
        }
        Entrepeneurship other = (Entrepeneurship) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return project.toString();
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Entrepeneurship getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Entrepeneurship originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    

}
