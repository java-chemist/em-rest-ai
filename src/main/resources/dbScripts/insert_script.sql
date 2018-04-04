INSERT INTO designations (des_code, des_name) VALUES ('IT', 'Intern');
INSERT INTO designations (des_code, des_name) VALUES ('A', 'Analyst');
INSERT INTO designations (des_code, des_name) VALUES ('SA', 'Senior Analyst');
INSERT INTO designations (des_code, des_name) VALUES ('M', 'Manager');
INSERT INTO designations (des_code, des_name) VALUES ('SM', 'Senior Manager');
INSERT INTO designations (des_code, des_name) VALUES ('D', 'Director');

INSERT INTO service_lines (sl_code, sl_name) VALUES ('J', 'Oracle Java');
INSERT INTO service_lines (sl_code, sl_name) VALUES ('C', 'Microsoft .Net');
INSERT INTO service_lines (sl_code, sl_name) VALUES ('A', 'Analytics & Cognitive');
INSERT INTO service_lines (sl_code, sl_name) VALUES ('B', 'BlockChain');

INSERT INTO roles (role_code, role_name) VALUES ('DEV', 'Developer');
INSERT INTO roles (role_code, role_name) VALUES ('QA', 'Tester');
INSERT INTO roles (role_code, role_name) VALUES ('FUNC', 'Functional');

INSERT INTO employees (name, emp_id, password, designation, service_line, role) 
VALUES ('Luv Gupta', 101, '$2a$10$5olP7R8um/Hf3.Lw8RghHO.DiwjQ4AQHPBpxTMVHtUjHbE0j7a1ya', 'SA', 'J', 'DEV');
INSERT INTO employees (name, emp_id, password, designation, service_line, role) 
VALUES ('Amit Kumar', 102, '$2a$10$pqK.c6mbRYwDjkjjp7MGmedsFZsXgOwTnMDXvkleyWOzp0gek.qPG', 'M', 'J', 'DEV');
INSERT INTO employees (name, emp_id, password, designation, service_line, role) 
VALUES ('Joe Gatto', 103, '$2a$10$5olP7R8um/Hf3.Lw8RghHO.DiwjQ4AQHPBpxTMVHtUjHbE0j7a1ya', 'IT', 'C', 'QA');
INSERT INTO employees (name, emp_id, password, designation, service_line, role) 
VALUES ('James Murray', 104, '$2a$10$pqK.c6mbRYwDjkjjp7MGmedsFZsXgOwTnMDXvkleyWOzp0gek.qPG', 'D', 'B', 'FUNC');
INSERT INTO employees (name, emp_id, password, designation, service_line, role) 
VALUES ('Satoshi Nakamoto', 105, '$2a$10$xzLxj9jxUVLJp8vYnx3wEuq8uI5DnNgxKhSYaviu1ZGk1e27zkAj.', 'SM', 'B', 'DEV');
INSERT INTO employees (name, emp_id, password, designation, service_line, role) 
VALUES ('Kevin Mitnick', 106, '$2a$10$W3KwUx.dXYZsxBW18IafsuV96q3fSbWmgRlrtIeeCWJrHtcSYCZeS', 'A', 'A', 'QA');
