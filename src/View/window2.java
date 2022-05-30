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
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 400;
	
	timetable tt;
	
	
	public static void main(String[] args) {
		
	}
	
	public window2(String str){
		
		super(str);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		secondpanel = new JPanel();
		secondpanel.setLayout(null);
		thirdpanel = new JPanel();
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
		JButton btn301 = new JButton("301");
		btn301.addActionListener(this);
		btn301.setBounds(30, 30, 60, 80);
		btn301.setFont(new Font("����ü",Font.BOLD,15));
		btn301.setToolTipText("�����ð�: ");
		thirdpanel.add(btn301);
	
		JButton btn302 = new JButton("302");
		btn302.setBounds(30, 120, 60, 80);
		thirdpanel.add(btn302);
		
		JButton btn303 = new JButton("����");
		btn303.setBounds(30, 210, 60, 50);
		thirdpanel.add(btn303);
		
		JButton btn304 = new JButton("304");
		btn304.setBounds(30, 275, 60, 50);
		thirdpanel.add(btn304);
		
		JButton btn305 = new JButton("305");
		btn305.setBounds(100, 30, 80, 50);
		thirdpanel.add(btn305);
		
		JButton btn306 = new JButton("306");
		btn306.setBounds(190, 30, 80, 50);
		thirdpanel.add(btn306);
		
		JButton btn307 = new JButton("307");
		btn307.setBounds(280, 30, 80, 50);
		thirdpanel.add(btn307);
		
		JButton btn308 = new JButton("308");
		btn308.setBounds(370, 30, 60, 100);
		thirdpanel.add(btn308);
		
		JButton btn309 = new JButton("309");
		btn309.setBounds(370, 140, 60, 90);
		thirdpanel.add(btn309);
		
		JButton btn310 = new JButton("310");
		btn310.setBounds(370, 240, 60, 60);
		thirdpanel.add(btn310);
		
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
