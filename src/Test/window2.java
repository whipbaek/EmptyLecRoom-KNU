package Test;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class window2 extends JFrame implements ActionListener{
	
	public static final int WIDTH = 580;
	public static final int HEIGHT = 490;
	
	private JPanel b1panel;
	private JPanel secondpanel;
	private JPanel thirdpanel;
	
	ImageIcon ele = new ImageIcon("./img/elevator.png");
	ImageIcon toi = new ImageIcon("./img/toi.png");
	

	private static final Color newBlue = new Color(230,245,255);
	private static final Color newGray = new Color(239,243,246);
	
	  
	public static void main(String[] args) {
		window2 gui= new window2("3F");
	}
	
	public window2(String str){
		
		super(" ");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		b1panel = new JPanel();
		b1panel.setLayout(null);
		b1panel.setBackground(Color.WHITE);
		
		secondpanel = new JPanel();
		secondpanel.setLayout(null);
		secondpanel.setBackground(Color.WHITE);
		
		thirdpanel = new JPanel();
		thirdpanel.setBackground(Color.WHITE);
		thirdpanel.setLayout(null);
		
		//�޴�
		JMenu menu = new JMenu("select");
		
		JMenuItem B1 = new JMenuItem("B1");
		B1.addActionListener(this);
		menu.add(B1);
		
		JMenuItem second = new JMenuItem("2F");
		second.addActionListener(this);
		menu.add(second);
		
		JMenuItem third = new JMenuItem("3F");
		third.addActionListener(this);
		menu.add(third);
	
		JMenuBar bar = new JMenuBar();
		bar.add(menu);
		
		setJMenuBar(bar);
		
		//�г� ����
		arrange_b1();
		setVisible(true);
		arrange_2();
		setVisible(true);
		arrange_3();
		setVisible(true);
		
		if(str.equals("B1")) {
			b1panel.setVisible(true);
			secondpanel.setVisible(false);
			thirdpanel.setVisible(false);
		}
		else if(str.equals("2F")) {
			b1panel.setVisible(false);
			secondpanel.setVisible(true);
			thirdpanel.setVisible(false);
		}
		else if(str.equals("3F")) {
			b1panel.setVisible(false);
			secondpanel.setVisible(false);
			thirdpanel.setVisible(true);
		}			
	}
	
	public void arrange_b1() {
		JLabel text = new JLabel();
		text.setBounds(175,305,220,30);
		text.setOpaque(true); 
		text.setBackground(newGray);
		b1panel.add(text);
		
		JButton btn101 = new JButton("101");
		btn101.setBackground(newBlue);
		btn101.addActionListener(this);
		btn101.setBounds(100, 50, 150, 200);
		b1panel.add(btn101);
			
		btn101.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
       
	
		JButton btn102 = new JButton("102");
		btn102.setBackground(newBlue);
		btn102.addActionListener(this);
		btn102.setBounds(330, 50, 150, 200);
		b1panel.add(btn102);
		
		btn102.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		JButton btnele = new JButton(ele);
		btnele.setBounds(210, 350, 70, 70);
		btnele.setBorderPainted(false);
		btnele.setContentAreaFilled(false);
		b1panel.add(btnele);
		
		JButton btnele2 = new JButton(ele);
		btnele2.setBounds(290, 350, 70, 70);
		btnele2.setBorderPainted(false);
		btnele2.setContentAreaFilled(false);
		b1panel.add(btnele2);
		
		add(b1panel);
		
	}
	
	JButton btn201;
	JButton btn209;
	JButton btn217;
	JButton btn255;
	JButton btn254;
	JButton btn251;
	JButton btn248;
	JButton btn245;
	JButton btn242;
	
	public void arrange_2(){ 
		JLabel text = new JLabel();
		text.setBounds(175,305,220,30);
		text.setOpaque(true); 
		text.setBackground(newGray);
		secondpanel.add(text);
		
		btn201 = new JButton("201");
		btn201.setBackground(newBlue);
		btn201.addActionListener(this);
		btn201.setBounds(20, 20, 100, 130);
		secondpanel.add(btn201);
			
		btn201.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
       
	
		btn209 = new JButton("209");
		btn209.setBackground(newBlue);
		btn209.addActionListener(this);
		btn209.setBounds(20, 160, 100, 130);
		secondpanel.add(btn209);
		
		btn209.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn217 = new JButton("����");
		btn217.setBackground(newBlue);
		btn217.addActionListener(this);
		btn217.setBounds(20, 300, 100, 100);
		secondpanel.add(btn217);
		
		btn217.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn255 = new JButton("255");
		btn255.setBackground(Color.WHITE);
		btn255.addActionListener(this);
		btn255.setBounds(130, 20, 230, 100);
		secondpanel.add(btn255);
		
		btn255.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn254 = new JButton("254");
		btn254.setBackground(newBlue);
		btn254.addActionListener(this);
		btn254.setBounds(370, 20, 70, 100);
		secondpanel.add(btn254);
		
		btn254.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn251 = new JButton("251");
		btn251.setBackground(newBlue);
		btn251.addActionListener(this);
		btn251.setBounds(450, 20, 100, 90);
		secondpanel.add(btn251);
		
		btn251.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn248 = new JButton("248");
		btn248.setBackground(newBlue);
		btn248.addActionListener(this);
		btn248.setBounds(450, 120, 100, 90);
		secondpanel.add(btn248);
		
		btn248.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn245 = new JButton("245");
		btn245.setBackground(newBlue);
		btn245.addActionListener(this);
		btn245.setBounds(450, 220, 100, 90);
		secondpanel.add(btn245);
		
		btn245.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
			
		btn242 = new JButton("242");
		btn242.setBackground(Color.WHITE);
		btn242.addActionListener(this);
		btn242.setBounds(450, 320, 100, 90);
		secondpanel.add(btn242);
		
		btn242.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		JButton btntoi = new JButton(toi);
		btntoi.setBounds(140, 140, 290, 150);
		btntoi.setBorderPainted(false);
		btntoi.setContentAreaFilled(false);
		secondpanel.add(btntoi);
		
		JButton btnele = new JButton(ele);
		btnele.setBounds(210, 350, 70, 70);
		btnele.setBorderPainted(false);
		btnele.setContentAreaFilled(false);
		secondpanel.add(btnele);
		
		JButton btnele2 = new JButton(ele);
		btnele2.setBounds(290, 350, 70, 70);
		btnele2.setBorderPainted(false);
		btnele2.setContentAreaFilled(false);
		secondpanel.add(btnele2);
				
		add(secondpanel);
	}
	
	JButton btn301;
	JButton btn309;
	JButton btn317;
	JButton btn355;
	JButton btn354;
	JButton btn351;
	JButton btn348;
	JButton btn345;
	JButton btn342;
	
	public void arrange_3(){
		
		JLabel text = new JLabel();
		text.setBounds(175,305,220,30);
		text.setOpaque(true); 
		text.setBackground(newGray);
		thirdpanel.add(text);
		
		btn301 = new JButton("301");
		btn301.setBackground(newBlue);
		btn301.addActionListener(this);
		btn301.setBounds(20, 20, 100, 130);
		thirdpanel.add(btn301);
			
		btn301.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
       
	
		btn309 = new JButton("309");
		btn309.setBackground(newBlue);
		btn309.addActionListener(this);
		btn309.setBounds(20, 160, 100, 130);
		thirdpanel.add(btn309);
		
		btn309.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn317 = new JButton("����");
		btn317.setBackground(newBlue);
		btn317.addActionListener(this);
		btn317.setBounds(20, 300, 100, 100);
		thirdpanel.add(btn317);
		
		btn317.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn355 = new JButton("355");
		btn355.setBackground(Color.WHITE);
		btn355.addActionListener(this);
		btn355.setBounds(130, 20, 230, 100);
		thirdpanel.add(btn355);
		
		btn355.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn354 = new JButton("354");
		btn354.setBackground(newBlue);
		btn354.addActionListener(this);
		btn354.setBounds(370, 20, 70, 100);
		thirdpanel.add(btn354);
		
		btn354.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn351 = new JButton("351");
		btn351.setBackground(newBlue);
		btn351.addActionListener(this);
		btn351.setBounds(450, 20, 100, 90);
		thirdpanel.add(btn351);
		
		btn351.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn348 = new JButton("348");
		btn348.setBackground(newBlue);
		btn348.addActionListener(this);
		btn348.setBounds(450, 120, 100, 90);
		thirdpanel.add(btn348);
		
		btn348.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
		btn345 = new JButton("345");
		btn345.setBackground(newBlue);
		btn345.addActionListener(this);
		btn345.setBounds(450, 220, 100, 90);
		thirdpanel.add(btn345);
		
		btn345.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
			
		btn342 = new JButton("342");
		btn342.setBackground(Color.WHITE);
		btn342.addActionListener(this);
		btn342.setBounds(450, 320, 100, 90);
		thirdpanel.add(btn342);
		
		btn342.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	text.setText("�����ð�: 00:30");
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	text.setText("");
		    }
		});
		
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
	}
		
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		if(btnStr.equals("B1")) {
			b1panel.setVisible(true);
			thirdpanel.setVisible(false);
			secondpanel.setVisible(false);			
		}			
		else if(btnStr.equals("2F")) {
			b1panel.setVisible(false);
			thirdpanel.setVisible(false);
			secondpanel.setVisible(true);			
		}			
		else if(btnStr.equals("3F")){
			b1panel.setVisible(false);
			thirdpanel.setVisible(true);
			secondpanel.setVisible(false);
		}
			
		else {
			System.err.println("unexpected error.");
		}
	}	
}