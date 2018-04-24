DROP DATABASE IF EXISTS Peluqueria;
create database Peluqueria;

use Peluqueria;

CREATE TABLE Proveedores(
	proveedorID 	INT PRIMARY KEY AUTO_INCREMENT,
	nombre 			VARCHAR(30),
	descripcion 	VARCHAR(100),
	direccion 		VARCHAR(30)
);

CREATE TABLE TelefonosProveedores (
	id 				INT PRIMARY KEY AUTO_INCREMENT,
	proveedorID 	INT,
	nombre 			VARCHAR(30),
	telefono 		VARCHAR(15) UNIQUE,
	FOREIGN KEY (proveedorID) REFERENCES Proveedores(proveedorID)  on delete no action on update no action 
);	

CREATE TABLE Descuentos(
	descuentoID 	INT PRIMARY KEY AUTO_INCREMENT,
	nombre 			VARCHAR(30) UNIQUE,
	es_por_convenio BOOL,
	descripcion 	VARCHAR(100),
	porcentaje 		DOUBLE,
	dias 			VARCHAR(7),
	fecha_de_expiracion DATE
);

CREATE TABLE Servicios(
	servicioID 		INT PRIMARY KEY AUTO_INCREMENT,
	nombre 			VARCHAR(30) UNIQUE,
	duracion 		INT,
	descripcion 	VARCHAR(100),
	precio 			DOUBLE
    );

CREATE TABLE Productos(
	productoID 		INT PRIMARY KEY AUTO_INCREMENT,
	nombre 			VARCHAR(30),
	marca 			VARCHAR(30),
	precio 			DOUBLE,
	descripcion 	VARCHAR(100),
	proveedorID 	INT,
	descuentoID 	INT,
	stock INT,
	FOREIGN KEY (proveedorID) 	REFERENCES Proveedores(proveedorID),
	FOREIGN KEY (descuentoID) 	REFERENCES Descuentos(descuentoID) 
);

CREATE TABLE ServiciosProductos(
	servicioID INT,
    productoID INT,
	FOREIGN KEY (productoID ) 	REFERENCES Productos(productoID),
	FOREIGN KEY (servicioID ) 	REFERENCES Servicios(servicioID)
    
);

CREATE TABLE DescuentosServicios(
	servicioID 		INT,
	descuentoID 	INT,
	FOREIGN KEY (descuentoID ) 	REFERENCES Descuentos(descuentoID),
	FOREIGN KEY (servicioID ) 	REFERENCES Servicios(servicioID)
);

CREATE TABLE DescuentosProductos(
	productoID 		INT,
	descuentoID 	INT,
	FOREIGN KEY (descuentoID ) 	REFERENCES Descuentos(descuentoID),
	FOREIGN KEY (productoID ) 	REFERENCES Productos(productoID)
);

CREATE TABLE Usuarios(
	usuarioID 		VARCHAR(10) PRIMARY KEY,
    contrasena 		VARCHAR(15),
    fecha_registrado TIME
);

CREATE TABLE Personas(
	personaID 		INT PRIMARY KEY AUTO_INCREMENT,
	nombre 			VARCHAR(30),
	documento 		VARCHAR (15),
	fecha_de_nacimiento DATE,
	usuarioID 		VARCHAR(10),
    comentarios 	VARCHAR(100),
    telefono		VARCHAR(15),
	FOREIGN KEY (usuarioID) 	REFERENCES Usuarios(usuarioID) on delete cascade on update cascade
);

CREATE TABLE Empleados (
	empleadoID 		INT PRIMARY KEY,
    vencimiento_carnet_de_salud DATE,
    sueldo 			DOUBLE,
	FOREIGN KEY (empleadoID) 	REFERENCES Personas(personaID) on delete cascade on update cascade
);

