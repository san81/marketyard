 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="s" uri="/struts-tags" %>
<s:head theme="ajax" />
<%--<s:fielderror></s:fielderror>--%>
<%--<s:actionerror/>--%>


<s:form action="loadSlip_cancel.action" namespace="admin" method="post" name="loadSlip">
	<tr>
		<td colspan=2>
			<span  class="subHead">
				<s:text name="label.viewSlip"></s:text>
			</span>
		<hr></td>
	  </tr>
	  <tr>
		<td colspan=2>
			<span  class="subHead">
				<s:actionmessage/>
			</span>
			<br>
		</td>
	  </tr>
	  
<s:textfield key="label.slip.id" name="slipId" required="true"></s:textfield></td>
<s:submit key="label.submit" ></s:submit>			

</s:form>
