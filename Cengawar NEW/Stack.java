
public class Stack {

	private int top = -1;
	private Object s[];
	
	
	public Stack(int capacity)
	{
		s= new Object[capacity];
	}
	
	
	//Operations
	
	//Push
	public void push(Object newaddition)
	{
		if(!isFull())
		{
		top++;
		s[top]=newaddition;
		}
		else
		{
			System.out.println("Stack Overflow");
		}
	}
	
	//Pop
	public Object pop()
	{
        if (isEmpty()) 
        {
        	throw new RuntimeException("Stack underflow");
       	}
		Object temporary = s[top];
		s[top]=null;
		top--;
		return temporary;

	}
	
	//Peek
	public Object peek()
	{
		if(!isEmpty())
		{
		return s[top];
		}
		else
		{
		System.out.println("Stack Underflow");
		return null;
		}
	}
	
	//Is Empty
	public boolean isEmpty()
	{
		if(top==-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Is Full
	public boolean isFull()
	{
		if(top==s.length-1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	//Top Getter
	public int size() {
		return top+1;
	}





}
