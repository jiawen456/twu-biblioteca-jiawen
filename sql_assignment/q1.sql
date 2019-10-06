SELECT member.name FROM checkout_item
INNER JOIN book ON checkout_item.book_id = book.id
INNER JOIN member ON checkout_item.member_id = member.id
WHERE book.title = "The Hobbit";