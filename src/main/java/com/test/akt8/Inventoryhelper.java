/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "inventoryhelper")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventoryhelper.findAll", query = "SELECT i FROM Inventoryhelper i")
    , @NamedQuery(name = "Inventoryhelper.findById", query = "SELECT i FROM Inventoryhelper i WHERE i.id = :id")
    , @NamedQuery(name = "Inventoryhelper.findByInventoryname", query = "SELECT i FROM Inventoryhelper i WHERE i.inventoryname = :inventoryname")
    , @NamedQuery(name = "Inventoryhelper.findByInventorynumber", query = "SELECT i FROM Inventoryhelper i WHERE i.inventorynumber = :inventorynumber")
    , @NamedQuery(name = "Inventoryhelper.findByDescription", query = "SELECT i FROM Inventoryhelper i WHERE i.description = :description")
    , @NamedQuery(name = "Inventoryhelper.findByCreatedat", query = "SELECT i FROM Inventoryhelper i WHERE i.createdat = :createdat")
    , @NamedQuery(name = "Inventoryhelper.findByUpdatedat", query = "SELECT i FROM Inventoryhelper i WHERE i.updatedat = :updatedat")})
public class Inventoryhelper implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "inventoryname")
    private String inventoryname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "inventorynumber")
    private String inventorynumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryid")
    private Collection<Transfer> transferCollection;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userid;

    public Inventoryhelper() {
    }

    public Inventoryhelper(Integer id) {
        this.id = id;
    }

    public Inventoryhelper(Integer id, String inventoryname, String inventorynumber, String description, Date createdat, Date updatedat) {
        this.id = id;
        this.inventoryname = inventoryname;
        this.inventorynumber = inventorynumber;
        this.description = description;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInventoryname() {
        return inventoryname;
    }

    public void setInventoryname(String inventoryname) {
        this.inventoryname = inventoryname;
    }

    public String getInventorynumber() {
        return inventorynumber;
    }

    public void setInventorynumber(String inventorynumber) {
        this.inventorynumber = inventorynumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedat() {
      //  Date createdat= new Date();
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
       // Date updatedat= new Date();
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    @XmlTransient
    public Collection<Transfer> getTransferCollection() {
        return transferCollection;
    }

    public void setTransferCollection(Collection<Transfer> transferCollection) {
        this.transferCollection = transferCollection;
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
        if (!(object instanceof Inventoryhelper)) {
            return false;
        }
        Inventoryhelper other = (Inventoryhelper) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return inventoryname;
    }
    
}
