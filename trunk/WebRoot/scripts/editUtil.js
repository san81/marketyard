<!--
 
  function setEditableStyles(checkBoxCtrl){
  	var colorToSet="white";  
  	var displayToSet='';	
  	
  	if(checkBoxCtrl.checked){
  		colorToSet="yellow";
  		displayToSet='none';  		
  	}
  	
  	var ratesDiv=document.getElementById('hamaliRateDiv');
  		ratesDiv.style.display=displayToSet;
  		ratesDiv=document.getElementById('ccRateDiv');
  		ratesDiv.style.display=displayToSet;
  		ratesDiv=document.getElementById('mfRateDiv');
  		ratesDiv.style.display=displayToSet;
	
	var divCtrl=document.getElementById('hamaliDiv');  
	divCtrl.style.backgroundColor=colorToSet;
	divCtrl=document.getElementById('ccDiv');
	divCtrl.style.backgroundColor=colorToSet;
	divCtrl=document.getElementById('mfDiv');
	divCtrl.style.backgroundColor=colorToSet;
	
  }
  
 var currentEditingDiv; 
  function makeEditable(divCtrl){
  	if(!document.conformSlipSubmit.doNotCalculate.checked)
  		return;
  	currentEditingDiv=divCtrl;
  	divCtrl.onclick='';
  	var eTextBox="<input type='text' name='editingBox' size='6' value='"+divCtrl.innerHTML+"' ";
  	eTextBox+="onblur='resetEditedVal(this)' ";
  	eTextBox+="/>";
  	divCtrl.innerHTML=eTextBox;
  	document.conformSlipSubmit.editingBox.focus();
  		
  }
  
 function resetEditedVal(editingBoxCtrl){
 	if(isNaN(editingBoxCtrl.value)) alert('not a number');
	var editedVal=parseFloat(editingBoxCtrl.value);
 	//set value to hidden variable
 	var pform=document.conformSlipSubmit; 	
 	if(currentEditingDiv.id=='hamaliDiv')
 		pform.totalHamali.value=editedVal; 		
 	else if(currentEditingDiv.id=='ccDiv')
 		pform.totalCc.value=editedVal;
 	else if(currentEditingDiv.id=='mfDiv')
 		pform.totalMf.value=editedVal;
 	
 	makeSlip(pform);
 	var numNF = new NumberFormat(editingBoxCtrl.value);
    numNF.setPlaces(2);
 	currentEditingDiv.innerHTML=numNF.toFormatted();
 	currentEditingDiv.onclick=function(){makeEditable(this);};
 }
-->