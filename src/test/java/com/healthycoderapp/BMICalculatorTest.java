package com.healthycoderapp;

import com.sun.jdi.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @ParameterizedTest(name = "weight:{0},height:{1}")
    @CsvFileSource(resources ="/diet-recommended-input-data.csv",numLinesToSkip = 1)
    void should_ReturnTrue_WhenDietRecommended(double weightValue, double heightvalue){
        //given
        double weight = weightValue;
        double height = heightvalue;
        //when
        boolean recommended = BMICalculator.isDietRecommended(weight,height);
        //then
        assertTrue(recommended, String.format("Diet is not recommended for weight: %.2f and height: %.2f", weight, height));    }
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


