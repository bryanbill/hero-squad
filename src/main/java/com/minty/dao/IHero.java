package com.minty.dao;

import com.minty.models.Hero;
import org.sql2o.Connection;

import java.util.List;

public interface IHero {
    public void createHero(Connection sql,Hero hero);
    public void deleteHero(Connection sql,int id);
    public void updateHero(Connection sql,Hero hero);
    public Hero getHero(Connection sql,int id);
    public List<Hero> getAllHeroes(Connection sql);
}
