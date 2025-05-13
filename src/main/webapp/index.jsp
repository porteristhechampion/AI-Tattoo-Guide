<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <c:import url="head.jsp"/>
    <body>
        <div class="container-fluid">
            <c:import url="header.jsp"/>
            <div class="container text-center m-5">
                <h2>Welcome to the AI tattoo assistant!</h2>
                <h5>This is just the beginning!</h5>
                <c:choose>
                    <c:when test="${empty username}">
                        <a href="login" class="btn btn-primary">Log in</a>
                    </c:when>
                    <c:otherwise>
                        <p>Welcome ${username}</p>
                        <a href="suggestions" class="btn btn-primary">View Suggestions</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
