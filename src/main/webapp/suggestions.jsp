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
    <c:import url="header.jsp"/>
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
            <h2>Generate a Tattoo Suggestion</h2>
            <form action="generateSuggestion" method="post">
                <label for="promptInput" class="form-label">Enter your prompt:</label>
                <input type="text" class="form-control" id="promptInput" name="prompt" required>
                <button type="submit" class="btn btn-primary">Generate</button>
            </form>

            <c:if test="${not empty generatedResponse}">
                <div class="mt-4">
                    <h4>AI Response:</h4>
                    <div class="alert alert-success" role="alert">
                        <p>${generatedResponse}</p>
                        <form action="insertSuggestion" method="post">
                            <input type="hidden" name="suggestion" value="${generatedRespose}"/>
                            <button type="submit" class="btn btn-primary">Save Suggestion</button>
                        </form>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
