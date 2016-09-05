$.fn.editable.defaults.ajaxOptions = {type: "PUT"};
$(document).ready(function() {
    $('.movie-name').editable();
    $('.movie-year').editable({
    	validate: function(value) {
    		if (isNaN(value)) return 'input is not a number';
    		if ( parseFloat(value) != parseInt(value) ) return 'input is not an integer';
    	}
    });
});