<%@ include file="/WEB-INF/views/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html itemscope itemtype="http://schema.org/Article" xmlns="http://www.w3.org/1999/xhtml" 
	xmlns:og="http://opengraphprotocol.org/schema/" xmlns:fb="http://www.facebook.com/2008/fbml"  lang="en">
	<head>
		<tiles:insertAttribute name="head"/>
	</head>
	<body>
		<div id="site_content">
			<tiles:insertAttribute name="content"/>
		</div>
		<tiles:insertAttribute name="footer"/>
	</body>
</html>
