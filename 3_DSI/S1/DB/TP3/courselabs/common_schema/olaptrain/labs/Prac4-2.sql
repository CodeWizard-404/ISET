-- ****************************************************************************
-- **  PRACTICE 4-2
-- ****************************************************************************
--    Cube MVs:  Query a fact table w/ and w/o query rewrite
-- ****************************************************************************

--     To turn on/off query rewrite for this session only.  
--     Run the queries (F9) and view explain plans (F6) with rewrite enabled and disabled

--     To turn on/off rewrite across database sessions, run the "ALTER materialized view"
--     command below. Rewrite is turned on by default.

  -- Rewrite whenever possible
    ALTER SESSION SET query_rewrite_integrity=stale_tolerated;
    ALTER SESSION SET query_rewrite_enabled = force;  
    
  -- Turn off rewrite for session   
    ALTER SESSION SET query_rewrite_enabled = false;  
    
  -- Turn on/off rewrite on MV
    -- Enable/Disable rewrite to the cube MV
    ALTER materialized VIEW cb$sales_cube disable query rewrite;
    ALTER materialized VIEW cb$sales_cube enable query rewrite;

--   Example queries are below were captured from a BI EE ad-hoc query session

-- 1. Quantity and Sales by Year and Product Group
    SELECT SUM(s.quantity) AS quantity,
           SUM(s.sales) AS sales,
           t.calendar_year_name,
           p.category_name
    FROM  times t,
          products p,
          sales_fact s
    WHERE p.item_key = s.product
      AND s.day_key = t.day_key
    GROUP BY p.category_name, t.calendar_year_name;

-- 2. Quantity and Sales by Year, Department, Class and Country
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
    WHERE p.item_key = s.product
      AND s.day_key = t.day_key
      AND s.channel = c.channel_key 
      AND s.customer = cu.customer_key
    GROUP BY p.department_name, t.calendar_year_name, c.class_name, cu.country_name;

-- 3. Quantity and Sales by Year, Category, Class and Region
    SELECT SUM(s.quantity) AS quantity,
           SUM(s.sales) AS sales,
           t.calendar_year_name,
           p.category_name,
           c.class_name,
           cu.region_name
    FROM  times t,
          products p,
          channels c,
          customers cu,
          sales_fact s
    WHERE p.item_key = s.product
      AND s.day_key = t.day_key
      AND s.channel = c.channel_key 
      AND s.customer = cu.customer_key
    GROUP BY p.category_name, t.calendar_year_name, c.class_name, cu.region_name;    
    
      
-- 4. Quantity & Sales by Year, Department, and Region
    SELECT  SUM(s.quantity) AS quantity,
            SUM(s.sales) AS sales,
            t.calendar_year_name,
            p.department_name,
            cu.region_name
    FROM  times t,
          customers cu,
          products p,
          sales_fact s
    WHERE(cu.customer_key = s.customer
     AND p.item_key = s.product
     AND s.day_key = t.day_key
    )
    GROUP BY cu.region_name, p.department_name, t.calendar_year_name;
  
