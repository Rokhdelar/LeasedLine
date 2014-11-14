package com.flnoc.LeasedLine.View;

import com.flnoc.LeasedLine.Model.SubStation;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
public class SubStationEditDialogController {
    @FXML
    private TextField subNameField;
    @FXML
    private TextField subLeaderField;
    @FXML
    private TextField subPhoneField;
    @FXML
    private TextField subMemoTextArea;

    private Stage editDialogStage;
    private SubStation subStation;
    private boolean isSave=false;

    @FXML
    private void initialize(){

    }

    public void setEditDialogStage(Stage editDialogStage) {
        this.editDialogStage = editDialogStage;
    }

    public void setSubStation(SubStation subStation) {
        this.subStation = subStation;

        subNameField.setText(subStation.getSubName());
        subLeaderField.setText(subStation.getSubLeader());
        subPhoneField.setText(subStation.getSubPhone());
        subMemoTextArea.setText(subStation.getSubMemo());
    }

    public boolean isSaved(){
        return isSave;
    }

    @FXML
    private void handleSave(){
        if(isInputValid()){
            subStation.setSubName(subNameField.getText());
            subStation.setSubLeader(subLeaderField.getText());
            subStation.setSubPhone(subPhoneField.getText());
            subStation.setSubMemo(subMemoTextArea.getText());
            isSave=true;
            this.editDialogStage.close();
        }
    }
    @FXML
    private void handleCancel(){
        editDialogStage.close();
    }

    private boolean isInputValid(){

        return true;
    }
}
