CREATE TABLE projets (
     id_projet SERIAL PRIMARY KEY,
     nom_projet VARCHAR(255) ,
     description VARCHAR(255),
     date_debut DATE,
     date_fin DATE,
     budget DECIMAL
);