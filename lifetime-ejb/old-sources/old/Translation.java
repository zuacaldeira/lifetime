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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "translation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Translation.findAll", query = "SELECT t FROM Translation t"),
    @NamedQuery(name = "Translation.findById", query = "SELECT t FROM Translation t WHERE t.id = :id"),
    @NamedQuery(name = "Translation.findByOriginal", query = "SELECT t FROM Translation t WHERE t.original = :original"),
    @NamedQuery(name = "Translation.findByTranslation", query = "SELECT t FROM Translation t WHERE t.translation = :translation"),
    @NamedQuery(name = "Translation.findByOrigin", query = "SELECT t FROM Translation t WHERE t.origin = :origin"),
    @NamedQuery(name = "Translation.findByTarget", query = "SELECT t FROM Translation t WHERE t.target = :target")})
public class Translation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 500)
    @Column(name = "original")
    private String original;
    @Size(max = 500)
    @Column(name = "translation")
    private String translation;
    @Size(max = 3)
    @Column(name = "origin")
    private String origin;
    @Size(max = 3)
    @Column(name = "target")
    private String target;

    public Translation() {
    }

    public Translation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
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
        if (!(object instanceof Translation)) {
            return false;
        }
        Translation other = (Translation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.Translation[ id=" + id + " ]";
    }
    
}
