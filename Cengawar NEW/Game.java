import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.awt.Color;
import enigma.console.*;
import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;



public class Game {
	
	public static enigma.console.Console cn = Enigma.getConsole("CENG-a-WAR",180,40,true);
	public TextMouseListener tmlis; 
	public KeyListener klis; 
	
	
	// ------ Standard variables for mouse and keyboard ------
	   public int mousepr;          // mouse pressed?
	   public int mousex, mousey;   // mouse text coords.
	   public int keypr;   // key pressed?
	   public int rkey;    // key   (for press/release)
	   // ----------------------------------------------------
	   
	   private int time;
	   private int Current_time;
	   private int temp_time;
	   private int c_x = 0;
	   private int c_y = 0;
	   private int screenx = 0;

	   private Point[][] map = new Point[19][49];
	  
	   
	   
	   private String[] birim = new String[19];
	   
	   CircularQueue q = new CircularQueue(90);
	   
	   String queue;
	   
	   int countqueue = 0;
	   
	   //METHODS
	  public void generateBases(Point[][] map, Random random, Player player, PC pc)
	  {
		  boolean valid_base_position[][] = new boolean[map.length][map[0].length];


			
			
			//Setting Valid Positions
		
					for(int i=2; i<map.length;i++)
					{
						for(int j=3; j<map[0].length;j++)
						{
							if(map[i][j]!=null)
							{
								boolean valid = true;
								for(int m=i-2;m<=i;m++)
								{
									for(int n=j-3;n<=j;n++)
									{
										if(map[m][n].getCharacter()!=' ')
										{
											valid=false;
										}
									}
									
								}
								
								if(valid)
								{
									//only the left one is necessary
									valid_base_position[i-1][j-2]=true;
								}
								
							}		
						}
					}
					
			
			
			
				
			
				int x;
				int y;
				
				do
				{
				 x = random.nextInt(18);
				 y = random.nextInt(48);
				}
				while(!valid_base_position[x][y]);
				
						
				int x_enemy;
				int y_enemy;
				
				
				if(x<9&&y<25)
				{
					do
					{
					 x_enemy = random.nextInt(10)+9;
					 y_enemy = random.nextInt(24)+25;
					}
					while(!valid_base_position[x_enemy][y_enemy]);
				}
				else if(x<9&&y>=25)
				{
					do
					{
					 x_enemy = random.nextInt(10)+9;
					 y_enemy = random.nextInt(25);
					}
					while(!valid_base_position[x_enemy][y_enemy]);
				}
				else if(x>=9&&y<25)
				{
					do
					{
					 x_enemy = random.nextInt(9);
					 y_enemy = random.nextInt(24)+25;
					}
					while(!valid_base_position[x_enemy][y_enemy]);
				}
				else
				{
					do
					{
					 x_enemy = random.nextInt(9);
					 y_enemy = random.nextInt(25);
					}
					while(!valid_base_position[x_enemy][y_enemy]);
				}
				
				map[x][y].setCharacter('[');
				map[x][y+1].setCharacter(']');
				player.getBase().setXcoordinate1(x);
				player.getBase().setXcoordinate2(x);
				player.getBase().setYcoordinate1(y);
				player.getBase().setYcoordinate2(y+1);
				
				
				map[x_enemy][y_enemy].setCharacter('[');
				map[x_enemy][y_enemy+1].setCharacter(']');
				pc.getBase().setXcoordinate1(x_enemy);
				pc.getBase().setXcoordinate2(x_enemy);
				pc.getBase().setYcoordinate1(y_enemy);
				pc.getBase().setYcoordinate2(y_enemy+1);

	  }

