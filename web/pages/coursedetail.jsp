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
    <div class="content">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                课程详情

            </h1>

            <ol class="breadcrumb">
                <li><a href="pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
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
                                 src="adminlte/img/photo1.png" alt="course picture">

                            <h3 class="profile-username text-center">${courseDetail.name}</h3>

                            <p class="text-muted text-center">课程类型：
                                <small>${courseDetail.type}</small>
                            </p>

                            <c:if test="${type == 2}">
                                <c:if test="${courseDetail.hasjoined}">
                                    <button class="btn btn-danger btn-block"
                                            onclick='ajaxurl("course/exit.do?id=${courseDetail.cid}", false, false, true)'>
                                        退出课程
                                    </button>
                                    <button class="btn btn-primary btn-block"
                                            onclick='window.open("resource/newedit.do?cid=${courseDetail.cid}", "contentFrame")'>
                                        分享资源
                                    </button>
                                </c:if>
                                <c:if test="${!courseDetail.hasjoined}">
                                    <button class="btn btn-primary btn-block"
                                            onclick='ajaxurl("course/join.do?id=${courseDetail.cid}", false, false, true)'>
                                        加入课程
                                    </button>
                                </c:if>
                            </c:if>
                            <c:if test="${type == 1}">
                                <div class="">
                                    您于<fmt:formatDate value="${courseDetail.createdate}" type="date"/>创建该课程
                                </div>
                                <button class="btn btn-danger btn-block"
                                        onclick='window.open("task/newedit.do?cid=${courseDetail.cid}", "contentFrame")'>
                                    发布作业
                                </button>
                                <button class="btn btn-primary btn-block"
                                        onclick='window.open("resource/newedit.do?cid=${courseDetail.cid}", "contentFrame")'>
                                    分享资源
                                </button>
                            </c:if>

                            <ul class="list-group list-group-unbordered">
                                <li class="list-group-item">
                                    <b>主讲教师 </b>
                                    <a class="pull-right"
                                       href="role/profile.do?id=${courseDetail.teacherid}">${courseDetail.teachername}</a>
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
                            <li><a href="#resources" data-toggle="tab">资源</a></li>
                            <li><a href="#tiezi" data-toggle="tab">帖子</a></li>
                        </ul>
                        <div class="tab-content">

                            <div class="active tab-pane" id="task">
                                <c:forEach var="item" items="${tasks}" varStatus="state">
                                    <div>
                                        <!-- small box -->
                                        <div class="small-box bg-green">
                                            <div class="inner">
                                                <div style="font-size: 20px">作业${state.index + 1} &nbsp;
                                                    <span style="color: yellow">${item.title}</span> &nbsp;
                                                    <c:if test="${type == 2 && !donelist.contains(item.taskid)}">
                                                        <a href="work/newedit.do?taskid=${item.taskid}"
                                                           style="font-size: 20px">
                                                            <button class="btn btn-danger">提交作业</button>
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${type == 2 && donelist.contains(item.taskid)}">
                                                        <a href="work/oldedit.do?taskid=${item.taskid}"
                                                           style="font-size: 20px">
                                                            <button class="btn btn-danger">修改作业</button>
                                                        </a>
                                                    </c:if>
                                                    <c:if test="${type == 1}">
                                                        <a href="task/oldedit.do?id=${item.taskid}"
                                                           style="font-size: 20px">
                                                            <button class="btn bg-yellow">修改</button>
                                                        </a>

                                                        <span onclick='if(window.confirm("确认删除？"))ajaxurl("task/delete.do?id=${item.taskid}", false, false, true)'>
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
                                            <a href="task/worklist.do?id=${item.taskid}" class="small-box-footer">
                                                查看所有提交 <i class="fa fa-arrow-circle-right"></i>
                                            </a>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <!-- /.tab-pane -->

                            <div class="tab-pane" id="resources">
                                <c:forEach var="item2" items="${resources}" varStatus="state2">
                                    <div>
                                        <div class="small-box bg-yellow">
                                            <div class="inner">
                                                <div style="font-size: 20px">
                                                    资源${state2.index + 1} &nbsp;
                                                    <c:if test="${myreslist.contains(item2.rid)}">
                                                        <a href="resource/oldedit.do?rid=${item2.rid}"
                                                           style="font-size: 20px">
                                                            <button class="btn bg-red">修改</button>
                                                        </a>
                                                        <span onclick='if(window.confirm("确认删除？"))ajaxurl("resource/delete.do?id=${item2.rid}", false, false, true)'>
                                                            <i class="ion ion-android-delete"></i>
                                                        </span>
                                                    </c:if>
                                                </div>
                                                <div>
                                                    <a href="resource/download.do?resourcemd5=${item2.resourcemd5}&resourcename=${item2.resourcename}">${item2.resourcename}</a>
                                                </div>
                                                <div>
                                                    创建人：${item2.rolename} &nbsp;&nbsp;
                                                    创建时间：<fmt:formatDate value="${item2.creattime}" type="both"/>&nbsp;
                                                </div>
                                                <br/>
                                                <c:if test="${item2.introduction == ''}">
                                                    <div style="font-size: 20px">暂无资源简介</div>
                                                </c:if>
                                                <c:if test="${!(item2.introduction == '')}">
                                                    <div style="font-size: 20px">资源简介：${item2.introduction}</div>
                                                </c:if>
                                            </div>
                                            <div class="icon">
                                                <i class="ion ion-bookmark"></i>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
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
<%@include file="javascript.html"%>
</body>
</html>
