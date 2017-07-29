$(function() {
	var source = $('#photo-template').html();
	source = source.replace(/<%/g, '{{');
	source = source.replace(/%>/g, '}}');
	
	var template = Handlebars.compile(source);

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
			item.img = '/file/' + item.id;
		
			var html = template(item);
			
			$('.ss-photos').append(html);
		}
		
		addEvents();
	}
	
	function addEvents() {
		$('.ss-photo').off('click');
		$('.ss-photo').on('click', function() {
			var id = $(this).parents('li').attr('photo-id');
			
			location.href = '/' + id;
		});
		
		$('.ss-btn-likes').off('click');
		$('.ss-btn-likes').on('click', function() {
			var id = $(this).parents('li').attr('photo-id');
			
			$.ajax({
				url: '/api/' + id + '/like',
				success: function(result) {
					result.img = '/file/' + result.id;
				
					var html = template(result);
					
					$('li[photo-id=' + result.id + ']').replaceWith(html);
					
					addEvents();
				}
			});
		});
	}
});










