<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="progressInfo"
	style="position: absolute; top: 37%; left: 40%; width: 25%; height: 25%; visibility: hidden">
				<table bgcolor="#ABCDEF" class="userAlertInnerTable" cellpadding="5" cellspacing="5">
					<TR>
						<TD valign="middle" bgcolor="#ABCDEF">
							<img src="images/progress-bar-circle.gif" width="48" height="48"
								border="0" />
						</TD>					
						<TD valign="middle" class="formLabel" nowrap bgcolor="#ABCDEF">
							<span id="progress_msg"> </span>
						</TD>
					</TR>
				</table>

</div>
<!-- div to be enabled only for ext based Ajax calls -->
<div id="extProgressInfo"
	style="position: absolute; top: 37%; left: 40%; width: 25%; height: 25%; visibility: hidden">
				<table bgcolor="#ABCDEF" class="userAlertInnerTable" cellpadding="5" cellspacing="5">
					<TR>
						<TD valign="middle" bgcolor="#ABCDEF">
							<img src="${pageContext.request.contextPath}/images/progress-bar-circle.gif" width="48" height="48"
								border="0" />
						</TD>					
						<TD valign="middle" class="formLabel" nowrap bgcolor="#ABCDEF">
							<s:text name="inform.loading"></s:text>
							<span id="progress_msg"> </span>
						</TD>
					</TR>
				</table>

</div>