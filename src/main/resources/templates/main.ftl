<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="我的主页">
<meta name="author" content="chenyingjun">
<link rel="shortcut icon" href="${request.contextPath}/resources/images/favicon.png"
	type="image/png">
<title>业务管理系统-我的主页</title>
<#include "common/resources.ftl"/>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="${request.contextPath}/resources/js/html5shiv.js"></script>
  <script src="${request.contextPath}/resources/js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
	<!-- Preloader -->
	<div id="preloader">
		<div id="status">
			<i class="fa fa-spinner fa-spin"></i>
		</div>
	</div>
	<section>
		<div class="leftpanel">
			<#include "common/header-left.ftl" />
			<!-- logopanel -->
			<div class="leftpanelinner">
				<!-- This is only visible to small devices -->
				<#include "common/header-left-sm.ftl" />
				<#include "common/menu.ftl" />
			</div>
			<!-- leftpanelinner -->
		</div>
		<!-- leftpanel -->

		<div class="mainpanel">

			<div class="headerbar">

				<a class="menutoggle"><i class="fa fa-bars"></i></a>

				<#include "common/header-right.ftl" />
				<!-- header-right -->

			</div>
			<!-- headerbar -->

			<div class="pageheader">
				<h2>
					<i class="fa fa-home"></i> 我的主页
				</h2>
				<#--<div class="breadcrumb-wrapper">-->
					<#--<ol class="breadcrumb">-->
						<#--<li><a href="<%=path%>/main">业务管理系统</a></li>-->
						<#--<li class="active"><a-->
							<#--href="<%=path%>/main">我的主页</a></li>-->
					<#--</ol>-->
				<#--</div>-->
			</div>
			<div class="contentpanel" style="position:static">
				<div class="row">
						<div class="col-md-3" style="position:absolute;right:0;bottom:0;">
							<div class="panel panel-success panel-stat">
								<div class="panel-heading">
	
									<div style="color: #fff;padding-left: 40px;">
										<div class="row">
											<input type="hidden" id="hidServerTime" value="${nowTime?string('yyyy-MM-dd HH:mm:ss') }">
											<h3 id="serverTime"></h3>
										</div>
										<!-- row -->
										<#--<div class="row">-->
											<#--<h5>上次登录IP：${userLoginRecord.t.ip }-->
											<#--&nbsp;&nbsp;&nbsp;-->
											<#--上次登录时间：<fmt:formatDate value="${userLoginRecord.t.createTime }" pattern="yyyy-MM-dd HH:mm:ss" /></h5>-->
										<#--</div>-->
										<!-- row -->
									</div>
									<!-- stat -->
	
								</div>
								<!-- panel-heading -->
							</div>
							<!-- panel -->
						</div>
					<!-- col-sm-6 -->
				</div>
			</div>
		</div>
		
	</section>

	<script type="text/javascript">
		var timmer = null;
		$(function($){
			
			Date.prototype.format = function(fmt) { // author: meizz
			    var o = {
			        "M+": this.getMonth() + 1,
			        // 月份
			        "d+": this.getDate(),
			        // 日
			        "H+": this.getHours(),
			        // 小时
			        "m+": this.getMinutes(),
			        // 分
			        "s+": this.getSeconds(),
			        // 秒
			        "q+": Math.floor((this.getMonth() + 3) / 3),
			        // 季度
			        "S": this.getMilliseconds()
			        // 毫秒
			    };
			    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
			    for (var k in o) if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
			    return fmt;
			}
			updateDate();
			timmer = setInterval(updateDate, 1000);
		});
		
		var updateDate = function(){
//			var time = parseInt($("#hidServerTime").val());
			var date = new Date($("#hidServerTime").val());
			$("#serverTime").html(date.format("yyyy-MM-dd HH:mm:ss"));
            var time = date.getTime() + 1000;
            date.setTime(time);
            $("#hidServerTime").val(date);
		};
	</script>
</body>
</html>
