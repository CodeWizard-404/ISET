-- ****************************************************************************
--
--    PRACTICES for Lesson 6
--
--    Querying views defined over an OLAP cube
--
-- ****************************************************************************
  -- 6-1: Replace the "??" with appropriate view names, column names, or column values
  --      

  SELECT ?? as dept,
         sales
  FROM ?? p,
       ?? s
  WHERE(p.dim_key = s.product
   AND p.level_name = '??'
   AND s.channel = '??'
   AND s.time = '??'
   AND s.geography = '??');
   
  -- ****************************************************************************
  -- 6-2: Replace the "??" with appropriate view names, column names, or column values
  --      
  SELECT c.?? as class,
         p.?? as dept,                   
         t.?? as qtr,
         round(s.sales) as sales
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.time 
   AND c.?? = '??'
   AND g.?? = '??'
   AND p.?? = '??'
   AND t.?? = '??'
   AND t.calendar_year_long_descr = 'CY2007')
  ORDER BY c.??, p.??, t.end_date;


  -- ****************************************************************************
  -- 6-3: 
  --      
  


  -- ****************************************************************************
  -- 6-4: 
  --      
  


  -- ****************************************************************************
  -- 6-5: 
  --      
  
  
  
  -- ****************************************************************************
  -- 6-6: 
  --      
  
  
