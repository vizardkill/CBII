--Vista Solicitudes
CREATE OR REPLACE VIEW v_Solicitudes_Usuarios AS
SELECT SOLICITUDES.pk_id as Id,
       USUARIOS.pk_documento as Usuario_Solicitante,
       TIPOS_ESTADOS_SOLICITUDES.nombre as Estado,
       CATEGORIAS_SOLICITUDES.nombre as Categoria,
       PROGRAMAS_ACADEMICOS.nombre as Programa_Academico,
       SOLICITUDES.descripcion_problema,
       SOLICITUDES.descripcion_peticion,
       SOLICITUDES.descripcion_solucion,
       SOLICITUDES.fecha_creacion,
       SOLICITUDES.fecha_solucion

FROM SOLICITUDES
INNER JOIN TIPOS_ESTADOS_SOLICITUDES ON SOLICITUDES.fk_estado = TIPOS_ESTADOS_SOLICITUDES.pk_id
INNER JOIN CATEGORIAS_SOLICITUDES ON SOLICITUDES.fk_categoria = CATEGORIAS_SOLICITUDES.pk_id
INNER JOIN PROGRAMAS_ACADEMICOS ON SOLICITUDES.fk_programa_academico = PROGRAMAS_ACADEMICOS.pk_id
INNER JOIN USUARIOS ON SOLICITUDES.fk_usuario_solicitante = USUARIOS.pk_documento

       