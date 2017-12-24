// 轮播插件
function Roll(opt){
	var settings = {  // settings.obj1,settings.obj2,whether
		obj1 : "", //滚动的容器节点
		obj2 : "", //标识节点外容器
		atuoplay : false, //是否自动播放
		time : "5000", //播放时间
		prev : "",  
		next : ""
	};
	$.extend(settings,opt);
	var aLen = $(settings.obj1).length;
	var a_index = 0;
	var b_index = 0;
	
	for(var i=0;i<aLen;i++){
		$(settings.obj2).append('<span></span>');
	}
	$(settings.obj2).find('span').eq(0).attr('class','active');
	
	if(settings.obj1.length >1){
		$(settings.obj2+' span').each(function(i,d){
			
			$(this).click(function(){
				
				a_index = $(this).index();
				if(a_index==b_index)return;
				tab();
			})
		});
		
		function tab(){
			if( a_index > b_index){
				$(settings.obj1).eq(a_index).css('left','100%');
				$(settings.obj1).eq(a_index).animate({left:0});
				$(settings.obj1).eq(b_index).animate({left:"-100%"});
				b_index = a_index
			}else{
				$(settings.obj1).eq(a_index).css('left','-100%');
				$(settings.obj1).eq(a_index).animate({left:0});
				$(settings.obj1).eq(b_index).animate({left:"100%"});
				b_index = a_index
			}
			$(settings.obj2+' span').eq(a_index).addClass("active").siblings('span').removeClass('active');
		};
		
		if(settings.atuoplay && $(settings.obj1).length>1 ){
			setInterval(function(){
				a_index++;
				if(a_index>aLen-1){
					a_index = 0
				}
				tab();
			},settings.time);
		};
		
		$(settings.prev).click(function(){
			a_index++;
			if(a_index>aLen-1){
				a_index = 0
			}
			tab();
		});
		
		$(settings.prev).click(function(){
			a_index--;
			if(a_index>aLen-1){
				a_index = 0
			}
			tab();
		});
	}
	
};

//放大镜插件
function Magnifier(opt){
	var settings = {
		obj1 : "", //大图接单
		obg2 : "", //小图容器
		mask : {	//蒙版参数
			width : "100",
			height : "100",
			backgroundPath : ""
		},
		enlarge : {
			top : "0",
			left: "0"
		}
	};
	
	var downX = 0;
	var downY = 0;
	
	$.extend(settings , opt);
	
	$(settings.obj2).each(function(i,d){
		$(this).click(function(){
			//alert($(this).attr('src'))
			$(settings.obj1).find('img').attr('src',$(this).find('img').attr('src'))
		})
	})
	
	$(settings.obj1).mouseenter(function(){
		$(this).append('<span class="mallmask"></span>');
		$('.mallmask').css({
			width : settings.mask.width , 
			height : settings.mask.height
		});
		$('.mallmask').css("background",'url('+settings.mask.backgroundPath+') no-repeat center');
		$(this).parent().css('position','relative');
		$(this).parent().append('<div class="fangda"><div>');
		$('.fangda').css({position:'absolute' , top: settings.enlarge.top ,overflow:'hidden', left: settings.enlarge.left,width:$(this).width(),height:$(this).height()});
		$('.fangda').append('<img/>');
		$('.fangda img').css({position:'absolute',top:'0',left:'0'});
		$('.fangda img').attr('src',$(this).find('img').attr('src'))
	}).mouseleave(function(){
		$('.mallmask').remove();
		$('.fangda').remove();
	});
	$(settings.obj1).on("mousemove" , function(e){
		downX = e.pageX-$(this).offset().left;
		downY = e.pageY-$(this).offset().top;
		
		var L = downX - ( $('.mallmask').width() )/2;
		var T = downY - ( $('.mallmask').height() )/2;
		if(L<0){
			L=0;
		}else if( L> $(this).width()-$('.mallmask').width() ){
			L = $(this).width()-$('.mallmask').width();
		}
		if(T<0){
			T = 0;
		}else if( T>$(this).height()-$('.mallmask').height()){
			T = $(this).height()-$('.mallmask').height();
		}
		$('.mallmask').css('left',L );
		$('.mallmask').css('top',T );
		var scaleX = L/( $(this).width()-$('.mallmask').width() );
		var scaleY = T/( $(this).height()-$('.mallmask').height() );
		$('.fangda img').css('left', -scaleX*($('.fangda img').width()-$('.fangda').width()) );
		$('.fangda img').css('top', -scaleY*( $('.fangda img').height()-$('.fangda').height() ) );
	});
};

