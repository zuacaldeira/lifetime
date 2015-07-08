/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.business.logic;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.api.PostMethods;
import facebook4j.conf.ConfigurationBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author lifetime
 */
@Stateless
@LocalBean
public class FacebookService {
    
    private Facebook facebook;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    private void initConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("539050279566424")
                .setOAuthAppSecret("34331877a5d1bcc8fc11d4ab90fd46b0")
                //.setOAuthAccessToken("alfarroba")
                .setOAuthPermissions("email,publish_stream,public_profile,user_friends");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
    
    public void post(String post) {
        PostMethods posts = facebook.posts();
        try {
            ResponseList<Post> allPosts = posts.getPosts();
            for(Post p: allPosts) {
                System.out.println(p.toString());
            }
        } catch (FacebookException ex) {
            Logger.getLogger(FacebookService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
