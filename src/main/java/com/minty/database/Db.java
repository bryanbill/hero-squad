package com.minty.database;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Db {
    /**
     * @return the sql2o
     */
    public Connection connect() {
        try{
            String connString = "jdbc:postgresql://localhost:5432/minty";
            String user = "bill";
            String password = "<cocoginger45";
            return new Sql2o(connString, user, password).open();
        }catch(Exception e){
            throw new RuntimeException("Could not connect to database", e);
        }
    }


}
