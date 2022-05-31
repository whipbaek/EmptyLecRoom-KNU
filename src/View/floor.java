package View;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.util.Date;

public class floor extends JFrame implements ActionListener{

	ImageIcon b1_img = new ImageIcon("./img/b1.png");
	ImageIcon f2_img = new ImageIcon("./img/2f.png");
	ImageIcon f3_img = new ImageIcon("./img/3f.png");


	public static void main(String[] args) {
		floor gui = new floor();
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

	window2 wd2;
	JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );

	public static final int WIDTH = 400;
	public static final int HEIGHT = 260;

	public floor(){
		super("floor");
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		biggerPanel = new JPanel();
		biggerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		biggerPanel.setBackground(Color.WHITE);

		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		JButton submit = new JButton("submit");
		submit.addActionListener(this);

		JLabel label = new JLabel("Input Time");
		spinnerpanel = new JPanel();
		spinnerpanel.setLayout(new GridLayout(1,5));
		spinnerpanel.setBackground(Color.WHITE);
		spinnerpanel.add(label);
		spinnerpanel.add(daysCombo);
		spinnerpanel.add(hoursCombo);
		spinnerpanel.add(minsCombo);
		spinnerpanel.add(submit);

		biggerPanel.add(spinnerpanel);

		floorpanel = new JPanel();
		floorpanel.setBackground(Color.WHITE);
		floorpanel.setLayout(new FlowLayout());
		JButton b1 = new JButton(b1_img);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);

		//b1.setPreferredSize(new Dimension(73, 130));
		b1.addActionListener(this);
		JButton second = new JButton(f2_img);
		second.setBorderPainted(false);
		second.setContentAreaFilled(false);
		//second.setPreferredSize(new Dimension(73, 102));
		second.addActionListener(this);
		JButton third = new JButton(f3_img);
		third.setBorderPainted(false);
		third.setContentAreaFilled(false);
//		third.setPreferredSize(new Dimension(73, 102));
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

		String selectedDay = daysCombo.getItemAt(daysCombo.getSelectedIndex());
		String selectedHour = hoursCombo.getItemAt(hoursCombo.getSelectedIndex());
		String selectedMin = minsCombo.getItemAt(minsCombo.getSelectedIndex());

		System.out.println(selectedDay + ", " + selectedHour + ", " + selectedMin);

		if(btnStr.equals("submit")) {
			floorpanel.setVisible(true);
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

	private class getTimes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedHour = hoursCombo.getItemAt(hoursCombo.getSelectedIndex());
			String selectedMin = minsCombo.getItemAt(minsCombo.getSelectedIndex());

			System.out.println(selectedHour + ", " + selectedMin);
		}
	}

}


