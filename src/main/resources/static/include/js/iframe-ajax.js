/**
 * @author chenyingjun
 */
var editTimmer = null;

var iframeRequest = false;

//参数组装
function findOfEditParam(id) {
    var paramInput = $("#" + id).find("input,select,textarea");
    var param = {};
    $(paramInput).each(function() {
        var name = $(this).attr("name");
        var value = $(this).val();
        param[name] = value;
    });

    return param;
}

var customSubmitHandler = function(form, id) {

    $(form).find("button[type='submit']").attr("disabled", "disabled").text("正在提交...");
    var param = findOfEditParam(id);
    var url = jQuery("#"+id).attr("action");
    jQuery.ajax({
        url:path + url,
        type:"POST",
        data:param,
        success:function(resp){
            if (resp && resp.code == '300') {
                alert('请重新登录！');
                window.location.reload();
            }
            editCallback(resp);
        },
        error:function(){
            $("form[data-option='edit']").find("button[type='submit']").removeAttr("disabled").text("提交");
            editFormSettring.error();
        }
    });



    /*var hand = $(form).find("button[type='submit']").attr("data-hand");

    if (hand == "1") {

        return;
    }

    if (iframeRequest) {

        return;
    }

    iframeRequest = true;

    $("form").removeAttr("data-option");

    $(form).attr("data-option", "edit");

    $(form).find("button[type='submit']").attr("disabled", "disabled").text("正在提交...");

    $(form).find("button[type='submit']").attr("data-hand", "1");

    $("#editIframe").remove();

    $(form).before('<iframe id="editIframe" name="editIframe" style="display: none;"></iframe>');

    $(form).attr("target", "editIframe");

    form.submit();*/
};

/**
 * 模拟ajax请求参数设置对象 module为1时执行默认操作,module为2时执行自定义方法,自定义需重写对象的success与error方法
 */
