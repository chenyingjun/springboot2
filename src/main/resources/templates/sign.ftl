<!DOCTYPE HTML>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="系统登录">
    <meta name="author" content="chenyingjun">
    <title>后台业务系统-系统登录</title>
    <link rel="shortcut icon" href="${request.contextPath}/include/images/favicon.png"
          type="image/png">
    <script type="text/javascript"
            src="${request.contextPath}/include/js/md5.js"></script>
<#include "common/resources.ftl"/>
</head>
<body class="signin">
<section>
    <div class="signinpanel">
        <div class="row">
            <div class="col-md-7">
                <div class="signin-info">
                    <div class="logopanel">
                        <h1>
                            <span>[</span> ${global.getConfig("systemProfiles.title")?html} <span>]</span>
                        </h1>
                    </div>
                    <!-- logopanel -->

                    <div class="mb20"></div>

                    <h5>
                        <strong>欢迎进入后台业务管理系统!</strong>
                    </h5>
                    <ul>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 技术支持：chenyingjun<a
                                href="http://www.baidu.com/" target="_blank"></a></li>
                    </ul>
                    <div class="mb20"></div>
                </div>
                <!-- signin0-info -->
            </div>

            <!-- col-sm-7 -->
            <div class="col-md-5">
                <form method="post"
                      action="" accept="utf-8"
                enctype="application/x-www-form-urlencoded">
                <h4 class="nomargin">登录后台业务管理系统</h4>
                <p class="mt5 mb20">
                    <span style="color: red" id="errorInfo"></span>
                </p>
                <input type="text" name="account"
                       class="form-control uname" placeholder="请输入用户名"
                       <#--value="${requestScope.SPRING_SECURITY_LAST_USERNAME}" /> <input-->
                       value="" /> <input
                    type="password" name="password"
                    class="form-control pword" placeholder="请输入密码" />

                <#--<c:if test="${not empty requestScope.isNeedCode && '1' == requestScope.isNeedCode}">
                    <input type="text" id="checkCode" name="verifyCode"
                           class="form-control" style="width: 50%" placeholder="请输入验证码" />
                    <img alt="点击刷新验证码" src="<%=path%>/genimage" title="点击刷新验证码"
                         id="verifyCodeImg"
                         style="width: auto; height: 38px; float: right; margin-top: -40px;" />
                </c:if>-->
                <button class="btn btn-success btn-block" type="button" id="login">登录</button>
                </form>
            </div>
            <!-- col-sm-5 -->
        </div>
        <!-- row -->
        <div class="signup-footer">
            <div style="text-align: center; width: 100%">Copyright &copy;
                2018 chenyingjun All Rights Reserved</div>
        </div>
    </div>
    <!-- signin -->
</section>
<script type="text/javascript">
    $(function($) {

        $("body").keydown(function() {
            if (event.keyCode == "13") {//keyCode=13是回车键
                $('#login').click();
            }
        });

        //登录操作
        $('#login').click(function(){

            var username = $('.uname').val();
            var password = $('.pword').val();
            if(username == '') {
                $('#errorInfo').html("请输入用户名");
                return false;
            }
            if(password == '') {
                $('#errorInfo').html("请输入密码");
                return false;
            }
            var pswd = password;
            pswd = hex_md5(pswd);
            var data = {passWord:pswd,account:username,rememberMe:$("#rememberMe").is(':checked')};

            $.ajax({
                url:path + "/submitLogin",
                data:data,
                type:"post",
                dataType:"json",
                beforeSend:function(){
                },
                success:function(result){
                    if(result && result.code != 200){
                        $('.password').val('');
                        if (result && result.message) {
                            $('#errorInfo').html(result.message);
                        } else {
                            $('#errorInfo').html("系统内部错误");
                        }
                        return;
                    }else{
                        var data = result.data;
                        if (data && data.status != 200) {
                            $('#errorInfo').html(data.message);
                            $('.pword').val('');
                            return;
                        } else {
                            setTimeout(function(){
                                //登录返回
                                window.location.href= result.data.back_url || "${request.contextPath}/";
                            },1000)
                        }
                    }
                },
                error:function(e){
                    console.log(e,e.message);
                    console.log('请看后台Java控制台，是否报错，确定已经配置数据库和Redis',new Function());
                }
            });
        });

        var c = jQuery.cookie('change-skin');
        if (c && c == 'greyjoy') {
            jQuery('.btn-success').addClass('btn-orange').removeClass(
                    'btn-success');
        } else if (c && c == 'dodgerblue') {
            jQuery('.btn-success').addClass('btn-primary').removeClass(
                    'btn-success');
        } else if (c && c == 'katniss') {
            jQuery('.btn-success').addClass('btn-primary').removeClass(
                    'btn-success');
        }

        $("#verifyCodeImg")
                .bind(
                        "click",
                        function() {

                            $(this).attr(
                                    "src",
                                    path + "/genimage?time"
                                    + new Date().getTime());
                        });
    });
</script>
</body>
</html>
