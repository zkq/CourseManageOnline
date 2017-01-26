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
                ta的资料
            </h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard"></i> 搜索</li>
                <li class="active">ta的资料</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-3">

                    <!-- Profile Image -->
                    <div class="box box-primary">
                        <div class="box-body box-profile">
                            <img class="profile-user-img img-responsive img-circle"
                                 src="/adminlte/img/user4-128x128.jpg" alt="User profile picture">

                            <h3 class="profile-username text-center">${otheruser.username}</h3>

                            <p class="text-muted text-center">最近登录时间
                                <small><fmt:formatDate value="${otheruser.lastlogintime}" type="both"/></small>
                            </p>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b><c:if test="${otherrole.type == '1'}">ta的粉丝</c:if>
                                        <c:if test="${otherrole.type == '2'}">ta关注的</c:if>
                                    </b> <a class="pull-right">${concerncnt}</a>
                                </li>
                                <li class="list-group-item">
                                    <b><c:if test="${otherrole.type == '1'}">ta的同事</c:if>
                                        <c:if test="${otherrole.type == '2'}">ta的同学</c:if>
                                    </b> <a class="pull-right">${mate}</a>
                                </li>
                            </ul>
                            <c:if test="${otherrole.type == '1'}">
                                <button type="button" class="btn btn-primary btn-block"
                                        onclick='ajaxurl("/concern/toggle.do?id=${otherrole.roleid}", false)'>
                                    <b id="concernText">
                                        <c:if test="${concerned}">取消关注</c:if>
                                        <c:if test="${!concerned}">关注ta</c:if>
                                    </b>
                                </button>
                            </c:if>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col -->
                <div class="col-md-9">
                    <!-- About Me Box -->
                    <div class="active box box-primary" id="aboutme">

                        <!-- /.box-header -->
                        <div class="box-body">
                            <strong><i class="fa fa-user-circle-o margin-r-5"></i>姓名</strong>

                            <p class="text-muted">
                                ${otherrole.name}
                            </p>

                            <hr>

                            <strong><i class="fa fa-book margin-r-5"></i>教育</strong>

                            <p class="text-muted">
                                ${otherrole.education}
                            </p>

                            <hr>

                            <strong><i class="fa fa-map-marker margin-r-5"></i> 籍贯</strong>

                            <p class="text-muted">${otherrole.nativeplace}</p>

                            <hr>

                            <strong><i class="fa fa-bank margin-r-5"></i> 单位</strong>

                            <p>
                                <span class="label label-danger">${otherrole.school}</span>
                                <span class="label label-success">${otherrole.college}</span>
                                <span class="label label-info">${otherrole.major}</span>
                            </p>

                            <hr>

                            <strong><i class="fa fa-file-text-o margin-r-5"></i> 联系方式</strong>

                            <p>
                                电话：${otherrole.contact}<br/>
                                邮箱：${otherrole.email}
                            </p>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
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
<script src="/myjs/myjs.js"></script>
</body>
</html>
