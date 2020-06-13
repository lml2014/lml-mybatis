package com.lml.mybatis.xml.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CountryTest {

    @Test
    void name() {
        assertNotNull(new Country(), "country is not null!");
    }
}