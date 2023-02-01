var prefix = "/system/menu"
layui.use(['form','layer','util'],function () {
	var form = layui.form, $ = layui.$, layer = layui.layer, util = layui.util;

	form.on('submit(submitForm)',function (data) {
		console.log(data)
		$.ajax({ cache : true, type : "POST",
			url : prefix + "/save",
			data : data.field,
			async : false,
			error : function(request) {
				layer.alert("Connection error");
			},
			success : function(data) {
				if (data.code == 0) {
					parent.layer.msg("保存成功");
					parent.reLoad();
					var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
					parent.layer.close(index);
				} else {
					layer.alert(data.msg)
				}
			}
		});
	})
	//打开图标列表
	util.event('lay-active', {
		icon: function(othis){
			layer.open({
				type: 2,
				title:iconList_i18n,//'图标列表',
				content: '/public/icon.html',
				area: ['480px', '90%'],
				success: function(layero, index){
					//var body = layer.getChildFrame('.ico-list', index);
					//console.log(layero, index);
				}
			});
		}
	});
})
