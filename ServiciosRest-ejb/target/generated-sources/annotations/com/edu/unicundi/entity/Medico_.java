package com.edu.unicundi.entity;

import com.edu.unicundi.entity.Direccion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-04-24T14:43:23")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, Date> fechaNacimiento;
    public static volatile SingularAttribute<Medico, String> apellido;
    public static volatile SingularAttribute<Medico, String> correo;
    public static volatile SingularAttribute<Medico, Direccion> direccion;
    public static volatile SingularAttribute<Medico, Integer> id;
    public static volatile SingularAttribute<Medico, String> nombre;

}