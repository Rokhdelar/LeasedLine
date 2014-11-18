package com.flnoc.LeasedLine.View.Customer;

import com.flnoc.LeasedLine.Model.Customer;
import com.flnoc.LeasedLine.Util.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Rokhdelar on 2014-11-18.
 */
public class CustomerController {
    private Stage customerStage;
    private ObservableList<Customer> customers;
    private Session session;

    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer,String> customerNameTableColumn;
    @FXML
    private TableColumn<Customer,String> customerPhoneTableColumn;
    @FXML
    private TableColumn<Customer,String> customerManagerTableColumn;
    @FXML
    private TableColumn<Customer,String> customerMemoTableColumn;
    @FXML
    private Label customerNameLabel;
    @FXML
    private Label customerPhoneLabel;
    @FXML
    private Label customerManagerLabel;
    @FXML
    private Label customerMemoLabel;

    public CustomerController() {
        customers= FXCollections.observableArrayList();
        session= DBUtil.getInstance().getSession();
    }
    @FXML
    private void initialize(){
        customerNameTableColumn.setCellValueFactory(cell->cell.getValue().customerNameProperty());
        customerPhoneTableColumn.setCellValueFactory(cell->cell.getValue().customerPhoneProperty());
        customerManagerTableColumn.setCellValueFactory(cell->cell.getValue().customerManagerProperty());
        customerMemoTableColumn.setCellValueFactory(cell->cell.getValue().customerMemoProperty());

        Query query=session.createQuery("FROM Customer ");
        customers.addAll(query.list());
        customerTableView.setItems(customers);

        showCustomerDetail(null);
        customerTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,newValue)->showCustomerDetail(newValue)
        );
    }

    private void showCustomerDetail(Customer customer){
        if(customer!=null){
            customerNameLabel.setText(customer.getCustomerName());
            customerPhoneLabel.setText(customer.getCustomerPhone());
            customerManagerLabel.setText(customer.getCustomerManager());
            customerMemoLabel.setText(customer.getCustomerMemo());
        }else{
            customerNameLabel.setText("");
            customerPhoneLabel.setText("");
            customerManagerLabel.setText("");
            customerMemoLabel.setText("");
        }
    }
    @FXML
    private void handleDelete(){
        Customer customer=customerTableView.getSelectionModel().getSelectedItem();
        if(customer!=null){
            Transaction transaction=session.beginTransaction();
            session.delete(customer);
            transaction.commit();
            transaction.commit();
            customerTableView.getItems().remove(customer);
        }
    }

    @FXML
    private void handleClose(){
        this.customerStage.close();
    }
    public void setCustomerStage(Stage customerStage) {
        this.customerStage = customerStage;
    }

    @Override
    protected void finalize() throws Throwable {
        session.close();
        super.finalize();
    }
}