CREATE TABLE Clientes(
	clienteID 		INT PRIMARY KEY,
    descuentoID 	INT,
	FOREIGN KEY (clienteID) 	REFERENCES Personas(personaID)  on delete cascade on update cascade,
	FOREIGN KEY (descuentoID) 	REFERENCES Descuentos(descuentoID) on delete NO ACTION on update NO ACTION
);

CREATE TABLE Cuponeras(
	cuponeraID 		INT PRIMARY KEY AUTO_INCREMENT,
	clienteID 		INT,
	descuento 		DOUBLE,
	fecha_de_inicio TIME,
	fecha_de_vencimiento DATE,
	FOREIGN KEY (clienteID) 	REFERENCES Clientes(clienteID)
);

CREATE TABLE Cupon(
	cuponeraID 		INT PRIMARY KEY AUTO_INCREMENT,
	servicioID 		INT,
	fecha_concretado DATE,
	FOREIGN KEY (cuponeraID) 	REFERENCES Cuponeras(cuponeraID),	
	FOREIGN KEY (servicioID) 	REFERENCES Servicios(servicioID)
);

CREATE TABLE Citas(
	citaID 		INT PRIMARY KEY AUTO_INCREMENT,
	clienteID 	INT,
	empleadoID 	INT,
	precio 		DOUBLE,
	descuentoID INT,
	descripcion VARCHAR(100),
	fecha_registrada TIME,
	fecha_de_cita DATE,
	concretada 	BOOL,
	FOREIGN KEY (clienteID) 	REFERENCES Clientes(clienteID),
	FOREIGN KEY (empleadoID) 	REFERENCES Empleados(empleadoID),
	FOREIGN KEY (descuentoID) 	REFERENCES Descuentos(descuentoID)
);

CREATE TABLE ServiciosCitas(
	citaID INT,
    servicioID INT,
	FOREIGN KEY (citaID) 		REFERENCES Citas(citaID),
	FOREIGN KEY (servicioID) 	REFERENCES Servicios(servicioID)    
);

-----------------------------------
-- PROCEDIMIENTOS PARA EMPLEADOS --
-----------------------------------

DROP PROCEDURE IF EXISTS AltaEmpleado; 
DELIMITER //
CREATE PROCEDURE AltaEmpleado 
(IN innombre VARCHAR(30),IN indocumento VARCHAR(15),IN infecha_de_nacimiento DATE,
IN inusuarioID VARCHAR(10), IN incontrasena VARCHAR(15),IN incomentarios VARCHAR(100),IN intelefono VARCHAR(15),
IN invencimiento_carnet_de_salud DATE, IN insueldo DOUBLE)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		select -1; -- es el error si falla y se dejo sin cambios
		ROLLBACK;
	END;
    
    START TRANSACTION;
		IF NOT ISNULL(inusuarioID) THEN 
			IF EXISTS (SELECT usuarioID FROM Usuarios WHERE usuarioID=inusuarioID) 
            THEN 
				SELECT -3; -- devuelvo 3
				ROLLBACK;
			END IF;
			INSERT INTO Usuarios (usuarioID,contrasena)
			VALUES (inusuarioID,incontrasena);
        END IF;
		INSERT INTO Personas
			(nombre,  documento, fecha_de_nacimiento, usuarioID,comentarios, telefono)
			VALUES (innombre,  indocumento, infecha_de_nacimiento, inusuarioID,incomentarios, intelefono); 
        INSERT INTO Empleados 
			(empleadoID, vencimiento_carnet_de_salud,sueldo)
            VALUES (@@identity, invencimiento_carnet_de_salud,insueldo);
            SELECT @@identity as id;
    COMMIT;
    
END//
DELIMITER ;


