package db;

public class Queries {
    public static String sqlSelectAllRecords(String tableName) {
        return "select * from " + tableName;
    }

    public static String sqlSelectAll(String tableName, String columnName) {
        return "select all " + columnName + " from " + tableName;
    }

    public static String sqlSelectAllWhere(String tableName, String columnName, String condition) {
        return "select all " + columnName + " from " + tableName + " where " + condition;
    }

    public static String sqlDelete(String tableName, String condition) {
        return "delete from " + tableName + " where " + condition;
    }

    public static String sqlUpdate(String tableName, String modify, String condition) {
        return "update " + tableName + " set " + modify + " where " + condition;
    }

    public static String sqlInsertInto(String tableName, String columnName, String values) {
        return "insert into " + tableName + " (" + columnName + ") " + " values (" + values + ")";
    }
}
