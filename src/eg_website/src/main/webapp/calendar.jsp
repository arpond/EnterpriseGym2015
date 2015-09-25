<!DOCTYPE html>
<html>
<head>
    <title>Calendar</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/calendar.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/WEB-INF/includes/scripts.jsp" %>
    
</head>
<body>
<div class="page-header">

		<div class="pull-right form-inline">
			<div class="btn-group">
				<button class="btn btn-primary" data-calendar-nav="prev"><< Prev</button>
				<button class="btn" data-calendar-nav="today">Today</button>
				<button class="btn btn-primary" data-calendar-nav="next">Next >></button>
			</div>
			<div class="btn-group">
				<button class="btn btn-warning" data-calendar-view="year">Year</button>
				<button class="btn btn-warning active" data-calendar-view="month">Month</button>
				<button class="btn btn-warning" data-calendar-view="week">Week</button>
				<button class="btn btn-warning" data-calendar-view="day">Day</button>
			</div>
		</div>
	</div>

    <div id="calendar"></div>

    <script type="text/javascript" src="js/BootstrapCalendar/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/BootstrapCalendar/underscore-min.js"></script>
    <script type="text/javascript" src="/eg_website/js/BootstrapCalendar/calendar.js"></script>
    <script type="text/javascript" src="js/BootstrapCalendar/app.js"></script>
    <script type="text/javascript">
        var calendar = $("#calendar").calendar(
            {
                tmpl_path: "/eg_website/js/BootstrapCalendar/tmpls/",
                events_source: function () { return []; }
            });         
    </script>
    
    <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
</body>
</html>