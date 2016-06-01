/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

/**
 * Implementation of a generic CRUD controller. Provides methods with default
 * implementations of basic CRUD operations, as defined by the interface type
 * {@code CRUDController<T>}.
 *
 * @author zuacaldeira
 * @param <T> Entity type corresponding to a database table.
 */
public abstract class CRUDControllerImpl<T> implements CRUDController<T> {

    protected static final String EMAIL = "email";
    protected static final String DB_URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";
    protected static final String DB_USER = "zua";
    protected static final String DB_PASSWORD = "unicidade";

}
