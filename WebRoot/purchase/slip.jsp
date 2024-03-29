 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <%@ taglib prefix="s" uri="/struts-tags" %>
<script language="JavaScript" type="text/javascript" src="${pageContext.request.contextPath}/scripts/editUtil.js"></script>
<span class="errorMessage" id="jsErrorMsgDiv" style="text-align:left"></span>
<%--<s:fielderror></s:fielderror>--%>

<%--<s:form action="conformSlipSubmit" namespace="admin" method="post" tooltipConfig="%{'jsTooltipEnabled':'true'}" name="slipSubmit" validate="true">--%>
<s:form action="conformSlipSubmit" method="POST" onsubmit="return checkAllBeforeSubmit(document.conformSlipSubmit)">
<s:head theme="ajax" />
<s:url id="jsonList" value="../json/seedsList.action"/>
<s:url id="buyerAccountsList" value="../json/accountIdsAndNamesList.action"/>

<%---- values from config --%>
<s:hidden name="slipId"></s:hidden>
<s:hidden name="cashCommissionRate"></s:hidden>
<s:hidden name="adthiRate"></s:hidden>
<s:hidden name="hamaliRate"></s:hidden>
<s:hidden name="action"></s:hidden>

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
	  	<td colspan="3">
	  		<s:if test="slipId == null">
	  			<s:text name="label.create.purchaseSlip"></s:text>
	  		</s:if>
	  		<s:else>
	  			<s:text name="label.edit.purchaseSlip"><s:param >${slipId}</s:param></s:text>
	  		</s:else>
	  	</td>
	  </tr>
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
				 
<%--								<s:datetimepicker value="today"--%>
<%--						             label="purchase date"--%>
<%--						             name="purchaseDate" required="true" displayFormat="dd/MM/yyyy" staticDisplay="true" disabled="true"/>--%>
<%--						--%>
				<tr>
					<td align="right"> <s:text name="seeds"></s:text><span class="required">*</span>:</td>
					<td>
							<s:autocompleter name="seed" theme="ajax" 
								indicator="indicator" href="%{jsonList}" cssStyle="width: 200px;" 
								autoComplete="false" required="true" requiredposition="right"/>
							<img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" alt="Loading..." style="display:none"/>
							

					</td>
				</tr>
				
		         <s:textfield name="bagwt" key="label.slip.bagWeight" onchange="makeSlip(document.conformSlipSubmit)" required="true"> </s:textfield>
        		 <s:textfield name="bags" key="label.slip.bags" onchange="makeSlip(document.conformSlipSubmit)" required="true"></s:textfield>  
        		 <s:textfield name="smallBag" key="label.slip.kgs" onchange="makeSlip(document.conformSlipSubmit)" required="true" onfocus="this.style.background=''"> </s:textfield>
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
					<td colspan="3"> <input type="checkbox" name="doNotCalculate" onchange="setEditableStyles(this)"
					<s:if test="doNotCalculate=='on'">checked</s:if>/>
					:<s:text name="label.slip.doNotCalculate"></s:text> </td>					
				</tr>
				<tr>
					<td> <s:text name="label.slip.hamali"></s:text> </td> <td>:</td>
					<td> <span id="hamaliDiv" class="expensesColor" onclick="makeEditable(this)">00.00</span> 
						 &nbsp;
						 <span id="hamaliRateDiv">at ${hamaliRate} per bag</span>
					</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.cc"></s:text> </td> <td>:</td>
					<td> <span id="ccDiv" class="expensesColor"  onclick="makeEditable(this)">00.00</span> 
						 &nbsp;
						 <span id="ccRateDiv">at ${cashCommissionRate}%  </span>
					</td>
				</tr>
				<tr>
					<td> <s:text name="label.slip.mf"></s:text> </td> <td>:</td>
					<td> <span id="mfDiv" class="expensesColor"  onclick="makeEditable(this)">00.00</span> 
						&nbsp;
						<span id="mfRateDiv">at ${adthiRate}%</span>
					</td>
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
				<s:select key="label.slip.status" name="status" list="#{'PENDING':'PENDING', 'PARTIAL':'PARTIAL', 'PAID':'PAID'}" onchange="setPaymentDetailsDiv(this)" required="true"></s:select>
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
					<td align="center" colspan="3">
						<input type="button" name="pickAnonymous" onClick="setAnonymousSupplier(this)" value="<s:text name="label.slip.pickAnonymous"></s:text>"/>
					</td>					
				</tr>
				<tr>
					<td><s:textfield key="label.slip.city" name="supplierCity" required="true"></s:textfield></td>
				</tr>
				<tr>
					<td align="right"> <s:text name="label.slip.supplier"></s:text><span class="required">*</span>:</td>
					<td colspan="2">
							<s:autocompleter id="supplier" name="supplier" theme="ajax" indicator="indicator" href="%{buyerAccountsList}" cssStyle="width: 200px;" autoComplete="false" searchType="substring" />
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
				<jsp:include flush="true" page="/payments/paymentDetails.jsp"></jsp:include>
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
	setEditableStyles(document.conformSlipSubmit.doNotCalculate);
	setPaymentDetailsDiv(document.conformSlipSubmit.status);
	setBankDetailsDiv(document.conformSlipSubmit.paymentMode);
</script>
