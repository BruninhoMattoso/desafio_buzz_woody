(function ($, dg){
	dg.serviceTable = function(){
	
		var values = [{
			desc : 'Um'
		}, {
			desc : 'Dois'
		}, {
			desc : 'Tres'
		}, {
			desc : 'Quatro'
		}, {
			desc : 'Cinco'
		}];
		
		function find(idx){
			var def = $.Deferred();
			setTimeout(function(){
				def.promisse();
			}, 2000);
			return def.resolve(values[idx - 1]);
		}
	
		
		return {
			find : find
		}
	};
})(jQuery, dextragiarios);
