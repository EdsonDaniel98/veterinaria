INSERT INTO veterinarians (id, name, last_name, second_last_name, license) VALUES (1, 'Edson', 'Daniel','Alvarado', 'AAEM98');
INSERT INTO veterinarians (id, name, last_name, second_last_name, license) VALUES (2, 'Miguel', 'Garcia','Pelaez', 'MIGA123');


INSERT INTO owners (id, name, last_name, second_last_name) VALUES (1, 'Ana', 'Perez','Gonzalez');
INSERT INTO owners (id, name, last_name, second_last_name) VALUES (2, 'Maria', 'Lorenzo','Tejada');

INSERT INTO patients (id, name, type_patient, birth_date, phone_number, owner_id) VALUES (1, 'Pepe', 'Gato', NOW(), "5553679274", 1);
INSERT INTO patients (id, name, type_patient, birth_date, phone_number, owner_id) VALUES (2, 'Tara', 'Perro', NOW(), "5554673864", 2);

INSERT INTO medical_registers (id, owner_id, patient_id, veterinary_id, create_at, hour) VALUES (1, 1, 1, 1, NOW(), "10");
INSERT INTO medical_registers (id, owner_id, patient_id, veterinary_id, create_at, hour) VALUES (2, 2, 2, 2, NOW(), "10");
