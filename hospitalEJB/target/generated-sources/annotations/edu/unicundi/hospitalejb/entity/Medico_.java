package edu.unicundi.hospitalejb.entity;

import edu.unicundi.hospitalejb.entity.Consulta;
import edu.unicundi.hospitalejb.entity.Direccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-04T23:06:37")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, Date> fechaNacimiento;
    public static volatile SingularAttribute<Medico, String> apellido;
    public static volatile SingularAttribute<Medico, String> correo;
    public static volatile SingularAttribute<Medico, Direccion> direccion;
    public static volatile ListAttribute<Medico, Consulta> consultas;
    public static volatile SingularAttribute<Medico, Integer> id;
    public static volatile SingularAttribute<Medico, String> nombre;

}