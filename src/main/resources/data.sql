INSERT INTO blog (title, content, description, imageName, createdAt, updatedAt)
VALUES ('First Blog', 'This is the content of the first blog.', 'A short description of the first blog.', 'image1.jpg',
        '2024-03-30 12:00:00', '2024-03-30 12:00:00'),
       ('Second Blog', 'This is the content of the second blog.', 'A short description of the second blog.',
        'image2.jpg', '2024-03-30 12:30:00', '2024-03-30 12:30:00'),
       ('Third Blog', 'This is the content of the third blog.', 'A short description of the third blog.', 'image3.jpg',
        '2024-03-30 13:00:00', '2024-03-30 13:00:00');

-- เพิ่มข้อมูลโรงเรียน
INSERT INTO school (schoolName)
VALUES ('Samsenwit School'),
       ('Chulalongkorn School');

-- เพิ่มข้อมูลนักเรียน
INSERT INTO student (studentName, dateOfBirth, schoolId)
VALUES ('Alice', '2547-09-15', 1), -- อยู่ที่ Samsenwit School
       ('Bob', '2548-10-11', 1),   -- อยู่ที่ Samsenwit School
       ('Charlie', '2550-01-20', 2); -- อยู่ที่ Chulalongkorn School
