
--PROCEDIMIENTOS
--Procedimiento almacenado, para la validacion de usuario y contraseña, que permite retornar los datos del usuario--
CREATE OR REPLACE PROCEDURE LOGIN_USUARIO 
(
    L_nick usuarios.username%TYPE,
    L_pwd  usuarios.pwd%TYPE,

    L_nombres OUT usuarios.nombres%TYPE,
    L_apellidos OUT usuarios.apellidos%TYPE,
    L_correo OUT usuarios.CORREO%TYPE,

    L_tipo OUT usuarios.fk_tipo_usuario%TYPE,
    L_doc OUT usuarios.pk_documento%TYPE,

    L_aux OUT INTEGER
) AS

BEGIN 
    
    SELECT CASE 
           WHEN EXISTS( 
               SELECT * FROM usuarios WHERE username = L_nick AND pwd = L_pwd
           )
           THEN 1
           ELSE 0
           END INTO L_aux
    FROM DUAL;

    IF(L_aux = 1) THEN
       SELECT  
                    nombres,
                    apellidos,
                    correo,
                    fk_tipo_documento,
                    pk_documento
                    
                    INTO L_nombres, L_apellidos, L_correo, L_tipo, L_doc

                    FROM usuarios
                    WHERE username = L_nick AND pwd = L_pwd;

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


