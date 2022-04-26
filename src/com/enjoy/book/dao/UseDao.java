package com.enjoy.book.dao;


import com.enjoy.book.bean.User;
import com.enjoy.book.util.DBHelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UseDao {
    QueryRunner runner = new QueryRunner();

    public User getUser(String name, String pwd) throws SQLException {
        Connection conn = DBHelper.getConnection();

        String sql = "SELECT *FROM user WHERE name=? and pwd=? and state=1";
        User user = runner.query(conn, sql, new BeanHandler<User>(User.class), name, pwd);

        conn.close();


        return user;
    }

    public static void main(String[] args) {
        User user = null;
        try {
            user = new UseDao().getUser("super", "123");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(user);
    }

}
