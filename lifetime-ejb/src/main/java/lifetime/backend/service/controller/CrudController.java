/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 * @param <T> A JPA entity type.
 */
public abstract class CrudController<T> {

    /**
     *
     * @param t
     * @return
     */
    public abstract boolean  create(T t);

    /**
     *
     * @param username
     * @return
     */
    public abstract T        read(String username);

    /**
     *
     * @param t
     * @return
     */
    public abstract boolean  update(T t);

    /**
     *
     * @param username
     * @return
     */
    public abstract boolean  delete(String username);
}
