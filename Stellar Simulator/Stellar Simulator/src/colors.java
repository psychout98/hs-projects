import java.awt.*;

import javax.swing.*;

public class colors extends JApplet{
	

	/*
1	 * 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ&@#$%&
2	 * 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ&@#$
3	 * 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ&@#$
4	 * 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRST
	 */
	
	String[][] pixel = new String[1200][700];
	
	public void paint(Graphics p){
		setSize(1200,700);
		p.setColor(Color.black);
		p.fillRect(0, 0, 1200, 700);
		for(int x=0;x<1200;x++)
			for(int y=0;y<700;y++)
				draw(x,y,p);
	}
	
	public void draw(int x, int y, Graphics p){
		p.setColor(getColor(pixel[x][y]));
		p.fillRect(x, y, 1, 1);
	}
	
	public Color getColor(String dh){
		return new Color(255,255,255);
	}
	
	}
