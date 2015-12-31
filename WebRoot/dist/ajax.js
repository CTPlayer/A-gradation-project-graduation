		$(document).ready(function(){
			$("#next").click(function(){
			var pageNo = parseInt($("#current").html())+1;
			$.ajax({
				type:"GET",
				url:"paging.do?pageNo="+pageNo,
				success:function(data){
					//$("#ct").html(data);
					$(document).find("html").html(data);
				}
			});
			});
		$("#prev").click(function(){
			var value = $("b").html();
			if(value>1){
				$("b").remove();
				$("#"+value).html(value);
				var pageNo = parseInt(value)-1;
				$("#"+pageNo).html("<b>"+pageNo+"</b>");
				$.ajax({
					type:"GET",
					url:"paging.do?pageNo="+pageNo
				});
			}
		});
	});
//function f2(event){
//	var number = $(event);
//	var value = number.html();//点击时对应的页数
//	var value2 = $("b").html();//当前<b>标签对应的值
//	$("b").remove();
//	$("#"+value2).html(value2);
//	number.html("<b>"+value+"</b>");
//	$(event).click(function(){
//		$.ajax({
//			type:"GET",
//			url:"paging.do?pageNo="+value
//		});
//	});
//}