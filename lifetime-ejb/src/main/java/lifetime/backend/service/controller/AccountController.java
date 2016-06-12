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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lifetime.backend.persistence.jooq.Tables;
import lifetime.backend.persistence.jooq.tables.Account;
import lifetime.backend.persistence.jooq.tables.LifetimeUser;
import lifetime.backend.persistence.jooq.tables.records.AccountRecord;
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
    public boolean register(String firstname, String lastname, String email, String password, String language, Date birthdate, String birthPlace) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            DSL.using(conn, SQLDialect.MYSQL)
                    .insertInto(Account.ACCOUNT, Account.ACCOUNT.EMAIL, Account.ACCOUNT.PASSWORD)
                    .values(email, password)
                    .execute();
            AccountRecord record = read(email);
            DSL.using(conn, SQLDialect.MYSQL)
                    .insertInto(LifetimeUser.LIFETIME_USER, LifetimeUser.LIFETIME_USER.FIRST_NAME, LifetimeUser.LIFETIME_USER.LAST_NAME, LifetimeUser.LIFETIME_USER.ACCOUNT_ID)
                    .values(firstname, lastname, record.getId())
                    .execute();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public AccountRecord read(String email) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            AccountRecord record = DSL.using(conn, SQLDialect.MYSQL)
                    .selectFrom(Tables.ACCOUNT).where(Tables.ACCOUNT.EMAIL.equal(email)).fetchOne();
            Logger.getLogger(AccountController.class.getName()).log(Level.INFO, "Found record " + record.get(Account.ACCOUNT.EMAIL));
            
            return record;
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
}