//购物车全选反选
function Selectbox(opt){
	var settings = {
		obj1 : "",
		obj2 : "",
		fn : function(){}
	};
	$.extend(settings , opt);
	$(settings.obj1).click(function(){
		if( $(this).prop('checked') ){
			
			$(this).prop('checked');
			$(settings.obj2).prop('checked',true)
		}else{
			$(this).attr('checked',false)
			$(settings.obj2).prop('checked',false)
		}
	});
	$(settings.obj2).click(function(){ 
		
		if( isChecked() ){
			$(settings.obj1).prop('checked',true)
		}else{
			$(settings.obj1).prop('checked',false)
		}
	});
	function isChecked(){
		var bBtn = true;
		$(settings.obj2).each(function(i,elem){
			if( !$(elem).prop('checked') ){
				bBtn = false;
				return false;
			}
		});
		return bBtn;
	};
};

//原生滑动插件
function Side(opt){
	var settings = {
		obj1 : "", //相对定位容器的id
		obj2 : "", //绝对定位容器的id
		axis : ""  //滑动的方向X或Y
	};	
	extend(settings,opt);
	
	var oDiv = document.getElementById( settings.obj1 );
	var oUl = document.getElementById( settings.obj2 );
	
	if( oDiv.offsetHeight < oUl.offsetHeight || oDiv.offsetWidth < oUl.offsetWidth ){
		var downY = 0;
		var downTop = 0;
		var iSpeed = 0;
		var prevY = 0;
		var timer = null;
		//oUl.addEventListener("touchmove",function(ev){ev.preventDefault();},false);
		oUl.addEventListener("touchstart",fnStart,false);
		function fnStart(ev){
			var touchs = ev.changedTouches[0];
			oUl.style.transition = "0s";
			if(settings.axis == "Y"){
				downX = touchs.pageY;
				downTop = this.offsetTop;
				prevY = touchs.pageY;	
			};
			if( settings.axis == "X" ){
				downY = touchs.pageX;
				downTop = this.offsetLeft;
				prevY = touchs.pageX;		
			}
			oUl.addEventListener("touchmove",fnMove,false);	
			function fnMove(ev){
				var touchs = ev.changedTouches[0];
				if( settings.axis == "Y" ){
					var T = touchs.pageY-downX+downTop;
					iSpeed = touchs.pageY - prevY;
					prevY = touchs.pageY; 
					if( T > 0 ){
						T = 0;	
					}else if( T < oDiv.offsetHeight - oUl.offsetHeight ){
						T = oDiv.offsetHeight - oUl.offsetHeight;	
					};	
					oUl.style.top = T+'px';
				};
				
				if( settings.axis == "X" ){
					var T = touchs.pageX-downY+downTop;
					iSpeed = touchs.pageX - prevY;
					prevY = touchs.pageX; 
					if( T > 0 ){
						T = 0;	
					}else if( T < oDiv.offsetWidth - oUl.offsetWidth ){
						T = oDiv.offsetWidth - oUl.offsetWidth;	
					};	
					
					oUl.style.left = T+'px';
				}
				
					
			}
			oUl.addEventListener("touchend",fnEnd,false);	
			function fnEnd(ev){
				clearInterval(timer);
				timer = setInterval(function(){
					if( settings.axis == "Y" ){
						if( Math.abs(iSpeed) < 1 || oUl.offsetTop>0 || oUl.offsetTop < oDiv.offsetHeight - oUl.offsetHeight  ){
							clearInterval(timer);
							
							if(oUl.offsetTop>0){
								
								oUl.style.transition = "0.3s";
								oUl.style.top = 0;	
							}else if( oUl.offsetTop < oDiv.offsetHeight - oUl.offsetHeight  ){
								oUl.style.transition = "0.3s";	
								oUl.style.top = oDiv.offsetHeight - oUl.offsetHeight + 'px';
							}
								
						}else{
							oUl.style.transition = "0s";
							iSpeed *=0.95;
							oUl.style.top = oUl.offsetTop + iSpeed + 'px';	
						}	
					};
					
					if( settings.axis == "X" ){
						if( Math.abs(iSpeed) < 1 || oUl.offsetLeft>0 || oUl.offsetLeft < oDiv.offsetWidth - oUl.offsetWidth ){
							clearInterval(timer);
							
							if(oUl.offsetLeft>0){
								oUl.style.transition = "0.3s";
								oUl.style.left = 0;	
							}else if( oUl.offsetLeft < oDiv.offsetWidth - oUl.offsetWidth  ){
								
								oUl.style.transition = "0.3s"
								oUl.style.left = oDiv.offsetWidth - oUl.offsetWidth + 'px';
							}
								
						}else{
							oUl.style.transition = "0s";
							iSpeed *=0.95;
							oUl.style.left = oUl.offsetLeft + iSpeed + 'px';	
						}		
					}
				},13);
				oUl.removeEventListener("touchmove",fnMove,false);
				oUl.removeEventListener("touchend",fnEnd,false);	
			}
		}	
	}
	
	function extend(obj1,obj2){
		for( var attr in obj2 ){
			obj1[attr] = obj2[attr]	
		}
	};
	
};

