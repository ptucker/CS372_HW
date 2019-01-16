import java.awt.Color;

public class Square extends Shape{
	private int side;
	
	Square(int ID, int side, Color color,String colorString){
		initialize(ID,color,colorString);
		this.side = side;
		type = "Square";
	}
	
	String getDetailString() {
		return String.format("%s\nColor: %s\nSide Length: %d\nArea: %f\nPerimeter: %f", this.toString(), colorString, side, this.getArea(),this.getPerimeter());
	}
	
	double getArea() { return side * side; }
	double getPerimeter() { return side * 4; }
}
