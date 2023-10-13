package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel pwLabel;
    private JPasswordField pwField;
    private JButton loginButton;

    public Login() {
        frame = new JFrame("Login Screen");
        panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setBounds(600, 300, 500, 1500);

        idLabel = new JLabel("ID: ", SwingConstants.CENTER);
        idField = new JTextField(20);
        
        pwLabel = new JLabel("PW: ", SwingConstants.CENTER);
        pwField = new JPasswordField(20);
        pwField.setEchoChar('*');
        
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = idField.getText();
                char[] password = pwField.getPassword(); 
                String passwordString = new String(password);

                if (isValidLogin(username, passwordString)) {
                    JOptionPane.showMessageDialog(frame, "로그인 성공");
                } else {
                    JOptionPane.showMessageDialog(frame, "로그인 실패");
                }

                pwField.setText("");
            }
        });

        panel.setLayout(new GridLayout(3, 2));
        panel.add(idLabel);
        panel.add(idField);
        panel.add(pwLabel);
        panel.add(pwField);
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