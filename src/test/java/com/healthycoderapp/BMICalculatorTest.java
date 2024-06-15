package com.healthycoderapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void should_ReturnTrue_WhenDietRecommended(){
        //given
        double weight = 89.0;
        double height = 1.72;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        //then
        assertTrue(recommended);
    }
@Test
    void  should_ReturnFalse_WhenDietNotRecommended(){
        double weight = 50;
        double height = 1.8;

        boolean recommended = BMICalculator.isDietRecommended(weight,height);

        assertFalse(recommended);

    }


    @Test
    void should_ThrowArithmeticException_When_HeightZero(){
        double weight = 50;
        double height = 0;

        Executable executable = ()->BMICalculator.isDietRecommended(weight,height);

        assertThrows(ArithmeticException.class,executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_When_ColderListNotEmpty(){
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.0));


        Coder coderWordBMI = BMICalculator.findCoderWithWorstBMI(coders);

        assertAll(

                ()->  assertEquals(1.82,coderWordBMI.getHeight()),
                ()-> assertEquals(98.0,coderWordBMI.getWeight())
);
    }

    @Test
    void should_ReturnNullWorstBMICoder_When_coderListEmpty(){
        List<Coder> coders = new ArrayList<>();

        Coder coderWordBMI = BMICalculator.findCoderWithWorstBMI(coders);
        assertNull(coderWordBMI);
    }

    @Test void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty(){
        List<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));
        double [] expected = {18.52,29.59,19.53};
        double [] bmiScores = BMICalculator.getBMIScores(coders);

        assertArrayEquals(expected,bmiScores);

    }

}


