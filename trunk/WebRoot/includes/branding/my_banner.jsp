
<jsp:directive.page import="com.san.my.common.global.SessionVars"/>
<jsp:directive.page import="java.util.Calendar"/>
<jsp:directive.page import="java.text.SimpleDateFormat"/>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Start banner content -->
<div id='banner'>
	<div id="headerLogo">
		<a href="" target="_blank"> <s:label key="label.marketYard" /> </a>
	</div>
	<div id="top_menu" align="right" style="color:#FF6600;font-weight: bold;">
		<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); %>
		<%=sdf.format(Calendar.getInstance().getTime()) %>
	</div>
	<div id="top_menu" align="right">
		<a href="">
			<s:label key="label.contact" />
		</a> |
		<a href="">
			<s:label key="label.support" />
		</a>
		<ul>
				<li class="Welcome">${session.user_role}</li>
		</ul>
	</div>
</div>
<!-- End banner content -->
<div style="clear: both;"></div>