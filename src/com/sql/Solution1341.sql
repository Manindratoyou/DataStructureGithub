--My Sql
(
    SELECT
        u.name AS results
    FROM
        MovieRating mr
    JOIN
        Users u ON mr.user_id = u.user_id
    GROUP BY
        u.user_id, u.name
    ORDER BY
        COUNT(mr.movie_id) DESC, u.name ASC
    LIMIT 1
)
UNION ALL
(
    SELECT
        m.title AS results
    FROM
        MovieRating mr
    JOIN
        Movies m ON mr.movie_id = m.movie_id
    WHERE
        DATE_FORMAT(mr.created_at, '%Y-%m') = '2020-02'
    GROUP BY
        m.movie_id, m.title
    ORDER BY
        AVG(mr.rating) DESC, m.title ASC
    LIMIT 1
);
--Oracle
-- For finding the user with the most ratings (using ROWNUM for older Oracle)
SELECT results FROM (
    SELECT
        u.name AS results,
        COUNT(mr.movie_id) AS rating_count,
        u.name AS user_name_for_order -- Need to include for ordering outside subquery
    FROM
        MovieRating mr
    JOIN
        Users u ON mr.user_id = u.user_id
    GROUP BY
        u.user_id, u.name
    ORDER BY
        rating_count DESC, user_name_for_order ASC
)
WHERE ROWNUM = 1

UNION ALL

-- For finding the movie with the highest average rating in Feb 2020 (using ROWNUM for older Oracle)
SELECT results FROM (
    SELECT
        m.title AS results,
        AVG(mr.rating) AS avg_rating,
        m.title AS movie_title_for_order -- Need to include for ordering outside subquery
    FROM
        MovieRating mr
    JOIN
        Movies m ON mr.movie_id = m.movie_id
    WHERE
        TO_CHAR(mr.created_at, 'YYYY-MM') = '2020-02'
    GROUP BY
        m.movie_id, m.title
    ORDER BY
        avg_rating DESC, movie_title_for_order ASC
)
WHERE ROWNUM = 1;