DROP PROCEDURE IF EXISTS BajaEmpleado; 
DELIMITER //
CREATE PROCEDURE BajaEmpleado (IN inpersonaID INT)
BEGIN
	DECLARE user VARCHAR(10);
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		select -1; -- es el error si falla y se dejo sin cambios
		ROLLBACK;
	END;
    
    START TRANSACTION;
		IF NOT EXISTS (
					SELECT empleadoID 
					FROM Personas INNER JOIN Empleados on Personas.personaID = Empleados.empleadoID
                    WHERE empleadoID = inpersonaID
                    ) THEN
			SELECT -4;
			ROLLBACK;
		END IF;
		IF EXISTS(SELECT usuarioID FROM Personas WHERE personaID = inpersonaID) THEN
			-- busco el usuario asociado al cliente para posteriormente borrarlo
			SELECT Usuarios.usuarioID INTO user 
			FROM Personas INNER JOIN Usuarios ON Personas.usuarioID = Usuarios.usuarioID
			WHERE Personas.personaID = inpersonaID; 
			-- lo borro
			DELETE FROM Usuarios WHERE usuarioID = user;
        END IF;
        DELETE FROM Personas WHERE personaID = inpersonaID;

        DELETE FROM Empleados WHERE empleadoID = inpersonaID;

    COMMIT;
    
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS ModificarEmpleado; 
DELIMITER //
CREATE PROCEDURE ModificarEmpleado
(IN inpersonaID INT, 
IN innombre VARCHAR(30),
IN indocumento VARCHAR(15),
IN infecha_de_nacimiento DATE,
IN inusuarioID VARCHAR(10), 
IN incontrasena VARCHAR(15),
IN incomentarios VARCHAR(100),
IN intelefono VARCHAR(15),
IN invencimiento_carnet_de_salud DATE,
IN insueldo DOUBLE)
BEGIN
	DECLARE user VARCHAR(10);
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		select -1; -- es el error si falla y se dejo sin cambios
		ROLLBACK;
	END;
    
    START TRANSACTION;
		IF NOT EXISTS (
					SELECT empleadoID 
					FROM Personas INNER JOIN Empleados on Personas.personaID = Empleados.empleadoID
                    WHERE empleadoID = inpersonaID
                    ) THEN
			SELECT -4;
			ROLLBACK;
		END IF;
		IF EXISTS(SELECT usuarioID FROM Personas WHERE personaID = inpersonaID) THEN
			-- busco el usuario asociado al Empleado para posteriormente modificarlo
			SELECT Usuarios.usuarioID INTO user 
			FROM Personas INNER JOIN Usuarios ON Personas.usuarioID = Usuarios.usuarioID
			WHERE Personas.personaID = inpersonaID; 
			-- lo modifico
			UPDATE Usuarios SET contrasena=incontrasena WHERE usuarioID = user;
--        ELSE
-- 			INSERT INTO Usuarios VALUES (inusuarioID,incontrasena);
		END IF;

        UPDATE Empleados SET vencimiento_carnet_de_salud=invencimiento_carnet_de_salud, sueldo=insueldo WHERE empleadoID = inpersonaID;
        
        UPDATE Personas SET 
        nombre=innombre, documento=indocumento, fecha_de_nacimiento=infecha_de_nacimiento,
        usuarioID=inusuarioID, comentarios=incomentarios, telefono=intelefono
        WHERE personaID = inpersonaID;        
        
    COMMIT;
    
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS ListarEmpleados;
DELIMITER //
CREATE PROCEDURE ListarEmpleados()
BEGIN
	SELECT Personas.*, Usuarios.contrasena, Empleados.vencimiento_carnet_de_salud, Empleados.sueldo
    FROM (Personas INNER JOIN Empleados on Personas.personaID = Empleados.empleadoID) 
    INNER JOIN Usuarios ON Personas.usuarioID = Usuarios.usuarioID;
END//
DELIMITER ;


-- --------------------------------
-- PROCEDIMIENTOS PARA CLIENTES --
-- --------------------------------

