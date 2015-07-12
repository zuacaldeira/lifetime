/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zua
 */
@Entity
@Table(name = "lifetimeUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LifetimeUser.findAll", query = "SELECT l FROM LifetimeUser l"),
    @NamedQuery(name = "LifetimeUser.findById", query = "SELECT l FROM LifetimeUser l WHERE l.id = :id"),
    @NamedQuery(name = "LifetimeUser.findByBirthDate", query = "SELECT l FROM LifetimeUser l WHERE l.birthDate = :birthDate"),
    @NamedQuery(name = "LifetimeUser.findByBirthPlace", query = "SELECT l FROM LifetimeUser l WHERE l.birthPlace = :birthPlace"),
    @NamedQuery(name = "LifetimeUser.findByFirstName", query = "SELECT l FROM LifetimeUser l WHERE l.firstName = :firstName"),
    @NamedQuery(name = "LifetimeUser.findByIsConfirmed", query = "SELECT l FROM LifetimeUser l WHERE l.isConfirmed = :isConfirmed"),
    @NamedQuery(name = "LifetimeUser.findByIsLoggedIn", query = "SELECT l FROM LifetimeUser l WHERE l.isLoggedIn = :isLoggedIn"),
    @NamedQuery(name = "LifetimeUser.findByLastName", query = "SELECT l FROM LifetimeUser l WHERE l.lastName = :lastName"),
    @NamedQuery(name = "LifetimeUser.findByMotherLanguage", query = "SELECT l FROM LifetimeUser l WHERE l.motherLanguage = :motherLanguage"),
    @NamedQuery(name = "LifetimeUser.findByUsername", query = "SELECT l FROM LifetimeUser l WHERE l.username = :username")})
public class LifetimeUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "birthPlace")
    private String birthPlace;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "isConfirmed")
    private Boolean isConfirmed;
    @Column(name = "isLoggedIn")
    private Boolean isLoggedIn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "motherLanguage")
    private String motherLanguage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;

    public LifetimeUser() {
        isConfirmed = false;
        isLoggedIn = false;
    }

    public LifetimeUser(Integer id, String firstName, String lastName, String username, Date birthDate, String birthPlace, String motherLanguage) {
        this.id = id;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.firstName = firstName;
        this.lastName = lastName;
        this.motherLanguage = motherLanguage;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.birthPlace);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.lastName);
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
        final LifetimeUser other = (LifetimeUser) obj;
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        if (!Objects.equals(this.birthPlace, other.birthPlace)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "lifetime.persistence.LifetimeUser[ id=" + id + " ]";
    }
    
}