	  public int menu(boolean forever) throws InterruptedException
	  {
		  while(forever)
		  {
		  	cn.getTextWindow().setCursorPosition(2, 4);
			cn.getTextWindow().output("              .          .                +              .      ");
			cn.getTextWindow().setCursorPosition(2, 6);
			cn.getTextWindow().output("          .        +          .      .          .          +                                                                     '" );		
			cn.getTextWindow().setCursorPosition(2, 7);
			cn.getTextWindow().output("     ,            _        +                    '                                 +                               '");	
			cn.getTextWindow().setCursorPosition(2, 8);
			cn.getTextWindow().output("  +              /;-._,-.____        ,-----.                 .-\"\"\"\"-        _____) __     __) _____)  _____   __       __) _____    _____  ");
			cn.getTextWindow().setCursorPosition(2, 9);
			cn.getTextWindow().output("            .   (_:#::_.:::. `-._   /:, /-._, `._,         F   .-'        /       (  /|  /  /        (  /  |    )  |  /   (  /  |  (  /   )");	
			cn.getTextWindow().setCursorPosition(2, 10);
			cn.getTextWindow().output("                    \\   _|`\"=:_::.`.);  \\ __/ /           F   J          /___       / | /  /   ___     /---|    | /| /      /---|    /__ /        .");	
			cn.getTextWindow().setCursorPosition(2, 11);
			cn.getTextWindow().output("                      ,    `./  \\:. `.   )==-'  .        I    I         /        ) /  |/  /     / )   /    |_   |/ |/    ) /    | ) /   \\_");	
			cn.getTextWindow().setCursorPosition(2, 12);
			cn.getTextWindow().output("    .      ., ,-=-.  ,\\, +#./`   \\:.  / /               . L   '.       (_____)  (_/   '  (____ /   (_/          /  |    (_/      (_/                        +");	
			cn.getTextWindow().setCursorPosition(2, 13);
			cn.getTextWindow().output(".           \\/:/`-' , ,\\ '` ` `   ): , /_  -o              L    `-._,      .  '                                 , ");	
			cn.getTextWindow().setCursorPosition(2, 3);
			cn.getTextWindow().output("                                                            +                       +                ' ");
			cn.getTextWindow().setCursorPosition(2, 14);
			cn.getTextWindow().output("       .    /:+- - + +- : :- + + -:'  /(o-) \\)              `-.__.-'    +  .     ");	
			cn.getTextWindow().setCursorPosition(2, 15);
			cn.getTextWindow().output("  .      ,=':  \\    ` `/` ' , , ,:' `'--\".--\"---._/`7     '   .    ");	
			cn.getTextWindow().setCursorPosition(2, 16);
			cn.getTextWindow().output("   `.   (    \\: \\,-._` ` + '\\, ,\"   _,--._,---\":.__/                                        SELECT A MAP:                                          .           ,       +");	
			cn.getTextWindow().setCursorPosition(2, 17);
			cn.getTextWindow().output("              \\:  `  X` _| _,\\/'   .-'");	
			cn.getTextWindow().setCursorPosition(2, 18);
			cn.getTextWindow().output(".               \":._:`\\____  /:'  /      .           .");	
			cn.getTextWindow().setCursorPosition(2, 19);
			cn.getTextWindow().output("                    \\::.  :\\/:'  /              +");	
			cn.getTextWindow().setCursorPosition(2, 20);
			cn.getTextWindow().output("   +                 `.:.  /:'  }      '");
			cn.getTextWindow().setCursorPosition(2, 21);
			cn.getTextWindow().output("           .           ):_(:;   \\           .");
			cn.getTextWindow().setCursorPosition(2, 22);
			cn.getTextWindow().output("                      /:. _/ ,  |                                                                                                         '");		
			cn.getTextWindow().setCursorPosition(2, 23);
			cn.getTextWindow().output("                   ' (|::.     ,`                  .");	
			cn.getTextWindow().setCursorPosition(2, 24);
			cn.getTextWindow().output("     .                |::.    {\\");	
			cn.getTextWindow().setCursorPosition(2, 25);
			cn.getTextWindow().output("  +                   |::.\\  \\ `.");	
			cn.getTextWindow().setCursorPosition(2, 26);
			cn.getTextWindow().output("      ()              |:::(\\    |");	
			cn.getTextWindow().setCursorPosition(2, 27);
			cn.getTextWindow().output("     /  \\     O       |:::/{ }  |                  (o");	
			cn.getTextWindow().setCursorPosition(2, 28);
			cn.getTextWindow().output("    {|  |}     )  ___/#\\::`/ (O \"==._____   O, (O  /`");	
			cn.getTextWindow().setCursorPosition(2, 29);
			cn.getTextWindow().output("   ~o|  |o~~~~~~w/w~\"~~,\\` `:/,-(~`\"~~~~~~~~\"~o~\\~/~w|/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");	
			cn.getTextWindow().setCursorPosition(2, 30);
			cn.getTextWindow().output(" ~~~{    }~~~~~~~~~~~~~~~~~~~~~~~~\\\\W~~~~~~~~~~~~\\|/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");	
			cn.getTextWindow().setCursorPosition(2, 31);
			cn.getTextWindow().output(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");
			cn.getTextWindow().setCursorPosition(2, 32);
			cn.getTextWindow().output(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");	
			for(int i=0; i<3; i++)
			{
				cn.getTextWindow().setCursorPosition(85+i*11, 22);			
				cn.getTextWindow().output("-   MAP   -");
			}
			for(int i=0; i<500; i++)
			{
				  if(mousepr==1)
				   {
					  if(mousepr==1)
					   {
						  if(mousex >= 85 && mousex < 97 && mousey>=20 && mousey<=25)
						   {   
							   //map1
							   forever = false;
							   return 1;
							  
						   }
						   else if(mousex >= 97 && mousex < 108 && mousey>=20 && mousey<=25)
						   {  
							   //map2
							   forever = false;
							   return 2;
						   }
						   else if(mousex >= 108 && mousex < 119 && mousey>=20 && mousey<=25)
						   {   
							   //map3
							   forever = false;
							   return 3;
							   
						   }
						   mousepr = 0;
					   }
					   mousepr = 0;
				   }
				Thread.sleep(1);
			}
			cn.getTextWindow().setCursorPosition(2, 4);
			cn.getTextWindow().output("              +          +                .              '      ");
			cn.getTextWindow().setCursorPosition(2, 3);
			cn.getTextWindow().output("                                                            .                       '                + ");
			cn.getTextWindow().setCursorPosition(2, 6);
			cn.getTextWindow().output("          +        .          '      '          +          '                                                                     ." );		
			cn.getTextWindow().setCursorPosition(2, 7);
			cn.getTextWindow().output("     .            _        .                    .                                 .                               .");	
			cn.getTextWindow().setCursorPosition(2, 8);
			cn.getTextWindow().output("  ,              /;-._,-.____        ,-----.                 .-\"\"\"\"-        _____) __     __) _____)  _____   __       __) _____    _____  ");
			cn.getTextWindow().setCursorPosition(2, 9);
			cn.getTextWindow().output("  .         +   (_:#::_.:::. `-._   /:, /-._, `._,         F   .-'        /       (  /|  /  /        (  /  |    )  |  /   (  /  |  (  /   )");	
			cn.getTextWindow().setCursorPosition(2, 10);
			cn.getTextWindow().output("                    \\   _|`\"=:_::.`.);  \\ __/ /           F   J          /___       / | /  /   ___     /---|    | /| /      /---|    /__ /        '");	
			cn.getTextWindow().setCursorPosition(2, 11);
			cn.getTextWindow().output("                      .    `./  \\:. `.   )==-'  '        I    I         /        ) /  |/  /     / )   /    |_   |/ |/    ) /    | ) /   \\_");	
			cn.getTextWindow().setCursorPosition(2, 12);
			cn.getTextWindow().output("    +      '. ,-=-.  ,\\, +#./`   \\:.  / /               , L   '.       (_____)  (_/   '  (____ /   (_/          /  |    (_/      (_/                        .");	
			cn.getTextWindow().setCursorPosition(2, 13);
			cn.getTextWindow().output("'           \\/:/`-' , ,\\ '` ` `   ): , /_  -o              L    `-._,      ,  .                                 + ");	
			cn.getTextWindow().setCursorPosition(2, 3);
			cn.getTextWindow().output("                                                            '                       .                . ");
			cn.getTextWindow().setCursorPosition(2, 14);
			cn.getTextWindow().output("       '    /:+- - + +- : :- + + -:'  /(o-) \\)              `-.__.-'    .  ,     ");	
			cn.getTextWindow().setCursorPosition(2, 15);
			cn.getTextWindow().output("  +      ,=':  \\    ` `/` ' , , ,:' `'--\".--\"---._/`7     +   ,    ");	
			cn.getTextWindow().setCursorPosition(2, 16);
			cn.getTextWindow().output("   +'   (    \\: \\,-._` ` + '\\, ,\"   _,--._,---\":.__/                                        SELECT A MAP:                                          '           +       .");	
			cn.getTextWindow().setCursorPosition(2, 17);
			cn.getTextWindow().output("              \\:  `  X` _| _,\\/'   '-.");	
			cn.getTextWindow().setCursorPosition(2, 18);
			cn.getTextWindow().output("+               \":._:`\\____  /:'  /      *           '");	
			cn.getTextWindow().setCursorPosition(2, 19);
			cn.getTextWindow().output("                    \\::.  :\\/:'  /              #");	
			cn.getTextWindow().setCursorPosition(2, 20);
			cn.getTextWindow().output("   .                 `.:.  /:'  }      .");
			cn.getTextWindow().setCursorPosition(2, 21);
			cn.getTextWindow().output("           '           ):_(:;   \\           ,");
			cn.getTextWindow().setCursorPosition(2, 22);
			cn.getTextWindow().output("                      /:. _/ ,  |                                                                                                         .");		
			cn.getTextWindow().setCursorPosition(2, 23);
			cn.getTextWindow().output("                   . (|::.     ,`                  +");	
			cn.getTextWindow().setCursorPosition(2, 24);
			cn.getTextWindow().output("     '                |::.    {\\");	
			cn.getTextWindow().setCursorPosition(2, 25);
			cn.getTextWindow().output("   '                  |::.\\  \\ `.");	
			cn.getTextWindow().setCursorPosition(2, 26);
			cn.getTextWindow().output("      ()              |:::(\\    |");	
			cn.getTextWindow().setCursorPosition(2, 27);
			cn.getTextWindow().output("     /  \\     O       |:::/{ }  |                  (o");	
			cn.getTextWindow().setCursorPosition(2, 28);
			cn.getTextWindow().output("    {|  |}     )  ___/#\\::`/ (O \"==._____   O, (O  /`");	
			cn.getTextWindow().setCursorPosition(2, 29);
			cn.getTextWindow().output("   ~o|  |o~~~~~~w/w~\"~~,\\` `:/,-(~`\"~~~~~~~~\"~o~\\~/~w|/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");	
			cn.getTextWindow().setCursorPosition(2, 30);
			cn.getTextWindow().output(" ~~~{    }~~~~~~~~~~~~~~~~~~~~~~~~\\\\W~~~~~~~~~~~~\\|/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");	
			cn.getTextWindow().setCursorPosition(2, 31);
			cn.getTextWindow().output(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");
			cn.getTextWindow().setCursorPosition(2, 32);
			cn.getTextWindow().output(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~ ~~~~ ~~~ ~~ ~   ~      ~        ~");	
			for(int i=0; i<3; i++)
			{
				cn.getTextWindow().setCursorPosition(85+i*11, 20);
				cn.getTextWindow().output("-----------");
				cn.getTextWindow().setCursorPosition(85+i*11, 21);
				cn.getTextWindow().output("-         -");
				cn.getTextWindow().setCursorPosition(85+i*11, 22);
				cn.getTextWindow().output("-   MAP   -");
				cn.getTextWindow().setCursorPosition(85+i*11, 23);
				cn.getTextWindow().output("-    "+(i+1)+"    -");
				cn.getTextWindow().setCursorPosition(85+i*11, 24);
				cn.getTextWindow().output("-         -");
				cn.getTextWindow().setCursorPosition(85+i*11, 25);
				cn.getTextWindow().output("-----------");
			}
			for(int i=0; i<500; i++)
			{
				  if(mousepr==1)
				   {
					  if(mousex >= 85 && mousex < 97 && mousey>=20 && mousey<=25)
					   {   
						   //map1
						   forever = false;
						   return 1;
						  
					   }
					   else if(mousex >= 97 && mousex < 108 && mousey>=20 && mousey<=25)
					   {  
						   //map2
						   forever = false;
						   return 2;
					   }
					   else if(mousex >= 108 && mousex < 119 && mousey>=20 && mousey<=25)
					   {   
						   //map3
						   forever = false;
						   return 3;
						   
					   }
					   mousepr = 0;
				   }
				Thread.sleep(1);
			}
		  }
			return 0;
	  }

	  
	  public void initializeMap(Point[][] map, int screenx, int file) throws IOException
	  {
		   if(screenx == 0)
		   {
			 
				Readfile map1 = new Readfile("C:\\Ceng-a-WAR\\Maps\\map.txt");
				Readfile map2 = new Readfile("C:\\Ceng-a-WAR\\Maps\\map2.txt");
				Readfile map3 = new Readfile("C:\\Ceng-a-WAR\\Maps\\map3.txt");
				
				if(file==1)
				{
					birim=map1.OpenFile();
				}
				else if(file==2)
				{
					birim=map2.OpenFile();
				}
				else
				{
					birim=map3.OpenFile();
				}
				
	         	for (int i = 0; i < 19; i++)
	         	{     
	         		for (int j = 0; j < 49; j++)
	         		{
		         		map[i][j].setCharacter(birim[i].charAt(j));
		         		map[i][j].setParent(null);
		         		map[i][j].setX_coordinate(i);
		         		map[i][j].setY_coordinate(j);
	         		}
	         	}
		 
		   }
	  }
	
	  public void screen(Point[][] map, int countqueue) {
		   
	  
	
		 
		   for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 49; j++) {
					cn.getTextWindow().setCursorPosition(5 + j,3 + i);
					cn.getTextWindow().output(map[i][j].getCharacter());
					
				}
			}
		   
		   cn.getTextWindow().setCursorPosition(62, 0);
		   Time();
		   cn.getTextWindow().setCursorPosition(56, 1);
		   cn.getTextWindow().output("--- --- --- ---");
		   cn.getTextWindow().setCursorPosition(57, 2);
		   cn.getTextWindow().output("T   C   W   R");
		   cn.getTextWindow().setCursorPosition(56, 3);
		   cn.getTextWindow().output("--- --- --- ---");
		   cn.getTextWindow().setCursorPosition(5 , 1);
		   cn.getTextWindow().output("PQueue >");
		   
		   while(!q.isEmpty()){
			queue = (String) q.dequeue();
			cn.getTextWindow().setCursorPosition(15+ countqueue, 1);
			cn.getTextWindow().output(queue);
			countqueue++;
		   }
			
		}

	   public void Time(){
		   
		   time = 1;
		   System.out.println(time);
			    long tempTime = System.currentTimeMillis();
				if (tempTime >= Current_time + 1000) {
					time++;
					
				    Current_time = (int) System.currentTimeMillis();
				}
				
				
	   }
	
	   public void mouseop(){
		   if(mousepr==1)
		   {
			   if(mousex == 57 && mousey == 2)
			   {   //System.out.println("queue tree");
			   q.enqueue("T");
			   queue = "T";
			   }
			   if(mousex == 61 && mousey == 2)
			   {   //System.out.println("queue ceng");
			   q.enqueue("C");
			   queue = "C";
			   }
			   if(mousex == 65 && mousey == 2)
			   {   //System.out.println("queue wall");
			   q.enqueue("W");
			   queue = "W";
			   }
			   if(mousex == 69 && mousey == 2)
			   { //System.out.println("queue r");
			   q.enqueue("R");
			   queue = "R";
			   }
			   mousepr = 0;
		   }
	   }
	   

	   public Point move(Point[][] map){
		   
		  
		   if(mousepr == 1 )
		   {
			   if(mousex < 54 && mousex >5)
			   {
				   if(mousey <22 && mousey>3)
				   {
					   return map[mousey-3][mousex-5];
				   }
				   else
				   {
					   return null;
				   }
			   }
			   else
			   {
				   return null;
			   }
			   
		   }
		   else
		   {
			   return null;
		   }
	   }
		   
		   
	   public void pathfinding(CengMAN cengman, Point destination, Point[][] map) throws InterruptedException
	   {
//		   	PathQueue p = new PathQueue();
		   	CircularQueue x = new CircularQueue(999);
		   	CircularQueue y = new CircularQueue(999);

			Stack sX = new Stack(999);
			Stack sY = new Stack(999);

			Point location = map[cengman.getLocation().getX_coordinate()][cengman.getLocation().getY_coordinate()];

			int currentx=cengman.getLocation().getX_coordinate();
			int currenty=cengman.getLocation().getY_coordinate();
			
			int targetx=destination.getX_coordinate();
			int targety=destination.getY_coordinate();
			
			int turn =0;
			
			boolean flag = false;
			
			
			x.enqueue(currentx);
			y.enqueue(currenty);
			
			for(int k=0; k<(map.length)*(map[0].length)&&flag==false;k++)
			{
				turn++;
				
				for(int z=0; z<turn; z++)
				{
					for(int i=-1; i<2; i++)
					{
						for(int j=-1; j<2; j++)
						{
							if(Math.abs(i)!=Math.abs(j))
							{
								//and if x and y aren't empty, and within our boundaries, have no parents and their soon-to-be parent is an empty space...	
							if(!x.isEmpty()&&(int)x.peek()+i>=0 && (int)y.peek()+j>=0 && (int)x.peek()+i<19 && (int)y.peek()+j<49&&map[(int)x.peek()+i][(int)y.peek()+j]!=null && (map[(int)x.peek()][(int)y.peek()].getCharacter()==' '||map[(int)x.peek()][(int)y.peek()].getCharacter()=='C')&&map[(int)x.peek()+i][(int)y.peek()+j].getParent()==null)
								{
								//If we've reached our target
								if((int)x.peek()+i==targetx && (int)y.peek()+j==targety)
									{
										flag = true;
										map[(int)x.peek()+i][(int)y.peek()+j].setParent(map[(int)x.peek()][(int)y.peek()]);
										break;
									}
								else if(map[(int)x.peek()+i][(int)y.peek()+j].getCharacter()==' ')
								{
									map[(int)x.peek()+i][(int)y.peek()+j].setParent(map[(int)x.peek()][(int)y.peek()]);
									x.enqueue((int)x.peek()+i);
									y.enqueue((int)y.peek()+j);
								}
								
							}
							
							}
					
						if(flag==true)
						{
							break;
						}
						
					}
						
						if(flag==true)
						{
							break;
						}
				}
					
					if(flag==true)
					{
						break;
					}
					
					if(turn>1 && !x.isEmpty()) //dequeues the front so it can move on to the next part of the combinations
					{
						x.dequeue();
						y.dequeue();
					}
			
				
			}
			
		
			
		}
			if(flag)
			{
				
				Point current = map[destination.getX_coordinate()][destination.getY_coordinate()];
				current.setParent(map[destination.getX_coordinate()][destination.getY_coordinate()].getParent());
				
				if(map[targetx][targety].getCharacter()!=' ')
				{
					current = current.getParent();
				}
				
				while(current!=location)
				{
					sX.push(current.getX_coordinate());
					sY.push(current.getY_coordinate());
					current = current.getParent();
				}
				
				while(!sX.isEmpty())
				{
				
					cengman.getPathX().enqueue(sX.pop());
					cengman.getPathY().enqueue(sY.pop());
				}
				
			}
	   	
		
	
		
			
			for(int i=0; i<map.length; i++)
			{
				for(int j=0; j<map[0].length;j++)
				{
					map[i][j].setParent(null);
				}
			}
			
			while(!x.isEmpty())
			{
				x.dequeue();
			}
			while(!y.isEmpty())
			{
				y.dequeue();
			}
			
	   }
	   
	   public void moveCengman(boolean cengmanclicked, CengMAN cengman, Point[][] map)throws InterruptedException
	   {
		   cengmanclicked=true;
		   Point destination = move(map);
		   if(destination==null)
		   {
			   cengmanclicked=false;
		   }
		   else
		   {			  
			   pathfinding(cengman, destination, map);
		   }
		   
	   }
	   
	   
 	   public Game() throws IOException, InterruptedException
	{
		 // ------ Standard code for mouse and keyboard ------ Do not change
	      tmlis=new TextMouseListener() {
	         public void mouseClicked(TextMouseEvent arg0) {}
	         public void mousePressed(TextMouseEvent arg0) {
	            if(mousepr==0) {
	               mousepr=1;
	               mousex=arg0.getX();
	               mousey=arg0.getY();
	            }
	         }
	         public void mouseReleased(TextMouseEvent arg0) {}
	      };
	      cn.getTextWindow().addTextMouseListener(tmlis);
	      
	      
	      
		Random random = new Random();
		Player player = new Player(200, 200, 200);
		PC pc  = new PC (200, 200, 200);
		
		

		//MAP LOADING
		int file=0;
//		Readfile map1 = new Readfile("C:\\Ceng-a-WAR\\Maps\\map.txt");
//		Readfile map2 = new Readfile("C:\\Ceng-a-WAR\\Maps\\map2.txt");
//		Readfile map3 = new Readfile("C:\\Ceng-a-WAR\\Maps\\map3.txt");
		 
		for(int i=0; i<map.length; i++)
		   {
			 for(int j=0; j<map[0].length; j++)
			   {
				   map[i][j] = new Point();
			   }
		   }
		
		
		
		boolean forever = true;
		file = menu(forever);
		

		//make this an option
//		public void intializeMap()
//		{
//			for(int i=0; i<map.length; i++)
//			{
//				for(int j=0; j<map[0].length; j++)
//				{
//					map[i][j].setCharacter();
//				}
//			}
//		}
	
		//Initialization

		initializeMap(map, screenx, file);
		boolean cengmanclicked=false;
		int selectedcengman=-1;
		
		//Base Generation

		generateBases(map, random, player, pc);
		
	
		screen(map, countqueue);
		
	     int px=5,py=5;
	     cn.getTextWindow().output(px,py,'P');
	     
	      //The game & flow
	      while(true)
	      {
	    	  
	    	  screen(map, countqueue);

	  		//Testing
	  		player.createCengMAN();
	  		pc.createCengMAN();
	  		
	  		if(player.getCengman(0)!=null && pc.getCengman(0)!=null)
	  		{
	  			
	  			player.getCengman(0).getLocation().setX_coordinate(3);
	  			player.getCengman(0).getLocation().setY_coordinate(7);
	  			pc.getCengman(0).getLocation().setX_coordinate(7);
	  			pc.getCengman(0).getLocation().setY_coordinate(4);	  			
	  			map[player.getCengman(0).getLocation().getX_coordinate()][player.getCengman(0).getLocation().getY_coordinate()].setCharacter('C');
	  			map[player.getCengman(0).getLocation().getX_coordinate()][player.getCengman(0).getLocation().getY_coordinate()].setCharacter('C');

	  			map[player.getCengman(0).getLocation().getX_coordinate()][player.getCengman(0).getLocation().getY_coordinate()].setData("PL"+"C"+0);	  			
	  			map[pc.getCengman(0).getLocation().getX_coordinate()][pc.getCengman(0).getLocation().getY_coordinate()].setData("PC"+"C"+0);

	  			
	  			Point selectcengman = move(map);
	  			
	  			if(cengmanclicked && selectcengman!=null)
	  			{

	  				Point destination = selectcengman;
	  		
	  			   if(destination!=null)
	  			   {			  
	  				   pathfinding(player.getCengman(selectedcengman), destination, map);
	  			   }
	  			   cengmanclicked=false;	
	  			}
	  			
	  			if(selectcengman!=null && selectcengman.getData()!=null &&selectcengman.getData().substring(0, 3).equalsIgnoreCase("PLC"))
	  			{

	  				cengmanclicked=true;
	  				selectedcengman = Integer.parseInt(selectcengman.getData().substring(3));
	  			}
	  		
	  			
//	  			pathfinding(player.getCengman(0), map[16][44], map);
	  			
	  			while(!player.getCengman(0).getPathX().isEmpty())
	  			{
	  				cn.getTextWindow().setCursorPosition((int)player.getCengman(0).getPathY().peek()+5, (int)player.getCengman(0).getPathX().peek()+3);
	  				cn.getTextWindow().output('.');
//	  				map[(int)player.getCengman(0).getPathX().peek()][(int)player.getCengman(0).getPathY().peek()].setCharacter('.');
	  				player.getCengman(0).getPathX().dequeue();
	  				player.getCengman(0).getPathY().dequeue();
	  			}
	  		
	  		}

	  		
	        // if(mousepr==1) {  // if mouse button pressed
	            //cn.getTextWindow().output(mousex,mousey,'');  // write a char to x,y position without changing cursor position
	            //px=mousex; py=mousey;
	            
	           // mousepr=0;     // last action  
	         //}
	         mouseop();
	         if(keypr==1) {    // if keyboard button pressed
	            if(rkey==KeyEvent.VK_LEFT) px--;   
	            if(rkey==KeyEvent.VK_RIGHT) px++;
	            if(rkey==KeyEvent.VK_UP) py--;
	            if(rkey==KeyEvent.VK_DOWN) py++;
	            
	            char rckey=(char)rkey;
	            //        left          right          up            down
	            if(rckey=='%' || rckey=='\'' || rckey=='&' || rckey=='(') cn.getTextWindow().output(px,py,'P'); // VK kullanmadan test teknigi
	            else cn.getTextWindow().output(rckey);
	            
	            if(rkey==KeyEvent.VK_SPACE) {
	               String str;         
	               str=cn.readLine();     // keyboardlistener running and readline input by using enter 
	               cn.getTextWindow().setCursorPosition(5, 20);
	               cn.getTextWindow().output(str);
	            }
	            
	            keypr=0;   
	            screenx++;// last action  
	         }
	         Thread.sleep(20);
	         
	         
	      }
	      
	      
		
		
			
			
//			//Display
//			for(int i=0;i<map.length;i++)
//			{
//				cn.getTextWindow().setCursorPosition(3, i+3);
//				for(int j=0; j<map[0].length;j++)
//				{
//					cn.getTextWindow().output(map[i][j].getCharacter());
//				}
//				
//			}
			
			
//		//Testing
//		String product;	
//		player.getBase().getBase_commands().enqueue("T1");
//		product = player.getBase().getBase_commands().peek().toString().substring(0, 1);
//		
//			
//
//		pc.createCengMAN();
		
		
		
		
		
	}




}
