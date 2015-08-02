/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.persistence.Photo;

/**
 *
 * @author zua
 */
@Stateless
public class PhotoController {

    private static final String USERNAME = "username";
    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    public Photo getPhoto(String username) {
        Query q = em.createNamedQuery("Photo.findByUsername", Photo.class);
        q.setParameter(USERNAME, username);
        List<Photo> photos = q.getResultList();
        if (!photos.isEmpty()) {
            return photos.get(0);
        }
        return null;

    }

    public void addPhoto(String username, byte[] b) {
        Photo p = new Photo();
        p.setImage(b);
        p.setUsername(username);
        deleteAllPhotos(username);
        em.persist(p);
    }

    private void deleteAllPhotos(String username) {
        Query q = em.createNamedQuery("Photo.findByUsername", Photo.class);
        q.setParameter(USERNAME, username);
        List<Photo> photos = q.getResultList();
        for (Photo p : photos) {
            em.remove(p);
        }
    }

}
