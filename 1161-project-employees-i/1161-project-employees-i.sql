# Write your MySQL query statement below

SELECT p.project_id,ROUND(AVG(e.Experience_years),2) as average_years
 FROM Project as p
 INNER JOIN Employee as e
 ON p.employee_id = e.employee_id
 group by project_id ;