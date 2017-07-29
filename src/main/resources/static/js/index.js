$(function() {
	$('.ss-write').on('click', function() {
		location.href = '/write';
	});
	
	function setList(list) {
		$('.ss-photos').empty();
		
		for (var i=0; i<list.length; i++) {
			var item = list[i];
			
			var html = '<li class="col-md-3">';
			html += '<div class="ss-photo-item">';
			html += '<div class="ss-photo" style="background-image:url(' + item.img + ')">';
			html += '</div>';
			html += '<div class="ss-text">';
			html += '<div class="ss-photo-name">' + item.name + '</div>';
			html += '<div class="ss-photo-content">' + item.content + '</div>';
			html += '<div class="ss-photo-buttons">';
			html += '<div class="ss-btn">';
			html += '좋아요 ' + item.likes;
			html += '</div>';
			html += '<div class="ss-btn ss-btn-comments">';
			html += '댓글 ' + item.comments;
			html += '</div>';
			html += '</div>';
			html += '</div>';
			html += '</div>';
			html += '</li>';
			
			$('.ss-photos').append(html);
		}
	}
	
	setList([{
		img: '/img/Penguins.jpg',
		name: '펭귄',
		content: '남극입니다.',
		likes: 4,
		comments: 0
	}, {
		img: '/img/Penguins.jpg',
		name: '펭귄 두마리',
		content: '추워요',
		likes: 2,
		comments: 0
	}]);
});










