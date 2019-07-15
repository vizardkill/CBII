DROP TABLESPACE CBII including contents and datafiles;
DROP USER conexion cascade;

CREATE TABLESPACE CBII LOGGING
DATAFILE 'D:\Documents\Oracle\Tablespace\CBII.dbf' size 50M
extent management local segment space management auto; 

create user conexion profile default 
identified by 123456 
default tablespace CBII 
temporary tablespace temp 
account unlock; 

--permisos 

grant connect, resource,dba to conexion; 
connect conexion/123456;