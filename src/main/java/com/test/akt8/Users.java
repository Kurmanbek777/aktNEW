/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.akt8;

import static com.test.akt8.PasswordEncryptionService.hashPassword;



import java.io.Serializable;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import static net.proselyte.springsecurityapp.model.User_.password;
import java.io.*;
import java.util.*;


/**
 *
 * @author User
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
    , @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findBySalt", query = "SELECT u FROM Users u WHERE u.salt = :salt")})
public class Users extends PasswordEncryptionService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "password")
    private String password;
    @Column(name = "salt")
    private String salt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Transfer> transferCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Offices> officesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Inventoryhelper> inventoryhelperCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Departments> departmentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Employees> employeesCollection;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users  (Integer id, String login, String password, String salt) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.salt = salt;
        
    //PasswordEncryptionService hashing; // не правильно
      //  hashing = new PasswordEncryptionService(); // не правильно
    //PasswordEncryptionService.hashPassword(password, salt); //вызов метода
    //PasswordEncryptionService hashing = new PasswordEncryptionService();
  //  hashing.toHex(hashedPassword) =password;
    password=PasswordEncryptionService.hashPassword(password, salt);
    salt=PasswordEncryptionService.generateSalt();
     System.out.println ("salt" + salt);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //  public static void main(String[] args) { 
      //  System.out.println("Wrong"); 
    //} 
    
    
    public String getPassword() {
        
       return password;
    }

    public void setPassword(String password) {
       
        this.password = password;
    }
 public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    @XmlTransient
    public Collection<Transfer> getTransferCollection() {
        return transferCollection;
    }

    public void setTransferCollection(Collection<Transfer> transferCollection) {
        this.transferCollection = transferCollection;
    }

    @XmlTransient
    public Collection<Offices> getOfficesCollection() {
        return officesCollection;
    }

    public void setOfficesCollection(Collection<Offices> officesCollection) {
        this.officesCollection = officesCollection;
    }

    @XmlTransient
    public Collection<Inventoryhelper> getInventoryhelperCollection() {
        return inventoryhelperCollection;
    }

    public void setInventoryhelperCollection(Collection<Inventoryhelper> inventoryhelperCollection) {
        this.inventoryhelperCollection = inventoryhelperCollection;
    }

    @XmlTransient
    public Collection<Departments> getDepartmentsCollection() {
        return departmentsCollection;
    }

    public void setDepartmentsCollection(Collection<Departments> departmentsCollection) {
        this.departmentsCollection = departmentsCollection;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  login;
    }
   

    
}
