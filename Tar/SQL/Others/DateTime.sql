-- Converting date to other date and time types

DECLARE @date date = '12-10-2025';  
DECLARE @datetime datetime = @date;  
  
SELECT @date AS '@date', @datetime AS '@datetime';  
  
--Result  
--@date      @datetime  
------------ -----------------------  
--2025-12-10 2025-12-10 00:00:00.000  
--  
--(1 row(s) affected)

-------*******-------

-- The following example compares the results of casting a string to each date and time data type.

SELECT   
     CAST('2007-05-08 12:35:29. 1234567 +12:15' AS time(7)) AS 'time'   
    ,CAST('2007-05-08 12:35:29. 1234567 +12:15' AS date) AS 'date'   
    ,CAST('2007-05-08 12:35:29.123' AS smalldatetime) AS 'smalldatetime'   
    ,CAST('2007-05-08 12:35:29.123' AS datetime) AS 'datetime'   
    ,CAST('2007-05-08 12:35:29. 1234567 +12:15' AS datetime2(7)) AS 'datetime2'  
    ,CAST('2007-05-08 12:35:29.1234567 +12:15' AS datetimeoffset(7)) AS 'datetimeoffset';

/*
Data type		Output
time			12:35:29. 1234567
date			2007-05-08
smalldatetime	2007-05-08 12:35:00
datetime		2007-05-08 12:35:29.123
datetime2		2007-05-08 12:35:29.1234567
datetimeoffset	2007-05-08 12:35:29.1234567 +12:15
*/