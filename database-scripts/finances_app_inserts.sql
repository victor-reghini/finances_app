
INSERT INTO users
(id, "name", email, "password")
VALUES(0, 'test user', 'test@user.com', 'test123');


INSERT INTO expense_group
(id, "name", description, user_id)
VALUES(0, '', '', 0);


INSERT INTO accounts
(id, "name", description, user_id, balance, status)
VALUES(0, '', '', 0, 0, '');


INSERT INTO categories
(id, "name", description, category_type, user_id)
VALUES(0, '', '', '', 0);


INSERT INTO cards
(id, "name", description, account_id, user_id, closing_date, card_type_id)
VALUES(0, '', '', 0, 0, 0, 0);


INSERT INTO card_type
(id, "name", description, account_id, user_id)
VALUES(0, '', '', 0, 0);


INSERT INTO payment_type
(id, "name", description, user_id)
VALUES(0, '', '', 0);


INSERT INTO expenses
(id, title, description, status, value, paid_value, payment_date, payment_due_date, purchase_date, installment, total_instalments, payment_type_id, account_id, card_id, user_id, expense_group_id, category_id)
VALUES(0, '', '', '', 0, 0, '', '', '', 0, 0, 0, 0, 0, 0, 0, 0);


INSERT INTO incomes
(id, title, description, value, payment_date, payment_type_id, account_id, user_id, category_id)
VALUES(0, '', '', 0, '', 0, 0, 0, 0);













