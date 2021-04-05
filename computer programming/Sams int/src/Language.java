import java.awt.AWTException;

import java.awt.BorderLayout;

import java.awt.Color;

import java.awt.Component;

import java.awt.Font;

import java.awt.GridLayout;

import java.awt.Robot;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JTextArea;

import javax.swing.text.JTextComponent;

public class Language extends JFrame implements ActionListener, MouseListener,

KeyListener {

	

		
		

	private static final long serialVersionUID = 1L;

	JPanel panel, panel1;

	static Robot robot;

	JButton done = new JButton("done");

	static JTextArea a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s,

	t, u, v, w, x, y, z, n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, page;

	static JTextArea[] area = { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,
			q, r,

			s, t, u, v, w, x, y, z, n1, n2, n3, n4, n5, n6, n7, n8, n9, n0 };

	static String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K",

			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",

			"Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "","~","`","!","@" };

	String[] letters1 = new String[letters.length];

	Font font;

	Language() {

		super("Secret Language");

		init();

		this.setSize(200, 300);

		this.setVisible(true);

	}

	public void init() {

		Font font = new Font("Times New Roman", Font.BOLD, 16);

		panel1 = new JPanel(new GridLayout(1, 1));

		done.addActionListener(this);

		panel1.add(done);

		panel = new JPanel(new GridLayout(12, 3));

		for (int i = 0; i < area.length; i++) {

			area[i] = new JTextArea(letters[i]);

			area[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

			area[i].addMouseListener(this);

			area[i].setFont(font);

			panel.add(area[i], BorderLayout.CENTER);

		}

		this.add(panel, BorderLayout.CENTER);

		this.add(panel1, BorderLayout.SOUTH);

	}

	public static void main(String[] args) throws AWTException {

		Language window = new Language();

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		robot = new Robot();

	}

	@Override
	public void actionPerformed(ActionEvent me) {

		if (me.getSource() == done) {

			for (int i = 0; i < area.length - 1; i++) {

				letters1[i] = area[i].getText();

				System.out.println(letters1[i]);

			}

			this.remove(panel);

			Notepad();

		}

	}

	JButton Translate = new JButton();

	public void Notepad() {

		init1();

		this.setVisible(true);

		this.setSize(600, 400);

		this.addKeyListener(this);

	}

	private void init1() {

		page = new JTextArea();
		Translate.addActionListener(this);
		page.add(Translate);
		page.addKeyListener(this);

		this.add(page, BorderLayout.CENTER);

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == e.getKeyCode()) {

			robot.keyPress(KeyEvent.VK_BACK_SPACE);

			robot.keyPress(keys(KeyEvent.getKeyText(e.getKeyCode()),
					e.getKeyCode()));

		}

	}

	public int keys(String key, int keyCode) {

		for (int i = 0; i < area.length - 1; i++) {

			if ((letters[i].equals(key))) {

				System.out.println(key + " " + letters1[i]);

				keyCode = letters1[i].charAt(0);

				return keyCode;

			}

		}

		return keyCode;

	}

	@Override
	public void keyPressed(KeyEvent me) {

	}

	@Override
	public void keyTyped(KeyEvent me) {

	}

	public void mouseClicked(MouseEvent me) {

		if (me.getSource() == (me.getSource())) {

			((JTextComponent) me.getSource()).setText(letters[36]);

		}

	}

	@Override
	public void mouseEntered(MouseEvent me) {

	}

	@Override
	public void mouseExited(MouseEvent me) {

	}

	@Override
	public void mousePressed(MouseEvent me) {

		if (me.getSource() == (me.getSource())) {

			((JTextComponent) me.getSource()).setText(letters[36]);

		}

	}

	@Override
	public void mouseReleased(MouseEvent me) {

	}

}