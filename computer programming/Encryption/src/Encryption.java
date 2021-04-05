import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
public class Encryption extends JFrame implements ActionListener{
	static JTextPane text;
	JButton start = new JButton("Encrypt Message");
	static boolean Start = false;
	static String indexChar[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"0", " ", "~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "(",
			")", "-", "_", "+", "=", "{", "[", "}", "]", "|", ":", ";", "'",
			"<", ",", ">", ".", "?", "/" }, indexNum[] = { "00", "01", "02",
			"03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
			"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
			"25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35",
			"36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
			"47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57",
			"58", "59", "60", "61", "62", "63", "64", "65", "66"},
			encryptedIndex[] = new String[indexChar.length],
			legend[] = new String[indexChar.length], message,
			encryptedMessage = "";
	
	Encryption(){
		text = new JTextPane();
		start.addActionListener(this);
		this.setSize(500,200);
		this.setVisible(true);
		this.setLayout(new GridLayout(2,1));
		this.add(text);
		this.add(start);
		
	}

	public static void main(String[] args) throws InterruptedException {
		Encryption window = new Encryption();
		Random rand = new Random();
		boolean numUsed[] = { false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false, false, false, false,
				false, false, false, false, false, false };
		for (int i = 0; i < indexChar.length; i++) {
			int num = rand.nextInt(indexChar.length);
			while (numUsed[num])
				num = rand.nextInt(indexChar.length);
			encryptedIndex[i] = indexNum[num];
			legend[i] = indexNum[i] + encryptedIndex[i];
			numUsed[num] = true;
		}
		for(int i=0;i<numUsed.length;i++)
			numUsed[i]=false;
		while(!Start){}
		message = text.getText();
		for (int i = 0; i < (message.length()>indexChar.length?message.length():indexChar.length); i++) {
			if(i<message.length())
			encryptedMessage += toEncryption(String.valueOf(message.charAt(i)));
			if (i < indexChar.length) {
				int num = rand.nextInt(indexChar.length);
				while (numUsed[num])
					num = rand.nextInt(indexChar.length);
				encryptedMessage += legend[num] + ".";
				numUsed[num] = true;
			}
		}
		Decryption decryptedMessage = new Decryption(encryptedMessage);
		Password finalDecryption = new Password(decryptedMessage.toString());
		
	}

	public static String toEncryption(String letter) {
		int num = 0;
		for (int i = 0; i < indexChar.length; i++)
			if (letter.toLowerCase().contains(indexChar[i]))
				num = i;
		return encryptedIndex[num] + ".";
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == start)
			Start = true;
	}

}
