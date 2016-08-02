$(function() {
	$("form :input")
			.blur(
					function() {
						var $parent = $(this).parent();
						if ($(this).is("#username")) {
							if (this.value != "") {
								$
										.ajax({
											url : 'userValidate',
											type : 'post',
											data : {
												"nameVal" : this.value,
											},
											dataType : 'json',
											success : function(data) {
												if (data != null) {
													$parent
															.append('<span class="formtips ErrorMsg">'
																	+ "账号已存在，请重新输入"
																	+ '</span');

												}
											}
										});

							}
						}

					});

});

$(function() {
	$("form :input")
			.blur(
					function() {
						var $parent = $(this).parent();
						if ($(this).is("#nickname")) {
							if (this.value != "") {
								$
										.ajax({
											url : 'userNickValidate',
											type : 'post',
											data : {
												"nickVal" : this.value,
											},
											dataType : 'json',
											success : function(data) {
												if (data != null) {
													$parent
															.append('<span class="formtips ErrorMsg">'
																	+ "昵称已存在，请重新输入"
																	+ '</span');

												}
											}
										});

							}
						}

					});

});
$(function() {

	$("form :input").blur(
			function() {
				var $parent = $(this).parent();
				$parent.find(".formtips").remove();
				if ($(this).is("#username")) {
					if (this.value == "") {
						var errorMsg = '请输入账号';
						$parent.append('<span class="formtips ErrorMsg">'
								+ errorMsg + '</span');
					}
				}
				if ($(this).is("#password")) {
					if (this.value == "") {
						var errorMsg = '请输入密码';
						$parent.append('<span class="formtips ErrorMsg">'
								+ errorMsg + '</span');
					}
				}
				if ($(this).is("#nickname")) {
					if (this.value == "") {
						var errorMsg = '请输入昵称';
						$parent.append('<span class="formtips ErrorMsg">'
								+ errorMsg + '</span');
					}
				}
			})
});