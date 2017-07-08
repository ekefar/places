<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home - Listty</title>

    <#include "common/styles.ftl">

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">
    <!-- HEADER -->
    <header id="pageTop" class="header">

        <!-- TOP INFO BAR -->

        <div class="nav-wrapper">

            <!-- NAVBAR -->
            <nav id="menuBar" class="navbar navbar-default lightHeader" role="navigation">
                <div class="container">

                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="index.html"><img src="img/logo.png" alt="logo"></a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse navbar-ex1-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class=""><a href="/">Home</a></li>
                            <li class=""><a href="#">List</a></li>
                            <li class=""><a href="#">About</a></li>
                            <li class=""><a href="#">Contact</a></li>
                        </ul>
                    </div>

                </div>
            </nav>
        </div>
    </header>


    <!-- BANNER SECTION -->
    <section class="clearfix homeBanner" style="background-image: url(img/banner/banner1.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="banerInfo">
                        <h1>Explore. Discover. Gamble.</h1>
                        <p>We will help to find the best casinos around you</p>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- INTEREST SECTION -->
    <section class="clearfix interestArea">
        <div class="container">
            <div class="page-header text-center">
                <h2>Choose were you are? <small>Select your country to reveal best casinos in your location</small></h2>
            </div>
            <div class="row">
                <div class="col-sm-3 col-xs-12">
                    <a href="/uk/" class="interestContent">
					<span>
						<i class="icon-listy icon-tea-cup-1"></i>
						England
					</span>
                    </a>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <a href="/north-ireland/" class="interestContent">
					<span>
						<i class="icon-listy icon-building"></i>
						North Ireland
					</span>
                    </a>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <a href="/scotland/" class="interestContent">
					<span>
						<i class="icon-listy icon-martini"></i>
						Scotland
					</span>
                    </a>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <a href="/welse/" class="interestContent">
					<span>
						<i class="icon-listy icon-car-1"></i>
						Welse
					</span>
                    </a>
                </div>

            </div>
        </div>
    </section>

    <!-- THINGS SECTION -->
    <section class="clearfix thingsArea">
        <div class="container">
            <div class="page-header text-center">
                <h2>Top casinos<small>These are some of the most popular casinos in UK</small></h2>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <div id="thubmnailSlider" class="carousel slide thumbnailCarousel">

                        <ol class="carousel-indicators">
                            <li data-target="#thubmnailSlider" data-slide-to="0" class="active"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="1"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="2"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="3"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="4"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="5"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="6"></li>
                            <li data-target="#thubmnailSlider" data-slide-to="7"></li>
                        </ol>

                        <!-- Carousel items -->
                        <div class="carousel-inner">

                            <div class="item row active">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-1.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater <i class="fa fa-check-circle" aria-hidden="true"></i></h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-list-left.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-2.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater</h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-grid-full.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-3.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater <i class="fa fa-check-circle" aria-hidden="true"></i></h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-grid.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-1.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater</h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-grid-full.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-2.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater <i class="fa fa-check-circle" aria-hidden="true"></i></h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-list-right.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-3.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater</h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-grid-full.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-1.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater <i class="fa fa-check-circle" aria-hidden="true"></i></h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-grid.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="item row">
                                <div class="col-md-4 col-sm-6 col-xs-12">
                                    <div class="thingsBox">
                                        <div class="thingsImage">
                                            <img src="img/things/things-2.jpg" alt="Image things">
                                            <div class="thingsMask">
                                                <ul class="list-inline rating">
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                                </ul>
                                                <a href="blog-details.html"><h2>The City Theater</h2></a>
                                                <p>10 Bay Street Toronto Ontario Canada</p>
                                            </div>
                                        </div>
                                        <div class="thingsCaption ">
                                            <ul class="list-inline captionItem">
                                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                                                <li><a href="category-list-full.html">Hotel, Restaurant</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <a class="left carousel-control" href="#thubmnailSlider" data-slide="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
                        <a class="right carousel-control" href="#thubmnailSlider" data-slide="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- FOOTER -->
    <#include "common/footer.ftl">
</div>


<!-- JAVASCRIPTS -->
<script src="/plugins/jquery/jquery.min.js"></script>
<script src="/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/plugins/smoothscroll/SmoothScroll.min.js"></script>
<script src="/plugins/waypoints/waypoints.min.js"></script>
<script src="/plugins/counter-up/jquery.counterup.min.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.min.js"></script>
<script src="/plugins/selectbox/jquery.selectbox-0.1.3.min.js"></script>
<script src="/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="/plugins/isotope/isotope.min.js"></script>
<script src="/plugins/fancybox/jquery.fancybox.pack.js"></script>
<script src="/plugins/isotope/isotope-triger.min.js"></script>
<!--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEDfNcQRmKQEyulDN8nGWjLYPm8s4YB58"></script>-->
<script src="/plugins/map/js/rich-marker.js"></script>
<script src="/plugins/map/js/infobox_packed.js"></script>
<script src="/js/single-map.js"></script>
<script src="/js/map.js"></script>
<script src="/js/custom.js"></script>

</body>

</html>
