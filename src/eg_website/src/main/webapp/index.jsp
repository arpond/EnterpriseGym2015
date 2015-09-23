<%-- 
    Document   : normalIndex
    Created on : 23-Sep-2015, 10:41:24
    Author     : Katerina
--%>

<html lang="en">

<head>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Home</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/modern-business.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

</head>

<body>

   <%@include file="includes/normalHeader.jsp" %>
   <!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <div class="fill" style="background-image:url('https://enterprise-gym.com/sites/default/files/TEG_Logo_07crop.png')";></div>
                <div class="carousel-caption">
                    <h2></h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('https://www.enterprise-gym.com/sites/default/files/images/team%20under%20construction1.png');"></div>
                <div class="carousel-caption">
                    <h2></h2>
                </div>
            </div>
            <div class="item">
                <div class="fill" style="background-image:url('http://enterprise-gym.com/sites/default/files/banner.jpg');"></div>
                <div class="carousel-caption">
                    <h2></h2>
                </div>
            </div>
        </div>


        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>

    <!-- Page Content -->
    <div class="container">
      
   
        <!-- Portfolio Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">Upcoming Events</h2>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="event1.png" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="event2.png" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="event3.png" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="event4.png" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="event5.png" alt="">
                </a>
            </div>
            <div class="col-md-4 col-sm-6">
                <a href="portfolio-item.html">
                    <img class="img-responsive img-portfolio img-hover" src="event6.png" alt="">
                </a>
            </div>
        </div>
        <!-- /.row -->


        <hr>

       

		
		     <!-- Features Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">The Enterprise Gym</h2>
            </div>
            <div class="col-md-6">
           
           What is The Enterprise Gym all about? Some key words and sentences for you to set the scene:
              <ul>
                     <li>Enterprise & Entrepreneurship isn't all about business.</li>
                     <li>Enterprise = the application of creative ideas and innovations to practical situations.</li>
                     <li>Enterprise combines creativity, ideas development and problem solving with expression, communication and practical action.</li>
                     <li>An enterprising individual has a positive, flexible and adaptive disposition to change, seeing it as normal and as an opportunity rather than a problem.</li>
                     <li>An enterprising individual has the capacity to initiate creative ideas and develop them into action in a determined manner.</li>
                     <li>An enterprising individual is an effective communicator, negotiator, influencer, planner and organiser.</li>
                     <li>An enterprising individual is active, confident and purposeful ? not uncertain and dependent</li>
              </ul>
            </div>
            <div class="col-md-6">
                <img class="img-responsive" src="http://placehold.it/700x450" alt="">
            </div>
        </div>
        <!-- /.row -->

        <hr>
 
 <!-- Call to Action Section -->
        <div class="well">
            <div class="row">
                <div class="col-md-8">
                   Links to facebook, twitter any other social media.
                </div>
                <div class="col-md-4">
                    <a class="btn btn-lg btn-default btn-block" href="#">Search</a>
                </div>
            </div>
        </div>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    Team 7 &copy; Enterprise Website 2015
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>