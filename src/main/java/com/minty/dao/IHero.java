package com.minty.dao;

import com.minty.models.Hero;
import org.sql2o.Connection;

import java.util.List;

public interface IHero {
    void createHero(Connection sql, Hero hero);

    void deleteHero(Connection sql, int id);

    void updateHero(Connection sql, Hero hero);

    Hero getHero(Connection sql, int id);

    List<Hero> getAllHeroes(Connection sql);

    Hero getHeroBySquadId(Connection sql, int squadId);


}
