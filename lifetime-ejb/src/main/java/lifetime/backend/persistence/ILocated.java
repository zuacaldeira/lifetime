/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.persistence;

/**
 *
 * @author zua
 */
public interface ILocated {

    public double getLatitude();

    public double getLongitude();

    public double getAzimuth();

    public void setLatitude(double latitude);

    public void setLongitude(double longitude);

    public void setAzimuth(double latitude);
}
