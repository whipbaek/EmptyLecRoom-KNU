package View;

import Model.TimeTable;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static View.FirstPage.*;

public class Floor3 extends JFrame implements ActionListener{

	public static JLabel text = new JLabel("강의실 현황: ");
	private JPanel thirdpanel;
	ImageIcon t1 = new ImageIcon("./img/t1.png"); //
	ImageIcon t2 = new ImageIcon("./img/t2.png"); //
	ImageIcon ele = new ImageIcon("./img/elevator.png");
	ImageIcon toi = new ImageIcon("./img/toi.png");

	public static void main(String[] args) {
		 new Floor3();
	}

	public Floor3(){

		super("3rd Floor");
		setSize(FirstPage.WIDTH,FirstPage.HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());


		thirdpanel = new JPanel();
		thirdpanel.setBackground(Color.WHITE);
		thirdpanel.setLayout(null);

		JMenuItem B1 = new JMenuItem("B1");
		B1.addActionListener(new MoveMenu());
		JMenuItem second = new JMenuItem("2F");
		second.addActionListener(new MoveMenu());
		JMenuItem third = new JMenuItem("3F");
		third.addActionListener(new MoveMenu());


		JMenuBar bar = new JMenuBar();
		bar.add(B1);
		bar.add(second);
		bar.add(third);


		text.setBounds(175,305,400,30);
		text.setOpaque(true);
		text.setBackground(Color.pink);
		thirdpanel.add(text);

		JButton btn301 = new JButton("301");
		btn301.addActionListener(this);
		btn301.setBounds(20, 20, 100, 130);

		if(isEmptyFloorRoom("301")) btn301.setBackground(Color.blue);
		else btn301.setBackground(Color.red);

//		btn301.setBorderPainted(false);
//		btn301.setContentAreaFilled(false);
		thirdpanel.add(btn301);

		btn301.addActionListener(event -> {
			text.setText(parsingClass.IsEmptyRoom("301","월","11:30"));
		});

		btn301.addMouseListener(new mouseOnTheRoom());

		btn301.addActionListener(new makingTimeTableOnClick());
		JButton btn309 = new JButton("309");
		btn309.setBounds(20, 160, 100, 130);
//		btn309.setBorderPainted(false);
//		btn309.setContentAreaFilled(false);
		thirdpanel.add(btn309);

		JButton btn317 = new JButton("317");
		btn317.setBounds(20, 300, 100, 100);
		thirdpanel.add(btn317);

		JButton btn355 = new JButton("355");
		btn355.setBounds(130, 20, 230, 100);
		thirdpanel.add(btn355);
		if(isEmptyFloorRoom("355")) btn355.setBackground(Color.blue);
		else btn355.setBackground(Color.red);

		JButton btn354 = new JButton("354");
		btn354.setBounds(370, 20, 70, 100);
		thirdpanel.add(btn354);

		JButton btn351 = new JButton("351");
		btn351.setBounds(450, 20, 100, 90);
		if(isEmptyFloorRoom("351")) btn351.setBackground(Color.blue);
		else btn351.setBackground(Color.red);
//		btn351.setBorderPainted(false);
//		btn351.setContentAreaFilled(false);
		thirdpanel.add(btn351);

		JButton btn348 = new JButton("348");
		btn348.setBounds(450, 120, 100, 90);
		if(isEmptyFloorRoom("348")) btn348.setBackground(Color.blue);
		else btn348.setBackground(Color.red);
//		btn348.setBorderPainted(false);
//		btn348.setContentAreaFilled(false);
		thirdpanel.add(btn348);

		JButton btn345 = new JButton("345");
		btn345.setBounds(450, 220, 100, 90);
		if(isEmptyFloorRoom("345")) btn345.setBackground(Color.blue);
		else btn345.setBackground(Color.red);
//		btn345.setBorderPainted(false);
//		btn345.setContentAreaFilled(false);
		thirdpanel.add(btn345);

		JButton btn342 = new JButton("342");
		btn342.setBounds(450, 320, 100, 90);
		if(isEmptyFloorRoom("342")) btn342.setBackground(Color.blue);
		else btn342.setBackground(Color.red);
//		btn342.setBorderPainted(false);
//		btn342.setContentAreaFilled(false);
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
		thirdpanel.setVisible(true);

		setJMenuBar(bar);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	private class MoveMenu implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()){
				case "B1":
					break;
				case "2F":
					new Floor2();
					setVisible(false);
					break;
			}
		}
	}

	public boolean isEmptyFloorRoom(String roomNum){
		return parsingClass.IsEmptyRoomBool(roomNum, nowDay, nowTime);
	}

	private class makingTimeTableOnClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			TimeTable tt = new TimeTable(e.getActionCommand(),parsingClass.getClassInfos());
			tt.setVisible(true);
		}
	}
	private class mouseOnTheRoom implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			String btnText = ((JButton) e.getSource()).getText();
			text.setText(parsingClass.IsEmptyRoom(btnText, nowDay, nowTime));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			text.setText("");
		}
	}
}
