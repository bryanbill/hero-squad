package com.minty.dao;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Hero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.*;

class HeroDaoTest {
    Connection connection = new Db().connect();
    Seeder seeder = new Seeder();

    HeroDao heroDao = new HeroDao();
    @BeforeEach
    void setUp() {
        seeder.seedDb();
    }

    @AfterEach
    void tearDown() {
        seeder.clearDb();
    }


    @Test
    void createHero() {
        heroDao.createHero(connection, new Hero(1,"Superman", "Super Strength", "Kryptonite", 1));
        assertEquals(1, heroDao.getAllHeroes(connection).size());
    }

    @Test
    void deleteHero() {
        heroDao.createHero(connection, new Hero(1,"Superman", "Super Strength", "Kryptonite", 1));
        heroDao.deleteHero(connection, 1);
        assertNull(heroDao.getHero(connection, 1));
    }

    @Test
    void getHero() {
        heroDao.createHero(connection, new Hero(1,"Superman", "Super Strength", "Kryptonite", 1));
        assertEquals("Superman", heroDao.getHero(connection, 1).getName());
    }

    @Test
    void getAllHeroes() {
        heroDao.createHero(connection, new Hero(1,"Superman", "Super Strength", "Kryptonite", 1));
        heroDao.createHero(connection, new Hero(2,"Batman", "Joker", "Speed", 2));
        assertEquals(2, heroDao.getAllHeroes(connection).size());
    }

    @Test
    void getHeroBySquadId() {
        heroDao.createHero(connection, new Hero(1,"Superman", "Super Strength", "Kryptonite", 1));
        heroDao.createHero(connection, new Hero(2,"Batman", "Joker", "Speed", 2));
        assertEquals(1, heroDao.getHeroBySquadId(connection, 1).getId());
    }
}