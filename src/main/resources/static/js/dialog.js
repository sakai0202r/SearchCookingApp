'use strict';

const UPDATE_MESSAGE = 'アカウント情報を変更しました';
const DELETE_MESSAGE = 'アカウントを削除します。\nよろしいですか？';

$('#update-btn').click(function() {
	alert(UPDATE_MESSAGE);
});

$('#delete-btn').click(function() {
	if(!confirm(DELETE_MESSAGE)) {
		return false;
	}
});
