package com.minty.dao;

import com.minty.models.Squad;
import org.sql2o.Connection;

import java.util.List;

public interface ISquad {
    public int createSquad(Connection sql, Squad squad);
    public boolean deleteSquad(Connection sql,int id);
    public Squad updateSquad(Connection sql, Squad squad);
    public Squad getSquad(Connection sql,int id);
    public List<Squad> getAllSquads(Connection sql);
}
