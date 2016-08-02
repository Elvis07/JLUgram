$(function(){
	var timer = '';//定时器
	var i = 0;
	var y = 0;
	var tao_timer = '';


	



	//轮换版
	$('.smal_pic li').mouseover(function(){
		clearInterval(timer);
		var backImg = $(this).find('img').attr('backImg');
		var backColor = $(this).find('img').attr('backColor');
		var background = 'url(' + backImg + ') ' + 'repeat center ' + backColor;
		$('#focus_background').css({background : background});
		$(this).addClass('hover').siblings().removeClass('hover');
		i = $(this).index();
		$('.focus_title a').eq(i).show().siblings('a').hide();
	})

	// 移出小图片开启定时器
	$('.smal_pic li').mouseout(function(){
		timer = setInterval(move,1500);
	})

	timer = setInterval(move,1500);

	function move(){
		if(i>6){
			i = 0;
		}
		var backImg = $('.smal_pic li').eq(i).find('img').attr('backImg');
		var backColor = $('.smal_pic li').eq(i).find('img').attr('backColor');
		var background = 'url(' + backImg + ') ' + 'repeat center ' + backColor;
		$('#focus_background').css({background : background});
		$('.smal_pic li').eq(i).addClass('hover').siblings().removeClass('hover');
		$('.focus_title a').eq(i).show().siblings('a').hide();
		i++; 
	}




	

})