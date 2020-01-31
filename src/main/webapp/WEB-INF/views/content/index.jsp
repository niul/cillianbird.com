<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<div class="main">
	<img src='<c:url value="/static/images/cillian.png"/>' alt='<f:message key="index.cillianbird.alt"/>' id="cillian"/>
	<br/>
	<img src='<c:url value="/static/images/${msg}.png"/>' id="${msg}"/>
	<br/>
	<img src='<c:url value="/static/images/lego.png"/>' alt='<f:message key="index.lego.alt"/>' id="lego"/>
</div>

<script>
	setTimeout(function(){
		window.location.reload(1);
	}, 4000);
</script>