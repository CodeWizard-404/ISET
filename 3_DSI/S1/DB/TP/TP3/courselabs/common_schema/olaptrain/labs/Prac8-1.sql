-- ****************************************************************************
--
--    PRACTICE for Lesson 8
--
--    Query for APEX Interactive Report
--
-- ****************************************************************************
--      

 SELECT 
  g.long_description "Geography",
  p.long_description "Product",
  t.long_description "Time",
  trunc(sales) "Sales",
  trunc(sales_pp_pct_chg, 1)  "% Chg Pr Period",
  trunc(sales_py_pct_chg, 1)  "% Chg Pr Year",
  product_alert "Product Alert",  
  trunc(sales_ytd) "YTD",
  trunc(sales_ytd_py_pct_chg, 1)  "YTD % Chg Pr Year",      
  t.dim_key as time_dim_key,
  t.parent as time_parent,  
  t.end_date as end_date,
  g.parent as geography_parent,
  g.dim_key as geography_dim_key,
  p.parent as product_parent,
  p.dim_key as product_dim_key
FROM sales_cube_view s, time_calendar_view t, product_standard_view p, geography_regional_view g
WHERE s.time = t.dim_key
 AND s.product = p.dim_key
 AND s.geography = g.dim_key
 AND s.channel = 'ALL_CHANNELS' 
 AND t.parent = nvl(:P1_TIME, 'ALL_YEARS')
 AND g.parent = nvl(:P1_GEOGRAPHY, 'ALL_REGIONS')
 AND p.parent = nvl(:P1_PRODUCT, 'ALL_PRODUCTS')
 