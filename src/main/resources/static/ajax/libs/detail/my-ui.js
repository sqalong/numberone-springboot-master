$(function () {
    document.body.className = localStorage.getItem('config-skin');
    $("[data-toggle='tooltip']").tooltip();
})
$.reload = function () {
    location.reload();
    return false;
}
$.loading = function (bool, text) {
    var $loadingpage = top.$("#loadingPage");
    var $loadingtext = $loadingpage.find('.loading-content');
    if (bool) {
        $loadingpage.show();
    } else {
        if ($loadingtext.attr('istableloading') == undefined) {
            $loadingpage.hide();
        }
    }
    if (!!text) {
        $loadingtext.html(text);
    } else {
        $loadingtext.html("数据加载中，请稍后…");
    }
    $loadingtext.css("left", (top.$('body').width() - $loadingtext.width()) / 2 - 50);
    $loadingtext.css("top", (top.$('body').height() - $loadingtext.height()) / 2);
}
$.request = function (name) {
    var search = location.search.slice(1);
    var arr = search.split("&");
    for (var i = 0; i < arr.length; i++) {
        var ar = arr[i].split("=");
        if (ar[0] == name) {
            if (unescape(ar[1]) == 'undefined') {
                return "";
            } else {
                return unescape(ar[1]);
            }
        }
    }
    return "";
}
$.currentWindow = function () {
    var iframeId = top.$(".My_iframe:visible").attr("id");
    return top.frames[iframeId];
}
$.browser = function () {
    var userAgent = navigator.userAgent;
    var isOpera = userAgent.indexOf("Opera") > -1;
    if (isOpera) {
        return "Opera"
    };
    if (userAgent.indexOf("Firefox") > -1) {
        return "FF";
    }
    if (userAgent.indexOf("Chrome") > -1) {
        if (window.navigator.webkitPersistentStorage.toString().indexOf('DeprecatedStorageQuota') > -1) {
            return "Chrome";
        } else {
            return "360";
        }
    }
    if (userAgent.indexOf("Safari") > -1) {
        return "Safari";
    }
    if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
        return "IE";
    };
}
$.download = function (url, data, method) {
    if (url && data) {
        data = typeof data == 'string' ? data : jQuery.param(data);
        var inputs = '';
        $.each(data.split('&'), function () {
            var pair = this.split('=');
            inputs += '<input type="hidden" name="' + pair[0] + '" value="' + pair[1] + '" />';
        });
        $('<form action="' + url + '" method="' + (method || 'post') + '">' + inputs + '</form>').appendTo('body').submit().remove();
    };
};


$.modalOpen = function (options) {
    var defaults = {
        id: null,
        title: '系统窗口',
        width: "100px",
        height: "100px",
        url: '',
        shade: 0.3,
        btn: ['确认', '关闭'],
        btnclass: ['btn btn-primary', 'btn btn-danger'],
        callBack: null
    };
    var options = $.extend(defaults, options);
    var _width = top.$(window).width() > parseInt(options.width.replace('px', '')) ? options.width : top.$(window).width() + 'px';
    var _height = top.$(window).height() > parseInt(options.height.replace('px', '')) ? options.height : top.$(window).height() + 'px';
    top.layer.open({
        id: options.id,
        type: 2,
        shade: options.shade,
        title: options.title,
        fix: false,
        area: [_width, _height],
        content: options.url,
        btn: options.btn,
        btnclass: options.btnclass,
        yes: function () {
            options.callBack(options.id)
        }, cancel: function () {
            return true;
        }
    });
}
$.mOpen = function (options) {
    var defaults = {
        id: null,
        title: '系统窗口',
        width: "100px",
        height: "100px",
        url: '',
        shade: 0.3,
        btn: ['确认',  '删除', '关闭'],
        btnclass: ['btn btn-primary', 'btn btn-danger', 'btn btn-danger'],
        callBack: null,
        delBack:null,
    };
    var options = $.extend(defaults, options);
    var _width = top.$(window).width() > parseInt(options.width.replace('px', '')) ? options.width : top.$(window).width() + 'px';
    var _height = top.$(window).height() > parseInt(options.height.replace('px', '')) ? options.height : top.$(window).height() + 'px';
    top.layer.open({
        id: options.id,
        type: 2,
        shade: options.shade,
        title: options.title,
        fix: false,
        area: [_width, _height],
        content: options.url,
        btn: options.btn,
        btnclass: options.btnclass,
        yes: function () {
            options.callBack(options.id)
        },btn2: function() {
            options.delBack(options.id)
        },cancel: function () {
            return true;
        }
    });
}
$.modalConfirm = function (content, callBack) {
    top.layer.confirm(content, {
        icon: "fa-exclamation-circle",
        title: "系统提示",
        btn: ['确认', '取消'],
        btnclass: ['btn btn-primary', 'btn btn-danger'],
    }, function () {
        callBack(true);
    }, function () {
        callBack(false)
    });
}

