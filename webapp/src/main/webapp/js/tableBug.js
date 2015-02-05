(function($, dg) {
	dg.bindButtons = function() {
		$('form').submit(function() {
			var trs = $('table.grid tbody tr');
			for ( var i = 0; i < trs.length; i++) {
				var tr = $(trs[i]);
				var id = tr.find('.id').text();
				dg.serviceTable().find(parseInt(id)).done(function(desc) {
					tr.find('.description').text(desc.desc);
				});
			}
			$('table.grid').show();
		});

	}
})(jQuery, dextragiarios);