package com.minty;

import com.minty.dao.HeroDao;
import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Hero;
import org.sql2o.Connection;
import static  spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        Connection sql = new Db().connect();
        new Seeder().seedDb();

        HeroDao heroDao = new HeroDao();

        get("/", (req, res) -> {
            heroDao.createHero(sql, new Hero(1,"Superman", "Super Strength", "Kryptonite", 1));

            System.out.println(heroDao.getHero(sql, 2).getName());
            return "Hello World";
        });
    }

    public  void handler() {

    }
}