$.modalAlert = function (content, type) {
    var icon = "";
    if (type == 'success') {
        icon = "fa-check-circle";
    }
    if (type == 'error') {
        icon = "fa-times-circle";
    }
    if (type == 'warning') {
        icon = "fa-exclamation-circle";
    }
    top.layer.alert(content, {
        icon: icon,
        title: "系统提示",
        btn: ['确认'],
        btnclass: ['btn btn-primary'],
    });
}
$.modalMsg = function (content, type) {
    if (type != undefined) {
        var icon = "";
        if (type == 'success') {
            icon = "fa-check-circle";
        }
        if (type == 'error') {
            icon = "fa-times-circle";
        }
        if (type == 'warning') {
            icon = "fa-exclamation-circle";
        }
        top.layer.msg(content, { icon: icon, time: 4000, shift: 5 });
        top.$(".layui-layer-msg").find('i.' + icon).parents('.layui-layer-msg').addClass('layui-layer-msg-' + type);
    } else {
        top.layer.msg(content);
    }
}
$.modalClose = function () {
    var index = top.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    var $IsdialogClose = top.$("#layui-layer" + index).find('.layui-layer-btn').find("#IsdialogClose");
    var IsClose = $IsdialogClose.is(":checked");
    if ($IsdialogClose.length == 0) {
        IsClose = true;
    }
    if (IsClose) {
        top.layer.close(index);
    } else {
        location.reload();
    }
}
$.submitForm = function (options) {
    var defaults = {
        url: "",
        param: [],
        loading: "正在提交数据...",
        success: null,
        alert:true,
        close: true
    };
    var options = $.extend(defaults, options);
    $.loading(true, options.loading);
    window.setTimeout(function () {
        if ($('[name=__RequestVerificationToken]').length > 0) {
            options.param["__RequestVerificationToken"] = $('[name=__RequestVerificationToken]').val();
        }
        $.ajax({
            url: options.url,
            data: options.param,
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.state == "success") {
                    if (options.success !=null) {
                        options.success(data);
                    } else {
                        $.loading(false);
                    }
                    if (options.alert) {
                        $.modalMsg(data.message, data.state);
                    }
                    if (options.close == true) {
                        $.modalClose();
                    }
                } else {
                    $.modalAlert(data.message, data.state);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.loading(false);
                $.modalMsg(errorThrown, "error");
            },
            beforeSend: function () {
                $.loading(true, options.loading);
            },
            complete: function () {
                $.loading(false);
            }
        });
    }, 300);
}

$.submitTelForm = function (options) {
    var defaults = {
        url: "",
        param: [],
        loading: "正在提交数据...",
        success: null,
        alert: true,
        close: true
    };
    var options = $.extend(defaults, options);
    $.loading(true, options.loading);
    window.setTimeout(function () {
        if ($('[name=__RequestVerificationToken]').length > 0) {
            options.param["__RequestVerificationToken"] = $('[name=__RequestVerificationToken]').val();
        }
        $.ajax({
            url: options.url,
            data: options.param,
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.success == true) {
                    if (options.success != null) {
                        options.success(data);
                    } else {
                        $.loading(false);
                    }
                    if (options.alert) {
                        $.modalMsg(data.msg, "success");
                    }
                    if (options.close == true) {
                        $.modalClose();
                    }
                } else {
                    $.modalAlert(data.msg, "error");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.loading(false);
                $.modalMsg(errorThrown, "error");
            },
            beforeSend: function () {
                $.loading(true, options.loading);
            },
            complete: function () {
                $.loading(false);
            }
        });
    }, 300);
}


