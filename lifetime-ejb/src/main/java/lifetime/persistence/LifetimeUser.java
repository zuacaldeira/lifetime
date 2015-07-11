/*
 * To change this license header, choose License Headers in Entrepeneurship Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lifetime
 */
@Entity
@Table(name = "lifetimeUser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LifetimeUser.findAll", query = "SELECT u FROM LifetimeUser u"),
    @NamedQuery(name = "LifetimeUser.findById", query = "SELECT u FROM LifetimeUser u WHERE u.id = :id"),
    @NamedQuery(name = "LifetimeUser.findByFirstName", query = "SELECT u FROM LifetimeUser u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "LifetimeUser.findByLastName", query = "SELECT u FROM LifetimeUser u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "LifetimeUser.findByBirthDate", query = "SELECT u FROM LifetimeUser u WHERE u.birthDate = :birthDate"),
    @NamedQuery(name = "LifetimeUser.findByBirthPlace", query = "SELECT u FROM LifetimeUser u WHERE u.birthPlace = :birthPlace"),
    @NamedQuery(name = "LifetimeUser.findByUsername", query = "SELECT u FROM LifetimeUser u WHERE u.username = :username"),
    //@NamedQuery(name = "LifetimeUser.findByMotherLanguage", query = "SELECT u LifetimeUser  u WHERE u.motherLanguage = :motherLanguage"),
    @NamedQuery(name = "LifetimeUser.findByIsLoggedIn", query = "SELECT u FROM LifetimeUser u WHERE u.isLoggedIn = :isLoggedIn"),
    @NamedQuery(name = "LifetimeUser.findByIsConfirmed", query = "SELECT u FROM LifetimeUser u WHERE u.isConfirmed = :isConfirmed")})
public class LifetimeUser implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Entity unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    /**
     * First names.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "firstName")
    private String firstName;

    /**
     * Last names.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lastName")
    private String lastName;

    /**
     * Birth date.
     */
    @Column(name = "birthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    /**
     * Birth place.
     */
    @Size(max = 45)
    @Column(name = "birthPlace")
    private String birthPlace;

    /**
     * Username or heteronym.
     */
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;

    /**
     * Mother language.
     */
    @Size(max = 10)
    @Column(name = "motherLanguage")
    private String motherLanguage;

    /**
     * Account status.
     */
    @Column(name = "isLoggedIn")
    private Boolean isLoggedIn;
    @Column(name = "isConfirmed")
    private Boolean isConfirmed;

    /**
     * Default constructor.
     */
    public LifetimeUser() {

    }

    /**
     * Initializes a user's {@code id}.
     *
     * @param id
     */
    public LifetimeUser(Integer id) {
        this.id = id;
        isLoggedIn = false;
        isConfirmed = false;
    }

    /**
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param username
     * @param birthDate
     * @param birthPlace
     * @param motherLanguage
     */
    public LifetimeUser(Integer id, String firstname, String lastname, String username, Date birthDate, String birthPlace, String motherLanguage) {
        this(id);
        this.firstName = firstname;
        this.lastName = lastname;
        this.username = username;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.motherLanguage = motherLanguage;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastname
     */
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    /**
     *
     * @return
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param birthDate
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     *
     * @return
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     *
     * @param birthPlace
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
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
    public String getMotherLanguage() {
        return motherLanguage;
    }

    /**
     *
     * @param motherLanguage
     */
    public void setMotherLanguage(String motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    /**
     *
     * @return
     */
    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    /**
     *
     * @param isLoggedIn
     */
    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    /**
     *
     * @return
     */
    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    /**
     *
     * @param isConfirmed
     */
    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
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
        if (!(object instanceof LifetimeUser)) {
            return false;
        }
        LifetimeUser other = (LifetimeUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User: " + firstName + " " + lastName;
    }

}
