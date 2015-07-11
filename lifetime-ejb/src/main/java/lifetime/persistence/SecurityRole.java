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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity representing a role.
 *
 * @author zua
 */
@Entity
@Table(name = "securityRole")
@XmlRootElement
public class SecurityRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Entity unique identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public SecurityRole() {
    }

    public SecurityRole(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    
    
    /**
     * The role's name.
     */
    @Size(max = 45)
    @Column(name = "roleName")
    private String roleName;

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
        if (!(object instanceof SecurityRole)) {
            return false;
        }
        SecurityRole other = (SecurityRole) object;
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
