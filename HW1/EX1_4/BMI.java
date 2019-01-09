import java.util.*;

public class BMI{
    public static void main(String[] args){
        System.out.println("Welcome to the BMI Calculator! So I can calculate, may I have your weight in pounds?");
        Scanner scnr = new Scanner(System.in);
        //PT -- name these, as you did for PI
        // final double POUND_PER_KG = 2.205;
        double weight = scnr.nextDouble() / 2.205;
        System.out.println("And may I also ask you your height in inches?");
        double height = scnr.nextDouble() / 39.37;
        double bmi = weight / (height * height);
        String result = "unknown";

        if (bmi >= 30.0){
            result = "obese";
        }
        else if (bmi > 25.0){
            result = "overweight";
        }
        else if (bmi > 18.5){
            result = "normal";
        }
        else {
            result = "underweight";
        }
        System.out.printf("Your BMI is %f, which is an %s BMI.", bmi, result);
    }
}
