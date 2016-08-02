function executeqq() {
	var openid;
	var paras = {};

	QC.api("get_user_info", paras)
	// 指定接口访问成功的接收函数，s为成功返回Response对象
	.success(function(s) {
		// 成功回调，通过s.data获取OpenAPI的返回数据

		upload(s.data.nickname, s.data.gender, s.data.figureurl_qq_2);

	})
	// 指定接口访问失败的接收函数，f为失败返回Response对象
	.error(function(f) {
		// 失败回调
		qq_error(f); // 这个地方可以自动以逻辑处理，也可以不处理，就是请求失败的提示
	})
	// 指定接口完成请求后的接收函数，c为完成请求返回Response对象
	.complete(function(c) {
		// 完成请求回调
		// qq_complete(c);
	});
	QC.Login.getMe(function(openId, accessToken) {
		openid = openId;

	})

	function upload(a, b, c) {

		$.ajax({
			url : 'userQQ',
			type : 'post',
			data : {
				"openId" : openid,
				"nickname" : a,
				"gender" : b,
				"figureurl_qq_2" : c
			},
			dataType : 'json',
			success : function(data) {
				location.href = "index.jsp";
			},
			error : function() {

			}

		});

		/* 后台获取session.user */
		$.ajax({
			url : 'userShowQQ',
			type : 'post',
			data : {
				"openId" : openid,
			},
			dataType : 'json',
			success : function(data) {

			},
			error : function() {

			}

		});

	}
}
function cancel() {
	// 方法体
	QC.Login.signOut()
}

var openid;

var paras = {};
//调用QC.Login方法，指定btnId参数将按钮绑定在容器节点中
QC.Login({
	//btnId：插入按钮的节点id，必选
	btnId : "qqLoginBtn",
	//用户需要确认的scope授权项，可选，默认all
	scope : "all",
	//按钮尺寸，可用值[A_XL| A_L| A_M| A_S|  B_M| B_S| C_S]，可选，默认B_S
	size : "A_L"
}, function(reqData, opts) {//登录成功
	/*	//根据返回数据，更换按钮显示状态方法
		var dom = document.getElementById(opts['btnId']), _logoutTemplate = [
		//头像

		//昵称

		//退出
		'<span><a href="javascript:QC.Login.signOut();">注销QQ</a></span>' ]
				.join("");
		dom && 
	 */(dom.innerHTML = QC.String.format(_logoutTemplate, {
		nickname : QC.String.escHTML(reqData.nickname), //做xss过滤
		figureurl : reqData.figureurl
	}));
}, function(opts) {//注销成功
	confirm("Are you sure to cancel?");
});