$.ChkData = function (options) {
    var defaults = {
        url: "",
        param: [],
        loading: "正在初始化...",
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);
    $.loading(true, options.loading);    
        $.ajax({
            url: options.url,
            data: options.param,
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data.state == "success") {
                    if (options.success != null) {
                        options.success(data);
                    } else {
                        $.loading(false);
                    }                   
                } else {
                    $.modalMsg(data.message, "error");
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.loading(false);
                $.modalMsg(errorThrown, "error");
            },
            beforeSend: function () {
                $.loading(true, options.loading);
            },
            complete: function () {
                $.loading(false);
            }
        });
}

$.deleteForm = function (options) {
    var defaults = {
        prompt: "注：您确定要删除该项数据吗？",
        url: "",
        param: [],
        loading: "正在删除数据...",
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);
    if ($('[name=__RequestVerificationToken]').length > 0) {
        options.param["__RequestVerificationToken"] = $('[name=__RequestVerificationToken]').val();
    }
    $.modalConfirm(options.prompt, function (r) {
        if (r) {
            $.loading(true, options.loading);
            window.setTimeout(function () {
                $.ajax({
                    url: options.url,
                    data: options.param,
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        if (data.state == "success") {
                            options.success(data);
                            $.modalMsg(data.message, data.state);
                        } else {
                            $.modalAlert(data.message, data.state);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        $.loading(false);
                        $.modalMsg(errorThrown, "error");
                    },
                    beforeSend: function () {
                        $.loading(true, options.loading);
                    },
                    complete: function () {
                        $.loading(false);
                    }
                });
            }, 500);
        }
    });
}
$.operatePrompt = function (options) {
    var defaults = {
        prompt: "注：您确定要删除该项数据吗？",
        url: "",
        formType:0,
        param: [],
        parName:"default",
        loading: "正在执行中...",
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);

    top.layer.prompt({
        title: options.prompt, formType: options.formType, btn: ['确认', '关闭'], btnclass: ['btn btn-primary', 'btn btn-danger'] }, function (text, index) {       
        $.loading(true, options.loading);
        if (text != "") {
            options.param[options.parName] = text;
        } else {
            return false;
        }
        window.setTimeout(function () {
            $.ajax({
                url: options.url,
                data: options.param,
                type: "post",
                dataType: "json",
                success: function (data) {
                    if (data.state == "success") {
                        options.success(data);
                        $.modalMsg(data.message, data.state);
                    } else {
                        $.modalAlert(data.message, data.state);
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $.loading(false);
                    $.modalMsg(errorThrown, "error");
                },
                beforeSend: function () {
                    $.loading(true, options.loading);
                },
                complete: function () {
                    $.loading(false);
                }
            });
        }, 500);

    });
}

$.operateForm = function (options) {
    var defaults = {
        prompt: "注：您确定要删除该项数据吗？",
        url: "",
        param: [],
        loading: "正在删除数据...",
        success: null,
        close: true
    };
    var options = $.extend(defaults, options);
    if ($('[name=__RequestVerificationToken]').length > 0) {
        options.param["__RequestVerificationToken"] = $('[name=__RequestVerificationToken]').val();
    }
    $.modalConfirm(options.prompt, function (r) {
        if (r) {
            $.loading(true, options.loading);
            window.setTimeout(function () {
                $.ajax({
                    url: options.url,
                    data: options.param,
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        if (data.state == "success") {
                            options.success(data);
                            $.modalMsg(data.message, data.state);
                        } else {
                            $.modalAlert(data.message, data.state);
                        }
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        $.loading(false);
                        $.modalMsg(errorThrown, "error");
                    },
                    beforeSend: function () {
                        $.loading(true, options.loading);
                    },
                    complete: function () {
                        $.loading(false);
                    }
                });
            }, 500);
        }
    });
}
$.jsonWhere = function (data, action) {
    if (action == null) return;
    var reval = new Array();
    $(data).each(function (i, v) {
        if (action(v)) {
            reval.push(v);
        }
    })
    return reval;
}
$.fn.jqGridRowValue = function () {
    var $grid = $(this);
    var selectedRowIds = $grid.jqGrid("getGridParam", "selarrrow");
    if (selectedRowIds != "") {
        var json = [];
        var len = selectedRowIds.length;
        for (var i = 0; i < len ; i++) {
            var rowData = $grid.jqGrid('getRowData', selectedRowIds[i]);
            json.push(rowData);
        }
        return json;
    } else {
        return $grid.jqGrid('getRowData', $grid.jqGrid('getGridParam', 'selrow'));
    }
}
$.fn.formValid = function () {
    return $(this).valid({
        errorPlacement: function (error, element) {
            element.parents('.formValue').addClass('has-error');
            element.parents('.has-error').find('i.error').remove();
            element.parents('.has-error').append('<i class="form-control-feedback fa fa-exclamation-circle error" data-placement="left" data-toggle="tooltip" title="' + error + '"></i>');
            $("[data-toggle='tooltip']").tooltip();
            if (element.parents('.input-group').hasClass('input-group')) {
                element.parents('.has-error').find('i.error').css('right', '33px')
            }
        },
        success: function (element) {
            element.parents('.has-error').find('i.error').remove();
            element.parent().removeClass('has-error');
        }
    });
}
function setDefChk(name, value) {
    if (value != "" && $("input[name='" + name + "']").length > 0) {
        var sel = value.split(",");
        for (var i = 0; i < sel.length; i++) {
            $("input[name='" + name + "']").each(function () {
                if ($(this).val() == sel[i]) {
                    this.checked = true;
                } else {
                    this.checked = false;
                }
            });
        }
    }
}
$.fn.formSerialize = function (formdate) {
    var element = $(this);
    if (!!formdate) {
        for (var key in formdate) {
            var $id = element.find('#' + key);
            if (formdate[key]) {
                var value = $.trim(formdate[key]).replace(/&nbsp;/g, '');
                var type = $id.attr('type');
                if ($id.hasClass("select2-hidden-accessible")) {
                    type = "select";
                }
                switch (type) {
                    case "checkbox":
                        setDefChk(key, value);
                        //if (value == "true") {
                        //    $id.attr("checked", 'checked');
                        //} else {
                        //    $id.removeAttr("checked");
                        //}
                        break;
                    case "select":
                        $id.val(value.split(",")).trigger("change");
                        break;
                    default:
                        $id.val(value);
                        break;
                }
            }
        };
        return false;
    }
    var postdata = {};
    element.find('input,select,textarea').each(function (r) {
        var $this = $(this);
        var id = $this.attr('id');
        if (id) {
            var type = $this.attr('type');
            switch (type) {
                case "checkbox":
                    var _name = $this.attr("name");
                    var chk_value = [];//定义一个数组    
                    $('input[name="' + _name + '"]:checked').each(function () {  
                        chk_value.push($(this).val());  
                    });
                    postdata[_name] = chk_value.join(",");
                    //postdata[id] = $this.is(":checked");
                    break;
                case "radio":
                    var _name = $this.attr("name");
                    postdata[_name] = $("input[name='" + _name + "']:checked").val();
                    break;
                case "select":
                    //var value = $this.val() == "" ? "&nbsp;" : $this.val();
                    //postdata[id] = value;
                    var text = $this.select2('data');
                    var _v="", _t="", _val=$this.attr("val");
                    if (text.length > 0) {
                        text.forEach(function (value, index, array) {
                            if (_v != "") {
                                _v += ",";
                                _t += ",";
                            }
                            _v += array[index].id;
                            if (array[index].text) {
                                _t += (array[index].text).replace(/　　/g, '');
                            }
                        })
                    }
                    postdata[id] = _v;
                    if (_val) {
                        if (_t != "请选择") {
                            postdata[_val] = _t;
                        }
                    }
                    break;
                default:
                    var value = $this.val() == "" ? "" : $this.val();                    
                    postdata[id] = value;
                    break;
            }
        }
    });
    if ($('[name=__RequestVerificationToken]').length > 0) {
        postdata["__RequestVerificationToken"] = $('[name=__RequestVerificationToken]').val();
    }
    return postdata;
};
$.fn.bindSelected = function (options) {
    var defaults = { val: "", txt: "", mult: false, data: null, def: "请选择" };
    var options = $.extend(defaults, options);
    if (options.data) {
        var $element = $(this);
        $element.select2({
            data: options.data,
            placeholder: options.def,
            closeOnSelect: options.true,
            allowClear: true
        })
    }
    if (!options.mult) {
        if (options.val && options.txt) {
            $(this).html('<option value="' + options.val + '">' + options.txt + '</option>').trigger("change");
        } else {
            if (options.val) {
                $(this).val(options.val).trigger("change");
            } else if (options.txt) {
                $(this).val(findKey(options.data,options.txt)).trigger("change");
            }
        }
    } else {
        if (options.val && options.txt) {
            var _1 = options.val.split(",");
            var _2 = options.txt.split(",");
            for (i = 0; i < _2.length; i++) {
                $(this).append("<option value='" + _1[i] + "'>" + _2[i] + "</option>");
            }
            $(this).val(_1).trigger("change");
        } else {
            if (options.val) {
                $(this).val(options.val).trigger("change");
            } else if(options.txt){
                $(this).val(findKey(options.data, options.txt)).trigger("change");
            }
        }
    }
}
function findKey(dt, id) {
    for (var j = 0; j < dt.length; j++) {
        if (id == dt[j].text) {
            return dt[j].id;
        }
    }
    return null;
}
$.fn.bindSelect = function (options) {
    var defaults = {
        id: "id",
        text: "text",
        search: false,
        url: "",
        param: [],
        data: [],
        method:"post",
        def: "请选择",
        clsOnSlt: true,
        val: null,
        defTxt:null,
        change: null
    };
    var options = $.extend(defaults, options);
    var $element = $(this);
    if (options.data.length > 0) {
        $element.select2({
            data: options.data,
            placeholder: options.def,
            closeOnSelect: options.clsOnSlt,
            allowClear: true
        });
        if (options.val) {
            $(this).val(options.val).trigger("change");
        } 
    } else {
        if (options.url != "") {
            $.ajax({
                url: options.url,
                data: options.param,
                dataType: "json",
                method:options.method,
                async: false,
                success: function (data) {
                    if (data.rows) {
                        $element.select2({
                            data: data.rows,
                            placeholder: options.def,//默认文字提示
                            allowClear: true//允许清空
                        })
                    } else {
                        $element.select2({
                            data: data,
                            placeholder: options.def,//默认文字提示
                            allowClear: true//允许清空
                        })
                    }
                    $element.on("change", function (e) {
                        if (options.change != null) {
                            options.change(data[$(this).find("option:selected").index()]);
                        }
                        $("#select2-" + $element.attr('id') + "-container").html($(this).find("option:selected").text().replace(/　　/g, ''));
                    });
                    if (options.val) {
                        $element.val(options.val).trigger("change");
                    }
                    if (options.defTxt) {
                        $element.val(findKey(data, options.text)).trigger("change");
                    }
                    //$.each(data, function (i) {
                    //    $element.append($("<option></option>").val(data[i][options.id]).html(data[i][options.text]));
                    //});
                    //$element.select2({
                    //    minimumResultsForSearch: options.search == true ? 0 : -1
                    //});
                    //$element.on("change", function (e) {
                    //    if (options.change != null) {
                    //        options.change(data[$(this).find("option:selected").index()]);
                    //    }
                    //    $("#select2-" + $element.attr('id') + "-container").html($(this).find("option:selected").text().replace(/　　/g, ''));
                    //});
                }
            });
        } else {
            $element.select2({
                minimumResultsForSearch: -1
            });
        }
    }
}

