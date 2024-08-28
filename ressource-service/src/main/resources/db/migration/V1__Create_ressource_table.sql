CREATE TYPE type_ressource_enum AS ENUM ('MATERIEL', 'LOGICIEL', 'HUMAINE', 'FINANCIERE');

CREATE TABLE ressources (
        id_ressource SERIAL PRIMARY KEY,
        nom VARCHAR(255) ,
        type type_ressource_enum,
        quantite INT ,
        nom_fournisseur VARCHAR(255) ,
        prenom_fournisseur VARCHAR(255) ,
        tele VARCHAR(255) ,
        adresse VARCHAR(255),
        id_tache INT
);