//手机滑动轮播插件
function SideBanner(opt){
	var settings = {
		obj1 : "", //外容器节点
		obj2 : "", //滑动ul
		obj3 : "", //高亮的节点
		autoPlay : false,
		time : "3000"
	};
	
	$.extend(settings , opt);
	
	$(settings.obj1).css({
		position : "relative",	
	});
	
	$(settings.obj2).children().css({
		width :  $(settings.obj1).width(),
		height :  $(settings.obj1).height(),
	});
	$(settings.obj2).css({
		position : "absolute",
		top : 0,
		left : 0,
		width : $(settings.obj1).width()*$(settings.obj2).children().length,
		height : $(settings.obj1).height()
	});	
	
	$(settings.obj2).children().css('float','left');
	if($(settings.obj2).children().length != $(settings.obj3).children().length ){
		$.each( $(settings.obj2).children() , function(){
			var $span = $('<span></span>');
			$(settings.obj3).append( $span );
		});
	}
	
	$(settings.obj3).find('span').eq(0).attr('class','active');
	
	if( $(settings.obj2).children().length>1 ){
		$(settings.obj1).on('touchmove',function(e){
			e.preventDefault()
		});
		
		var downX = 0;
		var downLeft = 0;
		var iNow = 0;
		var oTimer = null;
		
		
		function autoPlay(){
			oTimer = setInterval(function(){
				iNow++;
				iNow = iNow%$(settings.obj2).children().length;
				sideTab();
			},settings.time)	
		}
		
		if( settings.autoPlay ){
			autoPlay();
		}
		
		$(settings.obj2).on('touchstart',function(e){
			var touches = e.originalEvent.changedTouches[0];
			var bBtn = true;
			$(settings.obj2).css('transition',"0s");
			clearInterval(oTimer);
			downX = touches.pageX;
			downLeft = $(this).position().left;
			
			$(settings.obj2).on('touchmove',function(e){
				var touches = e.originalEvent.changedTouches[0];
				var L = touches.pageX - downX + downLeft;
				if( $(this).position().left>=0 ){
					if(bBtn){
						bBtn = false;
						downX = touches.pageX;
					}
					$(settings.obj2).css({
						left : (touches.pageX - downX)/10 
					});	
				}
				else if( $(this).position().left <= $(settings.obj1).width() -  $(settings.obj2).width() ){
					if(bBtn){
						bBtn = false;
						downX = touches.pageX;
					}
					$(settings.obj2).css({
						left : (touches.pageX - downX)/10 + $(settings.obj1).width()-$(settings.obj2).width()
					});	
				}else{
					
					$(settings.obj2).css({
						left : L
					});
				}	
			});
			
			$(settings.obj2).on('touchend',function(e){
				var touches = e.originalEvent.changedTouches[0];
				
				if( touches.pageX < downX && Math.abs( touches.pageX-downX ) >20  ){
					iNow++;
					if(iNow >= $(settings.obj2).children().length-1){
						iNow = $(settings.obj2).children().length-1
					}
					sideTab();	
				}
				else if( touches.pageX > downX && Math.abs( touches.pageX-downX ) >20 ){
					iNow--;
					if( iNow<=0 ){
						iNow = 0	
					}
					sideTab();		
				}else{
					sideTab();
				}
				
				if( settings.autoPlay ){
					autoPlay();
				}
				
				$(settings.obj2).off('touchmove');
				$(settings.obj2).off('touchend');
			})
		});
	};
	
	function sideTab(){
		$(settings.obj3).find('span').eq(iNow).addClass('active').siblings('span').removeClass('active');
		$(settings.obj2).css({
			transition : '0.4s',
			left : -$(settings.obj1).width()*iNow
		});	
	}
	
};

