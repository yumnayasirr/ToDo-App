package todo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton b1;
    JPanel newPanel;
    public JLabel userLabel, passLabel;
    JTextField textField1, textField2;

    Login() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        userLabel = new JLabel("Username");
        textField1 = new JTextField(15);

        passLabel = new JLabel("Password");
        textField2 = new JPasswordField(15);

        b1 = new JButton("SUBMIT");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(userLabel);
        panel.add(textField1);
        panel.add(passLabel);
        panel.add(textField2);
        panel.add(b1);

        add(panel, BorderLayout.CENTER);

        b1.addActionListener(this);
        setTitle("Admin Login");
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String username = textField1.getText();
            String password = textField2.getText();

            if ("manager".equals(username) && "manager".equals(password)) {

                JOptionPane.showMessageDialog(this, "Login successful!");

                ToDoManagerGUI adminDashboard = new ToDoManagerGUI();
                setVisible(false);;
            } else {

                JOptionPane.showMessageDialog(this, "Invalid username or password. Try again.");
            }

        }
    }

}
