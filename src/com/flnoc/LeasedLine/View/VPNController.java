package com.flnoc.LeasedLine.View;

import com.flnoc.LeasedLine.MainApp;
import com.flnoc.LeasedLine.Model.Vpn;
import com.flnoc.LeasedLine.Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by Rokhdelar on 2014-11-14.
 */
public class VPNController {
    @FXML
    private TableView<Vpn> vpnTableView;
    @FXML
    private TableColumn<Vpn,String> vpnNameTableColumn;
    @FXML
    private TableColumn<Vpn,String> vpnMainNumberTableColumn;
    @FXML
    private TableColumn<Vpn,String> vpnMemoTableColumn;

    @FXML
    private Label vpnNameLabel;
    @FXML
    private Label vpnMainNumberLabel;
    @FXML
    private Label vpnMemoLabel;

    private Stage vpnStage;
    public Stage getVpnStage() {
        return vpnStage;
    }

    public void setVpnStage(Stage vpnStage) {
        this.vpnStage = vpnStage;
    }

    private ObservableList<Vpn> vpns;
    private Session session;

    public VPNController() {
        vpns= FXCollections.observableArrayList();
        session= DBUtil.getInstance().getSession();
    }

    @FXML
    private void handleClose(){
        this.vpnStage.close();
    }

    @FXML
    private void handleDelete(){
        int selectedIndex=vpnTableView.getSelectionModel().getSelectedIndex();
        Vpn vpn=vpns.get(selectedIndex);
        Transaction transaction=session.beginTransaction();
        session.delete(vpn);
        transaction.commit();
        vpnTableView.getItems().remove(selectedIndex);
    }

    @FXML
    private void handleEdit(){
        Vpn vpn=vpnTableView.getSelectionModel().getSelectedItem();
        if (showEditVPNDialog(vpn)){
            Transaction transaction=session.beginTransaction();
            session.update(vpn);
            transaction.commit();
        }
    }

    @FXML
    private void handleNew(){
        Vpn vpn=new Vpn();
        if (showEditVPNDialog(vpn)){
            this.vpns.add(vpn);
            Transaction transaction=session.beginTransaction();
            session.save(vpn);
            transaction.commit();
        }
    }

    private boolean showEditVPNDialog(Vpn vpn){
        try {
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("View/VPNEditDialog.fxml"));
            Parent root=fxmlLoader.load();

            Stage vpnEditDialogStage=new Stage();
            vpnEditDialogStage.setTitle("修改VPN信息...");
            vpnEditDialogStage.initModality(Modality.WINDOW_MODAL);
            vpnEditDialogStage.initOwner(vpnStage);
            vpnEditDialogStage.setScene(new Scene(root));

            VPNEditDialogController vpnEditDialogController=fxmlLoader.getController();
            vpnEditDialogController.setVpnEditDialogStage(this.vpnStage);
            vpnEditDialogController.setVpn(vpn);

            vpnEditDialogStage.showAndWait();
            return vpnEditDialogController.isSaved();

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    private void showVPNDetail(Vpn vpn){
        if(vpn!=null){
            vpnNameLabel.setText(vpn.getVpnName());
            vpnMainNumberLabel.setText(vpn.getVpnMainNumber());
            vpnMemoLabel.setText(vpn.getVpnMemo());
        }else{
            vpnNameLabel.setText("");
            vpnMainNumberLabel.setText("");
            vpnMemoLabel.setText("");
        }
    }

    @FXML
    private void initialize(){
        vpnNameTableColumn.setCellValueFactory(cell->cell.getValue().vpnNameProperty());
        vpnMainNumberTableColumn.setCellValueFactory(cell->cell.getValue().vpnMainNumberProperty());
        vpnMemoTableColumn.setCellValueFactory(cell->cell.getValue().vpnMemoProperty());
        vpnMemoLabel.setWrapText(true);

        Query query=session.createQuery("from Vpn ");
        vpns.addAll(query.list());
        vpnTableView.setItems(vpns);

        showVPNDetail(null);

        vpnTableView.getSelectionModel().selectedItemProperty().addListener(
                (o,oldValue,newValue)->showVPNDetail(newValue)
        );
    }

    @Override
    protected void finalize() throws Throwable {
        session.close();
        super.finalize();
    }
}
