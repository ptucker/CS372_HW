import java.awt.Color;

public class Rectangle extends Shape{
	private int length;
	private int width;
	
	Rectangle(int ID, int length, int width, Color color, String colorString){
		initialize(ID,color,colorString);
		this.length = length;
		this.width = width;
		type = "Rectangle";
	}

	String getDetailString() {
		return String.format("%s\nColor: %s\nLength: %d\nWidth: %s\nArea: %f\nPerimeter: %f", this.toString(), colorString, length, width, this.getArea(),this.getPerimeter());
	}

	double getArea() {
		return length * width;
	}

	double getPerimeter() {
		return (length * 2) + (width * 2);
	}
}
