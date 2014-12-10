
function toBrandPage(all) {
		var target = $('#brandPage').val();
		if(0 < target && target <= all){
			location = basePath+"/collect/getBrandCollect.htm?page="+target;
		}else{
			alert('无效字符');
		}		
	}
	function showCommodity(){
		location = basePath+"/collect/getCommodityCollect.htm";
	}
	function selectAllBrand(){
		if($('#allCombox').attr("checked")=="checked"){
			  $("input[name=brandBox]").each(function(){
			      $(this).attr("checked","checked");
			      });
		}else{
			$("input[name=brandBox]").each(function(){
			      $(this).attr("checked",false);
			  });
		}
		 
	}
	function deleteBrand(){
		var ids = "";
		var index = 0;
		 $("input[name=brandBox]").each(function(){
		      if($(this).attr("checked") == "checked"){
		    	  ids+=$(this).val()+",";
		    	  index++;
		      }
		      });
		 if(index>0){
			 location = basePath+"/collect/deleteBrandCollect.htm?ids="+ids;
		 }else{
			 alert('请选择需要删除的品牌');
		 }
	}