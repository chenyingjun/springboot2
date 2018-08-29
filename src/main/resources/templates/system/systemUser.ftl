<!DOCTYPE HTML>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="chenyingjun">
    <title>系统用户管理</title>
<#include "../common/resources.ftl"/>
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
                <i class="fa fa-user"></i> 系统用户管理
            </h2>
            <div class="breadcrumb-wrapper">
                <ol class="breadcrumb">
                    <li><a href="${request.contextPath}/main">业务管理系统</a></li>
                    <li>系统管理</li>
                    <li class="active"><a href="${request.contextPath}/systemuser/">系统用户管理</a></li>
                </ol>
            </div>
        </div>
        <div class="contentpanel">
            <div class="row">
                <!-- panel -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <form id="serachForm" name="serachForm" action="#">
                            <input type="hidden" id="pageNum" name="pageNum"
                                   class="form-control mg-bm10" value="1"/>
                            <div class="form-group">
                                <div class="col-sm-1" style="width: auto;">
                                    <select id="pageSize" class="select2 mb10" required
                                            data-placeholder="每页记录数" name="pageSize">
                                        <option value="15" selected="selected">15</option>
                                        <option value="30">30</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                        <option value="200">200</option>
                                        <option value="500">500</option>
                                    </select><label class="error" for="pageSize"></label>
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" id="roleIds" name="roleIds"
                                           class="js-data-example-ajax mg-bm10" maxlength="32"
                                           placeholder="用户角色"/><label class="error"
                                                                      for="roleIds"></label>
                                </div>
                                <div class="col-sm-1">
                                    <input type="text" id="name" name="name"
                                           class="form-control mg-bm10" maxlength="32"
                                           placeholder="用户名"/><label class="error"
                                                                     for="name"></label>
                                </div>
                                <div class="col-sm-1">
                                    <input type="text" id="nickName" name="nickName"
                                           class="form-control mg-bm10" maxlength="32"
                                           placeholder="昵称"/><label class="error"
                                                                    for="nickName"></label>
                                </div>
                                <div class="col-sm-1">
                                    <input type="text" id="phone" name="phone"
                                           class="form-control mg-bm10" maxlength="32"
                                           placeholder="用户手机号"/><label class="error"
                                                                       for="phone"></label>
                                </div>
                                <div class="col-sm-1">
                                    <select id="sex" class="select2"
                                            data-placeholder="性别" name="sex">
                                        <option value="">性别</option>
                                        <option value="1">男</option>
                                        <option value="2">女</option>
                                    </select> <label class="error" for="sex"></label>
                                </div>
                                <div class="col-sm-1">
                                    <select id="userStatus" class="select2"
                                            data-placeholder="状态" name="userStatus">
                                        <option value="">状态</option>
                                        <option value="0">禁用</option>
                                        <option value="1">可用</option>
                                    </select> <label class="error" for="userStatus"></label>
                                </div>
                                <div class="col-sm-1">
                                    <input type="text" id="startTime" name="startTime"
                                           class="form-control mb10"
                                           onfocus="WdatePicker({maxDate:'#F{$dp.$D(endTime)}',dateFmt:'yyyyMMdd'})"
                                           placeholder="开始时间"/><label class="error" for="startTime"></label>
                                </div>
                                <div class="col-sm-1">
                                    <input type="text" id="endTime" name="endTime"
                                           class="form-control mb10"
                                           onfocus="WdatePicker({minDate:'#F{$dp.$D(startTime)}',dateFmt:'yyyyMMdd'})"
                                           placeholder="结束时间"/><label class="error" for="endTime"></label>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <button class="btn btn-success" type="submit">查询</button>
                                    <a class="btn btn-primary" href="${request.contextPath}/systemuser/add">新增</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive"
                             style="position: relative; min-height: 100px;overflow: overlay;margin-bottom: 10px;">
                            <table class="table table-striped" id="systemuserTable">
                                <thead>
                                <tr>
                                    <th td-name="name">姓名</th>
                                    <th td-name="nickName">昵称</th>
                                    <th td-name="rolesName">角色</th>
                                    <th td-name="email">邮箱</th>
                                    <th td-name="phone">手机号</th>
                                    <th td-name="sexName">性别</th>
                                    <th td-name="failNum">失败登录次数</th>
                                    <th td-name="statusName">状态</th>
                                    <th td-name="createTime">创建时间</th>
                                    <th td-name="updateTime">修改时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        <!-- table-responsive -->
                    </div>
                    <!-- panel-body -->
                </div>
                <!-- panel -->
            </div>
        </div>
    </div>
    <!-- contentpanel -->
</section>
<script type="text/javascript">
    /*
    * 加载数据函数
    */
    $(function () {

        table(path + "/systemuser/page", "serachForm",
                "systemuserTable", oper, true);

        jQuery("#serachForm").validate(
                {
                    rules: {},
                    submitHandler: function () {
                        table(path + "/systemuser/page", "serachForm",
                                "systemuserTable", oper, false);
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

    var oper = function(data) {
        return '<td><a title="编辑" href='
                + path
                + '/systemuser/'
                + data.id
                + '> <i class="fa fa-pencil"></i></a></td>'
    }
</script>

</body>
</html>
