/**
 * This class is generated by jOOQ
 */
package lifetime.backend.persistence.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import lifetime.backend.persistence.jooq.Keys;
import lifetime.backend.persistence.jooq.Lifetime;
import lifetime.backend.persistence.jooq.tables.records.KnowledgeUnitRecord;

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
public class KnowledgeUnit extends TableImpl<KnowledgeUnitRecord> {

    private static final long serialVersionUID = 1194260221;

    /**
     * The reference instance of <code>lifetime.knowledge_unit</code>
     */
    public static final KnowledgeUnit KNOWLEDGE_UNIT = new KnowledgeUnit();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<KnowledgeUnitRecord> getRecordType() {
        return KnowledgeUnitRecord.class;
    }

    /**
     * The column <code>lifetime.knowledge_unit.id</code>.
     */
    public final TableField<KnowledgeUnitRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.knowledge_unit.know_how_unit_id</code>.
     */
    public final TableField<KnowledgeUnitRecord, Integer> KNOW_HOW_UNIT_ID = createField("know_how_unit_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>lifetime.knowledge_unit.lecture_id</code>.
     */
    public final TableField<KnowledgeUnitRecord, Integer> LECTURE_ID = createField("lecture_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>lifetime.knowledge_unit</code> table reference
     */
    public KnowledgeUnit() {
        this("knowledge_unit", null);
    }

    /**
     * Create an aliased <code>lifetime.knowledge_unit</code> table reference
     */
    public KnowledgeUnit(String alias) {
        this(alias, KNOWLEDGE_UNIT);
    }

    private KnowledgeUnit(String alias, Table<KnowledgeUnitRecord> aliased) {
        this(alias, aliased, null);
    }

    private KnowledgeUnit(String alias, Table<KnowledgeUnitRecord> aliased, Field<?>[] parameters) {
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
    public Identity<KnowledgeUnitRecord, Integer> getIdentity() {
        return Keys.IDENTITY_KNOWLEDGE_UNIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<KnowledgeUnitRecord> getPrimaryKey() {
        return Keys.KEY_KNOWLEDGE_UNIT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<KnowledgeUnitRecord>> getKeys() {
        return Arrays.<UniqueKey<KnowledgeUnitRecord>>asList(Keys.KEY_KNOWLEDGE_UNIT_PRIMARY, Keys.KEY_KNOWLEDGE_UNIT_ID_UNIQUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<KnowledgeUnitRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<KnowledgeUnitRecord, ?>>asList(Keys.FK_KNOWLEDGE_UNIT_KNOW_HOW_UNIT1, Keys.FK_KNOWLEDGE_UNIT_LECTURE1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KnowledgeUnit as(String alias) {
        return new KnowledgeUnit(alias, this);
    }

    /**
     * Rename this table
     */
    public KnowledgeUnit rename(String name) {
        return new KnowledgeUnit(name, null);
    }
}