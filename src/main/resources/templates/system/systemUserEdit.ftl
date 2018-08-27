<!DOCTYPE HTML>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="author" content="chenyingjun">
<title>编辑系统用户信息</title>
    <script type="text/javascript"
            src="${request.contextPath}/include/js/md5.js"></script>
<#include "../common/resources.ftl"/>
</head>
<body>
	<!-- Preloader -->
	<section>
		<div class="leftpanel">
		<#include "../common/header-left.ftl"/>
			<!-- logopanel -->

			<div class="leftpanelinner">
			<#include "../common/header-left-sm.ftl"/>
			<#include "../common/menu.ftl"/>
			</div>
			<!-- leftpanelinner -->
		</div>
		<!-- leftpanel -->

		<div class="mainpanel">

			<div class="headerbar">

				<a class="menutoggle"><i class="fa fa-bars"></i></a>
			<#include "../common/header-right.ftl"/>
				<!-- header-right -->

			</div>
			<!-- headerbar -->

			<div class="pageheader">
				<h2>
					<i class="fa fa-user"></i> 编辑系统用户信息
				</h2>
				<div class="breadcrumb-wrapper">
					<ol class="breadcrumb">
						<li><a href="${request.contextPath}/main">${global.getConfig("systemProfiles.title")?html}</a></li>
						<li>系统管理</li>
						<li><a href="${request.contextPath}/systemuser/">系统用户管理</a></li>
						<li class="active">编辑系统用户信息</li>
					</ol>
				</div>
			</div>
			<div class="contentpanel">
				<div class="panel panel-default">
					<div class="panel-body panel-body-nopadding">
						<!-- 积分产品基本信息 -->
						<form id="baseInfoForm" name="baseInfoForm"
							action="/systemuser/edit" class="form-horizontal"
							method="post" accept-charset="UTF-8"
							enctype="application/x-www-form-urlencoded" data-option="edit">
							<div class="panel panel-default">
								<div class="panel-body">
									<div class="form-group">
                                        <input type="hidden" id="userId" name="userId"
                                               class="form-control" maxlength="20"
                                               value="${(user.id)! }" />
										<label class="col-sm-2 control-label">登录名<span
                                                class="asterisk">*</span></label>
										<div class="col-sm-4">
											<input type="code520" id="account" name="account"
												class="form-control" required="required"
												value="${(user.account)! }" placeholder="请输入登录名"/>
												<label class="error" for="account"></label>
										</div>
										<label class="col-sm-2 control-label">用户名<span
											class="asterisk">*</span></label>
										<div class="col-sm-4">
											<input type="text" id="name" name="name" required="required"
												value="${(user.name)! }" class="form-control"
												maxlength="20" placeholder="请输入用户名" /><label class="error"
												for="name"></label>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">昵称<span
											class="asterisk">*</span></label>
										<div class="col-sm-4">
											<input type="text" id="nickName" name="nickName"
												value="${(user.nickName)! }" class="form-control" required="required"
												maxlength="20" placeholder="请输入昵称" /><label class="error"
												for="nickName"></label>
										</div>
										<label class="col-sm-2 control-label">性别</label>
										<div class="col-sm-4">
											<select id="sex" class="select2 mg-bm10"
												data-placeholder="请选择性别" name="sex">
												<option value="0">未知</option>
												<option value="1"
													<#if user?? && (user.sex)! == '1'> selected="selected" </#if>>男</option>
												<option value="2"
													<#if user?? && (user.sex)! == '2'> selected="selected" </#if>>女</option>
											</select> <label class="error" for="sex"></label>
										</div>

									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">密码</label>
										<div class="col-sm-4">
											<input type="password" id="passWord" name="passWord"
												class="form-control"
												maxlength="20" placeholder="请输入密码" /><label class="error"
												for="passWord"></label>
										</div>
										<label class="col-sm-2 control-label">邮箱</label>
										<div class="col-sm-4">
											<input type="email" id="email" name="email"
												value="${(user.email)! }" class="form-control"
												maxlength="45" placeholder="请输入邮箱" /><label class="error"
												for="email"></label>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">手机号<span
											class="asterisk">*</span></label>
										<div class="col-sm-4">
											<#--<input type="mobile" id="phone" name="phone"
												value="${(user.phone)! }" class="form-control" required="required"
												maxlength="11" placeholder="请输入手机号" /><label class="error"
												for="phone"></label>-->
                                            <input type="mobile" id="phone" name="phone"
                                                   value="${(user.phone)! }" class="form-control" focusCleanup="true"
                                                   maxlength="45" placeholder="请输入手机号" /><label class="error"
                                                                                               for="phone"></label>
										</div>
										<label class="col-sm-2 control-label">连续登录失败次数<span
											class="asterisk">*</span></label>
										<div class="col-sm-4">
											<div class="input-group">
											<input type="text" id="failNum" name="failNum"
												value="${(user.failNum)?default(0) }" class="form-control"
												maxlength="1" placeholder="请输入连续登录失败次数" />
											<span class="input-group-addon">次</span>
											</div> <label class="error" for="failNum"></label>
										</div>
										
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">状态<span
											class="asterisk">*</span></label>
										<div class="col-sm-4">
											<select id="userStatus" class="select2 mg-bm10" required="required"
												data-placeholder="请选择状态" name="userStatus">
                                                    <option value="1"
														<#if user?? && user.status == 1> selected="selected" </#if>>可用</option>
                                                    <option value="0"
														<#if user?? && user.status == 0> selected="selected" </#if>>禁用</option>
											</select> <label class="error" for="userStatus"></label>
										</div>
										
										<label class="col-sm-2 control-label">所属角色<span
												class="asterisk">*</span></label>
										<div class="col-sm-4">
											<input type="text" id="roleIds" name="roleIds" value="${roleIds! }"
												class="js-data-example-ajax mg-bm10" maxlength="32" required
												placeholder="请选择所属角色" /><label class="error" for="roleIds"></label>
										</div>
									</div>
									<#if user??>
									<div class="form-group">
										<label class="col-sm-2 control-label">本次登录时间 </label>
										<div class="col-sm-4">
											<input type="text"
												class="form-control"
												value="${(user.loginTime?string('yyyy-MM-dd HH:mm:ss'))!}"
												disabled="disabled" />
										</div>
										<label class="col-sm-2 control-label">本次登录IP</label>
										<div class="col-sm-4">
											<input type="text"
												value="${(user.loginIp)! }" class="form-control"
												disabled="disabled" /> <label class="error"
												for="loginIp"></label>
										</div>
										
									</div>
									
									<div class="form-group">
										<label class="col-sm-2 control-label">上次登录时间 </label>
										<div class="col-sm-4">
											<input type="text"
												class="form-control"
												value="${(user.lastTime?string('yyyy-MM-dd HH:mm:ss'))!}"
												disabled="disabled" />
										</div>
										<label class="col-sm-2 control-label">上次登录IP</label>
										<div class="col-sm-4">
											<input type="text"
												value="${(user.lastIp)! }" class="form-control"
												disabled="disabled" /> <label class="error"
												for="lastIp"></label>
										</div>
										
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">创建时间 </label>
										<div class="col-sm-4">
											<input type="text"
												class="form-control"
												value="${(user.createTime?string('yyyy-MM-dd HH:mm:ss'))!}"
												disabled="disabled" />
										</div>
										<label class="col-sm-2 control-label">修改时间 </label>
										<div class="col-sm-4">
											<input type="text"
												class="form-control"
												value="${(user.updateTime?string('yyyy-MM-dd HH:mm:ss'))!}"
												disabled="disabled" />
										</div>
									</div>
									</#if>
									<div class="form-group">
										<label class="col-sm-2 control-label">备注 </label>
										<div class="col-sm-10">
											<textarea rows="20" class="form-control" id="remark"
												name="remark" placeholder="请输入备注">${(user.remark)! }</textarea>
										</div>
									</div>
								</div>
								<div class="panel-footer">
									<div class="row">
										<div class="col-sm-9 col-sm-offset-3">
											<button type="submit" class="btn btn-primary">提交</button>
											<a class="btn btn-default" href="${request.contextPath}/systemuser/">返回</a>
										</div>
									</div>
								</div>
							</div>
						</form>
						<!-- #basicWizard -->

					</div>
				</div>
				<!-- panel -->
			</div>
		</div>
		<!-- contentpanel -->
		<!-- mainpanel -->
	</section>
	<script type="text/javascript">
		$(function($) {

			jQuery("#baseInfoForm").validate({
                rules : {
				},
				submitHandler : function(form) {
					var pwd = jQuery("#passWord").val();
					if (pwd) {
						pwd = hex_md5(pwd);
                        jQuery("#passWord").val(pwd);
					}
					customSubmitHandler(form, "baseInfoForm");
				},
				unhighlight : function(element) {
					jQuery(element).parent().removeClass('has-error');
				},
				highlight : function(element) {
					jQuery(element).parent().removeClass('has-success')
							.addClass('has-error');
				},
				success : function(element) {
					jQuery(element).parent().removeClass('has-error')
							.addClass('has-success');
				}
			});
			
			//加载角色信息
			jQuery("#roleIds").select2({
				width : '100%',
				language : 'zh-CN',
				placeholder : "输入角色名解锁",
                maximumSelectionSize : 10,
				allowClear : true,
				dropdownCssClass : "bigdrop",
				multiple : true,
				tags: true,
				initSelection : function(element, callback) { // 初始化时设置默认值
					var ids = $(element).val();

					if (ids.length > 0) {

						$.ajax({
							type : 'GET',
							url : path + "/systemrole/data/ids?ids=" + ids,
							dataType : "json",
							data : null,
							cache : false,
							async : true,
							success : function(resp) {
								callback(resp.data);
							}
						});
					}
				},
				ajax : {
					url : path + "/systemrole/page",
					dataType : 'json',
					delay : 250,
					type : 'GET',
					data : function(term, pageNum) {
						term = $.trim(term);
						if (term && term.length > 0) {
							return {
								name : term,
								roleStatus : 1,
								pageSize : 15,
								pageNum : pageNum || 1,
							}
						} else {
							return {
								roleStatus : 1,
								pageSize : 15,
								pageNum : pageNum || 1,
							}
						}
					},
					results : function(resp, pageNum) {
						if (resp) {
                            var data = resp.data;
							var more = (pageNum * 15) < data.total; //用来判断是否还有更多数据可以加载
							return {
								results : data.list,
								more : more
							};
						} else {
							return {
								results : resp.list
							};
						}
					},
					cache : true
				},
				formatResult : function(obj) {
				 	 return obj.name;
				},
				formatSelection : function(obj) {
					return obj.name;
				},
				escapeMarkup : function(m) {
					return m;
				}
			});
		});
	</script>

</body>
</html>
