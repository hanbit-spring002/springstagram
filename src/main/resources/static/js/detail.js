$(function() {
	$('.ss-write').on('click', function() {
		location.href = '/write';
	});
	
	$('.ss-btn-likes').on('click', function() {
		var id = $('#photo-id').val();
		
		$.ajax({
			url: '/api/' + id + '/like',
			success: function(result) {
				$('.ss-photo-likes').html(result.likes);
			}
		});
	});
	
	function initPhotoDt() {
		moment.locale('ko');
		var updateDt = $('#update-dt').val();
		var photoDt = moment(updateDt).fromNow();
		
		$('.ss-photo-dt').html(photoDt);
	}
	
	initPhotoDt();
});







