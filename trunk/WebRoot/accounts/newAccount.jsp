<%@ taglib prefix="s" uri="/struts-tags"%>

<s:actionerror/>
<s:actionmessage/>
<s:fielderror />

<s:form action="saveAccount" method="POST" >
<s:head theme="ajax" />
<s:url id="jsonList" value="json/accountTypesList.action"/>

	<table>
		<tr>
			<td colspan="3">
				<s:label key="label.account.createTitle" />				
				<s:fielderror />
			</td>
		</tr>
		<tr>
			<td>
				<s:textfield name="loginName" key="label.account.loginName" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="name" key="label.account.name" />
			</td>
		</tr>
		
		<tr>
			<td> Account Type  :</td>
					<td>
							<s:autocompleter name="accountType" theme="ajax" indicator="indicator" href="%{jsonList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring"/>
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
							

					</td>
		</tr>
		
		<tr>

			<td>
				<s:textfield name="mobile" key="label.account.mobile" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="address" key="label.account.address" />
			</td>
		</tr>
		<tr>

			<td>
				<s:textfield name="village" key="label.account.village" />
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<s:submit></s:submit>
			</td>
		</tr>
	</table>
</s:form>
