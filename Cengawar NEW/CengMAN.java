
public class CengMAN {

	//VARIABLES
	static int time=8;
	static int food_cost=50;
	private Stack backpack = new Stack(8);
	private int life=100;
	private int level=1;
	private int attack_damage;
	private Point location;
	private boolean busy=false;
	private boolean ally;
	
	CircularQueue path;
	CircularQueue pathX;
	CircularQueue pathY;
	
	//CONSTRUCTORS
	public CengMAN(boolean ally)
	{
		this.ally=ally;
		path = new CircularQueue(999);
		pathX = new CircularQueue(999);
		pathY = new CircularQueue(999);

		location = new Point();
	}


	//GETTERS + SETTERS
	public Stack getBackpack() {
		return backpack;
	}
	public void setBackpack(Stack backpack) {
		this.backpack = backpack;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAttack_damage() {
		return attack_damage;
	}
	public void setAttack_damage(int attack_damage) {
		this.attack_damage = attack_damage;
	}	
	public Point getLocation()
	{
		return location;
	}
	public void setLocation(Point location)
	{
		this.location = location;
	}
	public boolean isBusy()
	{
		return busy;
	}
	public void setBusy(boolean busy)
	{
		this.busy=busy;
	}
	public boolean isAlly() {
		return ally;
	}
	public void setAlly(boolean ally) {
		this.ally = ally;
	}
	public CircularQueue getPath() {
		return path;
	}
	public void setPath(CircularQueue path) {
		this.path = path;
	}
	public CircularQueue getPathX() {
		return pathX;
	}
	public void setPathX(CircularQueue pathX) {
		this.pathX = pathX;
	}
	public CircularQueue getPathY() {
		return pathY;
	}
	public void setPathY(CircularQueue pathY) {
		this.pathY = pathY;
	}


	//METHODS
	public void increaseLife(int food)
	{
		if(life+food>599)
		{
			life = 599;
		}
		else
		{
			life = life + food;
		}
	}
	public void damageCengMAN(CengMAN foe)
	{
		if(foe!=null && (isAlly()||foe.isAlly())&&!(isAlly()&&foe.isAlly()))
		{
			foe.setLife(foe.getLife()-attack_damage);
		}
	}
	public void damageTree(Tree tree)
	{
		if(tree!=null && (isAlly()||tree.isAlly())&&!(isAlly()&&tree.isAlly()))
		{
			tree.setLife(tree.getLife()-attack_damage);
		}
	}
	public void damageBase(Base base)
	{
		if(base!=null && (isAlly()||base.isAlly())&&!(isAlly()&&base.isAlly()))
		{
			base.setLife(base.getLife()-attack_damage);
		}
	}
	public void damageWall(Wall wall)
	{
		if (wall!=null)
		{
		wall.setLife(wall.getLife()-attack_damage);
	
		}
	}
	public void calculateLevel()
	{
		if(life%100==0)
		{
			level=1;
		}
		else
		{
			level=life%100;
		}
	}
	public void calculateAttack_damage()
	{
		attack_damage=level*10;
	}
	public void extractBackpack()
	{
		//scan the area around the CengMAN on the board
		//if there is an empty space, drop the top content of the backpack
		//if not, do nothing
	}
	public void battle()
	{
		//scan the area around the cengman
		//if there is an enemy cengman directly around him, have him stay put until there are no cengman around him
		//have him only damage ONE cengman at per turn		
	}





}
