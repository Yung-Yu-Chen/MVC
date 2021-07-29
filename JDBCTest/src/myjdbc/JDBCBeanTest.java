package myjdbc;

import bean.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class JDBCBeanTest {
    public static final String COM_MYSQL_CJ_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/mytest";
    public static final String ACCOUNT = "root";
    public static final String PASSWORD = "root";
    public static final String SQL = "SELECT id,name,password,email,birthday FROM t_user";


    @Test
    public void testSelect() throws ClassNotFoundException, SQLException {
        Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
        //driver
        Connection connection = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
        //prepare
        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        //execute
        ResultSet resultSet = preparedStatement.executeQuery();
        //將回查結果封裝到bean的class中
        List<User> list = new ArrayList<>();
        while( resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setDate(resultSet.getDate("birthday"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            list.add(user);
        }
        for (User user: list) {
            System.out.println(user);
            System.out.println("---------------------");
        }
    }

    @Test
    public void testSelectTryCatch() {
        Connection connection =null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;;
        try {
            Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
            //driver
            connection = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
            //prepare
            preparedStatement = connection.prepareStatement(SQL);
            //execute
            resultSet = preparedStatement.executeQuery();
            //將回查結果封裝到bean的class中
            List<User> list = new ArrayList<>();
            while( resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("birthday"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                list.add(user);
            }
            for (User user: list) {
                System.out.println(user);
                System.out.println("---------------------");
            }

        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    @Test
    public void testSelectTryCatchResource() {
        try {
            Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
             ResultSet resultSet = preparedStatement.executeQuery()){
            //將回查結果封裝到bean的class中
            List<User> list = new ArrayList<>();
            while( resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setEmail(resultSet.getString("email"));
                user.setDate(resultSet.getDate("birthday"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                list.add(user);
            }
            for (User user: list) {
                System.out.println(user);
                System.out.println("---------------------");
            }

        } catch (SQLException  throwable) {
            throwable.printStackTrace();
        }

    }

}
