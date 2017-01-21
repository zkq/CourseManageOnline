<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>

        <base href="/">

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>登录</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="logreg/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="logreg/css/form-elements.css">
        <link rel="stylesheet" href="logreg/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="logreg/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="logreg/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="logreg/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="logreg/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="logreg/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>在线课程管理系统</strong></h1>
                            <div class="description">
                            	<br>
	                            	本系统由朱科潜开发完成，来源于《信息管理系统》课程项目实践。</br>
                                    请尽情享受使用本系统带来的便利吧！
                            	</p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>登录本系统</h3>
                            		<p>请输入您的用户名和密码：</p>
                        		</div>
                        		<div class="form-top-right" style="font-size: medium">
                                    <a href="register.jsp">新用户注册</a>
                        		</div>

                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="/user/login.do" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="username" value="${user.username}" placeholder="用户名..." class="form-username form-control" id="form-username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="密码..." class="form-password form-control" id="form-password">
			                        </div>
                                    <div id="form-alert" class="alert alert-info">
                                        ${errMsg}
                                    </div>
			                        <button type="submit" class="btn">点我登录</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="plugins/jQuery-1.11.1/jquery-1.11.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="plugins/jQuery-backstretch/jquery.backstretch.min.js"></script>
        <script src="logreg/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="logreg/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>