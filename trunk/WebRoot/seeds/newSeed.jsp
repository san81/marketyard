<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form action="admin/saveSeed" method="POST" validate="true">
	<table>
		<tr>
			<td colspan=3 valign="top">
				<span  class="subHead">					
						<s:text name="label.seed.createTitle"></s:text>					
				</span>
				<hr>
			</td>
	   </tr>
		
		<s:textfield name="seedName" key="label.seed.seedName" />
		<s:submit></s:submit>
			
	</table>
</s:form>