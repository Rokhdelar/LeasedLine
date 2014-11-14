package com.flnoc.LeasedLine.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Rokhdelar on 2014-11-14.
 */
@Entity
public class Lline {
    private int llineId;
    private String llineNumber;
    private String llineName;
    private String llineOpticalNumber;
    private String llinePhyPort;
    private String llineSubPort;
    private int llineOutVlan;
    private Integer llineInVlan;
    private String llineIp;
    private String llineMask;
    private String llineGateway;
    private String llineBandwidth;
    private String llineAddress;
    private String llineOdf;
    private String llineContact;
    private String llinePhone;
    private String llineLineNumber;
    private String llineMemo;
    private Customer customerByCustomerId;
    private Device deviceByDeviceId;
    private Vpn vpnByVpnId;

    @Id
    @Column(name = "llineID", nullable = false, insertable = true, updatable = true)
    public int getLlineId() {
        return llineId;
    }

    public void setLlineId(int llineId) {
        this.llineId = llineId;
    }

    @Basic
    @Column(name = "llineNumber", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLlineNumber() {
        return llineNumber;
    }

    public void setLlineNumber(String llineNumber) {
        this.llineNumber = llineNumber;
    }

    @Basic
    @Column(name = "llineName", nullable = false, insertable = true, updatable = true, length = 200)
    public String getLlineName() {
        return llineName;
    }

    public void setLlineName(String llineName) {
        this.llineName = llineName;
    }

    @Basic
    @Column(name = "llineOpticalNumber", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLlineOpticalNumber() {
        return llineOpticalNumber;
    }

    public void setLlineOpticalNumber(String llineOpticalNumber) {
        this.llineOpticalNumber = llineOpticalNumber;
    }

    @Basic
    @Column(name = "llinePhyPort", nullable = false, insertable = true, updatable = true, length = 20)
    public String getLlinePhyPort() {
        return llinePhyPort;
    }

    public void setLlinePhyPort(String llinePhyPort) {
        this.llinePhyPort = llinePhyPort;
    }

    @Basic
    @Column(name = "llineSubPort", nullable = true, insertable = true, updatable = true, length = 10)
    public String getLlineSubPort() {
        return llineSubPort;
    }

    public void setLlineSubPort(String llineSubPort) {
        this.llineSubPort = llineSubPort;
    }

    @Basic
    @Column(name = "llineOutVLAN", nullable = false, insertable = true, updatable = true)
    public int getLlineOutVlan() {
        return llineOutVlan;
    }

    public void setLlineOutVlan(int llineOutVlan) {
        this.llineOutVlan = llineOutVlan;
    }

    @Basic
    @Column(name = "llineInVLAN", nullable = true, insertable = true, updatable = true)
    public Integer getLlineInVlan() {
        return llineInVlan;
    }

    public void setLlineInVlan(Integer llineInVlan) {
        this.llineInVlan = llineInVlan;
    }

    @Basic
    @Column(name = "llineIP", nullable = true, insertable = true, updatable = true, length = 45)
    public String getLlineIp() {
        return llineIp;
    }

    public void setLlineIp(String llineIp) {
        this.llineIp = llineIp;
    }

    @Basic
    @Column(name = "llineMask", nullable = true, insertable = true, updatable = true, length = 15)
    public String getLlineMask() {
        return llineMask;
    }

    public void setLlineMask(String llineMask) {
        this.llineMask = llineMask;
    }

    @Basic
    @Column(name = "llineGateway", nullable = true, insertable = true, updatable = true, length = 15)
    public String getLlineGateway() {
        return llineGateway;
    }

    public void setLlineGateway(String llineGateway) {
        this.llineGateway = llineGateway;
    }

    @Basic
    @Column(name = "llineBandwidth", nullable = false, insertable = true, updatable = true, length = 10)
    public String getLlineBandwidth() {
        return llineBandwidth;
    }

    public void setLlineBandwidth(String llineBandwidth) {
        this.llineBandwidth = llineBandwidth;
    }

    @Basic
    @Column(name = "llineAddress", nullable = true, insertable = true, updatable = true, length = 100)
    public String getLlineAddress() {
        return llineAddress;
    }

    public void setLlineAddress(String llineAddress) {
        this.llineAddress = llineAddress;
    }

    @Basic
    @Column(name = "llineODF", nullable = true, insertable = true, updatable = true, length = 30)
    public String getLlineOdf() {
        return llineOdf;
    }

    public void setLlineOdf(String llineOdf) {
        this.llineOdf = llineOdf;
    }

    @Basic
    @Column(name = "llineContact", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLlineContact() {
        return llineContact;
    }

    public void setLlineContact(String llineContact) {
        this.llineContact = llineContact;
    }

    @Basic
    @Column(name = "llinePhone", nullable = true, insertable = true, updatable = true, length = 20)
    public String getLlinePhone() {
        return llinePhone;
    }

    public void setLlinePhone(String llinePhone) {
        this.llinePhone = llinePhone;
    }

    @Basic
    @Column(name = "llineLineNumber", nullable = true, insertable = true, updatable = true, length = 30)
    public String getLlineLineNumber() {
        return llineLineNumber;
    }

    public void setLlineLineNumber(String llineLineNumber) {
        this.llineLineNumber = llineLineNumber;
    }

    @Basic
    @Column(name = "llineMemo", nullable = true, insertable = true, updatable = true, length = 16777215)
    public String getLlineMemo() {
        return llineMemo;
    }

    public void setLlineMemo(String llineMemo) {
        this.llineMemo = llineMemo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lline lline = (Lline) o;

        if (llineId != lline.llineId) return false;
        if (llineOutVlan != lline.llineOutVlan) return false;
        if (llineAddress != null ? !llineAddress.equals(lline.llineAddress) : lline.llineAddress != null) return false;
        if (llineBandwidth != null ? !llineBandwidth.equals(lline.llineBandwidth) : lline.llineBandwidth != null)
            return false;
        if (llineContact != null ? !llineContact.equals(lline.llineContact) : lline.llineContact != null) return false;
        if (llineGateway != null ? !llineGateway.equals(lline.llineGateway) : lline.llineGateway != null) return false;
        if (llineInVlan != null ? !llineInVlan.equals(lline.llineInVlan) : lline.llineInVlan != null) return false;
        if (llineIp != null ? !llineIp.equals(lline.llineIp) : lline.llineIp != null) return false;
        if (llineLineNumber != null ? !llineLineNumber.equals(lline.llineLineNumber) : lline.llineLineNumber != null)
            return false;
        if (llineMask != null ? !llineMask.equals(lline.llineMask) : lline.llineMask != null) return false;
        if (llineMemo != null ? !llineMemo.equals(lline.llineMemo) : lline.llineMemo != null) return false;
        if (llineName != null ? !llineName.equals(lline.llineName) : lline.llineName != null) return false;
        if (llineNumber != null ? !llineNumber.equals(lline.llineNumber) : lline.llineNumber != null) return false;
        if (llineOdf != null ? !llineOdf.equals(lline.llineOdf) : lline.llineOdf != null) return false;
        if (llineOpticalNumber != null ? !llineOpticalNumber.equals(lline.llineOpticalNumber) : lline.llineOpticalNumber != null)
            return false;
        if (llinePhone != null ? !llinePhone.equals(lline.llinePhone) : lline.llinePhone != null) return false;
        if (llinePhyPort != null ? !llinePhyPort.equals(lline.llinePhyPort) : lline.llinePhyPort != null) return false;
        if (llineSubPort != null ? !llineSubPort.equals(lline.llineSubPort) : lline.llineSubPort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = llineId;
        result = 31 * result + (llineNumber != null ? llineNumber.hashCode() : 0);
        result = 31 * result + (llineName != null ? llineName.hashCode() : 0);
        result = 31 * result + (llineOpticalNumber != null ? llineOpticalNumber.hashCode() : 0);
        result = 31 * result + (llinePhyPort != null ? llinePhyPort.hashCode() : 0);
        result = 31 * result + (llineSubPort != null ? llineSubPort.hashCode() : 0);
        result = 31 * result + llineOutVlan;
        result = 31 * result + (llineInVlan != null ? llineInVlan.hashCode() : 0);
        result = 31 * result + (llineIp != null ? llineIp.hashCode() : 0);
        result = 31 * result + (llineMask != null ? llineMask.hashCode() : 0);
        result = 31 * result + (llineGateway != null ? llineGateway.hashCode() : 0);
        result = 31 * result + (llineBandwidth != null ? llineBandwidth.hashCode() : 0);
        result = 31 * result + (llineAddress != null ? llineAddress.hashCode() : 0);
        result = 31 * result + (llineOdf != null ? llineOdf.hashCode() : 0);
        result = 31 * result + (llineContact != null ? llineContact.hashCode() : 0);
        result = 31 * result + (llinePhone != null ? llinePhone.hashCode() : 0);
        result = 31 * result + (llineLineNumber != null ? llineLineNumber.hashCode() : 0);
        result = 31 * result + (llineMemo != null ? llineMemo.hashCode() : 0);
        return result;
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public Device getDeviceByDeviceId() {
        return deviceByDeviceId;
    }

    public void setDeviceByDeviceId(Device deviceByDeviceId) {
        this.deviceByDeviceId = deviceByDeviceId;
    }

    public Vpn getVpnByVpnId() {
        return vpnByVpnId;
    }

    public void setVpnByVpnId(Vpn vpnByVpnId) {
        this.vpnByVpnId = vpnByVpnId;
    }
}
