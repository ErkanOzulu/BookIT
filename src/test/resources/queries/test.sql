select firstname, lastname, role, email from users
where  email = 'blyst6@si.edu';

select firstname||' '|| lastname as name,role,t.batch_number,c.location as campus,t.name as teamname from users u join team t on u.team_id= t.id join campus c on t.campus_id= c.id where u.id=42 ;