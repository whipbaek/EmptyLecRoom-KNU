package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Floor2 extends JFrame implements ActionListener {


    private JPanel secondpanel;

    public static void main(String[] args) {
        new Floor2();
    }

    public Floor2() throws HeadlessException {

        super("2nd Floor");
        setSize(FirstPage.WIDTH,FirstPage.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        secondpanel = new JPanel();
        secondpanel.setLayout(null);
        secondpanel.setBackground(Color.WHITE);

        setVisible(true);

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
        secondpanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
