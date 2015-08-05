/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

import java.io.Serializable;
import java.util.Objects;
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
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
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

    /**
     *
     */
    public Contact() {
    }

    /**
     *
     * @param id
     */
    public Contact(Integer id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param username
     */
    public Contact(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    /**
     *
     * @param id
     * @param username
     * @param telephone1
     * @param mobile1
     * @param fax1
     */
    public Contact(Integer id, String username, String telephone1, String mobile1, String fax1) {
        this.id = id;
        this.username = username;
        this.telephone1 = telephone1;
        this.mobile1 = mobile1;
        this.fax1 = fax1;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getTelephone1() {
        return telephone1;
    }

    /**
     *
     * @param telephone1
     */
    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    /**
     *
     * @return
     */
    public String getTelephone2() {
        return telephone2;
    }

    /**
     *
     * @param telephone2
     */
    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    /**
     *
     * @return
     */
    public String getMobile1() {
        return mobile1;
    }

    /**
     *
     * @param mobile1
     */
    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    /**
     *
     * @return
     */
    public String getMobile2() {
        return mobile2;
    }

    /**
     *
     * @param mobile2
     */
    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    /**
     *
     * @return
     */
    public String getFax1() {
        return fax1;
    }

    /**
     *
     * @param fax1
     */
    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    /**
     *
     * @return
     */
    public String getFax2() {
        return fax2;
    }

    /**
     *
     * @param fax2
     */
    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.username);
        hash = 31 * hash + Objects.hashCode(this.telephone1);
        hash = 31 * hash + Objects.hashCode(this.mobile1);
        hash = 31 * hash + Objects.hashCode(this.fax1);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contact other = (Contact) obj;
        return sameOwner(other) && sameCommunications(other);
    }


    @Override
    public String toString() {
        return "lifetime.persistence.Contact[ id=" + id + " ]";
    }

    private boolean sameOwner(Contact other) {
        return Objects.equals(this.username, other.username);
    }

    private boolean sameCommunications(Contact other) {
        return Objects.equals(this.mobile1, other.mobile1) 
                && Objects.equals(this.telephone1, other.telephone1) 
                && Objects.equals(this.fax1, other.fax1);
    }

}
