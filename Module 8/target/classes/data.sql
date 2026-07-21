-- Country Data
INSERT INTO country (co_code, co_name) VALUES ('BV', 'Bouvet Island');
INSERT INTO country (co_code, co_name) VALUES ('DJ', 'Djibouti');
INSERT INTO country (co_code, co_name) VALUES ('GP', 'Guadeloupe');
INSERT INTO country (co_code, co_name) VALUES ('GS', 'South Georgia and the South Sandwich Islands');
INSERT INTO country (co_code, co_name) VALUES ('LU', 'Luxembourg');
INSERT INTO country (co_code, co_name) VALUES ('SS', 'South Sudan');
INSERT INTO country (co_code, co_name) VALUES ('TF', 'French Southern Territories');
INSERT INTO country (co_code, co_name) VALUES ('UM', 'United States Minor Outlying Islands');
INSERT INTO country (co_code, co_name) VALUES ('ZA', 'South Africa');
INSERT INTO country (co_code, co_name) VALUES ('ZM', 'Zambia');
INSERT INTO country (co_code, co_name) VALUES ('ZW', 'Zimbabwe');
INSERT INTO country (co_code, co_name) VALUES ('IN', 'India');

-- Stock Data (Facebook - Sept 2019)
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-03', 184.00, 182.39, 9779400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-04', 184.65, 187.14, 11308000);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-05', 188.53, 190.90, 13876700);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-06', 190.21, 187.49, 15226800);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-09', 187.73, 188.76, 14722400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-10', 187.44, 186.17, 15455900);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-11', 186.46, 188.49, 11761700);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-12', 189.86, 187.47, 11419800);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-13', 187.33, 187.19, 11441100);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-16', 186.93, 186.22, 8444800);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-17', 186.66, 188.08, 9671100);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-18', 188.09, 188.14, 9681900);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-19', 188.66, 190.14, 10392700);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-20', 190.66, 189.93, 19934200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-23', 189.34, 186.82, 13327600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-24', 187.98, 181.28, 18546600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-25', 181.45, 182.80, 18068300);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-26', 181.33, 180.11, 16083300);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-09-27', 180.49, 177.10, 14656200);

-- Stock Data (Facebook - Highest Volume)
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2019-01-31', 165.60, 166.69, 77233600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2018-10-31', 155.00, 151.79, 60101300);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('FB', '2018-12-19', 141.21, 133.24, 57404900);

-- Stock Data (Google - Price > 1250)
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-22', 1236.67, 1253.76, 954200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-23', 1256.64, 1270.59, 1593400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-24', 1270.59, 1260.05, 1169800);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-25', 1270.30, 1267.34, 1567200);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-26', 1273.38, 1277.42, 1361400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-04-29', 1280.51, 1296.20, 3618400);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-10-17', 1251.40, 1252.80, 1047900);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('GOOGL', '2019-05-10', 1100.00, 1150.00, 800000);

-- Stock Data (Netflix - Lowest Stock Prices)
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-24', 242.00, 233.88, 9547600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-21', 263.83, 246.39, 21397600);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2018-12-26', 233.92, 253.67, 14402700);
INSERT INTO stock (st_code, st_date, st_open, st_close, st_volume) VALUES ('NFLX', '2019-07-15', 380.00, 375.00, 5000000);

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
INSERT INTO skill (sk_id, sk_name) VALUES (4, 'SQL');

-- Employee Skill Mapping Data
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (1, 2);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 1);
INSERT INTO employee_skill (es_em_id, es_sk_id) VALUES (2, 3);
