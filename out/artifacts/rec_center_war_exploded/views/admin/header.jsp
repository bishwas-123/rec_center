<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <title>MUM RECREATION CENTER</title>
    <meta charset="utf-8">
    <meta name="viewport" content='width=device-width, initial-scale=1, width=device-width'>
    <meta name="description" content="Responsive HTML template for gym or fitness studio">
    <meta name="keywords" content="gym, fitness, workout, sports, website, template, html">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());
        gtag('config', 'UA-119687618-1');
    </script>
</head>

<body class="gym-city">

<div class="loading-screen" id="loadingScreen">
    <div class="loader">Loading...</div>
</div>
<nav class="navbar navbar-expand-lg navbar-top" style="max-height: 62px;">
    <div class="container">
        <!-- Logo -->
        <a class="navbar-brand" href="#">MUM REC CENTER</a>
        <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#gymCityNav"
                aria-controls="gymCityNav"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fa fa-bars" aria-hidden="true"></i>
        </button>

        <!-- Navbar -->
        <div class="collapse navbar-collapse" id="gymCityNav">
            <i class="fa fa-times close-navbar-mobile" aria-hidden="true" data-toggle="collapse"
               data-target="#gymCityNav"></i>
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/home" class="nav-link" id="navHome">Home</a> <!-- to highlight a selected nav item add "active" class -->
                </li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/users" class="nav-link">Users</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/viewresouces" class="nav-link">Resources</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

