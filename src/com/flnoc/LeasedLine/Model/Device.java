package com.flnoc.LeasedLine.Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
@Entity
public class Device {
    private int deviceId;
    private String deviceName;
    private String deviceIp;
    private String deviceSnmpro;
    private String deviceSnmprw;
    private String deviceUserName;
    private String devicePassword;
    private String deviceEnablePassword;
    private String deviceType;
    private String deviceModel;
    private String deviceBras;
    private String deviceBrasport;
    private String deviceInternetVlan;
    private String deviceMemo;
    private CommRoom commRoomByCommRoomId;
    private Collection<Lline> llinesByDeviceId;

    @Id
    @Column(name = "deviceID", nullable = false, insertable = true, updatable = true)
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "deviceName", nullable = false, insertable = true, updatable = true, length = 50)
    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @Basic
    @Column(name = "deviceIP", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    @Basic
    @Column(name = "deviceSNMPRO", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDeviceSnmpro() {
        return deviceSnmpro;
    }

    public void setDeviceSnmpro(String deviceSnmpro) {
        this.deviceSnmpro = deviceSnmpro;
    }

    @Basic
    @Column(name = "deviceSNMPRW", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDeviceSnmprw() {
        return deviceSnmprw;
    }

    public void setDeviceSnmprw(String deviceSnmprw) {
        this.deviceSnmprw = deviceSnmprw;
    }

    @Basic
    @Column(name = "deviceUserName", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDeviceUserName() {
        return deviceUserName;
    }

    public void setDeviceUserName(String deviceUserName) {
        this.deviceUserName = deviceUserName;
    }

    @Basic
    @Column(name = "devicePassword", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    @Basic
    @Column(name = "deviceEnablePassword", nullable = true, insertable = true, updatable = true, length = 20)
    public String getDeviceEnablePassword() {
        return deviceEnablePassword;
    }

    public void setDeviceEnablePassword(String deviceEnablePassword) {
        this.deviceEnablePassword = deviceEnablePassword;
    }

    @Basic
    @Column(name = "deviceType", nullable = false, insertable = true, updatable = true, length = 10)
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @Basic
    @Column(name = "deviceModel", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    @Basic
    @Column(name = "deviceBRAS", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDeviceBras() {
        return deviceBras;
    }

    public void setDeviceBras(String deviceBras) {
        this.deviceBras = deviceBras;
    }

    @Basic
    @Column(name = "deviceBRASPORT", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDeviceBrasport() {
        return deviceBrasport;
    }

    public void setDeviceBrasport(String deviceBrasport) {
        this.deviceBrasport = deviceBrasport;
    }

    @Basic
    @Column(name = "deviceInternetVLAN", nullable = true, insertable = true, updatable = true, length = 4)
    public String getDeviceInternetVlan() {
        return deviceInternetVlan;
    }

    public void setDeviceInternetVlan(String deviceInternetVlan) {
        this.deviceInternetVlan = deviceInternetVlan;
    }

    @Basic
    @Column(name = "deviceMemo", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getDeviceMemo() {
        return deviceMemo;
    }

    public void setDeviceMemo(String deviceMemo) {
        this.deviceMemo = deviceMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (deviceId != device.deviceId) return false;
        if (deviceBras != null ? !deviceBras.equals(device.deviceBras) : device.deviceBras != null) return false;
        if (deviceBrasport != null ? !deviceBrasport.equals(device.deviceBrasport) : device.deviceBrasport != null)
            return false;
        if (deviceEnablePassword != null ? !deviceEnablePassword.equals(device.deviceEnablePassword) : device.deviceEnablePassword != null)
            return false;
        if (deviceInternetVlan != null ? !deviceInternetVlan.equals(device.deviceInternetVlan) : device.deviceInternetVlan != null)
            return false;
        if (deviceIp != null ? !deviceIp.equals(device.deviceIp) : device.deviceIp != null) return false;
        if (deviceMemo != null ? !deviceMemo.equals(device.deviceMemo) : device.deviceMemo != null) return false;
        if (deviceModel != null ? !deviceModel.equals(device.deviceModel) : device.deviceModel != null) return false;
        if (deviceName != null ? !deviceName.equals(device.deviceName) : device.deviceName != null) return false;
        if (devicePassword != null ? !devicePassword.equals(device.devicePassword) : device.devicePassword != null)
            return false;
        if (deviceSnmpro != null ? !deviceSnmpro.equals(device.deviceSnmpro) : device.deviceSnmpro != null)
            return false;
        if (deviceSnmprw != null ? !deviceSnmprw.equals(device.deviceSnmprw) : device.deviceSnmprw != null)
            return false;
        if (deviceType != null ? !deviceType.equals(device.deviceType) : device.deviceType != null) return false;
        if (deviceUserName != null ? !deviceUserName.equals(device.deviceUserName) : device.deviceUserName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deviceId;
        result = 31 * result + (deviceName != null ? deviceName.hashCode() : 0);
        result = 31 * result + (deviceIp != null ? deviceIp.hashCode() : 0);
        result = 31 * result + (deviceSnmpro != null ? deviceSnmpro.hashCode() : 0);
        result = 31 * result + (deviceSnmprw != null ? deviceSnmprw.hashCode() : 0);
        result = 31 * result + (deviceUserName != null ? deviceUserName.hashCode() : 0);
        result = 31 * result + (devicePassword != null ? devicePassword.hashCode() : 0);
        result = 31 * result + (deviceEnablePassword != null ? deviceEnablePassword.hashCode() : 0);
        result = 31 * result + (deviceType != null ? deviceType.hashCode() : 0);
        result = 31 * result + (deviceModel != null ? deviceModel.hashCode() : 0);
        result = 31 * result + (deviceBras != null ? deviceBras.hashCode() : 0);
        result = 31 * result + (deviceBrasport != null ? deviceBrasport.hashCode() : 0);
        result = 31 * result + (deviceInternetVlan != null ? deviceInternetVlan.hashCode() : 0);
        result = 31 * result + (deviceMemo != null ? deviceMemo.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "commRoomID", referencedColumnName = "commRoomID", nullable = false)
    public CommRoom getCommRoomByCommRoomId() {
        return commRoomByCommRoomId;
    }

    public void setCommRoomByCommRoomId(CommRoom commRoomByCommRoomId) {
        this.commRoomByCommRoomId = commRoomByCommRoomId;
    }

    @OneToMany(mappedBy = "deviceByDeviceId")
    public Collection<Lline> getLlinesByDeviceId() {
        return llinesByDeviceId;
    }

    public void setLlinesByDeviceId(Collection<Lline> llinesByDeviceId) {
        this.llinesByDeviceId = llinesByDeviceId;
    }
}
