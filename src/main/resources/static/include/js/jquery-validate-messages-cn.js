$.extend($.validator.messages, {
	required : "必选字段",
	remote : "请修正该字段",
	email : "请输入正确格式的电子邮件",
	url : "请输入合法的网址",
	date : "请输入合法的日期",
	zipCode : "请输入正确的邮政编码",
	tel : "请输入正确的手机号码",
	cardId : "请输入正确的身份证号码",
	dateISO : "请输入合法的日期 (ISO)",
	number : "请输入合法的数字",
	digits : "只能输入整数",
	creditcard : "请输入合法的信用卡号",
	equalTo : "请再次输入相同的值",
	accept : "请输入拥有合法后缀名的字符串",
	maxlength : $.validator.format("请输入一个长度最多是 {0} 的字符串"),
	minlength : $.validator.format("请输入一个长度最少是 {0} 的字符串"),
	rangelength : $.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
	range : $.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
	max : $.validator.format("请输入一个最大为 {0} 的值"),
	min : $.validator.format("请输入一个最小为 {0} 的值")
});

// 邮政编码验证
jQuery.validator.addMethod("zipCode", function(value, element) {
	var zipCode = /^[0-9]{6}$/;
	return this.optional(element) || (zipCode.test(value));
}, "邮政编码只能为6位数字");

//ip地址验证
jQuery.validator.addMethod("ip", function(value, element) {
	var zipCode = /^\d{1,3}(\.\d{1,3}){3}$/;
	return this.optional(element) || (zipCode.test(value));
}, "请输入正确的ip地址");

// 手机号码或者电话号码验证
jQuery.validator.addMethod("phone", function(value, element) {
	var tel = /^(0\d{2,3}-?\d{7,8})|(1\d{10})$/;
	return this.optional(element) || (tel.test(value));
}, "手机号码或者电话号码格式不正确");

//电话号码验证
jQuery.validator.addMethod("tel", function(value, element) {
	var tel = /^0\d{2,3}-?\d{7,8}$/;
	return this.optional(element) || (tel.test(value));
}, "传真号码格式不正确");

// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
	var mobile = /^1\d{10}$/;
	return this.optional(element) || (mobile.test(value));
}, "手机号码格式不正确");

//只能输入数字，最多11位
jQuery.validator.addMethod("number11", function(value, element) {
	var number11 = /^\d{1,11}$/;
	return this.optional(element) || (number11.test(value));
}, "只能输入数字，最多11位");

// 身份证号码验证
jQuery.validator.addMethod("idCard", function(value, element) {
	var idCard = /^([0-9\*]{14}|[0-9\*]{17})[0-9xX]$/;
	return this.optional(element) || (idCard.test(value));
}, "身份证号码格式不正确");

//银行卡号验证
jQuery.validator.addMethod("bankCard", function(value, element) {
	var bankCard = /^(\d{16}|\d{19})$/;
	return this.optional(element) || (bankCard.test(value));
}, "银行卡号格式不正确");

//用户名验证，必须且只能包含数字和字母.6-20
jQuery.validator.addMethod("account", function(value, element) {
	var account = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
	return this.optional(element) || (account.test(value));
}, "必须且只能包含数字和字母6-20");

// 只能包括英文字母或者数字或者下划线(下划线不能开头跟结尾)
jQuery.validator.addMethod("code", function(value, element) {
	var objectCode = /^\w+$/;
	return this.optional(element) || (objectCode.test(value));
}, "只能包括英文字母、数字、“_”");

//只能包括16-32位的数字或字母
jQuery.validator.addMethod("code1632", function(value, element) {
	var objectCode = /^[0-9A-Za-z]{16,32}$/;
	return this.optional(element) || (objectCode.test(value));
}, "只能包括16-32位的数字或字母");

//只能包括6-20位的数字或字母
jQuery.validator.addMethod("code520", function(value, element) {
    var objectCode = /^[0-9A-Za-z]{5,20}$/;
    return this.optional(element) || (objectCode.test(value));
}, "只能包括5-20位的数字或字母");


//长度6-20位,字母、数字组合
jQuery.validator.addMethod("password", function(value, element) {
	var objectCode = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$/;
	return this.optional(element) || (objectCode.test(value));
}, "长度6-20位,字母、数字组合");

// 只能包括中文字、英文字母、数字和下划线(下划线不能开头跟结尾)
jQuery.validator.addMethod("chinaName", function(value, element) {
	var objectName = /^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
	return this.optional(element) || (objectName.test(value));
}, "只能包括中文字、英文字母、数字、“_”(“_”不能开头跟结尾)");

//姓名只能为中文
jQuery.validator.addMethod("aname", function(value, element) {
	var objectName = /^[\u4e00-\u9fa5]+$/;
	return this.optional(element) || (objectName.test(value));
}, "姓名只能为中文");

// 只能包括数字
jQuery.validator.addMethod("number", function(value, element) {
	var objectNum = /^[1-9]{1}[0-9]{0,10}$/;
	return this.optional(element) || (objectNum.test(value));
}, "只能包括大于零的正整数");

// 金额最多有两位小数
jQuery.validator.addMethod("amount", function(value, element) {
	var objectEng = /^\d+(\.\d{1,2})?$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能包括正整数或者两位小数点的小数");

//金额，最多有四位小数
jQuery.validator.addMethod("amount4", function(value, element) {
	var objectEng = /^\d+(\.\d{1,4})?$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能包括正整数或者四位小数点的小数");

//数字字母汉字
jQuery.validator.addMethod("objectName", function(value, element) {
	var objectEng = /^[a-zA-Z0-9\u4e00-\u9fa5]+$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能包括数字字母汉字");


//zip文件
jQuery.validator.addMethod("zipFile", function(value, element) {
	var objectEng = /^(\S+\s*\S+)+\.zip$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能上传后缀必须为.zip的文件");

//excel文件
jQuery.validator.addMethod("excelFile", function(value, element) {
	var objectEng = /^(\S+\s*\S+)+\.xls$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能上传后缀必须为.xls的文件");

//txt文件
jQuery.validator.addMethod("txtFile", function(value, element) {
	var objectEng = /^(\S+\s*\S+)+\.txt$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能上传后缀必须为.txt的文件");

//img文件
jQuery.validator.addMethod("imgFile", function(value, element) {
	var objectEng = /^(\S+\s*\S+)+\.((jpg)|(jpeg)|(png)|(gif)|(bmp))$/;
	return this.optional(element) || (objectEng.test(value));
}, "只能上传gif,jpeg,jpg,bmp,png的图片类型文件");