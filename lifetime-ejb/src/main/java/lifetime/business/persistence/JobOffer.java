/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "job_offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobOffer.findAll", query = "SELECT j FROM JobOffer j"),
    @NamedQuery(name = "JobOffer.findById", query = "SELECT j FROM JobOffer j WHERE j.id = :id"),
    @NamedQuery(name = "JobOffer.findByRank", query = "SELECT j FROM JobOffer j WHERE j.rank = :rank"),
    @NamedQuery(name = "JobOffer.findByPosition", query = "SELECT j FROM JobOffer j WHERE j.position = :position"),
    @NamedQuery(name = "JobOffer.findByLanguage", query = "SELECT j FROM JobOffer j WHERE j.language = :language"),
    @NamedQuery(name = "JobOffer.findByCreatedAt", query = "SELECT j FROM JobOffer j WHERE j.createdAt = :createdAt"),
    @NamedQuery(name = "JobOffer.findByContactName", query = "SELECT j FROM JobOffer j WHERE j.contactName = :contactName"),
    @NamedQuery(name = "JobOffer.findByContactEmail", query = "SELECT j FROM JobOffer j WHERE j.contactEmail = :contactEmail"),
    @NamedQuery(name = "JobOffer.findByOrganization", query = "SELECT j FROM JobOffer j WHERE j.organization = :organization"),
    @NamedQuery(name = "JobOffer.findByStart", query = "SELECT j FROM JobOffer j WHERE j.start = :start"),
    @NamedQuery(name = "JobOffer.findByEnd", query = "SELECT j FROM JobOffer j WHERE j.end = :end"),
    @NamedQuery(name = "JobOffer.findByReference", query = "SELECT j FROM JobOffer j WHERE j.reference = :reference"),
    @NamedQuery(name = "JobOffer.findByContactTitle", query = "SELECT j FROM JobOffer j WHERE j.contactTitle = :contactTitle")})
public class JobOffer implements Serializable {

    @Size(max = 255)
    @Column(name = "url")
    private String url;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "rank")
    private String rank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position")
    private Position position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization")
    private Organization organization;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "job_offer_tool",
            joinColumns = {@JoinColumn(name = "jobOffer", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tool", referencedColumnName = "id")})
    private List<Tool> tools;

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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Size(max = 100)
    @Column(name = "contactName")
    private String contactName;
    @Size(max = 100)
    @Column(name = "contactEmail")
    private String contactEmail;

    @Column(name = "start")
    @Temporal(TemporalType.DATE)
    private Date start;
    @Column(name = "end")
    @Temporal(TemporalType.DATE)
    private Date end;
    @Size(max = 45)
    @Column(name = "reference")
    private String reference;
    @Size(max = 45)
    @Column(name = "contactTitle")
    private String contactTitle;

    public JobOffer() {
    }

    public JobOffer(Integer id) {
        this();
        this.id = id;
    }

    public JobOffer(Integer id, String language, Date createdAt) {
        this(id);
        this.language = language;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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
        if (!(object instanceof JobOffer)) {
            return false;
        }
        JobOffer other = (JobOffer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return (position != null) ? position.toString() : ("" + id);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

}
