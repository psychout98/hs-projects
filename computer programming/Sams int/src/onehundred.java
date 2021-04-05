import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class onehundred extends JFrame{
	static int Hours=12;
	static int Minutes=0;
	static int Seconds=0;
	static JTextPane Time = new JTextPane();
	onehundred(){
		super("Clock");
		init();
		this.setSize(190,110);
		this.setVisible(true);
		this.setLocation(500,500);
	}
	
	public void init(){
		JPanel panel = new JPanel(new GridLayout(1,1));
		panel.setBackground(Color.WHITE);
		Font f = new Font("Times New Roman", Font.BOLD,30);
		Font f2 = new Font("Times New Roman",Font.BOLD,20);
		Time.setFont(f);
		Time.setEditable(false);
		panel.add(Time);
		this.add(panel, BorderLayout.CENTER);
	}
	
public static void main(String[]args)throws InterruptedException{
	String ap="AM";
	onehundred window = new onehundred();
	window.setDefaultCloseOperation(3);
	while(true){
		Time.setText(""+Hours+":0"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
	for(int h=0;h<12;h++){
	
		for(int m=0;m<60;m++){
			for(int s=0;s<60;s++){
				if(m<10){
					if(s<9){
						Thread.sleep(1000);
						Seconds = Seconds+1;
						Time.setText(""+Hours+":0"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
					}
					if(s>8){
					Thread.sleep(1000);
					Seconds = Seconds+1;
					Time.setText(""+Hours+":0"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
					}
					
				}
				if(m>9){
					if(s<9){
						Thread.sleep(1000);
						Seconds = Seconds+1;
						Time.setText(""+Hours+":"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
					}
					if(s>8){
					Thread.sleep(1000);
					Seconds = Seconds+1;
					Time.setText(""+Hours+":"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
					}
					}
			}
			Seconds=-1;
			Minutes=Minutes+1;
		}
		Minutes=0;
	Time.setText(""+Hours+":"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
	Hours = Hours+1;
	if(Hours==13){
		Hours=1;
	}
	Time.setText(""+Hours+":"+Minutes+"\t"+ap+"\n\t\t"+Seconds);
	}
	if(ap.toLowerCase().contains("a")){
		ap="PM";
	}
	if(ap.toLowerCase().contains("p")){
		ap="AM";
	}
	Hours=12;
	Minutes=0;
	Seconds=0;
	}
	
}
}