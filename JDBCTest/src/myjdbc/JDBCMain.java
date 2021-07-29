package myjdbc;

import java.sql.*;

public class JDBCMain {
    public static final String COM_MYSQL_CJ_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/mytest";
    public static final String ACCOUNT = "root";
    public static final String PASSWORD = "root";
    public static final String SQL = "SELECT id,name,password,email,birthday FROM t_user";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(COM_MYSQL_CJ_JDBC_DRIVER);
        //get connection
        Connection connection = DriverManager.getConnection(URL, ACCOUNT, PASSWORD);
        //prepare statement
        Statement statement = connection.createStatement();
        //get result
        ResultSet resultSet = statement.executeQuery(SQL);
        while(resultSet.next()){
            System.out.print( resultSet.getObject("id"));
            System.out.print( resultSet.getObject("name"));
            System.out.print( resultSet.getObject("password"));
            System.out.print( resultSet.getObject("birthday"));
            System.out.println("----------------------------------------------");
        }
        resultSet.close();

    }
}
