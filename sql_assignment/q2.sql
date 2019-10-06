SELECT COUNT(member.id) FROM member
LEFT JOIN checkout_item ON checkout_item.member_id = member.id
WHERE checkout_item.book_id IS NULL and checkout_item.movie_id IS NULL;