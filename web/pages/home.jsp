<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>主页</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <%@include file="css.html"%>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-red sidebar-mini layout-boxed">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="pages/home.jsp" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>CM</b>OL</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>在线课程管理系统</b></span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="adminlte/img/user4-128x128.jpg" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${user.username}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="adminlte/img/user4-128x128.jpg" class="img-circle" alt="User Image">

                                <p>
                                    最近登录时间
                                    <small><fmt:formatDate value="${user.lastlogintime}" type="both"/></small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="pages/myprofile.jsp" target="contentFrame"
                                       class="btn btn-default btn-flat">个人资料</a>
                                </div>
                                <div class="pull-right">
                                    <a href="user/logout.do" class="btn btn-default btn-flat">退出系统</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="adminlte/img/user4-128x128.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${user.username}</p>
                    <!-- Status -->
                    <div><i class="fa fa-circle text-success"></i>欢迎你</div>
                </div>
            </div>

            <!-- search form (Optional) -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" id="q" class="form-control" placeholder="搜索用户...">
              <span class="input-group-btn">
                <button type="button" name="search" id="search-btn" class="btn btn-flat"
                        onclick='$("#contentFrame").attr("src", "role/search.do?name=" + $("#q").val());'><i
                        class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">功能列表</li>
                <li class="active" id="profileli">
                    <a href="pages/myprofile.jsp" target="contentFrame">
                        <i class="fa fa-credit-card"></i>
                        <span>我的资料</span>
                    </a>
                </li>
                <c:if test="${type == 2}">
                    <li id="msgli">
                        <a href="message/my.do" target="contentFrame">
                            <i class="fa fa-envelope-o"></i>
                            <span>我的通知</span>
                        </a>
                    </li>
                </c:if>
                <li id="sourceli">
                    <a href="resource/my.do" target="contentFrame">
                        <i class="fa fa-file-word-o"></i>
                        <span>我的资源</span>
                    </a>
                </li>
                <c:if test="${role.type == '1'}">
                    <li id="classopli">
                        <a href="pages/addclass.jsp" target="contentFrame">
                            <i class="fa fa-plus-square-o"></i>
                            <span>开设课程</span>
                        </a>
                    </li>
                </c:if>
                <c:if test="${role.type == '2'}">
                    <li id="classopli">
                        <a href="pages/searchcourse.jsp" target="contentFrame">
                            <i class="fa fa-arrow-circle-o-down"></i>
                            <span>搜索课程</span>
                        </a>
                    </li>
                </c:if>

                <li id="classli" class="treeview">
                    <a href="course/list.do" target="contentFrame">
                        <i class="fa fa-flag-o"></i>
                        <span>我的课程</span>
                    </a>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <iframe name="contentFrame" src="pages/myprofile.jsp"
                id="contentFrame" width="100%" height="100%"
                marginwidth="0" marginheight="0" frameborder="0">
        </iframe>
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            欢迎使用本系统
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2017 <a href="#">朱科潜</a>.</strong> All rights reserved.
    </footer>

</div>
<!-- ./wrapper -->
<%@include file="javascript.html"%>
</body>
</html>
