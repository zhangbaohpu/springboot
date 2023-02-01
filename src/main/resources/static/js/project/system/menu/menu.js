var prefix = "/system/menu"
$(function() {
    load(0,false);
});
function load(parentId,expand) {
    $('#menuTable').myAjaxTreeTable({
                id : 'id',
                code : 'id',
                parentCode : 'parentId',
                type : "GET", // 请求数据的ajax类型
                url : prefix + '/list', // 请求数据的ajax的url
                ajaxParams : {parentId:parentId}, // 请求数据的ajax的data属性
                expandColumn : '1', // 在哪一列上面显示展开按钮
                striped : true, // 是否各行渐变色
                bordered : true, // 是否显示边框
                expandAll : expand, // 是否全部展开
                columns: [
                    {
                        title: id_i18n,//'编号',
                        field: 'sort',
                        visible: false,
                        align: 'center',
                        valign: 'center'
                    },
                    {
                        title: name_i18n,//'名称',
                        valign: 'center',
                        field: 'name'
                    },

                    {
                        title: icon_i18n,//'图标',
                        field: 'icon',
                        align: 'center',
                        valign: 'center',
                        width: '50',
                        formatter: function (item, index) {
                            return item.icon == null ? ''
                                : '<i class="' + item.icon
                                + ' fa-lg left-module-icon-mgt"></i>';
                        }
                    },
                    {
                        title: type_i18n,//'类型',
                        field: 'type',
                        align: 'center',
                        valign: 'center',
                        formatter: function (item, index) {
                            if (item.type == 0) {
                                return '<a class="label label-primary">'+catalog_i18n+'</a>';
                            }
                            if (item.type == 1) {
                                return '<a class="label label-success">'+menu_i18n+'</a>';
                            }
                            if (item.type == 2) {
                                return '<a class="label label-warning">'+btn_i18n+'</a>';
                            }
                        }
                    },
                    {
                        title: address_i18n,//'地址',
                        valign: 'center',
                        field: 'url'
                    },
                    {
                        title: permission_i18n,//'权限标识',
                        valign: 'center',
                        field: 'perms',
                        formatter : function(item,index) {
                            var value = item.perms;
                            if (value != null && value != ""){
                                if (value.length >50){
                                    var  va = value.substring(0,50);
                                    var v = va + "...";
                                    var val =' <span title= "' +value+ '">'+v+'</span>';
                                    return val ;
                                }
                                return value;
                            }
                        }
                    },
                    {
                        title: JS_lang_label_operation,//'操作',
                        field: 'id',
                        align: 'center',
                        valign: 'center',
                        formatter: function (item, index) {
                            var e = '<a class="layui-btn layui-btn-xs '
                                + s_edit_h
                                + '" href="#" mce_href="#" title="'+JS_lang_button_edit+'" onclick="edit(\''
                                + item.id
                                + '\')">'+JS_lang_button_edit+'</a> ';
                            var p = '<a class="layui-btn layui-btn-xs '
                                + s_add_h
                                + '" href="#" mce_href="#" title="'+JS_lang_button_addChild+'" onclick="add(\''
                                + item.id
                                + '\')">'+JS_lang_button_addChild+'</a> ';
                            var d = '<a class="layui-btn layui-btn-danger layui-btn-xs '
                                + s_remove_h
                                + '" href="#" title="'+JS_lang_button_remove+'"  mce_href="#" onclick="remove(\''
                                + item.id
                                + '\')">'+JS_lang_button_remove+'</a> ';
                            return e + d + p;
                        }
                    }]
            });
}
function expand(){
    load(null,true);
}
function fold(){
    load(0,false);
}
function reLoad() {
    load(null,true);
}
function reLoad() {
    load();
}
function add(pId) {
    layer.open({
        type: 2,
        title: addTitle_i18n,//'增加菜单',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '600px'],
        content: prefix + '/add/' + pId // iframe的url
    });
}

function remove(id) {
    layer.confirm(JS_lang_remove_confirm_title,{
        title:JS_lang_win_title_remove,
        btn: [JS_lang_remove_confirm_sure, JS_lang_remove_title_cancel]
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {'id': id},
            success: function (data) {
                if (data.code == 0) {
                    //layer.msg("删除成功");
                    layer.msg(JS_lang_remove_success);
                    reLoad();
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    })
}

function edit(id) {
    layer.open({
        type: 2,
        title: editTitle_i18n,//'菜单修改',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '600px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}
