/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zua
 */

@Entity
@Table(name = "userAccount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT a FROM UserAccount a"),
    @NamedQuery(name = "UserAccount.findByEmail", query = "SELECT a FROM UserAccount a WHERE a.email = :email")    
})
public class UserAccount extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

    
    @Size(max = 45)
    @Column(name = "email", unique = true)
    private String email;
    
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lifetimeUser")
    private LifetimeUser user;
    
    /**
     *
     */
    public UserAccount() {
    }

    /**
     *
     * @param id
     */
    public UserAccount(Integer id) {
        super(id);
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public LifetimeUser getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(LifetimeUser user) {
        this.user = user;
    }
    
    

    
    
    
}
