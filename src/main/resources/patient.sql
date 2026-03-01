-- ===============================
-- INSURANCE
-- ===============================
INSERT INTO insurance (policy_number, policy_provider, valid_till, created_at)
VALUES
    ('POL001', 'LIC', NOW() + INTERVAL '1 year', NOW()),
    ('POL002', 'HDFC Ergo', NOW() + INTERVAL '2 year', NOW());


-- ===============================
-- DOCTOR
-- ===============================
INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Raj Mehta', 'Cardiology', 'raj.mehta@hospital.com'),
    ('Dr. Anjali Iyer', 'Dermatology', 'anjali.iyer@hospital.com'),
    ('Dr. Karan Shah', 'Orthopedic', 'karan.shah@hospital.com');


-- ===============================
-- DEPARTMENT
-- ===============================
INSERT INTO department (name, head_doctor_id)
VALUES
    ('Cardiology', 1),
    ('Dermatology', 2);


-- ===============================
-- DEPARTMENT_DOCTORS (Many-To-Many)
-- ===============================
INSERT INTO department_doctors (department_id, doctor_id)
VALUES
    (1, 1),
    (2, 2),
    (1, 3);


-- ===============================
-- PATIENT
-- ===============================
INSERT INTO patient (name, dob, email, gender, blood_group, insurance_id, created_at)
VALUES
    ('Rahul Sharma', '1998-05-12', 'rahul@gmail.com', 'Male', 'A_POSITIVE', 1, NOW()),
    ('Sneha Patil', '1996-08-21', 'sneha@gmail.com', 'Female', 'O_NEGATIVE', 2, NOW());


-- ===============================
-- APPOINTMENT
-- ===============================
INSERT INTO appointment (appointment_time, doctor_id, patient_id, reason, status)
VALUES
    (NOW(), 1, 1, 'Heart Checkup', 'SCHEDULED'),
    (NOW() + INTERVAL '1 day', 2, 2, 'Skin Allergy', 'SCHEDULED');