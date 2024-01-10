

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.demo.Note"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>BLOG</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="açıklama" />
<meta name="keywords" content="arama kelimeleri" />
<meta name="author" content="Edanur Yetiş" />



<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">
<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700'
	rel='stylesheet' type='text/css'>
<!-- Animate -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon -->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<link rel="stylesheet" href="css/style.css">


<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>

</head>
<body>
	<div id="fh5co-offcanvas">
		<a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i
				class="icon-cross3"></i> <span>Kapat</span></span></a>
		<div class="fh5co-bio">
			<figure>
				<img src="images/person1.jpg" alt="Free HTML5 Bootstrap Template"
					class="img-responsive">
			</figure>
			<h3 class="heading">Hakkımda</h3>
			<h2>${user.name} ${user.surname}</h2>
			<ul class="fh5co-social">
				<li><a href="logout">Çıkış</a></li>
			</ul>
		</div>

	</div>
	<!-- END #fh5co-offcanvas -->
	<header id="fh5co-header">

		<div class="container-fluid">

			<div class="row">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
				<ul class="fh5co-social">
					<li><a href="ekle"><i class="icon-note">Note ekle</i></a></li>

				</ul>
				<div class="col-lg-12 col-md-12 text-center">
					<h1 id="fh5co-logo">
						<a href="/">Not Alma</a>
					</h1>
				</div>

			</div>

		</div>

	</header>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry" id="list">
			<%-- 			<%
			    //List<Note> notlar = (List<Note>) request.getAttribute("notlar");
			    //if (notlar != null) {
			      //  for (Note note : notlar) {
			%>
			           <article class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
			              
			                <h2 class="fh5co-article-title"><a href="single.html"><%= note.getTitle() %></a></h2> 
			                <h3><a href="single.html"  style="color:#999999"><%= note.getContent() %></a></h3>
			                <span class="fh5co-meta fh5co-date">6 Mart 2016</span>
			            </article>
			<%
			        //}
			   // }
			%> --%>
			<article
				class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
				<span class="fh5co-meta"><a href="single.html">Teknoloji</a></span>
				<h2 class="fh5co-article-title">
					<a href="single.html">Blog Başlığı</a>
				</h2>
				<h3>
					<a href="single.html" style="color: #999999">Lorem ipsum dolor
						sit amet, consectetur adipiscing elit, sed do eiusmod tempor
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
						voluptate velit esse cillum</a>
				</h3>
				<span class="fh5co-meta fh5co-date">6 Mart 2016</span>
			</article>
			<article
				class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
				<span class="fh5co-meta"><a href="single.html">Teknoloji</a></span>
				<h2 class="fh5co-article-title">
					<a href="single.html">Blog Başlığı</a>
				</h2>
				<h3>
					<a href="single.html" style="color: #999999">Lorem ipsum dolor
						sit amet, consectetur adipiscing elit, sed do eiusmod tempor
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
						voluptate velit esse cillum</a>
				</h3>
				<%
				String data = "Merhaba, dünya!";
				%>
				<%= data %>
			</article>
			<article
				class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
				<span class="fh5co-meta"><a href="single.html">Teknoloji</a></span>
				<h2 class="fh5co-article-title">
					<a href="single.html">Blog Başlığı</a>
				</h2>
				<h3>
					<a href="single.html" style="color: #999999">Lorem ipsum dolor
						sit amet, consectetur adipiscing elit, sed do eiusmod tempor
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
						voluptate velit esse cillum</a>
				</h3>
				<span class="fh5co-meta fh5co-date">6 Mart 2016</span>
			</article>
			<article
				class="col-lg-3 col-md-3 col-sm-3 col-xs-6 col-xxs-12 animate-box">
				<span class="fh5co-meta"><a href="single.html">Teknoloji</a></span>
				<h2 class="fh5co-article-title">
					<a href="single.html">Blog Başlığı</a>
				</h2>
				<h3>
					<a href="single.html" style="color: #999999">Lorem ipsum dolor
						sit amet, consectetur adipiscing elit, sed do eiusmod tempor
						incididunt ut labore et dolore magna aliqua. Ut enim ad minim
						veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip
						ex ea commodo consequat. Duis aute irure dolor in reprehenderit in
						voluptate velit esse cillum</a>
				</h3>
				<span class="fh5co-meta fh5co-date">6 Mart 2016</span>
			</article>

		</div>
	</div>

	<footer id="fh5co-footer">
		<p>
			<small>&copy; 2018.</small>
		</p>
	</footer>



	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="js/main.js"></script>

	<script src="js/index.js"></script>

</body>
</html>

