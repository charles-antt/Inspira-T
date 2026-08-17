CREATE DATABASE inspiraT_final;
USE inspiraT_final;
CREATE TABLE Usuario(
    id_usuario INT AUTO_INCREMENT,
    nombre_completo VARCHAR(100) NOT NULL,
    nombre_usuario VARCHAR(50) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    telefono VARCHAR(15),
    foto_perfil VARCHAR(255),
    fecha_registro DATETIME NOT NULL,
    PRIMARY KEY(id_usuario));
    CREATE TABLE Rol(
    id_rol INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255),
    PRIMARY KEY(id_rol));
CREATE TABLE Usuario_Rol(
    id_usuario INT,
    id_rol INT,
    PRIMARY KEY(id_usuario, id_rol),
    CONSTRAINT fk_usuario_rol_usuario FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario),
    CONSTRAINT fk_usuario_rol_rol FOREIGN KEY(id_rol) REFERENCES Rol(id_rol));
CREATE TABLE Instructor(
    id_instructor INT,
    ciudad VARCHAR(100),
    especialidad VARCHAR(100) NOT NULL,
    años_experiencia INT,
    frase VARCHAR(255),
    biografia TEXT,
    PRIMARY KEY(id_instructor),
    CONSTRAINT fk_instructor_usuario FOREIGN KEY(id_instructor) REFERENCES Usuario(id_usuario));
CREATE TABLE Aprendiz(
    id_aprendiz INT,
    PRIMARY KEY(id_aprendiz),
    CONSTRAINT fk_aprendiz_usuario FOREIGN KEY(id_aprendiz) REFERENCES Usuario(id_usuario));
CREATE TABLE Categoria(
    id_categoria INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    PRIMARY KEY(id_categoria));
CREATE TABLE Curso(
    id_curso INT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    miniatura VARCHAR(255),
    estado ENUM('Iniciado', 'En progreso', 'Finalizado') NOT NULL,
    nivel_dificultad VARCHAR(30) NOT NULL,
    fecha_publicacion DATE NOT NULL,
    id_categoria INT NOT NULL,
    id_instructor INT NOT NULL,
    PRIMARY KEY(id_curso),
    CONSTRAINT fk_curso_categoria FOREIGN KEY(id_categoria) REFERENCES Categoria(id_categoria),
    CONSTRAINT fk_curso_instructor FOREIGN KEY(id_instructor) REFERENCES Instructor(id_instructor));
CREATE TABLE Contenido(
    id_contenido INT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_publicacion DATE NOT NULL,
    estado ENUM('Borrador', 'Publicado', 'Archivado') NOT NULL,
    id_curso INT NOT NULL,
    PRIMARY KEY(id_contenido),
    CONSTRAINT fk_contenido_curso FOREIGN KEY(id_curso) REFERENCES Curso(id_curso));
CREATE TABLE Video(
    id_video INT,
    duracion TIME NOT NULL,
    orden INT NOT NULL,
    miniatura VARCHAR(255),
    url_video VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_video),
    CONSTRAINT fk_video_contenido FOREIGN KEY(id_video) REFERENCES Contenido(id_contenido));
CREATE TABLE TransmisionEnVivo(
    id_transmisionenvivo INT,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    enlace VARCHAR(255) NOT NULL,
    PRIMARY KEY(id_transmisionenvivo),
    CONSTRAINT fk_transmision_contenido FOREIGN KEY(id_transmisionenvivo) REFERENCES Contenido(id_contenido));
CREATE TABLE Inscripcion(
    id_inscripcion INT AUTO_INCREMENT,
    fecha_inscripcion DATE NOT NULL,
    progreso DECIMAL(5,2) NOT NULL,
    estado ENUM('Pendiente', 'En progreso', 'Completado') NOT NULL,
    fecha_finalizacion DATE,
    id_aprendiz INT NOT NULL,
    id_curso INT NOT NULL,
    PRIMARY KEY(id_inscripcion),
    CONSTRAINT fk_inscripcion_aprendiz FOREIGN KEY(id_aprendiz) REFERENCES Aprendiz(id_aprendiz),
    CONSTRAINT fk_inscripcion_curso FOREIGN KEY(id_curso) REFERENCES Curso(id_curso));
CREATE TABLE Certificado(
    id_certificado INT AUTO_INCREMENT,
    fecha_emision DATE NOT NULL,
    id_inscripcion INT NOT NULL,
    PRIMARY KEY(id_certificado),
    CONSTRAINT fk_certificado_inscripcion FOREIGN KEY(id_inscripcion) REFERENCES Inscripcion(id_inscripcion));
CREATE TABLE Comentario(
    id_comentario INT AUTO_INCREMENT,
    texto TEXT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    id_aprendiz INT NOT NULL,
    id_contenido INT NOT NULL,
    PRIMARY KEY(id_comentario),
    CONSTRAINT fk_comentario_aprendiz FOREIGN KEY(id_aprendiz) REFERENCES Aprendiz(id_aprendiz),
    CONSTRAINT fk_comentario_contenido FOREIGN KEY(id_contenido) REFERENCES Contenido(id_contenido));
CREATE TABLE Reaccion(
    id_reaccion INT AUTO_INCREMENT,
    tipo_reaccion VARCHAR(30) NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    id_aprendiz INT NOT NULL,
    id_comentario INT NOT NULL,
    PRIMARY KEY(id_reaccion),
    CONSTRAINT fk_reaccion_aprendiz FOREIGN KEY(id_aprendiz) REFERENCES Aprendiz(id_aprendiz),
    CONSTRAINT fk_reaccion_comentario FOREIGN KEY(id_comentario) REFERENCES Comentario(id_comentario));
CREATE TABLE Notificacion(
    id_notificacion INT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY(id_notificacion),
    CONSTRAINT fk_notificacion_usuario FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario));
CREATE TABLE Seguimiento(
    id_seguimiento INT AUTO_INCREMENT,
    fecha_seguimiento DATE NOT NULL,
    id_aprendiz INT NOT NULL,
    id_instructor INT NOT NULL,
    PRIMARY KEY(id_seguimiento),
    CONSTRAINT fk_seguimiento_aprendiz FOREIGN KEY(id_aprendiz) REFERENCES Aprendiz(id_aprendiz),
    CONSTRAINT fk_seguimiento_instructor FOREIGN KEY(id_instructor) REFERENCES Instructor(id_instructor));
    SHOW TABLES;
    
