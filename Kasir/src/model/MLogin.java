package model;

import view.*;
import javax.swing.*;

public class MLogin {
    private String id, pass;
    private Listener listener;

    protected void fireOnChange(){
        if (listener != null){
            listener.onChange(this);
        }
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public String getID() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        fireOnChange();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
        fireOnChange();
    }

    public void submitForm(VLogin vLogin){
        String id = vLogin.getFid().getText();
        JOptionPane.showMessageDialog(vLogin,id);
//        if (id == "admin"){
////            if (vLogin.getFpass().getText() == "adminpass"){
//                JOptionPane.showMessageDialog(vLogin,"Login berhasil!");
////                vLogin.dispose();
////            } else {
////                JOptionPane.showMessageDialog(vLogin,"Password salah!");
////            }
//        } else {
//            JOptionPane.showMessageDialog(vLogin,"ID tidak ada!");
//        }
    }

    public void resetForm(){
        setId("");
        setPass("");
    }
}
