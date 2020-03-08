package circles;

import java.awt.*;

public class Circle {
private int node;
public int x;
public int y;
public boolean state;
Graphics graphics;
public Circle(int n,Graphics g,int a,int b) {
	this.node=n;
	this.graphics=g;
	this.x=a;
	this.y=b;
	graphics.setColor(Color.BLACK);
	System.out.print(graphics);
	graphics.fillOval(x, y,10,10);
	Color[] colors = {Color.red, Color.black, Color.blue,Color.white};
}
public void turnOn(Color c) 
	{
	graphics.setColor(c);
	graphics.fillOval(x, y,10,10);
	}
public void turnOff() 
{
state=false;
graphics.setColor(Color.white);
graphics.fillOval(x, y,10,10);
}

}
