

var progressCount = 0;
function toggleExtProgressBox(state){
	var msg = document.getElementById("extProgressInfo");
	
	if (state == "hide") {	
		msg.style.visibility = "hidden";
	} else {		
		msg.style.visibility = "visible";
	}	
}
Ext.Ajax.on({
              'beforerequest': function(){  
		              progressCount++;  						
					if(progressCount==1)
						toggleExtProgressBox('show');          		                   
              },
           
              'requestcomplete': function(){ 
              		progressCount--;   					 
 				 	if(progressCount==0)
						toggleExtProgressBox('hide');	                       	
          }});
             
function makeExtAjaxCall(urlArg,paramsArg,successHandler,failureHandler){	
	
	if(!failureHandler)   /* failure handler is not mentioned, give the default handler */
			failureHandler = inCaseOfException;
		
	var json = Ext.Ajax.request({
                url: urlArg,
                params: paramsArg+"&isAjaxCall=true",
                success: successHandler,
                failure: failureHandler,
                timeout: 12000
            });
 }
 
function inCaseOfException(response) {
	toggleExtProgressBox('hide');
    var buttons = "<table><tr><td><input type=\"button\" id=\"okButton\" class=\"submit\" name=\"okButton\" value='Ok' onClick=\"hideMsgBox('customMsgBox');moveToQuickSearch();return false;\"></td>" ;
    writeToElement("custom_mgs_button", buttons);
    writeToElement("custom_mgs_msg", response.status + " " +response.statuText);
    showMsgBox('customMsgBox');
}


function moveToQuickSearch() {
     window.location = eventQuickSearchPath;
}


/* Prototype based Synchronouse call making to the server. */
function makeSynchCall(url,params,successHandler){
	
	showMe("extProgressInfo");
	new Ajax.Request(url,
		{
			asynchronous: false,
			method: 'get',
			onComplete: successHandler,
			parameters: params	
	    });	
	hideMe("extProgressInfo");
	
	/* exmaple call
	new Ajax.Request('../category/action/getChildNodeCount.do',
		{
			asynchronous:false,
			method:'get',
			onComplete:successHandler,
			parameters:{catId:804}	
	});	
	*/
}

