package com.minty.tests;

import com.minty.database.Db;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class DbTest {

    @Test
    void connect() {
      assertNotNull(new Db().connect());
    }
}