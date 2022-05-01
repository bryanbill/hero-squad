package com.minty.database;

import org.sql2o.Sql2o;

public class Db {
    /**
     * @return the sql2o
     */
    public Sql2o connect(){
        try{
            String connString = "jdbc:postgresql://localhost:5432/minty";
            String user = "postgres";
            String password = "postgres";
            return new Sql2o(connString, user, password);
        }catch(Exception e){
            throw new RuntimeException("Cannot connect to database", e);
        }
    }


}
