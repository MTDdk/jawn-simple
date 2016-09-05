if (typeof jQuery === 'undefined') { throw new Error('jQuery is required'); }

$(window).load(function() {
	// set active tab correctly
	var currentPage = window.location.pathname;
	if (currentPage == '/') currentPage += 'index';
	$('#navigation').children().removeClass('active');
	$('#navigation_'+ currentPage.substring(1)).addClass('active');
});

/*******************************/
/******* String Prototype ******/
/*******************************/
if (!String.startsWith) {
	String.prototype.startsWith = function(start) {
		return this.indexOf(start) == 0;
	}
}