function scale(obj,n){
	$(obj).css('height',$(this).width()*n)
};

//滑动弹框
$.fn.extend({
	sideBox : function(opt){
			var settings = {
					obj1 : "", //所要弹的框
					zIndex : "", //弹框的z-index
					direction : "", //弹框的位置方向
					backBtn : "" // 返回节点
				};
			$.extend(settings , opt);
		$(this).click(function(){
			$(settings.obj1).css("position","fixed");
			$(settings.obj1).css("zIndex",settings.zIndex);
			$(settings.obj1).css("display","block");
			var $div = $('<div id="mask"></div>');
			$div.css({
				width : "100%",
				height : "100%",
				position : "fixed",
				top : 0,
				left:0,
				zIndex : settings.zIndex-1,
				background : "rgba(55,55,55,0.1)"
			});
			$("body").append($div);
			if( settings.direction == "right" ){
				$(settings.obj1).css({
					left : $(window).width(),
					top:0	
				});	
				$(settings.obj1).animate({left:0});
			}else if(settings.direction == "left"){
				$(settings.obj1).css({
					left : -$(window).width(),
					top:0	
				});	
				$(settings.obj1).animate({left:0});
			}else if(settings.direction == "up"){
				$(settings.obj1).css({
					left : 0,
					top:-$(settings.obj1).height()	
				});	
				$(settings.obj1).animate({top:0});
			}else if(settings.direction == "down"){
				$(settings.obj1).css({
					left : 0,
					bottom:-$(settings.obj1).height()	
				});	
				$(settings.obj1).animate({bottom:0});
			};
		});
		
		$("body").delegate('#mask','click',function(){
			back();	
		});	
		$("body").delegate(settings.backBtn,'click',function(){
			back();	
		});
		function back(){
			if( settings.direction == "right" ){
				$(settings.obj1).animate({left:$(window).width()});	
			}else if(settings.direction == "left"){
				$(settings.obj1).animate({left:-$(window).width()});	
			}else if(settings.direction == "up"){
				$(settings.obj1).animate({top:-$(settings.obj1).height()});	
			}else if(settings.direction == "down"){
				$(settings.obj1).animate({bottom:-$(settings.obj1).height()});	
			};
			$("#mask").remove();
		}
	}
});	






