# Write your MySQL query statement below

SELECT teacher_id, count(DISTINCT subject_id) as cnt
FROM Teacher 
group by teacher_id;