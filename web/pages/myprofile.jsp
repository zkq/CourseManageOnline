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
                个人资料
            </h1>
            <ol class="breadcrumb">
                <li><a href="pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">个人资料</li>
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
                                 src="adminlte/img/user4-128x128.jpg" alt="User profile picture">

                            <h3 class="profile-username text-center">${user.username}</h3>

                            <p class="text-muted text-center">最近登录时间
                                <small><fmt:formatDate value="${user.lastlogintime}" type="both"/></small>
                            </p>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b><c:if test="${role.type == '1'}">我的粉丝</c:if>
                                        <c:if test="${role.type == '2'}">我关注的</c:if>
                                    </b> <a class="pull-right" href="concern/all.do">${concerncnt}</a>
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
                            <li class="active"><a href="#aboutme" data-toggle="tab">关于我</a></li>
                            <li><a href="#settings" data-toggle="tab">设置</a></li>
                        </ul>
                        <div class="tab-content">
                            <!-- About Me Box -->
                            <div class="active tab-pane" id="aboutme">
                                <div>
                                    <strong><i class="fa fa-user-circle-o margin-r-5"></i>姓名</strong>

                                    <p class="text-muted">
                                        ${role.name}
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-book margin-r-5"></i>教育</strong>

                                    <p class="text-muted">
                                        ${role.education}
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-map-marker margin-r-5"></i> 籍贯</strong>

                                    <p class="text-muted">${role.nativeplace}</p>

                                    <hr>

                                    <strong><i class="fa fa-bank margin-r-5"></i> 单位</strong>

                                    <p>
                                        <span class="label label-danger">${role.school}</span>
                                        <span class="label label-success">${role.college}</span>
                                        <span class="label label-info">${role.major}</span>
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-file-text-o margin-r-5"></i> 联系方式</strong>

                                    <p>
                                        电话：${role.contact}<br/>
                                        邮箱：${role.email}
                                    </p>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->

                            <div class="tab-pane" id="settings">
                                <form class="form-horizontal" id="form" method="post" action="role/update.do">
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
                                                   id="inputSex">
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
                                            <input type="text" name="email" value="${role.email}" class="form-control"
                                                   id="inputEmail">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputSchool" class="col-sm-2 control-label">学校</label>

                                        <div class="col-sm-10">
                                            <input type="text" name="school" value="${role.school}" class="form-control"
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
                                            <input type="text" name="major" value="${role.major}" class="form-control"
                                                   id="inputMajor">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="button" onclick='ajaxsubmit(this, false, true, false)' class="btn btn-danger">提交</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- /.tab-pane -->
                        </div>
                        <!-- /.tab-content -->
                    </div>
                    <!-- /.nav-tabs-custom -->
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
