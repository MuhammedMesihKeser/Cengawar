
public class Point {

	int x_coordinate;
	int y_coordinate;
	int amount;
	
	char character;
	
	boolean checked;

	Point parent;

	String data;
	
	//CONSTRUCTORS
	public Point()
	{
		data= null;
	}
	public Point(String data)
	{
		this.data = data;
	}
	
	//GETTERS+SETTERS
	public int getX_coordinate() {
		return x_coordinate;
	}
	public void setX_coordinate(int x_coordinate) {
		this.x_coordinate = x_coordinate;
	}
	public int getY_coordinate() {
		return y_coordinate;
	}
	public void setY_coordinate(int y_coordinate) {
		this.y_coordinate = y_coordinate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {

		this.character = character;
	}
	public boolean isChecked() {

		return checked;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Point getParent() {
		return parent;
	}
	public void setParent(Point parent) {
		this.parent = parent;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
