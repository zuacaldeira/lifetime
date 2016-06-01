/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

/**
 *
 * @author zuacaldeira
 */
interface CRUDController<T> {
    public T create(T item);
    public T read(Integer id);
    public T update(T item);
    public T delete(Integer id);
}
