package net.proselyte.springsecurityapp.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.proselyte.springsecurityapp.model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-06T18:00:34")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SingularAttribute<Role, String> name;
    public static volatile SingularAttribute<Role, Long> id;
    public static volatile SetAttribute<Role, User> users;

}