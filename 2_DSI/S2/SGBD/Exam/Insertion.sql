-- Remplissage de la table Salle
INSERT INTO Salle (salleID, nom, adresse, capacite) VALUES (1, 'Salle A', 'Adresse A', 200);
INSERT INTO Salle (salleID, nom, adresse, capacite) VALUES (2, 'Salle B', 'Adresse B', 150);
INSERT INTO Salle (salleID, nom, adresse, capacite) VALUES (3, 'Salle C', 'Adresse C', 300);

-- Remplissage de la table Chanteur
INSERT INTO Chanteur (chanteurID, nomchanteur) VALUES (1, 'Chanteur 1');
INSERT INTO Chanteur (chanteurID, nomchanteur) VALUES (2, 'Chanteur 2');
INSERT INTO Chanteur (chanteurID, nomchanteur) VALUES (3, 'Chanteur 3');

-- Remplissage de la table Spectacle
INSERT INTO Spectacle (spectacleID, titre, dateSpectacle, heure, salleID) VALUES ('SP0001', 'Spectacle 1', TO_DATE('2024-05-20', 'YYYY-MM-DD'), TO_DATE('18:00', 'HH24:MI'), 1);
INSERT INTO Spectacle (spectacleID, titre, dateSpectacle, heure, salleID) VALUES ('SP0002', 'Spectacle 2', TO_DATE('2024-05-21', 'YYYY-MM-DD'), TO_DATE('19:00', 'HH24:MI'), 2);
INSERT INTO Spectacle (spectacleID, titre, dateSpectacle, heure, salleID) VALUES ('SP0003', 'Spectacle 3', TO_DATE('2024-05-22', 'YYYY-MM-DD'), TO_DATE('20:00', 'HH24:MI'), 3);

-- Remplissage de la table Participer
INSERT INTO Participer (spectacleID, chanteurID) VALUES ('SP0001', 1);
INSERT INTO Participer (spectacleID, chanteurID) VALUES ('SP0001', 2);
INSERT INTO Participer (spectacleID, chanteurID) VALUES ('SP0002', 2);
INSERT INTO Participer (spectacleID, chanteurID) VALUES ('SP0003', 3);

-- Remplissage de la table Billet
INSERT INTO Billet (billetID, numPlace, prix, spectacleID) VALUES ('SP0001BL_001', 1, 50.00, 'SP0001');
INSERT INTO Billet (billetID, numPlace, prix, spectacleID) VALUES ('SP0001BL_002', 2, 50.00, 'SP0001');
INSERT INTO Billet (billetID, numPlace, prix, spectacleID) VALUES ('SP0002BL_001', 1, 40.00, 'SP0002');
INSERT INTO Billet (billetID, numPlace, prix, spectacleID) VALUES ('SP0003BL_001', 1, 60.00, 'SP0003');

-- Remplissage de la table Vente
INSERT INTO Vente (venteID, MoyenPaiement, dateVente, billetID) VALUES ('V0001', 'Carte de crédit', TO_DATE('2024-05-19', 'YYYY-MM-DD'), 'SP0001BL_001');
INSERT INTO Vente (venteID, MoyenPaiement, dateVente, billetID) VALUES ('V0002', 'Espèces', TO_DATE('2024-05-20', 'YYYY-MM-DD'), 'SP0001BL_002');
INSERT INTO Vente (venteID, MoyenPaiement, dateVente, billetID) VALUES ('V0003', 'Carte de crédit', TO_DATE('2024-05-21', 'YYYY-MM-DD'), 'SP0002BL_001');
INSERT INTO Vente (venteID, MoyenPaiement, dateVente, billetID) VALUES ('V0004', 'Chèque', TO_DATE('2024-05-22', 'YYYY-MM-DD'), 'SP0003BL_001');
