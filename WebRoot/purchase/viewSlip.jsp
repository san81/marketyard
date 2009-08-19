 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="s" uri="/struts-tags" %>

<s:fielderror></s:fielderror>

<s:form action="loadSlip.action" namespace="admin" method="post" name="loadSlip">

<s:textfield key="label.slip.id" name="slipId" required="true"></s:textfield></td>
<s:submit key="label.submit" ></s:submit>			

</s:form>
