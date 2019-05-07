<%@ include file="/WEB-INF/views/taglibs.jsp" %>

	<div id="footer">

	  <jsp:useBean id="now" class="java.util.Date" />
	  <fmt:formatDate var="year" value="${now}" pattern="yyyy" />
	  <!-- Copyright -->
	  <div class="copyright">
	    <ul class="menu">
		  <li>&copy; ${year} <f:message key="footer.copyright"/></li><li><f:message key="footer.design"/></li>
		</ul>
	 </div>
    </div>
    
		<script>
  			(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  				(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  				m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  				})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
			ga('create', 'UA-31008964-4', 'auto');
			ga('send', 'pageview');
		</script>