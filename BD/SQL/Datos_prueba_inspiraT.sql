USE inspiraT_final;
INSERT INTO Usuario
(id_usuario, nombre_completo, nombre_usuario, correo_electronico, contraseña, telefono, foto_perfil, fecha_registro)
VALUES
(1, 'María Elena Torres', 'maria_torres', 'maria.torres@inspirat.com', 'Prueba123', '7711234567', 'maria.jpg', '2026-01-15 10:30:00'),
(2, 'Carlos Hernández López', 'carlos_hl', 'carlos.hernandez@inspirat.com', 'Prueba123', '7712345678', 'carlos.jpg', '2026-01-20 12:15:00'),
(3, 'Sofía Martínez Ruiz', 'sofia_mr', 'sofia.martinez@inspirat.com', 'Prueba123', '7713456789', 'sofia.jpg', '2026-02-05 09:45:00'),
(4, 'José Antonio Pérez', 'jose_perez', 'jose.perez@inspirat.com', 'Prueba123', NULL, NULL, '2026-02-18 16:20:00');
INSERT INTO Rol
(id_rol, nombre, descripcion)
VALUES
(1, 'Instructor', 'Usuario encargado de compartir conocimientos mediante cursos y contenidos.'),
(2, 'Aprendiz', 'Usuario que accede a los cursos y contenidos disponibles.');
INSERT INTO Usuario_Rol
(id_usuario, id_rol)
VALUES
(1, 1),
(2, 2),
(3, 1),
(3, 2),
(4, 2);
INSERT INTO Instructor
(id_instructor, ciudad, especialidad, años_experiencia, frase, biografia)
VALUES
(1, 'Puebla', 'Talavera tradicional', 15, 'La tradición se conserva compartiéndola.', 'Artesana dedicada a la elaboración tradicional de piezas de talavera.'),
(3, 'Oaxaca', 'Tejido artesanal', 10, 'Cada tejido cuenta una historia.', 'Artesana especializada en técnicas tradicionales de tejido.');
INSERT INTO Aprendiz
(id_aprendiz)
VALUES
(2),
(3),
(4);
INSERT INTO Categoria
(id_categoria, nombre, descripcion)
VALUES
(1, 'Artesanías', 'Conocimientos relacionados con la elaboración de artesanías tradicionales.'),
(2, 'Textiles', 'Técnicas tradicionales de tejido y elaboración de textiles.'),
(3, 'Cocina tradicional', 'Conocimientos relacionados con platillos y técnicas de cocina tradicional.');
INSERT INTO Curso
(id_curso, titulo, descripcion, miniatura, estado, nivel_dificultad, fecha_publicacion, id_categoria, id_instructor)
VALUES
(1, 'Introducción a la Talavera Tradicional', 'Curso sobre técnicas básicas de elaboración de talavera.', 'talavera.jpg', 'Finalizado', 'Básico', '2026-01-10', 1, 1),

(2, 'Técnicas de Tejido Artesanal', 'Curso introductorio sobre técnicas tradicionales de tejido.', 'tejido.jpg', 'En progreso', 'Intermedio', '2026-02-15', 2, 3),

(3, 'Cocina Tradicional Mexicana', 'Curso dedicado a la preparación de platillos tradicionales.', 'cocina.jpg', 'Iniciado', 'Básico', '2026-03-20', 3, 1),

(4, 'Diseño de Textiles Tradicionales', 'Curso sobre diseño y elaboración de textiles tradicionales.', 'textiles.jpg', 'En progreso', 'Avanzado', '2026-04-12', 2, 3);
INSERT INTO Contenido
(id_contenido, titulo, descripcion, fecha_publicacion, estado, id_curso)
VALUES
(1, 'Materiales para Talavera', 'Introducción a los materiales utilizados en la elaboración de talavera.', '2026-01-12', 'Publicado', 1),

