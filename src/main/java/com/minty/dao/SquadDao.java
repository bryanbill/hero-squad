package com.minty.dao;

import com.minty.models.Squad;
import org.sql2o.Connection;

import java.util.List;

public class SquadDao implements ISquad {


    @Override
    public int createSquad(Connection sql, Squad squad) {
      try{
          String sqlQuery = "INSERT INTO squads (squadname, maxsize, createdat) VALUES (:squadName, :maxsize, :createdAt)";
          return  (int)sql.createQuery(sqlQuery, true)
                  .bind(squad)
                  .executeUpdate().getKey();
      }catch (Exception e){
          throw new RuntimeException("Error Occured", e);
      }
    }

    @Override
    public boolean deleteSquad(Connection sql, int id) {
       try {
           String sqlQuery = "DELETE FROM squads WHERE id = :id";
           return (int)sql.createQuery(sqlQuery)
                   .addParameter("id", id)
                   .executeUpdate().getResult()>0;
       }catch (Exception e){
           throw new RuntimeException("Error Occured", e);
       }
    }

    @Override
    public Squad updateSquad(Connection sql, Squad squad) {
       try{
           String sqlQuery = "UPDATE squads SET squadname = :squadName, cause = :cause WHERE id = :id";
          return sql.createQuery(sqlQuery)
                   .bind(squad)
                  .executeAndFetchFirst(Squad.class);
       }catch (Exception e){
           throw new RuntimeException("Error Occured", e);
       }
    }

    @Override
    public Squad getSquad(Connection sql, int id) {
        String sqlQuery = "SELECT * FROM squads WHERE id = :id";
        return sql.createQuery(sqlQuery)
                .addParameter("id", id)
                .executeAndFetchFirst(Squad.class);
    }

    @Override
    public List<Squad> getAllSquads(Connection sql) {
        String sqlQuery = "SELECT * FROM squads";
        return sql.createQuery(sqlQuery)
                .executeAndFetch(Squad.class);
    }

}
