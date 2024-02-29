 SELECT p.id,
       SUM(w.salary * DATEDIFF(MONTH, start_date, finish_date)) AS project_price
 FROM project p
 JOIN project_worker wp ON p.id = wp.project_id
 JOIN worker w ON wp.worker_id = w.id
 GROUP BY p.id
 ORDER BY project_price DESC;