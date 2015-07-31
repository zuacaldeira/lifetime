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
@Table(name = "Address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
    @NamedQuery(name = "Address.findByUsername", query = "SELECT a FROM Address a WHERE a.username = :username"),
    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street"),
    @NamedQuery(name = "Address.findByDoor", query = "SELECT a FROM Address a WHERE a.door = :door"),
    @NamedQuery(name = "Address.findByFloor", query = "SELECT a FROM Address a WHERE a.floor = :floor"),
    @NamedQuery(name = "Address.findByPostalCode", query = "SELECT a FROM Address a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "Address.findByLocality", query = "SELECT a FROM Address a WHERE a.locality = :locality"),
    @NamedQuery(name = "Address.findByRegion", query = "SELECT a FROM Address a WHERE a.region = :region"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Internal persistence id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    /**
     * Username.
     */
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    /**
     * Street name.
     */
    @Size(max = 255)
    @Column(name = "street")
    private String street;
    /**
     * Door.
     */
    @Size(max = 45)
    @Column(name = "door")
    private String door;
    /**
     * Floor.
     */
    @Size(max = 45)
    @Column(name = "floor")
    private String floor;
    /**
     * Postal code.
     */
    @Size(max = 45)
    @Column(name = "postal_code")
    private String postalCode;
    /**
     * Locality.
     */
    @Size(max = 45)
    @Column(name = "locality")
    private String locality;
    @Size(max = 45)
    @Column(name = "region")
    private String region;
    @Size(max = 45)
    @Column(name = "country")
    private String country;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String username, String street, String door, String floor, String postalCode, String locality, String region, String country) {
        this.id = id;
        this.username = username;
        this.street = street;
        this.door = door;
        this.floor = floor;
        this.postalCode = postalCode;
        this.locality = locality;
        this.region = region;
        this.country = country;
    }

    
    public Address(String street, String door, String floor, String postalCode, String locality, String region, String country) {
        this(null, null, street, door, floor, postalCode, locality, region, country);
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String SEPARATOR = " * ";
        StringBuilder builder = new StringBuilder();
        if (street != null) {
            builder.append(street);
            builder.append(", ");
        }
        if (door != null) {
            builder.append(door);
            builder.append(SEPARATOR);
        }
        if (postalCode != null) {
            builder.append(postalCode);
            builder.append(" ");
        }
        if (locality != null) {
            builder.append(locality);
            builder.append(SEPARATOR);
        }
        if (country != null) {
            builder.append(country);
        }
        return builder.toString();
    }

}
