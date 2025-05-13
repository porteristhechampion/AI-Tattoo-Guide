<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:import url="head.jsp" />
<body>
<div class="container">
  <c:import url="header.jsp" />

  <div class="hero text-center mt-5">
    <h1 class="mb-3">Oops! Something went wrong.</h1>
    <img src="images/hurt-robot.png" width="200">
    <p class="lead mb-4">
      We're sorry, but an error occurred while processing your request. Please try again later.
    </p>

    <p class="mb-3">
      <a href="index.jsp" class="btn btn-primary btn-lg">Return to Home</a>
    </p>
  </div>

  <c:import url="footer.jsp" />
</div>
</body>
</html>