DROP PROCEDURE IF EXISTS AltaCliente; 
DELIMITER //
CREATE PROCEDURE AltaCliente 
(IN innombre VARCHAR(30),
IN indocumento VARCHAR(15),
IN infecha_de_nacimiento DATE,
IN inusuarioID VARCHAR(10),
IN incontrasena VARCHAR(15),
IN incomentarios VARCHAR(100),
IN intelefono VARCHAR(15),
IN indescuentoID INT)
BEGIN
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		select -1; -- es el error si falla y se dejo sin cambios
		ROLLBACK;
	END;
    
    START TRANSACTION;
		IF NOT ISNULL(inusuarioID) THEN 
			IF EXISTS (SELECT usuarioID FROM Usuarios WHERE usuarioID=inusuarioID) 
            THEN 
				SELECT -3; -- devuelvo 3
				ROLLBACK;
			END IF;
			INSERT INTO Usuarios (usuarioID,contrasena)
			VALUES (inusuarioID,incontrasena);
        END IF;
		INSERT INTO Personas
			(nombre,  documento, fecha_de_nacimiento, usuarioID,comentarios, telefono)
			VALUES (innombre,  indocumento, infecha_de_nacimiento, inusuarioID,incomentarios, intelefono); 
        INSERT INTO Clientes 
			(clienteID, descuentoID)
			
            VALUES (@@identity, indescuentoID);
            SELECT @@identity as id;
    COMMIT;
    
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS BajaCliente; 
DELIMITER //
CREATE PROCEDURE BajaCliente (IN inpersonaID INT)
BEGIN
	DECLARE user VARCHAR(10);
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		select -1; -- es el error si falla y se dejo sin cambios
		ROLLBACK;
	END;
    
    START TRANSACTION;
		IF NOT EXISTS (
					SELECT clienteID 
					FROM Personas INNER JOIN Clientes on Personas.personaID = Clientes.clienteID
                    WHERE clienteID = inpersonaID
                    ) THEN
			SELECT -4;
			ROLLBACK;
		END IF;
		IF EXISTS(SELECT usuarioID FROM Personas WHERE personaID = inpersonaID) THEN
			-- busco el usuario asociado al cliente para posteriormente borrarlo
			SELECT Usuarios.usuarioID INTO user 
			FROM Personas INNER JOIN Usuarios ON Personas.usuarioID = Usuarios.usuarioID
			WHERE Personas.personaID = inpersonaID; 
			-- lo borro
			DELETE FROM Usuarios WHERE usuarioID = user;
        END IF;
        DELETE FROM Personas WHERE personaID = inpersonaID;

        DELETE FROM Clientes WHERE clienteID = inpersonaID;

    COMMIT;
    
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS ModificarCliente; 
DELIMITER //
CREATE PROCEDURE ModificarCliente
(IN inpersonaID INT, 
IN innombre VARCHAR(30),
IN indocumento VARCHAR(15),
IN infecha_de_nacimiento DATE,
IN inusuarioID VARCHAR(10), 
IN incontrasena VARCHAR(15),
IN incomentarios VARCHAR(100),
IN intelefono VARCHAR(15),
IN indescuentoID INT)
BEGIN
	DECLARE user VARCHAR(10);
	DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
	BEGIN
		select -1; -- es el error si falla y se dejo sin cambios
		ROLLBACK;
	END;
    
    START TRANSACTION;
		IF NOT EXISTS (
					SELECT clienteID 
					FROM Personas INNER JOIN Clientes on Personas.personaID = Clientes.clienteID
                    WHERE clienteID = inpersonaID
                    ) THEN
			SELECT -4;
			ROLLBACK;
		END IF;
		IF EXISTS(SELECT usuarioID FROM Personas WHERE personaID = inpersonaID) THEN
			-- busco el usuario asociado al cliente para posteriormente modificarlo
			SELECT Usuarios.usuarioID INTO user 
			FROM Personas INNER JOIN Usuarios ON Personas.usuarioID = Usuarios.usuarioID
			WHERE Personas.personaID = inpersonaID; 
			-- lo modifico
			UPDATE Usuarios SET contrasena=incontrasena WHERE usuarioID = user;
