'use strict';

//* 画面ロード時の処理 */
jQuery(function($) {
	
	$('#add-favorite').click(function (event) {
		// お気に入り追加
		addFavorite();
	});
	
	$('#remove-favorite').click(function (event) {
		// お気に入り解除
		removeFavorite();
	});
});

/** お気に入り追加処理 */
function addFavorite() {
	
	// フォームの値を取得
	var formData = $('#favorite-form').serializeArray();
	
	 $.ajax({
		type : "POST",
		cache : false,
		//url: ,
		data : formData,
		dataType : 'json',
	}).done(function(data) {
		// ajax成功時の処理
		location.reload();
	}).fail(function(jqXHR, textStatus, errorThrown) {
		// ajax失敗時の処理
		alert('お気に入りできませんでした');
	}).always(function() {
		// 常に実行する処理
	});
}

/** お気に入り解除処理 */
function removeFavorite() {
	
	// フォームの値を取得
	var formData = $('#favorite-form').serializeArray();
	
	 $.ajax({
		type : "DELETE",
		cache : false,
		//url: ,
		data : formData,
		dataType : 'json',
	}).done(function(data) {
		// ajax成功時の処理
		location.reload();
	}).fail(function(jqXHR, textStatus, errorThrown) {
		alert('お気に入り解除できませんでした');
	}).always(function() {
		// 常に実行する処理
	});
}
