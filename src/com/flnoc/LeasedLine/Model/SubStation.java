package com.flnoc.LeasedLine.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rokhdelar on 2014-11-11.
 */
@Entity
public class SubStation {
    private int subId;
    private String subName;
    private String subLeader;
    private String subPhone;
    private String subMemo;
    private Collection<CommRoom> commRoomsBySubId;

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
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Basic
    @Column(name = "subLeader", nullable = true, insertable = true, updatable = true, length = 10)
    public String getSubLeader() {
        return subLeader;
    }

    public void setSubLeader(String subLeader) {
        this.subLeader = subLeader;
    }

    @Basic
    @Column(name = "subPhone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getSubPhone() {
        return subPhone;
    }

    public void setSubPhone(String subPhone) {
        this.subPhone = subPhone;
    }

    @Basic
    @Column(name = "subMemo", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getSubMemo() {
        return subMemo;
    }

    public void setSubMemo(String subMemo) {
        this.subMemo = subMemo;
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
