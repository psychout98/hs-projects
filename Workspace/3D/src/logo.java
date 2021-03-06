import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class logo extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	JPanel panel, top, liner, tc, adder;
	JButton newLine, addPoint;
	JTextField tpx, tpy;
	JTextPane added;
	boolean adding, pluspt;
	int[][][][] sources = new int[0][0][0][0];
	int[][][] line = { { { 0, -2 }, { 0, 0 }, { 2, 1 } }, { { -2, 1 }, { 0, 0 } }, { { -1, 2 }, { 0, 1 }, { 1, 2 } },
			{ { -2, 0 }, { -1, 0 }, { -1, -1 } }, { { 1, -1 }, { 1, 0 }, { 2, 0 } }, { { 0, 1 }, { 0, 3 } },
			{ { -1, 2 }, { -1, 3 } }, { { 1, 2 }, { 1, 3 } }, { { -1, 0 }, { -3, -1 } } };
	int[][] temp = new int[0][0];
	int xs = (int) (10 * Math.sqrt(3)), ys = 10, xl = 620 / xs, yl = 300 / ys, light = -1;

	logo() throws InterruptedException {
		this.setSize(600, 700);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		top = new JPanel(new BorderLayout());
		addPoint = new JButton("Add Point");
		addPoint.addActionListener(this);
		tpx = new JTextField();
		tpx.setBorder(BorderFactory.createLineBorder(Color.black));
		tpy = new JTextField();
		tpy.setBorder(BorderFactory.createLineBorder(Color.black));
		tpx.addKeyListener(this);
		tpy.addKeyListener(this);
		newLine = new JButton("Add Line");
		newLine.addActionListener(this);
		JLabel lx = new JLabel("            X:"), ly = new JLabel("            Y:");
		tc = new JPanel(new GridLayout(2, 1));
		tc.setVisible(false);
		adder = new JPanel(new GridLayout(1, 5));
		added = new JTextPane();
		added.setBorder(BorderFactory.createLineBorder(Color.black));
		added.setEditable(false);
		adder.add(lx);
		adder.add(tpx);
		adder.add(ly);
		adder.add(tpy);
		adder.add(addPoint);
		tc.add(adder);
		tc.add(added);
		panel = new graphic();
		panel.addMouseMotionListener(this);
		top.add(newLine, BorderLayout.WEST);
		top.add(tc, BorderLayout.CENTER);
		this.add(top, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		/*
		 * int ls = 0; for (int i = 0; i < line.length; i++) { for (int j = 0; j
		 * < line[i].length - 1; j++) { ls += (Math.abs(line[i][j][0] -
		 * line[i][j + 1][0]) > 0 ? Math.abs(line[i][j][0] - line[i][j + 1][0])
		 * : Math.abs(line[i][j][1] - line[i][j + 1][1])); } }
		 * System.out.println(ls);
		 */
		sources = new int[line.length][2][][];
		for (int i = 0; i < line.length; i++) {
			sources[i][0] = new int[line[i].length - 1][];
			sources[i][1] = new int[line[i].length - 1][];
			for (int j = 0; j < line[i].length - 1; j++) {
				int dx = line[i][j + 1][0] - line[i][j][0], dy = line[i][j + 1][1] - line[i][j][1],
						d = Math.abs(Math.abs(dx) > 0 ? dx : dy);
				sources[i][0][j] = new int[20 * d];
				sources[i][1][j] = new int[20 * d];
				sources[i][0][j][0] = xs * xl / 2 + xs * line[i][j][0];
				sources[i][1][j][0] = ys * (yl - 1) + (line[i][j][0] % 2 == 0 ? 0 : ys) - 2 * ys * line[i][j][1];
				for (int k = 1; k < 20 * d; k++) {
					sources[i][0][j][k] = sources[i][0][j][0] + xs * k * dx / (20 * d);
					sources[i][1][j][k] = sources[i][1][j][0]
							- ys * k * (dy > 0 ? 1 : (dy == 0 ? (line[i][j][0] % 2 == 0 ? -1 : 1) : -1))
									/ (10 * (Math.abs(dx) > 0 ? 2 : 1));
				}
			}
		}
		while (true) {
			Thread.sleep(42);
			repaint();
		}
	}

	public void add() {
		int[][] hold = temp;
		temp = new int[hold.length + 1][2];
		for (int i = 0; i < hold.length; i++) {
			temp[i][0] = hold[i][0];
			temp[i][1] = hold[i][1];
		}
		temp[hold.length][0] = Integer.parseInt(tpx.getText());
		temp[hold.length][1] = Integer.parseInt(tpy.getText());
		added.setText(added.getText() + (added.getText().length() > 0 ? "," : "") + "{" + temp[hold.length][0] + ", "
				+ temp[hold.length][1] + "}");
		tpx.setText("");
		tpy.setText("");
	}

	public static void main(String[] args) throws InterruptedException {
		logo window = new logo();
	}

	public class graphic extends JPanel {

		public void paint(Graphics p) {
			setSize(600, 600);
			p.setColor(Color.white);
			p.fillRect(0, 0, 600, 600);
			p.setColor(Color.gray);
			for (int i = 0; i < xl; i++) {
				p.drawLine(xs * xl / 2, 2 * ys * i - 5, xs * xl / 2, ys * (2 * i + 1) - 5);
				p.drawLine(xs * i + 5, ys * (yl - 1), xs * (2 * i + 1) / 2 + 5, ys * (yl - 1));
			}
			p.setColor(Color.black);
			int[][][] pts = new int[xl][yl][2];
			for (int j = 0; j < yl; j++) {
				for (int i = 0; i < xl - 1; i += 2) {
					pts[i][j][0] = i * xs;
					pts[i][j][1] = (2 * j + 1) * ys;
					pts[i + 1][j][0] = (i + 1) * xs;
					pts[i + 1][j][1] = 2 * j * ys;
					p.fillRect(pts[i][j][0], pts[i][j][1], 1, 1);
					p.fillRect(pts[i + 1][j][0], pts[i + 1][j][1], 1, 1);
				}
			}
			for (int l = 0; l < line.length; l++)
				for (int pt = 0; pt < line[l].length - 1; pt++)
					p.drawLine(xs * xl / 2 + xs * line[l][pt][0],
							ys * (yl - 1) + (line[l][pt][0] % 2 == 0 ? 0 : ys) - 2 * ys * line[l][pt][1],
							xs * xl / 2 + xs * line[l][pt + 1][0],
							ys * (yl - 1) + (line[l][pt + 1][0] % 2 == 0 ? 0 : ys) - 2 * ys * line[l][pt + 1][1]);
			for (int pt = 0; pt < temp.length - 1; pt++)
				p.drawLine(xs * xl / 2 + xs * temp[pt][0],
						ys * (yl - 1) + (temp[pt][0] % 2 == 0 ? 0 : ys) - 2 * ys * temp[pt][1],
						xs * xl / 2 + xs * temp[pt + 1][0],
						ys * (yl - 1) + (temp[pt + 1][0] % 2 == 0 ? 0 : ys) - 2 * ys * temp[pt + 1][1]);
			for (int i = 0; i < sources.length; i++)
				for (int j = 0; j < sources[i][0].length; j++) {
					p.setColor(light == i?Color.red:Color.blue);
					for (int k = 1; k < sources[i][0][j].length; k++)
						p.fillRect(sources[i][0][j][k] - 1, sources[i][1][j][k] - 1, 2, 2);
				}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER && adding && tpx.getText().length() > 0 && tpy.getText().length() > 0)
			add();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newLine && !adding && added.getText().length() == 0) {
			adding = true;
			tc.setVisible(true);
			temp = new int[0][0];
		}
		if (e.getSource() == newLine && adding && added.getText().length() > 0) {
			adding = false;
			tc.setVisible(false);
			tpx.setText("");
			tpy.setText("");
			System.out.println(",{" + added.getText() + "}");
			added.setText("");
			int[][][] hold = line;
			line = new int[hold.length + 1][][];
			for (int i = 0; i < hold.length; i++) {
				line[i] = new int[hold[i].length][2];
				for (int j = 0; j < hold[i].length; j++) {
					line[i][j][0] = hold[i][j][0];
					line[i][j][1] = hold[i][j][1];
				}
			}
			line[hold.length] = new int[temp.length][2];
			for (int i = 0; i < temp.length; i++) {
				line[hold.length][i][0] = temp[i][0];
				line[hold.length][i][1] = temp[i][1];
			}
		}
		if (e.getSource() == addPoint && adding && tpx.getText().length() > 0 && tpy.getText().length() > 0)
			add();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.getSource() == e.getSource()){
			int mx = e.getX(),my = e.getY();
			System.out.println(mx+ " "+my);
		for(int i=0; i<sources.length;i++){
			for(int j=0;j<sources[i][0].length;j++)
				for(int k=0;k<sources[i][0][j].length;k++){
					if(mx <= sources[i][0][j][k] + 1 && mx >= sources[i][0][j][k] - 1 && my <= sources[i][1][j][k] + 1 && my >= sources[i][1][j][k] - 1){
						light = i;
						System.out.print(" "+sources[i][0][j][k]+" "+sources[i][1][j][k]);
						break;
					}
					else
						light = -1;
				}
				}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
