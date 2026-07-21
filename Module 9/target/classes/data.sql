-- Department Data
INSERT INTO department (dp_id, dp_name) VALUES (1, 'Information Technology');
INSERT INTO department (dp_id, dp_name) VALUES (2, 'Human Resources');
INSERT INTO department (dp_id, dp_name) VALUES (3, 'Finance');

-- Employee Data
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (1, 'John Doe', 50000.00, true, '1995-05-15', 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (2, 'Mary Smith', 60000.00, true, '1992-08-20', 1);
INSERT INTO employee (em_id, em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id) VALUES (3, 'Alex Johnson', 45000.00, false, '1998-11-10', 2);

-- Skill Data
INSERT INTO skill (sk_id, sk_name) VALUES (1, 'Java');
INSERT INTO skill (sk_id, sk_name) VALUES (2, 'Spring Boot');
INSERT INTO skill (sk_id, sk_name) VALUES (3, 'React');

-- Employee Skill Data
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);

-- Quiz Data: User
INSERT INTO users (us_id, us_name) VALUES (1, 'John');

-- Quiz Data: Question
INSERT INTO question (qt_id, qt_text) VALUES (1, 'What is the extension of the hyper text markup language file?');
INSERT INTO question (qt_id, qt_text) VALUES (2, 'What is the maximum level of heading tag can be used in a HTML page?');
INSERT INTO question (qt_id, qt_text) VALUES (3, 'The HTML document itself begins with <html> and ends </html>. State True of False');
INSERT INTO question (qt_id, qt_text) VALUES (4, 'Choose the right option to store text value value in a variable');

-- Quiz Data: Options
-- Question 1 Options
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (1, 1, '.xhtm', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (2, 1, '.ht', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (3, 1, '.html', 1.0, true);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (4, 1, '.htmx', 0.0, false);

-- Question 2 Options
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (5, 2, '5', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (6, 2, '3', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (7, 2, '4', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (8, 2, '6', 1.0, true);

-- Question 3 Options
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (9, 3, 'false', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (10, 3, 'true', 1.0, true);

-- Question 4 Options
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (11, 4, '''John''', 0.5, true);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (12, 4, 'John', 0.0, false);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (13, 4, '"John"', 0.5, true);
INSERT INTO options (op_id, op_qt_id, op_text, op_score, op_is_correct) VALUES (14, 4, '/John/', 0.0, false);

-- Quiz Data: Attempt
INSERT INTO attempt (at_id, at_us_id, at_date) VALUES (1, 1, '2026-07-21');

-- Quiz Data: Attempt Question
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (1, 1, 1);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (2, 1, 2);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (3, 1, 3);
INSERT INTO attempt_question (aq_id, aq_at_id, aq_qt_id) VALUES (4, 1, 4);

-- Quiz Data: Attempt Option
-- Q1 Selected
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (1, 1, 1, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (2, 1, 2, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (3, 1, 3, true);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (4, 1, 4, false);

-- Q2 Selected
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (5, 2, 5, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (6, 2, 6, true);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (7, 2, 7, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (8, 2, 8, false);

-- Q3 Selected
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (9, 3, 9, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (10, 3, 10, true);

-- Q4 Selected
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (11, 4, 11, true);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (12, 4, 12, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (13, 4, 13, false);
INSERT INTO attempt_option (ao_id, ao_aq_id, ao_op_id, ao_selected) VALUES (14, 4, 14, false);
