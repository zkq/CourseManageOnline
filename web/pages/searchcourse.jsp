<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>搜索课程</title>
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
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <!-- Content Wrapper. Contains page content -->
    <div class="wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                搜索课程
            </h1>
            <ol class="breadcrumb">
                <li><a href="pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">搜索课程</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-8">
                    <!-- Profile Image -->
                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">请输入课程加入码</h3>
                        </div>
                        <div class="box-body box-info">
                            <div class="input-group input-group-lg">
                                <input type="text" class="form-control" id="code">
                <span class="input-group-btn">
                  <button type="button" class="btn btn-info btn-flat" onclick='
                    $.ajax({
                      type: "POST",
                      url: "course/exist.do?code="+$("#code").val(),
                      async: false,
                      error: function(data) {
                          alert("连接出错");
                      },
                      success: function(data) {
                          if(data == "" || data == "ok"){
                              window.open("course/search.do?code="+$("#code").val(), "contentFrame");
                          }else{
                              alert(data);
                          }
                      }
                    });'>
                      确定
                  </button>
                </span>
                            </div>


                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
                <div class="col-md-2">
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
<%@include file="javascript.html"%>
</body>
</html>
