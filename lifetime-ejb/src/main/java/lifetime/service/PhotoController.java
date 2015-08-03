/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.interceptors.BooleanExceptionInterceptor;
import lifetime.interceptors.ObjectExceptionInterceptor;
import lifetime.persistence.Photo;

/**
 *
 * @author zua
 */
@Stateless
public class PhotoController extends CrudController<Photo> {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean create(Photo p) {
        deleteAllPhotos(p.getUsername());
        em.persist(p);
        return true;
    }

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

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean delete(String email) {
        if (hasPhoto(email)) {
            em.remove(read(email));
            return true;
        }
        return false;
    }

    @Override
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean update(Photo p) {
        em.merge(p);
        return true;
    }

    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean hasPhoto(String email) {
        return read(email) != null;
    }

}
