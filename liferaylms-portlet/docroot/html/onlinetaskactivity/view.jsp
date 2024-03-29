
<%@page import="com.liferay.portal.kernel.xml.Element"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portal.kernel.xml.SAXReaderUtil"%>
<%@page import="com.liferay.portal.kernel.xml.Node"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.model.Team"%>
<%@page import="com.liferay.portal.service.TeamLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.service.ResourceBlockLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.security.permission.PermissionCheckerFactoryUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityTryLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivityTry"%>
<%@page import="com.liferay.lms.service.LearningActivityResultLocalServiceUtil"%>
<%@page import="com.liferay.lms.service.LearningActivityLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivity"%>
<%@page import="com.liferay.portal.service.ServiceContextFactory"%>
<%@page import="com.liferay.portal.service.ServiceContext"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.lms.service.LearningActivityTryLocalServiceUtil"%>
<%@page import="com.liferay.lms.model.LearningActivityResult"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.CustomSQLParam"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.model.RoleConstants"%>
<%@page import="com.liferay.lms.OnlineActivity"%>
<%@page import="com.liferay.lms.model.Course"%>
<%@page import="com.liferay.lms.service.CourseLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.comparator.*"%>
<%@page import="com.liferay.util.JavaScriptUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.documentlibrary.FileSizeException"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>

<%@ include file="/init.jsp" %>
<div class="container-activity">
<%

long actId = ParamUtil.getLong(request,"actId",0);
if(actId==0)
{
	renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.FALSE);
}
else
{
	Course course=CourseLocalServiceUtil.fetchByGroupCreatedId(themeDisplay.getScopeGroupId());
	LearningActivity activity=LearningActivityLocalServiceUtil.getLearningActivity(actId);
	boolean isSetTextoEnr =  StringPool.TRUE.equals(LearningActivityLocalServiceUtil.getExtraContentValue(actId,"textoenr"));
	boolean isSetFichero =  StringPool.TRUE.equals(LearningActivityLocalServiceUtil.getExtraContentValue(actId,"fichero"));
	
	long typeId=activity.getTypeId();
	
	if(typeId==6&&(!LearningActivityLocalServiceUtil.islocked(actId,themeDisplay.getUserId())||
			permissionChecker.hasPermission(activity.getGroupId(), LearningActivity.class.getName(), actId, ActionKeys.UPDATE)||
			permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), "com.liferay.lms.model",themeDisplay.getScopeGroupId(),"ACCESSLOCK")))
	{

	String criteria = request.getParameter("criteria");
	String gradeFilter = request.getParameter("gradeFilter");

	if (criteria == null) criteria = "";	
	if (gradeFilter == null) gradeFilter = "";
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("jspPage","/html/onlinetaskactivity/view.jsp");
	portletURL.setParameter("criteria", criteria); 
	portletURL.setParameter("gradeFilter", gradeFilter);
	
	LearningActivity learningActivity=LearningActivityLocalServiceUtil.getLearningActivity(actId);
	
	LearningActivityResult result = LearningActivityResultLocalServiceUtil.getByActIdAndUserId(actId, themeDisplay.getUserId());
	Object  [] arguments=null;
	
	if(result!=null){	
		arguments =  new Object[]{result.getResult()};
	}
	
	boolean isTeacher=permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), "com.liferay.lms.model",themeDisplay.getScopeGroupId(), "VIEW_RESULTS");	
	boolean isTablet = ParamUtil.getBoolean(request, "isTablet",false);
%>

<h2 class="description-title"><%=activity.getTitle(themeDisplay.getLocale()) %></h2>
<%--<h3 class="description-h3"><liferay-ui:message key="description" /></h3> --%>
<div class="description"><%=activity.getDescription(themeDisplay.getLocale()) %></div>
<liferay-portlet:renderURL var="returnurl">
<liferay-portlet:param name="jspPage" value="/html/onlineactivity/view.jsp" />	
</liferay-portlet:renderURL>

<portlet:renderURL var="viewUrlPopGrades" windowState="<%= LiferayWindowState.POP_UP.toString() %>">   
	<portlet:param name="actId" value="<%=String.valueOf(activity.getActId()) %>" />      
	<portlet:param name="isTablet" value="<%=String.valueOf(isTablet) %>" />      
    <portlet:param name="jspPage" value="/html/onlinetaskactivity/popups/grades.jsp" />           
</portlet:renderURL>

