<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>个人中心</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/font-awesome-4.7.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/ionicons-2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/adminlte/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/adminlte/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <div class="wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                课程列表
            </h1>
            <ol class="breadcrumb">
                <li><a href="/pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">课程列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <c:forEach var="item" items="${courses}" varStatus="state">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <!-- small box -->
                <c:if test="${state.index % 2 == 1}">
                <div class="small-box bg-green">
                    </c:if>
                    <c:if test="${state.index % 2 == 0}">
                    <div class="small-box bg-red">
                        </c:if>

                        <div class="inner">
                            <p>${state.index + 1}
                                &nbsp;${item.code}
                            </p>
                            <h2>${item.name}</h2>
                        </div>
                        <div class="icon">
                            <i class="ion ion-bookmark"></i>
                        </div>
                        <a href="/course/detail.do?id=${item.id}" class="small-box-footer">
                            课程详细信息 <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>

                </c:forEach>
                <!-- /.row -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="/plugins/jQuery-2.2.3/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/adminlte/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/adminlte/js/demo.js"></script>
</body>
</html>