package edu.unicundi.hospitalejb.entity;

import edu.unicundi.hospitalejb.entity.DetalleConsulta;
import edu.unicundi.hospitalejb.entity.Medico;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-04T23:06:37")
@StaticMetamodel(Consulta.class)
public class Consulta_ { 

    public static volatile SingularAttribute<Consulta, Date> fecha;
    public static volatile ListAttribute<Consulta, DetalleConsulta> detalleConsulta;
    public static volatile SingularAttribute<Consulta, String> nombreMedico;
    public static volatile SingularAttribute<Consulta, Medico> medico;
    public static volatile SingularAttribute<Consulta, Integer> id;

}