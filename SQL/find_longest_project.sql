 SELECT id AS project_id,
       DATEDIFF(MONTH, start_date, finish_date) AS month_diff
 FROM project
 WHERE DATEDIFF(MONTH, start_date, finish_date) = (
    SELECT MAX(DATEDIFF(MONTH, start_date, finish_date))
    FROM project
);