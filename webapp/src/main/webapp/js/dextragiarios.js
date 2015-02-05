(function() {
	var olddg = null;
	if (typeof (dg) != 'undefined') {
		olddg = dg;
	}
	dg = {};
	var newdg = dg;

	function noconflict() {
		dg = olddg;
		return newdg;
	}
	
	newdg.noconflict = noconflict;
	dextragiarios = newdg;
	return newdg;
})();