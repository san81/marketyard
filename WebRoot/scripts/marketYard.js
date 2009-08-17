<!--


function makeSlip(pform){ 
	var vbags=pform.bags.value;
	var vsmallBag=pform.smallBag.value;
	var vbagWt=pform.bagwt.value;
	var vcost=pform.cost.value;
	var hamaliRate=pform.hamaliRate.value;
	var ccRate=pform.cashCommissionRate.value;
	var mfRate=pform.adthiRate.value;
	var grandSum;
	var netSum;
	
	if(vbagWt!='' && vbags!=''){
		
		var qt=parseInt(vbagWt)*parseInt(vbags);
		
			if(vsmallBag!='')
				{
					qt+=parseInt(vsmallBag);
					vbags=parseInt(vbags)+1;
				}
		qt=qt/100;
		pform.qtls.value=qt;
		setDiv(makeQtlString(qt),"qtlsDiv");
		var hamaliVar=vbags*hamaliRate;
		pform.totalHamali.value = hamaliVar;
		setDiv(hamaliVar,"hamaliDiv");
		
		if(vcost!=''){
			grandSum=qt*vcost;
			grandSum=Math.ceil(grandSum);
			pform.grossTotal.value=grandSum;				
			setDiv(makeQtlString(grandSum),"grossTotalDiv");
			var t=parseFloat(grandSum/100);
			t=Math.ceil(t);
			var cc=t*ccRate;
			var mf=t*mfRate;
			pform.totalCc.value=cc;
			pform.totalMf.value=mf;
			setDiv(cc,"ccDiv");
			setDiv(mf,"mfDiv");
			netSum=grandSum-(hamaliVar+cc+mf);
			netSum=Math.ceil(netSum);
			pform.netTotal.value=netSum;
			setDiv(netSum,"netTotalDiv");
		}
		
	}
}
function makeQtlString(str){
			str=String(str);
			if(str.indexOf(".")==-1)
				return str+".00";
			if((str.length-(str.indexOf(".")+1))!=2)
				return str+"0";
			else
				return str;				
}
function setDiv(str,divName){
	var divCtrl=document.getElementById(divName);	
	divCtrl.innerHTML=str;
}


-->