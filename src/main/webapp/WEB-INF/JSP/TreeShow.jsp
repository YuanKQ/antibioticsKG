<%--
  Created by IntelliJ IDEA.
  User: huangjiyue
  Date: 17/11/12
  Time: 上午11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TreeShow</title>
</head>
<body>
<hr>
<input type="button" value="点击获取菜单" id="getmenu">

<div id="menuDiv" style="height:500px;font-size: 10px;">

</div>
<script>
    $('#getmenu').click(function(){
        $.ajax({
            url:'Getmenu',
            type:'get',
            dataType:'text',
            success:function (data) {
                $('#menuDiv').empty();  //清空div内容
                var data=eval("("+data+")");
                var parent_arr =  Object.getOwnPropertyNames(data);  //获取data属性集合，即parent_menu
                for(var i = 0;i<parent_arr.length;i++){  //遍历parent_menu
                    var obj2=eval("("+parent_arr[i]+")");
                    $('#menuDiv').append("<hr><input type='checkbox' >"+obj2.antibiotic_name+"<hr>");
                    for(var j = 0;j<data[parent_arr[i]].length;j++){            //获取parent_menu下的child_menu
                        $('#menuDiv').append("<input type='checkbox' style='margin-left:20px;'>"+data[parent_arr[i]][j].menu_name+"<br>");
                    }
                }
            }
        });
    });
</script>

</body>
</html>
