$(function() {
    loadStudents();
});

  function loadStudents(){

    $("tbody").empty();
      //通过ajax异步请求数据
    $.ajax({
        url: "http://192.168.24.128:8080/demo/students", //请求的服务器地址
        type: "GET", //请求方式
        dataType: "json", //服务器返回数据的类型
        beforeSend: function() {
          //在发起请求前执行的回调函数
          //console.log("准备发起请求");
          $(".loading").show();
        },
        success: function(resp) {
          //ajax执行成功并得到服务器响应的数据
          //console.log("success");
          //console.log(resp)
  
          $(resp).each(function(index, item) {
            //console.log($(this));
            //console.log(item);
  
            var tr = `<tr>
                            <td><input type='checkbox' name='all' value='${item.stuNo}' /></td>
                            <td>${item.stuNo}</td>
                            <td>${item.stuName}</td>
                            <td>${item.gender}</td>
                            <td>
                                <a class='btn'>删除</a>    
                            </td>
                        </tr>`;
            //将tr转换为jquery的对象
            var tr_obj = $(tr);
            $("tbody").append(tr_obj);
          });
        },
        error: function() {
          //ajax在执行中发生错误
          console.log("error");
        },
        complete: function() {
          //ajax执行完触发的回调函数,不管ajax是否执行成功或发生错误，均触发complete
          //console.log("complete");
          $(".loading").hide();
        }
      });
  }

  $(function(){

    $("#chose_all").change(function (e) { 
        var isChecked = $(this).prop("checked");
        //console.log(isChecked)
        var allCheckbox = $("tbody :checkbox")
        allCheckbox.prop("checked",isChecked)
        
    });;

    $("#btn_add").click(function(){
        $(".mask").show()
        $(".register_wrap").show();
    });

    $(".register_wrap").click(function(e){
        
        //console.log(e);

        var $target = $(e.target); //将e.target的dom对象转换为jquery对象
        if($target.hasClass('register_wrap')){
            $(".mask").hide()
            $(".register_wrap").hide();
        }
    });

    $(".register_wrap form").submit(function(e){
        e.preventDefault();//阻止表单的默认行为，阻止表单提交

        //console.log("进入表单的submit事件")
        var flag = true;

        $(":text,:password").each(function(){
            var $this = $(this);//遍历时，this代表着每个input的dom对象
            if($this.val() == ''){
                flag = false;
                var text = $this.parents(".form-item").find("div:first label").text();
                var tag = '<span>'+text+'不能为空</span>';
                $(".message").append($(tag));
                //return false; //在jquery中的each，return false代表着退出循环。
            }
        });

        
        if($("[name='gender']:checked").length == 0){
            flag = false;
            var tag = '<span>请选择性别</span>';
            $(".message").append($(tag));
        }

        if(flag){//表单通过验证

            console.log($(".register_wrap form").serialize());
            

            //console.log("表单通过验证，允许提交");
            $.ajax({
                url:'http://192.168.24.128:8080/demo/register',
                type:'POST',
                dataType:'json',
                // data:{
                //     stuName:$("[name='stuName']").val(),
                //     stuPwd:$("[name='stuPwd']").val(),
                //     gender:$("[name='gender']:checked").val(),
                // },
                data:$(".register_wrap form").serialize(),
                success:function(resp){
                    if(resp.isSuccess){
                        //关闭当前的注册窗口
                        $(".mask").hide()
                        $(".register_wrap").hide();
                        //重新请求所有学生的信息
                        loadStudents();
                    }
                }
            });
        } 
    });

    $("tbody").on("click","a.btn",function(e){
        e.preventDefault();
        console.log("-------------------------");
        var stuNo = $(e.target).parents("tr").find("td:first :checkbox").val();
        if(confirm("确认删除学号" + stuNo + "吗？")){
            $.getJSON("http://192.168.24.128:8080/demo/deleteByStuNo",{"stuNo":stuNo},function(){
                loadStudents();
            });
        }
        
        
    })
  });