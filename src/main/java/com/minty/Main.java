package com.minty;

import com.minty.database.Seeder;
import com.minty.routes.Router;

public class Main {
    public static void main(String[] args) {
        new Seeder().seedDb();
        Router.run();
    }
}