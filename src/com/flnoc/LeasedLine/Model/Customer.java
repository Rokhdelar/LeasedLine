package com.flnoc.LeasedLine.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
@Entity
public class Customer {
    private int customerId;
    private StringProperty customerName;
    private StringProperty customerPhone;
    private StringProperty customerManager;
    private StringProperty customerMemo;
    private Collection<Lline> llinesByCustomerId;

    public Customer() {
        this.customerName=new SimpleStringProperty();
        this.customerPhone=new SimpleStringProperty();
        this.customerManager=new SimpleStringProperty();
        this.customerMemo=new SimpleStringProperty();
    }

    @Id
    @Column(name = "CustomerID", nullable = false, insertable = true, updatable = true)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "CustomerName", nullable = false, insertable = true, updatable = true, length = 100)
    public String getCustomerName() {
        return customerName.get();
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public StringProperty customerNameProperty(){
        return this.customerName;
    }

    @Basic
    @Column(name = "CustomerPhone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getCustomerPhone() {
        return customerPhone.get();
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone.set(customerPhone);
    }

    public StringProperty customerPhoneProperty(){
        return this.customerPhone;
    }
    @Basic
    @Column(name = "CustomerManager", nullable = true, insertable = true, updatable = true, length = 20)
    public String getCustomerManager() {
        return customerManager.get();
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager.set(customerManager);
    }
    public StringProperty customerManagerProperty(){
        return this.customerManager;
    }

    @Basic
    @Column(name = "CustomerMemo", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getCustomerMemo() {
        return customerMemo.get();
    }

    public void setCustomerMemo(String customerMemo) {
        this.customerMemo.set(customerMemo);
    }

    public StringProperty customerMemoProperty(){
        return this.customerMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerId != customer.customerId) return false;
        if (customerManager != null ? !customerManager.equals(customer.customerManager) : customer.customerManager != null)
            return false;
        if (customerMemo != null ? !customerMemo.equals(customer.customerMemo) : customer.customerMemo != null)
            return false;
        if (customerName != null ? !customerName.equals(customer.customerName) : customer.customerName != null)
            return false;
        if (customerPhone != null ? !customerPhone.equals(customer.customerPhone) : customer.customerPhone != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (customerPhone != null ? customerPhone.hashCode() : 0);
        result = 31 * result + (customerManager != null ? customerManager.hashCode() : 0);
        result = 31 * result + (customerMemo != null ? customerMemo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Lline> getLlinesByCustomerId() {
        return llinesByCustomerId;
    }

    public void setLlinesByCustomerId(Collection<Lline> llinesByCustomerId) {
        this.llinesByCustomerId = llinesByCustomerId;
    }
}
