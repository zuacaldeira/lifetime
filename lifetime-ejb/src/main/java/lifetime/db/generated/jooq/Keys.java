/**
 * This class is generated by jOOQ
 */
package lifetime.db.generated.jooq;


import javax.annotation.Generated;

import lifetime.db.generated.jooq.tables.Account;
import lifetime.db.generated.jooq.tables.Address;
import lifetime.db.generated.jooq.tables.SchemaVersion;
import lifetime.db.generated.jooq.tables.records.AccountRecord;
import lifetime.db.generated.jooq.tables.records.AddressRecord;
import lifetime.db.generated.jooq.tables.records.SchemaVersionRecord;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>lifetime</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = Identities0.IDENTITY_ACCOUNT;
    public static final Identity<AddressRecord, Integer> IDENTITY_ADDRESS = Identities0.IDENTITY_ADDRESS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = UniqueKeys0.KEY_ACCOUNT_PRIMARY;
    public static final UniqueKey<AddressRecord> KEY_ADDRESS_PRIMARY = UniqueKeys0.KEY_ADDRESS_PRIMARY;
    public static final UniqueKey<AddressRecord> KEY_ADDRESS_ID_UNIQUE = UniqueKeys0.KEY_ADDRESS_ID_UNIQUE;
    public static final UniqueKey<SchemaVersionRecord> KEY_SCHEMA_VERSION_PRIMARY = UniqueKeys0.KEY_SCHEMA_VERSION_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<AccountRecord, Integer> IDENTITY_ACCOUNT = createIdentity(Account.ACCOUNT, Account.ACCOUNT.ID);
        public static Identity<AddressRecord, Integer> IDENTITY_ADDRESS = createIdentity(Address.ADDRESS, Address.ADDRESS.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = createUniqueKey(Account.ACCOUNT, "KEY_account_PRIMARY", Account.ACCOUNT.ID);
        public static final UniqueKey<AddressRecord> KEY_ADDRESS_PRIMARY = createUniqueKey(Address.ADDRESS, "KEY_address_PRIMARY", Address.ADDRESS.ID);
        public static final UniqueKey<AddressRecord> KEY_ADDRESS_ID_UNIQUE = createUniqueKey(Address.ADDRESS, "KEY_address_id_UNIQUE", Address.ADDRESS.ID);
        public static final UniqueKey<SchemaVersionRecord> KEY_SCHEMA_VERSION_PRIMARY = createUniqueKey(SchemaVersion.SCHEMA_VERSION, "KEY_schema_version_PRIMARY", SchemaVersion.SCHEMA_VERSION.INSTALLED_RANK);
    }
}
