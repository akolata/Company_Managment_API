(function($){
	
	/*
		Eventy ajax "
		ajaxComplete
		ajaxError
		ajaxSend
		ajaxStart
	*/
	
	/*
		Globalny obiekt konfiguracyjny
		Dziala w obrebie wszystkich f-cji
	*/
	$.ajaxSetup({
		cache: false
	});
	
	$(document).ajaxStart(function(event,jqXHR,options){
		console.log("Ajax start");
	});
	
/*	$(document).ajaxCompletet(function(){
		console.log("Ajax complete");
	});*/
	
	$(document).ready(function (){
		
/*		var btn = $("#send-btn");
		
		btn.on("click",function(event){
		
			event.preventDefault();
		
			$.ajax({
				url: "/Spring_JS_Exercises/js",
				//url: "http://code.eduweb.pl/kurs-jquery/get_json.php",
				type: "POST",
				//datatype : text,
				data: {
					imie: "Tomasz"
				},
				context: btn , // this w f-cjach zamiast na jqXHR kieruje na nasz przyucisk
				success: function(data,status,jqXHR){
					console.log("Success !!!");
					console.log("Data from server = " + data);
					console.log(typeof data);
					console.log("STATUS = " + status);
					console.log("jqXHR = " + jqXHR);
					console.dir(jqXHR);
					this.attr("disabled","disabled");
				},
				error: function(jqXHR,status,errorThrown){
					console.log("Error !!!");
					console.log("Error = " + errorThrown);
					console.log("STATUS = " + status);
					console.log("jqXHR = " + jqXHR);
					console.dir(jqXHR);
				},
				complete : function(jqXHR,status){
					console.log("Complete !!!");
					console.log("STATUS = " + status);
					console.log("jqXHR = " + jqXHR);
				}
			});
			

		});*/
		//Skrotowe metody
/*		$.get("",function(data){
			console.log("w f-cji success");
		});
		
		$.getJSON("http://code.eduweb.pl/kurs-jquery/get_json.php",function(data){
			console.log(data);
		});*/
		
		//$.getScript("http://code.eduweb.pl/kurs-jquery/js/hello.js");
		
	/*	data = $("#form").serialize();
		$.post("",data,function(data){
			console.log("W success");
		});*/
	});
	
})(jQuery);