$.fn.bindSelect2 = function (options) {
    var defaults = {
        url: "",
        min: 1,
        def: "请选择",
        clsOnSlt:true,
    };
    var $element = $(this);
    var options = $.extend(defaults, options);
    $element.select2({
        ajax: {
            type: 'GET',
            url: options.url,
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    q: $.trim(params.term), // search term 请求参数
                    page: params.page
                };
            },
            processResults: function (data, params) {
                params.page = params.page || 1;                
                return {
                    results: data.rows,//itemList
                    pagination: {
                        more: (params.page * 30) < data.total
                    }
                };
            },
            cache: true
        },
        closeOnSelect: options.clsOnSlt,
        placeholder: options.def,//默认文字提示
        allowClear: true,//允许清空
        escapeMarkup: function (markup) { return markup; }, // 自定义格式化防止xss注入
        minimumInputLength: options.min,//最少输入多少个字符后开始查询
        formatResult: function formatRepo(repo) { return repo.text; }, // 函数用来渲染结果
        formatSelection: function formatRepoSelection(repo) { return repo.text; } // 函数用于呈现当前的选择
    });
}
function getTabId() {
    return top.$(".My_iframe:visible").attr("id");
}
$.fn.authBtn = function (moduleId) {
    if (!moduleId) {
        moduleId = top.$(".My_iframe:visible").attr("id").substr(6);
    }
    var dataJson = top.my_cfg.authButton["btn" + moduleId];
    if (dataJson != undefined) {
        var $element = $(this);
        var html = "";
        var defhtm = "";
        $.each(dataJson, function (i) {
            if (dataJson[i].defBtn=="true") {
                defhtm += '<a class="btn btn-primary dropdown-text" onclick="' + dataJson[i].click + '"><i class="fa fa-plus"></i>' + dataJson[i].text + '</a>';
            } else {
                html += '<li><a onclick="' + dataJson[i].click + '"><i class="fa fa-pencil-square-o"></i>' + dataJson[i].text + '</a></li>';
            }
        })
        $element.find(".btn-group").eq(1).html(defhtm);
        $element.find(".nav-pills").html(html);
    }
}
$.fn.dataGrid = function (options) {
    var defaults = {
        datatype: "json",
        autowidth: true,
        rownumbers: true,
        shrinkToFit: false,
        gridview: true,
        onSelectRow:true,
    };
    var options = $.extend(defaults, options);
    var $element = $(this);
    if (options.onSelectRow) {
        options["onSelectRow"] = function (rowid) {
            var length = $(this).jqGrid("getGridParam", "selrow").length;
            var $operate = $(".operate");
            if ($operate.text().length >72) {
                if (length > 0) {
                    $operate.animate({ "left": 5 }, 200);
                } else {
                    $operate.animate({ "left": '-100.1%' }, 200);
                }
                $operate.find('.close').click(function () {
                    $operate.animate({ "left": '-100.1%' }, 200);
                })
            }
        };
    }
    $element.jqGrid(options);
};

