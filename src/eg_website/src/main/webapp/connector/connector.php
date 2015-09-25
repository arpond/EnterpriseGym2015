<?php 
require_once("/connector/scheduler_connector.php");
 
$res=mysql_connect("46.101.32.81:3306","root","teameight");
mysql_select_db("eg_database");
 
$conn = new SchedulerConnector($res);
 
$conn->render_table("eg_calender_events","eventID","start_date,end_date,text");
?>