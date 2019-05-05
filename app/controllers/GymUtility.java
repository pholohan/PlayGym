package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class GymUtility
{
    public static double calcBmi(double weight, double height)
    {
        double mHeight = height * 0.01;
        double tempbmi = (weight)/(mHeight*mHeight);
        double bmi = toTwoDecimalPlaces(tempbmi);
        return bmi;
    }

    public static String bmiCat(double bmi)
    {
        String bmiCat = "";
        if(bmi < 18)
        {
            bmiCat = "Underweight";
        }
        else if(bmi >=18 && bmi <25)
        {
            bmiCat = "Normal";
        }
        else if(bmi >=25 && bmi <30)
        {
            bmiCat = "Overweight";
        }
        else if(bmi >=30 && bmi <35)
        {
            bmiCat = "Moderately Obese";
        }
        else if(bmi >=35 && bmi <40)
        {
            bmiCat = "Severely Obese";
        }
        else if(bmi >=40)
        {
            bmiCat = "Very Severely Obese";
        }
        return bmiCat;
    }

    public static String iwiCalc(double weight, double height, String gender)
    {
        String iwiColor = "";
        double heightCalc = 0;
        double idealWeight = 0;
        double genderIW = 0;
        double tolerance = 2.3;
        if(gender.equals("male"))
        {
            genderIW = 50;
        }
        if(gender.equals("female"))
        {
            genderIW = 45;
        }
        heightCalc = height- 60;
        idealWeight = genderIW + heightCalc * tolerance;
        if(weight <= idealWeight)
        {
            iwiColor = "big green tachometer alternate icon";
        }
        else if(weight > idealWeight)
        {
            iwiColor = "big red tachometer alternate icon";
        }
        return iwiColor;
    }

    public static double toTwoDecimalPlaces(double num)
    {
        return (int) (num *100 ) /100.0;
    }
}
