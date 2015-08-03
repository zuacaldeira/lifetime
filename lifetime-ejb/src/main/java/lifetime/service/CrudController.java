/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

/**
 *
 * @author zua
 * @param <T> A JPA entity type.
 */
public abstract class CrudController<T> {

    public abstract boolean  create(T t);

    public abstract T        read(String username);

    public abstract boolean  update(T t);

    public abstract boolean  delete(String username);
}
