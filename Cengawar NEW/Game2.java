

	import enigma.core.Enigma;
	import enigma.event.TextMouseEvent;
	import enigma.event.TextMouseListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;

	import org.omg.Messaging.SyncScopeHelper;

	import enigma.console.TextAttributes;
	import java.awt.Color;

	public class Game2 {
	   public enigma.console.Console cn = Enigma.getConsole("Mouse and Keyboard");
	   public TextMouseListener tmlis; 
	   public KeyListener klis; 
	   private int time;
	   private int Current_time;
	   private int temp_time;
	   private int c_x = 0;
	   private int c_y = 0;
	   private String[] birim = new String[19];
	   char[][] map = new char[49][19];
	  Queue q = new Queue(5);
	  String queue;
	  int countqueue = 0;
	  
	  int screenx = 0;
	   // ------ Standard variables for mouse and keyboard ------
	   public int mousepr;          // mouse pressed?
	   public int mousex, mousey;   // mouse text coords.
	   public int keypr;   // key pressed?
	   public int rkey;    // key   (for press/release)
	   // ----------------------------------------------------
	  
	   public void Screen() throws IOException {
		   
	       /*FileReader fileReader = new FileReader("C:\\map.txt");
	       String line;

	       BufferedReader br = new BufferedReader(fileReader);
	       
	       for (int i = 0; i < map.length; i++)
		   {     line = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = line.substring(i,1);
			}
		   }
	       br.close();
	       
	       for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					cn.getTextWindow().setCursorPosition(5 + i, + j);
					cn.getTextWindow().output(map[i][j]);
					
				}
			}*/
		   if(screenx == 0)
		   {
		   FileReader fileReader = new FileReader("C:\\map.txt");
		   String line;

		   BufferedReader br = new BufferedReader(fileReader);
	         int x = 0;
		   while ((line = br.readLine()) != null) {

		       birim[x] = line;
	          x++;
		   }

		   br.close();
		   for (int i = 0; i < 19; i++)
		   {     
			for (int j = 0; j < 49; j++) {
				map[j][i] = birim[i].charAt(j);
			}
		   }
		   }
		  
		   
		   for (int i = 0; i < 19; i++) {
				for (int j = 0; j < 49; j++) {
					cn.getTextWindow().setCursorPosition(5 + j,3 + i);
					cn.getTextWindow().output(map[j][i]);
					
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
	   
		   
	   public void move(){
		   map[5][5] = 'C';
		   if(mousepr == 1 )
		   {
			   if(mousex < 54 && mousex >5)
			   {
				   if(mousey <22 && mousey>3)
				   {
					    
					   map[mousex-5][mousey-3] = 'V';
				   }
			   }
			   
			   
		   }
		   
		   
	   }
	   Game2() throws Exception {   // --- Contructor
	                 
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
	    
	      klis=new KeyListener() {
	         public void keyTyped(KeyEvent e) {}
	         public void keyPressed(KeyEvent e) {
	            if(keypr==0) {
	               keypr=1;
	               rkey=e.getKeyCode();
	            }
	         }
	         public void keyReleased(KeyEvent e) {}
	      };
	      cn.getTextWindow().addKeyListener(klis);
	      // ----------------------------------------------------
	      

	      int px=5,py=5;
	      cn.getTextWindow().output(px,py,'P');
	      while(true) {
	    	  Screen();
	    	  move();
	    	  Screen();
	    	  
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
	      
	   }
	   
	


}
