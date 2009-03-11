
isIE = document.all;
isNN = !document.all && document.getElementById;
isN4 = document.layers;
function hideMsgBox(name) {
	var contentDiv = document.getElementById("contentAreaBottom");
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaMiddle");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTop");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTopAward");
	}
	if (contentDiv != null) {
		contentDiv.style.filter = "alpha(opacity=100)";
	}
	var targetDiv = document.getElementById(name);
	targetDiv.style.display = "none";
	toggleSelectBoxes(name);
	
	// added to remove the div which is used to disable all the controls behind the div popup opened
	var blurDiv = document.getElementById("blurDiv"); 
	if(blurDiv != null)
    	blurDiv.style.display = "none";
}
function showMsgBox(name) {
	toggleSelectBoxes(name);
	var contentDiv = document.getElementById("contentAreaBottom");
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaMiddle");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTop");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTopAward");
	}
	if (contentDiv != null) {
		contentDiv.style.filter = "alpha(opacity=40)";
	}
	var targetDiv = document.getElementById(name);
	targetDiv.style.display = "";
	
	// blur div is added to disable all the controls behind the openedd div popup.
	var blurDiv = document.getElementById("blurDiv"); 
	if(blurDiv != null){
		blurDiv.style.cssText = "position:absolute; top:0; right:0; width:" + document.body.clientWidth + "px; height:" + document.body.clientHeight + "px; background-color: #FFFFFF; opacity:0.5; filter:alpha(opacity=30)"; 
		blurDiv.style.display = "";
	}	
}
function hideMe(name) {
	var contentDiv = document.getElementById("contentAreaBottom");
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaMiddle");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTop");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTopAward");
	}
	if (contentDiv != null) {
		contentDiv.style.filter = "alpha(opacity=100)";
	}
	var targetDiv = document.getElementById(name);
	targetDiv.style.visibility = "hidden";
	showSelectBoxes();	
}
function showMe(name) {
	hideSelectBoxes();
	var contentDiv = document.getElementById("contentAreaBottom");
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaMiddle");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTop");
	}
	if (contentDiv == null) {
		contentDiv = document.getElementById("contentAreaTopAward");
	}
	if (contentDiv != null) {
		contentDiv.style.filter = "alpha(opacity=40)";
	}
	var targetDiv = document.getElementById(name);
	targetDiv.style.visibility = "visible";
}

function hideSelectBoxes() {
	var layerDivs = document.getElementsByTagName("div");
	for (var i = 0; i < layerDivs.length; i++) {
		var theDiv = layerDivs[i];     
		        //alert(theDiv.id) ;
		var Divid = theDiv.id;
		var ndx = Divid.search("select");
		if (ndx != -1) {
			theDiv.style.visibility = "hidden";
		}
	}
}

function showSelectBoxes() {
	var layerDivs = document.getElementsByTagName("div");
	for (var i = 0; i < layerDivs.length; i++) {
		var theDiv = layerDivs[i];     
        //alert(theDiv.id) ;
		var Divid = theDiv.id;
		var ndx = Divid.search("select");
		if (ndx != -1) {
			theDiv.style.visibility = "visible";
		}
	}
}
/*
	 hide all selects that show up under the div you are showing. 
	You would pass the left, top, width and height values to 
	this toggle script which hides them ONLY if the version is IE6 or previous.
	
	toggleSelectBoxes method is to find the position of the div that we want to display,
	toggleSelect - will hide/unhide all the combo boxes which are under this div position.
*/

function toggleSelectBoxes(name) {
	/* TODO: need to be changed to take the given div Id. Not just customMsgBox */
	var confmsgBox = document.getElementById(name);
	
	if(confmsgBox!=null){
		confmsgBox.style.display = '';
		var selx = confmsgBox.offsetLeft;
	        var sely = confmsgBox.offsetTop;
	        while (confmsgBox.offsetParent) {
	            confmsgBox = confmsgBox.offsetParent;
	            selx+= confmsgBox.offsetLeft;
	            sely+= confmsgBox.offsetTop;
	        }        
	     toggleSelect(selx,sely,confmsgBox.offsetHeight,confmsgBox.offsetWidth);
	     document.getElementById(name).style.display = 'none';
     }
}

function toggleSelect(x, y, w, h) {
	var appVer = navigator.appVersion.toLowerCase();
	var iePos = appVer.indexOf("msie");
	if (iePos != -1) {
		var is_minor = parseFloat(appVer.substring(iePos + 5, appVer.indexOf(";", iePos)));
		var is_major = parseInt(is_minor);
	}
	if (navigator.appName.substring(0, 9) == "Microsoft") { // Check if IE version is 6 or older 		
		if (is_major <= 6) {
			var selx, sely, selw, selh, i;
			var sel = document.getElementsByTagName("SELECT");
			for (i = 0; i < sel.length; i++) {
				selx = 0;
				sely = 0;
				var selp;
				if (sel[i].offsetParent) {
					selp = sel[i];
					while (selp.offsetParent) {
						selp = selp.offsetParent;
						selx += selp.offsetLeft;
						sely += selp.offsetTop;
					}
				}
				selx += sel[i].offsetLeft;
				sely += sel[i].offsetTop;
				selw = sel[i].offsetWidth;
				selh = sel[i].offsetHeight;
				if (selx + selw > x && selx < x + w && sely + selh > y && sely < y + h) {
					if (sel[i].style.visibility != "hidden") {
						sel[i].style.visibility = "hidden";
					} else {
						sel[i].style.visibility = "visible";
					}
				}
			}
		}
	}
}

