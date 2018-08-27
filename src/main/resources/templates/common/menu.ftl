<h5 class="sidebartitle">菜单导航</h5>
<ul id="menu" class="nav nav-pills nav-stacked nav-bracket">
    <li
            onclick="javascript:window.location.href='${request.contextPath}/main'"
            id="liMain"><a href="#"><i class="fa fa-home"></i> <span>我的主页</span></a>
    </li>
    <li class="nav-parent"><a href="#"><i class="fa fa-envelope"></i>
        <span> 任务管理 <span class="pull-right badge badge-success" id="processCount"></span>
			</span></a>
        <ul class="children">
            <li><a href="${request.contextPath}/articleprocess/"><i
                    class="fa fa-caret-right"></i> 文章任务管理 <span
                    class="pull-right badge badge-success" id="articleProcessCount"></span>
            </a></li>
            <li><a href="${request.contextPath}/suggestionprocess/"><i
                    class="fa fa-caret-right"></i> 反馈任务管理 <span
                    class="pull-right badge badge-success" id="suggestionProcessCount"></span>
            </a></li>
        </ul>
    </li>

    <li class="nav-parent"><a href="#"><i class="fa fa-user"></i>
        <span> 会员管理 <span class="pull-right badge badge-success"></span>
			</span></a>
        <ul class="children">
            <li><a href="${request.contextPath}/customer/"><i
                    class="fa fa-caret-right"></i> 会员信息管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
        </ul>
    </li>
    <li class="nav-parent"><a href="#"><i class="fa fa-paste"></i>
        <span> 分享管理 <span class="pull-right badge badge-success"></span>
			</span></a>
        <ul class="children">
            <li><a href="${request.contextPath}/article/"><i
                    class="fa fa-caret-right"></i> 文章信息管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
            <li><a href="${request.contextPath}/videos/"><i
                    class="fa fa-caret-right"></i> 视频信息管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
        </ul>
    </li>
    <li class="nav-parent"><a href="#"><i class="fa fa-database"></i>
        <span> 基础数据管理 <span class="pull-right badge badge-success"></span>
		</span></a>
        <ul class="children">
            <li><a href="${request.contextPath}/ggcodeintegral/"><i
                    class="fa fa-caret-right"></i> 积分规则管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
        </ul>
    </li>
    <li class="nav-parent"><a href="#"><i class="fa fa-gear"></i>
        <span> 系统管理 <span class="pull-right badge badge-success"></span>
			</span></a>
        <ul class="children">
            <li><a href="${request.contextPath}/systemuser/"><i
                    class="fa fa-caret-right"></i> 系统用户管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
            <li><a href="${request.contextPath}/systemrole/"><i
                    class="fa fa-caret-right"></i> 系统角色管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
            <li><a href="${request.contextPath}/systemmenu/"><i
                    class="fa fa-caret-right"></i> 菜单管理 <span
                    class="pull-right badge badge-success"></span>
            </a></li>
        </ul>
    </li>
</ul>
<script type="text/javascript">
    $(function ($) {

        var uri = window.location.pathname;

        if (uri == "${request.contextPath}" + '/main') {
            $("#liMain").addClass("active");
        }

        var uriArray = uri.split("\/");

        uri = "/" + uriArray[1] + "/" + uriArray[2] + "/";

        var menu = $("#menu").find("li").find("a[href^='" + uri + "']");

        $(menu).parent().addClass("active");

        var parent = $(menu).parent().parent();

        var parent_class = $(parent).attr("class");

        if ("children" == parent_class) {

            $(parent).slideDown("slow");
        }

        parent = $(parent).parent();

        var parent_class = $(parent).attr("class");

        if ("nav-parent" == parent_class) {

            $(parent).addClass("nav-active").addClass("active");
        }


    });
</script>

