INSERT INTO address (address_line1, address_line2, city, postal_code) VALUES
('ul. Klonowa 12', 'm. 4', 'Warszawa', '00-123'),
('ul. Lipowa 5', NULL, 'Kraków', '30-456'),
('ul. Dębowa 8', 'lok. 2A', 'Gdańsk', '80-789');


INSERT INTO doctor (doctor_number, email, first_name, last_name, telephone_number, specialization) VALUES
('D12345', 'kowalski@example.com', 'Jan', 'Kowalski', '123456789', 'GP'),
('D67890', 'nowak@example.com', 'Anna', 'Nowak', '987654321', 'DERMATOLOGIST'),
('D11223', 'wójcik@example.com', 'Piotr', 'Wójcik', '654321987', 'SURGEON');


INSERT INTO medical_treatment (description, type) VALUES
('Badanie serca', 'EKG'),
('Prześwietlenie płuc', 'RTG'),
('USG jamy brzusznej', 'USG');


INSERT INTO patient (date_of_birth, email, first_name, last_name, patient_number, telephone_number) VALUES
('1985-06-15', 'patient1@example.com', 'Marek', 'Wiśniewski', 'P1001', '111222333'),
('1992-09-23', 'patient2@example.com', 'Ewa', 'Kaczmarek', 'P1002', '444555666'),
('2000-01-05', 'patient3@example.com', 'Tomasz', 'Lis', 'P1003', '777888999');


INSERT INTO visit (time, description) VALUES
('2024-02-20 10:00:00', 'Kontrolna wizyta u GP'),
('2024-02-21 14:30:00', 'Konsultacja dermatologiczna'),
('2024-02-22 09:15:00', 'Konsultacja chirurgiczna');