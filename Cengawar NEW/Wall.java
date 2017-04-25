
public class Wall {

	//VARIABLES
	static int time =1;
	static int cement_cost=1;
	private int life=200;
	private int xcoordinate;
	private int ycoordinate;
	
	//CONSTRUCTORS
	public Wall(int xcoordinate, int ycoordinate)

	{
		this.xcoordinate=xcoordinate;
		this.ycoordinate=ycoordinate;
	}
	public Wall()
	{
		
	}
	
	//GETTERS+SETTERS
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
	
	
	//METHODS


}
