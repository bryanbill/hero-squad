package com.minty;

import com.minty.dao.HeroDao;
import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Hero;
import org.sql2o.Connection;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        Connection sql = new Db().connect();
        new Seeder().seedDb();

        HeroDao heroDao = new HeroDao();


        get("/", (req, res) -> {
            return "Hello World";
        });
    }

}