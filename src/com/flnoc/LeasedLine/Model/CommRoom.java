package com.flnoc.LeasedLine.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
@Entity
public class CommRoom {
    private int commRoomId;
    private String commRoomName;
    private String commRoomAddress;
    private String commRoomContact;
    private String commRoomPhone;
    private String commRoomMemo;
    private SubStation subStationBySubId;
    private Collection<Device> devicesByCommRoomId;

    @Id
    @Column(name = "commRoomID", nullable = false, insertable = true, updatable = true)
    public int getCommRoomId() {
        return commRoomId;
    }

    public void setCommRoomId(int commRoomId) {
        this.commRoomId = commRoomId;
    }

    @Basic
    @Column(name = "commRoomName", nullable = false, insertable = true, updatable = true, length = 50)
    public String getCommRoomName() {
        return commRoomName;
    }

    public void setCommRoomName(String commRoomName) {
        this.commRoomName = commRoomName;
    }

    @Basic
    @Column(name = "commRoomAddress", nullable = true, insertable = true, updatable = true, length = 100)
    public String getCommRoomAddress() {
        return commRoomAddress;
    }

    public void setCommRoomAddress(String commRoomAddress) {
        this.commRoomAddress = commRoomAddress;
    }

    @Basic
    @Column(name = "commRoomContact", nullable = true, insertable = true, updatable = true, length = 10)
    public String getCommRoomContact() {
        return commRoomContact;
    }

    public void setCommRoomContact(String commRoomContact) {
        this.commRoomContact = commRoomContact;
    }

    @Basic
    @Column(name = "commRoomPhone", nullable = true, insertable = true, updatable = true, length = 15)
    public String getCommRoomPhone() {
        return commRoomPhone;
    }

    public void setCommRoomPhone(String commRoomPhone) {
        this.commRoomPhone = commRoomPhone;
    }

    @Basic
    @Column(name = "commRoomMemo", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getCommRoomMemo() {
        return commRoomMemo;
    }

    public void setCommRoomMemo(String commRoomMemo) {
        this.commRoomMemo = commRoomMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommRoom commRoom = (CommRoom) o;

        if (commRoomId != commRoom.commRoomId) return false;
        if (commRoomAddress != null ? !commRoomAddress.equals(commRoom.commRoomAddress) : commRoom.commRoomAddress != null)
            return false;
        if (commRoomContact != null ? !commRoomContact.equals(commRoom.commRoomContact) : commRoom.commRoomContact != null)
            return false;
        if (commRoomMemo != null ? !commRoomMemo.equals(commRoom.commRoomMemo) : commRoom.commRoomMemo != null)
            return false;
        if (commRoomName != null ? !commRoomName.equals(commRoom.commRoomName) : commRoom.commRoomName != null)
            return false;
        if (commRoomPhone != null ? !commRoomPhone.equals(commRoom.commRoomPhone) : commRoom.commRoomPhone != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commRoomId;
        result = 31 * result + (commRoomName != null ? commRoomName.hashCode() : 0);
        result = 31 * result + (commRoomAddress != null ? commRoomAddress.hashCode() : 0);
        result = 31 * result + (commRoomContact != null ? commRoomContact.hashCode() : 0);
        result = 31 * result + (commRoomPhone != null ? commRoomPhone.hashCode() : 0);
        result = 31 * result + (commRoomMemo != null ? commRoomMemo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "subID", referencedColumnName = "subID", nullable = false)
    public SubStation getSubStationBySubId() {
        return subStationBySubId;
    }

    public void setSubStationBySubId(SubStation subStationBySubId) {
        this.subStationBySubId = subStationBySubId;
    }

    @OneToMany(mappedBy = "commRoomByCommRoomId")
    public Collection<Device> getDevicesByCommRoomId() {
        return devicesByCommRoomId;
    }

    public void setDevicesByCommRoomId(Collection<Device> devicesByCommRoomId) {
        this.devicesByCommRoomId = devicesByCommRoomId;
    }
}
