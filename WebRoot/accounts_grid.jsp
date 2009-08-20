<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Paging Grid Example</title>
<jsp:include page="includes/jsInclude.jsp"></jsp:include>
<script type="text/javascript" src="<%=request.getContextPath() %>/scripts/grid/accounts_paging.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/grid-examples.css" />

<!-- Common Styles for the examples -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/ext-examples.css" />
</head>
<body>

<h1>Paging Grid Example</h1>
<p>This example shows how to create a grid with paging. This grid uses a ScriptTagProxy to fetch cross-domain
    remote data (from the Ext forums).</p>
<p>Note that the jsis not minified so it is readable. See <a href="paging.js">paging.js</a>.</p>

<div id="topic-grid"></div>

</body>
</html>
