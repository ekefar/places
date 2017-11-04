<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <#include "common/meta.ftl">

    <title>Home - Stores List</title>

    <#include "common/styles.ftl">

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(/img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">
    <!-- HEADER -->

    <#include "common/header.ftl"/>


    <!-- BANNER SECTION -->
    <section class="clearfix homeBanner banner-image">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="banerInfo">
                        <h1>Explore. Discover. Gamble.</h1>
                        <p>We will help to find the best stores around you</p>
                    </div>£
                </div>
            </div>
        </div>
    </section>

    <!-- INTEREST SECTION -->
    <section class="clearfix interestArea">
        <div class="container">
            <div class="page-header text-center">
                <h2>Choose where you are? <small>Select your country to reveal best stores in your location</small></h2>
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
                    <a href="/northern-ireland/" class="interestContent country-flag">
					<span>
                        <i class="icon-listy flag-icon flag-icon-gb-nir"></i>
						Northern Ireland
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