$.fn.dataGridV1 = function (options) {
    var defaults = {
        datatype: "json",
        autowidth: true,
        rownumbers: true,
        shrinkToFit: false,
        gridview: true
    };
    var options = $.extend(defaults, options);
    var $element = $(this);
    options["onSelectRow"] = function (rowid) {
        var length = $(this).jqGrid("getGridParam", "selrow");
        var $operate = $(".operate");
        //if (length) {
            $operate.animate({ "left": 0 }, 200);
        //} else {
           // $operate.animate({ "left": '-100.1%' }, 200);
       // }
        $operate.find('.close').click(function () {
            $operate.animate({ "left": '-100.1%' }, 200);
        })
    };
    $element.jqGrid(options);
};

$.fn.dataGridV2 = function (options) {
    var defaults = {
        datatype: "json",
        autowidth: true,
        rownumbers: true,
        shrinkToFit: false,
        gridview: true
    };
    var options = $.extend(defaults, options);
    var $element = $(this);
    $element.jqGrid(options);
};
function formatUnits(size) {
    if (isNaN(size) || size == null) {
        size = 0;
    }
    if (size <= 0) return size + "bytes";
    var t1 = (size / 1024).toFixed(2);
    if (t1 < 0) {
        return "0KB";
    }
    if (t1 > 0 && t1 < 1024) {
        return t1 + "KB";
    }
    var t2 = (t1 / 1024).toFixed(2);
    if (t2 < 1024)
        return t2 + "MB";
    return (t2 / 1024).toFixed(2) + "GB";
}

