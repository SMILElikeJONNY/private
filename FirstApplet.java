import java.applet.*;
import java.awt.*;

public class FirstApplet extends Applet implements Runnable{
	int x_pos = 10;
	int y_pos = 100;
	int radius = 20;
	int x_speed = 1;
	int y_speed = 1;
	int appletSize_x = 300;
	int appletSize_y = 300;

	public void init(){
		setBackground(Color.blue);
	}
	public void start(){
		Thread th = new Thread(this);
		th.start();
	}
	public void stop(){}

	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true){

			if(MouseInfo.getPointerInfo().getLocation().x == 300 && MouseInfo.getPointerInfo().getLocation().y == 300){
			  x_speed = -1;
			}

			if(x_pos > appletSize_x-radius){
				x_speed = -1;
				y_speed = -1;
			}
			if(x_pos < radius){
				x_speed = 1;
				y_speed = 1;
			}

			y_pos += y_speed;
			x_pos += x_speed;
			repaint();

			try{
				Thread.sleep(5);

			}
			catch(InterruptedException ex){

			}
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		}
	}

	public void destory(){}
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.fillOval(x_pos -radius,y_pos-radius,2*radius,2*radius);
	}

}