package com.minty.models;

public interface ISquad {
     boolean addToSquad(int squadId, Hero hero);
     boolean removeFromSquad(int squadId, Hero hero);
}
