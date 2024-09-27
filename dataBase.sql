CREATE DATABASE IF NOT EXISTS Similares;
USE Similares;

CREATE TABLE IF NOT EXISTS USUARIOS (
    ID_Usuario INTEGER PRIMARY KEY AUTO_INCREMENT,
    Correo VARCHAR(100) NOT NULL UNIQUE,
    Password VARCHAR(100) NOT NULL,
    Rol VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS DOCTORES (
    ID_Doctor INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Apellido VARCHAR(100) NOT NULL,
    Telefono VARCHAR(100) NOT NULL,
    ID_Usuario INTEGER NOT NULL,
    FOREIGN KEY (ID_Usuario) REFERENCES USUARIOS(ID_Usuario)
);

CREATE TABLE IF NOT EXISTS CITAS (
    ID_Cita INTEGER PRIMARY KEY AUTO_INCREMENT,
    Nombre_Paciente VARCHAR(100) NOT NULL,
    ID_Doctor INTEGER NOT NULL,
    Fecha DATE NOT NULL,
    Hora TIME NOT NULL,
    Prioridad INTEGER NOT NULL,
    FOREIGN KEY (ID_Doctor) REFERENCES DOCTORES(ID_Doctor)
);

CREATE TABLE IF NOT EXISTS REPORTE (
    ID_Consulta INTEGER PRIMARY KEY AUTO_INCREMENT,
    ID_Cita INTEGER NOT NULL,
    Diagnostico VARCHAR(100) NOT NULL,
    Tratamiento VARCHAR(100) NOT NULL,
    Notas VARCHAR(100) NOT NULL,
    FOREIGN KEY (ID_Cita) REFERENCES CITAS(ID_Cita)
);

/* Crea datos */
INSERT INTO USUARIOS (Correo, Password, rol) VALUES
('usuario1@example.com', 'password1', 'Doctor'),
('usuario2@example.com', 'password2', 'Doctor'),
('usuario3@example.com', 'password3', 'Doctor'),
('usuario4@example.com', 'password4', 'Doctor'),
('usuario5@example.com', 'password5', 'Doctor'),
('usuario6@example.com', 'password6', 'Doctor'),
('usuario7@example.com', 'password7', 'Doctor'),
('usuario8@example.com', 'password8', 'Doctor'),
('usuario9@example.com', 'password9', 'Doctor'),
('usuario10@example.com', 'password10', 'Doctor'),
('usuario11@example.com', 'password11', 'Doctor'),
('usuario12@example.com', 'password12', 'Doctor'),
('usuario13@example.com', 'password13', 'Doctor'),
('usuario14@example.com', 'password14', 'Doctor'),
('usuario15@example.com', 'password15', 'Doctor'),
('usuario16@example.com', 'password16', 'Doctor'),
('usuario17@example.com', 'password17', 'Doctor'),
('usuario18@example.com', 'password18', 'Doctor'),
('usuario19@example.com', 'password19', 'Doctor'),
('usuario20@example.com', 'password20', 'Doctor'),
('usuario21@example.com', 'password21', 'Doctor'),
('usuario22@example.com', 'password22', 'Doctor'),
('usuario23@example.com', 'password23', 'Doctor'),
('usuario24@example.com', 'password24', 'Doctor'),
('usuario25@example.com', 'password25', 'Recepcionista'),
('usuario26@example.com', 'password26', 'Recepcionista'),
('usuario27@example.com', 'password27', 'Recepcionista'),
('usuario28@example.com', 'password28', 'Recepcionista'),
('usuario29@example.com', 'password29', 'Recepcionista'),
('usuario30@example.com', 'password30', 'Recepcionista');

INSERT INTO DOCTORES (Nombre, Apellido, Telefono, ID_Usuario) VALUES
('José', 'García', '555-2526', 1),
('María', 'Martínez', '555-2728', 2),
('Carlos', 'Hernández', '555-2930', 3),
('Ana', 'López', '555-3132', 4),
('Jorge', 'González', '555-3334', 5),
('Laura', 'Pérez', '555-3536', 6),
('Francisco', 'Rodríguez', '555-3738', 7),
('Sofía', 'Sánchez', '555-3940', 8),
('Manuel', 'Ramírez', '555-4142', 9),
('Patricia', 'Torres', '555-4344', 10),
('Ricardo', 'Flores', '555-4546', 11),
('Diana', 'Vázquez', '555-4748', 12),
('Alejandro', 'Gómez', '555-4950', 13),
('Verónica', 'Jiménez', '555-5152', 14),
('Roberto', 'Mendoza', '555-5354', 15);

/* Crear 30 citas */
/* La prioridad es del 1 al 3 */
INSERT INTO CITAS (Nombre_Paciente, ID_Doctor, Fecha, Hora, Prioridad) VALUES
('Paciente1', 1, '2021-12-01', '08:00:00', 1),
('Paciente2', 2, '2021-12-01', '08:30:00', 2),
('Paciente3', 3, '2021-12-01', '09:00:00', 3),
('Paciente4', 4, '2021-12-01', '09:30:00', 1),
('Paciente5', 5, '2021-12-01', '10:00:00', 2),
('Paciente6', 6, '2021-12-01', '10:30:00', 3),
('Paciente7', 7, '2021-12-01', '11:00:00', 1),
('Paciente8', 8, '2021-12-01', '11:30:00', 2),
('Paciente9', 9, '2021-12-01', '12:00:00', 3),
('Paciente10', 10, '2021-12-01', '12:30:00', 1),
('Paciente11', 11, '2021-12-01', '13:00:00', 2),
('Paciente12', 12, '2021-12-01', '13:30:00', 3),
('Paciente13', 13, '2021-12-01', '14:00:00', 1),
('Paciente14', 14, '2021-12-01', '14:30:00', 2),
('Paciente15', 15, '2021-12-01', '15:00:00', 3),
('Paciente16', 1, '2021-12-01', '15:30:00', 1),
('Paciente17', 2, '2021-12-01', '16:00:00', 2),
('Paciente18', 3, '2021-12-01', '16:30:00', 3),
('Paciente19', 4, '2021-12-01', '17:00:00', 1),
('Paciente20', 5, '2021-12-01', '17:30:00', 2),
('Paciente21', 6, '2021-12-01', '18:00:00', 3),
('Paciente22', 7, '2021-12-01', '18:30:00', 1),
('Paciente23', 8, '2021-12-01', '19:00:00', 2),
('Paciente24', 9, '2021-12-01', '19:30:00', 3),
('Paciente25', 10, '2021-12-01', '20:00:00', 1),
('Paciente26', 11, '2021-12-01', '20:30:00', 2),
('Paciente27', 12, '2021-12-01', '21:00:00', 3),
('Paciente28', 13, '2021-12-01', '21:30:00', 1),
('Paciente29', 14, '2021-12-01', '22:00:00', 2),
('Paciente30', 15, '2021-12-01', '22:30:00', 3);

/* Crear 30 reportes */
INSERT INTO REPORTE (ID_Cita, Diagnostico, Tratamiento, Notas) VALUES
(1, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(2, 'Migraña', 'Ibuprofeno 400mg', 'Dolor intenso'),
(3, 'Gastritis', 'Omeprazol 20mg', 'Recomendación de dieta'),
(4, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(5, 'Contractura muscular', 'Relajante muscular', 'Ejercicios recomendados'),
(6, 'Amigdalitis', 'Antibiótico', 'Reposo recomendado'),
(7, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(8, 'Migraña', 'Ibuprofeno 400mg', 'Dolor intenso'),
(9, 'Gastritis', 'Omeprazol 20mg', 'Recomendación de dieta'),
(10, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(11, 'Contractura muscular', 'Relajante muscular', 'Ejercicios recomendados'),
(12, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(13, 'Migraña', 'Ibuprofeno 400mg', 'Dolor intenso'),
(14, 'Gastritis', 'Omeprazol 20mg', 'Recomendación de dieta'),
(15, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(16, 'Contractura muscular', 'Relajante muscular', 'Ejercicios recomendados'),
(17, 'Amigdalitis', 'Antibiótico', 'Reposo recomendado'),
(18, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(19, 'Migraña', 'Ibuprofeno 400mg', 'Dolor intenso'),
(20, 'Gastritis', 'Omeprazol 20mg', 'Recomendación de dieta'),
(21, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(22, 'Contractura muscular', 'Relajante muscular', 'Ejercicios recomendados'),
(23, 'Amigdalitis', 'Antibiótico', 'Reposo recomendado'),
(24, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(25, 'Migraña', 'Ibuprofeno 400mg', 'Dolor intenso'),
(26, 'Gastritis', 'Omeprazol 20mg', 'Recomendación de dieta'),
(27, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina'),
(28, 'Contractura muscular', 'Relajante muscular', 'Ejercicios recomendados'),
(29, 'Amigdalitis', 'Antibiótico', 'Reposo recomendado'),
(30, 'Saludable', 'No requiere tratamiento', 'Chequeo de rutina');