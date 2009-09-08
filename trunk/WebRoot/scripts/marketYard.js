<!--


function makeSlip(pform){ 
	var vbags=pform.bags.value;
	var vsmallBag=pform.smallBag.value;
	var vbagWt=pform.bagwt.value;
	var vcost=pform.cost.value;
	var hamaliRate=pform.hamaliRate.value;
	var ccRate=pform.cashCommissionRate.value;
	var mfRate=pform.adthiRate.value;
	var grandSum=0;
	var netSum=0;
	var cc=parseFloat(pform.totalCc.value);
	var mf=parseFloat(pform.totalMf.value);
	var hamaliVar=parseFloat(pform.totalHamali.value);
	var doNotCalculateVar=document.conformSlipSubmit.doNotCalculate.checked;
	
	if(vbagWt!='' && vbags!=''){
		
		var qt=parseInt(vbagWt)*parseInt(vbags);
		
			if(vsmallBag!='')
				{
					var looseBagWt=parseInt(vsmallBag);
					if(looseBagWt>=parseInt(vbagWt)){
						alert('Loose Bag weight should not be more than Bag weight');
						pform.smallBag.value='0';
						pform.smallBag.focus();
						pform.smallBag.style.background='pink';
						return;	
					}					
					qt+=parseInt(vsmallBag);
					vbags=parseInt(vbags)+1;
				}
				
		qt=qt/100;
		if(!doNotCalculateVar){
			hamaliVar=vbags*hamaliRate;
			hamaliVar = roundTo(hamaliVar);
		}
		
		if(vcost!=''){
		
			grandSum=qt*vcost;			
			var t=parseFloat(grandSum/100);
			if(!doNotCalculateVar){
				if(grandSum>750){ //this needs to be configurable
					cc=t*ccRate;							
				}			
				mf=t*mfRate;
				mf = roundTo(mf);
				cc = roundTo(cc);
			}
			grandSum = roundTo(grandSum);
			
			netSum=grandSum-(hamaliVar+cc+mf);
			netSum=roundTo(netSum);	
			
			pform.grossTotal.value=grandSum;
			pform.totalCc.value=cc;	
			pform.totalMf.value=mf;		
			pform.netTotal.value=netSum;
			
			setDiv(makeFormatedString(cc),"ccDiv");
			setDiv(makeFormatedString(mf),"mfDiv");
			setDiv(makeFormatedString(grandSum),"grossTotalDiv");
			setDiv(makeFormatedString(netSum),"netTotalDiv");
		}
		
		
		pform.qtls.value=qt;
		pform.totalHamali.value = hamaliVar;
		setDiv(makeFormatedString(qt),"qtlsDiv");
		setDiv(makeFormatedString(hamaliVar),"hamaliDiv");
		
	}
}

function roundTo(value,decimalPlaces){
		var valToUse = 100;
		if(decimalPlaces) 
			valToUse=Math.pow(10,decimalPlaces);
		var roundedVar = value * valToUse;
	roundedVar=Math.round(roundedVar);
	roundedVar=roundedVar/valToUse;
	return roundedVar;

}
function makeFormatedString(str){
	
			str=String(str);
			if(str=='') return "";
			if(str.indexOf(".")==-1)
				return str+".00";
			if((str.length-(str.indexOf(".")+1))<2)
				return str+"0";
			else if((str.length-(str.indexOf(".")+1))>2)				
				return str.substr(0,str.indexOf(".")+3);			
			else
				return str;				
}
function setDiv(str,divName){
	var divCtrl=document.getElementById(divName);	
	divCtrl.innerHTML=str;
}

function setPaymentDetailsDiv(comboCtrl){

	var paymentDetailsDivCtrl = document.getElementById('paymentDetailsInputDiv');		
	if(comboCtrl.value=='PENDING')	
		paymentDetailsDivCtrl.style.display='none';
	else
		paymentDetailsDivCtrl.style.display='';
		
	if(comboCtrl.value=='PAID')
		document.conformSlipSubmit.paymentAmount.value=document.conformSlipSubmit.netTotal.value;
	else if(comboCtrl.value=='PARTIAL' && document.conformSlipSubmit.action.value == 'edit')
		document.conformSlipSubmit.paymentAmount.value=document.conformSlipSubmit.paymentAmount.value;
	else
		document.conformSlipSubmit.paymentAmount.value='';
	
}

function setBankDetailsDiv(comboCtrl){
	var bankDetailsDivCtrl = document.getElementById('bankDetailsDiv');

	if(comboCtrl.value=='CASH')
		bankDetailsDivCtrl.style.display='none';
	else
		bankDetailsDivCtrl.style.display='';
	
}

function togglePaymentsDiv(){
		var collapseDivCtrl = $('collapseDiv');
		var paymentsDivCtrl = $('paymentsDiv');
		if(collapseDivCtrl.innerHTML=='+'){
			collapseDivCtrl.innerHTML='-';			
			paymentsDivCtrl.style.display='';
		}else{
			collapseDivCtrl.innerHTML='+';
			paymentsDivCtrl.style.display='none';			
		}
	}
function togglePaymentDetailsDiv(){
	var paymentToggleCtrl = $('paymentToggle');
	var paymentsDetailsDiv = $('paymentDetailsInputDiv');
	if(paymentToggleCtrl.innerHTML=='+'){
		paymentToggleCtrl.innerHTML='-';			
		paymentsDetailsDiv.style.display='';
	}else{
		paymentToggleCtrl.innerHTML='+';
		paymentsDetailsDiv.style.display='none';			
	}
	document.getElementById('paymentDetailsTitleRow').style.display='none';
}

function checkAllBeforeSubmit(pform){
	//buyername and supplier name should not be same
	if(pform.buyerAccountId.value==pform.supplier.value){
		setErrorMsg('Buyer and Supplier should not be same');
		return false;
	}
		
	var varPaymentAmount=parseInt(pform.paymentAmount.value);
	var varNetTotal=parseInt(pform.netTotal.value);
	
	if(pform.status.value=='PAID'){
		if(varPaymentAmount!=varNetTotal){
			setErrorMsg('When slip status is paid, Amount paid must be equal to net total');
			pform.paymentAmount.value=pform.netTotal.value;
			return false;
		}
	}
	
	if(varPaymentAmount>varNetTotal){
		if(varPaymentAmount!=varNetTotal){
			setErrorMsg('You are not allowed to pay more than net total');
			pform.paymentAmount.value=pform.netTotal.value;
			return false;
		}
	}
	
	//if paymentMode is check, then bank related info is required
	if(pform.paymentMode.value=='CHECK'){
		if(pform.bankName.value=='' || pform.checkNumber.value=='' || pform.branchName.value==''){
			setErrorMsg('Check related information is required.');
			return false;
		}
	}
	makeSlip(document.conformSlipSubmit);
	return true;
}
function setErrorMsg(msg){
	var errorsDivCtrl = document.getElementById('jsErrorMsgDiv');
	errorsDivCtrl.innerHTML="<li>"+msg+"</li>";
	
}
-->