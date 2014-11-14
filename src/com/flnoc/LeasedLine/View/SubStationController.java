package com.flnoc.LeasedLine.View;

import com.flnoc.LeasedLine.MainApp;
import com.flnoc.LeasedLine.Model.SubStation;
import com.flnoc.LeasedLine.Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;


/**
 * Created by X on 14/11/11.
 */
public class SubStationController {
    @FXML
    private TableView<SubStation> subStationTableView;
    @FXML
    private TableColumn<SubStation,String> subNameTableColumn;
    @FXML
    private TableColumn<SubStation,String> subLeaderTableColumn;
    @FXML
    private TableColumn<SubStation,String> subPhoneTableColumn;
    @FXML
    private TableColumn<SubStation,String> subMemoTableColumn;

    @FXML
    private Label subNameLabel;
    @FXML
    private Label subLeaderLabel;
    @FXML
    private Label subPhoneLabel;
    @FXML
    private Label subMemoLabel;
    @FXML
    private void handleClose(){
        this.subStationStage.close();
    }

    private ObservableList<SubStation> subStations;
    private Session session;
    private Stage subStationStage;

    public void setSubStationStage(Stage subStationStage) {
        this.subStationStage = subStationStage;
    }

    public SubStationController() {
        subStations= FXCollections.observableArrayList();
        session=DBUtil.getInstance().getSession();
    }

    @FXML
    private void initialize(){
        subNameTableColumn.setCellValueFactory(cell->cell.getValue().subNameProperty());
        subLeaderTableColumn.setCellValueFactory(cell->cell.getValue().subLeaderProperty());
        subPhoneTableColumn.setCellValueFactory(cell->cell.getValue().subPhoneProperty());
        subMemoTableColumn.setCellValueFactory(cell->cell.getValue().subMemoProperty());
        //用Hibernate获取SubStation的列表。

        Query query=session.createQuery("from SubStation ");
        subStations.addAll(query.list());

        subStationTableView.setItems(subStations);
        showSubStationDetail(null);

        subStationTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue,newValue)->showSubStationDetail(newValue)
        );
    }
    @FXML
    private void showSubStationDetail(SubStation subStation){
        if(subStation!=null){
            subNameLabel.setText(subStation.getSubName());
            subLeaderLabel.setText(subStation.getSubLeader());
            subPhoneLabel.setText(subStation.getSubPhone());
            subMemoLabel.setText(subStation.getSubMemo());
        }else
        {
            subNameLabel.setText("");
            subLeaderLabel.setText("");
            subPhoneLabel.setText("");
            subMemoLabel.setText("");
        }
    }
    @FXML
    private void handleDeleteSubStation(){
        int selectIndex=subStationTableView.getSelectionModel().getSelectedIndex();
        SubStation subStation=subStations.get(selectIndex);
        Transaction transaction=session.beginTransaction();
        session.delete(subStation);
        transaction.commit();
        subStationTableView.getItems().remove(selectIndex);
        session.delete(subStation);
    }

    private boolean showEditDialog(SubStation subStation){
        try{
            FXMLLoader fxmlLoader=new FXMLLoader();
            fxmlLoader.setLocation(MainApp.class.getResource("View/SubStationEditDialog.fxml"));
            Parent root=fxmlLoader.load();

            Stage editDialogStage=new Stage();
            editDialogStage.setTitle("修改支局信息...");
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(subStationStage);

            editDialogStage.setScene(new Scene(root));
            SubStationEditDialogController subStationEditDialogController=fxmlLoader.getController();
            subStationEditDialogController.setEditDialogStage(editDialogStage);
            subStationEditDialogController.setSubStation(subStation);

            editDialogStage.showAndWait();
            return subStationEditDialogController.isSaved();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @FXML
    private void handleNew(){
        SubStation subStation=new SubStation();
        if (showEditDialog(subStation)){
            subStations.add(subStation);
            Transaction transaction=session.beginTransaction();
            session.save(subStation);
            transaction.commit();
        }
    }

    @FXML
    private void handleEdit(){
        SubStation subStation=subStationTableView.getSelectionModel().getSelectedItem();

        if(showEditDialog(subStation)){
            showSubStationDetail(subStation);
            Transaction transaction=session.beginTransaction();
            session.update(subStation);
            transaction.commit();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        session.close();
        super.finalize();
    }
}