<script type="text/javascript">

    //查询任务数并显示
    function findTaskCount() {
        $.ajax({
            type: 'GET',
            url: path + "/count/task",
            dataType: "json",
            data: null,
            cache: false,
            async: true,
            success: function (data) {
                if (data && data.t) {
                    if (data.t.processCount) {
                        $("#processCount").css("display", "block").html(data.t.processCount);
                    } else {
                        $("#processCount").css("display", "none");
                    }

                    if (data.t.articleProcessCount) {
                        $("#articleProcessCount").css("display", "block").html(data.t.articleProcessCount);
                    } else {
                        $("#articleProcessCount").css("display", "none");
                    }

                    if (data.t.suggestionProcessCount) {
                        $("#suggestionProcessCount").css("display", "block").html(data.t.suggestionProcessCount);
                    } else {
                        $("#suggestionProcessCount").css("display", "none");
                    }

                    setTimeout(function () {
                        findTaskCount();
                    }, 5000);
                }
            }
        });
    }

    $(function ($) {

        //findTaskCount();

        jQuery("#updateUserPwdForm").validate(
                {

                    rules: {
                        "oldPassword": {
                            password: true,
                        },
                        "password": {
                            password: true,
                        },
                        "confirmPassword": {
                            equalTo: '#userPassword',
                        },
                    },
                    submitHandler: function (form) {

                        customSubmitHandler(form);

                    },
                    unhighlight: function (element) {
                        jQuery(element).parent().removeClass('has-error');
                    },
                    highlight: function (element) {
                        jQuery(element).parent().removeClass('has-success')
                                .addClass('has-error');
                    },
                    success: function (element) {
                        jQuery(element).parent().removeClass('has-error')
                                .addClass('has-success');
                    }
                });

        /** 加载所属用户信息 */
        jQuery("#mainUserDepId").select2({
            width: '100%',
            language: 'zh-CN',
            placeholder: "输入部门名称解锁",
            minimumInputLength: 0,
            dropdownCssClass: "bigdrop",
            initSelection: function (element, callback) { // 初始化时设置默认值

                var id = element.val();

                if (id.length > 0) {

                    $.ajax({
                        type: 'GET',
                        url: path + "/department/data/id?id=" + id,
                        dataType: "json",
                        data: null,
                        cache: false,
                        async: true,
                        success: function (resp) {
                            callback(resp.t);
                        }
                    });
                }
            },
            ajax: {
                url: path + "/department/page",
                dataType: 'json',
                delay: 250,
                type: 'GET',
                data: function (term, pageNum) {
                    term = $.trim(term);
                    if (term && term.length > 0) {
                        return {
                            depName: term,
                            pageSize: 15,
                            pageNum: pageNum || 1,
                        }
                    } else {
                        return {
                            pageSize: 15,
                            pageNum: pageNum || 1,
                        }
                    }
                },
                results: function (data, pageNum) {
                    if (data) {
                        var more = (pageNum * 15) < data.t.total; //用来判断是否还有更多数据可以加载

                        return {
                            results: data.t.list,
                            more: more
                        };
                    } else {
                        return {
                            results: data.t.list
                        };
                    }
                },
                cache: true
            },
            formatResult: function (obj) {
                return obj.name;
            },
            formatSelection: function (obj) {
                return obj.name;
            },
            escapeMarkup: function (m) {
                return m;
            }
        });
    })

    var editCallbackUpdatePwd = function (resp) {
        $("#global").remove();

        $("form[data-option='edit']").find("button[type='submit']").removeAttr("data-hand");

        $("form[data-option='edit']").find("button[type='submit']").removeAttr("disabled").text("提交");

        var globalErrorHtml = '<div id="global" class="alert alert-danger" style="margin-bottom: 10px;">' + '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + '<div>';

        iframeRequest = false;

        var code = resp.code;

        if ("200" == code) {
            globalErrorHtml = '<div id="global" class="alert alert-success" style="margin-bottom: 10px;">' + '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + '<div>';

            var message = resp.message;

            if (message) {

                message = decodeURIComponent(message);
            } else {

                message = "操作成功";
            }

            globalErrorHtml = globalErrorHtml + message + '，3秒后自动关闭此页面</div></div>';

            $("form[data-option='edit']").find(".panel").find(".panel-body").find(".form-group").eq(0).before(globalErrorHtml);

            editTimmer = setTimeout(function () {

                        $("#closeUpdateUserPwdBody").click();
                    },
                    3000);

            if (typeof formSuccess === 'function') {
                formSuccess(resp);
            }
        } else if ("500" == code) {
            if (editFormSettring.module == "1") {

                editFormSettring.defaultError(resp);

            } else {

                editFormSettring.error(resp);
            }
        } else {

            editFormSettring.serverError(resp);

        }
    }

    function findUserInfo() {

    }


    function updateUserPWD() {
        $("#updateUserPwdForm").attr("action", path + "/user/update/pwd");
    }

    /**退出*/
    function logout(){
        $.getJSON(path + "/logout",{},function(result){
            if(result && result.data.status == 200){
                window.location.reload(true);
                return !1;
            }else{
            }
        });
    }
</script>