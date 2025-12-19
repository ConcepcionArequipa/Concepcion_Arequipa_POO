CREATE DATABASE banco_bd;
USE banco_bd;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    saldo DOUBLE NOT NULL DEFAULT 1000,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    rol VARCHAR(20) NOT NULL DEFAULT 'cliente'
);

-- Usuario cliente de prueba
INSERT INTO usuarios (usuario, password)
VALUES ('cliente123', 'clave456');

-- Otro cliente
INSERT INTO usuarios (usuario, password)
VALUES ('conce123', '1234');

-- Usuario administrador
INSERT INTO usuarios (usuario, password, saldo, rol)
VALUES ('admin', 'admin123', 0, 'administrador');

-- Verificar datos
SELECT id, usuario, saldo, activo, rol FROM usuarios;
