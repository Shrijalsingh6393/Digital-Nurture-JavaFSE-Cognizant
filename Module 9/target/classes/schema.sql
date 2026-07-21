-- Department & Employee Schema
CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(50) NOT NULL
);

CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(50) NOT NULL,
    em_salary NUMERIC(10,2),
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    CONSTRAINT fk_emp_dept FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

CREATE TABLE skill (
    sk_id INT AUTO_INCREMENT PRIMARY KEY,
    sk_name VARCHAR(50) NOT NULL
);

CREATE TABLE employee_skill (
    es_em_id INT NOT NULL,
    es_sk_id INT NOT NULL,
    PRIMARY KEY (es_em_id, es_sk_id),
    CONSTRAINT fk_es_emp FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
    CONSTRAINT fk_es_sk FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Quiz Schema
CREATE TABLE users (
    us_id INT AUTO_INCREMENT PRIMARY KEY,
    us_name VARCHAR(50) NOT NULL
);

CREATE TABLE question (
    qt_id INT AUTO_INCREMENT PRIMARY KEY,
    qt_text VARCHAR(255) NOT NULL
);

CREATE TABLE options (
    op_id INT AUTO_INCREMENT PRIMARY KEY,
    op_qt_id INT NOT NULL,
    op_text VARCHAR(100) NOT NULL,
    op_score NUMERIC(5,2) NOT NULL,
    op_is_correct BOOLEAN NOT NULL,
    CONSTRAINT fk_opt_qt FOREIGN KEY (op_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt (
    at_id INT AUTO_INCREMENT PRIMARY KEY,
    at_us_id INT NOT NULL,
    at_date DATE NOT NULL,
    CONSTRAINT fk_att_us FOREIGN KEY (at_us_id) REFERENCES users(us_id)
);

CREATE TABLE attempt_question (
    aq_id INT AUTO_INCREMENT PRIMARY KEY,
    aq_at_id INT NOT NULL,
    aq_qt_id INT NOT NULL,
    CONSTRAINT fk_aq_at FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
    CONSTRAINT fk_aq_qt FOREIGN KEY (aq_qt_id) REFERENCES question(qt_id)
);

CREATE TABLE attempt_option (
    ao_id INT AUTO_INCREMENT PRIMARY KEY,
    ao_aq_id INT NOT NULL,
    ao_op_id INT NOT NULL,
    ao_selected BOOLEAN NOT NULL,
    CONSTRAINT fk_ao_aq FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
    CONSTRAINT fk_ao_op FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);
