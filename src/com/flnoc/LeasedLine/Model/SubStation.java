package com.flnoc.LeasedLine.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rokhdelar on 2014-11-11.
 */
@Entity
public class SubStation {
    private int subId;
    private StringProperty subName;
    //private String subName;
    private StringProperty subLeader;
    //private String subLeader;
    private StringProperty subPhone;
    //private String subPhone;
    private StringProperty subMemo;
    //private String subMemo;
    private Collection<CommRoom> commRoomsBySubId;

    @Override
    public String toString() {
        return "SubStation{" +
                "subId=" + subId +
                ", subName=" + subName.get() +
                ", subLeader=" + subLeader.get() +
                ", subPhone=" + subPhone.get() +
                ", subMemo=" + subMemo.get() +
                '}';
    }

    public SubStation(){
        this(null);
    }

    public SubStation(String subName){
        this.subName=new SimpleStringProperty(subName);
        this.subLeader=new SimpleStringProperty();
        this.subPhone=new SimpleStringProperty();
        this.subMemo=new SimpleStringProperty();
    }
    @Id
    @Column(name = "subID", nullable = false, insertable = true, updatable = true)
    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Basic
    @Column(name = "subName", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSubName() {
        return subName.get();
    }

    public void setSubName(String subName) {
        this.subName.set(subName);
    }

    public StringProperty subNameProperty(){
        return this.subName;
    }

    @Basic
    @Column(name = "subLeader", nullable = true, insertable = true, updatable = true, length = 10)
    public String getSubLeader() {
        return subLeader.get();
    }

    public void setSubLeader(String subLeader) {
        this.subLeader.set(subLeader);
    }

    public StringProperty subLeaderProperty(){
        return this.subLeader;
    }

    @Basic
    @Column(name = "subPhone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getSubPhone() {
        return subPhone.get();
    }

    public void setSubPhone(String subPhone) {
        this.subPhone.set(subPhone);
    }

    public StringProperty subPhoneProperty(){
        return subPhone;
    }

    @Basic
    @Column(name = "subMemo", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getSubMemo() {
        return subMemo.get();
    }

    public void setSubMemo(String subMemo) {
        this.subMemo.set(subMemo);
    }

    public StringProperty subMemoProperty(){
        return subMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubStation that = (SubStation) o;

        if (subId != that.subId) return false;
        if (subLeader != null ? !subLeader.equals(that.subLeader) : that.subLeader != null) return false;
        if (subMemo != null ? !subMemo.equals(that.subMemo) : that.subMemo != null) return false;
        if (subName != null ? !subName.equals(that.subName) : that.subName != null) return false;
        if (subPhone != null ? !subPhone.equals(that.subPhone) : that.subPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subId;
        result = 31 * result + (subName != null ? subName.hashCode() : 0);
        result = 31 * result + (subLeader != null ? subLeader.hashCode() : 0);
        result = 31 * result + (subPhone != null ? subPhone.hashCode() : 0);
        result = 31 * result + (subMemo != null ? subMemo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "subStationBySubId")
    public Collection<CommRoom> getCommRoomsBySubId() {
        return commRoomsBySubId;
    }

    public void setCommRoomsBySubId(Collection<CommRoom> commRoomsBySubId) {
        this.commRoomsBySubId = commRoomsBySubId;
    }
}
