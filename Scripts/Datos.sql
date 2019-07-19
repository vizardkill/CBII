--INSERTAR DATOS BD
----------------------
INSERT INTO TIPOS_DOCUMENTOS VALUES(1,'CEDULA CIUDADANIA','CC'); 
INSERT INTO TIPOS_USUARIOS VALUES (1,'USUARIO','Usuario para el envio de solicitudes');
INSERT INTO PROGRAMAS_ACADEMICOS VALUES (1,'Tecnología en Sistematización de Datos','TNLG53587','El programa de tecnología en Sistematización 
de Datos enmarcado dentro del área de desarrollo de software, es el siguiente ciclo en el proceso de formación iniciado en la Técnica Profesional.');
INSERT INTO TIPOS_ESTADOS_SOLICITUDES VALUES (1,'Abierta','La solicitud esta creada, los empleados no la han revisado.');
INSERT INTO TIPOS_ESTADOS_SOLICITUDES VALUES (2,'Procesada','La solicitud esta siendo revisada por los empleados.');
INSERT INTO TIPOS_ESTADOS_SOLICITUDES VALUES (3,'Terminada','La solicitud se ha completado, termino el proceso.');

INSERT INTO CATEGORIAS_SOLICITUDES VALUES (1,'Casos Especiales',5,'Estudiantes que no posen ninguna materia matriculada en su linea academica');

INSERT INTO SOLICITUD VALUES (1,1000,1,1,1,1,'SOLICITUD PARA PETICION GRADOS',
'PROBLEMA CON GRADOS','PROBLEMA CON GRADOS', TO_DATE('2019/06/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'));

INSERT INTO SOLICITUD VALUES (22,1000,1,1,1,22,'PRUEBA POSIBLE SOLUCION',
'PROBLEMA CON CODIGO','PROBLEMA CON CODIGO', TO_DATE('2019/06/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss')); 

