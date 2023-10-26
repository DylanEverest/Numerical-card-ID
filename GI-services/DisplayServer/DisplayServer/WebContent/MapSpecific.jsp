<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- leaflet css and leaflet js  -->
        <link rel="stylesheet" href="LeafletDep/leaflet.css" />
        <link rel="stylesheet" href="css/app.css">
        <!--====== Vendor Css ======-->
        <link rel="stylesheet" href="css/vendor.css">

        <!--====== Utility-Spacing ======-->
        <link rel="stylesheet" href="css/utility.css">

        <script src="LeafletDep/leaflet.js"></script>

        <title>Map</title>
    </head>

    <style>
    </style>

    <body>
        <div id="app">
            <header class="header--style-1 header--box-shadow">
                <nav class="primary-nav primary-nav-wrapper--border">
                    <div class="container">
                        <div class="primary-nav">
                            <h1> Properties</h1>
                        </div>
                    </div>
                </nav>

            </header>
            <main>
                <div id="empty">

                </div>
                <div id="containermap">

                    <div id="map"></div>
                    <div class="u-s-p-b-60" id="inputmap">

                        <!--====== Section Content ======-->
                        <div class="section__content">
                            <div class="dash">
                                <div class="container">
                                    <div class="row">

                                        <div class="col-lg-9 col-md-12">
                                            <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white">
                                                <div class="dash__pad-2">

                                                    <div class="rowlaitude" style="display: flex;">

                                                        <h1 class="dash__h1 u-s-m-b-14">Enter latitude and longitude</h1>

                                                        <button class="btn btn--e-brand-b-2" id="additems" type="submit">Add more</button>
                                                        <button class="btn btn--e-brand-b-2" id="deleteitems" type="submit">Delete</button>
                                                        <button class="btn btn--e-brand-b-2" id="refreshitems" type="submit">Refresh</button>
                                                    </div>

                                                    <span class="dash__text u-s-m-b-30">Search information</span>
                                                    <form class="dash-address-manipulation" method="GET" action="./treatmentMap/InsertProperty.jsp">
                                                        <div class="gl-inline">
                                                            <div class="u-s-m-b-30">
                                                              <label class="gl-label" for="latitude">Adress *</label>
                                                              <input name="Adress" class="input-text input-text--primary-style" type="text" id="latitude" placeholder="Card ID" value="undefined">
                                                            </div>

                                                          </div>
                                                        <button class="btn btn--e-brand-b-2" type="submit">INSERT</button>

                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--====== End - Section Content ======-->
                    </div>

                </div>
            
            </main>
            <footer>
            </footer>
        </div>


    </body>

    <script  src="js/Map/Map.js"></script>

    <%=  %>
</html>