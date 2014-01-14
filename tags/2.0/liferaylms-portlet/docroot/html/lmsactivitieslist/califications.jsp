<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.lms.service.LearningActivityResultLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivityResult"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>

<%@ include file="/init.jsp"%>

<%
	long actId = ParamUtil.getLong(request, "resId", 0);
	LearningActivity learnActivity = LearningActivityLocalServiceUtil.getLearningActivity(actId);
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	dateFormat.setTimeZone(timeZone);
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage","/html/lmsactivitieslist/califications.jsp");
	portletURL.setParameter("resId",Long.toString(actId));
%>

<h2 class="table_title"><%=learnActivity.getTitle(themeDisplay.getLocale()) %></h2>

<portlet:renderURL var="calificacionesURL">
	<portlet:param name="jspPage" value="/html/lmsactivitieslist/califications.jsp"></portlet:param>
</portlet:renderURL>

<liferay-ui:search-container iteratorURL="<%=portletURL%>" deltaConfigurable="true" emptyResultsMessage="there-are-no-results" delta="10">

   	<liferay-ui:search-container-results>
		<%
			//List<LearningActivityResult> learnResults = LearningActivityResultLocalServiceUtil.getByActId(actId);
			DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LearningActivityResult.class).add(PropertyFactoryUtil.forName("actId").eq(actId));

			pageContext.setAttribute("results", LearningActivityResultLocalServiceUtil.dynamicQuery(dynamicQuery,searchContainer.getStart(),searchContainer.getEnd()));
		    pageContext.setAttribute("total", (int)LearningActivityResultLocalServiceUtil.dynamicQueryCount(DynamicQueryFactoryUtil.forClass(LearningActivityResult.class).add(PropertyFactoryUtil.forName("actId").eq(actId))));

		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="com.liferay.lms.model.LearningActivityResult" keyProperty="larId" modelVar="result">
		
		<%
			User usu = UserLocalServiceUtil.getUser(result.getUserId());
			
			String puntuation = String.valueOf(result.getResult());
			String res = result.getPassed()?LanguageUtil.get(themeDisplay.getLocale(),"passed"):LanguageUtil.get(themeDisplay.getLocale(),"not-passed");
			String startdate = (result.getStartDate()!=null)?dateFormat.format(result.getStartDate()):"";
			
			//Si es de tipo test y no se ha entregado
			if(learnActivity.getTypeId() == 0 && result.getEndDate() == null){
				puntuation = LanguageUtil.get(themeDisplay.getLocale(),"activity.showcalifications.notsubmitted");
				res = LanguageUtil.get(themeDisplay.getLocale(),"activity.showcalifications.notsubmitted");
				startdate = LanguageUtil.get(themeDisplay.getLocale(),"activity.showcalifications.notsubmitted");
			}
		%>

		<liferay-ui:search-container-column-text name="user"><%=usu.getFullName() %> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="activity.showcalifications.puntuation">	<%=puntuation %> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="activity.showcalifications.result">		<%=res %> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="activity.showcalifications.startdate">	<%=startdate %> </liferay-ui:search-container-column-text>
		
	</liferay-ui:search-container-row>
	
 	<liferay-ui:search-iterator />
 	
</liferay-ui:search-container>
