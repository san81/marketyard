<!--

	function chkUser(){
		
		var email=document.mailForm.userName.value;
		var pass=document.mailForm.passcode.value;
		var msgDiv=document.getElementById('message');
		if(email=="" || pass==""){
			msgDiv.innerHTML="<input type=hidden name=userStatus value=0><li>username/passcode required to login ";
		}else {
				msgDiv.innerHTML="Checking u r validation ..";
				var reqUrl='./phps/chkForUser.php?user='+email+'&pass='+pass;
				sendGetRequest(reqUrl,'message','takeAction()');
			}
		return false;
	}
function takeAction(){
	var status=document.mailForm.userStatus.value;
	 if(status==0)
		{
			document.mailForm.action="index.php";
			document.mailForm.submit();
		}
}

function makeLogoutCall(){
	document.mailForm.action="./phps/logout.php";
	document.mailForm.submit();
}
function makeSlip(pform){
	var vbags=pform.bags.value;
	var vsmallBag=pform.smallBag.value;
	var vbagWt=pform.bagwt.value;
	var vcost=pform.cost.value;
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
		setDiv(makeQtlString(qt),"qtlsDiv");
		var hamaliVar=vbags*3;
		setDiv(hamaliVar,"hamaliDiv");
		
		if(vcost!=''){
			grandSum=qt*vcost;	
			grandSum=Math.ceil(grandSum);
			setDiv(makeQtlString(grandSum),"grossTotalDiv");
			var t=parseFloat(grandSum/100);
			t=Math.ceil(t);
			var cc=t*2;
			var mf=t*1;
			setDiv(cc,"ccDiv");
			setDiv(mf,"mfDiv");
			netSum=grandSum-(hamaliVar+cc+mf);
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
function createCal9(){	
		var cal9 = new calendar3(document.forms['calform'].elements['input9']);
				cal9.year_scroll = true;
				cal9.time_comp = false;
}
function plProcess(){
	
	sendPostRequest('../phps/plProcess.php','purchaseSlip','document.calform','');
}

-->