package com.flnoc.LeasedLine.View;

import com.flnoc.LeasedLine.Model.SubStation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;


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
    private Stage subStationStage;

    public void setSubStationStage(Stage subStationStage) {
        this.subStationStage = subStationStage;
    }

    public SubStationController() {
    }

    @FXML
    private void initialize(){
        subNameTableColumn.setCellValueFactory(cell->cell.getValue().subNameProperty());
        subLeaderTableColumn.setCellValueFactory(cell->cell.getValue().subLeaderProperty());
        subPhoneTableColumn.setCellValueFactory(cell->cell.getValue().subPhoneProperty());
        subMemoTableColumn.setCellValueFactory(cell->cell.getValue().subMemoProperty());

        //用Hibernate获取SubStation的列表。

        subStationTableView.setItems(subStations);
    }
}
