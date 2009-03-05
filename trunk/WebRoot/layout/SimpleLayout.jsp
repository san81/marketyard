<%@ page language="java" contentType="text/html;charset=UTF-8"
	errorPage="/error.jsp" buffer="20kb"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<html:html locale="true">
<head>
	
	<tiles:useAttribute name="componentTitle" />
	<tiles:useAttribute name="sectionTitle" />
	<title><bean:message key="label.myGenSource" />&nbsp;&gt;&nbsp;
		<bean:message name="componentTitle" />&nbsp;&gt;&nbsp; <bean:message
			name="sectionTitle" /></title>
	<link href="css_new/mgs.css" rel="stylesheet" type="text/css">
	<script language="JavaScript"
		src="<%=request.getContextPath()%>/javascript/MgsDivLayer.js"></script>
	<script language="JavaScript"
		src="<%=request.getContextPath()%>/javascript/popup.js"></script>
	<script language="JavaScript"
		src="<%=request.getContextPath()%>/jslib/extjs/scripts/ext-base.js"></script>
	<script language="JavaScript"
		src="<%=request.getContextPath()%>/jslib/extjs/scripts/ext-all.js"></script>
	<script language="JavaScript"
		src="<%=request.getContextPath()%>/javascript/util.js"></script>
	<script language="JavaScript"
		src="<%=request.getContextPath()%>/javascript/extAjaxCall.js"></script>
</head>
<body>
	<div id="container">
		<tiles:insert attribute="banner" />
		<div id="navigation"></div>
		<!-- Start main content -->
		<div id="contentwrapper">
			<div id="content_1column">
				<jsp:include page="/includes/userAlerts/progressBox.jsp" />
				<script language="JavaScript">
				writeToElement('progress_msg',"<bean:message key='string.loadingInProgress'/>...");
				toggleProgressBox('show');
				</script>
				<tiles:insert attribute="body" />
				<script language="JavaScript">
				toggleProgressBox('hide');
				</script>
			</div>
		</div>
		<!-- End main content -->
		<tiles:insert attribute="footer" />
	</div>
</body>
</html:html>