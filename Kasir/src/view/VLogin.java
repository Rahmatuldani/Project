package view;

import javax.swing.*;
import java.awt.event.*;
import controller.*;
import model.*;

public class VLogin extends JFrame implements ActionListener,Listener {
    final JTextField fid = new JTextField(10);
    final JPasswordField fpass = new JPasswordField(10);
    JLabel lid = new JLabel("ID");
    JLabel lpass = new JLabel("Password");
    JButton btnLogin = new JButton("Login");
    CLogin cLogin;
    MLogin mLogin;

    public VLogin(){
        setTitle("Login");
        setDefaultCloseOperation(3);
        setSize(380,190);

        setLayout(null);
        add(lid);
        add(fid);
        add(lpass);
        add(fpass);
        add(btnLogin);

        lid.setBounds(40,30,120,25);
        fid.setBounds(160,30,170,25);
        lpass.setBounds(40,65,120,25);
        fpass.setBounds(160,65,170,25);
        btnLogin.setBounds(250,110,80,25);

        btnLogin.addActionListener(this);

        setVisible(true);

        cLogin = new CLogin();
        mLogin = new MLogin();
        mLogin.setListener(this);
        cLogin.setMo(mLogin);
    }

    public JTextField getFid() {
        return fid;
    }

    public JPasswordField getFpass() {
        return fpass;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnLogin){
            cLogin.submitForm(this);
        }
    }

    @Override
    public void onChange(MLogin mLogin) {
        fid.setText(mLogin.getID());
        fpass.setText(mLogin.getPass());
    }
}
