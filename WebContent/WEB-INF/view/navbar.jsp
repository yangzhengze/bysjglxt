<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--------------------------------------------------------------------------------->
<script src="<%=basePath%>js/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap-select.min.css">
<script src="<%=basePath%>js/bootstrap-select.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/chartist-custom.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/main.css">
<link rel="stylesheet"
	href="<%=basePath%>css/navbar/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>css/navbar/style.css">
<link rel="stylesheet" href="<%=basePath%>css/table.css">
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/toastr.css" />
<script src="<%=basePath%>js/toastr.js"></script>
<!--------------------------------------------------------------------------------->
<link rel="stylesheet" href="<%=basePath%>css/jquery-confirm.css" />
<script src="<%=basePath%>js/jquery-confirm.js"></script>
<!--------------------------------------------------------------------------------->
<!---页面公用------------------------------------------------------------------------------>
<script type="text/javascript"
	src="<%=basePath%>js/loginAndLogout/Input_Select.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/loginAndLogout/getUserSessionForAjax.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/loginAndLogout/roleControl.js"></script>
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<!--------------------------------------------------------------------------------->
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div
			style="width: auto; float: left; line-height: 78px; margin: 0 0 0 30px; font-size: 30px;">毕业设计管理系统</div>
		<div id="navbar-menu">
			<ul class="nav navbar-nav navbar-left" style="margin: 0 0 0 50px">
				<li class="dropdown" style="float: left;">
					<a href="<%=basePath%>loginLogout/LoginLogoutManagement_index">
						<span>首页</span>
					</a>
				</li>
				<!--  -->
				<li class="leader_control dropdown" style="float: left;">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span>信息</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a
								href="<%=basePath%>student/StudentInformationManagement_listPage"
								class="">学生</a>
						</li>
						<li>
							<a
								href="<%=basePath%>teacher/TeacherInformationManagement_TeacherManagementPage">教师</a>
						</li>
						<li>
							<a
								href="<%=basePath%>section/SectionInformationManagement_SectionManagementPage">教研室</a>
						</li>
					</ul>
				</li>
				<!--  -->
				<li class="dropdown" style="float: left;">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span>课题</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a
								href="<%=basePath%>topic/TopicInformationManagement_TopicListPage">课题</a>
						</li>
						<li>
							<a
								href="<%=basePath%>topic/TopicInformationManagement_MyTopicListPage">我的课题</a>
						</li>
					</ul>
				</li>
				<!--  -->
				<li class="dropdown" style="float: left;">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span>流程</span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">流程定义列表</a>
						</li>
				</li>
				<li>
					<a href="#">流程实例列表</a>
				</li>
				<li>
					<a href="#">任务定义列表</a>
				</li>
				<li>
					<a href="#">任务实例列表</a>
				</li>
			</ul>
			</li>
			<!--  -->
			<li class="dropdown" style="float: left;">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					<span>毕业设计</span>
					<i class="icon-submenu lnr lnr-chevron-down"></i>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a
							href="#">毕业设计列表</a>
					</li>
					<li>
						<a
							href="#">我的毕业设计</a>
					</li>
				</ul>
			</li>
			<!--  -->
			</ul>
			<!--  -->
			<ul class="nav navbar-nav navbar-right" style="margin: 0 50px 0 0">
				<!--  -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle icon-menu"
						data-toggle="dropdown">
						<i class="lnr lnr-alarm"></i>
						<span class="badge bg-danger">2</span>
					</a>
					<ul class="dropdown-menu notifications">
						<li>
							<a href="#" class="notification-item">
								<span class="dot bg-success"></span>
								指导老师审核开题报告——江鑫鑫
							</a>
						</li>
						<li>
							<a href="#" class="notification-item">
								<span class="dot bg-success"></span>
								指导老师填写评价审阅表——李文凯
							</a>
						</li>
					</ul>
				</li>

				<!--  -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="fa fa-user-circle"></i>
						<span id="USER_NAME"></span>
						<i class="icon-submenu lnr lnr-chevron-down"></i>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="#">
								<i class="lnr lnr-user"></i>
								<span>我的信息</span>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="lnr lnr-lock"></i>
								<span>修改密码</span>
							</a>
						</li>
						<li>
							<a href="<%=basePath%>loginLogout/LoginLogoutManagement_logout">
								<i class="lnr lnr-exit"></i>
								<span>退出登录</span>
							</a>
						</li>
					</ul>
				</li>
				<!--  -->
			</ul>
		</div>
		</nav>
</body>
<script type="text/javascript">
	getUserSessionForAjax();
</script>
</html>