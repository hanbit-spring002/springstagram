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
	
	$('.ss-comment-write').on('click', function() {
		var author = $('#ss-comment-author').val().trim();
		var content = $('#ss-comment-content').val().trim();
		
		if (!author) {
			alert('댓글 작성자를 입력하세요.');
			$('#ss-comment-author').focus();
			return;
		}
		else if (!content) {
			alert('댓글 내용을 입력하세요.');
			$('#ss-comment-content').focus();
			return;
		}
		
		var photoId = $('#photo-id').val();
		
		$.ajax({
			url: '/api/comment',
			method: 'POST',
			data: {
				photoId: photoId,
				author: author,
				comment: content
			},
			success: function(result) {
				
			}
		})
	});
	
	function initPhotoDt() {
		moment.locale('ko');
		var updateDt = $('#update-dt').val();
		var photoDt = moment(updateDt).fromNow();
		
		$('.ss-photo-dt').html(photoDt);
	}
	
	initPhotoDt();
});







