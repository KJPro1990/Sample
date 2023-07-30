var data = { userid: 'user01', password: null }

$(function() {
	$('#myForm').w2form({
		name: 'myForm',
		header: 'ログイン認証',
		fields: [
			{ field: 'userid', name: 'ユーザＩＤ', type: 'text', required: true },
			{ field: 'password', name: 'パスワード', type: 'password', required: true },
		],
		record: data,
		actions: {
			ログイン: function() {
				var formObject = $('#main')[0]
				var windowMain = window.open('about:blank', 'mainA')
				formObject.target = 'mainA'
				formObject.submit()
				windowMain.focus()
			}
		}
	});

	$('#grid').w2grid({
		name: 'data_form',
		show: {
			toolbar: true,
			footer: true,
			lineNumbers: true,
			toolbarAdd: true,
			toolbarDelete: true,
			toolbarSave: true,
		},
		onAdd: function(event) {
			showEditForm(false);
		},
		columns: [
			{ field: 'recid', caption: 'ID', size: '50px', sortable: true },
			{ field: 'fname', caption: 'First Name', size: '30%', sortable: true },
			{ field: 'lname', caption: 'Last Name', size: '30%', sortable: true },
			{ field: 'email', caption: 'Email', size: '40%' },
			{ field: 'sdate', caption: 'Start Date', size: '120px', editable: { type: 'date' } }
		],
		records: [
			{ recid: 1, fname: 'John', lname: 'doe', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 2, fname: 'Stuart', lname: 'Motzart', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 3, fname: 'Jin', lname: 'Franson', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 4, fname: 'Susan', lname: 'Ottie', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 5, fname: 'Kelly', lname: 'Silver', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 6, fname: 'Francis', lname: 'Gatos', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 7, fname: 'Mark', lname: 'Welldo', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 8, fname: 'Thomas', lname: 'Bahh', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
			{ recid: 9, fname: 'Sergei', lname: 'Rachmaninov', email: 'jdoe@gmail.com', sdate: '4/3/2012' },
		]
	});

	// 非同期通信
	$("#btnAjax").on("click", function() {
		var postData = {
			title: "サンプルタイトル",
			body: "これはAjax POSTリクエストのサンプルです。",
			userId: 1
		};

		$.ajax({
			url: "/result", // 任意のAPIエンドポイントを指定
			type: "POST",
			dataType: "json",
			data: postData,
			success: function(data) {
				$("#response").text(JSON.stringify(data));
			},
			error: function(xhr, status, error) {
				// TODO 再リクエスト？
				console.log("エラーが発生しました: " + error);
//				$('#main').action = '/error';
				$('#main').submit();
			}
		});
	});

	//編集表示
	function showEditForm(isEdit) {
		$('#grid').hide();
		$('#grid').show();
		w2ui['data_form'].clear();
		//w2ui['data_form'].header = uiName;

		if (isEdit) {
			var sel = w2ui['data_form'].getSelection();
			if (sel.length == 1) {
				var record = w2ui['data_form'].get(sel[0]);
				w2ui['data_form'].record = record;
			}
		}
		w2ui['data_form'].refresh();
	}
});