<portlet:renderURL var="setGradesURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">   
	<portlet:param name="actId" value="<%=String.valueOf(activity.getActId()) %>" />      
	<portlet:param name="isTablet" value="<%=String.valueOf(isTablet) %>" /> 
	<portlet:param name="ajaxAction" value="setGrades" />      
   	<portlet:param name="jspPage" value="/html/onlinetaskactivity/popups/grades.jsp" />           
</portlet:renderURL>
      
<script type="text/javascript">
   <!--

    function <portlet:namespace />showPopupGradesStudent(studentId,selfGrade)
    {

		AUI().use('aui-dialog','liferay-portlet-url', function(A){
			var renderUrl = Liferay.PortletURL.createRenderURL();							
			renderUrl.setWindowState('<%= LiferayWindowState.POP_UP.toString() %>');
			renderUrl.setPortletId('<%=portletDisplay.getId()%>');
			renderUrl.setParameter('actId', '<%=String.valueOf(activity.getActId()) %>');
			renderUrl.setParameter('isTablet', '<%=String.valueOf(isTablet) %>');
			<%
			if(isTeacher){
			%>
			if(!selfGrade) {
				renderUrl.setParameter('studentId', studentId);
			}
			<%
			}
			%>
			renderUrl.setParameter('jspPage', '/html/onlinetaskactivity/popups/grades.jsp');

			window.<portlet:namespace />popupGrades = new A.Dialog({
				id:'<portlet:namespace />showPopupGradesStudent',
	            title: '<liferay-ui:message key="onlineActivity.view.last" />',
	            centered: true,
	            modal: true,
	            width: 600,
	            height: 350,
	            after: {   
		          	close: function(event){ 
		          		document.getElementById('<portlet:namespace />studentsearch').submit();
	            	}
	            }
	        }).plug(A.Plugin.IO, {
	            uri: renderUrl.toString()
	        }).render();
			window.<portlet:namespace />popupGrades.show();   
		});
    }
    
    function <portlet:namespace />showPopupGradesTeacher(studentId,selfGrade)
    {

		AUI().use('aui-dialog','liferay-portlet-url', function(A){
			var renderUrl = Liferay.PortletURL.createRenderURL();							
			renderUrl.setWindowState('<%= LiferayWindowState.POP_UP.toString() %>');
			renderUrl.setPortletId('<%=portletDisplay.getId()%>');
			renderUrl.setParameter('actId', '<%=String.valueOf(activity.getActId()) %>');
			renderUrl.setParameter('isTablet', '<%=String.valueOf(isTablet) %>');
			<%
			if(isTeacher){
			%>
			if(!selfGrade) {
				renderUrl.setParameter('studentId', studentId);
			}
			<%
			}
			%>
			renderUrl.setParameter('jspPage', '/html/onlinetaskactivity/popups/grades.jsp');

			window.<portlet:namespace />popupGrades = new A.Dialog({
				id:'<portlet:namespace />showPopupGradesTeacher',
	            title: '<liferay-ui:message key="onlinetaskactivity.set.grades" />',
	            centered: true,
	            modal: true,
	            width: 600,
	            height: 800,
	            after: {   
		          	close: function(event){ 
		          		document.getElementById('<portlet:namespace />studentsearch').submit();
	            	}
	            }
	        }).plug(A.Plugin.IO, {
	            uri: renderUrl.toString()
	        }).render();
			window.<portlet:namespace />popupGrades.show();   
		});
    }

    function <portlet:namespace />doClosePopupGrades()
    {
        AUI().use('aui-dialog', function(A) {
        	window.<portlet:namespace />popupGrades.close();
        });
    }

	<%
	if((PermissionCheckerFactoryUtil.create(themeDisplay.getUser())).hasPermission(themeDisplay.getScopeGroupId(), "com.liferay.lms.model", themeDisplay.getScopeGroupId(), "VIEW_RESULTS")){
	%>

    function <portlet:namespace />doSaveGrades()
    {
        AUI().use('aui-io-request','io-form', function(A) {
            A.io.request('<%= setGradesURL %>', { 
                method : 'POST', 
                form: {
                    id: '<portlet:namespace />fn_grades'
                },
                dataType : 'html', 
                on : { 
                    success : function() { 
                    	A.one('.aui-dialog-bd').set('innerHTML',this.get('responseData'));				                    	
                    } 
                } 
            });
        });
    }
	<%
	}
	%>

    //-->
</script>

