/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import lifetime.backend.persistence.jooq.Keys;
import lifetime.backend.persistence.jooq.Lifetime;
import lifetime.backend.persistence.jooq.tables.records.LifetimeUserRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LifetimeUser extends TableImpl<LifetimeUserRecord> {

    private static final long serialVersionUID = 1726838439;

    /**
     * The reference instance of <code>lifetime.lifetime_user</code>
     */
    public static final LifetimeUser LIFETIME_USER = new LifetimeUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LifetimeUserRecord> getRecordType() {
        return LifetimeUserRecord.class;
    }

    /**
     * The column <code>lifetime.lifetime_user.id</code>.
     */
    public final TableField<LifetimeUserRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.lifetime_user.first_name</code>.
     */
    public final TableField<LifetimeUserRecord, String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    /**
     * The column <code>lifetime.lifetime_user.last_name</code>.
     */
    public final TableField<LifetimeUserRecord, String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

    /**
     * The column <code>lifetime.lifetime_user.address_id</code>.
     */
    public final TableField<LifetimeUserRecord, Integer> ADDRESS_ID = createField("address_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.lifetime_user.account_id</code>.
     */
    public final TableField<LifetimeUserRecord, Integer> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.lifetime_user.photo_id</code>.
     */
    public final TableField<LifetimeUserRecord, Integer> PHOTO_ID = createField("photo_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>lifetime.lifetime_user</code> table reference
     */
    public LifetimeUser() {
        this("lifetime_user", null);
    }

    /**
     * Create an aliased <code>lifetime.lifetime_user</code> table reference
     */
    public LifetimeUser(String alias) {
        this(alias, LIFETIME_USER);
    }

    private LifetimeUser(String alias, Table<LifetimeUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private LifetimeUser(String alias, Table<LifetimeUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Lifetime.LIFETIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LifetimeUserRecord, Integer> getIdentity() {
        return Keys.IDENTITY_LIFETIME_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LifetimeUserRecord> getPrimaryKey() {
        return Keys.KEY_LIFETIME_USER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LifetimeUserRecord>> getKeys() {
        return Arrays.<UniqueKey<LifetimeUserRecord>>asList(Keys.KEY_LIFETIME_USER_PRIMARY, Keys.KEY_LIFETIME_USER_ID_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LifetimeUserRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LifetimeUserRecord, ?>>asList(Keys.FK_LIFETIME_USER_ADDRESS1, Keys.FK_LIFETIME_USER_ACCOUNT1, Keys.FK_LIFETIME_USER_PHOTO1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeUser as(String alias) {
        return new LifetimeUser(alias, this);
    }

    /**
     * Rename this table
     */
    public LifetimeUser rename(String name) {
        return new LifetimeUser(name, null);
    }
}