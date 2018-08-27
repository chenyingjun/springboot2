var filedId = false, filedImgId = false, filedCode = false;

$(function($) {

	var html = '<iframe id="uploadIframe" name="uploadIframe" style="display: none;"></iframe>'
			+ '<div class="modal fade bs-example-modal-static" id="uploadModal"'
			+ '	tabindex="-1" role="dialog" aria-labelledby="uploadModalLabel"'
			+ '	data-backdrop="static" aria-hidden="true">'
			+ '	<form id="uploadForm" name="uploadForm" action="'
			+ path
			+ '/upload/file" method="post"'
			+ '		accept-charset="UTF-8" enctype="multipart/form-data"'
			+ '		class="form-horizontal" target="uploadIframe">'
			+ '		<div class="modal-dialog">'
			+ '			<div class="modal-content">'
			+ '				<div class="modal-header">'
			+ '				<a aria-hidden="true" data-dismiss="modal" class="close" href="javascript:;">&times;</a>'
			+ '					<h4 class="modal-title">上传图片</h4>'
			+ '				</div>'
			+ '				<div class="modal-body">'
			+ '					<div class="form-group">'
			+ '						<div class="col-sm-12">'
			+ '							<input type="file" id="customUploadFile" name="file" placeholder="单击选择图片" required /><label for="customUploadFile" class="error"></label>'
			+ '						</div>'
			+ '					</div>'
			+ '				</div>'
			+ '				<div class="modal-footer">'
			+ '					<div class="row">'
			+ '						<div class="col-sm-9 col-sm-offset-3">'
			+ '							<button type="submit" class="btn btn-primary">上传</button>'
			+ '						</div>'
			+ '					</div>'
			+ '				</div>'
			+ '			</div>'
			+ '		</div>' + '	</form>' + '</div>';

	$("body").append(html);

	jQuery("#uploadForm").validate(
			{
				rules : {
					/*"file" : {
						imgFile : true,
					},*/
				},
				submitHandler : function(form) {
					var hand = $(form).find("button[type='submit']").attr("data-hand");

					if (hand == "1") {

						return;
					}

					if (iframeRequest) {

						return;
					}

					iframeRequest = true;

					$("form").removeAttr("data-option");

					$(form).attr("data-option", "edit");

					$(form).find("button[type='submit']").attr("disabled", "disabled").text(
							"正在上传...");
					
					$(form).find("button[type='submit']").attr("data-hand", "1");

					$("#editIframe").remove();

					form.submit();
				},
				unhighlight : function(element) {
					jQuery(element).parent().removeClass('has-error');
				},
				highlight : function(element) {
					jQuery(element).parent().removeClass('has-success')
							.addClass('has-error');
				},
				success : function(element) {
					jQuery(element).parent().removeClass('has-error').addClass(
							'has-success');
				}
			});
});

/** 显示上传控件 */
var uploadFormShow = function(id, imgId, code) {

	$("#uploadForm")[0].reset();

	filedId = id;

	filedImgId = imgId;
	
	filedCode = code;
};

/** 上传回调 */
var uploadCallback = function(data) {

	$("form[data-option='edit']").find("button[type='submit']").removeAttr(
			"data-hand");

	$("form[data-option='edit']").find("button[type='submit']").removeAttr(
			"disabled").text("提交");
	
	iframeRequest = false;

	if (data) {

		var code = data.code;

		if (code) {

			if ("200" == code) {

				var t = data.t;

				if (t) {

					if (filedId)
						$("#" + filedId).val(t.url);

					if (filedImgId)
						$("#" + filedImgId).attr("src", t.url);

					if (filedCode)
						$("#" + filedCode).val(t.code);
					
					$("#uploadForm").find(".close").click();

					return;
				}
			}
		}
	}

	$("label[for='customUploadFile']").css("display", "block").text("文件上传失败");
};
