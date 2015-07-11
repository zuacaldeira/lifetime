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
@Table(name = "user_story")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStory.findAll", query = "SELECT u FROM UserStory u"),
    @NamedQuery(name = "UserStory.findById", query = "SELECT u FROM UserStory u WHERE u.id = :id"),
    @NamedQuery(name = "UserStory.findByMessage", query = "SELECT u FROM UserStory u WHERE u.message = :message"),
    @NamedQuery(name = "UserStory.findByUsername", query = "SELECT u FROM UserStory u WHERE u.username = :username"),
    @NamedQuery(name = "UserStory.findByMethodName", query = "SELECT u FROM UserStory u WHERE u.methodName = :methodName")})
public class UserStory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 500)
    @Column(name = "message")
    private String message;
    @Size(max = 50)
    @Column(name = "username")
    private String username;
    @Size(max = 50)
    @Column(name = "method_name")
    private String methodName;

    public UserStory() {
    }

    public UserStory(Integer id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
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
        if (!(object instanceof UserStory)) {
            return false;
        }
        UserStory other = (UserStory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.business.persistence.UserStory[ id=" + id + " ]";
    }
    
}
