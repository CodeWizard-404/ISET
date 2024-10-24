-- ****************************************************************************
-- **  OLAP HANDS-ON
-- ****************************************************************************

-- ****************************************************************************
-- EXERCISE 4-3
--
--    Cube MVs:  Query a fact table w/ and w/o query rewrite
-- ****************************************************************************

--     Turn on/off query rewrite for this session only.  
--     Run the queries (F9) and view explain plans (F6) with rewrite enabled and disabled
--     To turn on/off rewrite across database sessions, run the "ALTER materialized view"
--     command below.

  -- Rewrite whenever possible
    ALTER SESSION SET query_rewrite_integrity=stale_tolerated;
    ALTER SESSION SET query_rewrite_enabled = force;  
    
  -- Turn off rewrite for session   
    ALTER SESSION SET query_rewrite_enabled = false;  
    
  -- Turn on/off rewrite on MV
    -- Enable/Disable rewrite to the cube MV
    ALTER materialized VIEW cb$sales_cube disable query rewrite;
    ALTER materialized VIEW cb$sales_cube enable query rewrite;

-- ****************************************************************************
-- EXERCISE 4-3
--    Cube MVs:  Run this query to see if it rewrites
-- ****************************************************************************

  -- Quantity and Sales by Year, Department, Class and Country
    SELECT SUM(s.quantity) AS quantity,
           SUM(s.sales) AS sales,
           t.calendar_year_name,
           p.department_name,
           c.class_name,
           cu.country_name
    FROM  times t,
          products p,
          channels c,
          customers cu,
          sales_fact s
    WHERE s.product = p.item_key
      AND s.day_key = t.day_key
      AND s.channel = c.channel_key 
      AND s.customer = cu.customer_key
    GROUP BY p.department_name, t.calendar_year_name, c.class_name, cu.country_name;

begin
dbms_mview.explain_rewrite(
        '',
    'CB$SALES_CUBE', 'a1');
    end;
    /
      
