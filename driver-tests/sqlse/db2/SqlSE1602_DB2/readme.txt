execute subquery on drivertest_emp
Query:

SELECT * FROM drivertest_emp WHERE deptid = (SELECT MAX(deptid) FROM drivertest_dept)

output:

<?xml version="1.0" encoding="UTF-8"?>
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://schemas.xmlsoap.org/soap/envelope/ http://schemas.xmlsoap.org/soap/envelope/" xmlns="http://com.sun.jbi/sqlse/sqlseengine">
<SOAP-ENV:Header/>
<SOAP-ENV:Body>
  <SubQueryResponse xmlns="http://com.sun.jbi/sqlse/sqlseengine">
    <EMPID>3</EMPID>
    <ENAME>kerry</ENAME>
    <DEPTID>3</DEPTID>
  </SubQueryResponse>
</SOAP-ENV:Body>
</SOAP-ENV:Envelope>