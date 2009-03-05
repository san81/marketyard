
<br>
  
<form name="calform">
<input type=text name=input9>&nbsp;&nbsp;&nbsp;<a href="javascript:cal9.popup();"><img src="img/cal.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a><br>
</form>

<script>
		var cal9 = new calendar3(document.forms['calform'].elements['input9']);
				cal9.year_scroll = true;
				cal9.time_comp = false;
</script>