$(document).ready(function(){
	$.ajax({
		type : 'GET',
        url : 'api/usuarios',
        dataType : 'json'
    }).success(function(strJson) {
    	$.get('templates/template.html').done(function(template) {
    		$('#usuarios').html(doT.template(template)(strJson));
    	});
    })
});