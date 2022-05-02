package com.minty.dao;

import com.minty.database.Db;
import com.minty.database.Seeder;
import com.minty.models.Squad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SquadDaoTest {
    Connection connection = new Db().connect();

    @BeforeEach
    void setUp() {
        new Seeder().seedDb();
    }

    @AfterEach
    void tearDown() {
        new Seeder().clearDb();
    }

    @Test
    void createSquad() {
        SquadDao squadDao = new SquadDao();
        squadDao.createSquad(connection, new Squad(1, "The Avengers", "Earth's Mightiest Heroes", 10, LocalDateTime.now()));
        assertEquals(1, squadDao.getAllSquads(connection).size());
    }

    @Test
    void deleteSquad() {
        SquadDao squadDao = new SquadDao();
        squadDao.createSquad(connection, new Squad(1, "The Avengers", "Earth's Mightiest Heroes", 10, LocalDateTime.now()));
        squadDao.deleteSquad(connection, 1);
        assertTrue(squadDao.getAllSquads(connection).isEmpty());
    }

    @Test
    void getSquad() {
        SquadDao squadDao = new SquadDao();
        squadDao.createSquad(connection, new Squad(1, "The Avengers", "Earth's Mightiest Heroes", 10, LocalDateTime.now()));
        assertEquals("The Avengers", squadDao.getSquad(connection, 1).getSquadName());
    }

    @Test
    void getAllSquads() {
        SquadDao squadDao = new SquadDao();
        squadDao.createSquad(connection, new Squad(1, "The Avengers", "Earth's Mightiest Heroes", 10, LocalDateTime.now()));
        squadDao.createSquad(connection, new Squad(2, "The Justice League", "Justice League of America", 10, LocalDateTime.now()));
        assertEquals(2, squadDao.getAllSquads(connection).size());
    }
}