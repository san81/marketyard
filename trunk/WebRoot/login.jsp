
<jsp:directive.page import="org.springframework.context.MessageSource"/>
<jsp:directive.page import="java.util.Locale"/>
<jsp:directive.page import="com.san.my.common.util.springs.ServiceLocator"/><%@ taglib prefix="s" uri="/struts-tags"%>
<form action="acegiAuthentication" method="POST">
	<table border=0>
		<tr>
			<td colspan="2">
				Login
			</td>

		</tr>

		<%
			String errorKey = request.getParameter("errorMsg");
			if (errorKey != null) {
		%>
		<tr>
			<td colspan="2">
				error msg
				<s:i18n name="errorKey"></s:i18n>
			</td>

		</tr>
		<%
		}
		%>
		
		 <%
    	// if a specific error has been passed then display that
    	MessageSource messageSource = ServiceLocator.getMessageSource();
    	String errorMessage = (String)request.getAttribute("errorMessage");
    	if(null == errorMessage)
    	{
    		errorMessage = request.getParameter("errorMessage");   
    	}
    	
        if(request.getParameter("loginfail") != null)
	    {
	           errorMessage = (String)request.getParameter("loginfail");
	    }
    %>
    <%if (errorMessage!=null){
    System.out.println("errorMessage: "+messageSource.getMessage(errorMessage,null, new Locale("EN")));%>
    <%= messageSource.getMessage(errorMessage,null, new Locale("EN"))%>
		<tr>
			<td colspan="2">
				Error Msg: 
					<s:set name="msg" value="<%errorMessage %>" scope="page"></s:set>
				   <s:text name="msg" ></s:text>					
			</td>
		</tr>
   <% } %>



		<s:textfield name="j_username" label="Login name" />
		<s:password name="j_password" label="Password" />
		<s:submit value="Login" align="center" />

	</table>
</form>

