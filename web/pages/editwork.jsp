<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>编辑作品</title>
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
                ${title}作品
            </h1>
            <ol class="breadcrumb">
                <li><a href="pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li>我的课程</li>
                <li>${coursename}</li>
                <li class="active">${title}作品</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">

                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">编辑作品</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="work/add.do" enctype="multipart/form-data">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="title">标题</label>
                                    <input type="text" class="form-control" id="title" name="title"
                                           value="${work.title}">
                                    <input type="hidden" name="taskid" value="${taskid}">
                                </div>
                                <div class="form-group">
                                    <label for="explain">内容（可选）</label>
                                    <textarea type="" class="form-control" id="explain"
                                              name="explain">
                                    </textarea>
                                </div>
                                <div class="form-group">
                                    <label for="attachment">附件（可选）</label>
                                    <input type="file" id="attachment" name="file">
                                </div>
                                <div class="progress">
                                    <span class="bar"></span><span class="percent">0%</span>
                                </div>

                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="button" class="btn btn-primary" id="submitbtn"
                                        onclick="ajaxfile(this, false)">提交
                                </button>
                                <button type="reset" class="btn btn-danger" id="resetbtn">重置</button>
                            </div>
                        </form>
                    </div>


                </div>
                <!-- /.col -->
                <div class="col-md-2"></div>
            </div>
            <!-- /.row -->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
<%@include file="javascript.html" %>
<script>
    $("#explain").val("${work.explain}");
</script>
</body>
</html>
