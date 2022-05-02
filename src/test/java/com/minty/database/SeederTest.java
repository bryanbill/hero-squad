package com.minty.database;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeederTest {


    @AfterEach
    void tearDown() {
        new Seeder().clearDb();
    }

    @Test
    void seedDb() {
      assertDoesNotThrow(() -> {
        new Seeder().seedDb();
      });
    }


}