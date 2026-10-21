USE springboot_practice;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(150)
);

INSERT INTO students (name, email)
SELECT 'Puneeth', 'puneeth@example.com'
WHERE NOT EXISTS (
    SELECT 1 FROM students
    WHERE email = 'puneeth@example.com'
);

SELECT * FROM students;
