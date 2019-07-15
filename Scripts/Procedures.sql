
--PROCEDIMIENTOS
--Procedimiento almacenado, para la validacion de usuario y contraseña, que permite retornar los datos del usuario--
CREATE OR REPLACE PROCEDURE LOGIN_USUARIO 
(
    L_nick USUARIOS.USERNAME%TYPE,
    L_pwd  USUARIOS.PWD%TYPE,

    L_name OUT USUARIOS.NOMBRE%TYPE,
    L_lastname1 OUT USUARIOS.PRIMER_APELLIDO%TYPE,
    L_lastname2 OUT USUARIOS.SEGUNDO_APELLIDO%TYPE,
    L_email OUT USUARIOS.CORREO%TYPE,
    L_tel OUT USUARIOS.TELEFONO%TYPE,
    L_tipo OUT USUARIOS.FK_TIPO_USUARIO%TYPE,
    L_doc OUT USUARIOS.PK_DOCUMENTO%TYPE,

    L_aux OUT INTEGER
) AS

BEGIN 
    
    SELECT CASE 
           WHEN EXISTS( 
               SELECT * FROM USUARIOS WHERE USERNAME = L_nick AND PWD = L_pwd
           )
           THEN 1
           ELSE 0
           END INTO L_aux
    FROM DUAL;

    IF(L_aux = 1) THEN
       SELECT  
                    NOMBRE,
                    PRIMER_APELLIDO,
                    SEGUNDO_APELLIDO,
                    CORREO,
                    TELEFONO,
                    FK_TIPO_USUARIO,
                    PK_DOCUMENTO
                    
                    INTO L_name, L_lastname1, L_lastname2, L_email, L_tel, L_tipo, L_doc

                    FROM USUARIOS
                    WHERE USERNAME = L_nick AND PWD = L_pwd;

    END IF;

    EXCEPTION WHEN NO_DATA_FOUND THEN
    L_aux := 0;
    
END;
/
 
--/Funcion para verificar si se encuentra en uso (Nick, Email, Documento) en la tabla usuario
CREATE OR REPLACE FUNCTION Validaciones_Usuario(V_tipo VARCHAR2,V_variable VARCHAR2) RETURN NUMBER
IS V_aux NUMBER(1,0);
BEGIN

  IF (v_tipo = 'ValidarNickUsuario') THEN 
      SELECT COUNT(username) INTO V_aux FROM USUARIOS WHERE username = V_variable;
      RETURN V_aux;
  END  IF;

  IF (v_tipo = 'ValidarEmailUsuario') THEN 
      SELECT COUNT(correo) INTO V_aux FROM USUARIOS WHERE correo = V_variable;
      RETURN V_aux;
  END  IF;

  IF (v_tipo = 'ValidarDocUsuario') THEN 
      SELECT COUNT(pk_documento) INTO V_aux FROM USUARIOS WHERE pk_documento = V_variable;
      RETURN V_aux;
  END  IF;
  
  EXCEPTION WHEN NO_DATA_FOUND THEN
  V_aux := 0;
  RETURN V_aux;  
END;
/

--/Funcion para verificar si se encuentra en uso el codigo en la tabla PROGRAMAS_ACADEMICOS
CREATE OR REPLACE FUNCTION Validar_Codigo_P_Academico (V_variable VARCHAR2) RETURN NUMBER
IS V_aux NUMBER(1,0);
BEGIN

  SELECT CASE 
     WHEN EXISTS (SELECT codigo FROM PROGRAMAS_ACADEMICOS WHERE codigo = V_variable) 
     THEN 1
     ELSE 0
     END INTO V_aux
  FROM DUAL;
  RETURN V_aux;    

  EXCEPTION WHEN NO_DATA_FOUND THEN
  V_aux := 0;
  RETURN V_aux;  
END;
/

--/Funcion para verificar si se encuentra en uso el codigo en la tabla MATERIAS
CREATE OR REPLACE FUNCTION Validar_Codigo_Materia (V_variable VARCHAR2) RETURN NUMBER
IS V_aux NUMBER(1,0);
BEGIN

  SELECT CASE 
     WHEN EXISTS (SELECT codigo FROM MATERIAS WHERE codigo = V_variable) 
     THEN 1
     ELSE 0
     END INTO V_aux
  FROM DUAL;
  RETURN V_aux;    

  EXCEPTION WHEN NO_DATA_FOUND THEN
  V_aux := 0;
  RETURN V_aux;  
END;
/


