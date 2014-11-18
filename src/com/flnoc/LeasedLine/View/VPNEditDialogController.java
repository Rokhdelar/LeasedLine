package com.flnoc.LeasedLine.View;

import com.flnoc.LeasedLine.Model.Vpn;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Created by Rokhdelar on 2014-11-14.
 */
public class VPNEditDialogController {
    @FXML
    private TextField vpnNameTextField;
    @FXML
    private TextField vpnMainNumberTextField;
    @FXML
    private TextArea vpnMemoTextArea;

    private Stage vpnEditDialogStage;
    private Vpn vpn;
    private boolean isSave=false;

    public void setVpnEditDialogStage(Stage vpnEditDialogStage) {
        this.vpnEditDialogStage = vpnEditDialogStage;
    }

    public boolean isSaved() {
        return isSave;
    }

    public void setVpn(Vpn vpn) {
        this.vpn = vpn;

        vpnNameTextField.setText(vpn.getVpnName());
        vpnMainNumberTextField.setText(vpn.getVpnMainNumber());
        vpnMemoTextArea.setText(vpn.getVpnMemo());
    }

    @FXML
    private void handleSave(){
        vpn.setVpnName(vpnNameTextField.getText());
        vpn.setVpnMainNumber(vpnMainNumberTextField.getText());
        vpn.setVpnMemo(vpnMemoTextArea.getText());
        isSave=true;
        this.vpnEditDialogStage.close();
    }

    @FXML
    private void handleCancel(){
        this.vpnEditDialogStage.close();
    }
}
