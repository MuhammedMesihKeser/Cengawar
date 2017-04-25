
public class Tree {

	//VARIABLES
	static int time=1;
	static int food_cost=50;
	private int fruit;
	private int life=50;
	private int xcoordinate;
	private int ycoordinate;
	private boolean ally; //where true=Ally, false=foe
	
	//CONSTRUCTORS
	public Tree(boolean ally)
	{
		this.ally=ally;
	}
	

	//GETTERS+SETTERS
	public int getFruit() {
		return fruit;
	}
	public void setFruit(int fruit) {
		this.fruit = fruit;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getXcoordinate() {
		return xcoordinate;
	}
	public void setXcoordinate(int xcoordinate) {
		this.xcoordinate = xcoordinate;
	}
	public int getYcoordinate() {
		return ycoordinate;
	}
	public void setYcoordinate(int ycoordinate) {
		this.ycoordinate = ycoordinate;
	}
	public boolean isAlly() {
		return ally;
	}
	public void setAlly(boolean ally) {
		this.ally = ally;
	}


	//METHODS
	public void growFruit()
	{
		if(fruit<=45)
		{
			fruit+=5;
		}
		else
		{
			fruit=50;
		}
	}
	public void dropFruit(CengMAN ally)
	{
		if(ally.isAlly() && fruit!=0 && !ally.getBackpack().isFull())
		{
			ally.getBackpack().push("f"+Integer.toString(fruit));
			fruit=0;
		}
		else
		{
			System.out.println("COULDN'T DROP FRUIT");
		}
	}

}
