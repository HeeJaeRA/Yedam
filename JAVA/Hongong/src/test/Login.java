package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        frame = new JFrame("Login Screen");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameLabel = new JLabel("ID: ");
        passwordLabel = new JLabel("Password: ");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword(); 
                String passwordString = new String(password);

                if (isValidLogin(username, passwordString)) {
                    JOptionPane.showMessageDialog(frame, "로그인 성공");
                } else {
                    JOptionPane.showMessageDialog(frame, "로그인 실패");
                }

                passwordField.setText("");
            }
        });

        panel.setLayout(new GridLayout(3, 2));
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private boolean isValidLogin(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {

    	new Login();
    	
    }
}