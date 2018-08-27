<div class="visible-xs hidden-sm hidden-md hidden-lg">
	<div class="media userlogged">
		<div class="media-body">
			<#--<h4>${sessionScope.user.nickName }</h4>-->
		</div>
	</div>
	<ul class="nav nav-pills nav-stacked nav-bracket mb30">
		<li><a data-toggle="modal" data-target="#personModal"
			href="javascript:void(0);" onclick="findPersonInfo();"><i
				class="fa fa-user"></i> <span>个人信息</span></a></li>
		<li><a data-toggle="modal" data-target="#personPWDModal"
			href="javascript:void(0);" onclick="updatePersonPWD();"><i
				class="fa fa-lock"></i> <span>修改密码</span></a></li>
		<li><a
			href="${request.contextPath}/j_spring_security_logout"><i
				class="fa fa-sign-out"></i> <span>退出登录</span></a></li>
	</ul>
</div>