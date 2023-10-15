 
<html lang=""><head>
        <meta charset="UTF-8">
        <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge"><![endif]-->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="images/favicon.png" rel="shortcut icon">
        <title>Ludus - Electronics, Apparel, Computers, Books, DVDs &amp; more</title>

        <!--====== Google Font ======-->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800" rel="stylesheet">

        <!--====== Vendor Css ======-->
        <link rel="stylesheet" href="css/vendor.css">

        <!--====== Utility-Spacing ======-->
        <link rel="stylesheet" href="css/utility.css">

        <!--====== App ======-->
        <link rel="stylesheet" href="css/app.css">
    </head>
    <body>
        <div id="app">
            <header class="header--style-1 header--box-shadow">
                <nav class="primary-nav primary-nav-wrapper--border">
                    <div class="container">
                        <div class="primary-nav">
                            <!-- logo -->

                            <!-- params -->
                            <div class="menu-init" id="navigation">
                                <div class="ah-lg-mode">
                                    <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                                        <li class="has-dropdown" data-tooltip="tooltip" data-placement="left" title="" data-original-title="Account">
                                            <a>
                                                <i class="far fa-user-circle"></i>
                                            </a>
                                            <span class="js-menu-toggle"></span>
                                            <ul style="width:120px">
                                                <li>
                                                    <a href="signup.html"><i class="fas fa-user-plus u-s-m-r-6"></i>
                                                        <span>Signup</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="signin.html"><i class="fas fa-lock u-s-m-r-6"></i>
                                                        <span>Signin</span>
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="signup.html"><i class="fas fa-lock-open u-s-m-r-6"></i>
                                                        <span>Signout</span>
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                    </ul>

                                </div>
                            </div>

                        </div>
                    </div>
                </nav>
                <nav class="secondary-nav-wrapper">
                    <div class="container">
                        <div class="secondary-nav">
                            <div class="menu-init" id="navigation1">
                                <div class="ah-lg-mode">
                                </div>
                            </div>
                            <div class="menu-init" id="navigation2">
                                <div class="ah-lg-mode">
                                    <ul class="ah-list ah-list--design2 ah-list--link-color-secondary">
                                        <li>
                                            <a href="shop-side-version-2.html">MAIN</a>
                                        </li>
                                        <li class="has-dropdown">
                                            <a>PAGES<i class="fas fa-angle-down u-s-m-l-6"></i></a>
                                            <span class="js-menu-toggle"></span>
                                            <ul style="width:170px">
                                                <li>

                                                    <a href="about.html">About us</a></li>
                                                <li>

                                                    <a href="contact.html">Contact</a></li>
                                                <li>

                                                    <a href="404.html">404</a></li>
                                            </ul>
                                        </li>
                                        <li class="has-dropdown">
                                            <a>EXTRAS<i class="fas fa-angle-down u-s-m-l-6"></i></a>
                                            <span class="js-menu-toggle"></span>
                                            <ul style="width:200px">
                                                <li>
                                                    <a href="blog-masonry.html">Blog Masonry</a>
                                                </li>
                                                <li>
                                                    <a href="blog-detail.html">Blog Details</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li>
                                            <a href="shop-side-version-2.html">CONTACT</a>
                                        </li>
                                        <li>

                                            <a href="shop-side-version-2.html">ABOUT US</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="menu-init" id="navigation3">
                                <button class="btn btn--icon toggle-button toggle-button--secondary fas fa-shopping-bag toggle-button-shop" type="button"></button>
                                <span class="total-item-round">2</span>
                                <div class="ah-lg-mode">
                                    <ul class="ah-list ah-list--design1 ah-list--link-color-secondary">
                                        <li>
                                            <a href="index.html"><i class="fas fa-home u-c-brand"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </header>
            <main>
                <div class="app-content">
                    <div class="u-s-p-y-60">
                        <div class="section__content">
                            <div class="container">
                                <div class="breadcrumb">
                                    <div class="breadcrumb__wrap">
                                        <ul class="breadcrumb__list">
                                            <li class="has-separator">

                                                <a href="index.html">Home</a></li>
                                            <li class="is-marked">

                                                <a href="dash-address-add.html">Search</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="u-s-p-b-60">

                        <!--====== Section Content ======-->
                        <div class="section__content">
                            <div class="dash">
                                <div class="container">
                                    <div class="row">

                                        <div class="col-lg-9 col-md-12">
                                            <div class="dash__box dash__box--shadow dash__box--radius dash__box--bg-white">
                                                <div class="dash__pad-2">

                                                    <h1 class="dash__h1 u-s-m-b-14">Enter NIC</h1>

                                                    <span class="dash__text u-s-m-b-30">Search information</span>
                                                    <form class="dash-address-manipulation" method="GET" action="SimpleInformation.jsp">
                                                        <div class="gl-inline">
                                                            <div class="u-s-m-b-30">

                                                                <label class="gl-label" for="address-fname">NIC *</label>

                                                                <input name="paramName" class="input-text input-text--primary-style" type="text" id="address-fname" placeholder="Section Name"></div>

                                                        </div>

                                                        <button class="btn btn--e-brand-b-2" type="submit">SEARCH</button>
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

        </div>
        <!-- Le div à dupliquer -->
        <div class="hidden" id="duplicate">
            <div class="u-s-m-b-30">
                <label class="gl-label" for="address-country">Employee *</label>
                <select class="select-box select-box--primary-style" id="address-country" name="person">
                    <option selected="" value="">Choose an employee</option>
                    <option value="uae">James DEAN (UAE)</option>
                    <option value="uk">Olivia Dean (UK)</option>
                </select>
            </div>
            <div class="u-s-m-b-30">
                <label class="gl-label" for="address-street">WORKING HOUR EXCEPTED (Hours per day) *</label>
                <input class="input-text input-text--primary-style" type="number" id="address-street">
            </div>
        </div>

        <script>
            // Sélectionnez les boutons par leur ID
            var addButton = document.getElementById("add");
            var deleteButton = document.getElementById("delete");
            var newdiv = document.getElementById("duplicate");
            var container = document.querySelector(".dash-address-manipulation");

            // Ajoutez un gestionnaire d'événement au clic pour le bouton "+" (addButton)
            addButton.addEventListener("click", function() {
            // Créez une copie du div "input"
                var newInputDiv = newdiv.cloneNode(true);
                newInputDiv.classList.remove("hidden");
                newInputDiv.classList.add("gl-inline");
                var lastChild = container.lastElementChild;
                // Ajoutez la copie au conteneur
                container.insertBefore(newInputDiv, lastChild);

            });

            // Ajoutez un gestionnaire d'événement au clic pour le bouton "-" (deleteButton)
            deleteButton.addEventListener("click", function() {
                var children = container.children;

                // Vérifiez s'il y a au moins deux éléments (l'élément "input" initial et un autre élément)
                if (children.length >= 2) {
                    // Récupérez l'avant-dernier élément en utilisant l'indice length - 2
                    var beforeLastChild = children[children.length - 2];
                    // Supprimez l'avant-dernier élément s'il existe et si son ID est "input"
                    if (beforeLastChild.id === "duplicate") {
                        container.removeChild(beforeLastChild);
                    }
                }

            });
        </script>



</body></html>
