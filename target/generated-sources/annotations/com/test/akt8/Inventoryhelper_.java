package com.test.akt8;

import com.test.akt8.Transfer;
import com.test.akt8.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-21T22:02:57")
@StaticMetamodel(Inventoryhelper.class)
public class Inventoryhelper_ { 

    public static volatile SingularAttribute<Inventoryhelper, Date> createdat;
    public static volatile SingularAttribute<Inventoryhelper, String> inventoryname;
    public static volatile SingularAttribute<Inventoryhelper, String> description;
    public static volatile SingularAttribute<Inventoryhelper, String> inventorynumber;
    public static volatile SingularAttribute<Inventoryhelper, Integer> id;
    public static volatile SingularAttribute<Inventoryhelper, Users> userid;
    public static volatile CollectionAttribute<Inventoryhelper, Transfer> transferCollection;
    public static volatile SingularAttribute<Inventoryhelper, Date> updatedat;

}