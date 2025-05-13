<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="mb-4">
    <nav class="d-flex justify-content-center py-3 border-bottom bg-white">
        <a href="index.jsp">Home</a>
        <c:choose>
            <c:when test="${not empty username}">
                <a href="logout">Log out</a>
                <c:if test="${sessionScope.isAdmin == true}">
                    <a href="users">Admin</a>
                </c:if>
            </c:when>
            <c:otherwise>
                <a href="login">Login</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>
