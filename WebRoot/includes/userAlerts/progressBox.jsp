<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<div id="progressInfo"
	style="position: absolute; top: 37%; left: 40%; width: 25%; height: 25%; visibility: hidden">
				<table bgcolor="#F0F0F0" class="userAlertInnerTable" cellpadding="5" cellspacing="5">
					<TR>
						<TD valign="middle" bgcolor="#F0F0F0">
							<img src="images/progress-bar-circle.gif" width="48" height="48"
								border="0" />
						</TD>					
						<TD valign="middle" class="formLabel" nowrap bgcolor="#F0F0F0">
							<span id="progress_msg"> </span>
						</TD>
					</TR>
				</table>

</div>
<!-- div to be enabled only for ext based Ajax calls -->
<div id="extProgressInfo"
	style="position: absolute; top: 37%; left: 40%; width: 25%; height: 25%; visibility: hidden">
				<table bgcolor="#F0F0F0" class="userAlertInnerTable" cellpadding="5" cellspacing="5">
					<TR>
						<TD valign="middle" bgcolor="#F0F0F0">
							<img src="images/progress-bar-circle.gif" width="48" height="48"
								border="0" />
						</TD>					
						<TD valign="middle" class="formLabel" nowrap bgcolor="#F0F0F0">
							<bean:message key='string.processingRequest'/>...
							<span id="progress_msg"> </span>
						</TD>
					</TR>
				</table>

</div>