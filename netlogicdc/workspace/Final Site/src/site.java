import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class site extends JFrame implements ActionListener {

	/**
	 * Stuff left to do
	 * 
	 * data validation
	 * 
	 * auto population
	 * 
	 * compare existing and new user setup
	 * 
	 * save & save as new
	 * 
	 * separate "send" button
	 */
	private static final long serialVersionUID = 1L;
	JButton b[] = { new JButton("Add Custom RadioButton"),
			new JButton("Add Custom Checkbox"),
			new JButton("Add Custom Input Field"),
			new JButton("Add Custom Section"), new JButton("Add Custom Label"),
			new JButton("Edit field") }, finish;
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
			"Other User Calendar Access Section",
			"User to Other Email Section", "Other user to Email Section",
			"Email Distribution Lists Section", "Shared Peripherals Section",
			"APPLICATION ACCESS Section" }, sections[] = {
			"Below user info section", "Inside drive access section",
			"Below drive access section", "Inside application access section",
			"Below application access section",
			"Below special instructions section" }, comsite,
			locats[] = new String[standards.length];
	field[] CFS = new field[0];
	int lat = 0;
	JPanel panel = new JPanel(), panel3 = new JPanel(new BorderLayout()),
			panel4 = new JPanel(new BorderLayout()), panel5 = new JPanel(),
			panel6 = new JPanel(), panel2 = new JPanel(), tpan = new JPanel(
					new BorderLayout()), p8 = new JPanel(), p7[], mfp[] = {
					new JPanel(new GridLayout(16, 2, 5, 5)),
					new JPanel(new GridLayout(1, 1)),
					new JPanel(new GridLayout(1, 1)),
					new JPanel(new BorderLayout()), new JPanel() }, p3[] = {
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)),
					new JPanel(new GridLayout(1, 2)) };
	Component c[] = { new JLabel("Provide general user information."),
			new JLabel(), new JLabel("First Name: "), new JTextField(),
			new JLabel("Last Name: "), new JTextField(),
			new JLabel("Employee Title: "), new JTextField(),
			new JLabel("Phone Extension: "), new JTextField(),
			new JLabel("Start Date: "), new JTextField(),
			new JLabel("Cell Number: "), new JTextField(),
			new JLabel("Office Site:"), new JTextField(),
			new JLabel("Desk Location: "), new JTextField(),
			new JLabel("Provide general access information."), new JLabel(),
			new JLabel("Email Address: "/* (will auto-populate): " */),
			new JTextField(), new JLabel("Email Alias: "), new JTextField(),
			new JLabel("Desired Username: "), new JTextField(),
			new JLabel("Desired Password: "), new JTextField(),
			new JLabel("Provide specific access information."), new JLabel(),
			new JLabel("Set permissions to drives, resources, etc."),
			new JLabel() },
			c2[] = {
					new JLabel("DRIVE / RESOURCE ACCESS"),
					new JLabel(
							"Which networked drives should the user have access to?"),
					new JLabel(
							"Which calendars should the user have access to?"),
					new JLabel(
							"Should another employee have access to the new user's calendar?"),
					new JLabel(
							"Should the user have access to another user's email?"),
					new JLabel(
							"Should another employee have access to the new user's email?"),
					new JLabel(
							"Should the user be included in any of the following email distribution lists?"),
					new JLabel(
							"Which shared peripherals should the user have access to?") };
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
			new JRadioButton("Other User Calendar Access Section"),
			new JRadioButton("User to Other Email Section"),
			new JRadioButton("Other User to Email Section"),
			new JRadioButton("Email Distribution Lists Section"),
			new JRadioButton("Shared Peripherals Section"),
			new JRadioButton("APPLICATION ACCESS Section"),
			new JRadioButton("Special Instructions Section") };
	JCheckBox chk[] = new JCheckBox[rbp1.length], checkall = new JCheckBox(
			"Select all");
	JTextField aups[] = { new JTextField(), new JTextField(), new JTextField() };

	public site(String name, String cst) throws IOException,
			InterruptedException {
		super("NetLogicDC Form Editor");
		Name = name;
		comsite = cst;
		this.setSize(1350, 850);
		this.setDefaultCloseOperation(3);
		this.setFont(f);
		init();
		while (!done) {
			for (int i = 0; i < p7.length; i++) {
				if (rbp1[i].isSelected()) {
					sel[i] = true;
					p7[i].setVisible(true);
				} else {
					sel[i] = false;
					p7[i].setVisible(false);
				}
			}
			if (rbp1[15].isSelected()) {
				sel[15] = true;
				mfp[1].setVisible(true);
			} else {
				sel[15] = false;
				mfp[1].setVisible(false);
			}
			for (int i = 16; i < 23; i++)
				if (rbp1[i].isSelected()) {
					sel[i] = true;
					p3[i - 15].setVisible(true);
				} else {
					sel[i] = false;
					p3[i - 15].setVisible(false);
				}
			if (rbp1[23].isSelected()) {
				sel[23] = true;
				mfp[2].setVisible(true);
			} else {
				sel[23] = false;
				mfp[2].setVisible(false);
			}
			if (rbp1[24].isSelected()) {
				sel[24] = true;
				mfp[3].setVisible(true);
			} else {
				sel[24] = false;
				mfp[3].setVisible(false);
			}
			for (int i = 0; i < standards.length; i++) {
				if (i != 15 || i != 23 || i != 24) {
					if (sel[i + (i > 15 && i < 23 ? 1 : 0)])
						locats[i] = standards[i];
					else
						locats[i] = "";
				}
			}
			int o = 0;
			for (int i = 0; i < CFS.length; i++) {
				if (CFS[i].Type == 3) {
					locats[o + standards.length] = CFS[i].Label.getText();
					o++;
				}
			}
			int sels = 0;
			for (int i = 0; i < rbp1.length; i++)
				if (rbp1[i].isSelected())
					sels++;
			if (sels == rbp1.length - 1)
				checkall.setSelected(false);
			if (checkall.isSelected())
				for (int i = 0; i < rbp1.length; i++)
					rbp1[i].setSelected(true);
			/*
			 * if (aups[0].getText().length() > 0 && aups[1].getText().length()
			 * > 0) aups[2].setText((aups[0].getText().charAt(0) +
			 * aups[1].getText() + "@" + comsite).toLowerCase()); else
			 * aups[2].setText(""); if (rbp1[10].isSelected()) {
			 * rbp1[1].setSelected(true); rbp1[2].setSelected(true); }
			 */
			validate();
			Thread.sleep(100);
		}
		write();
		System.exit(0);
	}

	public void init() throws IOException {
		panel3.setBackground(new Color(140, 202, 97));
		panel3.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel4.setSize(600, 800);
		JLabel[] l = { new JLabel("Editor"), new JLabel(), new JLabel(),
				new JLabel(" " + Name), new JLabel(), new JLabel() };
		panel.setLayout(new GridLayout(rbp1.length + b.length + 4, 1));
		JPanel panl[] = new JPanel[rbp1.length + b.length + 4];
		panl[0] = new JPanel(new GridLayout(1, 1));
		panl[0].add(l[0]);
		panl[1] = new JPanel(new GridLayout(1, 1));
		panl[1].add(l[2]);
		for (int i = 0; i < b.length; i++) {
			panl[i + 2] = new JPanel(new GridLayout(1, 1));
			panl[i + 2].add(b[i]);
			b[i].addActionListener(this);
		}
		panl[b.length + 2] = new JPanel(new BorderLayout());
		panl[b.length + 2].add(checkall, BorderLayout.WEST);
		panl[b.length + 2].add(new JLabel(), BorderLayout.CENTER);
		panl[b.length + 3] = new JPanel(new BorderLayout());
		panl[b.length + 3].add(new JLabel("Check If Required Field"),
				BorderLayout.WEST);
		panl[b.length + 3].add(new JLabel(), BorderLayout.CENTER);
		JPanel ppan[] = new JPanel[7];
		for (int i = 0; i < rbp1.length; i++) {
			if (i > 15 && i < 23) {
				panl[i + b.length + 4] = new JPanel(new BorderLayout());
				chk[i] = new JCheckBox();
				ppan[i - 16] = new JPanel(new GridLayout(1, 2));
				ppan[i - 16].add(new JLabel());
				ppan[i - 16].add(chk[i]);
				panl[i + b.length + 4].add(ppan[i - 16], BorderLayout.WEST);
				panl[i + b.length + 4].add(rbp1[i], BorderLayout.CENTER);
			} else {
				panl[i + b.length + 4] = new JPanel(new BorderLayout());
				chk[i] = new JCheckBox();
				panl[i + b.length + 4].add(chk[i], BorderLayout.WEST);
				panl[i + b.length + 4].add(rbp1[i], BorderLayout.CENTER);
			}
		}
		for (int i = 0; i < chk.length; i++)
			if (i == 0 || i == 9 || i == 14 || i == 15 || i == 24)
				chk[i].setVisible(false);
		for (int i = 0; i < panl.length; i++)
			panel.add(panl[i]);
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
		p.setPreferredSize(new Dimension(300, this.getHeight() - 45));
		p.getVerticalScrollBar().setUnitIncrement(16);
		panel5.add(p);
		panel4.add(panel3, BorderLayout.NORTH);
		panel2.setBackground(new Color(123, 185, 80));
		panel2.setBorder(new EmptyBorder(20, 20, 20, 20));
		JScrollPane p2 = new JScrollPane(tpan);
		p2.setPreferredSize(new Dimension(600, this.getHeight()));
		p2.getVerticalScrollBar().setUnitIncrement(16);
		panel4.add(p2, BorderLayout.CENTER);
		this.add(panel5, BorderLayout.WEST);
		this.add(panel4, BorderLayout.CENTER);
		this.setVisible(true);
		f = new Font("Ariel", Font.PLAIN, 14);
		Panel2();
	}

	public void Panel2() {
		locats = new String[standards.length + lat];
		panel2.removeAll();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		mfp[0].removeAll();
		mfp[1].removeAll();
		mfp[2].removeAll();
		mfp[3].removeAll();
		mfp[4].removeAll();
		mfp[0].setBackground(new Color(123, 185, 80));
		mfp[0].setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		mfp[0].setLayout(new BoxLayout(mfp[0], BoxLayout.Y_AXIS));
		p7 = new JPanel[c.length / 2];
		for (int i = 0; i < p7.length; i++) {
			p7[i] = new JPanel();
			p7[i].setLayout(new GridLayout(1, 2));
			p7[i].setBackground(new Color(123, 185, 80));
			c[i * 2].setFont(f);
			c[(i * 2) + 1].setFont(f);
			p7[i].add(c[i * 2]);
			p7[i].add(c[(i * 2) + 1]);
			mfp[0].add(p7[i]);
			acf(i, mfp[0]);
		}
		mfp[1].setBackground(new Color(123, 185, 80));
		mfp[1].setBorder(BorderFactory.createLineBorder(Color.gray));
		mfp[1].setLayout(new BorderLayout());
		p8.setLayout(new BoxLayout(p8, BoxLayout.Y_AXIS));
		p8.setBackground(new Color(123, 185, 80));
		for (int i = 0; i < p3.length; i++) {
			c2[i].setFont(f);
			p3[i].removeAll();
			p3[i].setLayout(new GridLayout(1, 2, 0, 3));
			p3[i].setBorder(BorderFactory.createLineBorder(Color.gray));
			p3[i].setBackground(new Color(123, 185, 80));
			p3[i].add(c2[i]);
			p3[i].add(new JLabel());
			if (i > 0)
				acf(14 + i, p3[i]);
			if (i == 0)
				mfp[1].add(p3[i], BorderLayout.NORTH);
			else
				p8.add(p3[i]);
		}
		prw(1, p8);
		mfp[1].add(p8);
		mfp[2].setBackground(new Color(123, 185, 80));
		mfp[2].setBorder(BorderFactory.createLineBorder(Color.gray));
		mfp[2].setLayout(new GridLayout(1, 1));
		mfp[4].setLayout(new BorderLayout());
		mfp[4].setBackground(new Color(123, 185, 80));
		JLabel appl = new JLabel("APPLICATION ACCESS");
		JPanel apnl = new JPanel(new GridLayout(1, 2)), mapl = new JPanel(
				new GridLayout(0, 2));
		appl.setFont(f);
		apnl.setBorder(BorderFactory.createLineBorder(Color.gray));
		apnl.setBackground(new Color(123, 185, 80));
		mapl.setBackground(new Color(123, 185, 80));
		apnl.add(appl);
		apnl.add(new JLabel());
		mfp[4].add(apnl, BorderLayout.NORTH);
		acf(22, mapl);
		mfp[4].add(mapl, BorderLayout.CENTER);
		mfp[2].add(mfp[4]);
		prw(3, mfp[2]);
		mfp[3].setBackground(new Color(123, 185, 80));
		mfp[3].setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel si = new JLabel("Special Instuctions");
		si.setFont(f);
		mfp[3].add(si, BorderLayout.NORTH);
		JTextArea sp = new JTextArea();
		sp.setRows(10);
		mfp[3].add(sp, BorderLayout.CENTER);
		tpan.add(mfp[0], BorderLayout.NORTH);
		prw(0, panel2);
		panel2.add(mfp[1]);
		panel2.add(Box.createRigidArea(new Dimension(300, 20)));
		prw(2, panel2);
		panel2.add(mfp[2]);
		panel2.add(Box.createRigidArea(new Dimension(300, 20)));
		prw(4, panel2);
		panel2.add(mfp[3]);
		panel2.add(Box.createRigidArea(new Dimension(300, 20)));
		prw(5, panel2);
		tpan.add(panel2, BorderLayout.CENTER);
		validate();
	}

	public void prw(int loc, JPanel p) {
		for (int i = 0; i < CFS.length; i++) {
			if (CFS[i].Location == loc && CFS[i].Type == 3) {
				CFS[i].p.removeAll();
				CFS[i].p.setLayout(new GridLayout(1, 2));
				if (!(p.equals(panel2) || p.equals(p8)))
					p.setLayout(new GridLayout(
							Integer.parseInt(p
									.getLayout()
									.toString()
									.substring(
											p.getLayout().toString()
													.indexOf("rows=") + 5,
											p.getLayout().toString()
													.indexOf("cols=") - 1)) + 1,
							Integer.parseInt(p
									.getLayout()
									.toString()
									.substring(
											p.getLayout().toString()
													.indexOf("cols=") + 5,
											p.getLayout().toString()
													.indexOf("]"))),
							Integer.parseInt(p
									.getLayout()
									.toString()
									.substring(
											p.getLayout().toString()
													.indexOf("hgap=") + 5,
											p.getLayout().toString()
													.indexOf("vgap=") - 1)),
							Integer.parseInt(p
									.getLayout()
									.toString()
									.substring(
											p.getLayout().toString()
													.indexOf("vgap=") + 5,
											p.getLayout().toString()
													.indexOf("rows=") - 1))));
				acf(CFS[i].pan + standards.length, CFS[i].p);
				validate();
				p.add(CFS[i].p2);
				if (p.equals(panel2) || p.equals(p8))
					panel2.add(Box.createRigidArea(new Dimension(300, 20)));
			}
		}
	}

	public void acf(int loc, JPanel p) {
		for (int i = 0; i < CFS.length; i++) {
			if (CFS[i].Location == loc) {
				if (CFS[i].Type == 0) {
					if (!p.equals(mfp[0])) {
						p.setLayout(new GridLayout(
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("rows=") + 5,
												p.getLayout().toString()
														.indexOf("cols=") - 1))
										+ CFS[i].rb.length,
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("cols=") + 5,
												p.getLayout().toString()
														.indexOf("]"))),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("hgap=") + 5,
												p.getLayout().toString()
														.indexOf("vgap=") - 1)),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("vgap=") + 5,
												p.getLayout().toString()
														.indexOf("rows=") - 1))));
						for (int j = 0; j < CFS[i].rb.length; j++) {
							p.add(CFS[i].rb[j]);
							p.add(new JLabel());
						}
					} else {
						JPanel tppp = new JPanel(new BorderLayout()), tpp2 = new JPanel(
								new GridLayout(CFS[i].rb.length, 1));
						for (int j = 0; j < CFS[i].rb.length; j++)
							tpp2.add(CFS[i].rb[j]);
						tppp.add(tpp2);
						p.add(tppp);
					}
				}
				if (CFS[i].Type == 1) {
					if (!p.equals(mfp[0])) {
						p.setLayout(new GridLayout(
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("rows=") + 5,
												p.getLayout().toString()
														.indexOf("cols=") - 1)) + 1,
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("cols=") + 5,
												p.getLayout().toString()
														.indexOf("]"))),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("hgap=") + 5,
												p.getLayout().toString()
														.indexOf("vgap=") - 1)),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("vgap=") + 5,
												p.getLayout().toString()
														.indexOf("rows=") - 1))));
						p.add(CFS[i].cb);
						p.add(new JLabel());
					} else {
						JPanel tppp = new JPanel(new BorderLayout());
						tppp.add(CFS[i].cb);
						p.add(tppp);
					}
				}
				if (CFS[i].Type == 2) {
					if (!p.equals(mfp[0])) {
						p.setLayout(new GridLayout(
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("rows=") + 5,
												p.getLayout().toString()
														.indexOf("cols=") - 1)) + 1,
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("cols=") + 5,
												p.getLayout().toString()
														.indexOf("]"))),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("hgap=") + 5,
												p.getLayout().toString()
														.indexOf("vgap=") - 1)),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("vgap=") + 5,
												p.getLayout().toString()
														.indexOf("rows=") - 1))));
						p.add(CFS[i].Label);
						p.add(CFS[i].t);
					} else {
						JPanel tppp = new JPanel(new GridLayout(1, 2));
						tppp.setBackground(new Color(123, 185, 80));
						tppp.add(CFS[i].Label);
						tppp.add(CFS[i].t);
						p.add(tppp);
					}
				}
				if (CFS[i].Type == 4) {
					if (!p.equals(mfp[0])) {
						p.setLayout(new GridLayout(
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("rows=") + 5,
												p.getLayout().toString()
														.indexOf("cols=") - 1)) + 1,
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("cols=") + 5,
												p.getLayout().toString()
														.indexOf("]"))),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("hgap=") + 5,
												p.getLayout().toString()
														.indexOf("vgap=") - 1)),
								Integer.parseInt(p
										.getLayout()
										.toString()
										.substring(
												p.getLayout().toString()
														.indexOf("vgap=") + 5,
												p.getLayout().toString()
														.indexOf("rows=") - 1))));
						p.add(CFS[i].Label);
						p.add(CFS[i].l);
					} else {
						JPanel tppp = new JPanel(new BorderLayout());
						tppp.setBackground(new Color(123, 185, 80));
						tppp.add(CFS[i].Label);
						p.add(tppp);
					}
				}
			}
		}
	}

	public String acc(int loc) {
		String fc = "";
		for (int i = 0; i < CFS.length; i++) {
			if (CFS[i].Location == loc) {
				if (CFS[i].Type == 0) {
					for (int j = 0; j < CFS[i].rb.length; j++)
						fc += "<input type=\\\"radio\\\"name=\\\""
								+ CFS[i].rb[0].getText()
								+ "\\\"\\\"value=\\\"\"+userinfo["
								+ (standards.length + i) + "]+\"\\\">"
								+ CFS[i].rb[j].getText() + "<br><br>";
				}
				if (CFS[i].Type == 1) {
					fc += "<input type=\\\"checkbox\\\" value=\\\"\"+userinfo[0]+\"\\\">"
							+ CFS[i].Label.getText() + "<br><br>";
				}
				if (CFS[i].Type == 2) {
					fc += CFS[i].Label.getText()
							+ " <input type=\\\""
							+ (CFS[i].ttp == 0 ? "text"
									: (CFS[i].ttp == 1 ? "email"
											: (CFS[i].ttp == 2 ? "tel" : "date")))
							+ "\\\" value=\\\"\"+userinfo[0]+\"\\\"><br><br>";
				}
				if (CFS[i].Type == 4) {
					fc += CFS[i].Label.getText() + "<br><br>";
				}
			}
		}
		return fc;
	}

	public String pcc(int loc) {
		String fc = "";
		for (int i = 0; i < CFS.length; i++) {
			if (CFS[i].Location == loc && CFS[i].Type == 3) {
				fc += "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
						+ CFS[i].Label.getText()
						+ "<br><br>"
						+ acc(CFS[i].pan + 23) + "<br></div>";
			}
		}
		return fc;
	}

	public void write() throws IOException {
		int[] cs = new int[CFS.length];
		for (int i = 0; i < cs.length; i++) {
			cs[i] = CFS[i].Location;
		}
		String form = "";

		form += acc(0);

		form += (sel[1] ? (chk[1].isSelected() ? "*" : "")
				+ "First Name: <input type=\\\"text\\\" value=\\\"\"+userinfo[0]+\"\\\"><br><br>"
				: "");
		form += acc(1);
		form += (sel[2] ? (chk[2].isSelected() ? "*" : "")
				+ "Last Name: <input type=\\\"text\\\" value=\\\"\"+userinfo[1]+\"\\\"><br><br>"
				: "");
		form += acc(2);
		form += (sel[3] ? (chk[3].isSelected() ? "*" : "")
				+ "Employee Title: <input type=\\\"text\\\" value=\\\"\"+userinfo[2]+\"\\\"><br><br>"
				: "");
		form += acc(3);
		form += (sel[4] ? (chk[4].isSelected() ? "*" : "")
				+ "Phone Extension: <input type=\\\"number\\\" value=\\\"\"+userinfo[3]+\"\\\"><br><br>"
				: "");
		form += acc(4);
		form += (sel[5] ? (chk[5].isSelected() ? "*" : "")
				+ "Start Date: <input type=\\\"date\\\" value=\\\"\"+userinfo[4]+\"\\\"><br><br>"
				: "");
		form += acc(5);
		form += (sel[6] ? (chk[6].isSelected() ? "*" : "")
				+ "Cell Number: <input type=\\\"number\\\" value=\\\"\"+userinfo[5]+\"\\\"><br><br>"
				: "");
		form += acc(6);
		form += (sel[7] ? (chk[7].isSelected() ? "*" : "")
				+ "Office Site: <input type=\\\"text\\\" value=\\\"\"+userinfo[6]+\"\\\"><br><br>"
				: "");
		form += acc(7);
		form += (sel[8] ? (chk[8].isSelected() ? "*" : "")
				+ "Desk Location: <input type=\\\"text\\\" value=\\\"\"+userinfo[7]+\"\\\"><br><br>"
				: "");
		form += acc(8);
		form += (sel[9] ? "Provide general Access Information.<br><br>" : "");
		form += acc(9);
		form += (sel[10] ? (chk[10].isSelected() ? "*" : "")
				+ "Email Address: "
				+ /* (will auto populate): */" <input type=\\\"email\\\" value=\\\"\"+userinfo[3]+\"\\\"><br><br>"
				: "");
		form += acc(10);
		form += (sel[11] ? (chk[11].isSelected() ? "*" : "")
				+ "Email Alias: <input type=\\\"text\\\" value=\\\"\"+userinfo[8]+\"\\\"><br><br>"
				: "");
		form += acc(11);
		form += (sel[12] ? (chk[12].isSelected() ? "*" : "")
				+ "Desired Username: <input type=\\\"text\\\" value=\\\"\"+userinfo[9]+\"\\\"><br><br>"
				: "");
		form += acc(12);
		form += (sel[13] ? (chk[13].isSelected() ? "*" : "")
				+ "Desired Password: <input type=\\\"text\\\" value=\\\"\"+userinfo[10]+\"\\\"><br><br>"
				: "");
		form += acc(13);
		form += pcc(0);
		form += (sel[14] ? "Provide specific access information. Set permissions to drives, resources, etc.<br><br>"
				: "");
		form += acc(14);
		form += (sel[15] ? "<div style=\\\"width:760px;border:1px solid gray;background:#6AA840;\\\">DRIVE / RESOURCE ACCESS<br>"
				: "");
		form += (sel[16] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[16].isSelected() ? "*" : "")
				+ "Which networked drives should the user have access to?<br><br>"
				+ acc(16) + "</div>"
				: "");
		form += (sel[17] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[17].isSelected() ? "*" : "")
				+ "Which calendars should the user have access to?<br><br>"
				+ acc(17) + "</div>"
				: "");
		form += (sel[18] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[18].isSelected() ? "*" : "")
				+ "Should another employee have access to the new user's calendar?<br><br>"
				+ acc(18) + "</div>"
				: "");
		form += (sel[19] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[19].isSelected() ? "*" : "")
				+ "Should the user have access to another user's email?<br><br>"
				+ acc(19) + "</div>"
				: "");
		form += (sel[20] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[20].isSelected() ? "*" : "")
				+ "Should another employee have access to the new user's email?<br><br>"
				+ acc(20) + "</div>"
				: "");
		form += (sel[21] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[21].isSelected() ? "*" : "")
				+ "Should the user be included in any of the following email distribution lists?<br><br>"
				+ acc(21) + "</div>"
				: "");
		form += (sel[22] ? "<div style=\\\"border:1px solid gray;width=760px;\\\"><br>"
				+ (chk[22].isSelected() ? "*" : "")
				+ "Which shared peripherals should the user have access to?<br><br>"
				+ acc(22) + "</div>"
				: "");
		form += pcc(2);
		form += acc(15);
		form += (sel[15] ? "</div><br><br>" + pcc(3) : "");
		form += (sel[23] ? "<div style=\\\"width:760px;border:1px solid gray;background:#6AA840;\\\">"
				+ (chk[23].isSelected() ? "*" : "")
				+ "APPLICATION ACCESS<br>"
				+ pcc(3) + acc(23) + "</div><br><br>"
				: "");
		form += pcc(4);
		form += (sel[24] ? "<div style=\\\"width:760px;border:1px solid gray;background:#6AA840;\\\">Special instructions<textarea name=\\\"specinstructs\\\" "
				+ "style=\\\"margin:2;resize:none\\\" cols=\\\"105\\\" rows=\\\"10\\\">\"+userinfo[79]+\"</textarea>"
				: "");
		form += pcc(5);
		String f = "<Html><Head><Title>"
				+ Name
				+ " - Netlogicdc</Title>"
				+ "<link rel=\"shortcut icon\" type=\"image/x-icon\" "
				+ "href=\"C:/Users/nheath/My Documents/Website/logo.png\" />"
				+ "</Head><Body bgcolor=\"#8CCA61\" style=\"margin:50px\">"
				+ "<a href=\"http://www.netlogicdc.com\">"
				+ "<img src=\"C:/Users/nheath/My Documents/Website/logo-white.png\" style=\"width:240px;height:58px;\">"
				+ "<br><br></a><div style=\"float:right;margin:10px 50px 0px 0px;width:30%\"><div style=\"float:right;\">"
				+ "<font size=\"4\" color=\"white\" face=\"Ariel\">Search users:"
				+ "</font><input onkeypress=\"gathertext(form)\" type=\"search\" name=\"searcher\"></div><br><br>"
				+ "<font size=\"5\" color=\"white\" face=\"Ariel\">User List</font><br><br><div style=\"overflow:scroll;width:100%;"
				+ "height:520px;border:1px solid gray;background:#7BB950;\"><a><a style=\"float:left;margin:10px\"><font size=\"4\""
				+ " color=\"black\" face=\"Ariel\">Fake User</font></a><a style=\"float:right;margin:10px\"><input type=\"button\""
				+ " onclick = \"showUser('fakeuser')\" name=\"fake-user\" value=\"View User Data\"></a></a></div></div><div style=\""
				+ "float:left;width:59%;height:540px\"><font id=\"i1\" size=\"6\" color=\"white\" face=\"Ariel\">"
				+ Name
				+ "</font><br><br><a style=\"float:right;\"><input type=\"button\" value=\"New User\" onclick=\"showUser('new')\">"
				+ "<input type=\"button\" onclick=\"makefile()\" value=\"Save Form\"><input type=\"button\" onclick=\"makefile()\""
				+ " value=\"Save As New Form\"><input type=\"button\" onclick=\"makefile()\" value=\"Send\"></a><br><br>"
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
		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(this);
		File file = fc.getSelectedFile();
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(f);
		bw.close();
		File file2 = new File(file.getAbsolutePath() + ".html");
		file.renameTo(file2);
	}

	public static void main(String[] args) throws IOException,
			InterruptedException, AWTException {
		// 2329089562800
		String name = JOptionPane.showInputDialog("Client Name: ");
		// String cst = JOptionPane
		// .showInputDialog("Client Website (example.com): ");
		// cst += (cst.contains(".com") ? "" : ".com");
		@SuppressWarnings("unused")
		site window = new site(name, "");
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
		if (arg0.getSource() == b[5] && CFS.length > 0)
			new editFields();
	}

	public class editFields extends JFrame implements ActionListener {

		/* 
		 */
		private static final long serialVersionUID = 1L;
		@SuppressWarnings("rawtypes")
		JComboBox cb, cb2, cb3, cb4;
		JButton bts[] = { new JButton("Delete"), new JButton("Save"),
				new JButton("Next") };
		JTextField tp = new JTextField();
		String[] mix, rbs;
		JLabel l[] = { new JLabel("Choose field: "), new JLabel("Set Label: "),
				new JLabel("Set Location"), new JLabel("Radiobutton:") };
		int step = 0, index;
		JPanel panel8 = new JPanel(new GridLayout(2, 2));

		public editFields() {
			super("Edit a field");
			this.setSize(400, 150);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			for (int i = 0; i < bts.length; i++)
				bts[i].addActionListener(this);
			mix = new String[CFS.length];
			for (int i = 0; i < CFS.length; i++)
				mix[i] = CFS[i].Label.getText()
						+ (CFS[i].Type == 0 ? " radio button"
								: (CFS[i].Type == 1 ? " check box"
										: (CFS[i].Type == 2 ? " input field"
												: (CFS[i].Type == 3 ? " section"
														: " label"))));
			tp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			cb = new JComboBox<Object>(mix);
			cb.setSelectedIndex(0);
			panel8.add(l[0]);
			panel8.add(cb);
			panel8.add(bts[0]);
			panel8.add(bts[2]);
			this.add(panel8);
		}

		public void step2() {
			rbs = new String[CFS[cb.getSelectedIndex()].rb.length];
			for (int i = 0; i < CFS[cb.getSelectedIndex()].rb.length; i++)
				rbs[i] = CFS[cb.getSelectedIndex()].rb[i].getText();
			cb4 = new JComboBox<Object>(rbs);
			panel8.add(l[3]);
			panel8.add(cb4);
			panel.add(bts[0]);
			panel.add(bts[2]);
			panel8.add(bts[0]);
			panel8.add(bts[2]);
			validate();
		}

		public void step3() {
			if (CFS[cb.getSelectedIndex()].Type == 3)
				cb3 = new JComboBox<Object>(sections);
			else
				cb3 = new JComboBox<Object>(locats);
			cb3.setSelectedIndex(CFS[cb.getSelectedIndex()].Location);
			panel8.add(l[2]);
			panel8.add(cb3);
			panel8.add(bts[0]);
			panel8.add(bts[2]);
			validate();
		}

		public void step4() {
			panel8.add(l[1]);
			panel8.add(tp);
			panel8.add(bts[0]);
			panel8.add(bts[1]);

			validate();
		}

		public void nextStep() {
			step++;
			panel8.removeAll();
			panel8.setLayout(new GridLayout(2, 2));
			this.setVisible(true);
			validate();
			if (step == 3) {
				step4();
			}
			if (step == 2) {
				step3();
				tp.setText(CFS[cb.getSelectedIndex()].rb[cb4.getSelectedIndex()]
						.getText());
			}
			if (step == 1 && CFS[cb.getSelectedIndex()].Type == 0) {
				step2();
			}
			if (step == 1 && CFS[cb.getSelectedIndex()].Type > 0) {
				step++;
				step3();
				tp.setText(CFS[cb.getSelectedIndex()].Label.getText());
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bts[0]) {
				field ta[] = CFS;
				CFS = new field[ta.length - 1];
				for (int i = 0; i < CFS.length; i++)
					CFS[i] = (i >= cb.getSelectedIndex() ? ta[i + 1] : ta[i]);
				Panel2();
				this.dispose();
			}
			if (e.getSource() == bts[2]) {
				nextStep();
			}
			if (e.getSource() == bts[1]) {
				if (CFS[cb.getSelectedIndex()].Type == 0) {
					CFS[cb.getSelectedIndex()].rb[cb4.getSelectedIndex()]
							.setText(tp.getText());
					CFS[cb.getSelectedIndex()].Location = cb3
							.getSelectedIndex();
				}
				if (CFS[cb.getSelectedIndex()].Type == 1) {
					CFS[cb.getSelectedIndex()].cb.setText(tp.getText());
					CFS[cb.getSelectedIndex()].Location = cb3
							.getSelectedIndex();
				}
				if (CFS[cb.getSelectedIndex()].Type >= 2) {
					CFS[cb.getSelectedIndex()].Label.setText(tp.getText());
					CFS[cb.getSelectedIndex()].Location = cb3
							.getSelectedIndex();
				}
				Panel2();
				this.dispose();
			}

		}

	}

	public class customField extends JFrame implements ActionListener,
			KeyListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int Type;
		String ts;
		JComboBox<?> cb = new JComboBox<Object>(locats);
		JComboBox<?> cr, ct;
		JLabel l[] = {
				new JLabel("Location (Goes Below or inside of field): "),
				new JLabel(), new JLabel("Type: ") };
		JTextField t = new JTextField();
		JButton add, ap;
		JCheckBox req = new JCheckBox("Check If Required");
		JPanel ppatt = new JPanel(new GridLayout(1, 2));
		aps aut;

		public customField(int type) throws InterruptedException {
			super("Add new custom "
					+ (type == 0 ? "radio button" : (type == 1 ? "check box"
							: (type == 2 ? "input field"
									: (type == 3 ? "section" : "label")))));
			ts = (type == 0 ? "radio button" : (type == 1 ? "check box"
					: (type == 2 ? "input field" : (type == 3 ? "section"
							: "label"))));
			Type = type;
			this.setSize(500, 180);
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

			String s[] = new String[CFS.length + 1];
			s[0] = "None";
			for (int i = 0; i < CFS.length; i++)
				if (CFS[i].Type == 0)
					s[i + 1] = CFS[i].Label.getText();
				else
					s[i + 1] = "";
			cr = new JComboBox<Object>(s);
			this.setSize(500, 180);
			this.setLayout(new GridLayout(4, 2, 3, 3));
			l[1].setText("Radio Button Label: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Radio Button");
			add.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(l[1]);
			this.add(t);
			this.add(new JLabel("Connect to another radiobutton: "));
			this.add(cr);
			this.add(req);
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
			this.add(req);
			this.add(add);
		}

		public void inf() {
			String tps[] = { "Text", "Email", "Phone", "Date" };
			ct = new JComboBox<Object>(tps);
			ppatt.add(l[2]);
			ppatt.add(ct);
			this.setLayout(new GridLayout(4, 2, 3, 3));
			l[1].setText("Input Field Label: ");
			t.setBorder(BorderFactory.createLineBorder(Color.black));
			t.addKeyListener(this);
			add = new JButton("Add Input Field");
			add.addActionListener(this);
			ap = new JButton("Create Auto Population");
			ap.addActionListener(this);
			this.add(l[0]);
			this.add(cb);
			this.add(ap);
			this.add(ppatt);
			this.add(l[1]);
			this.add(t);
			this.add(req);
			this.add(add);
		}

		public void sec() {
			cb = new JComboBox<Object>(sections);
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
			this.add(req);
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
			this.add(new JLabel());
			this.add(add);
		}

		public void addCF() {
			int loca;
			/*
			 * if (cb.getSelectedIndex() > standards.length - 1) { if
			 * (CFS[cb.getSelectedIndex() - standards.length].Type == 3) loca =
			 * cb.getSelectedIndex(); else loca = CFS[cb.getSelectedIndex() -
			 * standards.length].Location; } else
			 */
			loca = cb.getSelectedIndex();
			boolean valid = true;
			for (int i = 0; i < CFS.length; i++) {
				if (Type == 3 && CFS[i].Type == 3
						&& t.getText().equals(CFS[i].Label.getText()))
					valid = false;
			}
			if (valid) {
				if (Type == 0) {
					if (cr.getSelectedIndex() > 0) {
						CFS[cr.getSelectedIndex() - 1].addRB(t.getText());
						this.dispose();
						Panel2();
					} else {
						field[] tf = CFS;
						CFS = new field[tf.length + 1];
						for (int i = 0; i < tf.length; i++)
							CFS[i] = tf[i];
						CFS[CFS.length - 1] = new field(loca, Type, t.getText());
						this.dispose();
						Panel2();
					}
				} else {
					if (Type == 3)
						lat++;
					field[] tf = CFS;
					CFS = new field[tf.length + 1];
					for (int i = 0; i < tf.length; i++)
						CFS[i] = tf[i];
					CFS[CFS.length - 1] = new field(loca, Type, t.getText());
					if (Type == 2)
						CFS[CFS.length - 1].aut = aut;

					if (Type == 2)
						CFS[CFS.length - 1].ttp = ct.getSelectedIndex();
					this.dispose();
					Panel2();
				}
				CFS[CFS.length - 1].required = req.isSelected();
			}
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == add) {
				addCF();
			}
			if (arg0.getSource() == ap) {
				aut = new aps();
				l[2].setText(aut.toString());
			}
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				addCF();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}

	}

	public class aps extends JFrame implements ActionListener, KeyListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public aps() {
			super("Create Auto Population Method");
			this.setSize(500, 200);
			this.setLocationRelativeTo(null);
			this.setVisible(true);

		}

		@Override
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

	}

	public class field {

		int Location, Type, pan, ttp;
		JLabel Label, l;
		JRadioButton rb[];
		JTextField t;
		JCheckBox cb;
		JPanel p, p2, p3;
		ButtonGroup bgr;
		boolean required;
		aps aut;

		public field(int location, int type, String label) {
			Location = location;
			Type = type;
			Label = new JLabel(label);
			Label.setFont(f);
			if (type == 0) {
				bgr = new ButtonGroup();
				rb = new JRadioButton[1];
				rb[0] = new JRadioButton(label);
				rb[0].setFont(f);
				rb[0].setBackground(new Color(123, 185, 80));
				bgr.add(rb[0]);
			}
			if (type == 1) {
				cb = new JCheckBox(label);
				cb.setFont(f);
				cb.setBackground(new Color(123, 185, 80));
			}
			if (type == 2) {
				t = new JTextField();
			}
			if (type == 3) {
				p2 = new JPanel(new BorderLayout());
				p2.setBackground(new Color(123, 185, 80));
				p2.setBorder(BorderFactory.createLineBorder(Color.gray));
				p3 = new JPanel(new GridLayout(1, 2));
				p3.setBackground(new Color(123, 185, 80));
				p3.add(Label);
				p3.add(new JLabel());
				pan = lat - 1;
				p = new JPanel(new GridLayout(0, 2));
				p.setBackground(new Color(123, 185, 80));
				p2.add(p3, BorderLayout.NORTH);
				p2.add(p, BorderLayout.CENTER);
			}
			if (type == 4)
				l = new JLabel();
		}

		public void addRB(String label) {
			bgr = new ButtonGroup();
			JRadioButton trb[] = rb;
			rb = new JRadioButton[trb.length + 1];
			for (int i = 0; i < trb.length; i++) {
				rb[i] = trb[i];
				bgr.add(rb[i]);
			}
			rb[rb.length - 1] = new JRadioButton(label);
			rb[rb.length - 1] = new JRadioButton(label);
			rb[rb.length - 1].setFont(f);
			rb[rb.length - 1].setBackground(new Color(123, 185, 80));
			bgr.add(rb[rb.length - 1]);
		}

	}
}