function NewDate(str) {
    //str = str.split('-');
    var date = new Date(str);
    //date.setUTCFullYear(str[0], str[1] - 1, str[2]);
    date.setUTCHours(0, 0, 0, 0);
    return date;
}
function TimeCom(dateValue) {
    var newCom;

    if (dateValue == "" || dateValue==null) {
        newCom = new Date();
    } else {
        newCom = NewDate(dateValue);
    }
    this.year = newCom.getYear();
    this.month = newCom.getMonth() + 1;
    this.day = newCom.getDate();
    this.hour = newCom.getHours();
    this.minute = newCom.getMinutes();
    this.second = newCom.getSeconds();
    this.msecond = newCom.getMilliseconds();
    this.week = newCom.getDay();
}
function DateDiff(interval, date1, date2) {
    var TimeCom1 = new TimeCom(date1);
    var TimeCom2 = new TimeCom(date2);
    var result;
    switch (String(interval).toLowerCase()) {
        case "y":
        case "year":
            result = TimeCom1.year - TimeCom2.year;
            break;
        case "m":
        case "month":
            result = (TimeCom1.year - TimeCom2.year) * 12 + (TimeCom1.month - TimeCom2.month);
            if (TimeCom1.day >= TimeCom2.day) {
                result = result + 1;
            }
            break;
        case "d":
        case "day":
            result = Math.round((Date.UTC(TimeCom1.year, TimeCom1.month - 1, TimeCom1.day) - Date.UTC(TimeCom2.year, TimeCom2.month - 1, TimeCom2.day)) / (1000 * 60 * 60 * 24));
            break;
        case "h":
        case "hour":
            result = Math.round((Date.UTC(TimeCom1.year, TimeCom1.month - 1, TimeCom1.day, TimeCom1.hour) - Date.UTC(TimeCom2.year, TimeCom2.month - 1, TimeCom2.day, TimeCom2.hour)) / (1000 * 60 * 60));
            break;
        case "min":
        case "minute":
            result = Math.round((Date.UTC(TimeCom1.year, TimeCom1.month - 1, TimeCom1.day, TimeCom1.hour, TimeCom1.minute) - Date.UTC(TimeCom2.year, TimeCom2.month - 1, TimeCom2.day, TimeCom2.hour, TimeCom2.minute)) / (1000 * 60));
            break;
        case "s":
        case "second":
            result = Math.round((Date.UTC(TimeCom1.year, TimeCom1.month - 1, TimeCom1.day, TimeCom1.hour, TimeCom1.minute, TimeCom1.second) - Date.UTC(TimeCom2.year, TimeCom2.month - 1, TimeCom2.day, TimeCom2.hour, TimeCom2.minute, TimeCom2.second)) / 1000);
            break;
        case "ms":
        case "msecond":
            result = Date.UTC(TimeCom1.year, TimeCom1.month - 1, TimeCom1.day, TimeCom1.hour, TimeCom1.minute, TimeCom1.second, TimeCom1.msecond) - Date.UTC(TimeCom2.year, TimeCom2.month - 1, TimeCom2.day, TimeCom2.hour, TimeCom2.minute, TimeCom2.second, TimeCom1.msecond);
            break;
        case "w":
        case "week":
            result = Math.round((Date.UTC(TimeCom1.year, TimeCom1.month - 1, TimeCom1.day) - Date.UTC(TimeCom2.year, TimeCom2.month - 1, TimeCom2.day)) / (1000 * 60 * 60 * 24)) % 7;
            break;
        default:
            result = "0";
    }
    if (result < 0) {
        return 0;
    }
    return (result);
}

