import java.util.*;

public class AreaOfCircle{

    public static final double PI = 3.14;

    public static void main(String[] args){
        System.out.println("Please enter the radius of a circle to have its area calculated:");
        Scanner scnr = new Scanner(System.in);
        double radius;
        do{
            radius = scnr.nextDouble();
        } while (radius < 0);

        double area = PI * (radius * radius);
        System.out.printf("Circle of radius %f has an area of %f.", radius, area);
    }
}