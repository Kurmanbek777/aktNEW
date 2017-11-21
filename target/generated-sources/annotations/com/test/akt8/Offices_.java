package com.test.akt8;

import com.test.akt8.Departments;
import com.test.akt8.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-21T22:02:57")
@StaticMetamodel(Offices.class)
public class Offices_ { 

    public static volatile SingularAttribute<Offices, Date> createdat;
    public static volatile SingularAttribute<Offices, String> officename;
    public static volatile SingularAttribute<Offices, Integer> id;
    public static volatile CollectionAttribute<Offices, Departments> departmentsCollection;
    public static volatile SingularAttribute<Offices, Users> userid;
    public static volatile SingularAttribute<Offices, Date> updatedat;

}