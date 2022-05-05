package com.minty.database;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Db {
    /**
     * Connect to the database.
     *
     * @return Connection
     */
    public Connection connect() {

        try {
            String connString = "jdbc:postgresql://ec2-35-168-194-15.compute-1.amazonaws.com:5432/d95g7pn9ggh4n5";
            String user = "jdmptvfntsrceu";
            String password = "e16fa901f5d45c21ce13dae0541a118aeb4fc13ccaf6a6fcc6ad35bfc0fa00cb";

            return new Sql2o(connString, user, password).open();
        } catch (Exception e) {
            throw new RuntimeException("Could not connect to database", e);
        }
    }

    public void close(Connection conn) {
        conn.close();
    }

}
