<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!-- Start footer content -->
<div id="footer" align="center">
	<hr class="horizontalRule" width="90%" />
	<div class="footer">
		<a href="branding.jsp?sec=privacy" target="_blank"><bean:message
				key="string.privacyPolicy" />
		</a> |
		<a href="public/usageAgreement.do" target="_blank"><bean:message
				key="string.usageAgreement" />
		</a>
	<br/>
		<bean:message key="string.copyright" />
	</div>
</div>
<!-- End footer content -->
