package com.flnoc.LeasedLine.View;

import com.flnoc.LeasedLine.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Rokhdelar on 2014-11-13.
 */
public class MainAppWindowController {
    private Stage mainAppStage;

    public void setMainAppStage(Stage mainAppStage) {
        this.mainAppStage = mainAppStage;
    }

    @FXML
    private void handleExit(){
        System.exit(0);
    }
    @FXML
    private void handleSubStation() throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("View/SubStation.FXML"));
        Parent root=fxmlLoader.load();

        Stage subStationStage=new Stage();
        subStationStage.setTitle("支局信息管理...");
        subStationStage.initModality(Modality.WINDOW_MODAL);
        subStationStage.initOwner(mainAppStage);
        subStationStage.setScene(new Scene(root));

        SubStationController subStationController=fxmlLoader.getController();
        subStationController.setSubStationStage(subStationStage);

        subStationStage.showAndWait();
    }
    @FXML
    private void handleVPN() throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("View/VPN.FXML"));
        Parent root=fxmlLoader.load();

        Stage vpnStage =new Stage();
        vpnStage.setTitle("VPN信息管理...");
        vpnStage.initModality(Modality.WINDOW_MODAL);
        vpnStage.initOwner(mainAppStage);
        vpnStage.setScene(new Scene(root));

        VPNController vpnController=fxmlLoader.getController();
        vpnController.setVpnStage(vpnStage);

        vpnStage.showAndWait();
    }
}
