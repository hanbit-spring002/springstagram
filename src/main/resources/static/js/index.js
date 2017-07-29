$(function() {
	$('.ss-write').on('click', function() {
		location.href = '/write';
	});
	
	$.ajax({
		url: '/api/list',
		success: function(result) {
			setList(result);
		}
	});
	
	function setList(list) {
		$('.ss-photos').empty();
		
		for (var i=0; i<list.length; i++) {
			var item = list[i];
			var img = '/file/' + item.id;
			
			var html = '<li class="col-md-3">';
			html += '<div class="ss-photo-item">';
			html += '<div class="ss-photo" style="background-image:url(' + img + ')">';
			html += '</div>';
			html += '<div class="ss-text">';
			html += '<div class="ss-photo-name">' + item.name + '</div>';
			html += '<div class="ss-photo-content">' + item.content + '</div>';
			html += '<div class="ss-photo-buttons">';
			html += '<div class="ss-btn">';
			html += '좋아요 ' + item.likes;
			html += '</div>';
			html += '<div class="ss-btn ss-btn-comments">';
			html += '댓글 ' + 0;
			html += '</div>';
			html += '</div>';
			html += '</div>';
			html += '</div>';
			html += '</li>';
			
			$('.ss-photos').append(html);
		}
	}
});










