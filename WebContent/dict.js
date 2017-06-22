
$(document).ready(function (){

	$("#lookUp").click(function (){
		console.log("Searcing...");
		search();
    });
	
	function search(){ 
	  $.ajax({
		  url:"./DictServlet",
		  type:"POST",
		  dataType:"json",
		  data:{
			  word:$("#searchWord").val()
		  },
		  succee:function(resultData){
			   $("#result").html("");
			   var output="";
			   if(resultData.length===0){
				   $("#result").html("<em>No Matching Word Found!</em>");
			   }
			   else{
				   $.each(resultData,function(index,value){
					   if( value['wordType']===""){
							 output=output+value['word']+" "+value['definition'];
						}
					   else{
						   output=output+value['word']+" "+value['definition']+" "+value['wordtype']
					   }
					   });
					   
					   $("#result").html(output);
				    }

		  },
		  
		  error:function(){
			   $("#result").html("Error");
			  
		  },
		  
	  });
  } 
  });