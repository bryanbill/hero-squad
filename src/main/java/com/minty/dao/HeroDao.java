package com.minty.dao;

import com.minty.models.Hero;
import org.sql2o.Connection;

import java.util.List;

public class HeroDao implements IHero {
    public void createHero(Connection sql, Hero hero) {
        try {
            sql.createQuery("INSERT INTO heroes (heroname, power, weakness, squadid) VALUES (:name, :power, :weakness, :squadId)", true)
                    .bind(hero)
                    .executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Error Occured", e);
        }
    }

    public void deleteHero(Connection sql, int id) {
        sql.createQuery("DELETE FROM heroes WHERE id = :id")
                .addParameter("id", id)
                .executeUpdate();
    }

    public void updateHero(Connection sql, Hero hero) {
        sql.createQuery("UPDATE heroes SET heroName = :name, power = :power, weakness = :weakness, squadId = :squadId WHERE id = :id")
                .bind(hero)
                .executeUpdate();
    }

    public Hero getHero(Connection sql, int id) {
        try {
            return sql.createQuery("SELECT * FROM heroes WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Hero.class);
        } catch (Exception e) {
            throw new RuntimeException("Error Occured", e);
        }
    }

    public List<Hero> getAllHeroes(Connection sql) {
        return sql.createQuery("SELECT * FROM heroes")
                .executeAndFetch(Hero.class);
    }

    /**
     * @param sql 
     * @param squadId
     * @return
     */
    @Override
    public Hero getHeroBySquadId(Connection sql, int squadId) {
        try {
            return sql.createQuery("SELECT * FROM heroes WHERE squadId = :squadId")
                    .addParameter("squadId", squadId)
                    .executeAndFetchFirst(Hero.class);
        } catch (Exception e) {
            throw new RuntimeException("Error Occured", e);
        }
    }




}
