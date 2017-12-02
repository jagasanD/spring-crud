<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registration</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
   <style type="text/css">
  .full-width{
  width:100%;
}
.margin-top{
   margin-top: 3%;
}
.fa-font-size{
    font-size: 18px;
    cursor: pointer;
    
}
.fa-delete{
color: #c33030;
}
.fa-edit1{
color: #257325;
padding-right: 5px
}
.table-th{

 background-color: #80bde2;
    color: white;
}
.img-set{
height: 70px;
    width: 60px;
}

.panel-heading{

 background-color: #80bde2 !important;
    color: white !important;
}
   
  </style>

</head>


<body>
  <div class="container margin-top">
  <div class="row">
   <div class="col-md-4 col-sm-6 col-lg-4">
<div class="panel panel-default">
 <div class="panel-heading text-center">Registration Form</div>
    <div class="panel-body">
<form id="registerSubmit"  enctype="multipart/form-data">
  <div class="form-group">
  
   <input type="hidden" name="userId" value="0">
  
    <label for="email">Employee Name:</label>
    <input type="text"  name="userName" class="form-control" id="name">
  </div>
    <div class="form-group">
    <label for="email">Employee Email:</label>
    <input type="email" name="email" class="form-control" id="email">
  </div>

  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="password" class="form-control" id="pwd">
  </div>
   <div class="form-group">
  <input type="file" name="file" class="form-control" />
  </div>
  
  <div class="checkbox">
    <label><input type="checkbox"> Remember me</label>
  </div>
  <button type="button" class="btn btn-info center full-width submitButton">Submit</button>
</form>
</div>
  </div>
</div>

 <div class="col-md-6 col-sm-6 col-lg-8">
  <table class="table table-bordered">
  <thead class="table-th">
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Email</th>
      <th>Password</th>
      <th>Img</th>
      <th>Action</th>
    </tr>
  </thead>
  <tbody class="appendData">
    <tr class="index-1">
      <td scope="row">1</td>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td><img class="img-set" alt="logo" /></td>
      <td>
      <span><i class="fa fa-pencil fa-font-size fa-edit1 " id="editClick" aria-hidden="true" ></i></span>
      <i class="fa fa-trash fa-font-size  fa-delete" aria-hidden="true"></i>
      </td>
    </tr>
  </tbody>
</table>
  </div>

<div>
</div>


<script>


function myFunction(id) {
	console.log("-----calls--------"+id);

	$('#'+id).closest('tr').children('td').each(function(index) {
		if(index==0){
			$('input[name="userId"]').val($(this).text());
			console.log($(this).text());
		}else if(index==1){
			$('input[name="userName"]').val($(this).text());
			console.log($(this).text());
		}else if(index==2){
			$('input[name="email"]').val($(this).text());
				console.log($(this).text());
    		}else if(index==3){
    			$('input[name="password"]').val($(this).text());
    			//console.log($(this).text());
    		}
        
    })
}


function deleteFunction(id) {
	console.log("-----calls--------"+id);

	$('#'+id).closest('tr').children('td').each(function(index) {
		if(index==0){
			
			var value= $(this).text()
			
			$.ajax({
	    	      type: "POST",
	    	      url: "/myapp/user/delete-user/"+value,
	    	      data:  $("#registerSubmit").serialize(),
	    	      success: function(resultData){
	    	         var deleteRow = "replaceVal-"+value;
	    	         
	    	         if(resultData.status=="SUCCESS"){
	    	        	
	    	        	 $('#'+deleteRow).remove();
	    	         }
	    	       
	    			
	    	      },
	    	      error: function (textStatus, errorThrown) {
	                  
	    	    	 
	              }
	    });
			
			
			
			
			
		}
    })
}


