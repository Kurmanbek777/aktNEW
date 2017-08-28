package kg.infocom.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T10:51:44")
@StaticMetamodel(ServiceUsers.class)
public class ServiceUsers_ { 

    public static volatile SingularAttribute<ServiceUsers, String> userLogin;
    public static volatile SingularAttribute<ServiceUsers, String> userPassword;
    public static volatile SingularAttribute<ServiceUsers, Date> userAdddate;
    public static volatile SingularAttribute<ServiceUsers, String> userFio;
    public static volatile SingularAttribute<ServiceUsers, String> userRole;
    public static volatile SingularAttribute<ServiceUsers, Long> userId;

}