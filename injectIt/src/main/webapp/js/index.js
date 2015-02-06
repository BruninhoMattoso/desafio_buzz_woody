    $.ajax({
        url : 'api/usuarios',
        type : "GET",
    }).done(function(resp) {
        $("#usuarios").html(resp);
    });

    $('#pesquisar').click(function() {
    	
        $.ajax({
            url : 'api/usuarios',
            type : 'POST',
            data : {
                name : $('#search').val()
            },
            dataType : 'json'
        }).done(function(resp) {
        	console.info(resp);
        	$.get('templates/template.html',function (template){
        		$("#usuarios").html(doT.template(template)(resp));
        	}, "html");
            
        });
    });
