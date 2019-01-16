import java.awt.Color;

public abstract class Shape {
	protected String type = "unspecified";
	protected int ID;
	protected Color color;
	protected String colorString;
	
	void initialize(int ID, Color color, String colorString) {
		this.ID = ID;
		this.color = color;
		this.colorString = colorString;
	}
	
	public String toString() {
		return String.format("%s (ID # %d)", type, ID);
	}
	
	public String getKind() {
		return type;
	}
	
	public Color getColor() {
		return color;
	}
	
	abstract String getDetailString();
	abstract double getArea();
	abstract double getPerimeter();
}
