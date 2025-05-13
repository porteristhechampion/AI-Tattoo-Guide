<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<c:import url="head.jsp"/>
<body>
<div class="container-fluid">
    <c:import url="header.jsp"/>

    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="mb-4 text-center">Edit Your Tattoo Suggestion</h2>

            <form action="updateSuggestion" method="post" class="p-4 rounded shadow-sm bg-light">
                <input type="hidden" name="suggestionId" value="${suggestion.id}"/>

                <div class="mb-3">
                    <label for="editSuggestion" class="form-label fw-bold">Suggestion Text</label>
                    <textarea class="form-control" id="editSuggestion" name="suggestion" rows="4" required>${suggestion.suggestion}</textarea>
                </div>

                <div class="mb-4">
                    <label for="styleSelect" class="form-label fw-bold">Style</label>
                    <select class="form-control" id="styleSelect" name="style" required>
                        <option value="" disabled selected>Select a style</option>
                        <c:forEach var="style" items="${styles}">
                            <option value="${style.id}" <c:if test="${suggestion.style.id == style.id}">selected</c:if>>${style.style}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Save Changes</button>
                    <a href="suggestions" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
    <c:import url="footer.jsp"/>
</div>
</body>
</html>
