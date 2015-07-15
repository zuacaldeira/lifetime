/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.service;

import java.io.File;
import lifetime.persistence.UserAccount;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

/**
 *
 * @author zua
 */
public class Deployments {

    public static Archive getDeploymentLifetimeAccountService() {
        JavaArchive result = ShrinkWrap.create(JavaArchive.class, "test.jar")
                //.addAsLibraries(files)
                .addPackage(LifetimeAccountBusiness.class.getPackage().getName())
                .addPackage(UserAccount.class.getPackage().getName())
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"),
                        "META-INF/persistence.xml")
                .addAsResource(EmptyAsset.INSTANCE,
                        ArchivePaths.create("beans.xml"));
        return result;
    }
    
}
