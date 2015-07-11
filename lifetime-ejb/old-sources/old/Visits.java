/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package old;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "visits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visits.findAll", query = "SELECT v FROM Visits v"),
    @NamedQuery(name = "Visits.findById", query = "SELECT v FROM Visits v WHERE v.id = :id"),
    @NamedQuery(name = "Visits.findByGuestId", query = "SELECT v FROM Visits v WHERE v.guestId = :guestId"),
    @NamedQuery(name = "Visits.findByHostId", query = "SELECT v FROM Visits v WHERE v.hostId = :hostId"),
    @NamedQuery(name = "Visits.findByCreatedAt", query = "SELECT v FROM Visits v WHERE v.createdAt = :createdAt")})
public class Visits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "guestId")
    private Integer guestId;
    @Column(name = "hostId")
    private Integer hostId;
    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public Visits() {
    }

    public Visits(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
        if (!(object instanceof Visits)) {
            return false;
        }
        Visits other = (Visits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.Visits[ id=" + id + " ]";
    }
    
}
