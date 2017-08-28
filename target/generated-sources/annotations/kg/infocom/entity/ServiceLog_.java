package kg.infocom.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-28T10:51:44")
@StaticMetamodel(ServiceLog.class)
public class ServiceLog_ { 

    public static volatile SingularAttribute<ServiceLog, Date> logDate;
    public static volatile SingularAttribute<ServiceLog, Long> logId;
    public static volatile SingularAttribute<ServiceLog, String> logUsername;
    public static volatile SingularAttribute<ServiceLog, String> logAction;

}