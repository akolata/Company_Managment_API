/**
 * Handle requests to API
 */

(function($){
	
	var showEmployeeBtn = $("#show-emp-btn");
	var showEmpResultDiv = $("#show-emp-result");
	var addEmployeeBtn = $("#add-emp-btn");
	var addEmpResultDiv = $("#add-emp-result");
	
	function clearPreviousSearchResults(){
		
		if($(".table").length){ 
			$(".table").remove();
		}
		
		if($(".alert").length){ 
			$(".alert").remove();
		}
	}
	
	function displayMessage(status,jqXHR){
		var alert = $("<div></div>").addClass("alert");
		var messageText = status + " " + jqXHR.status + " \n" ;
		
		if(status === "error"){
			alert.addClass("alert-danger");
		}else if(status === "success"){
			alert.addClass("alert-success");
		}
		
		if(jqXHR.status == 404){
			var response = $.parseJSON(jqXHR.responseText);
			messageText += ("Result : " + response.name + + " \n");
			messageText += ("Cause : " + response.cause + + " \n");
		}
		
		alert.text(messageText);
		alert.html(alert.html().replace(/\n/g,'<br/>'));
		showEmpResultDiv.append(alert);
	}
	
	function displayMessageAboutAddedEmployee(status,jqXHR){
		var alert = $("<div></div>").addClass("alert");
		var messageText = status + " " + jqXHR.status + " \n" ;
		
		if(status === "error"){
			alert.addClass("alert-danger");
		}else if(status === "success"){
			alert.addClass("alert-success");
		}
		
		if(jqXHR.status == 201){
			var response = $.parseJSON(jqXHR.responseText);
			messageText += ("New employee added with id : " + response.id);
		}
		
		alert.text(messageText);
		alert.html(alert.html().replace(/\n/g,'<br/>'));
		
		addEmpResultDiv.empty();
		addEmpResultDiv.append(alert);
	}
	
	function createTableWithEmployees(data){
		
		var table = $("<table></table>").addClass("table").addClass("table-striped").css("display","none");
		var tHead = $("<thead></thead>");
		var tBody = $("<tbody></tbody>");
		var tHeadRow = $("<tr></tr>");
		
		tHeadRow.append($("<th></th>").text("id"));
		tHeadRow.append($("<th></th>").text("firstName"));
		tHeadRow.append($("<th></th>").text("lastName"));
		tHeadRow.append($("<th></th>").text("hireDate dd/MM/yyyy"));
		tHeadRow.append($("<th></th>").text("salary"));
		tHeadRow.append($("<th></th>").text("department id"));
		tHeadRow.append($("<th></th>").text("department name"));
		
		tHead.append(tHeadRow);
		
		$(data).each(function(i,item){
			var tr =	$("<tr></tr>");
			
			tr.append($("<td></td>").text(item.id));
			tr.append($("<td></td>").text(item.firstName));
			tr.append($("<td></td>").text(item.lastName));
			tr.append($("<td></td>").text(item.hireDate.dayOfMonth + "/" + item.hireDate.monthValue + "/" + item.hireDate.year));
			tr.append($("<td></td>").text(item.salary));
			tr.append($("<td></td>").text(item.department.id));
			tr.append($("<td></td>").text(item.department.name));
						
			tBody.append(tr);
		});
		
		table.append(tHead);
		table.append(tBody);
		showEmpResultDiv.append(table);
		table.show("slow");
	}
	
	
	showEmployeeBtn.on("click",function(event){
		var empId = $("#emp-id"),
			apiUrl = "http://localhost:8080/Spring_JS_Exercises/api/employee/";
		
		if(empId.val() === ""){
			apiUrl += "all";
		}else{
			apiUrl += empId.val();
		}
		
		$.ajax({
			url : apiUrl,
			method : "GET",
			success : function(data, status, jqXHR) {
				clearPreviousSearchResults();
				displayMessage(status,jqXHR);
				createTableWithEmployees(data);
			},
			error : function(jqXHR, status, errorThrown) {
				clearPreviousSearchResults();
				displayMessage(status,jqXHR);
			}
		});
	});
	
	addEmployeeBtn.on("click",function(event){
		var empFirstName = $("#firstname").val(),
			empLastName = $("#lastname").val(),
			empSalary = $("#salary").val(),
			empSuperiorId = $("#superior").val(),
			empDepartmentId = $("#department").val();
		
		var addEmployeeApiUrl = "http://localhost:8080/Spring_JS_Exercises/api/employee/add";
		var addEmployeeJSON = {
			firstName: empFirstName,
			lastName : empLastName,
			salary : empSalary,
			departmentId : empDepartmentId,
			superiorId : empSuperiorId	
		};
		
		addEmployeeJSON = JSON.stringify(addEmployeeJSON);
		console.log(addEmployeeJSON);
		
		$.ajax({
			url : addEmployeeApiUrl,
			method : "POST",
			dataType : "json",
			data : addEmployeeJSON,
			beforeSend: function(xhr){
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.setRequestHeader('Accept', 'application/json');
			},
			success : function(data, status, jqXHR) {
				displayMessageAboutAddedEmployee(status,jqXHR);
			},
			error : function(jqXHR, status, errorThrown) {
				displayMessageAboutAddedEmployee(status,jqXHR);
			}
		});
	});
	
})(jQuery);