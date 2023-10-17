# Write your MySQL query statement below

SELECT e.name 
FROM Employee e 
JOIN Employee b ON e.id = b.managerId 
GROUP BY b.managerId 
HAVING COUNT(*) >= 5;