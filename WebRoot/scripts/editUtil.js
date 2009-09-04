<!--
 
  function setEditableStyles(checkBoxCtrl){
  	var colorToSet="white";  	
  	
  	if(checkBoxCtrl.checked)
  		colorToSet="yellow";
	
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
  	currentEditingDiv=divCtrl;alert(currentEditingDiv.id);
  	divCtrl.onclick='';
  	var eTextBox="<input type='text' name='editingBox' size='6' value='"+divCtrl.innerHTML+"' ";
  	eTextBox+="onblur='resetEditedVal(this)' ";
  	eTextBox+="/>";
  	divCtrl.innerHTML=eTextBox;
  	//document.conformSlipSubmit.editingBox.setFocus();
  		
  }
  
 function resetEditedVal(editingBoxCtrl){alert(currentEditingDiv.id);alert(this);
 	if(isNaN(editingBoxCtrl.value)) alert('not a number');
 	currentEditingDiv.innerHTML=editingBoxCtrl.value;
 	//set value to hidden variable
 	var pform=document.conformSlipSubmit; 	
 	if(currentEditingDiv.id=='hamaliDiv')
 		pform.totalHamali.value=editingBoxCtrl.value;
 	else if(currentEditingDiv.id=='ccDiv')
 		pform.totalCc.value=editingBoxCtrl.value;
 	else if(currentEditingDiv.id=='mfDiv')
 		pform.totalMf.value=editingBoxCtrl.value;
 		
 	currentEditingDiv.onclick=function(){makeEditable(this);};
 }
-->