$(document).ready(function(){
	
	
	$.ajax({
	      type: "GET",
	      url: "/myapp/user/get-user-list",
	      success: function(resultData){
	        // alert(resultData);
	         console.log(resultData);
	         for(var i=0; i<resultData.data.length;i++){
	        	// var alternateRowTemplate = "<tr><th>"+resultData.data[i].userId+"</th><td>"+resultData.data[i].userName+"</td><td>"+resultData.data[i].email+"</td><td>"+resultData.data[i].password+"</td></tr>";
	     var editVal ="editClick-"+resultData.data[i].userId;
	    var theAnchorText = 'I\'m home';
	   console.log(theAnchorText);
	  
	   var quote_str = '\'editVal\'';
	   
	 
	  
	       var alternateRowTemplate = '<tr id="replaceVal-'+resultData.data[i].userId+'"><td>'+resultData.data[i].userId+'</td><td>'+resultData.data[i].userName+'</td><td>'+resultData.data[i].email+'</td><td>'+resultData.data[i].password+'</td>'+
	       '<td><img class="img-set" alt="logo" src="/myapp/user/download/'+resultData.data[i].fileId+'"/></td>'+
   	          '<td><span><i class="fa fa-pencil fa-font-size fa-edit1 " id="editClick'+resultData.data[i].userId+'" aria-hidden="true" onclick="myFunction(&quot;'+"editClick"+resultData.data[i].userId+'&quot;)"></i></span>'+
   	          '<span><i class="fa fa-trash fa-font-size  fa-delete" aria-hidden="true" onclick="deleteFunction(&quot;'+"editClick"+resultData.data[i].userId+'&quot;)"></i></span>'+
   	          '</td></tr>';
		          
   	       
   	          
		          $(".appendData").append(alternateRowTemplate);
	        	// alert();
	        	 
	         }
	       
	      },
	      error: function (textStatus, errorThrown) {
            
	    	 
        }
});
	
	
	
	
    $(".submitButton").click(function(){
    	var formData = new FormData();
    	var file=$('input[type=file]')[0].files[0];
    	if(file != null || file=="undefined"){
    		formData.append('file', file); 
    	}
    	
    	formData.append('userId',$('input[name="userId"]').val());
    	formData.append('userName',$('input[name="userName"]').val());
    	formData.append('password',$('input[name="password"]').val());
    	formData.append('email',$('input[name="email"]').val());
    	
    	$.ajax({
    	      type: "POST",
    	      url: "/myapp/user/save-user",
    	     // data:  $("#registerSubmit").serialize(),
    	     data:formData,
    	     processData: false,
    	     contentType: false,
    	      success: function(resultData){
    	    	  var val = $('input[name="userId"]').val();
    	    	  $('#registerSubmit')[0].reset();
    	         console.log(resultData);
    	         var editClick ="editClick-"+resultData.id;
    	         var replaceValue ="replaceVal-"+resultData.id;
    	          var alternateRowTemplate = '<tr id="replaceVal-'+resultData.id+'"><td>'+resultData.id+'</td><td>'+resultData.name+'</td><td>'+resultData.email+'</td><td>'+resultData.password+'</td>'+
    	          '<td><img class="img-set" alt="logo" src="/myapp/user/download/'+resultData.fileId+'"/></td>'+
       	          '<td><span><i class="fa fa-pencil fa-font-size fa-edit1 " id="editClick'+resultData.id+'" aria-hidden="true" onclick="myFunction(&quot;'+"editClick"+resultData.id+'&quot;)"></i></span>'+
       	          '<span><i class="fa fa-trash fa-font-size  fa-delete" aria-hidden="true" onclick="deleteFunction(&quot;'+"editClick"+resultData.id+'&quot;)"></i></span>'+
       	          '</td></tr>';
    	          
    	          
    	          if(val==null || val==0|| val=="0"){
    		        	 console.log("----save if----------");
    		        	 $(".appendData").append(alternateRowTemplate);
    		         }else{
    		        	 console.log("----edit else----------");
    		        	 $("#"+replaceValue).replaceWith(alternateRowTemplate);
    		         }
    		          
    		         $('input[name="userId"]').val(0);
    			
    	      },
    	      error: function (textStatus, errorThrown) {
                  
    	    	 
              }
    });
});
    
   
       
});
</script>
</body>
</html>