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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import java.util.Date;

public class timetable extends JFrame{
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 450;
	
	public timetable(int num){
		
		super("timetable");
	
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		JLabel label = new JLabel(num+"ȣ �ð�ǥ");
		label.setFont(new Font("����ü",Font.BOLD,20));
	    label.setHorizontalAlignment(JLabel.CENTER); 
	        
	    add(label,BorderLayout.NORTH);
		
		
		String header[] = {"�ð�","��","ȭ","��","��","��"};
		String contents[][]= {
				{"9:00~9:30","a","b","c","d",null},
				{"9:30~10:00","a","b","c","d",null},
				{"10:00~10:30","a","b","c","d",null},
				{"10:30~11:00","a","b","c","d",null},
				{"11:00~11:30","a","b","c","d",null},
				{"11:30~12:00","a","b","c","d",null},
				{"12:00~12:30","a","b","c","d",null}
		};
		JTable table = new JTable(contents,header);
		JScrollPane scrollpane = new JScrollPane(table);
		add(scrollpane,BorderLayout.CENTER);
		
		setVisible(true);
		
		

	}
	
}
