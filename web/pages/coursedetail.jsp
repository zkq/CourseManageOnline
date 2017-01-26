<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>课程</title>
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
    <div class="content">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                课程详情

            </h1>

            <ol class="breadcrumb">
                <li><a href="/pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">课程详情</li>
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
                                 src="/adminlte/img/photo1.png" alt="course picture">

                            <h3 class="profile-username text-center">${courseDetail.name}</h3>

                            <p class="text-muted text-center">课程类型：
                                <small>${courseDetail.type}</small>
                            </p>

                            <c:if test="${type == 2}">
                                <c:if test="${courseDetail.hasjoined}">
                                    <button class="btn btn-danger btn-block"
                                            onclick='ajaxurl("/course/exit.do?id=${courseDetail.cid}", false, false)'>
                                        退出课程
                                    </button>
                                    <button class="btn btn-primary btn-block"
                                            onclick='ajaxurl("/source/add.do?id=${courseDetail.cid}", false, false)'>
                                        分享资源
                                    </button>
                                </c:if>
                                <c:if test="${!courseDetail.hasjoined}">
                                    <button class="btn btn-primary btn-block"
                                            onclick='ajaxurl("/course/join.do?id=${courseDetail.cid}", false, false)'>
                                        加入课程
                                    </button>
                                </c:if>
                            </c:if>
                            <c:if test="${type == 1}">
                                <div class="">
                                    您于<fmt:formatDate value="${courseDetail.createdate}" type="date"/>创建该课程
                                </div>
                                <button class="btn btn-danger btn-block"
                                        onclick='window.open("/task/newedit.do?cid=${courseDetail.cid}", "contentFrame")'>
                                    发布作业
                                </button>
                                <button class="btn btn-primary btn-block"
                                        onclick='ajaxurl("/source/add.do?id=${courseDetail.cid}", false, false)'>
                                    分享资源
                                </button>
                            </c:if>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>主讲教师 </b>
                                    <a class="pull-right"
                                       href="/role/profile.do?id=${courseDetail.teacherid}">${courseDetail.teachername}</a>
                                </li>
                                <li class="list-group-item">
                                    <b>加入码</b>
                                    <div class="pull-right">${courseDetail.code}</div>
                                </li>
                                <li class="list-group-item">
                                    <b>开课时间</b>
                                    <div class="pull-right"><fmt:formatDate value="${courseDetail.startdate}"/></div>
                                </li>
                                <li class="list-group-item">
                                    <b>结课时间</b>
                                    <div class="pull-right"><fmt:formatDate value="${courseDetail.finishdate}"/></div>
                                </li>
                                <li class="list-group-item">
                                    <b>加入截止</b>
                                    <div class="pull-right"><fmt:formatDate value="${courseDetail.joinenddate}"/></div>
                                </li>
                                <li class="list-group-item">
                                    <b>课程简介</b><br/>
                                    <div>${courseDetail.introduction}</div>
                                </li>
                            </ul>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->


                </div>
                <!-- /.col -->
                <div class="col-md-9">
                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#task" data-toggle="tab">作业</a></li>
                            <li><a href="#settings" data-toggle="tab">资源</a></li>
                            <li><a href="#tiezi" data-toggle="tab">帖子</a></li>
                        </ul>
                        <div class="tab-content">

                            <div class="active tab-pane" id="task">
                                <c:forEach var="item" items="${tasks}" varStatus="state">
                                    <div>
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <div style="font-size: 20px">作业${state.index + 1} &nbsp;${item.title}&nbsp;
                                                    <c:if test="${type == 2}">
                                                        <a href="/task/edithand.do?id=${item.taskid}"
                                                           style="font-size: 20px">
                                                            <button class="btn btn-danger">提交作业</button>
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${type == 1}">
                                                        <a href="/task/oldedit.do?id=${item.taskid}"
                                                           style="font-size: 20px">
                                                            <button class="btn bg-yellow">修改</button>
                                                        </a>

                                                        <span onclick='if(window.confirm("确认删除？"))ajaxurl("/task/delete.do?id=${item.taskid}", true, false)'>
                                                            <i class="ion ion-android-delete"></i>
                                                        </span>
                                                    </c:if>
                                                </div>
                                                <div>
                                                    创建时间<fmt:formatDate value="${item.creattime}" type="both"/>&nbsp;&nbsp;
                                                    提交截止时间<fmt:formatDate value="${item.endtime}" type="both"/>&nbsp;
                                                </div>
                                                <br/>
                                                <div style="font-size: 20px">${item.requirement}</div>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-bookmark"></i>
                                            </div>
                                            <a href="/task/detail.do?id=${item.taskid}" class="small-box-footer">
                                                查看所有提交 <i class="fa fa-arrow-circle-right"></i>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- /.tab-pane -->

                            <div class="tab-pane" id="settings">
                                <form class="form-horizontal" id="form" method="post" action="/role/update.do">
                                    <div class="form-group">
                                        <label for="inputName" class="col-sm-2 control-label">真实姓名</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="name" value="${role.name}" class="form-control"
                                                   id="inputName">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputSex" class="col-sm-2 control-label">性别</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="sex" value="${role.sex}" class="form-control"
                                                   id="inputSex" placeholder="男/女">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAge" class="col-sm-2 control-label">年龄</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="age" value="${role.age}" class="form-control"
                                                   id="inputAge">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputEducation" class="col-sm-2 control-label">教育</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="education" value="${role.education}"
                                                   class="form-control" id="inputEducation">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputNativePlace" class="col-sm-2 control-label">籍贯</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="nativeplace" value="${role.nativeplace}"
                                                   class="form-control" id="inputNativePlace">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputContact" class="col-sm-2 control-label">联系方式</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="contact" value="${role.contact}"
                                                   class="form-control" id="inputContact">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="email" value="${role.email}"
                                                   class="form-control"
                                                   id="inputEmail">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputSchool" class="col-sm-2 control-label">学校</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="school" value="${role.school}"
                                                   class="form-control"
                                                   id="inputSchool">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputCollege" class="col-sm-2 control-label">学院</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="college" value="${role.college}"
                                                   class="form-control" id="inputCollege">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label for="inputMajor" class="col-sm-2 control-label">专业</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="major" value="${role.major}"
                                                   class="form-control"
                                                   id="inputMajor">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="button"
                                                    onclick='ajaxsubmit(this, "/pages/myprofile.jsp#aboutme")'
                                                    class="btn btn-danger">提交
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.tab-pane -->

                            <div class="tab-pane" id="tiezi">
                                <div>帖子</div>
                            </div>
                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
                </div>
                <!-- /.col -->
            </div>
            <!-- /.row -->
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
<!-- Slimscroll -->
<script src="/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/adminlte/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/adminlte/js/demo.js"></script>
<script src="/myjs/myjs.js"></script>
</body>
</html>
