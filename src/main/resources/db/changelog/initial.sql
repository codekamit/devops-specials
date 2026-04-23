--liquibase formatted sql

--changeset amit:1
CREATE TABLE department (
    department_id BIGSERIAL PRIMARY KEY,
    department_name VARCHAR(255),
    department_subject VARCHAR(255)
);

--changeset amit:2
CREATE TABLE employee (
    employee_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    version BIGINT DEFAULT 0,
    department_department_id BIGINT,
    FOREIGN KEY (department_department_id) REFERENCES department(department_id)
);
