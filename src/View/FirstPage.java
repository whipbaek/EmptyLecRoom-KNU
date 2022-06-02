package View;

import Model.ITBuild;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class FirstPage extends JFrame implements ActionListener{

	ImageIcon b1_img = new ImageIcon("./img/b1.png");
	ImageIcon f2_img = new ImageIcon("./img/2f.png");
	ImageIcon f3_img = new ImageIcon("./img/3f.png");


	public static void main(String[] args) {
		FirstPage gui = new FirstPage();
		gui.setVisible(true);
	}
	String[] days = {"월","화","수","목","금"};
	String[] hours = {"09","10","11","12","13","14","15","16","17","18"};
	String[] mins = {"00","01","02","03","04","05","06","07","08","09","10",
			"11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
			"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50",
			"51","52","53","54","55","56","57","58","59"};
	private JPanel biggerPanel;
	private JPanel spinnerpanel;
	private JPanel floorpanel;
	private JComboBox<String> daysCombo = new JComboBox<>(days);
	private JComboBox<String> hoursCombo = new JComboBox<>(hours);
	private JComboBox<String> minsCombo = new JComboBox<>(mins);
	private JButton b1;
	private JButton second;
	private JButton third;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static ITBuild tempIt;
	public static String nowTime;
	public static String nowDay;

	public FirstPage(){
		super("Empty Lec Rooms for KNU IT5");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //화면 중앙

		biggerPanel = new JPanel();
		biggerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		biggerPanel.setBackground(Color.WHITE);

		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		JButton submitbtn = new JButton("submit");
		submitbtn.addActionListener(this);

		JLabel label = new JLabel("Please enter a time ");
		spinnerpanel = new JPanel();
		spinnerpanel.setLayout(new GridLayout(1,5));
		spinnerpanel.setBackground(Color.WHITE);
		spinnerpanel.add(label);
		spinnerpanel.add(daysCombo);
		spinnerpanel.add(hoursCombo);
		spinnerpanel.add(minsCombo);
		spinnerpanel.add(submitbtn);

		biggerPanel.add(spinnerpanel);

		floorpanel = new JPanel();
		floorpanel.setBackground(Color.WHITE);
		floorpanel.setLayout(new FlowLayout());

		b1 = new JButton(b1_img);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.addActionListener(new moveToFloorObj());

		second = new JButton(f2_img);
		second.setBorderPainted(false);
		second.setContentAreaFilled(false);
		second.addActionListener(new moveToFloorObj());

		third = new JButton(f3_img);
		third.setBorderPainted(false);
		third.setContentAreaFilled(false);
		third.addActionListener(new moveToFloorObj());

		floorpanel.add(b1);
		floorpanel.add(second);
		floorpanel.add(third);
		biggerPanel.add(floorpanel);
		add(biggerPanel);

		floorpanel.setVisible(false);
	}



// submit Event
	@Override
	public void actionPerformed(ActionEvent e) {

		tempIt = new ITBuild();
		try {
			tempIt.setArrayLists(); //파일에서 데이터 읽어옴
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		tempIt.setCinfos(); // 읽어온 데이터를 Cinfos에 저장함
		tempIt.setClassByRoom(); // 호실 마다 시간표를 정리

		// 특정시간을 매개변수로 넣고 비어있는지 차 있는지 확인한다.

		floorpanel.setVisible(true);
		System.out.println(e.getActionCommand());
		String selectedDay = daysCombo.getItemAt(daysCombo.getSelectedIndex());
		String selectedHour = hoursCombo.getItemAt(hoursCombo.getSelectedIndex());
		String selectedMin = minsCombo.getItemAt(minsCombo.getSelectedIndex());
		nowTime = selectedHour + ":" + selectedMin;
		nowDay = selectedDay;

	}

	//층별 창으로 이동
	private class moveToFloorObj implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			Object source = e.getSource();

			if (b1.equals(source)) {
				setVisible(false);
			} else if (second.equals(source)) {
				new Floor2();
				setVisible(false);
			} else if (third.equals(source)) {
				new Floor3();
				setVisible(false);
			}
		}
	}
}




