var interval_height="";

function showPopup(_languaje,_tt,_url,_width,_height,_clase,_id) {
	_idioma=_languaje;
	_partesURL=_url.split("#");
	_url=_partesURL[0]+idioma(_languaje,0)+_partesURL[1];
	
	if ($.browser.msie && parseInt($.browser.version, 10) <= 6) { 
		$("#barra_foot").append("<div id='content_testpc'></div>");
		$("#content_testpc").html("<iframe src='"+_url+"' id='"+_id+"' frameborder='0' width='"+_width+"' height='"+_height+"' scrolling='no' ></iframe>");
		$("#content_testpc").dialog({title: _tt,dialogClass: _clase });
		$("#content_testpc").dialog( "option", "width", 653 );
		/*
		AUI().ready('aui-dialog','aui-dialog-iframe','liferay-portlet-url', function(A) {
		window.myDialog = new A.Dialog({title:_tt,width:_width,height:_height,centered:true,modal:true,resizable:false}).plug(A.Plugin.DialogIframe,{uri:_url,iframeCssClass:_clase,iframeId:_id}).render();});
		interval_height=setInterval("altura('"+_id+"',"+_height+")",500);
		*/
	} else {
		AUI().ready('aui-dialog','aui-dialog-iframe','liferay-portlet-url', function(A) {
		window.myDialog = new A.Dialog({title:_tt,width:_width,height:_height,centered:true,modal:true,resizable:false}).plug(A.Plugin.DialogIframe,{uri:_url,iframeCssClass:_clase,iframeId:_id}).render();});
	}

}


function idioma(tot,part){
	_idioma=tot;
	_partesIdioma=_idioma.split("_");
	return _partesIdioma[part];
}

function ventana(_languaje,_url,ancho,alto,nombre){
	_idioma=_languaje;
	if(_idioma!=""){
	_partesURL=_url.split("#");
	_url=_partesURL[0]+idioma(_languaje,0)+_partesURL[1];
	}
	x = (screen.width / 2) - (ancho/2);
	y = (screen.height / 2) - (alto/2);
	window.open(_url,nombre, "width="+ancho+",height="+alto+",menubar=0,toolbar=0,directories=0,scrollbars=no,resizable=no,left= "+ x + ",top=" + y +"");
}

function open_win(url_,name_,width_,height_){
	window.open(url_,name_, 'width='+width_+',height='+height_+',menubar=0,toolbar=0,directories=0,scrollbars=yes,resizable=yes');
	return false;
}

function altura(_id,_alt){
	if($('#'+_id).height()!=_alt){
	$('#'+_id).height(_alt);
	$('aui-widget-bd.aui-panel-bd.aui-dialog-bd').height(_alt);
	clearInterval(interval_height);
	}
}



function _RevisionForo(){
	
	// SUSCRIBE	
	$("#portlet_19 .thread-controls .thread-actions .lfr-table .taglib-icon:eq(1)").hide();
	
	
	
	// PERMISOS FORO COMPARTIDO POR CLASE CON EL CUERPO DEL POST. COGEMOS EL SEGUNDO.
	// aui-fieldset aui-field aui-field-wrapper
	//$("#portlet_19 .aui-fieldset .aui-field .aui-field-wrapper:eq(1)").hide();
	
	$("#portlet_20 .aui-field-wrapper:eq(1)").hide();
	//$("#portlet_20 .aui-field.aui-field-text:eq(1)").hide();
	$("#portlet_33 .aui-field-wrapper:eq(1)").hide();
	$("#portlet_33 .aui-field.aui-field-text:eq(1)").hide();
	//$("#portlet_36 .aui-field-wrapper:eq(1)").hide();
	//$("#portlet_36 .aui-field.aui-field-text:eq(1)").hide();
	$("#mediatecaClass #hmhp_postReplyForm0").show();
	
}

$(document).ready(function() {
	_RevisionForo();


	$('.lms-tree ul li.option-more ul').hide();
	
	$('.lms-tree ul li span.desplegar').click(function() {
		var enlaceEstado = $(this).parent().hasClass('option-more');
		if(enlaceEstado == 1){
			$(this).parent().removeClass("option-more");
			$(this).parent().addClass("option-less");
			$(this).parent().find('ul').slideDown();
		}else{
			$(this).parent().removeClass("option-less");
			$(this).parent().addClass("option-more");
			$(this).parent().find('ul').slideUp();
		}

	});
	
	$('div.option-more .collapsable').hide();
	
	$('div.option-more span').click(function() {
		var enlaceEstado = $(this).parent().hasClass('option-more');
		if(enlaceEstado == 1){
			$(this).parent().removeClass("option-more");
			$(this).parent().addClass("option-less");
			$(this).parent().find('div.collapsable').slideDown();
		}else{
			$(this).parent().removeClass("option-less");
			$(this).parent().addClass("option-more");
			$(this).parent().find('div.collapsable').slideUp();
		}

	}); 

	$('.ico_feedback').click(function() {	
		var src = "/web/guest/feedback";
		$.modal('<iframe src="' + src + '" height="330" width="550" style="border:0">');
	});	
	
});

