create database banco_bd;
use banco_bd;
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50) NOT NULL unique,
    password VARCHAR(50) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
    saldo DOUBLE NOT NULL DEFAULT 1000
);

INSERT INTO usuarios (usuario, password, activo, saldo)
VALUES ('cliente123', 'clave456', true, 1000);

INSERT INTO usuarios (usuario, password, activo, saldo)
VALUES ('conce123', '1234', true, 1000);

