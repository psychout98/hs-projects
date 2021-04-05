import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class site2 extends JApplet {

	public void go() throws IOException, InterruptedException{
		JPanel panel = new site4("TEST");
		add(panel);
	}

}

	/*
	 * method of putting custom items into page list Tune to user friendly
	 

	JButton b[] = { new JButton("Add Custom RadioButton"),
			new JButton("Add Custom Checkbox"),
			new JButton("Add Custom Input Field"),
			new JButton("Add Custom Section"), new JButton("Add Custom Label") },
			finish;
	boolean sel[] = { false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false },
			done = false;
	String Name, standards[] = { "General User Info Label", "First Name Field",
			"Last Name Field", "Employee Title Field", "Phone Extension Field",
			"Start Date Field", "Cell Number Field", "Office Site Field",
			"Desk Location Field", "General Access Information Label",
			"Email Address Field", "Email Alias Field",
			"Desired Username Field", "Desired Password Field",
			"Specific Access Information Label", "Networked Drives Section",
			"User Calendar Access Section",
			"Other Employee Calendar Access Section",
			"User to Other Email Section", "Other user to Email Section",
			"Email Distribution Lists Section", "Shared Peripherals Section",
			"APPLICATION ACCESS Section" }, sections[] = {
			"Below user info section", "Inside drive access section",
			"Below drive access section", "Inside application access section",
			"Below application access section",
			"Below special instructions section" };
	String locats[] = new String[standards.length];
	ArrayList secs = new ArrayList();
	field[] CFS = new field[0];
	int lat = -1;
	JPanel panel = new JPanel(new GridLayout(36, 1)), panel3 = new JPanel(
			new BorderLayout()),panel2, panel4 = new JPanel(new BorderLayout()),
			panel5 = new JPanel(), panel6 = new JPanel();
	Font f = new Font("Times New Roman", Font.PLAIN, 24);
	JRadioButton[] rbp1 = { new JRadioButton("General User Info Label"),
			new JRadioButton("First Name Field"),
			new JRadioButton("Last Name Field"),
			new JRadioButton("Employee Title Field"),
			new JRadioButton("Phone Extension Field"),
			new JRadioButton("Start Date Field"),
			new JRadioButton("Cell Number Field"),
			new JRadioButton("Office Site Field"),
			new JRadioButton("Desk Location Field"),
			new JRadioButton("General Access Information Label"),
			new JRadioButton("Email Address Field"),
			new JRadioButton("Email Alias Field"),
			new JRadioButton("Desired Username Field"),
			new JRadioButton("Desired Password Field"),
			new JRadioButton("Specific Access Information Label"),
			new JRadioButton("DRIVE / RESOURCE ACCESS Section"),
			new JRadioButton("Networked Drives Section"),
			new JRadioButton("User Calendar Access Section"),
			new JRadioButton("Other Employee Calendar Access Section"),
			new JRadioButton("User to Other Email Section"),
			new JRadioButton("Other User to Email Section"),
			new JRadioButton("Email Distribution Lists Section"),
			new JRadioButton("Shared Peripherals Section"),
			new JRadioButton("APPLICATION ACCESS Section"),
			new JRadioButton("Special Instructions Section") };

	public site2(String name) throws IOException, InterruptedException {
		super("NetLogicDC Form Editor");
		Name = name;
		this.setResizable(false);
		this.setSize(1250, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		panel3.setBackground(new Color(140, 202, 97));
		panel3.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel4.setSize(600, 800);
		JLabel[] l = { new JLabel("Editor"), new JLabel(), new JLabel(),
				new JLabel(" " + name), new JLabel(), new JLabel() };
		panel.add(l[0]);
		panel.add(l[2]);
		for (int i = 0; i < b.length; i++) {
			panel.add(b[i]);
			b[i].addActionListener(this);
		}
		for (int i = 0; i < rbp1.length; i++)
			panel.add(rbp1[i]);
		BufferedImage img = ImageIO.read(new File("logo-white.png"));
		ImageIcon icon = new ImageIcon(img);
		JLabel lbl = new JLabel(icon);
		lbl.setForeground(new Color(123, 185, 80));
		panel3.add(lbl, BorderLayout.WEST);
		finish = new JButton("Finish Form");
		finish.addActionListener(this);
		panel3.add(finish, BorderLayout.EAST);
		l[3].setFont(f);
		l[3].setForeground(Color.white);
		panel3.add(l[3], BorderLayout.SOUTH);
		JScrollPane p = new JScrollPane(panel);
		p.setPreferredSize(new Dimension(300, 800));
		p.getVerticalScrollBar().setUnitIncrement(16);
		panel5.add(p);
		panel4.add(panel3, BorderLayout.NORTH);
		panel2 = showHTML();
		JScrollPane p2 = new JScrollPane(panel2);
		p2.setPreferredSize(new Dimension(600, 800));
		p2.getVerticalScrollBar().setUnitIncrement(16);
		panel4.add(p2, BorderLayout.CENTER);
		this.add(panel5, BorderLayout.WEST);
		this.add(panel4, BorderLayout.CENTER);
		Thread.sleep(1);
		this.setVisible(true);
		f = new Font("Ariel", Font.PLAIN, 14);
		while (!done) {
			panel2 = showHTML();
			validate();
			Thread.sleep(500);
		}
		finish();
		System.exit(0);
	}
	
	public JPanel showHTML(){
		JPanel htmlpanel = new JPanel();
		JEditorPane ed1=new JEditorPane("text/html",write());
		htmlpanel.add(ed1); setVisible(true);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		return htmlpanel;
	}

	
	public String write(){
		String[] customs = new String[CFS.length];
		int[] cs = new int[CFS.length];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = CFS[i].Location;
		}
		String form = (sel[1] ? "First Name: <input type=\\\"text\\\" value=\\\"\"+userinfo[0]+\"\\\"><br><br>"
				: "");
		form += (sel[2] ? "Last Name: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[1];form+=\"\\\"><br><br>"
				: "");
		form += (sel[3] ? "Employee Title: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[2];form+=\"\\\"><br><br>"
				: "");
		form += (sel[4] ? "Phone Extension: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[3];form+=\"\\\"><br><br>"
				: "");
		form += (sel[5] ? "Start Date: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[4];form+=\"\\\"><br><br>"
				: "");
		form += (sel[6] ? "Cell Number: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[5];form+=\"\\\"><br><br>"
				: "");
		form += (sel[7] ? "Office Site: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[6];form+=\"\\\"><br><br>"
				: "");
		form += (sel[8] ? "Desk Location: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[7];form+=\"\\\"><br><br>"
				: "");
		form += (sel[9] ? "Provide general Access Information." : "");
		form += (sel[10] ? "Email Address (will auto populate): <input type=\\\"text\\\" value=\\\"\";form+=userinfo[3];form+=\"\\\"><br><br>"
				: "");
		form += (sel[11] ? "Email Alias: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[8];form+=\"\\\"><br><br>"
				: "");
		form += (sel[12] ? "Desired Username: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[9];form+=\"\\\"><br><br>"
				: "");
		form += (sel[13] ? "Desired Password: <input type=\\\"text\\\" value=\\\"\";form+=userinfo[10];form+=\"\\\"><br><br>"
				: "");
		form += (sel[14] ? "Provide specific access information. Set permissions to drives, resources, etc.<br><br>"
				: "");
		form += (sel[15] ? "<div style=\\\"width:760px;border:1px solid gray;background:#6AA840;\\\">DRIVE / RESOURCE ACCESS<br>"
				: "");
		form += (sel[16] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Which networked drives should the user have access to?<br><br></div>"
				: "");
		form += (sel[17] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Which calendars should the user have access to?<br><br></div>"
				: "");
		form += (sel[18] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Should another employee have access to the new user's calendar?<br><br></div>"
				: "");
		form += (sel[19] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Should the user have access to another user's email?<br><br></div>"
				: "");
		form += (sel[20] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Should another employee have access to the new user's email?<br><br></div>"
				: "");
		form += (sel[21] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Should the user be included in any of the following email distribution lists?<br><br></div>"
				: "");
		form += (sel[22] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>Which shared peripherals should the user have access to?<br><br></div>"
				: "");
		form += (sel[15] ? "</div><br><br>" : "");
		form += (sel[24] ? "<div style=\\\"width:760px;border:1px solid gray;background:#6AA840;\\\">Special instructions<textarea name=\\\"specinstructs\\\" "
				+ "style=\\\"margin:2;resize:none\\\" cols=\\\"105\\\" rows=\\\"10\\\">\"+userinfo[79]+\"</textarea>"
				: "");
		String f = "<Html><Head><Title>"
				+ Name
				+ " - Netlogicdc</Title>"
				+ "<link rel=\"shortcut icon\" type=\"image/x-icon\" "
				+ "href=\"C:/Users/nheath/My Documents/Website/logo.png\" />"
				+ "</Head><Body bgcolor=\"#8CCA61\" style=\"margin:50px\">"
				+ "<a href=\"http://www.netlogicdc.com\">"
				+ "<img src=\"C:/Users/nheath/My Documents/Website/logo-white.png\" style=\"width:240px;height:58px;\">"
				+ "<br><br><br></a><div style=\"float:right;margin:10px 50px 0px 0px;width:35%\"><div style=\"float:right;\">"
				+ "<font size=\"4\" color=\"white\" face=\"Ariel\">Search users:"
				+ "</font><input onkeypress=\"gathertext(form)\" type=\"search\" name=\"searcher\"></div><br><br>"
				+ "<font size=\"5\" color=\"white\" face=\"Ariel\">User List</font><br><br><div style=\"overflow:scroll;width:100%;"
				+ "height:520px;border:1px solid gray;background:#7BB950;\"><a><a style=\"float:left;margin:10px\"><font size=\"4\""
				+ " color=\"black\" face=\"Ariel\">Fake User</font></a><a style=\"float:right;margin:10px\"><input type=\"button\""
				+ " onclick = \"showUser('fakeuser')\" name=\"fake-user\" value=\"View User Data\"></a></a></div></div><div style=\""
				+ "float:left;width:54%;height:540px\"><font id=\"i1\" size=\"6\" color=\"white\" face=\"Ariel\">"
				+ Name
				+ "</font><br><br><a style=\"float:right;\"><input type=\"button\" value=\"New User\" onclick=\"showUser('new')\">"
				+ "<input type=\"button\" onclick=\"makefile()\" value=\"Save User\"></a><br><br>"
				+ "<form id=\"uform\" style=\"float:left;overflow:scroll;width:100%;height:520px;border:1px solid gray;background:#7BB950;\">"
				+ "<div style=\"margin:10px\"><font  size=\"4\" color=\"black\" face=\"Ariel\">These documents serve as tools for adding and editing users "
				+ "and allows netlogicdc technicians to set appropriate permissions for the new user. For security reasons, any new or revised documents must"
				+ " be authorized by an authority at <a id=\"clientname\">"
				+ Name
				+ "</a> to be valid.</font></div></form></div><script>"
				+ "function checkdoc(){}"
				+ "function showUser(x){if(x==\"new\"){"
				+ "userinfo=new Array(\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\","
				+ "\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\","
				+ "\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\","
				+ "\"\",\"\",\"\");}else{var filename = x+\".txt\";"
				+ "userinfo=new Array(\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\","
				+ "\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\","
				+ "\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\",\"\","
				+ "\"\",\"\",\"\");}document.getElementById(\"uform\").innerHTML=\""
				+ "<div style=\\\"margin:10px\\\"><font size=\\\"3\\\" color=\\\"black\\\" face=\\\"Helvetica\\\">"
				+ (sel[0] ? "Provide general user information." : "")
				+ "<input style=\\\"float:right;color:red;\\\" type=\\\"button\\\"onclick=\\\"memo()\\\"  value=\\\"X\\\"><br><br>"
				+ form
				+ "</font></div>\";}"
				+ "function memo(){document.getElementById(\"uform\").innerHTML=\"<div style=\\\"margin:10px\\\">"
				+ "<font  size=\\\"4\\\" color=\\\"black\\\" face=\\\"Ariel\\\">These documents serve as tools for"
				+ " adding and editing users and allows netlogicdc \"+\"technicians to set appropriate permissions "
				+ "for the new user. For security reasons, any new or revised documents must be \"+\"authorized by an"
				+ " authority at <a id=\\\"clientname\\\">" + Name
				+ "</a> to be valid.</font></div>\";}</script></Body></Html>";
		return form;
	}
	
	public void finish() throws IOException{
		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(this);
		File file = fc.getSelectedFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(write());
		bw.close();
		File file2 = new File(file.getAbsolutePath() + ".html");
		file.renameTo(file2);
	}

	public static void main(String[] args) throws IOException,
			InterruptedException, AWTException {
		String name = JOptionPane.showInputDialog("Client Name: ");
		site2 window = new site2(name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == finish)
			done = true;
		for (int i = 0; i < 5; i++)
			if (arg0.getSource() == b[i])
				try {
					new customField(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}

	public class customField extends JFrame implements ActionListener,
			KeyListener {

		int Type;
		String ts;

		JComboBox cb = new JComboBox(locats);
		JLabel l[] = {new JLabel("Location (Goes Below or inside of field): "),new JLabel() };
		JTextPane t = new JTextPane();
		JButton add;

		public customField(int type) throws InterruptedException {
			super("Add new custom "
					+ (type == 0 ? "radio button" : (type == 1 ? "check box"
							: (type == 2 ? "input field"
									: (type == 3 ? "section" : "label")))));
			ts = (type == 0 ? "radio button" : (type == 1 ? "check box"
					: (type == 2 ? "input field" : (type == 3 ? "section"
							: "label"))));
			Type = type;
			this.setSize(500, 150);
			this.setLocationRelativeTo(null);
			if (type == 0)
				rbn();
			else if (type == 1)
				cbx();
			else if (type == 2)
				inf();
			else if (type == 3)
				sec();
			else
				lab();
			this.setVisible(true);
		}

		public void rbn() {
			this.setLayout(new GridLayout(3, 2, 3, 3));
			l[1].setText("Radio Button Label: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Radio Button");
			add.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(l[1]);
			this.add(t);
			this.add(add);
		}

		public void cbx() {
			this.setLayout(new GridLayout(3, 2, 3, 3));
			l[1].setText("Check Box Label: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Check Box");
			add.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(l[1]);
			this.add(t);
			this.add(add);
		}

		public void inf() {
			this.setLayout(new GridLayout(3, 2, 3, 3));
			l[1].setText("Input Field Label: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Input Field");
			add.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(l[1]);
			this.add(t);
			this.add(add);
		}

		public void sec() {
			cb = new JComboBox(sections);
			this.setLayout(new GridLayout(3, 2, 3, 3));
			l[1].setText("Section Label: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Section");
			add.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(l[1]);
			this.add(t);
			this.add(add);
		}

		public void lab() {
			this.setLayout(new GridLayout(3, 2, 3, 3));
			l[1].setText("Label Text: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Label");
			add.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(l[1]);
			this.add(t);
			this.add(add);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == add) {
				boolean valid = true;
				for (int i = 0; i < CFS.length; i++) {
					if (Type == 3 && CFS[i].Type == 3
							&& t.getText().equals(CFS[i].Label.getText()))
						valid = false;
				}
				if (valid) {
					if (Type == 3) {
						lat++;
						String ts[] = locats;
						locats = new String[ts.length + 1];
						for (int i = 0; i < ts.length; i++)
							locats[i] = ts[i];
						locats[ts.length] = t.getText() + " section";
					}
					field[] tf = CFS;
					CFS = new field[tf.length + 1];
					for (int i = 0; i < tf.length; i++)
						CFS[i] = tf[i];
					CFS[CFS.length - 1] = new field(cb.getSelectedIndex(),
							Type, t.getText());
					this.dispose();
				}
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				boolean valid = true;
				for (int i = 0; i < CFS.length; i++) {
					if (Type == 3 && CFS[i].Type == 3
							&& t.getText().equals(CFS[i].Label.getText()))
						valid = false;
				}
				if (valid) {
					if (Type == 3) {
						lat++;
						String ts[] = locats;
						locats = new String[ts.length + 1];
						for (int i = 0; i < ts.length; i++)
							locats[i] = ts[i];
						locats[ts.length] = t.getText() + " section";
					}
					field[] tf = CFS;
					CFS = new field[tf.length + 1];
					for (int i = 0; i < tf.length; i++)
						CFS[i] = tf[i];
					CFS[CFS.length - 1] = new field(cb.getSelectedIndex(),
							Type, t.getText());
					this.dispose();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}

	}

	public class field {

		int Location, Type, pan;
		JLabel Label, l;
		JRadioButton rb;
		JTextPane t;
		JCheckBox cb;
		JPanel p;

		public field(int location, int type, String label) {
			Location = location;
			Type = type;
			Label = (type > 1 ? new JLabel(label) : new JLabel());
			Label.setFont(f);
			if (type == 0) {
				rb = new JRadioButton(label);
				rb.setFont(f);
				rb.setBackground(new Color(123, 185, 80));
			}
			if (type == 1) {
				cb = new JCheckBox(label);
				cb.setFont(f);
				cb.setBackground(new Color(123, 185, 80));
			}
			if (type == 2) {
				t = new JTextPane();
			}
			if (type == 3) {
				p = new JPanel();
				p.setBackground(new Color(123, 185, 80));
				p.setBorder(BorderFactory.createLineBorder(Color.gray));
				p.setLayout(new GridLayout(1, 2));
				p.add(Label);
				p.add(new JLabel());
				pan = lat;
				Label.setText(Label.getText());
			}
			if (type == 4)
				l = new JLabel();
		}

	}
}
*/
