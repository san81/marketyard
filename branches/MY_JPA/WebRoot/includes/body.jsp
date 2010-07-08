
<jsp:directive.page import="org.acegisecurity.Authentication"/>
<jsp:directive.page import="org.acegisecurity.context.SecurityContextHolder"/>
<jsp:directive.page import="org.acegisecurity.GrantedAuthority"/>
<%
Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
GrantedAuthority[] ga= authentication.getAuthorities();
%>

You are logged in as <strong><%=ga[0] %></strong>