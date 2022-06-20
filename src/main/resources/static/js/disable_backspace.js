function banBackSpaces(e) {
    var ev = e || window.event;//获取event对象
    var obj = ev.target || ev.srcElement;//获取事件源
    //alert(obj.className);
    var t = obj.type || obj.getAttribute('type');//获取事件源类型
    //alert(obj.className);
    //获取作为判断条件的事件类型
    var vReadOnly = obj.getAttribute('readonly');
    //处理null值情况
    vReadOnly = (vReadOnly == "") ? false : vReadOnly;
    //当敲Backspace键时，事件源类型为密码或单行、多行文本的，
    //并且readonly属性为true或enabled属性为false的，则退格键失效
    var flag1 = (ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea" )
        && vReadOnly == "readonly") ? true : false;
    //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
    var flag2 = (ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea")
        ? true : false;
    if(ev.keyCode == 8 && obj.className == "layui-input layui-unselect"){
        return false;
    }
    if (ev.keyCode == 8 && obj.className == "xm-input xm-select") {
        return false;
    }
    if (ev.keyCode == 8 && obj.className == "xm-input xm-select-input") {
        return false;
    }

    //&& obj.className != "layui-input layui-unselect"
    //判断
    if (flag2) {
        return false;
    }
    if (flag1) {
        return false;
    }
}

window.onload = function () {
    //禁止后退键 作用于Firefox、Opera
    document.onkeypress = banBackSpaces;
    //禁止后退键  作用于IE、Chrome
    document.onkeydown = banBackSpaces;
}