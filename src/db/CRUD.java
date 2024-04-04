package db;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

public interface CRUD {
    public void create(String tableName, String columnName, String values);
    public void delete(String tableName, String condition);
    public void update(String tableName, String modify, String condition);
}
