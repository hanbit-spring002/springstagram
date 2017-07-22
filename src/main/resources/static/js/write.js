$(function() {
	$('.ss-file-select').on('click', function() {
		var fileInputId = $(this).attr('for');
		var fileInput = $('#' + fileInputId);
		
		fileInput.on('change', function() {
			var fileReader = new FileReader();
			
			fileReader.onload = function(event) {
				var preview = $('<img>');
				preview.attr('src', event.target.result);
				
				$('.ss-write-preview').html(preview);
			};
			
			fileReader.readAsDataURL(this.files[0]);
		});
		
		fileInput.click();
	});
	
	$('.ss-save').on('click', function() {
		if ($('#ss-write-photo')[0].files.length === 0) {
			alert('파일을 선택하세요.');
			return;
		}
		else if ($('#ss-write-name').val().trim() === '') {
			alert('사진제목을 입력하세요.');
			$('#ss-write-name').focus();
			return;
		}
		else if ($('#ss-write-content').val().trim() === '') {
			alert('사진내용을 입력하세요.');
			$('#ss-write-content').focus();
			return;
		}
		
		var formData = new FormData();
		formData.append('img', $('#ss-write-photo')[0].files[0]);
		formData.append('name', $('#ss-write-name').val().trim());
		formData.append('content', $('#ss-write-content').val().trim());
		
		$.ajax({
			url: '/api/write',
			method: 'POST',
			data: formData,
			processData: false,
			contentType: false,
			success: function(result) {
				location.href = '/';
			},
			error: function(jqXHR, errorMsg, errorThrown) {
				alert(errorMsg);
			}
		})
	});
});

















