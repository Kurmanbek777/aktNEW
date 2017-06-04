/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transfer.findAll", query = "SELECT t FROM Transfer t")
    , @NamedQuery(name = "Transfer.findById", query = "SELECT t FROM Transfer t WHERE t.id = :id")
    , @NamedQuery(name = "Transfer.findByActnumber", query = "SELECT t FROM Transfer t WHERE t.actnumber = :actnumber")
    , @NamedQuery(name = "Transfer.findByDateofact", query = "SELECT t FROM Transfer t WHERE t.dateofact = :dateofact")
    , @NamedQuery(name = "Transfer.findByInventorycount", query = "SELECT t FROM Transfer t WHERE t.inventorycount = :inventorycount")
    , @NamedQuery(name = "Transfer.findByCreatedat", query = "SELECT t FROM Transfer t WHERE t.createdat = :createdat")
    , @NamedQuery(name = "Transfer.findByUpdatedat", query = "SELECT t FROM Transfer t WHERE t.updatedat = :updatedat")})
public class Transfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actnumber")
    private int actnumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateofact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventorycount")
    private int inventorycount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @JoinColumn(name = "empfrom", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employees empfrom;
    @JoinColumn(name = "empto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employees empto;
    @JoinColumn(name = "inventoryid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Inventoryhelper inventoryid;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userid;

    public Transfer() {
    }

    public Transfer(Integer id) {
        this.id = id;
    }

    public Transfer(Integer id, int actnumber, Date dateofact, int inventorycount, Date createdat, Date updatedat) {
        this.id = id;
        this.actnumber = actnumber;
        this.dateofact = dateofact;
        this.inventorycount = inventorycount;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getActnumber() {
        return actnumber;
    }

    public void setActnumber(int actnumber) {
        this.actnumber = actnumber;
    }

    public Date getDateofact() {
        Date dateofact= new Date();
        return dateofact;
    }

    public void setDateofact(Date dateofact) {
        this.dateofact = dateofact;
    }

    public int getInventorycount() {
        return inventorycount;
    }

    public void setInventorycount(int inventorycount) {
        this.inventorycount = inventorycount;
    }

    public Date getCreatedat() {
        Date createdat= new Date();
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        Date updatedat= new Date();
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Employees getEmpfrom() {
        return empfrom;
    }

    public void setEmpfrom(Employees empfrom) {
        this.empfrom = empfrom;
    }

    public Employees getEmpto() {
        return empto;
    }

    public void setEmpto(Employees empto) {
        this.empto = empto;
    }

    public Inventoryhelper getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(Inventoryhelper inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transfer)) {
            return false;
        }
        Transfer other = (Transfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.test.akt8.Transfer[ id=" + id + " ]";
    }
    
}
