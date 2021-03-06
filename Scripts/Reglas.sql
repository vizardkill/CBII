--PROGRAMAS_ACADEMICOS
ALTER TABLE PROGRAMAS_ACADEMICOS ADD CONSTRAINT PK_PROGRAMA_ACADEMICO PRIMARY KEY(pk_id);
ALTER TABLE PROGRAMAS_ACADEMICOS ADD CONSTRAINT NN_NOMBRE_PROGRAMA_ACADEMICO CHECK(nombre IS NOT NULL); 
ALTER TABLE PROGRAMAS_ACADEMICOS ADD CONSTRAINT NN_CODIGO_PROGRAMA_ACADEMICO CHECK(codigo IS NOT NULL); 
ALTER TABLE PROGRAMAS_ACADEMICOS ADD CONSTRAINT UQ_CODIGO_PROGRAMA_ACADEMICO UNIQUE(codigo);

--CATEGORIAS_SOLICITUDES
ALTER TABLE CATEGORIAS_SOLICITUDES ADD CONSTRAINT PK_CATEGORIA_SOLICITUD PRIMARY KEY(pk_id);
ALTER TABLE CATEGORIAS_SOLICITUDES ADD CONSTRAINT NN_NOMBRE_C_SOLICITUD CHECK(nombre IS NOT NULL); 
ALTER TABLE CATEGORIAS_SOLICITUDES ADD CONSTRAINT NN_PRIORIDAD_C_SOLICITUD CHECK(prioridad IS NOT NULL); 
ALTER TABLE CATEGORIAS_SOLICITUDES ADD CONSTRAINT RANGO_PRIORIDAD_C_SOLICITUD CHECK(prioridad BETWEEN 1 AND 5);
ALTER TABLE CATEGORIAS_SOLICITUDES ADD CONSTRAINT UQ_NOMBRE_C_SOLICITUD UNIQUE(nombre);


--TIPOS_ESTADOS_SOLICITUDES
ALTER TABLE TIPOS_ESTADOS_SOLICITUDES ADD CONSTRAINT PK_TIPO_ESTADO_SOLICITUD PRIMARY KEY(pk_id);
ALTER TABLE TIPOS_ESTADOS_SOLICITUDES ADD CONSTRAINT NN_NOMBRE_TE_SOLICITUD CHECK(nombre IS NOT NULL);
ALTER TABLE TIPOS_ESTADOS_SOLICITUDES ADD CONSTRAINT UQ_NOMBRE_TE_SOLICITUD UNIQUE(nombre);


--TIPOS_DOCUMENTOS
ALTER TABLE TIPOS_DOCUMENTOS ADD CONSTRAINT PK_TIPO_DOCUMENTO PRIMARY KEY(pk_id);
ALTER TABLE TIPOS_DOCUMENTOS ADD CONSTRAINT NN_NOMBRE_TIPO_DOCUMENTO CHECK(nombre IS NOT NULL);
ALTER TABLE TIPOS_DOCUMENTOS ADD CONSTRAINT NN_ABREVIATURA_TIPO_DOCUMENTO CHECK(abreviatura IS NOT NULL);
ALTER TABLE TIPOS_DOCUMENTOS ADD CONSTRAINT UQ_NOMBRE_TIPO_DOCUMENTO UNIQUE(nombre);
ALTER TABLE TIPOS_DOCUMENTOS ADD CONSTRAINT UQ_ABREVIATURA_TIPO_DOCUMENTO UNIQUE(abreviatura);


--TIPOS_USUARIOS
ALTER TABLE TIPOS_USUARIOS ADD CONSTRAINT PK_USUARIO PRIMARY KEY(pk_id);
ALTER TABLE TIPOS_USUARIOS ADD CONSTRAINT NN_NOMBRE_TIPO_USUARIO CHECK (nombre IS NOT NULL);
ALTER TABLE TIPOS_USUARIOS ADD CONSTRAINT UQ_NOMBRE_TIPO_USUARIO UNIQUE(nombre);


