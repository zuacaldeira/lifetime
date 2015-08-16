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
public class Located implements ILocated {

    private double latitude;
    private double longitude;
    private double azimuth;

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public double getAzimuth() {
        return azimuth;
    }

    @Override
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

}
