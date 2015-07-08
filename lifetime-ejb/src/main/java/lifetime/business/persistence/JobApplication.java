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
@Table(name = "job_application")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobApplication.findAll", query = "SELECT j FROM JobApplication j"),
    @NamedQuery(name = "JobApplication.findById", query = "SELECT j FROM JobApplication j WHERE j.id = :id"),
    @NamedQuery(name = "JobApplication.findByJobOfferId", query = "SELECT j FROM JobApplication j WHERE j.jobOfferId = :jobOfferId"),
    @NamedQuery(name = "JobApplication.findByCoverLetterId", query = "SELECT j FROM JobApplication j WHERE j.coverLetterId = :coverLetterId"),
    @NamedQuery(name = "JobApplication.findByLanguage", query = "SELECT j FROM JobApplication j WHERE j.language = :language"),
    @NamedQuery(name = "JobApplication.findByCreatedAt", query = "SELECT j FROM JobApplication j WHERE j.createdAt = :createdAt"),
    @NamedQuery(name = "JobApplication.findByUserId", query = "SELECT j FROM JobApplication j WHERE j.userId = :userId"),
    @NamedQuery(name = "JobApplication.findByIsReviewed", query = "SELECT j FROM JobApplication j WHERE j.isReviewed = :isReviewed"),
    @NamedQuery(name = "JobApplication.findByJobOfferIdAndUserId", query = "SELECT j FROM JobApplication j WHERE j.jobOfferId = :jobOfferId AND j.userId = :userId"),
    @NamedQuery(name = "JobApplication.findByUserIdAndLanguage", query = "SELECT j FROM JobApplication j WHERE j.language = :language AND j.userId = :userId"),
    @NamedQuery(name = "JobApplication.findByReviewedAt", query = "SELECT j FROM JobApplication j WHERE j.reviewedAt = :reviewedAt")})
public class JobApplication implements Serializable {
    @Lob
    @Column(name = "coverLetterImage")
    private byte[] coverLetterImage;
    @Lob
    @Column(name = "resumeeImage")
    private byte[] resumeeImage;
    @Column(name = "isReviewed")
    private Short isReviewed;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jobOfferId")
    private int jobOfferId;
    @Column(name = "coverLetterId")
    private Integer coverLetterId;
    @Lob
    @Size(max = 16777215)
    @Column(name = "emailText")
    private String emailText;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "language")
    private String language;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId")
    private int userId;
    @Column(name = "reviewedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewedAt;

    public JobApplication() {
    }

    public JobApplication(Integer id) {
        this.id = id;
    }

    public JobApplication(Integer id, int jobOfferId, String language, Date createdAt, int userId) {
        this.id = id;
        this.jobOfferId = jobOfferId;
        this.language = language;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getJobOfferId() {
        return jobOfferId;
    }

    public void setJobOfferId(int jobOfferId) {
        this.jobOfferId = jobOfferId;
    }

    public Integer getCoverLetterId() {
        return coverLetterId;
    }

    public void setCoverLetterId(Integer coverLetterId) {
        this.coverLetterId = coverLetterId;
    }


    public String getEmailText() {
        return emailText;
    }

    public void setEmailText(String emailText) {
        this.emailText = emailText;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public Date getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(Date reviewedAt) {
        this.reviewedAt = reviewedAt;
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
        if (!(object instanceof JobApplication)) {
            return false;
        }
        JobApplication other = (JobApplication) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.JobApplication[ id=" + id + " ]";
    }


    public Short getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(Short isReviewed) {
        this.isReviewed = isReviewed;
    }

    public byte[] getCoverLetterImage() {
        return coverLetterImage;
    }

    public void setCoverLetterImage(byte[] coverLetterImage) {
        this.coverLetterImage = coverLetterImage;
    }

    public byte[] getResumeeImage() {
        return resumeeImage;
    }

    public void setResumeeImage(byte[] resumeeImage) {
        this.resumeeImage = resumeeImage;
    }
    
}
