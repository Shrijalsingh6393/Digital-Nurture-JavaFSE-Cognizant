-- Exercise 1 - Scenario 2: Promote customers to VIP when balance > 10000
DECLARE
    CURSOR cust_cur IS
        SELECT customer_id, balance
        FROM customers;
    v_customer_id customers.customer_id%TYPE;
    v_balance customers.balance%TYPE;
BEGIN
    OPEN cust_cur;
    LOOP
        FETCH cust_cur INTO v_customer_id, v_balance;
        EXIT WHEN cust_cur%NOTFOUND;
        IF v_balance > 10000 THEN
            UPDATE customers
            SET is_vip = 'TRUE'
            WHERE customer_id = v_customer_id;
        END IF;
    END LOOP;
    CLOSE cust_cur;
    COMMIT;
END;
/
