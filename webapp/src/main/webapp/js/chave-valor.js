Dextra = (function($, handle) {
	var Dextra = window.Dextra || {};
	
	Dextra.ChaveValor = {
			
			"init" : function() {
				var source = $("#index-template").html();
				var template = Handlebars.compile(source);

				$.getJSON("/api/chave-valor/vo", {}, function(vo) {
					//$("#main-chave-valor").html(template(vo.value));
				});  
			} 
			
	};

	return Dextra;
})(jQuery, Handlebars);