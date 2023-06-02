package com.ls.dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lee
 * @Date 2023/3/23 17:52
 */
public class BaseDao<T> {

    private static final BasicDataSource DATA_SOURCE;

    static {
        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName("com.mysql.jdbc.Driver");
        DATA_SOURCE.setUrl("jdbc:mysql://localhost:3306/ls");
        DATA_SOURCE.setUsername("root");
        DATA_SOURCE.setPassword("L12345.");
    }

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(DATA_SOURCE);

    private Class<T> beanClass;

    public BaseDao(){
        beanClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void add(T bean){
        Field[] declaredFields = beanClass.getDeclaredFields();

        //INSERT INTO `ls`.`user` (`name`, `age`) VALUES ('lee', 18);
        StringBuilder sql = new StringBuilder()
                .append("insert into ")
                .append(beanClass.getSimpleName())
                .append(" values(");
        for (int i = 0; i < declaredFields.length; i++) {
            sql.append("?");
            if (i < declaredFields.length - 1){
                sql.append(",");
            }
        }
        sql.append(")");

        //获得bean字段的值（要插入的记录）
        List<Object> paramList = new ArrayList<>();
        try {
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object o = declaredField.get(bean);
                paramList.add(o);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int size = paramList.size();
        Object[] objects = paramList.toArray(new Object[size]);
        int update = jdbcTemplate.update(sql.toString(), objects);
        System.out.println(update);
    }

}
