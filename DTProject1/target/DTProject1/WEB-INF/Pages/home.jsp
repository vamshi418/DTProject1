<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style type="text/css">
		p {
		   margin: 0 0 10px;
   		   font-size: 20px;
    	   color: white;
		  }
		</style>
		<%@ include file='header.jsp' %>

	<title>Project</title>
  </head>
	<body> 
			<div class="container-fluid">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
            	<!-- Indicators -->
            	<ol class="carousel-indicators">
                	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                	<li data-target="#myCarousel" data-slide-to="1"></li>
                	<li data-target="#myCarousel" data-slide-to="2"></li>
                   	<li data-target="#myCarousel" data-slide-to="3"></li>
            	</ol>
            	<div class="carousel-inner" role="listbox">
                	<div class="item active">
                    	<img src="resources/images/img11.png" alt="first slide" >
                    	<div class="container">
                        	<div class="carousel-caption">
                            	<h1></h1>
                            	<p>Play is the only way the highest intelligence of human kind can unfold.</p>
                        	</div>
                    	</div>
                	</div>
                	<div class="item">
                    	<img  src="resources/images/img12.png" alt="Second slide">
                    	<div class="container">
                        	<div class="carousel-caption">
                            	<h1></h1>
                            <p>Champions keep playing until they get it right.</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img src="resources/images/img13.png" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1></h1>
                            <p>The pain you feel today will be the STRENGTH you feel tomorrow</p>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img src="resources/images/img14.png" alt="forth slide">
                    <div class="container">
                        <div class="carousel-caption">
                            <h1></h1>
                            <p>Concentration comes out of a combination of confidence and hunger</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->

		</div>
		<br>		
		<%@ include file='footer.jsp' %>
	
			
</body>
</html>