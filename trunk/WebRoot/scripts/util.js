function isMaxLength(obj, mLength) {
	if (obj.getAttribute && obj.value.length > mLength) {
		obj.value = obj.value.substring(0, mLength);
	}
}
function charactersRemaining(_element, _maxCharacters) {
	var text = "";
	var string = _element.value;
	var charactersLeftInTextArea = _maxCharacters - string.length;
	if (charactersLeftInTextArea < 0) {
		_element.value = string.substring(0, _maxCharacters);
		text = 0;
	} else {
		var text = charactersLeftInTextArea;
	}
	writeToElement("charRemaining", text, false);
}
function clearFields() {
	var formInputs = document.getElementsByTagName("input");
	for (var i = 0; i < formInputs.length; i++) {
		var theInput = formInputs[i];
		if (theInput.type == "text") {
			theInput.value = "";
		}
	}
}
function clearSelectBoxes() {
	var formInputs = document.getElementsByTagName("select");
	for (var i = 0; i < formInputs.length; i++) {
		var theInput = formInputs[i];
		theInput.value = "";
	}
}
function submitSearchForm() {
	document.searchForm.submit();
	return true;
}
function writeToElement(_elementId, _value) {
	var dbgObj = document.getElementById(_elementId);
	dbgObj.innerHTML = _value;
}
function toggleProgressBox(state) {
	var msg = document.getElementById("progressInfo");
	if (state == "hide") {
		hideMe("progressInfo");
		msg.style.display = "none";
	} else {
		showMe("progressInfo");
		msg.style.display = "";
	}
}
function toggleProgressBoxSmall(state) {
	var elmId ='progressCirSmall';
	if (state == "hide") {
		hideElm(elmId);
	} else {
		showElm(elmId);
	}
}
function getElm(elmId){
    var elem;
    if (document.getElementById) // this is the way the standards work
        elem = document.getElementById(elmId);
    else if (document.all) // this is the way old msie versions work
        elem = document.all[elmId];
    else if (document.layers) // this is the way nn4 works
        elem = document.layers[elmId];
    return elem;
}
function hideElm(elmId){
	var elm = getElm(elmId);
    if (elm != null && elm != 'undefined'){
    	elm.style.display = 'none';
    }
}

function showElm(elmId){
	var elm = getElm(elmId);
    if (elm != null && elm != 'undefined'){
    	elm.style.display = '';
    }
}
function onYes(id) {

	if(id == 'confMsgBox' || id == 'customMsgBox'){
		hideMsgBox(id)
	}else{
		hideElm(id);
	}
	if (typeof processYes == "function") {
		processYes();
	}
}
function onNo(id) {
	if(id == 'confMsgBox' || id == 'customMsgBox'){
		hideMsgBox(id)
	}else{
		hideElm(id);
	}
	if (typeof processNo == "function") {
		processNo();
	}
}


/*
*	Utility method to construct the request query string from 
*   the form elements.
*/
function getRequestBody(oForm) {

    var aParams = new Array();
    for (var i = 0; i < oForm.elements.length; i++) {
        var sParam = encodeURIComponent(oForm.elements[i].name);
        sParam += "=";
        if(oForm.elements[i].type == 'checkbox')
	        sParam += encodeURIComponent(oForm.elements[i].checked);
        else
    	    sParam += encodeURIComponent(oForm.elements[i].value);
        aParams.push(sParam);
    }
    aParams.push(sParam);
    return aParams.join("&");
}
