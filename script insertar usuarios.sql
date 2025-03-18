use desarrollo;

SELECT * FROM alumno;

INSERT INTO alumno (idalumno, matricula, nombre, apellidos) VALUES (1, 10, 'Jose', 'Cardenas');

INSERT INTO usuario (correo, contrasena, idAlumno) 
VALUES ('jose.cardenas@uabc.edu.mx', '123456', 1);

SELECT * FROM usuario;