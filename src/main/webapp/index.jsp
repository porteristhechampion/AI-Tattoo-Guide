<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<c:import url="head.jsp" />
<body>
<div class="container">
    <c:import url="header.jsp" />

    <div class="hero text-center mt-5">
        <h1 class="mb-3">Welcome to the AI Tattoo Assistant</h1>
        <p class="lead mb-4">
            This is the first version of the AI Tattoo Assistant - a web application built for my Enterprise Java class project.
            It's designed to help users generate tattoo ideas using AI. More features and polish are planned for future updates!
        </p>

        <c:choose>
            <c:when test="${empty user}">
                <a href="login" class="btn btn-primary btn-lg">Log in</a>
            </c:when>
            <c:otherwise>
                <p class="mb-3">Welcome, <strong>${user.username}</strong>!</p>
                <a href="suggestions.jsp" class="btn btn-success btn-lg">View Suggestions</a>
            </c:otherwise>
        </c:choose>
    </div>
    <c:import url="footer.jsp" />
</div>
</body>
</html>
