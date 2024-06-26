package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup(){
        this.dietPlanner = new DietPlanner(20,30,50);
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test finshed");
    }

    @Test
    void should_ReturnCorrectDietPlan_whenCorrectCoder(){

        Coder coder = new Coder(1.82,75,26,Gender.MALE);
        DietPlan expected = new DietPlan(2202,110,73,275);
        DietPlan actual = dietPlanner.calculateDiet(coder);

        assertAll(
                ()->assertEquals(expected.getCalories(),actual.getCalories()),
                ()->assertEquals(expected.getProtein(),actual.getProtein()),
                ()->assertEquals(expected.getFat(),actual.getFat()),
                ()->assertEquals(expected.getCarbohydrate(),actual.getCarbohydrate())
        );

    }

}