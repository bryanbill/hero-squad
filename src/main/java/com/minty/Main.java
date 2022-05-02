package com.minty;

import com.minty.database.Db;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Main {
    public static void main(String[] args) {
        Connection sql = new Db().connect();
    }
}