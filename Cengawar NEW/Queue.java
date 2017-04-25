

public class Queue {

	private Object elements[];
	private int front, rear;
	
	
	
	
	public Queue(int capacity)
	{
		elements=new Object[capacity];
		front =0;
		rear =-1;
	}
	
	public boolean isEmpty()
	{
		if(rear<front)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isFull()
	{
		return (rear +1 == elements.length);
	}
	
	public void enqueue(Object data)
	{
		if (isFull())
		{
			System.out.println("Queue Overflow");
		}
		else
		{
			rear++;
			elements[rear]=data;
		}
	}
	
	public Object dequeue()
	{
		if (isEmpty())
		{
			System.out.println("Queue Underflow");
			return null;
		}
		else
		{
			Object returnData = elements[front];
			elements[front]=null;
			front++;
			return returnData;
		}
		
		
	}
	
	
	public Object peek()
	{
		if (isEmpty())
		{
			System.out.println("Queue is empty");
			return null;
		}
		else
		{
			return elements[front];
		}
		
	}
	
	
	public int size()
	{
		return rear - front +1;
	}
	
	
	
}
