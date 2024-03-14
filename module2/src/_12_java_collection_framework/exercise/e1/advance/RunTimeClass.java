package _12_java_collection_framework.exercise.e1.advance;

import java.util.Map;

public class RunTimeClass {
    private String entityName;
    private Map<String, String> fields;
    private String searchBy;
    private Map<String, String> sort;

    private Class<?> cls;

    public RunTimeClass() {
    }

    public RunTimeClass(String entityName, Map<String, String> fields, String searchBy, Map<String, String> sort, Class<?> cls) {
        this.entityName = entityName;
        this.fields = fields;
        this.searchBy = searchBy;
        this.sort = sort;
        this.cls = cls;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public Map<String, String> getSort() {
        return sort;
    }

    public void setSort(Map<String, String> sort) {
        this.sort = sort;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }
}
