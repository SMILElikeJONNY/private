import java.applet.*;
import java.awt.*;

public class FirstApplet extends Applet implements Runnable{
	int x_pos = 10;
	int y_pos = 100;
	int radius = 20;
	public void init(){}
	public void start(){
		Thread th = new Thread(this);
		th.start();
	}
	public void stop(){}

	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		while(true){

			x_pos ++;
			repaint();
			try{
				Thread.sleep(20);

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