<%
if((PermissionCheckerFactoryUtil.create(themeDisplay.getUser())).hasPermission(themeDisplay.getScopeGroupId(), "com.liferay.lms.model", themeDisplay.getScopeGroupId(), "VIEW_RESULTS")){
%>

<div class="student_search"> 

	<portlet:renderURL var="buscarURL">
		<portlet:param name="jspPage" value="/html/onlinetaskactivity/view.jsp"></portlet:param>
	</portlet:renderURL>

	<h5><liferay-ui:message key="studentsearch"/></h5>
	<aui:form name="studentsearch" action="<%=buscarURL %>" method="post">
		<aui:fieldset>
			<%if(isTablet){ %>
				<aui:input name="isTablet" type="hidden" value="true" ></aui:input>
			<% } %>
			<aui:column>
				<aui:input label="studentsearch.text.criteria" name="criteria" size="20" value="<%=criteria %>" />	
			</aui:column>
			<aui:column>
				<aui:select label="offlinetaskactivity.status" name="gradeFilter" onchange='<%="document.getElementById(\'" + renderResponse.getNamespace() + "studentsearch\').submit();" %>'>
					<aui:option selected='<%= gradeFilter.equals("") %>' value=""><liferay-ui:message key="onlinetaskactivity.all" /></aui:option>
					<aui:option selected='<%= gradeFilter.equals("nocalification") %>' value="nocalification"><liferay-ui:message key="onlinetaskactivity.status.passed" /></aui:option>
					<aui:option selected='<%= gradeFilter.equals("passed") %>' value="passed"><liferay-ui:message key="onlinetaskactivity.passed" /></aui:option>
					<aui:option selected='<%= gradeFilter.equals("failed") %>' value="failed"><liferay-ui:message key="onlinetaskactivity.failed" /></aui:option>
				</aui:select>
			</aui:column>	
			<aui:column>
				<aui:button cssClass="inline-button" name="searchUsers" value="search" type="submit" />
			</aui:column>	
		</aui:fieldset>
	</aui:form>
	
	<liferay-ui:search-container iteratorURL="<%=portletURL%>" emptyResultsMessage="there-are-no-results" delta="10" deltaConfigurable="true">

	   	<liferay-ui:search-container-results>
			<%
				String middleName = null;
		
				LinkedHashMap<String,Object> params = new LinkedHashMap<String,Object>();
				params.put("usersGroups", new Long(themeDisplay.getScopeGroupId()));
				params.put("onlineActivity",new CustomSQLParam(OnlineActivity.ACTIVITY_TRY_SQL,actId));
						
				if(gradeFilter.equals("passed")) {
					params.put("passed",new CustomSQLParam(OnlineActivity.ACTIVITY_RESULT_PASSED_SQL,actId));
				}
				else {
					if(gradeFilter.equals("failed")) {
						params.put("failed",new CustomSQLParam(OnlineActivity.ACTIVITY_RESULT_FAIL_SQL,actId));
					} else {
						if (gradeFilter.equals("nocalification")) {
							params.put("nocalification",new CustomSQLParam(OnlineActivity.ACTIVITY_RESULT_NO_CALIFICATION_SQL,actId));
						}
					}
				}
				
				OrderByComparator obc = new UserFirstNameComparator(true);
				
				if(!StringPool.BLANK.equals(LearningActivityLocalServiceUtil.getExtraContentValue(actId,"team"))){
					String teamId = LearningActivityLocalServiceUtil.getExtraContentValue(actId,"team");
					Team team = TeamLocalServiceUtil.getTeam(Long.parseLong(teamId));
					params.put("usersTeams", team.getTeamId());
				}
				//if ((GetterUtil.getInteger(PropsUtil.get(PropsKeys.PERMISSIONS_USER_CHECK_ALGORITHM))==6)&&(!ResourceBlockLocalServiceUtil.isSupported("com.liferay.lms.model"))){		
				//
				//	params.put("notTeacher",new CustomSQLParam(OnlineActivity.NOT_TEACHER_SQL,themeDisplay.getScopeGroupId()));
				//	List<User> userListPage = UserLocalServiceUtil.search(themeDisplay.getCompanyId(), criteria, WorkflowConstants.STATUS_ANY, params, searchContainer.getStart(), searchContainer.getEnd(), obc);
				//	int userCount = UserLocalServiceUtil.searchCount(themeDisplay.getCompanyId(), criteria,  WorkflowConstants.STATUS_ANY, params);
				//	pageContext.setAttribute("results", userListPage);
				//	pageContext.setAttribute("total", userCount);
				//
				//}
				//else{
				
					List<User> userListsOfCourse = UserLocalServiceUtil.search(themeDisplay.getCompanyId(), criteria, WorkflowConstants.STATUS_ANY, params, QueryUtil.ALL_POS, QueryUtil.ALL_POS, obc);
					List<User> userLists =  new ArrayList<User>(userListsOfCourse.size());
					
					for(User userOfCourse:userListsOfCourse){							
						if(!PermissionCheckerFactoryUtil.create(userOfCourse).hasPermission(themeDisplay.getScopeGroupId(), "com.liferay.lms.model",themeDisplay.getScopeGroupId(), "VIEW_RESULTS")){
							userLists.add(userOfCourse);
						}
					}	
				
					pageContext.setAttribute("results", ListUtil.subList(userLists, searchContainer.getStart(), searchContainer.getEnd()));
					pageContext.setAttribute("total", userLists.size());	
				//}
			%>
		</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row className="com.liferay.portal.model.User" keyProperty="userId" modelVar="user">
		<liferay-ui:search-container-column-text name="name">
			<liferay-ui:user-display userId="<%=user.getUserId() %>"></liferay-ui:user-display>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="calification">
			<% LearningActivityResult learningActivityResult = LearningActivityResultLocalServiceUtil.getByActIdAndUserId(actId, user.getUserId()); 
			   if((learningActivityResult!=null)&&(learningActivityResult.getEndDate()!=null)) {	   
					   Object  [] arg =  new Object[]{learningActivityResult.getResult(),activity.getPasspuntuation()};
					   if(learningActivityResult.getPassed()){
						   %><liferay-ui:message key="onlinetaskactivity.student.passed"  arguments="<%=arg %>" /><%
					   }else{ 
						   %><liferay-ui:message key="onlinetaskactivity.student.failed"  arguments="<%=arg %>" /><%
					   }
			   }else {
					   %><liferay-ui:message key="onlinetaskactivity.student.without.qualification" /><% 
               }

			 	if(isTablet){
			 		LearningActivityTry lATry = LearningActivityTryLocalServiceUtil.getLastLearningActivityTryByActivityAndUser(actId, user.getUserId()); 
			 		if(lATry!=null){
			 			String urlFile = null;
			 			String titleFile = null;
			 			long sizeKbFile=0;
			 			Iterator<Node> nodeItr = SAXReaderUtil.read(lATry.getTryResultData()).getRootElement().nodeIterator();		
			 			while(nodeItr.hasNext()) {
			 		         Node element = nodeItr.next();
			 		         if(OnlineActivity.FILE_XML.equals(element.getName())) {
			 	        		try{
			 		        	 	DLFileEntry dlfile = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(((Element)element).attributeValue("id")));
			 		    			urlFile = themeDisplay.getPortalURL()+"/documents/"+dlfile.getGroupId()+"/"+dlfile.getUuid();
			 		    			titleFile = dlfile.getTitle();
			 		    			sizeKbFile = dlfile.getSize()/1024;
			 	        		}
			 	        		catch(Throwable a){
			 	        		}
			 		         }
			 		    }

			 			if(urlFile!=null){
			%>		
					<p class="see-more">
							<a class="verMas2" href="<%=urlFile%>"><%=titleFile+"&nbsp;("+ sizeKbFile +"Kb)&nbsp;"%> <liferay-ui:message key="onlinetaskactivity.grades.download"/></a>
					</p>
            		<!-- Very ugly -->
					<br /><br />
			<%			}
					}
				}else{
					
				}
			%>
            <p class="see-more">
				<a href="javascript:<portlet:namespace />showPopupGradesTeacher(<%=Long.toString(user.getUserId()) %>);"><liferay-ui:message key="onlinetaskactivity.set.grades"/></a>
			</p>
		</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		
	 	<liferay-ui:search-iterator />
	 	
	</liferay-ui:search-container>
	
