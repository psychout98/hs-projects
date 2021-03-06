import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
public class Spectrum extends JFrame{
	Random rand = new Random();
	JPanel clock;
	int c[]=new int[3];
	Spectrum() throws InterruptedException{
		super("Clock");
		init();
		this.setSize(600,600);
		this.setVisible(true);
		this.add(clock);
		int r[]={1,2,0,0,2,1},
			g[]={0,0,2,1,1,2},
			b[]={2,1,1,2,0,0};
		while(true){
			for(int j=0;j<6;j++)
		for(int i=0;i<6;i++)
		for(int k=0;k<255;k++){
		Thread.sleep(10);
		if(i==0)
		c[g[j]]++;
		else if(i==1)
		c[r[j]]++;
		else if(i==2)
		c[b[j]]++;
		else if(i==3)
		c[g[j]]--;
		else if(i==4)
		c[r[j]]--;
		else if(i==5)
		c[b[j]]--;
		repaint();
		}	
		}
	}
	
	public void init(){
		clock = new Clockpanel();
	}
	public static void main(String[]args) throws InterruptedException{
		Spectrum window=new Spectrum();
		window.setDefaultCloseOperation(3);
	}
	private class Clockpanel extends JPanel{
		public void paintComponent(Graphics p){
			Color Color=new Color(c[0],c[1],c[2]);
			p.setColor(Color);
			p.fillRect(0, 0, 600, 600);
			
			}
	}
}
