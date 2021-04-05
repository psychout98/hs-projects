import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class corey extends JFrame {
	
	JPanel panel = new graphic();
	double seconds = 0;
	double time = 1, speed = 1;
	int cR = 255,cG=255,cB=255,AcR=75,AcG=155,AcB=255;
	
	corey() throws InterruptedException{
		super("Corey's Silly Chemathon Project");
		this.setSize(500, 500);
		this.setVisible(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		while(true){
			Thread.sleep(5);
			repaint();
			seconds+=.005;
			if(seconds >= time && seconds <=time+speed){
				cR = 255-(int)(AcR*((seconds-time)/speed));
				cG = 255-(int)(AcG*((seconds-time)/speed));
				cB = 255-(int)(AcB*((seconds-time)/speed));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		corey window = new corey();
	}

	public class graphic extends JPanel{
		
		public void paint(Graphics p){
			p.setColor(Color.gray);
			p.fillRect(0, 0, 500, 500);
			p.setColor(Color.white);
			p.fillRect(100, 50, 300, 50);
			p.setColor(Color.black);
			p.drawLine(100, 50, 400, 50);
			p.drawLine(100, 50, 100, 425);
			p.drawLine(125, 450, 375, 450);
			p.drawLine(400, 50, 400, 425);
			p.fillArc(100, 400, 50, 50, 180, 90);
			p.fillArc(350, 400, 50, 50, 270, 90);
			p.setColor(new Color(cR,cG,cB));
			int[][] pts = {{101,399,399,375,125,101},
							{100,100,425,449,449,425}};
			p.fillPolygon(pts[0], pts[1], 6);
			p.fillArc(101, 399, 50, 50, 180, 90);
			p.fillArc(349, 399, 50, 50, 270, 90);
			
		}
		
	}
}
