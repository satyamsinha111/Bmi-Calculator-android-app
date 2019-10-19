package com.innovativeminds.bmicalculator;

public class BmiCalculator {

    //calculate bmi for pound
    public static  float bmiInPound(float weightInPound,float heightInFeet)
    {
        float bmi=0;
        bmi = (weightInPound * 703) / (heightInFeet * heightInFeet);
        return bmi;
    }

    //calculate bmi for kg
    public static float bmiInKg(float weightInKg,float heightInMeteres)
    {
        float bmi = 0;
        bmi=weightInKg/(heightInMeteres*heightInMeteres);
        return bmi;
    }




}
