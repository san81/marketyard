<%@ taglib prefix="s" uri="/struts-tags"%>

<table class="embeddedWindow" id="customMsgBox" border="0" cellpadding="0"
	cellspacing="0"
	style="position: absolute; top: 35%; left: 35%; display: none; z-index: 3;">
	<tr>
		<td class="embeddedWindowTitle" id="titleBar" valign="middle">
			<a href="javascript://"
				onClick="hideMsgBox('customMsgBox');return false"><img
					src="images/exit.gif" border="0" /> </a>
			<s:text name="string.notice" />
		</td>
	</tr>
	<tr>
		<td class="embeddedWindowContent">
			<!-- PLACE YOUR CONTENT HERE //-->
			<table>
				<TR>
					<TD height="30" valign="middle">
						<span id="custom_mgs_msg" class="formLabel"></span>
						<br />
						<span class="errorListText" id="custom_mgs_err_msg"
							style="display: none;"> </span>
					</TD>
				</TR>
				<TR>
					<TD height="30" valign="middle" class="formLabel" nowrap>
						<span id="custom_mgs_input" style="display: none;"> </span>
					</TD>
				</TR>
				<TR>
					<TD align="center">
						<span id="custom_mgs_button"> </span>
					</TD>
				</TR>
			</table>
			<!-- END OF CONTENT AREA //-->
		</td>
	</tr>
</table>