Date.prototype.format = function (format) //author: meizz 
{
    var o = {
        "M+": this.getMonth() + 1, //month         
        "d+": this.getDate(),    //day         
        "h+": this.getHours(),   //hour         
        "m+": this.getMinutes(), //minute         
        "s+": this.getSeconds(), //second         
        "q+": Math.floor((this.getMonth() + 3) / 3),  //quarter         
        "S": this.getMilliseconds() //millisecond     
    };
    if (/(y+)/.test(format))
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};

//产生随机数
$.fn.rndWord = function (min, max, randomFlag) {
    var str = "",
        range = min,
        arr = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

    // 随机产生
    if (randomFlag) {
        range = Math.round(Math.random() * (max - min)) + min;
    }
    for (var i = 0; i < range; i++) {
        pos = Math.round(Math.random() * (arr.length - 1));
        str += arr[pos];
    }
    $(this).val(str);
}

//判断是否是当天
function difDt(str) {
    var nowDate = new Date();
    var year = nowDate.getFullYear();
    var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1)
     : nowDate.getMonth() + 1;
    var day = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate
     .getDate();
    var dateStr = year + "-" + month + "-" + day;
    str = str.substring(0, str.indexOf(" "))
    return str === dateStr;
}

function getJsonItem(arr,n,v) {  
    for (var i = 0; i < arr.length; i++)  
        if (arr[i][n]==v)  
            return arr[i];  
} 

function getJsonItem(arr, obj) {
    arrFor: for (var i = 0; i < arr.length; i++) {
        for (var n in obj)
            if (arr[i][n] != obj[n])
                continue arrFor;
        return arr[i];
    }
} 

/*demo
 * getJsonItem(json,"id","2")
 * getJsonItem(json,{"id":"2","num":"234"})
 * /
*/