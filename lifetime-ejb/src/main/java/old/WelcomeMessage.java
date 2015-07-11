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
@Table(name = "welcome_message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WelcomeMessage.findAll", query = "SELECT w FROM WelcomeMessage w"),
    @NamedQuery(name = "WelcomeMessage.findById", query = "SELECT w FROM WelcomeMessage w WHERE w.id = :id"),
    @NamedQuery(name = "WelcomeMessage.findByMessage", query = "SELECT w FROM WelcomeMessage w WHERE w.message = :message"),
    @NamedQuery(name = "WelcomeMessage.findByUserId", query = "SELECT w FROM WelcomeMessage w WHERE w.userId = :userId")})
public class WelcomeMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "message")
    private String message;
    @Column(name = "userId")
    private Integer userId;

    public WelcomeMessage() {
    }

    public WelcomeMessage(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof WelcomeMessage)) {
            return false;
        }
        WelcomeMessage other = (WelcomeMessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.WelcomeMessage[ id=" + id + " ]";
    }
    
}
