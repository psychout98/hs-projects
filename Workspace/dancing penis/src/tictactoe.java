import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class tictactoe extends JFrame implements ActionListener{

	JButton b[][] = new JButton[3][3],startX = new JButton("X"),startO = new JButton("O");
	JPanel p[][] = new JPanel[3][3],v[][] = new JPanel[3][3];
	boolean x = false;
	JPanel doogie = new JPanel(new GridLayout(3,3));
	int[][] xos = {{0,0,0},{0,0,0},{0,0,0}};
	boolean started = false;
	Random rand = new Random();
	
	tictactoe() throws IOException, InterruptedException{
		super("dick dank dildo");
		this.setSize(500,500);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(3);
		String f[] = {"put ur dick here","put ur wank in me", "fuq nuggits", "make me ur daddy", "typical bitch","spill ur seed in me",
				"over here dipshit", "ur pushing rope rn","don't pick me I'm shy"};
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				p[i][j] = new imagePanel(true);
				v[i][j] = new imagePanel(false);
				b[i][j] = new JButton(f[3*i+j]);
				b[i][j].addActionListener(this);
			}
		startX.addActionListener(this);
		startO.addActionListener(this);
		doogie.add(startX);
		doogie.add(startO);
		this.add(doogie);
		this.setVisible(true);
		while(!started){
			if(started)
			break;
			Thread.sleep(500);
		}
		System.out.println("poop");
		redoButtons(xos);
	}
	public class imagePanel extends JPanel{
		
		private BufferedImage image;
		
		public imagePanel(boolean pv) throws IOException{
			if(pv)
			image = ImageIO.read(new File("238652949.jpg"));
			else
			image = ImageIO.read(new File("vagina-illustration.jpg"));
		}
		
		public void paint(Graphics g){
			super.paintComponent(g);
	        g.drawImage(image, 0, 0, this);
		}
	}

	public void redoButtons(int[][] oxs){
		doogie.removeAll();
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				if(oxs[i][j] == 0)
					doogie.add(b[i][j]);
				else if (oxs[i][j] == 1)
					doogie.add(p[i][j]);
				else
					doogie.add(v[i][j]);				
			}
		this.validate();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		tictactoe dildopolis = new tictactoe();
	}
	
	public void compGo(){
		int row = rand.nextInt(3),col= rand.nextInt(3);
		while(xos[row][col]>0){
		row= rand.nextInt(3);
		col=rand.nextInt(3);
		}
		if(x){
			xos[row][col] = 2;
			redoButtons(xos);
			check();
		}
		else{
			xos[row][col] = 1;
			redoButtons(xos);
			check();
		}

		if(check())
			fin();
	}
	
	public boolean check(){
		boolean tictactoe=false;
		for(int i =0;i<3;i++){
				if(xos[i][0]>0&&xos[i][0]==xos[i][1] && xos[i][0]==xos[i][2])
					tictactoe=true;
				if(xos[0][i]>0&&xos[0][i]==xos[1][i] && xos[0][i] == xos[2][i])
					tictactoe=true;
		}
		if(xos[0][0]>0&&xos[0][0]==xos[1][1]&&xos[0][0]==xos[2][2])
			tictactoe=true;
		if(xos[0][0]>0&&xos[2][0]==xos[1][1]&&xos[0][2]==xos[2][0])
			tictactoe=true;
		return tictactoe;
	}
	public void fin(){
		doogie.removeAll();
		JLabel label = new JLabel("Somebody won, I don't care who.");
		doogie.add(label);
		doogie.validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startX){
		x= true;
		started=true;
		}
		if(e.getSource() == startO)
		started=true;
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++){
				if(e.getSource() == b[i][j])
					if(x){
						xos[i][j] = 1;
						if(check())
							fin();
						redoButtons(xos);
						compGo();
					}
					else{
						xos[i][j] = 2;
						if(check())
							fin();
						redoButtons(xos);
						compGo();
					}
						
				
			}
	}

}
