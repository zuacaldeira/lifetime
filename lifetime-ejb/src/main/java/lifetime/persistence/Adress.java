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
 *
 * @author zua
 */
@Entity
@Table(name = "Adress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adress.findAll", query = "SELECT a FROM Adress a"),
    @NamedQuery(name = "Adress.findById", query = "SELECT a FROM Adress a WHERE a.id = :id"),
    @NamedQuery(name = "Adress.findByUsername", query = "SELECT a FROM Adress a WHERE a.username = :username"),
    @NamedQuery(name = "Adress.findByStreet", query = "SELECT a FROM Adress a WHERE a.street = :street"),
    @NamedQuery(name = "Adress.findByDoor", query = "SELECT a FROM Adress a WHERE a.door = :door"),
    @NamedQuery(name = "Adress.findByFloor", query = "SELECT a FROM Adress a WHERE a.floor = :floor"),
    @NamedQuery(name = "Adress.findByPostalCode", query = "SELECT a FROM Adress a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "Adress.findByLocality", query = "SELECT a FROM Adress a WHERE a.locality = :locality"),
    @NamedQuery(name = "Adress.findByRegion", query = "SELECT a FROM Adress a WHERE a.region = :region"),
    @NamedQuery(name = "Adress.findByCountry", query = "SELECT a FROM Adress a WHERE a.country = :country")})
public class Adress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 255)
    @Column(name = "street")
    private String street;
    @Size(max = 45)
    @Column(name = "door")
    private String door;
    @Size(max = 45)
    @Column(name = "floor")
    private String floor;
    @Size(max = 45)
    @Column(name = "postal-code")
    private String postalCode;
    @Size(max = 45)
    @Column(name = "locality")
    private String locality;
    @Size(max = 45)
    @Column(name = "region")
    private String region;
    @Size(max = 45)
    @Column(name = "country")
    private String country;

    public Adress() {
    }

    public Adress(Integer id) {
        this.id = id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        if (!(object instanceof Adress)) {
            return false;
        }
        Adress other = (Adress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lifetime.persistence.Adress[ id=" + id + " ]";
    }
    
}
