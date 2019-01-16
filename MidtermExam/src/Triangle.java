import java.awt.Color;

public class Triangle extends Shape{
	private int side1;
	private int side2;
	private int side3;
	
	Triangle(int ID, int side1, int side2, int side3, Color color,String colorString){
		initialize(ID,color,colorString);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		type = "Triangle";
	}
	
	String getDetailString() {
		return String.format("%s\nColor: %s\nSide1 Length: %d\nSide2 Length: %d\nSide3 Length: %d\nArea: %f\nPerimeter: %f", this.toString(), colorString, side1, side2, side3, this.getArea(),this.getPerimeter());
	}
	
	double getArea() {
		double p = this.getPerimeter() / 2;
		return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
	}
	double getPerimeter() { return side1 + side2 + side3; }
}
