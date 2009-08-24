 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="s" uri="/struts-tags" %>

<%--<s:fielderror></s:fielderror>--%>

<%--<s:form action="conformSlipSubmit" namespace="admin" method="post" tooltipConfig="%{'jsTooltipEnabled':'true'}" name="slipSubmit" validate="true">--%>
<s:form action="conformSlipSubmit" method="POST">
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



<table width=100% border=0>
	  <tr>
		<td colspan=3>
			<span  class="subHead">
				<s:text name="label.purchaseDetails"></s:text>
			</span>
		<hr></td>
	  </tr>	
	  <tr>
		<td>
			<table border=0>
				 
								<s:datetimepicker value="today"
						             label="purchase date"
						             name="purchaseDate" required="true"/>
						
				<tr>
					<td align="right"> <s:text name="seeds"></s:text><span class="required">*</span>:</td>
					<td>
							<s:autocompleter name="seed" theme="ajax" indicator="indicator" href="%{jsonList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring"/>
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
							

					</td>
				</tr>
				
		         <s:textfield name="bagwt" key="label.slip.bagWeight" onchange="makeSlip(document.conformSlipSubmit)" required="true"> </s:textfield>
        		 <s:textfield name="bags" key="label.slip.bags" onchange="makeSlip(document.conformSlipSubmit)" required="true"></s:textfield> &nbsp;&nbsp; <s:textfield name="smallBag" key="label.slip.kgs" onchange="makeSlip(document.conformSlipSubmit)" required="true"> </s:textfield>
				 <s:textfield name="cost" key="label.slip.costperQtl" onchange="makeSlip(document.conformSlipSubmit)" required="true"></s:textfield>
				
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>				
				<tr>
					<td> <lable class="lable" for="qtyls"><s:text name="label.slip.qtls"></s:text></lable> </td> <td>:</td>
					<td> <div id="qtlsDiv" class="derivedInfo">00-00</div> </td>
				</tr>	
				<tr>
					<td> <s:text name="label.slip.grossTotal"></s:text> </td> <td>:</td>
					<td> <div id="grossTotalDiv" class="grandTotal">00.00</div> </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.hamali"></s:text> </td> <td>:</td>
					<td> <span id="hamaliDiv" class="expensesColor">00.00</span> &nbsp;at ${hamaliRate} per bag</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.cc"></s:text> </td> <td>:</td>
					<td> <span id="ccDiv" class="expensesColor">00.00</span> &nbsp;at ${cashCommissionRate}%  </td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.mf"></s:text> </td> <td>:</td>
					<td> <span id="mfDiv" class="expensesColor">00.00</span> &nbsp;at ${adthiRate}%</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.netTotal"></s:text> </td> <td>:</td>
					<td> <div id="netTotalDiv" class="grandTotal">00.00</div> </td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan=3><br>
			<span  class="subHead">
				<s:text name="label.buyerSupplierDetails"></s:text>
			</span>
			<hr>
		</td>
	</tr>
	<tr>
		<td valign="top">
			<table>
				<tr>
					<td colspan=3 align="center" style="font-weight:bold"><s:text name="label.slip.purchaseParty"></s:text></td>
				</tr>
				<tr>
					<td align="right"> <s:text name="label.slip.buyer"></s:text><span class="required">*</span>:</td>
					<td colspan="2">
							<s:autocompleter name="buyerAccountId" theme="ajax" indicator="indicator" href="%{buyerAccountsList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring" />
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
					</td>
				</tr>
				<tr>
					<td><s:text name="label.slip.status"></s:text><span class="required">*</span> </td>
					<td>:</td>
					<td><select name="status" onchange="setPaymentDetailsDiv(this)">
							<option value="PENDING">PENDING</option>
							<option value="PARTIAL">PARTIAL</option>							
							<option value="PAID">PAID</option>							
						</select>
					</td>
				</tr>
			</table>
		</td>
		<td>
			
		</td>
		<td>
			<table>
				<tr>
					<td colspan=3 align="center" style="font-weight:bold"><s:text name="label.slip.farmarDetails"></s:text> </td>
				</tr>				
				<tr>
					<td><s:textfield key="label.slip.city" name="supplierCity" required="true"></s:textfield></td>
				</tr>
				<tr>
					<td align="right"> <s:text name="label.slip.supplier"></s:text><span class="required">*</span>:</td>
					<td colspan="2">
							<s:autocompleter name="supplier" theme="ajax" indicator="indicator" href="%{buyerAccountsList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring" />
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
					</td>
				</tr>
				<tr>
					<td><s:textarea key="label.slip.description" name="description" required="true" cols="15" ></s:textarea></td>
				</tr>
			</table>
		</td>
	</tr>	
	<tr>
		<td colspan="3">
			<div id="paymentDetailsInputDiv" style="display: none">
				<table border=0 width="100%">
					<tr>
						<td colspan=6>
							<span class="subHead"> 
								<s:text name="label.slip.paymentDetails"></s:text>
							</span>
							<hr>
						</td>
					</tr>				
					<tr>
							<td><s:text name="label.slip.paymentMode"></s:text><span class="required">*</span>:
								<select name="paymentMode" onchange="setBankDetailsDiv(this)">
									<option value="CASH" selected>CASH</option>
									<option value="CHECK">CHECK</option>
								</select>
							</td>
							<td>
								<s:text name="label.amount"></s:text><span class="required">*</span>:
								<input type="text" name="paymentAmount" class="grandTotal">
							</td>							
					</tr>
					<tr>
						<td colspan="2">
							<div id="bankDetailsDiv" style="display: none">
							  <table>
							  	<s:textfield key="label.bankName" name="bankName" required="true"></s:textfield>
							  	<s:textfield key="label.checkNumber" name="checkNumber" required="true"></s:textfield>
							  	<s:textfield key="label.branchName" name="branchName" required="true"></s:textfield>							  										
								</table>		
							</div>
						</td>
					</tr>										
			     </table>
		   </div>
	    </td>	   
	</tr>	
	<tr>
		<td colspan=3 align="center"> 
		<br/><br/>
		</td>
	</tr>
	<tr>
		<td colspan=3 align=center> 
			<s:submit key="label.submit" ></s:submit>			
		</td>
	</tr>
	<tr>
		<td colspan=3 align="center"> 
		<br/><br/>
		</td>
	</tr>
</table>
</s:form>
<script>
	makeSlip(document.conformSlipSubmit);
</script>
