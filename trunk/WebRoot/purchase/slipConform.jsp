 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="s" uri="/struts-tags" %>



<s:form action="backSlipSubmit.action" namespace="admin" method="post" tooltipConfig="%{'jsTooltipEnabled':'true'}" name="slipSubmit">
<s:head theme="ajax" />
<s:url id="jsonList" value="../json/seedsList.action"/>
<s:url id="buyerAccountsList" value="../json/accountIdsAndNamesList.action"/>

<%---- values from config --%>
<s:hidden name="cashCommissionRate"></s:hidden>
<s:hidden name="adthiRate"></s:hidden>
<s:hidden name="hamaliRate"></s:hidden>
<%--values from config--%>
<%--derived values --%>
<s:hidden name="qtls"></s:hidden>
<s:hidden name="grossTotal"></s:hidden>
<s:hidden name="totalHamali"></s:hidden>
<s:hidden name="totalCc"></s:hidden>
<s:hidden name="totalMf"></s:hidden>
<s:hidden name="netTotal"></s:hidden>
<%--derived values --%>
<s:hidden name="purchaseDate"></s:hidden>
<s:hidden name="seed"></s:hidden>
<s:hidden name="seedKey"></s:hidden>
<s:hidden name="bagwt"></s:hidden>
<s:hidden name="bags"></s:hidden>
<s:hidden name="smallBag"></s:hidden>
<s:hidden name="cost"></s:hidden>

<s:hidden name="buyerAccountId"></s:hidden>
<s:hidden name="buyerAccountIdKey"></s:hidden>
<s:hidden name="status"></s:hidden>

<s:hidden name="supplier"></s:hidden>
<s:hidden name="supplierKey"></s:hidden>
<s:hidden name="supplierCity"></s:hidden>
<s:hidden name="description"></s:hidden>

<s:hidden name="paymentMode"></s:hidden>
<s:hidden name="bankName"></s:hidden>
<s:hidden name="branchName"></s:hidden>
<s:hidden name="checkNumber"></s:hidden>
<s:hidden name="paymentAmount"></s:hidden>

	
<table width=100% border="0">
	<tr><td>
			<table border=0>
				<tr>
					<td>
						SLIP ID...
					</td>
				</tr>
				<tr>
						<td colspan=2> 
								<s:label key="purchaseDate"></s:label>
						 </td>
				</tr>
				<tr>
					<td>
							<s:label key="seed"></s:label>

					</td>
				</tr>
				<tr>
					<td> <s:label key="bagwt"> </s:label> </td>
				</tr>
				<tr>
					<td> <s:label key="bags"></s:label>  &nbsp;&nbsp; <s:label key="smallBag"></s:label> </td>
				</tr>
				<tr>
					<td> <s:label key="cost"></s:label> </td>
				</tr>								
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>				
				<tr>
					<td> <s:label key="qtls" ></s:label> </td> 
				</tr>	
				<tr>
					<td> <s:label key="grossTotal" cssClass="grandTotal"></s:label> </td> 					
				</tr>
				<tr>
					<td> <s:label key="totalHamali" cssClass="expensesColor"></s:label> 
					&nbsp;at ${hamaliRate} per bag</td>
				</tr>
				<tr>
					<td> <s:label key="totalCc" cssClass="expensesColor"></s:label> 
						&nbsp;at ${cashCommissionRate}% 
					</td>
				</tr>
				<tr>
					<td> <s:label key="totalMf" cssClass="expensesColor"></s:label> 
					&nbsp;at ${adthiRate}%</td>
				</tr>
				<tr>
					<td> <s:label key="netTotal" cssClass="grandTotal"></s:label></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan=3><hr></td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td colspan=3><s:text name="label.slip.purchaseParty"></s:text></td>
				</tr>
				<tr>
					<td> <s:label key="buyerAccountId"></s:label>					
				</tr>				
				<tr>
					<td> <s:label key="status"></s:label>					
				</tr>
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>
				<tr>
					<td colspan=3><s:text name="label.slip.farmarDetails"></s:text> </td>
				</tr>
				<tr>
					<td><s:label key="supplier"></s:label></td>
				</tr>
				<tr>
					<td><s:label key="supplierCity"></s:label></td>									
				</tr>
				<tr>
					<td><s:label key="description"></s:label></td>					
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan=3 align=center> <hr>
		</td>
	</tr>
	<tr>
		<td>
			<table border=0>
				<tr>
					<td colspan=3><s:text name="label.slip.paymentDetails"></s:text> </td>
				</tr>
				<tr>
						<td><s:label key="paymentMode"></s:label>
						</td>
				</tr>
				<s:label key="paymentAmount" ></s:label>
				<s:label key="checkNumber" ></s:label>				
			</table>
		</td>
	    <td>
	    </td>
	    <td>
	       <table>
	       		<tr>
	       			<td><br><br></td>
	       		</tr>
		    	<s:label key="bankName"></s:label>
				<s:label key="branchName"></s:label>				
			</table>
	    </td>
	</tr>
	<tr>
		<td colspan=3 align="center"> 
		<br/><br/>
		</td>
	</tr>
	<tr>
	<s:if test="action=='confirm'" >
		<td colspan=3 align="center">
			<input type="submit" value="Edit Slip" />
				&nbsp; &nbsp;
			<input type="button" value="Save" onClick="document.slipSubmit.action='saveSlip.action';document.slipSubmit.submit();"/>
		</td>
	</s:if>
	<s:elseif test="action=='save'">
		<td colspan=3 align="center">
			<input type="button" value="Print" />
				&nbsp; &nbsp;
			<input type="button" value="Make Another Purchase"/>
		</td>
	</s:elseif>
	<s:elseif test="action=='load'">
		<td colspan=3 align="center">
			<input type="submit" value="Edit Slip" />
				&nbsp; &nbsp;
			<input type="button" value="Print"/>
		</td>
	</s:elseif>		
	</tr>
	
</table>
</s:form>