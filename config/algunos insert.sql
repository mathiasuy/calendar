use Peluqueria;
insert into Proveedores (nombre,descripcion,direccion,habilitado) VALUES
("Conaprole","Cooperativa lechera","Magallanes 123",TRUE);
insert into Proveedores (nombre,descripcion,direccion,habilitado) VALUES
("Calcar","Cooperativa lechera de colonia","calle 123",TRUE);
insert into Descuentos (nombre,es_por_convenio,descripcion,porcentaje,dias,fecha_de_expiracion,habilitado) VALUES
("Descuento 1",true,"es el descuento 1",5,"0100000","2018/12/12",TRUE);
insert into Descuentos (nombre,es_por_convenio,descripcion,porcentaje,dias,fecha_de_expiracion,habilitado) VALUES
("Descuento 2",true,"es el descuento 2",8,"0100100","2018/12/20",TRUE);
insert into Productos (nombre,marca,precio,descripcion,proveedorID,habilitado)VALUES
("leche","Conaprole",20,"leche descremada",1,TRUE);
insert into Productos (nombre,marca,precio,descripcion,proveedorID,habilitado)VALUES
("leche","Calcar",20,"leche descremada",2,TRUE);
insert into Productos (nombre,marca,precio,descripcion,proveedorID,habilitado)VALUES
("Pudding Conamigos","Conaprole",20,"Postre Pudding Conamigos",1,TRUE);
insert into Servicios (nombre,duracion,descripcion,precio,habilitado) VALUES
("Envío",10,"Envío directo al hogar",150,TRUE);
insert into Servicios (nombre,duracion,descripcion,precio,habilitado) VALUES
("Cubiertos",50,"Mesa",30,TRUE);
insert into DescuentosProductos (descuentoID, productoID) VALUES
(1,1);
insert into DescuentosProductos (descuentoID, productoID) VALUES
(2,1);
insert into DescuentosProductos (descuentoID, productoID) VALUES
(2,3);
insert into ServiciosProductos (servicioID, productoID) VALUES
(1,1);
insert into ServiciosProductos (servicioID, productoID) VALUES
(1,2);
insert into ServiciosProductos (servicioID, productoID) VALUES
(2,3);
INSERT INTO DescuentosServicios VALUES (1,1);
INSERT INTO DescuentosServicios VALUES (1,2);
INSERT INTO DescuentosServicios VALUES (2,2);

call AltaEmpleado("Juan","126780","2012/12/12","cometnario","12120994","juan","pass",true,"2012/12/12",12000,@exito);
call AltaEmpleado("Ramiro","127678","2012/12/12","cometnario","12120994","Ramis","pass",true,"2012/12/12",12000,@exito);
call AltaEmpleado("Ramiro","129678","2012/12/12","cometnario","12120994","Ramis2","asd",true,"2012/12/12",12000,@exito);
call AltaCliente("Marcos","123485678","2012/12/12","cometnario","12120994","marc1","pass",true,1,@exito);
call AltaCliente("Andres","126578","2012/12/12","cometnario","12120994",NULL,"pass",true,1,@exito);
call AltaCliente("Andres","142678","2012/12/12","cometnario","12120994",NULL,NULL,true,1,@exito);
call BajaCliente(6,@exito); -- falla si el usuario es null, por la cascada (CORREGIDO)
call bajaEmpleado(4,@exito); -- falla si el usuario es null, por la cascada (CORREGIDO)
call BajaCliente(2,@exito);
call bajaEmpleado(5,@exito);
call ModificarCliente(4,"Anderes modificado","1231","2013/12/12","comentario modificado","1212","marc3","pass2",true,1,@exito);
call ModificarEmpleado(1,"Juan modificado","1231","2013/12/12","comentario modificado","1212","juan2","pass3",true,"2012/12/12",13000,@exito);
call listarClientes();
call listarEmpleados();
SELECT * FROM Personas inner join Empleados ON Personas.personaID = Empleados.empleadoID;
SELECT * FROM Personas inner join Clientes ON Personas.personaID = Clientes.clienteID;
call Login("marc3","pass2",@tipo);
SELECT @tipo;
call Login("MARc3","pass2",@tipo);
SELECT @tipo;
call Login("juan","pass",@tipo);
SELECT @tipo;
call listarDescuentosXProducto(1,1,1);
call filtroMostrarServiciosProductos("%env%");

