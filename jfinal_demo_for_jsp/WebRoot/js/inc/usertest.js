//�ֻ���֤
function userName(str){
    var reg=/^[1][358][0-9]{9}$/;
    if(reg.test(str)){
        return true;
    }else{
        return false;
    }
};
//������֤
function userPassword(str){
    var reg = /^[a-z0-9_-]{6,18}$/;
    if(reg.test(str)){
        return true;
    }else{
        return false;
    }
};
//��֤���������Ƿ���ͬ
function userPassrepeat(str1 , str2){
    if(str1 != str2){
        return false;
    }
    return true;
};

//ajax����
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
















