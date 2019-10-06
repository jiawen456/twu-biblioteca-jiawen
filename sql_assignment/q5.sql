SELECT member.name FROM member
INNER JOIN checkout_item ON member.id = checkout_item.member_id
GROUP BY checkout_item.member_id
HAVING COUNT(member.id) > 1