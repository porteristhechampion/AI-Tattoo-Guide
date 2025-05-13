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

    <div class="container mt-5">
        <div class="row">
            <!-- Saved Suggestions Section -->
            <div class="col-md-6 mb-4">
                <div class="card shadow">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0">Saved Suggestions</h4>
                    </div>
                    <div class="card-body">
                        <table id="suggestionTable" class="table table-hover table-bordered">
                            <thead class="thead-light">
                            <tr>
                                <th>Suggestion</th>
                                <th>Style</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${not empty suggestions}">
                                    <c:forEach var="suggestion" items="${suggestions}">
                                        <tr>
                                            <td>
                                                    ${suggestion.suggestion}
                                                <div class="mt-2 d-flex gap-2">
                                                    <form action="editSuggestion" method="post" class="me-1">
                                                        <input type="hidden" name="suggestionEdit" value="${suggestion.id}"/>
                                                        <button type="submit" class="btn btn-sm btn-outline-primary">Edit</button>
                                                    </form>
                                                    <form action="deleteSuggestion" method="post">
                                                        <input type="hidden" name="suggestionDelete" value="${suggestion.id}"/>
                                                        <button type="submit" class="btn btn-sm btn-outline-danger">Delete</button>
                                                    </form>
                                                </div>
                                            </td>
                                            <td>${suggestion.style.style}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="2" class="text-center text-muted">No suggestions found</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Generate Suggestion Section -->
            <div class="col-md-6 mb-4">
                <div class="card shadow">
                    <div class="card-header bg-success text-white">
                        <h4 class="mb-0">Generate a Tattoo Suggestion</h4>
                    </div>
                    <div class="card-body">
                        <form action="generateSuggestion" method="post">
                            <div class="form-group mb-3">
                                <label for="promptInput">Enter your prompt:</label>
                                <input type="text" class="form-control" id="promptInput" name="prompt" placeholder="e.g., 'dragon with cherry blossoms'" required>
                            </div>
                            <button type="submit" class="btn btn-success">Generate</button>
                        </form>

                        <c:if test="${not empty generatedResponse}">
                            <div class="alert alert-success mt-4">
                                <h5>AI Response:</h5>
                                <p>${generatedResponse}</p>
                                <form action="insertSuggestion" method="post">
                                    <textarea name="suggestion" hidden>${generatedResponse}</textarea>

                                    <div class="form-group mt-2">
                                        <label for="styleSelect">Choose a style:</label>
                                        <select class="form-control" id="styleSelect" name="style" required>
                                            <option value="" disabled selected>Select a style</option>
                                            <c:forEach var="style" items="${styles}">
                                                <option value="${style.id}">${style.style}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <button type="submit" class="btn btn-primary mt-3">Save Suggestion</button>
                                </form>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="footer.jsp"/>
</div>
</body>
</html>
