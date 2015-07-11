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
@Table(name = "professional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professional.findAll", query = "SELECT p FROM Professional p"),
    @NamedQuery(name = "Professional.findById", query = "SELECT p FROM Professional p WHERE p.id = :id"),
    @NamedQuery(name = "Professional.findByPosition", query = "SELECT p FROM Professional p WHERE p.position = :position"),
    @NamedQuery(name = "Professional.findByOrganization", query = "SELECT p FROM Professional p WHERE p.organization = :organization"),
    @NamedQuery(name = "Professional.findByStart", query = "SELECT p FROM Professional p WHERE p.start = :start"),
    @NamedQuery(name = "Professional.findByEnd", query = "SELECT p FROM Professional p WHERE p.end = :end"),
    @NamedQuery(name = "Professional.findByStatus", query = "SELECT p FROM Professional p WHERE p.status = :status"),
    @NamedQuery(name = "Professional.findByUserId", query = "SELECT p FROM Professional p WHERE p.userId = :userId"),
    @NamedQuery(name = "Professional.findByLanguage", query = "SELECT p FROM Professional p WHERE p.language = :language"),
    @NamedQuery(name = "Professional.findByOriginalId", query = "SELECT p FROM Professional p WHERE p.originalId = :originalId"),
    @NamedQuery(name = "Professional.findByDescription", query = "SELECT p FROM Professional p WHERE p.description = :description"),
    @NamedQuery(name = "Professional.findByUserIdAndLanguage", query = "SELECT a FROM Professional a WHERE a.userId = :userId AND a.language = :language")})
public class Professional extends Achievement implements Serializable {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position")
    private Position position;

    @Size(max = 500)
    @Column(name = "description")
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Professional originalId;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "professional_tool",
            joinColumns = {@JoinColumn(name = "professional", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;

    

    public Professional() {
    }

    public Professional(Integer id) {
        super(id);
    }

    public Professional(Integer id, int userId) {
        super(id, userId);
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.Professional[ id=" + getId() + " ]";
    }

    public Professional getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Professional originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
    
}
