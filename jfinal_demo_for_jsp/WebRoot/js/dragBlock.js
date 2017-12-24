function dragBlock(obj){
    var downX = 0 , downY = 0 , downLeft = 0, downTop=0;
    $(obj).on('touchstart',function(e){
        var touches = e.originalEvent.changedTouches[0];
        var startTime = new Date().getTime();
        $(this).css('transition' , '0s')
        downX = touches.pageX;
        downY = touches.pageY;
        downLeft = $(this).position().left;
        downTop = $(this).position().top;
        $(obj).on('touchmove',function(e) {
            var touches = e.originalEvent.changedTouches[0];
            var L = touches.pageX-downX+downLeft;
            var T = touches.pageY-downY+downTop;
            e.preventDefault()
            if( L <= 0){
                L = 0;
            }else if( L >= $(window).width()-$(this).width() ){
                L = $(window).width-$(this).width()
            };
            if( T<=0 ){
                T=0
            }else if( T >= $(window).height()-$(this).height() ){
                T = $(window).height()-$(this).height();
            };
            $(this).css({
                left : L,
                top : T
            })
        });
        $(obj).on('touchend',function(){
            var endTime = new Date().getTime();
            var winWidth = $(window).width() - $(this).width();
                $(this).css('transition' , '0.3s')
            if( $(this).position().left <= winWidth/2 ){
                $(this).css('left' , '0')
            }else if($(this).position().left > winWidth/2){
                $(this).css('left' , winWidth)
            };
            if( endTime-startTime <= 120 ){
                window.location.href="/user/sign.html";
            }
            $(obj).off('touchmove');
            $(obj).off('touchend');
        });
        return false;
    })
}