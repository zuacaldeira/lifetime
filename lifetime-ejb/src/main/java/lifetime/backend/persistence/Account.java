/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Entity
@Table(name = "Account", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")})
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;

    /**
     * User owning this account. If this account gets deleted, the user also
     * will.
     */
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    private User user;

    /**
     * User owning this account. If this account gets deleted, the user also
     * will.
     */
    @OneToOne(targetEntity = Role.class)
    @JoinColumn(name = "role")
    private Role role;

    /**
     * Default constructor.
     */
    public Account() {
    }

    /**
     * Unary constructor.
     *
     * @param id
     */
    public Account(Integer id) {
        this.id = id;
    }

    /**
     * Standard constructor.
     *
     * @param id
     * @param email
     * @param password
     */
    public Account(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    /**
     * Retrieves the account unique identifier, as in the database.
     *
     * @return Account <i>id</i>
     */
    public Integer getId() {
        return id;
    }

    /**
     * Updates the account identifier.
     *
     * @param id The new identifier
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get the account email and username.
     *
     * @return The account email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Updates the account email.
     *
     * @param email The new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the account password.
     *
     * @return The new password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Updates the account password.
     *
     * @param password The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user owning this account.
     *
     * @return The account owner
     */
    public User getUser() {
        return user;
    }

    /**
     * Updates the account owner.
     *
     * @param user The new owner
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Role getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }
    
    

    /**
     * Hash code.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.user);
        return hash;
    }

    /**
     * Compare for equality. Two accounts are semantically equivalent if they
     * <i>simultaneously</i> have the same email, password, and belong to same
     * user.
     *
     * @param obj The object to compare with.
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    @Override
    public String toString() {
        return "lifetime.persistence.Account[ id=" + id + " ]";
    }


}