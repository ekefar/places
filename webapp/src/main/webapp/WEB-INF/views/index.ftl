<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <#include "common/meta.ftl">

    <title>Home - Casinos List</title>

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
    <section class="clearfix homeBanner banner-image">
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
                <h2>Choose where you are? <small>Select your country to reveal best casinos in your location</small></h2>
            </div>
            <div class="row">
                <div class="col-sm-3 col-xs-12">
                    <a href="/england/" class="interestContent country-flag">
					<span>
						<i class="icon-listy flag-icon flag-icon-gb-eng"></i>
						England
					</span>
                    </a>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <a href="/wales/" class="interestContent country-flag">
					<span>
						<i class="icon-listy flag-icon flag-icon-gb-wls"></i>
						Wales
					</span>
                    </a>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <a href="/scotland/" class="interestContent country-flag">
					<span>
						<i class="icon-listy flag-icon flag-icon-gb-sct"></i>
						Scotland
					</span>
                    </a>
                </div>
                <div class="col-sm-3 col-xs-12">
                    <a href="/north-ireland/" class="interestContent country-flag">
					<span>
                        <i class="icon-listy flag-icon flag-icon-gb-nir"></i>
						North Ireland
					</span>
                    </a>
                </div>

            </div>
        </div>
    </section>

    <!-- TOP SECTION -->
    <#include "top-places.ftl">


    <!-- FOOTER -->
    <#include "common/footer.ftl">
</div>

<#include "common/scripts.ftl">
</body>

</html>
