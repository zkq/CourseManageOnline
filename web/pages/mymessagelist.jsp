<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Timeline</title>
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
                我的通知
            </h1>
            <ol class="breadcrumb">
                <li><a href="pages/home.jsp" target="_top"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">我的通知</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <!-- row -->
            <div class="row">
                <div class="col-md-12">
                    <!-- The time line -->
                    <ul class="timeline">

                        <c:forEach var="item" items="${messages}">
                            <c:if test="${!item.sameday}">
                                <!-- timeline time label -->
                                <li class="time-label">
                                <span class="bg-red">
                                    <fmt:formatDate value="${item.actiontime}" type="date"/>
                                </span>
                                </li>
                                <!-- /.timeline-label -->
                            </c:if>
                            <!-- timeline item -->
                            <li>
                                <c:if test="${item.actiontype == 1}"><i class="fa fa-flag-o bg-blue"></i></c:if>
                                <c:if test="${item.actiontype == 2}"><i class="fa fa-bookmark-o bg-red"></i></c:if>
                                <c:if test="${item.actiontype == 3}"><i class="fa fa-camera bg-purple"></i></c:if>
                                <c:if test="${item.actiontype == 4}"><i class="fa fa-video-camera bg-maroon"></i></c:if>
                                <c:if test="${item.actiontype == 5}"><i class="fa fa-file-word-o bg-blue"></i></c:if>
                                <c:if test="${item.actiontype == 6}"><i class="fa fa-file-archive-o bg-blue"></i></c:if>

                                <div class="timeline-item">
                                    <span class="time"><i class="fa fa-clock-o"></i><fmt:formatDate value="${item.actiontime}" type="time"/></span>

                                    <h3 class="timeline-header"><a href="role/profile.do?id=${item.tid}">${item.tname}老师</a>${item.actionname}&nbsp;&nbsp;${item.tip}&nbsp;&nbsp;
                                        <button class="btn btn-danger" type="button" onclick='
                                            ajaxurl("message/delete.do?mid=${item.mid}", false, false, false);
                                            //删除该元素
                                            $(this).parent().parent().remove();
                                            '>删除</button>
                                    </h3>

                                    <div class="timeline-body">
                                        <c:if test="${item.actiontype == 1}">
                                            课程名称：${item.content}
                                        </c:if>
                                        <c:if test="${item.actiontype == 2}">
                                            作业标题：${item.content}
                                        </c:if>
                                        <c:if test="${item.actiontype == 3}">
                                            图片名称：<a href="resource/download.do?resourcemd5=${fn:split(item.content, " ")[0]}&resourcename=${fn:split(item.content, " ")[1]}">
                                            ${fn:split(item.content, " ")[1]}</a><br>
                                            <img src="resources/${fn:split(item.content, " ")[0]}" alt="..." class="margin" height="200">
                                        </c:if>
                                        <c:if test="${item.actiontype == 4}">
                                            视频名称：<a href="resource/download.do?resourcemd5=${fn:split(item.content, " ")[0]}&resourcename=${fn:split(item.content, " ")[1]}">
                                            ${fn:split(item.content, " ")[1]}</a><br>
                                            <div class="embed-responsive embed-responsive-16by9">
                                                <video src="resources/${fn:split(item.content, " ")[0]}" height="10%" width="auto" controls="controls">
                                                    您的浏览器不支持播放视频的控件
                                                </video>
                                            </div>
                                        </c:if>
                                        <c:if test="${item.actiontype == 5}">
                                            文档名称：<a href="resource/download.do?resourcemd5=${fn:split(item.content, " ")[0]}&resourcename=${fn:split(item.content, " ")[1]}">
                                            ${fn:split(item.content, " ")[1]}</a>
                                        </c:if>
                                        <c:if test="${item.actiontype == 6}">
                                            资源名称：<a href="resource/download.do?resourcemd5=${fn:split(item.content, " ")[0]}&resourcename=${fn:split(item.content, " ")[1]}">
                                            ${fn:split(item.content, " ")[1]}</a>
                                        </c:if>
                                    </div>
                                    <div class="timeline-footer">

                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                        </li>

                        <li>
                            <i class="fa fa-clock-o bg-gray"></i>
                        </li>
                    </ul>
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
