/**
	This function is used for number formatting any given number to user's locale format.
	This function depends on two global vlaues.<b> 
	var groupSeparator = ",";
	var decimalSeparator = ".";	
*/
function NumberFormat(num, inputDecimal)
{
	this.COMMA = ',';
	this.PERIOD = '.';
	this.DASH = '-'; 
	this.LEFT_PAREN = '('; 
	this.RIGHT_PAREN = ')'; 
	this.LEFT_OUTSIDE = 0; 
	this.LEFT_INSIDE = 1;  
	this.RIGHT_INSIDE = 2;  
	this.RIGHT_OUTSIDE = 3;  
	this.LEFT_DASH = 0; 
	this.RIGHT_DASH = 1; 
	this.PARENTHESIS = 2; 
	this.NO_ROUNDING = -1 
	this.num;
	this.numOriginal;
	this.hasSeparators = false;  
	this.separatorValue; 
	this.decimalValue; 
	this.inputDecimalValue;
	this.negativeFormat; 
	this.negativeRed; 
	this.hasCurrency;  
	this.currencyPosition;  
	this.currencyValue;  
	this.places;
	this.roundToPlaces; 
	this.truncate;
	this.isPercentage = false;
	this.setNumber = setNumberNF;
	this.toUnformatted = toUnformattedNF;
	this.setInputDecimal = setInputDecimalNF; 
	this.setSeparators = setSeparatorsNF; 
	this.setCommas = setCommasNF;
	this.setNegativeFormat = setNegativeFormatNF; 
	this.setNegativeRed = setNegativeRedNF; 
	this.setCurrency = setCurrencyNF;
	this.setCurrencyPrefix = setCurrencyPrefixNF;
	this.setCurrencyValue = setCurrencyValueNF; 
	this.setCurrencyPosition = setCurrencyPositionNF; 
	this.setPlaces = setPlacesNF;
	this.toFormatted = toFormattedNF;
	this.toPercentage = toPercentageNF;
	this.getOriginal = getOriginalNF;
	this.moveDecimalRight = moveDecimalRightNF;
	this.moveDecimalLeft = moveDecimalLeftNF;
	this.getRounded = getRoundedNF;
	this.preserveZeros = preserveZerosNF;
	this.justNumber = justNumberNF;
	this.expandExponential = expandExponentialNF;
	this.getZeros = getZerosNF;
	this.moveDecimalAsString = moveDecimalAsStringNF;
	this.moveDecimal = moveDecimalNF;
	this.addSeparators = addSeparatorsNF;
	this.validateNumber = validateNumberNF;		
	if (inputDecimal == null) {
	this.setNumber(num, this.PERIOD);
	} else {
	this.setNumber(num, inputDecimal); 
	}
	//this.setCommas(true);
	// groupSeparator & decimalSeparator values are set in my_banner.jsp page.
	this.setSeparators(true, groupSeparator, decimalSeparator);	

	this.setNegativeFormat(this.LEFT_DASH); 
	this.setNegativeRed(false); 
	this.setCurrency(false); 
	this.setCurrencyPrefix('$');
	this.setPlaces(2);
}
function setInputDecimalNF(val)
{
	this.inputDecimalValue = val;
}
function setNumberNF(num, inputDecimal)
{
	if (inputDecimal != null) {
	this.setInputDecimal(inputDecimal); 
	}
	this.numOriginal = num;
	this.num = this.justNumber(num);
}
function toUnformattedNF()
{
	if(this.isPercentage)
		return (this.num + '%');
	else
		return (this.num);
}
function getOriginalNF()
{
	return (this.numOriginal);
}
function setNegativeFormatNF(format)
{
	this.negativeFormat = format;
}
function setNegativeRedNF(isRed)
{
	this.negativeRed = isRed;
}
function setSeparatorsNF(isC, separator, decimal)
{
	this.hasSeparators = isC;
	if (separator == null) separator = this.COMMA;
	if (decimal == null) decimal = this.PERIOD;
	if (separator == decimal) {
	this.decimalValue = (decimal == this.PERIOD) ? this.COMMA : this.PERIOD;
	} else {
	this.decimalValue = decimal;
	}
	this.separatorValue = separator;
}
function setCommasNF(isC)
{
	this.setSeparators(isC, this.COMMA, this.PERIOD);
}
function setCurrencyNF(isC)
{
	this.hasCurrency = isC;
}
function setCurrencyValueNF(val)
{
	this.currencyValue = val;
}
function setCurrencyPrefixNF(cp)
{
	this.setCurrencyValue(cp);
	this.setCurrencyPosition(this.LEFT_OUTSIDE);
}
function setCurrencyPositionNF(cp)
{
	this.currencyPosition = cp
}
function setPlacesNF(p, tr)
{
	this.roundToPlaces = !(p == this.NO_ROUNDING); 
	this.truncate = (tr != null && tr); 
	this.places = (p < 0) ? 0 : p; 
}
function addSeparatorsNF(nStr, inD, outD, sep)
{
	nStr += '';
	var dpos = nStr.indexOf(inD);
	var nStrEnd = '';
	if (dpos != -1) {
	nStrEnd = outD + nStr.substring(dpos + 1, nStr.length);
	nStr = nStr.substring(0, dpos);
	}
	var rgx = /(\d+)(\d{3})/;
	while (rgx.test(nStr)) {
	nStr = nStr.replace(rgx, '$1' + sep + '$2');
	}

	return nStr + nStrEnd;
}
function toFormattedNF()
{	
	var pos;
	var nNum = this.num; 
	var nStr;            
	var splitString = new Array(2);   
	if (this.roundToPlaces) {
	nNum = this.getRounded(nNum);
	nStr = this.preserveZeros(Math.abs(nNum)); 
	} else {
	nStr = this.expandExponential(Math.abs(nNum)); 
	}
	if (this.hasSeparators) { 

	nStr = this.addSeparators(nStr, this.PERIOD, this.decimalValue, this.separatorValue);
	} else {
	nStr = nStr.replace(new RegExp('\\' + this.PERIOD), this.decimalValue); 
	}
	var c0 = '';
	var n0 = '';
	var c1 = '';
	var n1 = '';
	var n2 = '';
	var c2 = '';
	var n3 = '';
	var c3 = '';
	var negSignL = (this.negativeFormat == this.PARENTHESIS) ? this.LEFT_PAREN : this.DASH;
	var negSignR = (this.negativeFormat == this.PARENTHESIS) ? this.RIGHT_PAREN : this.DASH;
	if (this.currencyPosition == this.LEFT_OUTSIDE) {
	if (nNum < 0) {
	if (this.negativeFormat == this.LEFT_DASH || this.negativeFormat == this.PARENTHESIS) n1 = negSignL;
	if (this.negativeFormat == this.RIGHT_DASH || this.negativeFormat == this.PARENTHESIS) n2 = negSignR;
	}
	if (this.hasCurrency) c0 = this.currencyValue;
	} else if (this.currencyPosition == this.LEFT_INSIDE) {
	if (nNum < 0) {
	if (this.negativeFormat == this.LEFT_DASH || this.negativeFormat == this.PARENTHESIS) n0 = negSignL;
	if (this.negativeFormat == this.RIGHT_DASH || this.negativeFormat == this.PARENTHESIS) n3 = negSignR;
	}
	if (this.hasCurrency) c1 = this.currencyValue;
	}
	else if (this.currencyPosition == this.RIGHT_INSIDE) {
	if (nNum < 0) {
	if (this.negativeFormat == this.LEFT_DASH || this.negativeFormat == this.PARENTHESIS) n0 = negSignL;
	if (this.negativeFormat == this.RIGHT_DASH || this.negativeFormat == this.PARENTHESIS) n3 = negSignR;
	}
	if (this.hasCurrency) c2 = this.currencyValue;
	}
	else if (this.currencyPosition == this.RIGHT_OUTSIDE) {
	if (nNum < 0) {
	if (this.negativeFormat == this.LEFT_DASH || this.negativeFormat == this.PARENTHESIS) n1 = negSignL;
	if (this.negativeFormat == this.RIGHT_DASH || this.negativeFormat == this.PARENTHESIS) n2 = negSignR;
	}
	if (this.hasCurrency) c3 = this.currencyValue;
	}
	nStr = c0 + n0 + c1 + n1 + nStr + n2 + c2 + n3 + c3;
	if (this.negativeRed && nNum < 0) {
	nStr = '<font color="red">' + nStr + '</font>';
	}
	if(this.isPercentage)
		return (nStr + '%');
	else
		return (nStr);
}
function toPercentageNF()
{
	nNum = this.num * 100;
	nNum = this.getRounded(nNum);
	return nNum + '%';
}
function getZerosNF(places)
{
	var extraZ = '';
	var i;
	for (i=0; i<places; i++) {
	extraZ += '0';
	}
	return extraZ;
}
function expandExponentialNF(origVal)
{
	if (isNaN(origVal)) return origVal;
	var newVal = parseFloat(origVal) + ''; 
	var eLoc = newVal.toLowerCase().indexOf('e');
	if (eLoc != -1) {
	var plusLoc = newVal.toLowerCase().indexOf('+');
	var negLoc = newVal.toLowerCase().indexOf('-', eLoc); 
	var justNumber = newVal.substring(0, eLoc);
	if (negLoc != -1) {
	var places = newVal.substring(negLoc + 1, newVal.length);
	justNumber = this.moveDecimalAsString(justNumber, true, parseInt(places));
	} else {
	if (plusLoc == -1) plusLoc = eLoc;
	var places = newVal.substring(plusLoc + 1, newVal.length);
	justNumber = this.moveDecimalAsString(justNumber, false, parseInt(places));
	}
	newVal = justNumber;
	}
	return newVal;
} 
function moveDecimalRightNF(val, places)
{
	var newVal = '';
	if (places == null) {
	newVal = this.moveDecimal(val, false);
	} else {
	newVal = this.moveDecimal(val, false, places);
	}
	return newVal;
}
function moveDecimalLeftNF(val, places)
{
	var newVal = '';
	if (places == null) {
	newVal = this.moveDecimal(val, true);
	} else {
	newVal = this.moveDecimal(val, true, places);
	}
	return newVal;
}
function moveDecimalAsStringNF(val, left, places)
{
	var spaces = (arguments.length < 3) ? this.places : places;
	if (spaces <= 0) return val; 
	var newVal = val + '';
	var extraZ = this.getZeros(spaces);
	var re1 = new RegExp('([0-9.]+)');
	if (left) {
	newVal = newVal.replace(re1, extraZ + '$1');
	var re2 = new RegExp('(-?)([0-9]*)([0-9]{' + spaces + '})(\\.?)');		
	newVal = newVal.replace(re2, '$1$2.$3');
	} else {
	var reArray = re1.exec(newVal); 
	if (reArray != null) {
	newVal = newVal.substring(0,reArray.index) + reArray[1] + extraZ + newVal.substring(reArray.index + reArray[0].length); 
	}
	var re2 = new RegExp('(-?)([0-9]*)(\\.?)([0-9]{' + spaces + '})');
	newVal = newVal.replace(re2, '$1$2$4.');
	}
	newVal = newVal.replace(/\.$/, ''); 
	return newVal;
}
function moveDecimalNF(val, left, places)
{
	var newVal = '';
	if (places == null) {
	newVal = this.moveDecimalAsString(val, left);
	} else {
	newVal = this.moveDecimalAsString(val, left, places);
	}
	return parseFloat(newVal);
}
function getRoundedNF(val)
{
	val = this.moveDecimalRight(val);
	if (this.truncate) {
	val = val >= 0 ? Math.floor(val) : Math.ceil(val); 
	} else {
	val = Math.round(val);
	}
	val = this.moveDecimalLeft(val);
	return val;
}
function preserveZerosNF(val)
{
	var i;
	val = this.expandExponential(val);
	if (this.places <= 0) return val; 
	var decimalPos = val.indexOf('.');
	if (decimalPos == -1) {
	val += '.';
	for (i=0; i<this.places; i++) {
	val += '0';
	}
	} else {
	var actualDecimals = (val.length - 1) - decimalPos;
	var difference = this.places - actualDecimals;
	for (i=0; i<difference; i++) {
	val += '0';
	}
	}
	return val;
}
function justNumberNF(val)
{
	var newVal = val + '';
	//var isPercentage = false;
	if (newVal.indexOf('%') != -1) {
	newVal = newVal.replace(/\%/g, '');
	this.isPercentage = true; 
	}
	var re = new RegExp('[^\\' + this.inputDecimalValue + '\\d\\-\\+\\(\\)eE]', 'g');
	newVal = newVal.replace(re, '');
	var tempRe = new RegExp('[' + this.inputDecimalValue + ']', 'g');
	var treArray = tempRe.exec(newVal); 
	if (treArray != null) {
	var tempRight = newVal.substring(treArray.index + treArray[0].length); 
	newVal = newVal.substring(0,treArray.index) + this.PERIOD + tempRight.replace(tempRe, ''); 
	}
	if (newVal.charAt(newVal.length - 1) == this.DASH ) {
	newVal = newVal.substring(0, newVal.length - 1);
	newVal = '-' + newVal;
	}
	else if (newVal.charAt(0) == this.LEFT_PAREN
	&& newVal.charAt(newVal.length - 1) == this.RIGHT_PAREN) {
	newVal = newVal.substring(1, newVal.length - 1);
	newVal = '-' + newVal;
	}
	newVal = parseFloat(newVal);
	if (!isFinite(newVal)) {
	newVal = 0;
	}
	/*if (isPercentage) {
	newVal = this.moveDecimalLeft(newVal, 2);	
	}*/
	return newVal+'';
}
/*
 This function validates the input user's format.
 User can enter in his locale format only. He can omit group separator. But he has to enter the decimal separator in his locale only.
 If we have to support more number formats then we have to add corresponding regular expression here.
*/
function validateNumberNF()
{
	
	var userNumRegEx;
	var code = this.separatorValue.charCodeAt(0);	
	if(/,/.test(this.separatorValue)) // Number Format : #,###.##
	{
		userNumRegEx= new RegExp('^[-+]?(\\d{1,3},?(\\d{3},?)*\\d{3}(\\.\\d*)?|\\d{1,3}(\\.\\d*)?|\\.\\d*?)[%]?$','g');
	}
	else if(/\./.test(this.separatorValue)) // Number Format : #.###,##
	{
		userNumRegEx= new RegExp('^[-+]?(\\d{1,3}\\.?(\\d{3}\\.?)*\\d{3}(,\\d*)?|\\d{1,3}(,\\d*)?|,\\d*?)[%]?$','g');
	}
	//For white space IE cannt pass this reg ex. so we are checking it by asci code.
	else if(/\s/.test(this.separatorValue) || code == 160) // Number Format : # ###,## 
	{		
		userNumRegEx= new RegExp('^[-+]?(\\d{1,3}\\s?(\\d{3}\\s?)*\\d{3}(,\\d*)?|\\d{1,3}(,\\d*)?|,\\d*?)[%]?$','g');
	}
	else // Number Format : #,###.##
	{
		
		userNumRegEx = new RegExp('^[-+]?(\\d{1,3},?(\\d{3},?)*\\d{3}(\\.\\d*)?|\\d{1,3}(\\.\\d*)?|\\.\\d*?)[%]?$','g');
	}
	
	if (userNumRegEx.test(this.numOriginal))
	{
		return true;
	}
	else
	{
		return false;
	}
}
// Added to change the decimal separator of a number from "." to user locales decimal separator. we are not using it now.
function localizeNumber(number){
	var nNum = number+'';
	if (nNum.indexOf('.') != -1) {
		nNum = nNum.replace(/\./, decimalSeparator);
	}
	return nNum;
}

