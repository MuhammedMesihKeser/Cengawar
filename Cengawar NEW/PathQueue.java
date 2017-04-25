
public class PathQueue {
	
	private CircularQueue x;
	private CircularQueue y;
	
	
	public PathQueue()
	{
		x= new CircularQueue(999);
		y= new CircularQueue(999);
	}

	public int getXva() {
		
		return (int)x.peek();
	}

	public void setXva(int x) {
		this.x.enqueue(x);
		}

	public int getYva() {
		return (int)y.peek();
	}

	public void setYva(int y) {
		this.y.enqueue(y);
	}

	public CircularQueue getX() {
		return x;
	}

	public void setX(CircularQueue x) {
		this.x = x;
	}

	public CircularQueue getY() {
		return y;
	}

	public void setY(CircularQueue y) {
		this.y = y;
	}
	
	
}
