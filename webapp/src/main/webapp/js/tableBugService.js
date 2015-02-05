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
			return {
				done:function(success){
					setTimeout(function(){
						success(values[idx - 1]);
					}, 2000);
				}
			}
		}
		
		return {
			find : find
		}
	};
})(jQuery, dextragiarios);