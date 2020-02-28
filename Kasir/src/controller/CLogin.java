package controller;

import model.MLogin;
import view.*;

import javax.swing.*;

public class CLogin {
    private MLogin mo;

    public void setMo(MLogin mLogin) {
        mo = mLogin;
    }

    public void submitForm(VLogin vLogin) {
        String Id = vLogin.getFid().getText();
        String Pass = vLogin.getFpass().getText();

        if (Id.trim().equals("")){
            JOptionPane.showMessageDialog(vLogin,"ID harus diisi!");
        } else if (Pass.trim().equals("")){
            JOptionPane.showMessageDialog(vLogin,"Password Harus Diisi!");
        } else {
            mo.submitForm(vLogin);
        }
    }
}
