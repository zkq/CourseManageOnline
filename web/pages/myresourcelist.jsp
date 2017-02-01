<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>我的资源</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


    <%@include file="css.html" %>

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
                资源列表
            </h1>
            <ol class="breadcrumb">
                <li><a href="pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">资源列表</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">我发布的</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="table1" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>资源名称</th>
                                    <th>类型</th>
                                    <th>课程名称</th>
                                    <th>创建时间</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach var="item" items="${mycreats}">
                                    <tr>
                                        <td>
                                            <a href="resource/download.do?resourcemd5=${item.resourcemd5}&resourcename=${item.resourcename}">${item.resourcename}</a>
                                        </td>
                                        <td>
                                            <c:if test="${item.type == 1}">
                                                图片
                                            </c:if>
                                            <c:if test="${item.type == 2}">
                                                视频
                                            </c:if>
                                            <c:if test="${item.type == 3}">
                                                文档
                                            </c:if>
                                            <c:if test="${item.type == 4}">
                                                其他
                                            </c:if>
                                        </td>
                                        <td>${item.coursename}</td>
                                        <td><fmt:formatDate value="${item.creattime}" type="both"/></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">我下载的</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <table id="table2" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <th>资源名称</th>
                                    <th>类型</th>
                                    <th>课程名称</th>
                                    <th>创建者</th>
                                    <th>创建时间</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach var="item" items="${mydownloads}">
                                    <tr>
                                        <td>
                                            <a href="resource/download.do?resourcemd5=${item.resourcemd5}&resourcename=${item.resourcename}">${item.resourcename}</a>
                                        </td>
                                        <td>
                                            <c:if test="${item.type == 1}">
                                                图片
                                            </c:if>
                                            <c:if test="${item.type == 2}">
                                                视频
                                            </c:if>
                                            <c:if test="${item.type == 3}">
                                                文档
                                            </c:if>
                                            <c:if test="${item.type == 4}">
                                                其他
                                            </c:if>
                                        </td>
                                        <td>${item.coursename}</td>
                                        <td>${item.rolename}</td>
                                        <td><fmt:formatDate value="${item.creattime}" type="both"/></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
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
<%@include file="javascript.html" %>
<!-- page script -->
<script>
    $(function () {
        $('#table1').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
        $('#table2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });


</script>
</body>
</html>
