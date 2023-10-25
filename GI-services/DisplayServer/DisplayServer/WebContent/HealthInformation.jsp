<%@ page import="jakarta.servlet.http.HttpServletRequest" %>

<%@ page import="Health.HealthAccess" %>



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
            
        </header>
        <main>
            <div class="app-content">                    
                <div class="u-s-p-b-60">
    
                    <!--====== Section Content ======-->
                    
                    <!--====== End - Section Content ======-->
                </div>
                
                <div class="u-s-p-b-60">
    
                    <!--====== Section Content ======-->
                    <div class="section__content">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                    
                                    <a href= <%= "HealthInformation.jsp?paramName="+ request.getParameter("paramName") %> > 
                                        <div class="service u-h-100">
                                            <div class="service__icon"><i class="fas fa-truck"></i></div>
                                            <div class="service__info-wrap">
                                            
                                                <span class="service__info-text-1">Health</span>
                                            
                                                <span class="service__info-text-2">Click here</span></div>
                                        </div>
                                    </a>

                                </div>
                                <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                    <a href=<%= "Amount.jsp?paramName="+ request.getParameter("paramName") %>>
                                    <div class="service u-h-100">
                                        <div class="service__icon"><i class="fas fa-redo"></i></div>
                                        <div class="service__info-wrap">
    
                                            <span class="service__info-text-1">Amount</span>
    
                                            <span class="service__info-text-2">Click here</span></div>
                                    </div></a>
                                </div>
                                <div class="col-lg-4 col-md-6 u-s-m-b-30">
                                    <a href=<%= "Properties.jsp?paramName="+ request.getParameter("paramName") %>>
                                    <div class="service u-h-100">
                                        <div class="service__icon"><i class="fas fa-headphones-alt"></i></div>
                                        <div class="service__info-wrap">
    
                                            <span class="service__info-text-1">Properties</span>
    
                                            <span class="service__info-text-2">Click here</span></div>
                                    </div></a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--====== End - Section Content ======-->
                </div>
                
    
    
                
                <div class="u-s-p-b-60">
    
                    
                    
                    <div class="section__content">
                        <div class="container">
                            <div class="row">

                                <!-- CODE -->
                                <%= HealthAccess.getHTMLHealthInfo(request.getParameter("paramName")) %>                                
                                <!-- CODE -->
                            </div>
                        </div>
                    </div>
                    
                </div>
                
                
            </div>
        </main>
        <footer>
        </footer>
    </div>



</body></html>