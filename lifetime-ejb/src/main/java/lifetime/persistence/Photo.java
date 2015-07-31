/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.persistence;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "Photo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Photo.findAll", query = "SELECT p FROM Photo p"),
    @NamedQuery(name = "Photo.findById", query = "SELECT p FROM Photo p WHERE p.id = :id"),
    @NamedQuery(name = "Photo.findByUsername", query = "SELECT p FROM Photo p WHERE p.username = :username")})
public class Photo implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Photo() {
    }

    public Photo(Integer id) {
        this.id = id;
    }

    public Photo(byte[] image) {
        this.image = image;
    }

    public Photo(Integer id, String username, byte[] image) {
        this.image = image;
        this.username = username;
        this.id = id;
    }

    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    
    @Override
    public String toString() {
        return "lifetime.persistence.Photo[ id=" + id + " ]";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Arrays.hashCode(this.image);
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Photo other = (Photo) obj;
        if (!Arrays.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    
    

}
