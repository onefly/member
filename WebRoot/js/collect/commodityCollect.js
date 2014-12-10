//跳转页面
	function toCommodityPage(all) {
		var target = $('#commodityPage').val();
		if(0 < target && target <= all){
			location = basePath+"/collect/getCommodityCollect.htm?page="+target;
		}else{
			alert('无效字符');
		}
		
	}
	//查看收藏的品牌
	function showBrand(){
		location = basePath+"/collect/getBrandCollect.htm";
	}
	//选中所有商品
	function selectAllCommodity(){
		if($('#allCombox').attr("checked")=="checked"){
			  $("input[name=commodityBox]").each(function(){
			      $(this).attr("checked","checked");
			      });
		}else{
			$("input[name=commodityBox]").each(function(){
			      $(this).attr("checked",false);
			  });
		}
		
	}
	//删除选中的商品
	function deleteCommodity(){
		var ids = "";
		var index = 0;
		 $("input[name=commodityBox]").each(function(){
		      if($(this).attr("checked") == "checked"){
		    	  ids+=$(this).val()+",";
		    	  index++;
		      }
		      });
		 if(index>0){
			 location =basePath+ "/collect/deleteCommodityCollect.htm?ids="+ids;
		 }else{
			 alert('请选择需要删除的商品');
		 }
	}