/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Calendar;
import static java.util.concurrent.ThreadLocalRandom.current;
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
@Table(name = "offices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offices.findAll", query = "SELECT o FROM Offices o")
    , @NamedQuery(name = "Offices.findById", query = "SELECT o FROM Offices o WHERE o.id = :id")
    , @NamedQuery(name = "Offices.findByOfficename", query = "SELECT o FROM Offices o WHERE o.officename = :officename")
    , @NamedQuery(name = "Offices.findByCreatedat", query = "SELECT o FROM Offices o WHERE o.createdat = :createdat")
    , @NamedQuery(name = "Offices.findByUpdatedat", query = "SELECT o FROM Offices o WHERE o.updatedat = :updatedat")})
public class Offices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "officename")
    private String officename;
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
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Users userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "officeid")
    private Collection<Departments> departmentsCollection;

    public Offices() {
    }

    public Offices(Integer id) {
        this.id = id;
    }

    public Offices(Integer id, String officename, Date createdat, Date updatedat) {
        this.id = id;
        this.officename = officename;
        this.createdat = createdat;
        this.updatedat = updatedat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename;
    }

   // public String getCreatedat(){
     //   SimpleDateFormat createdat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
       // Date current = new Date();
       // return  createdat == null ? "" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current);
       
        //return createdat.format(current);
//}

    
    
       public Date getCreatedat(){
        //Date createdat = new java.util.Date();
       // return  createdat == null ? "" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current);
       
      return createdat;
}


    public void setCreatedat(Date createdat) {
        
        this.createdat = createdat;
    }

  // public String getUpdatedat() {
    //   SimpleDateFormat updatedat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
      //  Date current = new Date();
    //    //return updatedat == null ? "" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current);
      // return updatedat.format(current);
    //}

      public Date getUpdatedat(){
       // Date updatedat = new java.util.Date();
       // return  createdat == null ? "" : new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(current);
       
        return updatedat;
}
    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @XmlTransient
    public Collection<Departments> getDepartmentsCollection() {
        return departmentsCollection;
    }

    public void setDepartmentsCollection(Collection<Departments> departmentsCollection) {
        this.departmentsCollection = departmentsCollection;
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
        if (!(object instanceof Offices)) {
            return false;
        }
        Offices other = (Offices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return officename;
        
    }
    
}
