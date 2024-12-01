-- ****************************************************************************
--
-- PRACTICE SOLUTIONS for Lesson 6
--
--    Querying views defined over an OLAP cube
--
-- ****************************************************************************
  -- Simple queries taken from BI EE. These queries illustrate the following:
  --      A) "Level" conditions are used to replace "group by".
  --      B) Aggregation occurs in cube and respects cube aggregation rules.
  --      C) No "sum/group by" is required for summary queries
  --      D) OLAP calculations are simply selected as 'data columns'
  -- ****************************************************************************
  --
  -- 6-1: Product and Sales are the only columns in query. "DEPARTMENT" is the  
  --      level name for Product. All other dimensions require an 'ALL' filter
  --      in order to leverage aggregations in the Cube.

  SELECT p.department_long_descript as dept,
         sales
  FROM PRODUCT_STANDARD_VIEW p,
       SALES_CUBE_VIEW s
  WHERE(p.dim_key = s.product
   AND p.LEVEL_NAME = 'DEPARTMENT'
   AND s.channel = 'ALL_CHANNELS'
   AND s.geography = 'ALL_REGIONS'
   AND s.time = 'ALL_YEARS');
  
  -- 6-2: A geography column is not in query, so "ALL_REGIONS" condition 
  --      must be added in order to leverage aggregation over geography.

  SELECT c.class_long_description as class,
         p.department_long_descript as dept,                   
         t.calendar_quarter_long_de as qtr,
         round(s.sales) as sales
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.TIME 
   AND c.level_name = 'CLASS'
   AND g.level_name = 'ALL_REGIONS'
   AND p.level_name = 'DEPARTMENT'
   AND t.level_name = 'CALENDAR_QUARTER'
   AND t.calendar_year_long_descr = 'CY2007')
  ORDER BY c.class_long_description, p.department_long_descript, t.end_date;
  
  -- ****************************************************************************
  -- 6-3:  Add calculations to previous query.
  --       Calculations exposed as columns and computed in cube.  
  --       Includes time series, year-to-date

  SELECT c.class_long_description as class,
         p.department_long_descript as dept,                   
         t.calendar_quarter_long_de as qtr,
         round(s.sales) as sales,                   -- sales 
         round(s.SALES_YTD) as ytd,                 -- sales year to date
         round(s.SALES_2006) as sales_2006,         -- sales for all of 2006
         round(s.TO_GO) as to_go,                   -- absolute sales required to achieve 2006 revenue.
                                                    -- This is based on year to date sales compared to 2006
         round(s.PCT_OF_2006) as Pct_of_2006,       -- ytd sales as a % of 2006 sales
         how_is_sales_ytd                           -- How is sales performing YTD (compared to last year)
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.TIME 
   AND c.level_name = 'CLASS'
   AND g.level_name = 'ALL_REGIONS'
   AND p.level_name = 'DEPARTMENT'
   AND t.level_name = 'CALENDAR_QUARTER'
   AND t.calendar_year_long_descr = 'CY2007')
  ORDER BY c.class_long_description, p.department_long_descript, t.end_date;
  
  -- ****************************************************************************
  -- 6-4: The cube/dimensions are represented as embedded totals. This makes it easy to
  --      show multiple levels of aggregation at the same time using a simple query.
  --      Here, we are showing different levels for time (month, quarter and year)
  --
  --      To simplify the query, notice that you can select from the long_description or short_description 
  --      columns for each dimension instead of the "level" description columns.
  --      This is the only other change required for the query - all the calculations work out perfectly
  
  SELECT c.long_description as channel,
         p.long_description as product,                   
         t.long_description as time,
         round(s.sales) as sales,
         round(s.SALES_YTD) as ytd,
         round(s.SALES_2006) as sales_2006,
         round(s.TO_GO) as to_go,
         round(s.PCT_OF_2006) as pct_of_2006,
         how_is_sales_ytd           
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.TIME 
   AND c.level_name = 'CLASS'
   AND g.level_name = 'ALL_REGIONS'
   AND p.level_name = 'DEPARTMENT'
   AND t.long_description in ('CY2007', 'Q3-CY2007', 'Nov-2007'))
  ORDER BY channel, product, t.end_date;  
  
  -- ****************************************************************************
  -- 6-5: The dimension views also include special hierarchy columns that make it easy
  --      to navigate the dimensions (e.g. drill down from 'All Years' to the 'Years'.
  --      Using the "parent" column for drilling allows you to drill down any type of
  --      of hierarchy:  level-based, ragged, skip-level or value-based.
  --
  --      The following query selects the "children" of "ALL_PRODUCTS" and "ALL_REGIONS"
  --      by applying a condition on the parent columns
  --      Note that the Channel dimension is now removed from the results.
  
  SELECT g.long_description as geography,
         p.long_description as product,                   
         t.long_description as time,
         round(s.sales) as sales,
         round(s.SALES_YTD) as ytd,
         round(s.SALES_2006) as sales_2006,
         round(s.TO_GO) as to_go,
         round(s.PCT_OF_2006) as pct_of_2006,
         how_is_sales_ytd    
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.TIME 
   AND g.parent = 'ALL_REGIONS'        -- The children of "ALL_REGIONS"
   AND c.level_name = 'ALL_CHANNELS'
   AND p.parent = 'ALL_PRODUCTS'        -- The children of "ALL_PRODUCTS"
   AND t.long_description in ('CY2007', 'Q3-CY2007', 'Nov-2007'))
  ORDER BY geography, product, t.end_date;  
  
  -- ****************************************************************************
  -- 6-6: Change the Time selection to a Parameterized "drill" using 'ALL_YEARS'
  --      Channel is added back into the results, and Geography is removed.
  --      Drill on Channel to return the children of  'ALL_CHANNELS'.

  SELECT c.long_description as channel,
         p.long_description as product,                   
         t.long_description as time,
         round(s.sales) as sales,
         round(s.SALES_YTD) as ytd,
         round(s.SALES_2006) as sales_2006,
         round(s.TO_GO) as to_go,
         round(s.PCT_OF_2006) as pct_of_2006,
         how_is_sales_ytd 
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.TIME 
   AND c.parent = 'ALL_CHANNELS'        -- The children of "ALL_CHANNELS"
   AND g.level_name = 'ALL_REGIONS'
   AND p.parent = 'ALL_PRODUCTS'        -- The children of "ALL_PRODUCTS"
   AND t.parent = nvl(:time_parent, 'ALL_YEARS'))
  ORDER BY channel, product, t.end_date; 

  -- ****************************************************************************
  -- 6-7: Aggregating over the Channel Type Attribute
  --      (A) Cube delivers summary data
  --      (B) Relational engine summarizes the cube data

  SELECT c.channel_type as chan_type,
         p.category_long_descriptio as category,
         t.calendar_quarter_long_de as qtr,
         sum(s.sales) as sales,     -- (B) Relational engine summarizes cube data
         sum(s.sales_ytd) as ytd    -- (B) Relational engine
  FROM channel_sales_channel_view c,
       product_standard_view p,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND p.dim_key = s.product
   AND t.dim_key = s.time          -- (A) Cube delivers summary data at Levels:
   AND c.level_name = 'CHANNEL'           -- Channel
   AND s.geography = 'ALL_REGIONS'        -- All Regions 
   AND p.level_name = 'CATEGORY'          -- Category
   AND t.level_name = 'CALENDAR_QUARTER'  -- Quarter
   )
  GROUP BY                         -- (B) Relational engine
    t.calendar_quarter_long_de,
    p.category_long_descriptio,
    c.channel_type;