SELECT tieneClienteConvenioEnServicio(4,1);
call listarDescuentosXProducto(1,1,1);
SELECT * FROM Clientes;

    -- SELECT * FROM Clientes;-- 4-6
    -- SELECT  * FROM Empleados; -- 1-3

    INSERT INTO Citas(clienteID,empleadoID,descripcion,fecha_de_cita,concretada) 
    VALUES 
    (4,1,"cita descripcion 1",now(),FALSE),
    (5,2,"cita descripcion 2",now(),TRUE),
    (5,1,"cita descripcion 2",now(),FALSE);

insert into itemsCitas (citaID, descuentoID, duracion, precio, servicioID)    
values 
(1, 1, 1211,808,1 ),
(2, 2, 111,778,1 ),
(3, 2, 11,781,2 ),
(3, NULL, 541,78,2),
(3, NULL, 110,78,2 ),
(3, 1, 1,78,1 ),
(1, NULL, 51,78,1 ),
(1, 1, 81,718,2 );
    
	SELECT agregarServicioACitaAutoDescuento(2,1);
    SELECT agregarServicioACitaAutoDescuento(1,1);
    SELECT agregarServicioACitaAutoDescuento(2,1);
call listarItemsXCita(1);
call listarItemsXCita(2);
SELECT * FROM Servicios;
select * from citas;
SELECT agregarServicioACitaAutoDescuento(2,2);
SELECT quitarServicioACita(2,2);
-- SELECT agregarServicioACitaAutoDescuento(1,1);
-- SELECT agregarServicioACitaAutoDescuento(1,2); 
select tieneClienteConvenioEnServicio(4,2);
select tieneClienteConvenioEnProducto(4,1);   
call listarCitasEntre("2016/12/23","2017/12/23");
call altaCliente ("Maria2","123123a","2012/12/12","ad c","1234545","mari2","pas",true,null,@tipo);
select @tipo;
select * from citas inner join ItemsCitas on Citas.citaID = ItemsCitas.citaID;
call listarCitasDelDia("2016/12/23");
-- call bajaempleado("12678");
-- select *  from personas;
-- call bajaCliente("12678");
-- select *  from personas;


INSERT INTO CitasSimples (cliente,empleado,descripcion,fecha_de_cita,precio)
VALUES ("Ilda", "Esteban","lavado y brushing","2017-01-17/ 15:00:00",800),
("Karen", "Rubén","lavado y brushing","2017-01-17 16:00:00",600),
("Mirta", "Rogelio","brushing","2017-01-17 16:30:00",500),
("Claudia", "Susana","brushing progresivo","2017-01-18 8:00:00",1000),
("Marcos", "Esteban","corte y color","2017-01-18 9:00:00",750),
("Andres", "María","coloración","2017-01-18 9:30:00",250),
("Juan", "María","depilación","2017-01-19 15:00:00",400),
("JAckita", "María","manos","2017-01-20 16:00:00",1200),
("Rómulo", "Joel","moño","2017-01-20 16:30:00",500),
("Rómulo", "Esteban","color lavado y brushing","2017-01-20 18:00:00",550),
("Raquel", "Susana","uñas de acrílico","2017-01-21 15:00:00",660),
("Roberto", "Rogelio","lavado","2017-01-21 8:00:00",804),
("Ricardo", "Rubén","bozo","2017-01-21 18:00:00",505)
;
UPDATE  CitasSimples SET  fecha_de_cita="2017-01-18T12:30:00" WHERE citaSimpleID=1;

SELECT * FROM CitasSimples