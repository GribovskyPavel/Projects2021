package by.bsu.labGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.*;

public class MyGUI extends JFrame {
    private final JTextField text1 = new JTextField();
    private final JTextField text2 = new JTextField();
    private final ArrayList<String> list = new ArrayList<>();

    MyGUI(){
        super("MyApplication");
        this.setBounds(450,300,600,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Button button1 = new Button("Copy");
        Button button2 = new Button("Print");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        button1.addActionListener(new ButtonEventCopy());
        button2.addActionListener(new ButtonEventPrint());

        Container container = this.getContentPane();
        label1.setText("Поле ввода");
        label2.setText("Поле вывода");
        panel1.add(text1,BorderLayout.CENTER);
        panel1.add(label1,BorderLayout.NORTH);
        panel2.add(text2,BorderLayout.CENTER);
        panel2.add(label2,BorderLayout.NORTH);

        mainPanel.add(panel1,BorderLayout.NORTH);
        mainPanel.add(panel2,BorderLayout.CENTER);
        mainPanel.add(button1,BorderLayout.WEST);
        mainPanel.add(button2,BorderLayout.EAST);

        container.add(mainPanel);

    }
    class ButtonEventCopy implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = text1.getText();
            text2.setText(str);
            list.add(str);
        }
    }
    class ButtonEventPrint implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            TreeSet<String> tree = new TreeSet(list);
            System.out.println(tree);
        }
    }
}
