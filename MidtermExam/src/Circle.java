import java.awt.Color;

public class Circle extends Shape{
	private int radius;
	
	Circle(int ID, int radius, Color color, String colorString){
		initialize(ID,color,colorString);
		this.radius = radius;
		type = "Circle";
	}
	
	String getDetailString() {
		return String.format("%s\nColor: %s\nRadius: %d\nArea: %f\nPerimeter: %f", this.toString(), colorString, radius, this.getArea(),this.getPerimeter());
	}
	
	double getArea(){
		return Math.PI * (radius * radius);
	}
	
	double getPerimeter() {
		return Math.PI * 2 * radius;
	}
}
