<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletRequest"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portal.model.PortletConstants"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@ include file="/init.jsp" %>

<%
	LearningActivity learningActivity = LearningActivityLocalServiceUtil.getLearningActivity(ParamUtil.getLong(request,"resId"));
	long entryId=ParamUtil.getLong(request, "assertId");
	if(entryId==0){
		entryId = GetterUtil.getLong(LearningActivityLocalServiceUtil.getExtraContentValue(learningActivity.getActId(), "assetEntry"), 0);
	}
	
	LiferayPortletURL backUrl = PortletURLFactoryUtil.create(request, PortalUtil.getJsSafePortletId("lmsactivitieslist"+
				PortletConstants.WAR_SEPARATOR+portletConfig.getPortletContext().getPortletContextName()), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	backUrl.setWindowState(LiferayWindowState.POP_UP);
	backUrl.setParameter("actionEditing", String.valueOf(true));	
	backUrl.setParameter("resId", String.valueOf(learningActivity.getActId()));	
	backUrl.setParameter("jspPage", "/html/editactivity/editactivity.jsp");
	backUrl.setParameter("assertId", String.valueOf(entryId));	
	
	AssetEntry entry=AssetEntryLocalServiceUtil.getEntry(entryId);
	AssetRendererFactory assetRendererFactory=AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(entry.getClassName());			
	AssetRenderer assetRenderer= AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(entry.getClassName()).getAssetRenderer(entry.getClassPK());	
	PortletURL path = assetRenderer.getURLEdit((LiferayPortletRequest)renderRequest,(LiferayPortletResponse)renderResponse); 
    path.setWindowState(LiferayWindowState.POP_UP);
    
%>
<script type="text/javascript">
<!--
	function <portlet:namespace />back(source) {
		if ((!!window.postMessage)&&(window.parent != window)) {
			AUI().use('json-stringify', function(A){
				parent.postMessage(JSON.stringify({name:'resizeWidthActivity',
        							   width:'750px'}), window.location.origin);
			});
		}

	}

	function <portlet:namespace />load(source) {
	    if (source.Document && source.Document.body.scrollHeight) 
	        source.height = source.contentWindow.document.body.scrollHeight;
	    else if (source.contentDocument && source.contentDocument.body.scrollHeight) 
	        source.height = source.contentDocument.body.scrollHeight + 35;
	    else if (source.contentDocument && source.contentDocument.body.offsetHeight) 
	        source.height = source.contentDocument.body.offsetHeight + 35;
	}

//-->
</script>

<link href='http://fonts.googleapis.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>
<liferay-ui:icon image="back" message="back" url="<%=backUrl.toString() %>" label="true" onClick="<%=renderResponse.getNamespace()+\"back(this)\" %>" />
<liferay-ui:header title="<%=AssetRendererFactoryRegistryUtil.
								getAssetRendererFactoryByClassName(LearningActivity.class.getName()).
								getClassTypes(new long[0], themeDisplay.getLocale()).get(Long.valueOf(learningActivity.getTypeId()))%>"></liferay-ui:header>
<liferay-ui:header title="<%=learningActivity.getTitle(themeDisplay.getLocale()) %>"></liferay-ui:header>
<iframe id="<portlet:namespace/>editor" src="<%=path.toString() %>" onload="<portlet:namespace />load(this)" frameBorder="0" scrolling="no" width="100%" height="0"></iframe>
