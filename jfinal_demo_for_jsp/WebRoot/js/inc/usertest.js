//手机验证
function userName(str){
    var reg=/^[1][358][0-9]{9}$/;
    if(reg.test(str)){
        return true;
    }else{
        return false;
    }
};
//密码验证
function userPassword(str){
    var reg = /^[a-z0-9_-]{6,18}$/;
    if(reg.test(str)){
        return true;
    }else{
        return false;
    }
};
//验证两次密码是否相同
function userPassrepeat(str1 , str2){
    if(str1 != str2){
        return false;
    }
    return true;
};

//ajax函数
function ajaxload(url,type,fn){
    $.ajax({
        url : url,
        type : type,
        dataType : 'josn',
        success : function(data){
            fn(data)
        }
    })
};
















