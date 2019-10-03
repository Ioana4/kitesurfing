angular.module('app', [ 'ngRoute', 'ngResource' ]);

angular.module('app').controller('windController', function($scope) {
	

	WgWidget({
		s : 508600,
		odh : 0,
		doh : 24,
		wj : 'knots',
		tj : 'c',
		waj : 'm',
		fhours : 72,
		lng : 'en',
		params : [ 'WINDSPD', 'GUST', 'SMER', 'TMPE', 'CDC', 'APCPs' ],
		first_row : true,
		spotname : true,
		first_row_minfo : true,
		last_row : true,
		lat_lon : true,
		tz : true,
		sun : true,
		link_archive : false,
		link_new_window : false
	}, 'wg_target_div_508600_92191667');
});