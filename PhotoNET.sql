CREATE DATABASE IF NOT EXISTS PhotoNET;
USE PhotoNET;

CREATE TABLE User(
    id INT (11) PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(25) NOT NULL,
    prenom VARCHAR(25) NOT NULL,
    username VARCHAR(25) NOT NULL,
    pwd VARCHAR(255) NOT NULL,
    userRole int NOT NULL
);

CREATE TABLE UserRole(
	id int primary key auto_increment,
	nomRole varchar(100) 
);

CREATE TABLE Photo(
    id INT (11) PRIMARY KEY AUTO_INCREMENT,
    nomPhoto VARCHAR(25) NOT NULL,
    dateAjout  datetime DEFAULT NOW(),
    details VARCHAR(255) ,
    album int NOT NULL,
    commentaires VARCHAR(255)
);

CREATE TABLE Album(
    id INT (11) PRIMARY KEY AUTO_INCREMENT,
    nomAlbum VARCHAR(25) NOT NULL,
    dateCreation datetime DEFAULT NOW(),
    proprioAlbum int NOT NULL,
    detail VARCHAR(255)
);

INSERT INTO UserRole(nomRole) VALUES ('utilisateur'), ('admin');

INSERT INTO User(nom, prenom, username, pwd, userRole) 
VALUES ('BA','Mamie','mamie','passer','admin');

ALTER TABLE User ADD CONSTRAINT fk_user_userRole FOREIGN KEY(userRole) REFERENCES UserRole(id);
ALTER TABLE Photo ADD CONSTRAINT fk_album_photo FOREIGN KEY(album) REFERENCES Album(id);
ALTER TABLE Album ADD CONSTRAINT fk_user_album FOREIGN KEY(proprioAlbum) REFERENCES User(id);

GRANT ALL PRIVILEGES ON PhotoNET.* TO user IDENTIFIED BY 'passer';