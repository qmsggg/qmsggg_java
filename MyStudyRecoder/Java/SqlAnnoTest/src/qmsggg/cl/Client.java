package qmsggg.cl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        DaoBean bean = new DaoBean("1", "luohao", "12");
        System.out.println(assembleSqlFromObj(bean));
    }

    private static String assembleSqlFromObj(Object obj) {
        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuffer sql = new StringBuffer();

        String tableName = table.name();
        sql.append("select from " + tableName + " where 1=1");

        System.out.println("Fields: " + obj.getClass().getFields().toString());
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldMethod = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);

            Column column = field.getAnnotation(Column.class);
            if (column != null) {
                try {
                    Method method = obj.getClass().getMethod(fieldMethod);
                    String f = (String) method.invoke(obj);
                    if (f != null && !f.isEmpty()) {
                        sql.append(column.value() + f);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return sql.toString();
    }
}
