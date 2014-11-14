package com.flnoc.LeasedLine.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
@Entity
public class Vpn {
    private int vpnID;
    private StringProperty vpnName;
    private StringProperty vpnMainNumber;
    private StringProperty vpnMemo;
    private Collection<Lline> llinesByVpnid;

    public Vpn() {
        this.vpnName = new SimpleStringProperty();
        this.vpnMainNumber = new SimpleStringProperty();
        this.vpnMemo = new SimpleStringProperty();
    }

    @Id
    @Column(name = "VPNID", nullable = false, insertable = true, updatable = true)
    public int getVpnid() {
        return vpnID;
    }

    public void setVpnid(int vpnid) {
        this.vpnID = vpnid;
    }

    @Basic
    @Column(name = "VPNName", nullable = false, insertable = true, updatable = true, length = 100)
    public String getVpnName() {
        return vpnName.get();
    }

    public void setVpnName(String vpnName) {
        this.vpnName.set(vpnName);
    }

    public StringProperty vpnNameProperty(){
        return vpnName;
    }

    @Basic
    @Column(name = "VPNMainNumber", nullable = false, insertable = true, updatable = true, length = 20)
    public String getVpnMainNumber() {
        return vpnMainNumber.get();
    }

    public void setVpnMainNumber(String vpnMainNumber) {
        this.vpnMainNumber.set(vpnMainNumber);
    }

    public StringProperty vpnMainNumberProperty(){
        return vpnMainNumber;
    }

    @Basic
    @Column(name = "VPNMemo", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getVpnMemo() {
        return vpnMemo.get();
    }

    public void setVpnMemo(String vpnMemo) {
        this.vpnMemo.set(vpnMemo);
    }

    public StringProperty vpnMemoProperty(){
        return vpnMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vpn vpn = (Vpn) o;

        if (vpnID != vpn.vpnID) return false;
        if (vpnMainNumber != null ? !vpnMainNumber.equals(vpn.vpnMainNumber) : vpn.vpnMainNumber != null) return false;
        if (vpnMemo != null ? !vpnMemo.equals(vpn.vpnMemo) : vpn.vpnMemo != null) return false;
        if (vpnName != null ? !vpnName.equals(vpn.vpnName) : vpn.vpnName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vpnID;
        result = 31 * result + (vpnName != null ? vpnName.hashCode() : 0);
        result = 31 * result + (vpnMainNumber != null ? vpnMainNumber.hashCode() : 0);
        result = 31 * result + (vpnMemo != null ? vpnMemo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "vpnByVpnId")
    public Collection<Lline> getLlinesByVpnid() {
        return llinesByVpnid;
    }

    public void setLlinesByVpnid(Collection<Lline> llinesByVpnid) {
        this.llinesByVpnid = llinesByVpnid;
    }
}
