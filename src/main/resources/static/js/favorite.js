'use strict';

//* 画面ロード時の処理 */
jQuery(function($) {
	
	$('#favorite').click(function (event) {
		// お気に入り追加
		addFavorite();
	});
});

/** お気に入り追加処理 */
function addFavorite() {
	
	var formData = $('#user-detail-form').serializeArray();
	
	 $.ajax({
		type : "PUT",
		cache : false,
		data : formData,
		dataType : 'json'
	});
}