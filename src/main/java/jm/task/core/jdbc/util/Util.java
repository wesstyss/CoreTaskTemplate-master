package jm.task.core.jdbc.util;

import jm.task.core.jdbc.Config;
import jm.task.core.jdbc.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util extends Config {
    private static Util instance;
    private static Connection connect;
    String connectionString ="jdbc:mysql://" + dbHost + ":" + dbPort + "/" +
            dbName + "?autoReconnect=true&useSSL=false";

    private Util()  {
        try{
        if (connect == null || connect.isClosed()) {
            connect = DriverManager.getConnection(connectionString, dbUser, dbPass);
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
         return connect;
    }

    public static Util getInstance(){
        if (instance == null){
            instance = new Util();
        }
        return instance;
     }
}
