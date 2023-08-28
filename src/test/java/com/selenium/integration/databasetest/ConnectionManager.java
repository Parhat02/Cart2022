package com.selenium.integration.databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    //create a method to connect to database
    public static Connection connectToDatabaseServer(String dbUrl, String dbPort, String defaultDatabase,
                                                     String dbUsername, String dbPassword,
                                                     ConnectionType connectionType){
        //define a connection object instance
        Connection connection=null;
        String JTDS_Driver = "net.sourceforge.jtds.jdbc.Driver";
        String MYSQL_Driver = "com.mysql.cj.jdbc.Driver";
        switch (connectionType){
            case MSSQLSERVER:
                try {
                    Class.forName(JTDS_Driver); //initialize SQL Server driver
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Please check driver information");
                }
                String connectionUrl="jdbc:jtds:sqlserver://"+dbUrl+":"+dbPort+";DatabaseName="+ defaultDatabase;
                try {
                    connection= DriverManager.getConnection(connectionUrl,dbUsername,dbPassword);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case MYSQLServer:
                try {
                    Class.forName(MYSQL_Driver).newInstance(); //initialize MYSQL Driver
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Please check MYSQL Driver information");
                }
                String mysqlConnectionUrl="jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDatabase+"?useSSL=false";
                try {
                    connection=DriverManager.getConnection(mysqlConnectionUrl,dbUsername,dbPassword);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("You need to specify a database connection type MSSQL or MYSQL");
        }
        // Verify if the connection is established
        try {
            if (!connection.isClosed()){
                System.out.println("Database connection is established");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    // define a method to disconnect from database server
    public static void closeDatabaseConnection(Connection connection){
        try {
            if (connection.isClosed()){
                System.out.println("Connection has already disconnected");

            }
            else{
                connection.close();
                System.out.println("Disconnected from the database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
