package com.test.akt8;

import com.test.akt8.Departments;
import com.test.akt8.Employees;
import com.test.akt8.Inventoryhelper;
import com.test.akt8.Offices;
import com.test.akt8.Transfer;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-21T22:02:57")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile CollectionAttribute<Users, Employees> employeesCollection;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> salt;
    public static volatile CollectionAttribute<Users, Offices> officesCollection;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile CollectionAttribute<Users, Departments> departmentsCollection;
    public static volatile SingularAttribute<Users, String> login;
    public static volatile CollectionAttribute<Users, Transfer> transferCollection;
    public static volatile CollectionAttribute<Users, Inventoryhelper> inventoryhelperCollection;

}