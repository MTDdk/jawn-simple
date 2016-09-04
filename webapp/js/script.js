if (typeof jQuery === 'undefined') { throw new Error('jQuery is required'); }

$(window).load(function() {
	$('#index_button_go').click(function(){
		var url = $('#index_text_url').val();
		redirect(url);
	});
	
	$('#index_text_url').keydown(function(event){
		if (event.which == 13 ) {
			redirect($(this).val());
		}
	});
	
	
	// set active tab correctly
	var currentPage = window.location.pathname;
	$('#navigation').children().removeClass('active');
	$('#navigation_'+ currentPage.substring(1)).addClass('active');
});

function redirect(url) {
	window.location.assign('index/redirect?url='+url);
}

/*******************************/
/******* String Prototype ******/
/*******************************/
if (!String.startsWith) {
	String.prototype.startsWith = function(start) {
		return this.indexOf(start) == 0;
	}
}