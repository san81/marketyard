
<!--
function showMsgBox(name) {
	// the method call below is added to move the popup with the scroll event.
	fireMyPopup(name);
	var targetDiv = document.getElementById(name);
	if (targetDiv != null) {
		targetDiv.style.display = "";
	}
	
	// blur div is added to disable all the controls behind the openedd div popup.
	if (name != "progressInfo" && name != "extProgressInfo") { //need not blur the background when progress bar is displayed
		var blurDiv = document.getElementById("blurDiv");
		if (blurDiv != null) {	
			//blurDiv.style.cssText = "position:absolute; top:0; right:0; width:" + document.body.clientWidth + "px; height:" + document.body.clientHeight + "px; background-color: #FFFFFF; opacity:0.5; filter:alpha(opacity=30)"; 
			if (parseInt(document.documentElement.clientHeight) > parseInt(document.body.clientHeight)) {
				blurDiv.style.cssText = "position:absolute; top:0; right:0; width:" + document.body.clientWidth + "px; height:" + document.documentElement.clientHeight + "px; background-color: #FFFFFF; opacity:0.5; filter:alpha(opacity=30)";
			} else {
				blurDiv.style.cssText = "position:absolute; top:0; right:0; width:" + document.body.clientWidth + "px; height:" + document.body.clientHeight + "px; background-color: #FFFFFF; opacity:0.5; filter:alpha(opacity=30)";
			}
			blurDiv.style.display = "";
		}
	}
}
function hideMe(name) {
	var targetDiv = document.getElementById(name);
	targetDiv.style.visibility = "hidden";
	showSelectBoxes();
}
function hideProgressBar(name) {
	var targetDiv = document.getElementById(name);
	targetDiv.style.visibility = "hidden";
}

// the code below is added for popup scrolling.
var divPopup;
function myPopupRelocate() {
	var scrolledX, scrolledY;
	if (self.pageYOffset) {
		scrolledX = self.pageXOffset;
		scrolledY = self.pageYOffset;
	} else {
		if (document.documentElement && document.documentElement.scrollTop) {
			scrolledX = document.documentElement.scrollLeft;
			scrolledY = document.documentElement.scrollTop;
		} else {
			if (document.body) {
				scrolledX = document.body.scrollLeft;
				scrolledY = document.body.scrollTop;
			}
		}
	}
	var centerX, centerY;
	if (self.innerHeight) {
		centerX = self.innerWidth;
		centerY = self.innerHeight;
	} else {
		if (document.documentElement && document.documentElement.clientHeight) {
			centerX = document.documentElement.clientWidth;
			centerY = document.documentElement.clientHeight;
		} else {
			if (document.body) {
				centerX = document.body.clientWidth;
				centerY = document.body.clientHeight;
			}
		}
	}
	var leftOffset = scrolledX + (centerX - 250) / 2;
	var topOffset = scrolledY + (centerY - 200) / 2;
	if (document.getElementById(divPopup) != null) {
		document.getElementById(divPopup).style.top = topOffset + "px";
		document.getElementById(divPopup).style.left = leftOffset + "px";
	}
}
function fireMyPopup(popup) {
	divPopup = popup;
	myPopupRelocate(divPopup);
 //document.getElementById(divPopup).style.display = "";
	document.body.onscroll = myPopupRelocate;
	window.onscroll = myPopupRelocate;
}