var editFormSettring = {
    module: "1",
    defaultSuccess: function(resp) {

        var globalErrorHtml = '<div id="global" class="alert alert-success" style="margin-bottom: 10px;margin-left: 30px;margin-right: 30px;">' + '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + '<div>';

        var message = resp.message;

        if (message) {

            message = decodeURIComponent(message);
        } else {

            message = "操作成功";
        }

        globalErrorHtml = globalErrorHtml + message + '，3秒后自动跳转上级页面</div></div>';

        // $("form[data-option='edit']").find(".panel").find(".panel-body").find(".form-group").eq(0).before(globalErrorHtml);
        $("form[data-option='edit']").find(".panel").find(".panel-footer").before(globalErrorHtml);
        var uri = window.location.pathname;

        var uriArray = uri.split("\/");

        uri = "/" + uriArray[1] + "/" + uriArray[2] + "/";

        editTimmer = setTimeout(function() {

            window.location.href = uri;
        },
        3000);

        if (typeof formSuccess === 'function') {
            formSuccess(resp);
        }
    },
    defaultError: function(resp) {
    	var globalErrorHtml = '<div id="global" class="alert alert-danger" style="margin-bottom: 10px;margin-left: 30px;margin-right: 30px;">' + '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + '<div>';
    	
        var formValid = resp.data;

        if (formValid) {

            var globalErrors = formValid.globalErrors;

            if (globalErrors.length > 0) {

                globalErrors = JSON.stringify(globalErrors);

                globalErrors = decodeURIComponent(globalErrors);

                globalErrorHtml = globalErrorHtml + globalErrors +"<br>"

            }

            var fieldErrors = formValid.fieldErrors;

            $("form[data-option='edit']").find("input").each(function() {

                var id = $(this).attr("id");

                var name = $(this).attr("name");

                var value = $(this).val();

                var type = $(this).attr("type");

                $("#" + id).parent().removeClass("has-error").find(".error").html("");

                var fieldError = fieldErrors[name];

                if ("hidden" != type && fieldError) {

                    fieldError = decodeURIComponent(fieldError);

                    var parentClass = $("#" + id).parent().attr("class");

                    if (parentClass == "input-group") {
                        $("#" + id).parent().parent().addClass("has-error");

                        var error = $("#" + id).parent().parent().find(".error");

                        if (error.size() > 0) {

                            $(error).html(fieldError).css("display", "block");
                        } else {

                            $("#" + id).parent().after('<label class="error" for="' + id + '" style="display:block">' + fieldError + '</label>');
                        }
                    } else {

                        $("#" + id).parent().addClass("has-error");

                        var error = $("#" + id).parent().find(".error");

                        if (error.size() > 0) {

                            $(error).html(fieldError).css("display", "block");
                        } else {

                            $("#" + id).after('<label class="error" for="' + id + '" style="display:block">' + fieldError + '</label>');
                        }
                    }

                }
            });

            $("form[data-option='edit']").find("textarea").each(function() {

                var id = $(this).attr("id");

                var name = $(this).attr("name");

                var value = $(this).val();

                var type = $(this).attr("type");

                $("#" + id).parent().removeClass("has-error").find(".error").html("");

                var fieldError = fieldErrors[name];

                if ("hidden" != type && fieldError) {

                    fieldError = decodeURIComponent(fieldError);

                    var parentClass = $("#" + id).parent().attr("class");

                    if (parentClass == "input-group") {
                        $("#" + id).parent().parent().addClass("has-error");

                        var error = $("#" + id).parent().parent().find(".error");

                        if (error.size() > 0) {

                            $(error).html(fieldError).css("display", "block");
                        } else {

                            $("#" + id).parent().after('<label class="error" for="' + id + '" style="display:block">' + fieldError + '</label>');
                        }
                    } else {
                        $("#" + id).parent().addClass("has-error");

                        var error = $("#" + id).parent().find(".error");

                        if (error.size() > 0) {

                            $(error).html(fieldError).css("display", "block");
                        } else {

                            $("#" + id).after('<label class="error" for="' + id + '" style="display:block">' + fieldError + '</label>');
                        }
                    }
                }
            });

            $("form[data-option='edit']").find("select").each(function() {

                var id = $(this).attr("id");

                var name = $(this).attr("name");

                var value = $(this).val();

                var type = $(this).attr("type");

                $("#" + id).parent().removeClass("has-error").find(".error").html("");

                $("#s2id_" + id).find("a").removeAttr("style");

                var fieldError = fieldErrors[name];

                if ("hidden" != type && fieldError) {

                    fieldError = decodeURIComponent(fieldError);

                    var parentClass = $("#" + id).parent().attr("class");

                    if (parentClass == "input-group") {
                        $("#" + id).parent().parent().addClass("has-error");

                        var error = $("#" + id).parent().parent().find(".error");

                        if (error.size() > 0) {

                            $(error).html(fieldError).css("display", "block");
                        } else {

                            $("#" + id).parent().after('<label class="error" for="' + id + '" style="display:block">' + fieldError + '</label>');
                        }
                    } else {
                        $("#" + id).parent().addClass("has-error");

                        var error = $("#" + id).parent().find(".error");

                        if (error.size() > 0) {

                            $(error).html(fieldError).css("display", "block");
                        } else {

                            $("#" + id).after('<label class="error" for="' + id + '" style="display:block">' + fieldError + '</label>');
                        }
                    }

                    $("#s2id_" + id).find("a").attr("style", "border-color:#a94442");
                }
            });
        }

        var message = resp.message;

        if (message) {

            message = decodeURIComponent(message);
        } else {

            message = "操作失败";
        }

        globalErrorHtml = globalErrorHtml + message + '</div></div>';

        // $("form[data-option='edit']").find(".panel").find(".panel-body").find(".form-group").eq(0).before(globalErrorHtml);
        $("form[data-option='edit']").find(".panel").find(".panel-footer").before(globalErrorHtml);
    },
    serverError: function(resp) {
        var globalErrorHtml = '<div id="global" class="alert alert-danger" style="margin-bottom: 10px;margin-left: 30px;margin-right: 30px;">' + '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>' + '<div>';
        var message;

        if (resp && resp.message) {

            message = decodeURIComponent(resp.message);
        } else {

            message = "操作失败";
        }

        globalErrorHtml = globalErrorHtml + message + '</div></div>';

        // $("form[data-option='edit']").find(".panel").find(".panel-body").find(".form-group").eq(0).before(globalErrorHtml);
        $("form[data-option='edit']").find(".panel").find(".panel-footer").before(globalErrorHtml);
    },
    success: function(resp) {},
    error: function(resp) {},
};

/**
 * 模拟ajax的from表单提交回调方法 resp: 返回结果
 */
var editCallback = function(resp) {

    $("#global").remove();

    $("form[data-option='edit']").find("button[type='submit']").removeAttr("data-hand");

    $("form[data-option='edit']").find("button[type='submit']").removeAttr("disabled").text("提交");

    iframeRequest = false;

    var code = resp.code;

    if ("200" == code) {

        if (editFormSettring.module == "1") {

            editFormSettring.defaultSuccess(resp);

        } else {

            editFormSettring.success(resp);

        }
    } else if ("400" == code) {
        if (editFormSettring.module == "1") {

            editFormSettring.defaultError(resp);

        } else {

            editFormSettring.error(resp);
        }
    } else {
    	
        editFormSettring.serverError(resp);
        
    }
};