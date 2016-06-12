/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifetime.backend.service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SortOrder;
import org.jooq.Table;
import org.jooq.UpdatableRecord;

/**
 * Implementation of a generic CRUD controller. Provides methods with default
 * implementations of basic CRUD operations, as defined by the interface type
 * {@code CRUDRepositoryInterface<T>}.
 *
 * @author zuacaldeira
 * @param <R> Entity type corresponding to a database table.
 */
public abstract class AbstractCRUDRepository<R extends UpdatableRecord, ID, P> {

    protected static final String EMAIL = "email";
    protected static final String DB_URL = "jdbc:mysql://localhost:3306/lifetime?zeroDateTimeBehavior=convertToNull";
    protected static final String DB_USER = "zua";
    protected static final String DB_PASSWORD = "unicidade";

    protected final DSLContext dslContext;
    private final Table<R> table;
    private final Field<ID> idField;
    private final Class<P> pojoClass;

    public AbstractCRUDRepository(DSLContext dslContext, Table<R> table, Field<ID> idField, Class<P> pojoClass) {
        this.dslContext = dslContext;
        this.table = table;
        this.pojoClass = pojoClass;
        this.idField = idField;
    }

    public List<P> getPage(Integer page, Integer pageSize, String sortField, String sortOrder, Map<String, Object> filterQuery) {
        String sortFieldName = sortField.replaceAll("([A-Z])", "_$1").toLowerCase();
        return dslContext.selectFrom(table)
                .where(filter(filterQuery != null ? filterQuery : new HashMap<>()))
                .orderBy(table.field(sortFieldName).sort(SortOrder.valueOf(sortOrder)))
                .limit(pageSize)
                .offset((page - 1) * pageSize)
                .fetchInto(pojoClass);
    }

    public P getById(ID id) {
        return getRecordById(id).into(pojoClass);
    }

    public P update(ID id, P pojo) {
        R record = getRecordById(id);
        record.from(pojo);
        record.store();
        return record.into(pojoClass);
    }

    // ...
    protected Condition filter(Map<String, Object> filterQuery) {
        return null;
    }

    // ...

    private R getRecordById(ID id) {
        return dslContext.fetchOne(table, idField.eq(id));
    }
}
