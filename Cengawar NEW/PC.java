
public class PC {

	//ATTRIBUTES + ARRAYS
	CengMAN[] cengman;
	Tree[] tree;
	Wall[] wall;
	Base base;
	
	//COUNTERS
	private int cengman_amount;
	private int tree_amount;
	private int wall_amount;
	
	//CONSTRUCTOR
	PC(int cengman_capacity, int tree_capacity,  int wall_capacity)
	{
		cengman = new CengMAN[cengman_capacity];
		tree = new Tree[tree_capacity];
		wall = new Wall[wall_capacity];
		base = new Base(false);
		cengman_amount=0;
		tree_amount=0;
		wall_amount=0;
	}
	
	
	//GETTERS+SETTERS
	public CengMAN getCengman(int cengman_no) {
		return cengman[cengman_no];
	}
	public void setCengman(CengMAN cengman, int cengman_no) {
		this.cengman[cengman_no]=cengman;
	}
	public Tree getTree(int tree_no) {
		return tree[tree_no];
	}
	public void setTree(Tree tree, int tree_no) {
		this.tree[tree_no] = tree;
	}
	public Wall getWall(int wall_no) {
		return wall[wall_no];
	}
	public void setWall(Wall wall, int wall_no) {
		this.wall[wall_no] = wall;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
	}
	public int getCengman_amount() {
		return cengman_amount;
	}
	public void setCengman_amount(int cengman_amount) {
		this.cengman_amount = cengman_amount;
	}
	public int getTree_amount() {
		return tree_amount;
	}
	public void setTree_amount(int tree_amount) {
		this.tree_amount = tree_amount;
	}
	public int getWall_amount() {
		return wall_amount;
	}
	public void setWall_amount(int wall_amount) {
		this.wall_amount = wall_amount;
		}
		
	
	
	//METHODS
	public void createCengMAN()
	{		
		//QUEUE THIS IN THE BASE
		base.getBase_commands().enqueue("C"+CengMAN.time);

		if(base.getFood()>=CengMAN.food_cost)
		{
			base.setFood(base.getFood()-50);
			cengman[cengman_amount]=new CengMAN(false);
			cengman_amount++;
		}
	}
	public void createTree()
	{
		//QUEUE THIS IN THE BASE
		base.getBase_commands().enqueue("T"+Tree.time);
		
		if(base.getFood()>=Tree.food_cost)
		{
			base.setFood(base.getFood()-50);
			tree[tree_amount]=new Tree(false);
			tree_amount++;
		}
	}
	public void createWall(CengMAN cengman)
	{
		//QUEUE THIS IN THE BASE
		base.getBase_commands().enqueue("W"+Wall.time);
		
		if(!cengman.getBackpack().isEmpty() && cengman.getBackpack().peek()=="C")
		{
			cengman.getBackpack().pop();
			wall[wall_amount]=new Wall();
			wall_amount++;
		}
	}
	public void buryCengMAN()
	{
		for(int i=0; i<cengman_amount;i++)
		{
			if(cengman[i]!=null && cengman[i].getLife()<=0)
			{
				cengman[i]=null;
			}
		}
	}
	public void doThings(String product) //Check if the queue is empty before using this method!
	{
		if(base.getCounter()!=0)
		{
			base.setCounter(base.getCounter()-1);
			
		}
		else
		{
			//Check the command's letter
			switch (product){ 
			case "C":	
			createCengMAN();
			case "T":
			createTree();
			
			}
			getBase().getBase_commands().dequeue();
		}
	}
	
	//AI
	private boolean danger;



	}
