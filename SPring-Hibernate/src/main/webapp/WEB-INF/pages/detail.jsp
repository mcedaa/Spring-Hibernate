<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="shortcut icon" href="./../favicon.ico">
<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700'
	rel='stylesheet' type='text/css'>
<!-- Animate -->
<link rel="stylesheet" href="./../css/animate.css">
<!-- Icomoon -->
<link rel="stylesheet" href="./../css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="./../css/bootstrap.css">

<link rel="stylesheet" href="./../css/style.css">


<!-- Modernizr JS -->
<script src="./../js/modernizr-2.6.2.min.js"></script>

</head>
<body>
	<input type="text" hidden style="" value="${id}" id=id />
	<div id="fh5co-offcanvas">
		<a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i
				class="icon-cross3"></i> <span>Kapat</span></span></a>
		<div class="fh5co-bio">
			<figure>
				<img src="./../images/person1.jpg"
					alt="Free HTML5 Bootstrap Template" class="img-responsive">
			</figure>
			<h3 class="heading">Hakkımda</h3>
			<h2>Edanur Yetiş</h2>
			<p>Bilgisayar Mühendisiyim. Web ve Mobil uygulama
				geliştirmekteyim.</p>
			<ul class="fh5co-social">
				<li><a href="#"><i class="icon-twitter"></i></a></li>
				<li><a href="#"><i class="icon-facebook"></i></a></li>
				<li><a href="#"><i class="icon-instagram"></i></a></li>
			</ul>
		</div>

	</div>

	<!-- END #fh5co-offcanvas -->
	<header id="fh5co-header">

		<div class="container-fluid">

			<div class="row">
				<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>

				<div class="col-lg-12 col-md-12 text-center">
					<h1 id="fh5co-logo">NOTUM</h1>
				</div>

			</div>

		</div>

	</header>
	<!-- END #fh5co-header -->
	<div class="container-fluid">
		<div class="row fh5co-post-entry single-entry">
			<article
				class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">

				<h2 class="fh5co-article-title animate-box">Not Başlığı</h2>


				<div
					class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
					<h2 class="fh5co-article-title animate-box">
						<input type="text" id="note_title" placeholder="Başlık"
							disabled="disabled">
					</h2>

					<div
						class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
						<div class="row">
							<div class="col-lg-8 cp-r animate-box">
								<textarea class="form form-control" id="note_detail"
									style="height: 400px; width: 100%; cursor: default;"
									placeholder="İçerik" disabled="disabled"></textarea>
							</div>
							<div class="col-lg-4 animate-box">
								<div class="fh5co-highlight right">

									<button class="btn btn-info" style="width: 100%"
										onclick="update()" id="updateBtn">Güncelle</button>
									</br>
									<button class="btn btn-danger" style="width: 100%"
										onclick="deleteNote()">Sil</button>
									<!-- verdiğimiz id updateBtn u detail.js sayfasında kullandık -->
								</div>
							</div>
						</div>

					</div>

				</div>
			</article>
		</div>
	</div>

	<footer id="fh5co-footer">
		<p>
			<small>&copy; 2018.</small>
		</p>
	</footer>

	<!-- jQuery -->
	<script src="./../js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="./../js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="./../js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="./../js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="./../js/main.js"></script>
	<script src="./../js/detail.js"></script>

</body>
</html>



