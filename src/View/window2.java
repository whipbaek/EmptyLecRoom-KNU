package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class window2 extends JFrame implements ActionListener{

	private JPanel selectpanel;
	private JPanel roompanel;
	private JPanel secondpanel;
	private JPanel thirdpanel;

	public static final int WIDTH = 580;
	public static final int HEIGHT = 490;


	ImageIcon t1 = new ImageIcon("./img/t1.png"); //
	ImageIcon f1 = new ImageIcon("./img/f1.png");
	ImageIcon t2 = new ImageIcon("./img/t2.png"); //
	ImageIcon f2 = new ImageIcon("./img/f2.png");
	ImageIcon ele = new ImageIcon("./img/elevator.png");
	ImageIcon toi = new ImageIcon("./img/toi.png");

	timetable tt;


	public static void main(String[] args) {
		window2 gui= new window2("3F");
	}

	public window2(String str){

		super(str);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		secondpanel = new JPanel();
		secondpanel.setLayout(null);
		secondpanel.setBackground(Color.WHITE);
		thirdpanel = new JPanel();
		thirdpanel.setBackground(Color.WHITE);
		thirdpanel.setLayout(null);

		JMenu B1 = new JMenu("B1");
		B1.addActionListener(this);
		JMenu second = new JMenu("2F");
		second.addActionListener(this);
		JMenu third = new JMenu("3F");
		third.addActionListener(this);



		/*JMenuItem B1Choice = new JMenuItem("B1");
		B1Choice.addActionListener(this);
		Menu.add(B1Choice);

		JMenuItem SecondChoice = new JMenuItem("2F");
		SecondChoice.addActionListener(this);
		Menu.add(SecondChoice);

		JMenuItem ThirdChoice = new JMenuItem("3F");
		ThirdChoice.addActionListener(this);
		Menu.add(ThirdChoice);
		*/

		JMenuBar bar = new JMenuBar();
		bar.add(B1);
		bar.add(second);
		bar.add(third);

		setJMenuBar(bar);

		if(str.equals("3F"))
			arrange_3();
		else if(str.equals("2F"))
			arrange_2();

		setVisible(true);

	}


	public void arrange_2(){

		JButton btn201 = new JButton("201");
		btn201.setBounds(30, 30, 60, 80);
		btn201.setFont(new Font("����ü",Font.BOLD,15));
		btn201.setToolTipText("�����ð�: ");
		secondpanel.add(btn201);

		JButton btn202 = new JButton("202");
		btn202.setBounds(30, 120, 60, 80);
		secondpanel.add(btn202);

		JButton btn203 = new JButton("����");
		btn203.setBounds(30, 210, 60, 50);
		secondpanel.add(btn203);

		JButton btn204 = new JButton("204");
		btn204.setBounds(30, 275, 60, 50);
		secondpanel.add(btn204);

		JButton btn205 = new JButton("205");
		btn205.setBounds(100, 30, 80, 50);
		secondpanel.add(btn205);

		JButton btn206 = new JButton("206");
		btn206.setBounds(190, 30, 80, 50);
		secondpanel.add(btn206);

		JButton btn207 = new JButton("207");
		btn207.setBounds(280, 30, 80, 50);
		secondpanel.add(btn207);

		JButton btn208 = new JButton("208");
		btn208.setBounds(370, 30, 60, 100);
		secondpanel.add(btn208);

		JButton btn209 = new JButton("209");
		btn209.setBounds(370, 140, 60, 90);
		secondpanel.add(btn209);

		JButton btn210 = new JButton("210");
		btn210.setBounds(370, 240, 60, 60);
		secondpanel.add(btn210);

		add(secondpanel);
		thirdpanel.setVisible(false);
		secondpanel.setVisible(true);
	}


	public void arrange_3(){

		JLabel text = new JLabel("���� �ð�: ");
		text.setBounds(175,305,220,30);
		text.setOpaque(true);
		text.setBackground(Color.pink);
		thirdpanel.add(text);

		JButton btn301 = new JButton(t2);
		btn301.addActionListener(this);
		btn301.setBounds(20, 20, 100, 130);
		btn301.setBorderPainted(false);
		btn301.setContentAreaFilled(false);
		thirdpanel.add(btn301);

		btn301.addActionListener(event -> {
			text.setText("�����ð�: 00:30");
		});

		btn301.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				text.setText("�����ð�: 00:30");
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				text.setText("");
			}
		});


		JButton btn309 = new JButton(t2);
		btn309.setBounds(20, 160, 100, 130);
		btn309.setBorderPainted(false);
		btn309.setContentAreaFilled(false);
		thirdpanel.add(btn309);

		JButton btn317 = new JButton("����");
		btn317.setBounds(20, 300, 100, 100);
		thirdpanel.add(btn317);

		JButton btn355 = new JButton("355");
		btn355.setBounds(130, 20, 230, 100);
		thirdpanel.add(btn355);

		JButton btn354 = new JButton("354");
		btn354.setBounds(370, 20, 70, 100);
		thirdpanel.add(btn354);

		JButton btn351 = new JButton(t1);
		btn351.setBounds(450, 20, 100, 90);
		btn351.setBorderPainted(false);
		btn351.setContentAreaFilled(false);
		thirdpanel.add(btn351);

		JButton btn348 = new JButton(t1);
		btn348.setBounds(450, 120, 100, 90);
		btn348.setBorderPainted(false);
		btn348.setContentAreaFilled(false);
		thirdpanel.add(btn348);

		JButton btn345 = new JButton(t1);
		btn345.setBounds(450, 220, 100, 90);
		btn345.setBorderPainted(false);
		btn345.setContentAreaFilled(false);
		thirdpanel.add(btn345);

		JButton btn342 = new JButton(t1);
		btn342.setBounds(450, 320, 100, 90);
		btn342.setBorderPainted(false);
		btn342.setContentAreaFilled(false);
		thirdpanel.add(btn342);

		JButton btntoi = new JButton(toi);
		btntoi.setBounds(140, 140, 290, 150);
		btntoi.setBorderPainted(false);
		btntoi.setContentAreaFilled(false);
		thirdpanel.add(btntoi);

		JButton btnele = new JButton(ele);
		btnele.setBounds(210, 350, 70, 70);
		btnele.setBorderPainted(false);
		btnele.setContentAreaFilled(false);
		thirdpanel.add(btnele);

		JButton btnele2 = new JButton(ele);
		btnele2.setBounds(290, 350, 70, 70);
		btnele2.setBorderPainted(false);
		btnele2.setContentAreaFilled(false);
		thirdpanel.add(btnele2);




		add(thirdpanel);
		secondpanel.setVisible(false);
		thirdpanel.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();

		if(btnStr.equals("2F"))
			arrange_2();
		else if(btnStr.equals("3F"))
			arrange_3();
		else if(btnStr.equals("301"))
			tt = new timetable(301);

		else {
			System.err.println("unexpected error.");
		}
	}



}
