var dateSelector={
	leapYear:1,
	normalYear:0,
	monthDayCount:new Array(31,28,31,30,31,30,31,31,30,31,30,31)
};

dateSelector.isLeapYear=function(year){
	return ((year%4==0 && year%100!=0)||(year%400==0))?1:0;
};
/*
 * 初始化函数，
 * 参数分别为选择年份的select元素的id值，选择月份的select元素的id值，选择日期的select元素的id值
 * 在项目中引入次js文件后，dateSelector.init(year,month,day)来初始化日期选择框
 */
dateSelector.init=function(year,month,day){
	var me=this;
	var now=new Date();
	var startYear=now.getFullYear()-60;
	var yearCount=60;
	$("#"+year).append("<option value='"+0+"'>"+"请选择"+"</option>");
	$("#"+month).append("<option value='"+0+"'>"+"请选择"+"</option>");
	$("#"+day).append("<option value='"+0+"'>"+"请选择"+"</option>");
	for(var i=1;i<=yearCount;i++){		
		$("#"+year).append("<option value='"+startYear+"'>"+startYear+"</option>");
		startYear++;		
		if(i<=12){			
			$("#"+month).append("<option value='"+i+"'>"+i+"</option>");			
		}						
	}
	
	$("#"+year).change(function(){
		$("#"+month).val(0);
		$("#"+day).val(0);
	});
	
	$("#"+month).change(function(){
		var selectedYear=$("#"+year).val();
		var selectedMonth=$("#"+month).val();
		var dayCount=0;
		if(selectedYear!=null&&selectedYear!=0){			
			if(selectedMonth!=null&&selectedMonth!=0){
				dayCount=(me.monthDayCount)[selectedMonth-1];				
				if(selectedMonth==2){
					dayCount+=me.isLeapYear(selectedYear);   
				}
			}
		}
		for(var i=1;i<=dayCount;i++){
			$("#"+day).append("<option value='"+i+"'>"+i+"</option>");
		}	
	});
	
};