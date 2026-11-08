
DROP DATABASE IF EXISTS practica;
DROP USER IF EXISTS 'usuario_practica'@'%';
DROP USER IF EXISTS 'usuario_practica'@'localhost';

CREATE DATABASE practica
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

CREATE USER 'usuario_practica'@'%' IDENTIFIED BY 'la_Clave';
CREATE USER 'usuario_practica'@'localhost' IDENTIFIED BY 'la_Clave';
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'%';
GRANT ALL PRIVILEGES ON practica.* TO 'usuario_practica'@'localhost';
FLUSH PRIVILEGES;

USE practica;

CREATE TABLE suculenta (
    id_suculenta      INT           NOT NULL AUTO_INCREMENT,
    nombre_comun      VARCHAR(60)   NOT NULL,
    nombre_cientifico VARCHAR(80)   NOT NULL,
    familia           VARCHAR(50)   NOT NULL,
    color_principal   VARCHAR(40)   NOT NULL,
    altura_cm         INT           NOT NULL,
    precio_estimado   DECIMAL(10,2) NOT NULL,
    nivel_riego       VARCHAR(10)   NOT NULL,
    ruta_imagen       VARCHAR(1024) NOT NULL,
    PRIMARY KEY (id_suculenta)
) ENGINE = InnoDB;

INSERT INTO suculenta (nombre_comun, nombre_cientifico, familia, color_principal, altura_cm, precio_estimado, nivel_riego, ruta_imagen) VALUES
('Rosa de alabastro', 'Echeveria elegans', 'Crassulaceae', 'Verde azulado', 10, 3500.00, 'Bajo',
 'https://upload.wikimedia.org/wikipedia/commons/8/85/Echeveria_elegans_-_1.jpg'),
('Echeveria Black Prince', 'Echeveria ''Black Prince''', 'Crassulaceae', 'Morado oscuro', 8, 4500.00, 'Bajo',
 'https://upload.wikimedia.org/wikipedia/commons/9/9b/Echeveria_%27Black_Prince%27_-_20090226.jpg'),
('Echeveria Blue Curl', 'Echeveria ''Blue Curl''', 'Crassulaceae', 'Azul verdoso', 15, 4200.00, 'Moderado',
 'https://upload.wikimedia.org/wikipedia/commons/e/e3/Echeveria_Blue_Curl.jpg'),
('Árbol de jade', 'Crassula ovata', 'Crassulaceae', 'Verde brillante', 60, 8000.00, 'Moderado',
 'https://upload.wikimedia.org/wikipedia/commons/5/5d/Crassula_ovata_RTBG.jpg'),
('Sábila', 'Aloe vera', 'Asphodelaceae', 'Verde grisáceo', 45, 5000.00, 'Bajo',
 'https://upload.wikimedia.org/wikipedia/commons/3/3f/A_potted_aloe_vera_plant.jpg'),
('Aloe tigre', 'Aloe variegata', 'Asphodelaceae', 'Verde con franjas blancas', 25, 4000.00, 'Bajo',
 'https://upload.wikimedia.org/wikipedia/commons/d/de/Aloe_variegata0.jpg');

SELECT * FROM suculenta;