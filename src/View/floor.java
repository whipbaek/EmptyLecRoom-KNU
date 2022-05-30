package View;
import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import java.util.Date;

public class floor extends JFrame implements ActionListener{
	
	public static void main(String[] args) {
		floor gui = new floor();
		gui.setVisible(true);
	}
	
	
	private JPanel biggerPanel;
	private JPanel spinnerpanel;
	private JPanel floorpanel;
	
	window2 wd2;
	JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
	
	public static final int WIDTH = 300;
	public static final int HEIGHT = 150;
	
	public floor(){
		super("floor");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		biggerPanel = new JPanel(); 
		biggerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		spinnerpanel = new JPanel();
	
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date()); 
		JButton submit = new JButton("submit");
		submit.addActionListener(this);
		//안녕하세
		JLabel label = new JLabel("��/��"); //��¥: ��/��/��
		spinnerpanel = new JPanel();
		spinnerpanel.add(label,BorderLayout.WEST);
		spinnerpanel.add(timeEditor,BorderLayout.EAST);
		spinnerpanel.add(submit,BorderLayout.CENTER);
		biggerPanel.add(spinnerpanel);
		
		floorpanel = new JPanel();
		floorpanel.setLayout(new FlowLayout());
		JButton b1 = new JButton("B1");
		b1.addActionListener(this);
		JButton second = new JButton("2F");
		second.addActionListener(this);
		JButton third = new JButton("3F");
		third.addActionListener(this);
		
		floorpanel.add(b1);
		floorpanel.add(second);
		floorpanel.add(third);
		biggerPanel.add(floorpanel);
		add(biggerPanel);
		
		floorpanel.setVisible(false);
	}
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		String btnStr = e.getActionCommand();
		
		
		if(btnStr.equals("submit")) {
			floorpanel.setVisible(true);
			Date date = (Date)timeSpinner.getValue();	
			System.out.println(date);
		}
		else if(btnStr.equals("B1"))
			wd2 = new window2("B1");
		else if(btnStr.equals("2F"))
			wd2 = new window2("2F");
		else if(btnStr.equals("3F"))
			wd2 = new window2("3F");
			
		else {
			System.err.println("unexpected error.");
		}
	}	
	
}


