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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  Entity representing a role.
 * @author zua
 */
@Entity
@Table(name = "userRole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findByUsername", query = "SELECT u FROM UserRole u WHERE u.username = :username"),
})
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Entity's identifier.
     */
    /**
     * Entity unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    /**
     * The username of the user owning this role.
     */
    @Size(max = 45)
    @Column(name = "username")
    private String username;

    /**
     * The role's name.
     */
    @Size(max = 45)
    @Column(name = "roleName")
    private String roleName;

    public UserRole() {
    }

    public UserRole(Integer id, String username, String role) {
        this.id = id;
        this.username = username;
        this.roleName = role;
    }

    /**
     * Get the value of roleName
     *
     * @return the value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set the value of roleName
     *
     * @param roleName new value of roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Delivers the id of this role.
     *
     * @return UserRole's id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Update the role's id.
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Calculates this role's hash code.
     *
     * @return The hash code value
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compares this role with another object for equality.
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Returns an internal string representation of this role.
     *
     * @return The representation string
     */
    @Override
    public String toString() {
        return "lifetime.persistence.Role[ id=" + id + " ]";
    }

}