(2, 'Preparación de la pieza', 'Proceso inicial para preparar una pieza de talavera.', '2026-01-18', 'Publicado', 1),

(3, 'Tipos de hilo', 'Descripción de los principales tipos de hilo utilizados en el tejido.', '2026-02-18', 'Publicado', 2),

(4, 'Técnicas básicas de tejido', 'Explicación de técnicas básicas utilizadas en textiles tradicionales.', '2026-02-25', 'Publicado', 2),

(5, 'Ingredientes tradicionales', 'Introducción a ingredientes utilizados en la cocina tradicional.', '2026-03-22', 'Publicado', 3),

(6, 'Diseño de patrones', 'Introducción al diseño de patrones textiles.', '2026-04-15', 'Borrador', 4);
INSERT INTO Video
(id_video, duracion, orden, miniatura, url_video)
VALUES
(1, '00:12:30', 1, 'materiales.jpg', 'https://ejemplo.com/video1'),
(2, '00:18:45', 2, 'talavera.jpg', 'https://ejemplo.com/video2'),
(3, '00:15:20', 1, 'hilos.jpg', 'https://ejemplo.com/video3');
INSERT INTO TransmisionEnVivo
(id_transmisionenvivo, fecha, hora_inicio, hora_fin, enlace)
VALUES
(4, '2026-05-10', '17:00:00', '18:30:00', 'https://ejemplo.com/transmision1'),
(5, '2026-05-17', '18:00:00', '19:30:00', 'https://ejemplo.com/transmision2'),
(6, '2026-05-24', '16:00:00', '17:30:00', 'https://ejemplo.com/transmision3');
INSERT INTO Inscripcion
(id_inscripcion, fecha_inscripcion, progreso, estado, fecha_finalizacion, id_aprendiz, id_curso)
VALUES
(1, '2026-02-01', 100.00, 'Completado', '2026-03-01', 2, 1),

(2, '2026-03-05', 75.00, 'En progreso', NULL, 2, 2),

(3, '2026-03-25', 50.00, 'En progreso', NULL, 3, 3),

(4, '2026-04-20', 25.00, 'Pendiente', NULL, 4, 4);
INSERT INTO Certificado
(id_certificado, fecha_emision, id_inscripcion)
VALUES
(1, '2026-03-02', 1);
INSERT INTO Comentario
(id_comentario, texto, fecha, hora, id_aprendiz, id_contenido)
VALUES
(1, 'La explicación de los materiales fue muy clara.', '2026-02-10', '11:30:00', 2, 1),

(2, 'Me gustaría aprender más sobre esta técnica.', '2026-03-10', '14:20:00', 3, 3),

(3, 'El contenido fue muy interesante.', '2026-04-02', '16:45:00', 4, 5);
INSERT INTO Reaccion
(id_reaccion, tipo_reaccion, fecha, hora, id_aprendiz, id_comentario)
VALUES
(1, 'Me gusta', '2026-02-11', '12:00:00', 3, 1),

(2, 'Me gusta', '2026-03-11', '15:10:00', 2, 2),

(3, 'Me encanta', '2026-04-03', '17:00:00', 4, 3);
INSERT INTO Notificacion
(id_notificacion, titulo, mensaje, fecha, hora, id_usuario)
VALUES
(1, 'Nuevo curso disponible', 'Se ha publicado un nuevo curso de artesanías.', '2026-03-01', '09:00:00', 2),

(2, 'Curso actualizado', 'El contenido de un curso se ha actualizado.', '2026-03-15', '13:30:00', 3),

(3, 'Nuevo contenido', 'Se ha agregado nuevo contenido a un curso.', '2026-04-10', '10:15:00', 4);
INSERT INTO Seguimiento
(id_seguimiento, fecha_seguimiento, id_aprendiz, id_instructor)
VALUES
(1, '2026-02-05', 2, 1),

(2, '2026-03-10', 3, 3),

(3, '2026-04-20', 4, 1);