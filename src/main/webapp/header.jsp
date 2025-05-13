<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<header>
    <nav class="d-flex flex-column flex-sm-row text-center justify-content-evenly py-3 fs-5">
        <a href="index.jsp" class="text-decoration-none">HOME</a>
        <a href="users" class="text-decoration-none">ADMIN</a>
        <c:choose>
            <c:when test="${not empty username}">
                <a href="logOut" class="text-decoration-none">Log out</a>
            </c:when>
        </c:choose>
    </nav>
</header>
