package com.minty.models;

import java.time.LocalDateTime;

public class Squad{
    private int id;
    private String squadName;
    private String cause;
    private int maxSize;
    private LocalDateTime createdAt;

    public Squad(int id, String squadName, String cause, int maxSize, LocalDateTime createdAt) {
        this.id = id;
        this.squadName = squadName;
        this.cause = cause;
        this.maxSize = maxSize;
        this.createdAt = createdAt;
    }
    public String getSquadName() {
        return squadName;
    }

    public String getCause() {
        return cause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public int getId() {
        return id;
    }
}