--        ELSE
-- 			INSERT INTO Usuarios VALUES (inusuarioID,incontrasena);
		END IF;

        UPDATE Clientes SET descuentoID=indescuentoID WHERE clienteID = inpersonaID;
        
        UPDATE Personas SET 
        nombre=innombre, documento=indocumento, fecha_de_nacimiento=infecha_de_nacimiento,
        usuarioID=inusuarioID, comentarios=incomentarios, telefono=intelefono
        WHERE personaID = inpersonaID;        
        
    COMMIT;
    
END//
DELIMITER ;

DROP PROCEDURE IF EXISTS ListarClientes;
DELIMITER //
CREATE PROCEDURE ListarClientes()
BEGIN
	SELECT Personas.*, Usuarios.contrasena, Clientes.descuentoID
    FROM (Personas INNER JOIN Clientes on Personas.personaID = Clientes.clienteID) 
    INNER JOIN Usuarios ON Personas.usuarioID = Usuarios.usuarioID;
END//
DELIMITER ;


use Peluqueria;
insert into Proveedores (nombre,descripcion,direccion) VALUES
("Conaprole","Cooperativa lechera","Magallanes 123");
insert into Proveedores (nombre,descripcion,direccion) VALUES
("Calcar","Cooperativa lechera de colonia","calle 123");
insert into Descuentos (nombre,es_por_convenio,descripcion,porcentaje,dias,fecha_de_expiracion) VALUES
("Descuento 1",true,"es el descuento 1",5,"0100000","2018/12/12");
insert into Descuentos (nombre,es_por_convenio,descripcion,porcentaje,dias,fecha_de_expiracion) VALUES
("Descuento 2",true,"es el descuento 2",8,"0100100","2018/12/20");
insert into Productos (nombre,marca,precio,descripcion,proveedorID,descuentoID)VALUES
("leche","Conaprole",20,"leche descremada",1,1);
insert into Productos (nombre,marca,precio,descripcion,proveedorID,descuentoID)VALUES
("leche","Calcar",20,"leche descremada",2,1);
insert into Productos (nombre,marca,precio,descripcion,proveedorID,descuentoID)VALUES
("Pudding Conamigos","Conaprole",20,"Postre Pudding Conamigos",1,2);
insert into Servicios (nombre,duracion,descripcion,precio) VALUES
("Envío",10,"Envío directo al hogar",150);
insert into Servicios (nombre,duracion,descripcion,precio) VALUES
("Cubiertos",50,"Mesa",30);
insert into ServiciosProductos (servicioID, productoID) VALUES
(1,1);
insert into ServiciosProductos (servicioID, productoID) VALUES
(1,2);
insert into ServiciosProductos (servicioID, productoID) VALUES
(2,3);

call AltaEmpleado("Juan","12678","2012/12/12","juan","pass","cometnario","12120994","2012/12/12",12000);
call AltaEmpleado("Ramiro","12678","2012/12/12","Ramis","pass","cometnario","12120994","2012/12/12",12000);
call AltaEmpleado("Ramiro","12678","2012/12/12","asd","asd","cometnario","12120994","2012/12/12",12000);
call AltaCliente("Marcos","12345678","2012/12/12","marc1","pass","cometnario","12120994",1);
call AltaCliente("Andres","12678","2012/12/12","and","pass","cometnario","12120994",1);
call AltaCliente("Andres","12678","2012/12/12","asdf","df","cometnario","12120994",1);
call BajaCliente(6); -- falla si el usuario es null, por la cascada
call bajaEmpleado(3); -- falla si el usuario es null, por la cascada
call BajaCliente(2);
call bajaEmpleado(5);
call ModificarCliente(4,"Anderes modificado","1231","2013/12/12","marc1","pass2","comentario modificado",
"1212",1);
call ModificarEmpleado(1,"Juan modificado","1231","2013/12/12","juan","pass3","comentario modificado",
"1212","2015/12/12",13000);
call listarClientes();
call listarEmpleados();