--MATERIAS
ALTER TABLE MATERIAS ADD CONSTRAINT PK_MATERIA PRIMARY KEY(pk_id);
ALTER TABLE MATERIAS ADD CONSTRAINT FK_PROGRAMA_ACADEMICO_MATERIA FOREIGN KEY(fk_programa_academico) REFERENCES PROGRAMAS_ACADEMICOS(pk_id);
ALTER TABLE MATERIAS ADD CONSTRAINT NN_PROGRAMA_ACADEMICO_MATERIA CHECK(fk_programa_academico IS NOT NULL);
ALTER TABLE MATERIAS ADD CONSTRAINT NN_CODIGO_MATERIA CHECK(codigo IS NOT NULL);
ALTER TABLE MATERIAS ADD CONSTRAINT NN_NOMBRE_MATERIA CHECK(nombre IS NOT NULL);
ALTER TABLE MATERIAS ADD CONSTRAINT UQ_CODIGO_MATERIA UNIQUE(codigo);


--USUARIOS
ALTER TABLE USUARIOS ADD CONSTRAINT PK_DOCUMENTO PRIMARY KEY(pk_documento);
ALTER TABLE USUARIOS ADD CONSTRAINT FK_TIPO_DOCUMENTO FOREIGN KEY(fk_tipo_documento) REFERENCES TIPOS_DOCUMENTOS(pk_id);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_TIPO_DOCUMENTO CHECK(fk_tipo_documento IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT FK_TIPO_USUARIO FOREIGN KEY(fk_tipo_usuario) REFERENCES TIPOS_USUARIOS(pk_id);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_TIPO_USUARIO CHECK(fk_tipo_usuario IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_NOMBRES_USUARIO CHECK (nombres IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_APELLIDOS_USUARIO CHECK(apellidos IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_CORREO_ELECTRONICO_USUARIO CHECK(correo IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_USERNAME_USUARIO CHECK(username IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT NN_PWD_USUARIO CHECK(pwd IS NOT NULL);
ALTER TABLE USUARIOS ADD CONSTRAINT UQ_CORREO_USUARIO UNIQUE(correo);
ALTER TABLE USUARIOS ADD CONSTRAINT UQ_USERNAME_USUARIO UNIQUE(username);


--SOLICITUD
ALTER TABLE SOLICITUDES ADD CONSTRAINT PK_SOLICITUD_ID PRIMARY KEY(pk_id);
ALTER TABLE SOLICITUDES ADD CONSTRAINT FK_USUARIO_SOLICITANTE FOREIGN KEY(fk_usuario_solicitante) REFERENCES USUARIOS(pk_documento);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_USUARIO_SOLICITANTE CHECK(fk_usuario_solicitante IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT FK_USUARIO_ENCARGADO FOREIGN KEY(fk_usuario_encargado) REFERENCES USUARIOS(pk_documento);
ALTER TABLE SOLICITUDES ADD CONSTRAINT FK_ESTADO_SOLICITUD FOREIGN KEY(fk_estado) REFERENCES TIPOS_ESTADOS_SOLICITUDES(pk_id);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_ESTADO_SOLICITUD CHECK(fk_estado IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT FK_CATEGORIA_SOLICITUD FOREIGN KEY(fk_categoria) REFERENCES CATEGORIAS_SOLICITUDES(pk_id);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_CATEGORIA_SOLICITUD CHECK(fk_categoria IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT FK_P_ACADEMICO_SOLICITUD FOREIGN KEY(fk_programa_academico) REFERENCES PROGRAMAS_ACADEMICOS(pk_id);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_P_ACADEMICO_SOLICITUD CHECK(fk_programa_academico IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_TITULO_SOLICITUD CHECK(titulo IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_D_PROBLEMA_SOLICITUD CHECK(descripcion_problema IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_D_PETICION_SOLICITUD CHECK(descripcion_peticion IS NOT NULL);
--ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_D_SOLUCION_SOLICITUD CHECK(descripcion_solucion IS NOT NULL);
ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_FECHA_CREACION_SOLICITUD CHECK(fecha_creacion IS NOT NULL);
--ALTER TABLE SOLICITUDES ADD CONSTRAINT NN_FECHA_SOLUCION_SOLICITUD CHECK(fecha_solucion IS NOT NULL);



--LOGS 
ALTER TABLE LOGS ADD CONSTRAINT PK_LOG PRIMARY KEY(pk_id);


