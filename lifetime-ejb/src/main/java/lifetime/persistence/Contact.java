/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

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
 * @author zua
 */
@Entity
@Table(name = "Contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findById", query = "SELECT c FROM Contact c WHERE c.id = :id"),
    @NamedQuery(name = "Contact.findByUsername", query = "SELECT c FROM Contact c WHERE c.username = :username"),
    @NamedQuery(name = "Contact.findByTelephone1", query = "SELECT c FROM Contact c WHERE c.telephone1 = :telephone1"),
    @NamedQuery(name = "Contact.findByTelephone2", query = "SELECT c FROM Contact c WHERE c.telephone2 = :telephone2"),
    @NamedQuery(name = "Contact.findByMobile1", query = "SELECT c FROM Contact c WHERE c.mobile1 = :mobile1"),
    @NamedQuery(name = "Contact.findByMobile2", query = "SELECT c FROM Contact c WHERE c.mobile2 = :mobile2"),
    @NamedQuery(name = "Contact.findByFax1", query = "SELECT c FROM Contact c WHERE c.fax1 = :fax1"),
    @NamedQuery(name = "Contact.findByFax2", query = "SELECT c FROM Contact c WHERE c.fax2 = :fax2")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "telephone1")
    private String telephone1;
    @Size(max = 45)
    @Column(name = "telephone2")
    private String telephone2;
    @Size(max = 45)
    @Column(name = "mobile1")
    private String mobile1;
    @Size(max = 45)
    @Column(name = "mobile2")
    private String mobile2;
    @Size(max = 45)
    @Column(name = "fax1")
    private String fax1;
    @Size(max = 45)
    @Column(name = "fax2")
    private String fax2;

    public Contact() {
    }

    public Contact(Integer id) {
        this.id = id;
    }

    public Contact(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public Contact(Integer id, String username, String telephone1, String mobile1, String fax1) {
        this.id = id;
        this.username = username;
        this.telephone1 = telephone1;
        this.mobile1 = mobile1;
        this.fax1 = fax1;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
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
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.persistence.Contact[ id=" + id + " ]";
    }
    
}
