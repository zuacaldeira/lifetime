/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "missing_translation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MissingTranslation.findAll", query = "SELECT m FROM MissingTranslation m"),
    @NamedQuery(name = "MissingTranslation.findById", query = "SELECT m FROM MissingTranslation m WHERE m.id = :id"),
    @NamedQuery(name = "MissingTranslation.findByWord", query = "SELECT m FROM MissingTranslation m WHERE m.word = :word"),
    @NamedQuery(name = "MissingTranslation.findByOrigin", query = "SELECT m FROM MissingTranslation m WHERE m.origin = :origin"),
    @NamedQuery(name = "MissingTranslation.findByTarget", query = "SELECT m FROM MissingTranslation m WHERE m.target = :target")})
public class MissingTranslation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "word")
    private String word;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "origin")
    private String origin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "target")
    private String target;

    public MissingTranslation() {
    }

    public MissingTranslation(Integer id) {
        this.id = id;
    }

    public MissingTranslation(Integer id, String word, String origin, String target) {
        this.id = id;
        this.word = word;
        this.origin = origin;
        this.target = target;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MissingTranslation)) {
            return false;
        }
        MissingTranslation other = (MissingTranslation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.MissingTranslation[ id=" + id + " ]";
    }
    
}