</div>
<% } %>		
	
	<portlet:actionURL name="setActivity" var="setActivity">
		<portlet:param name="actId" value="<%=Long.toString(activity.getActId()) %>" />
	</portlet:actionURL>
	
	<% if((activity.getTries()==0)||(activity.getTries()>LearningActivityTryLocalServiceUtil.getTriesCountByActivityAndUser(actId, user.getUserId()))){ 
	
	if(isSetTextoEnr){ %>

	<% } %>
	
	<%if(isTablet!=true||isTeacher!=true){ %>
	
		<aui:form name="fm" action="<%=setActivity%>"  method="post" enctype="multipart/form-data" cssClass='<%=(result!=null)?((result.getEndDate()!= null)?"aui-helper-hidden":""):""%>' >
			<aui:fieldset>
			<% if(isSetTextoEnr){ %>
			<aui:input type="hidden" name="text" value='<%= ParamUtil.getString(request,"text", StringPool.BLANK) %>'/>
			<aui:field-wrapper label="text" name="DescripcionRichTxt" >
				<div id="<portlet:namespace/>DescripcionRichTxt" ><%= ParamUtil.getString(request,"text", StringPool.BLANK) %></div>
			</aui:field-wrapper>
			<liferay-ui:input-editor toolbarSet="actliferay" name="DescripcionRichTxt" initMethod="initEditor"  />
			<script type="text/javascript">
		    <!--
		
				function <portlet:namespace />initEditor() {
					return "";
				}
		
			    function <portlet:namespace />extractCodeFromEditor()
			    {
					try {
						document.<portlet:namespace />fm['<portlet:namespace />text'].value = window['<portlet:namespace />DescripcionRichTxt'].getHTML();
					}
					catch (e) {
					}
			    	
			    }
		
		    -->
			</script>	
			<% } 
			   else { %>
			<aui:field-wrapper label="text" name="text" >
				<aui:input type="textarea" cols="100" rows="5" name="text" label="" value='<%= ParamUtil.getString(request,"text", StringPool.BLANK) %>'/>
			</aui:field-wrapper>
			<% }
			   if(isSetFichero){ %>
			<aui:field-wrapper label="courseadmin.importuserrole.file" name="fileName" >
	   		<aui:input inlineLabel="left" inlineField="true"
				  	name="fileName" label="" id="fileName" type="file" value="" />
			</aui:field-wrapper>
			<liferay-ui:error exception="<%= FileSizeException.class %>">
				<%
				long fileMaxSize = GetterUtil.getLong(PrefsPropsUtil.getString(PropsKeys.DL_FILE_MAX_SIZE));
		
				if (fileMaxSize == 0) {
					fileMaxSize = GetterUtil.getLong(PrefsPropsUtil.getString(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE));
				}
		
				fileMaxSize /= 1024;
				%>
		
				<liferay-ui:message arguments="<%= fileMaxSize %>" key="onlineActivity.enter.valid.file" />
			</liferay-ui:error>
			<liferay-ui:error exception="<%= com.liferay.portlet.documentlibrary.FileExtensionException.class %>">
				<liferay-ui:message key="onlineActivity.not.allowed.file.type"/>
			</liferay-ui:error>
			<liferay-ui:error key="onlineActivity.mandatory.file" message="onlineActivity.mandatory.file" />
			<liferay-ui:error key="onlineActivity-error-file-type" message="onlineActivity.not.allowed.file.type" />
			<% } %>
			</aui:fieldset>
			<aui:button-row>
			<aui:button type="submit" value="onlinetaskactivity.save" onClick='<%=(isSetTextoEnr)?(renderResponse.getNamespace() + "extractCodeFromEditor()"):""%>'></aui:button>
			</aui:button-row>
		</aui:form>
	<%} %>
	<liferay-ui:success key="onlinetaskactivity.updating" message="onlinetaskactivity.updating" />
	<% } if(!isTeacher) { %>
	
<div class="nota"> 

<% if (result!=null){ %>
	<p class="doc_descarga"><a class="verMas" href="javascript:<portlet:namespace />showPopupGradesStudent(<%=Long.toString(user.getUserId()) %>,true);"><liferay-ui:message key="onlineActivity.view.last" /></a></p>
	<%
	if(result.getEndDate()!= null){
		%><p><liferay-ui:message key="your-result-activity" /><%=arguments[0] %></p><%
		if(LearningActivityResultLocalServiceUtil.userPassed(actId,themeDisplay.getUserId())){
			%><p><liferay-ui:message key="your-result-pass-activity" /> </p><%
		}else{
			Object  [] arg =  new Object[]{activity.getPasspuntuation()};
			%><p><liferay-ui:message key="your-result-dont-pass-activity"  arguments="<%=arg %>" /> </p><%
		}
		if (!result.getComments().trim().equals("")){ %>
			<h3><liferay-ui:message key="comment-teacher" /></h3>
			<p><span class="destacado"><%=result.getComments() %></span></p>
		<%}
	}
}else {
	if(activity.getTries()!=0) {
%>
	<p class="doc_descarga"><span><liferay-ui:message key="onlinetaskactivity.not.qualificated.activity" /></span> <a class="verMas" href="javascript:<portlet:namespace />showPopupGradesStudent(<%=Long.toString(user.getUserId()) %>,true);"><liferay-ui:message key="onlineActivity.view.last" /></a></p>
<% 
	}	
}%>

</div>

<% }}} %>
</div>