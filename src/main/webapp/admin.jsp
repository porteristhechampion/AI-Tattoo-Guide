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

    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="mt-4 mb-3 text-center">
                <h2 class="fw-bold">User Management</h2>
                <p class="text-muted">View and manage registered users.</p>
            </div>

            <div class="card shadow-sm">
                <div class="card-body">
                    <table id="userTable" class="table table-striped table-hover align-middle">
                        <thead class="table-dark">
                        <tr>
                            <th scope="col">Username</th>
                            <th scope="col" class="text-center">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty users}">
                                <c:forEach var="user" items="${users}">
                                    <tr>
                                        <td>${user.username}</td>
                                        <td class="text-center">
                                            <form action="deleteUser" method="post" class="d-inline-block">
                                                <input type="hidden" name="userDelete" value="${user.id}"/>
                                                <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this user?')">
                                                    Delete
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="2" class="text-center text-muted">No users found.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>
    <c:import url="footer.jsp"/>
</div>
</body>
</html>
