<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#suggestionTable').DataTable();
    });
</script>

<html>
<c:import url="head.jsp"/>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <h2>Suggestions:</h2>

            <table id="suggestionTable" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Saved Suggestions</th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty suggestions}">
                        <c:forEach var="suggestion" items="${suggestions}">
                            <tr>
                                <td>${suggestion.suggestion}</td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>No suggestions found</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>

        <div class="col-md-8">

        </div>
    </div>
</div>
</body>
</html>
