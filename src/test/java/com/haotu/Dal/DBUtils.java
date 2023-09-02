package com.haotu.Dal;

import com.beust.jcommander.internal.Lists;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

class User {
    private long id;
    private String name;
    private int age;

    public User() {
    }

    public User(long id,  String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class DBUtils {

    private static JdbcTemplate jdbcTemplate;


    public static DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=UTC");
        return dataSource;
    }

    public static JdbcTemplate getJdbcTemplate() {
        DataSource dataSource = dataSource();
        if (jdbcTemplate != null) {
            return jdbcTemplate;
        }
        return new JdbcTemplate(dataSource);
    }

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        System.out.println(jdbcTemplate);
        List<User> users = Lists.newArrayList();
        jdbcTemplate.query("select * from db_user", (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            users.add(new User(id, name, age));
            return null;
        });
        System.out.println(users);
    }
}
