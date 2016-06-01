/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import lifetime.backend.interceptors.BooleanExceptionInterceptor;
import lifetime.backend.interceptors.ObjectExceptionInterceptor;
import lifetime.backend.persistence.jooq.tables.Account;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;
import lifetime.backend.util.SecurityRoles;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

/**
 *
 * @author <a href="mailto:zuacaldeira@gmail.com">Alexandre Caldeira</a>
 */
@Stateless
public class AccountController {

    private static final String EMAIL = "email";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";
    private static final String DB_USER = "zua";
    private static final String DB_PASSWORD = "unicidade";

    /**
     * Persistence Context.
     */
    @PersistenceContext(unitName = "lifetimePU")
    private EntityManager em;

    /**
     *
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     * @param language
     * @param birthdate
     * @param birthPlace
     * @return
     */
    @Interceptors({BooleanExceptionInterceptor.class})
    public boolean register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            DSL.using(conn, SQLDialect.MYSQL)
                    .insertInto(Account.ACCOUNT, Account.ACCOUNT.EMAIL, Account.ACCOUNT.PASSWORD)
                    .values(email, password)
                    .execute();

            /*DSL.using(conn, SQLDialect.MYSQL)
                    .insertInto(LifetimeUser.LIFETIME_USER, LifetimeUser.LIFETIME_USER.FIRST_NAME, LifetimeUser.LIFETIME_USER.LAST_NAME, LifetimeUser.LIFETIME_USER.ACCOUNT_ID)
                    .values(firstname, lastname, )
                    .execute();*/
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Account read(String email, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
