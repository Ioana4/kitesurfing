$('div img').on('click',
		function() {
			var src = $(this).attr('src');
			var img = '<img src="' + src + '" class="img-responsive"/>';

			var index = $(this).parent('div').index();

			var html = '';
			html += img;
			html += '<div style="height:25px;clear:both;display:block;">';

			html += '<a class="controls next" href="' + (index + 2)+ '">next &raquo;</a>';

			html += '<a class="controls previous" href="' + (index)
					+ '">&laquo; prev</a>';
			html += '</div>';

			$('#myModal').modal();
			$('#myModal').on('shown.bs.modal', function() {
				$('#myModal .modal-body').html(html);
				$('a.controls').trigger('click');
			})
			$('#myModal').on('hidden.bs.modal', function() {
				$('#myModal .modal-body').html('');
			});

			hideControls(index, index + 2);
		});

$(document).on('click', 'a.controls', function() {
	var index = $(this).attr('href');
	var src = $('div.row div:nth-child(' + index + ') img').attr('src');
	$('.modal-body img').attr('src', src);

	// update controls
	var newPrevIndex = parseInt(index) - 1;
	var newNextIndex = parseInt(newPrevIndex) + 2;

	if ($(this).hasClass('previous')) {
		$(this).attr('href', newPrevIndex);
		$('a.next').attr('href', newNextIndex);
	} else {
		$(this).attr('href', newNextIndex);
		$('a.previous').attr('href', newPrevIndex);
	}

	hideControls(newPrevIndex, newNextIndex);

	return false;
});

function hideControls(newPrevIndex, newNextIndex) {
	var total = $('div.row div').length + 1;

	// hide next button
	if (total === newNextIndex) {
		$('a.next').hide();
	} else {
		$('a.next').show();
	}
	// hide previous button
	if (newPrevIndex === 0) {
		$('a.previous').hide();
	} else {
		$('a.previous').show();
	}
}
