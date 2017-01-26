<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>编辑作业</title>
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
    <!-- daterange picker -->
    <link rel="stylesheet" href="/plugins/daterangepicker/daterangepicker.css">
    <!-- bootstrap datepicker -->
    <link rel="stylesheet" href="/plugins/datepicker/datepicker3.css">

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
                ${title}作业
            </h1>
            <ol class="breadcrumb">
                <li><a href="/pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li>我的课程</li>
                <li>${coursename}</li>
                <li class="active">${title}作业</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">

                    <div class="box box-primary">
                        <div class="box-header with-border">
                            <h3 class="box-title">作业信息</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form role="form" method="post" action="/task/add.do">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="title">作业标题</label>
                                    <input type="text" class="form-control" id="title" name="title" value="${task.title}">
                                    <input type="hidden" name="cid" value="${cid}">
                                    <input type="hidden" name="taskid" value="${task.taskid}">
                                </div>
                                <div class="form-group">
                                    <label for="datepick">作业提交截止日期:</label>

                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="datepick"
                                               name="endtime" value='<fmt:formatDate value="${task.endtime}" pattern="MM/dd/yyyy"/>'>
                                    </div>
                                    <!-- /.input group -->
                                </div>
                                <div class="form-group">
                                    <label for="requirement">作业要求</label>
                                    <textarea type="" class="form-control" id="requirement"
                                              name="requirement">
                                    </textarea>
                                </div>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="button" class="btn btn-primary" onclick='ajaxsubmit(this, false)'>提交
                                </button>
                                <button type="reset" class="btn btn-danger">重置</button>
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
<!-- bootstrap datepicker -->
<script src="/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- date-range-picker -->
<script src="/plugins/daterangepicker/moment.min.js"></script>
<script src="/plugins/daterangepicker/daterangepicker.js"></script>
<script src="/myjs/myjs.js"></script>

<script>
    //Date picker
    $('#datepick').datepicker({
        autoclose: true
    });
    //Date range picker
    $('#classdate').daterangepicker();

    $("#requirement").val("${task.requirement}");


</script>
</body>
</html>
