<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#userTable').DataTable();
    });
</script>

<html>
<c:import url="head.jsp"/>
<body>
<div class="container-fluid">
    <c:import url="header.jsp"/>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <h2>Users:</h2>

            <table id="userTable" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Username</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty users}">
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>
                                        ${user.username}
                                    <br>
                                    <form action="deleteUser" method="post">
                                        <input type="hidden" name="userDelete" value="${user.id}"/>
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>No users found</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
