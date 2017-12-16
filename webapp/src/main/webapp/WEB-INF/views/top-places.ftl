<section class="clearfix thingsArea">
    <div class="container">


    <#-- ENGLAND BEST PLACES-->
        <div class="page-header text-center">
            <h2>Top stores in England
                <small>These are some of the most popular stores in England</small>
            </h2>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div id="england-best-carousel">
                    <#list englandTop as place>
                        <div>
                            <div class="img-wrap">
                                <a href="/place/${place.id}/">
                                    <img src="${place.thumbnailUrl}" class="img-responsive" alt="workimg">
                                </a>
                            </div>
                            <div class="place-description">
                                <h3><a href="/place/${place.id}/"
                                       style="color: #222222">${place.name}</a></h3>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>

    <#-- IRELAND BEST PLACES-->
        <br><br><br>
        <div class="page-header text-center">
            <h2>Top stores in Northern Ireland
                <small>These are some of the most popular stores in Northern Ireland</small>
            </h2>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div id="ireland-best-carousel">
                    <#list northernIrelandTop as place>
                        <div>
                            <div class="img-wrap">
                                <a href="/place/${place.id}/">
                                    <img src="${place.thumbnailUrl}" class="img-responsive" alt="workimg">
                                </a>
                            </div>
                            <div class="place-description">
                                <h3><a href="/place/${place.id}/"
                                       style="color: #222222">${place.name}</a></h3>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>

    <#-- WALES BEST PLACES-->
        <br><br><br>
        <div class="page-header text-center">
            <h2>Top stores in Wales
                <small>These are some of the most popular stores in Wales</small>
            </h2>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div id="wales-best-carousel">
                    <#list walesTop as place>
                        <div>
                            <div class="img-wrap">
                                <a href="/place/${place.id}/">
                                    <img src="${place.thumbnailUrl}" class="img-responsive" alt="workimg">
                                </a>
                            </div>
                            <div class="place-description">
                                <h3><a href="/place/${place.id}/"
                                       style="color: #222222">${place.name}</a></h3>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    </div>

<#-- SCOTLAND BEST PLACES-->
    <br><br><br>
    <div class="page-header text-center">
        <h2>Top stores in Scotland
            <small>These are some of the most popular stores in Scotland</small>
        </h2>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div id="scotland-best-carousel">
                <#list scotlandTop as place>
                    <div>
                        <div class="img-wrap">
                            <a href="/place/${place.id}/">
                                <img src="${place.thumbnailUrl}" class="img-responsive" alt="workimg">
                            </a>
                        </div>
                        <div class="place-description">
                            <h3><a href="/place/${place.id}/"
                                   style="color: #222222">${place.name}</a></h3>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>

</section>
