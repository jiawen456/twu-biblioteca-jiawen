INSERT INTO book
VALUES (11, "The Pragmatic Programmer");

INSERT INTO member
VALUES (43, "Jia Wen");

INSERT INTO checkout_item (member_id, book_id)
VALUES (43, 11);

SELECT member.name FROM checkout_item
INNER JOIN book ON checkout_item.book_id = book.id
INNER JOIN member ON checkout_item.member_id = member.id
WHERE book.title = "The Pragmatic Programmer";