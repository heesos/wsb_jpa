-- Insert into doctor
INSERT INTO doctor (doctor_number, email, first_name, last_name, telephone_number, specialization) VALUES
('D10001', 'doc1@example.com', 'Jan', 'Kowalski', '123456789', 'GP'),
('D10002', 'doc2@example.com', 'Anna', 'Nowak', '987654321', 'DERMATOLOGIST'),
('D10003', 'doc3@example.com', 'Piotr', 'Wójcik', '654321987', 'SURGEON'),
('D10004', 'doc4@example.com', 'Marek', 'Lis', '111222333', 'OCULIST'),
('D10005', 'doc5@example.com', 'Ewa', 'Kaczmarek', '444555666', 'GP'),
('D10006', 'doc6@example.com', 'Tomasz', 'Zieliński', '777888999', 'DERMATOLOGIST'),
('D10007', 'doc7@example.com', 'Karolina', 'Jankowska', '999888777', 'SURGEON'),
('D10008', 'doc8@example.com', 'Adam', 'Lewandowski', '666555444', 'OCULIST');

-- Insert into patient
INSERT INTO patient (date_of_birth, email, first_name, last_name, patient_number, telephone_number) VALUES
('1985-06-15', 'patient1@example.com', 'Marek', 'Wiśniewski', 'P1001', '111222333'),
('1992-09-23', 'patient2@example.com', 'Ewa', 'Kaczmarek', 'P1002', '444555666'),
('2000-01-05', 'patient3@example.com', 'Tomasz', 'Lis', 'P1003', '777888999'),
('1978-04-12', 'patient4@example.com', 'Paweł', 'Dąbrowski', 'P1004', '333444555'),
('1989-11-30', 'patient5@example.com', 'Katarzyna', 'Mazur', 'P1005', '555666777'),
('1995-07-21', 'patient6@example.com', 'Dominik', 'Szymański', 'P1006', '888999000'),
('1983-02-08', 'patient7@example.com', 'Aleksandra', 'Kowalczyk', 'P1007', '222333444'),
('1975-09-17', 'patient8@example.com', 'Grzegorz', 'Wójcik', 'P1008', '666777888');

-- Insert into address
INSERT INTO address (doctor_id, patient_id, address_line1, address_line2, city, postal_code) VALUES
(1, NULL, 'ul. Klonowa 12', 'm. 4', 'Warszawa', '00-123'),
(2, NULL, 'ul. Lipowa 5', NULL, 'Kraków', '30-456'),
(3, NULL, 'ul. Dębowa 8', 'lok. 2A', 'Gdańsk', '80-789'),
(4, NULL, 'ul. Brzozowa 10', NULL, 'Poznań', '60-789'),
(NULL, 5, 'ul. Świerkowa 3', 'm. 1', 'Łódź', '90-321'),
(NULL, 6, 'ul. Topolowa 7', NULL, 'Wrocław', '50-234'),
(NULL, 7, 'ul. Sosnowa 9', 'lok. 5', 'Katowice', '40-567'),
(NULL, 8, 'ul. Jesionowa 15', NULL, 'Lublin', '20-678');

-- Insert into visit
INSERT INTO visit (doctor_id, patient_id, time, description) VALUES
(1, 1, '2024-02-20 10:00:00', 'Kontrolna wizyta u GP'),
(2, 2, '2024-02-21 14:30:00', 'Konsultacja dermatologiczna'),
(3, 3, '2024-02-22 09:15:00', 'Konsultacja chirurgiczna'),
(4, 4, '2024-02-23 11:45:00', 'Badanie okulistyczne'),
(5, 5, '2024-02-24 08:30:00', 'Porada lekarza rodzinnego'),
(6, 6, '2024-02-25 16:00:00', 'Wizyta kontrolna u dermatologa'),
(7, 7, '2024-02-26 12:15:00', 'Konsultacja chirurga'),
(8, 8, '2024-02-27 15:45:00', 'Wizyta okulistyczna');

-- Insert into medical_treatment
INSERT INTO medical_treatment (visit_id, description, type) VALUES
(1, 'Badanie serca', 'EKG'),
(2, 'Prześwietlenie płuc', 'RTG'),
(3, 'USG jamy brzusznej', 'USG'),
(4, 'Badanie EKG serca', 'EKG'),
(5, 'Prześwietlenie kolana', 'RTG'),
(6, 'USG tarczycy', 'USG'),
(7, 'Badanie RTG kręgosłupa', 'RTG'),
(8, 'USG nerek', 'USG');
