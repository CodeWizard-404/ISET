-- ****************************************************************************
-- PRACTICE SOLUTION for 7-3
--
  --     A forecast has been created using OLAP's statistical forecast capabilities.
  --     The forecast is computed at a higher level than the actual sales data -
  --     and it is not dimensioned by CHANNEL. Therefore, FORECAST is in a separate cube.
  --
  --     The CROSS_OVER measures in the SALES cube display actual sales for
  --     historical data and forecast data for future time periods.
  --
  --     Note: no join is required to display SALES and FORECAST data together
  --     using the CROSS_OVER calculation. The cube merges the data w/o 
  --     requiring joins through the calculation.
  
  SELECT c.long_description as channel,
         p.long_description as product,                   
         t.long_description as time,
         round(s.sales) as sales,
         round(s.cross_over_best_fit, 0) as best_fit,
         round(s.cross_over_linear_regres, 0) as lin_reg
  FROM channel_sales_channel_view c,
       product_standard_view p,
       geography_regional_view g,
       time_calendar_view t,
       sales_cube_view s
  WHERE(c.dim_key = s.channel
   AND g.dim_key = s.geography
   AND p.dim_key = s.product
   AND t.dim_key = s.TIME 
   AND c.dim_key = 'ALL_CHANNELS'        -- The children of "ALL_CHANNELS"
   AND g.level_name = 'ALL_REGIONS'
   AND p.parent = 'ALL_PRODUCTS'        -- The children of "ALL_PRODUCTS"
   AND t.level_name = 'CALENDAR_QUARTER'
   AND t.calendar_year_long_descr in ('CY2007', 'CY2008'))
  ORDER BY channel, product, t.end_date;  

