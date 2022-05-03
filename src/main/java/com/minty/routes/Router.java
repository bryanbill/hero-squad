package com.minty.routes;

import com.minty.dao.HeroDao;
import com.minty.dao.SquadDao;
import com.minty.database.Db;
import com.minty.models.Hero;
import com.minty.models.Squad;
import org.sql2o.Connection;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.SparkBase.staticFileLocation;

public class Router {

    public static void run() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        int port;
        if (processBuilder.environment().get("PORT") != null) {
            port = Integer.parseInt(processBuilder.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        staticFileLocation("/public");
        // Create a connection to the database
        Connection sql = new Db().connect();

        // Create a new HeroDao object
        HeroDao heroDao = new HeroDao();

        // Create a new SquadsDao object
        SquadDao squadsDao = new SquadDao();

        get("/", (req, res) -> {
            return new ModelAndView(new HashMap<>(), "landing.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/hero", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", squadsDao.getAllSquads(sql));

            return new ModelAndView(model, "create_hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/squad", (req, res) -> {
            return new ModelAndView(new HashMap<>(), "create_squad.hbs");
        }, new HandlebarsTemplateEngine());

        // Get all heroes
        get("/heroes", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("heroes", heroDao.getAllHeroes(sql));

            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        // Get all squads
        get("/squads", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", squadsDao.getAllSquads(sql));
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        // Get a hero by id
        get("/heroes/:id", (req, res) -> {
            return heroDao.getHero(sql, Integer.parseInt(req.params(":id")));
        });

        // Get a squad by id
        get("/squads/:id", (req, res) -> {
            return squadsDao.getSquad(sql, Integer.parseInt(req.params(":id")));
        });

        // Get a hero by squad id
        get("/squads/:id/heroes", (req, res) -> {
            return heroDao.getHeroBySquadId(sql, Integer.parseInt(req.params(":id")));
        });

        // Create a hero
        post("/heroes", (req, res) -> {
            Hero hero = new Hero(0, req.queryParams("name"), req.queryParams("power"), req.queryParams("weakness"), Integer.parseInt(req.queryParams("squadId")));
            heroDao.createHero(sql, hero);
            res.redirect("/heroes");
            return hero;
        });

        // Create a squad
        post("/squads", (req, res) -> {
            Squad squad = new Squad(0, req.queryParams("name"), req.queryParams("cause"), Integer.parseInt(req.queryParams("maxsize")), LocalDateTime.now());
            squadsDao.createSquad(sql, squad);
            res.redirect("/squads");
            return squad;
        });

        // Update a hero
        post("/heroes/:id", (req, res) -> {
            Hero hero = new Hero(Integer.parseInt(req.params(":id")), req.queryParams("name"), req.queryParams("power"), req.queryParams("weakness"), Integer.parseInt(req.queryParams("squadId")));
            heroDao.updateHero(sql, hero);
            return hero;
        });

        // Update a squad
        post("/squads/:id", (req, res) -> {
            Squad squad = new Squad(Integer.parseInt(req.params(":id")), req.queryParams("name"), req.queryParams("cause"), Integer.parseInt(req.queryParams("maxsize")), LocalDateTime.now());
            squadsDao.updateSquad(sql, squad);
            return squad;
        });

        // Delete a hero
        post("/heroes/:id/delete", (req, res) -> {
            heroDao.deleteHero(sql, Integer.parseInt(req.params(":id")));
            return "Hero deleted";
        });

        // Delete a squad
        post("/squads/:id/delete", (req, res) -> {
            squadsDao.deleteSquad(sql, Integer.parseInt(req.params(":id")));
            return "Squad deleted";
        });

        // Delete a hero by id
        delete("/heroes/:id/delete", (req, res) -> {
            heroDao.deleteHero(sql, Integer.parseInt(req.params(":id")));
            res.redirect("/heroes");
            return "Hero deleted";
        });

        // Delete a squad by id
        delete("/squads/:id/delete", (req, res) -> {
            squadsDao.deleteSquad(sql, Integer.parseInt(req.params(":id")));
            res.redirect("/squads");
            return "Squad deleted";
        });

    }
}
