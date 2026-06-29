-- Exercise 1 - Scenario 1: Apply 1% discount to loan interest rates for customers older than 60
DECLARE
    CURSOR cust_cur IS
        SELECT customer_id, loan_interest_rate, age
        FROM customers;
    v_customer_id customers.customer_id%TYPE;
    v_interest_rate customers.loan_interest_rate%TYPE;
    v_age customers.age%TYPE;
BEGIN
    OPEN cust_cur;
    LOOP
        FETCH cust_cur INTO v_customer_id, v_interest_rate, v_age;
        EXIT WHEN cust_cur%NOTFOUND;
        IF v_age > 60 THEN
            UPDATE customers
            SET loan_interest_rate = v_interest_rate * 0.99
            WHERE customer_id = v_customer_id;
        END IF;
    END LOOP;
    CLOSE cust_cur;
    COMMIT;
END;
/
