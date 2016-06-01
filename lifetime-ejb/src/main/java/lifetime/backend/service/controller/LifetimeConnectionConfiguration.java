/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import org.jooq.util.jaxb.Configuration;

/**
 *
 * @author zuacaldeira
 */
class LifetimeConnectionConfiguration extends Configuration {

    protected static final String EMAIL = "email";
    protected static final String DB_URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";
    protected static final String DB_USER = "zua";
    protected static final String DB_PASSWORD = "unicidade";

    public LifetimeConnectionConfiguration() {
    }

}
