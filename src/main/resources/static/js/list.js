'use strict';

$('#check-box').click(function() {
	$('.text-box').toggle(this.checked);
	if ($("#check-box").prop("checked") == true) {
		$('.pulldown').prop('disabled', true);
	} else {
		$('.pulldown').prop('disabled', false);
	}
});