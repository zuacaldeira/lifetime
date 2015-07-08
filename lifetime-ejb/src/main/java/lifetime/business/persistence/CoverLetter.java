/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "cover_letter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CoverLetter.findAll", query = "SELECT c FROM CoverLetter c"),
    @NamedQuery(name = "CoverLetter.findById", query = "SELECT c FROM CoverLetter c WHERE c.id = :id"),
    @NamedQuery(name = "CoverLetter.findByLanguage", query = "SELECT c FROM CoverLetter c WHERE c.language = :language"),
    @NamedQuery(name = "CoverLetter.findByCreatedAt", query = "SELECT c FROM CoverLetter c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CoverLetter.findByPositionId", query = "SELECT c FROM CoverLetter c WHERE c.positionId = :positionId"),
    @NamedQuery(name = "CoverLetter.findByUserId", query = "SELECT c FROM CoverLetter c WHERE c.userId = :userId")})
public class CoverLetter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Size(max = 16777215)
    @Column(name = "introduction")
    private String introduction;
    @Lob
    @Size(max = 16777215)
    @Column(name = "whyMe")
    private String whyMe;
    @Lob
    @Size(max = 16777215)
    @Column(name = "whyYou")
    private String whyYou;
    @Lob
    @Size(max = 16777215)
    @Column(name = "conclusion")
    private String conclusion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "language")
    private String language;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdAt")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(name = "positionId")
    private Integer positionId;
    @Column(name = "userId")
    private Integer userId;

    public CoverLetter() {
    }

    public CoverLetter(Integer id) {
        this.id = id;
    }

    public CoverLetter(Integer id, String language, Date createdAt) {
        this.id = id;
        this.language = language;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getWhyMe() {
        return whyMe;
    }

    public void setWhyMe(String whyMe) {
        this.whyMe = whyMe;
    }

    public String getWhyYou() {
        return whyYou;
    }

    public void setWhyYou(String whyYou) {
        this.whyYou = whyYou;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        if (!(object instanceof CoverLetter)) {
            return false;
        }
        CoverLetter other = (CoverLetter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cover Letter: " + id;
    }
    
}
