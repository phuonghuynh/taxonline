<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="author" content="Luka Cvrk (solucija.com)" />
	<meta name="keywords" content="conceptnova, concept, framework, web, content, corporate, business" />
	<meta name="description" content="Tax Online" />	
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/jsp/layout/css/main.css" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/jsp/layout/css/breadcum.css" type="text/css" />
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/jsp/layout/js/lib/dijit/themes/claro/claro.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/jsp/layout/js/lib/dojox/grid/resources/claroGrid.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/jsp/layout/js/lib/dojox/grid/resources/Grid.css" />
	<script src="<%=request.getContextPath()%>/static/jsp/layout/js/lib/dojo/dojo.js" data-dojo-config="parseOnLoad: true"></script>
	
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.1/jquery.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/base/jquery-ui.css">	
	
	<script language="JavaScript">
		dojo.require("custom.TaxUtils");
		taxUtils = new custom.TaxUtils({});;
	</script>
	
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body class="claro">
	<div id="wrap">
		<div id="header_top">
		<h1 id="logo"><a href="#" title="Conceptnova">Labor<span class="grey">Exporting</span></a></h1>
			<tiles:insertAttribute name="navigation" />
			
			<div id="slogan">
				<tiles:insertAttribute name="slogan" />
			</div>
		</div>
		<div id="header_bottom">
			<tiles:insertAttribute name="header_bottom" />
		</div>	
		<div id="maincontent">
			<div id="error" class="error" style="display:none;"></div>
			<div id="left">
				<tiles:insertAttribute name="body_left" />
			</div>	
			
			<div id="right">				
				<tiles:insertAttribute name="body_right" />
			</div>
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>