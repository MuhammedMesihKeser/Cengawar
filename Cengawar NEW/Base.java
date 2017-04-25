
public class Base {

	//VARIABLES
	private int life=1000;
	private int xcoordinate1;
	private int ycoordinate1;
	private int xcoordinate2;
	private int ycoordinate2;
	private int food=80;
	
	private int counter=0;
	//the items around the base?
	
	
	private boolean ally;
	
	//make this a circular queue
	private Queue base_commands=new Queue(500);
	
	Base(boolean ally)
	{
		this.ally=ally;
	}
	
	//GETTERS+SETTERS
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getXcoordinate1() {
		return xcoordinate1;
	}
	public void setXcoordinate1(int xcoordinate1) {
		this.xcoordinate1 = xcoordinate1;
	}
	public int getYcoordinate1() {
		return ycoordinate1;
	}
	public void setYcoordinate1(int ycoordinate1) {
		this.ycoordinate1 = ycoordinate1;
	}
	public int getXcoordinate2() {
		return xcoordinate2;
	}
	public void setXcoordinate2(int xcoordinate2) {
		this.xcoordinate2 = xcoordinate2;
	}
	public int getYcoordinate2() {
		return ycoordinate2;
	}
	public void setYcoordinate2(int ycoordinate2) {
		this.ycoordinate2 = ycoordinate2;
	}
	public int getFood()
	{
		return food;
	}
	public void setFood(int food)
	{
		this.food=food;
	}
	public boolean isAlly()
	{
		return ally;
	}
	public Queue getBase_commands() {
		return base_commands;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	//METHODS
//	public void scanInventory(Point[] map)
//	{
//		
//		
//		
//	}
	public void repair()
	{
		//Check for food around the base.
		//If there is food, decrease the food and bring up the base's life by that same amount.
	}

	
}
