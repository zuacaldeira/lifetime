/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables.records;


import javax.annotation.Generated;

import lifetime.backend.persistence.jooq.tables.LifetimeOrg;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


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
public class LifetimeOrgRecord extends UpdatableRecordImpl<LifetimeOrgRecord> implements Record5<Integer, String, Integer, Integer, Integer> {

    private static final long serialVersionUID = 1633377987;

    /**
     * Setter for <code>lifetime.lifetime_org.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>lifetime.lifetime_org.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>lifetime.lifetime_org.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>lifetime.lifetime_org.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>lifetime.lifetime_org.account_id</code>.
     */
    public void setAccountId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>lifetime.lifetime_org.account_id</code>.
     */
    public Integer getAccountId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>lifetime.lifetime_org.address_id</code>.
     */
    public void setAddressId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>lifetime.lifetime_org.address_id</code>.
     */
    public Integer getAddressId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>lifetime.lifetime_org.photo_id</code>.
     */
    public void setPhotoId(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>lifetime.lifetime_org.photo_id</code>.
     */
    public Integer getPhotoId() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, Integer, Integer, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, Integer, Integer, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return LifetimeOrg.LIFETIME_ORG.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return LifetimeOrg.LIFETIME_ORG.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return LifetimeOrg.LIFETIME_ORG.ACCOUNT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return LifetimeOrg.LIFETIME_ORG.ADDRESS_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return LifetimeOrg.LIFETIME_ORG.PHOTO_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getAccountId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getAddressId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getPhotoId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeOrgRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeOrgRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeOrgRecord value3(Integer value) {
        setAccountId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeOrgRecord value4(Integer value) {
        setAddressId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeOrgRecord value5(Integer value) {
        setPhotoId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LifetimeOrgRecord values(Integer value1, String value2, Integer value3, Integer value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LifetimeOrgRecord
     */
    public LifetimeOrgRecord() {
        super(LifetimeOrg.LIFETIME_ORG);
    }

    /**
     * Create a detached, initialised LifetimeOrgRecord
     */
    public LifetimeOrgRecord(Integer id, String name, Integer accountId, Integer addressId, Integer photoId) {
        super(LifetimeOrg.LIFETIME_ORG);

        set(0, id);
        set(1, name);
        set(2, accountId);
        set(3, addressId);
        set(4, photoId);
    }
}
