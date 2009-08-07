<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html;charset=UTF-8"
	errorPage="/error/error.do" buffer="20kb"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>


<html>
<head>	
	<title><s:text name="label.marketYard" /></title>
		<script language="JavaScript" type="text/javascript" src="scripts/marketYard.js"></script>		
		<link href="${pageContext.request.contextPath}/css/my.css" rel="stylesheet" type="text/css"></link>
</head>

<body>
<tiles:insertAttribute name="banner"></tiles:insertAttribute>
<div id="outer">  
  <div class="outerwrap">
    <div id="centrecontent">
      <div class="cmiddle">
      		<tiles:insertAttribute name="body"></tiles:insertAttribute>
	  </div>
	</div>
	<tiles:insertAttribute name="sideMenu"></tiles:insertAttribute>
  </div>
   <!-- left side ads related tile here --> 
</div>
<tiles:insertAttribute name="banner"></tiles:insertAttribute>	
</body>
</html>
