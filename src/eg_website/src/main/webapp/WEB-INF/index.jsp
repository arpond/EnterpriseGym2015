<%-- 
    Document   : normalIndex
    Created on : 23-Sep-2015, 10:41:24
    Author     : Katerina
--%>
<%@page import="uk.ac.dundee.team7.eg_website.Store.EventStore"%>
<%@page import="java.util.*" %>
<html lang="en">

    <head>
        <%@include file="/WEB-INF/includes/scripts.jsp" %>
        <title>Home</title>
    </head>

    <body>
        <%@include file="/WEB-INF/includes/normalHeader.jsp" %>
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
                    <div class="fill" style="background-image:url('https://enterprise-gym.com/sites/default/files/TEG_Logo_07crop.png');">
                    </div>
                    <div class="carousel-caption">
                        <h2></h2>
                    </div>
                </div>
                
                <div class="item">
                    <div class="fill" style="background-image:url('https://www.enterprise-gym.com/sites/default/files/images/team%20under%20construction1.png');">   
                    </div>
                    <div class="carousel-caption">
                        <h2></h2>
                    </div>
                </div>
                
                <div class="item">
                    <div class="fill" style="background-image:url('http://enterprise-gym.com/sites/default/files/banner.jpg');">
                        
                    </div>
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
                <%
                    ArrayList<EventStore> events = (ArrayList<EventStore>) request.getAttribute("events");

                    for (int i = 0; (i < events.size() && i < 3); i++) {
                        EventStore es = events.get(i);
                %>
                
                    <div class="col-md-4 col-sm-12">
                        <a href="/eg_website<%=es.getContent().getContentPath()%>">
                            <img class="img-responsive img-portfolio img-hover" src="<%=es.getEventImage()%>"  style="height:auto; width:auto; max-height:150px; max-width:250px; display:block; margin-left:auto; margin-right:auto; ">
                        </a>
                        <div>
                            <p><%=es.getContent().getContentSummary()%></p>
                        </div>
                    </div>
                    <%
                        }
                    %>
               
            </div>
            <!-- /.row -->


            <br><br>

        <!-- Portfolio Section -->
            <div class="row">
                
                <%
                    for (int i = 4; ( i < 7); i++) {
                        EventStore es = events.get(i);
                %>
                
                    <div class="col-md-4 col-sm-12">
                        <a href="/eg_website<%=es.getContent().getContentPath()%>">
                            <img class="img-responsive img-portfolio img-hover" src="<%=es.getEventImage()%>"  style="height:auto; width:auto; max-height:150px; max-width:250px; display:block; margin-left:auto; margin-right:auto; ">
                        </a>
                        <div>
                            <p><%=es.getContent().getContentSummary()%></p>
                        </div>
                    </div>
                    <%
                        }
                    %>
               
            </div>
            <!-- /.row -->

            </div>
         
               
                <hr>
                <br>
               
              
             <div class="kat" style="margin-left:auto; margin-right:auto; max-width:900px;"> 
                 <h2>The Enterprise Gym</h2><br>
                
                       <p>The Enterprise Gym, is managed by students for students and supported by our experienced business patrons, 
                  runs free workshops and events to develop your enterprise skills and commercial awareness. Being able to 
                  demonstrate that you have some enterprising attributes is great whether you are applying for jobs 
                  or thinking of starting your own enterprise. Key transferable skills can really help make you stand out.</p><br>
                  
                  
                 <p>The Enterprise Gym was created by the University of Dundee in 2005 in response to government 
                 concern over graduate "business readiness". Its mission is to help students from all disciplines 
                 to improve their enterprise skills, self-reliance and employability through engaging with business 
                 enterprise and developing entrepreneurial skills. Key to this is the deep involvement and support of the business
                 community helping to deliver learning that is fun, interactive and rewarding.</p>
              
             </div>       
                    <hr>
                    
                    
                    </body>

            <!-- Features Section -->
            <footer>
                 <!-- Footer -->
            <%@include file="/WEB-INF/includes/normalFooter.jsp" %>
            
            </footer>
            <!-- /.row -->

       
        
        
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

   

</html>