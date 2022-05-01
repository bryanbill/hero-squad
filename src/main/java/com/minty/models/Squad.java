package com.minty.models;

public class Squad implements ISquad{
    private String squadName;
    private String cause;
    private int maxSize;


    /**
     * @param squadId,hero
     * @return
     */
    @Override
    public boolean addToSquad(int squadId, Hero hero) {
        return false;
    }

    /**
     * @param squadId,hero
     * @return boolean
     */
    @Override
    public boolean removeFromSquad(int squadId, Hero hero) {
        return false;
    }

    public Squad findSquadById(int id){
        return new Squad();
    }
}
