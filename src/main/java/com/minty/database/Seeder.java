package com.minty.database;

import org.sql2o.Connection;

public class Seeder extends Db {
    public void seedDb() {
       try{
           Connection conn = connect();
           //Create Tables
           conn.createQuery("CREATE TABLE IF NOT EXISTS heroes (id SERIAL PRIMARY KEY, heroName VARCHAR(255), power VARCHAR(255), weakness VARCHAR(255), squadId INTEGER)").executeUpdate();
           conn.createQuery("CREATE TABLE IF NOT EXISTS squads (id SERIAL PRIMARY KEY, squadName VARCHAR(255), cause VARCHAR(255), maxSize INTEGER, createdAt VARCHAR(100))").executeUpdate();

       }catch (Exception e){
           throw new RuntimeException("Could not connect to database", e);
       }
    }
    public void clearDb() {
        Connection conn = connect();
       //Drop Tables
        conn.createQuery("DROP TABLE IF EXISTS heroes").executeUpdate();
        conn.createQuery("DROP TABLE IF EXISTS squads").executeUpdate();
    }
}
