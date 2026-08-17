USE inspiraT_final;
-- CONSULTA 1. Usuarios registrados
SELECT *
FROM Usuario;
-- CONSULTA 2. Datos principales de los usuarios
SELECT
    id_usuario,
    nombre_completo,
    nombre_usuario,
    correo_electronico
FROM Usuario;
-- CONSULTA 3. Roles registrados
SELECT *
FROM Rol;
-- CONSULTA 4. Información básica de los cursos
SELECT
    id_curso,
    titulo,
    estado,
    nivel_dificultad,
    fecha_publicacion
FROM Curso;
-- CONSULTA 5. Categorías registradas
SELECT
    id_categoria,
    nombre,
    descripcion
FROM Categoria;