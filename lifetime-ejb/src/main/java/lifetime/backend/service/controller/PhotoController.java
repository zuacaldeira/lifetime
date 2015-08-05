/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.backend.interceptors.BooleanExceptionInterceptor;
import lifetime.backend.interceptors.ObjectExceptionInterceptor;
import lifetime.backend.persistence.Photo;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class PhotoController extends CrudController<Photo> {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     *
     * @param p
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean create(Photo p) {
        deleteAllPhotos(p.getUsername());
        em.persist(p);
        return true;
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    @Interceptors({ObjectExceptionInterceptor.class})
    public Photo read(String username) {
        Query q = em.createNamedQuery("Photo.findByUsername", Photo.class);
        q.setParameter(USERNAME, username);
        List<Photo> photos = q.getResultList();
        if (!photos.isEmpty()) {
            return photos.get(0);
        }
        return null;

    }

    private void deleteAllPhotos(String username) {
        Query q = em.createNamedQuery("Photo.findByUsername", Photo.class);
        q.setParameter(USERNAME, username);
        List<Photo> photos = q.getResultList();
        for (Photo p : photos) {
            em.remove(p);
        }
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean delete(String email) {
        if (hasPhoto(email)) {
            em.remove(read(email));
            return true;
        }
        return false;
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean update(Photo p) {
        em.merge(p);
        return true;
    }

    /**
     *
     * @param email
     * @return
     */
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasPhoto(String email) {
        return read(email) != null;
    }

}
