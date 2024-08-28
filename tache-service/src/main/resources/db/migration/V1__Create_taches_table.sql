CREATE TYPE statut_enum AS ENUM ('A_FAIRE', 'EN_COURS', 'TERMINE');

CREATE TABLE taches (
    id_tache SERIAL PRIMARY KEY,
    description VARCHAR(255) ,
    date_debut DATE ,
    date_fin DATE ,
    status statut_enum,
    id_projet INT
);
