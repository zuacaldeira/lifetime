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
@Table(name = "linguistic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Linguistic.findAll", query = "SELECT l FROM Linguistic l"),
    @NamedQuery(name = "Linguistic.findById", query = "SELECT l FROM Linguistic l WHERE l.id = :id"),
    @NamedQuery(name = "Linguistic.findByStart", query = "SELECT l FROM Linguistic l WHERE l.start = :start"),
    @NamedQuery(name = "Linguistic.findByEnd", query = "SELECT l FROM Linguistic l WHERE l.end = :end"),
    @NamedQuery(name = "Linguistic.findByLanguage", query = "SELECT l FROM Linguistic l WHERE l.language = :language"),
    @NamedQuery(name = "Linguistic.findByLevel", query = "SELECT l FROM Linguistic l WHERE l.level = :level"),
    @NamedQuery(name = "Linguistic.findByOrganization", query = "SELECT l FROM Linguistic l WHERE l.organization = :organization"),
    @NamedQuery(name = "Linguistic.findByStatus", query = "SELECT l FROM Linguistic l WHERE l.status = :status"),
    @NamedQuery(name = "Linguistic.findByUserId", query = "SELECT l FROM Linguistic l WHERE l.userId = :userId"),
    @NamedQuery(name = "Linguistic.findByName", query = "SELECT l FROM Linguistic l WHERE l.name = :name"),
    @NamedQuery(name = "Linguistic.findByUserIdAndLanguage", query = "SELECT a FROM Linguistic a WHERE a.userId = :userId AND a.language = :language"),
    @NamedQuery(name = "Linguistic.findByOriginalId", query = "SELECT l FROM Linguistic l WHERE l.originalId = :originalId"),
    @NamedQuery(name = "Linguistic.findByDescription", query = "SELECT l FROM Linguistic l WHERE l.description = :description")})
public class Linguistic extends Achievement implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Size(max = 45)
    @Column(name = "level")
    private String level;
    
    @Size(max = 45)
    @Column(name = "name")
    private String name;

    @Size(max = 500)
    @Column(name = "description")
    private String description;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originalId")
    private Linguistic originalId;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "linguistic_tool",
            joinColumns = {@JoinColumn(name = "linguistic", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;

    public Linguistic() {
    }

    public Linguistic(Integer id) {
        super(id);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Linguistic: " + name;
    }

    public Linguistic getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Linguistic originalId) {
        this.originalId = originalId;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
    

}
