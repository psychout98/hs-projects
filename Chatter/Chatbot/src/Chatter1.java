import java.awt.AWTException;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Chatter1 extends JFrame implements ActionListener, KeyListener {
	static JTextPane Statement, Response;
	static int verbEnd = 0;
	static boolean go = false, responded = false;
	static String keyword, response, keywords[], responses[], arrayList = "",
			words[], definitions[], questionStarter[] = { "what", "who","where","when", "why" }, array[],
			verb[], noun[], description[];
	static File  File2 = new File("Words.txt");

	Chatter1() {
		super("Chatbot");
		this.setSize(500, 100);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(500, 200);
		this.setLayout(new GridLayout(1, 1));
		this.setDefaultCloseOperation(3);
		init();
	}

	public void init() {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		Statement = new JTextPane();
		Statement.setEditable(true);
		Statement.addKeyListener(this);
		Statement.setBorder(BorderFactory.createLineBorder(Color.black));
		Response = new JTextPane();
		Response.setEditable(false);
		Response.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.add(Response);
		panel.add(Statement);
		this.add(panel);
	}

	public static void Respond(String statement) throws IOException {
		boolean any = false, anyWords = false;
		if (statement.startsWith("learn"))
			Learn(statement.substring(6));
		else {
			if (statement.endsWith("?")) {
				Answer(statement);
				any = true;
			}
			for (int i = 0; i < array.length; i++)
				if (statement.contains(array[i])) {
					Response.setText("I knew that.");
					any = true;
				} else {
					int space = -1;
					for (int k = 0; k < statement.length(); k++)
						if (statement.charAt(k) == ' ') {
							space = k;
							break;
						}
					for (int j = 0; j < array.length; j++)
						if (statement.substring(space + 1,
								statement.length() - 2).contains(noun[j]))
							anyWords = true;
					if (!anyWords)
						Response.setText("What is "
								+ statement.substring(space + 1,
										statement.length() - 2));
				}
			if (!any) {
				Response.setText(getRandomResponse());
			}
		}

	}

	public static void Answer(String statement) {
		for (int i = 0; i < questionStarter.length; i++)
			if (statement.startsWith(questionStarter[i])) {
				for (int j = 0; j < array.length; j++) {
					if (getVerb(statement, questionStarter[i])
							.contains(verb[j])
							&& statement.substring(verbEnd).contains(noun[j])) {
						Response.setText(array[j]);
						break;
					}
				}
			}
	}

	public static String getVerb(String statement, String starter) {
		int start = starter.length() + 1;
		for (int i = start; i < statement.length(); i++)
			if (statement.charAt(i) == ' ') {
				verbEnd = i;
				break;
			}
		return statement.substring(start, verbEnd);
	}

	public static void Learn(String statement) throws IOException {
		Scanner scan = new Scanner(File2);
		arrayList = "";
		while (scan.hasNextLine())
			arrayList += scan.nextLine() + "\n";
		arrayList += statement;
		FileWriter fw = new FileWriter(File2.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(arrayList);
		bw.close();
		redefineArrays();
		Response.setText("Okay, " + statement);
	}

	public static boolean isCommand(String statement) {
		return false;
	}

	private static String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		}

		return response;
	}

	public static void main(String[] args) throws InterruptedException,
			IOException, AWTException {

		Chatter1 window = new Chatter1();
		redefineArrays();
		Response.setText("Hello, lets talk.");
		while (!Statement.getText().toLowerCase().equals("bye")) {
			if (go) {
				Respond(Statement.getText());
				go = false;
				responded = true;
			}
			Thread.sleep(100);
		}

	}

	public static void redefineArrays() throws FileNotFoundException {
		Scanner as1 = new Scanner(File2), as2 = new Scanner(File2);
		int lines = 0, space = 0, space2 = 0;
		while (as1.hasNextLine()) {
			arrayList += as1.nextLine() + "\n";
			lines++;
		}
		array = new String[lines];
		noun = new String[lines];
		verb = new String[lines];
		description = new String[lines];
		for (int l = 0; l < lines; l++) {
			String line = as2.nextLine();
			array[l] = line;
			for (int i = 0; i < line.length(); i++)
				if (line.charAt(i) == ' ') {
					space = i;
					i = line.length();
				}
			noun[l] = line.substring(0, space);
			for (int i = space + 1; i < line.length(); i++)
				if (line.charAt(i) == ' ') {
					space2 = i;
					i = line.length();
				}
			verb[l] = line.substring(space + 1, space2);
			description[l] = line.substring(space2 + 1);

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (responded && e.getKeyCode() == e.getKeyCode()) {
			Statement.setText("");
			responded = false;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Robot r;

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				r = new Robot();
				r.keyPress(KeyEvent.VK_BACK_SPACE);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			go = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}