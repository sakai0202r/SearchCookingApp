'use strict';

function humburger() {
	document.getElementById('header-menu').classList.toggle('not-active');
}

document.getElementById('user-icon').addEventListener('click', function() {
	humburger();
});