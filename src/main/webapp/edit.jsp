<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<c:import url="head.jsp"/>
<body>
<div class="container-fluid">
    <c:import url="header.jsp"/>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form action="updateSuggestion" method="post">
                <input type="hidden" name="suggestionId" value="${suggestion.id}"/>

                <label for="editSuggestion" class="form-label">Edit your suggestion:</label>
                <input type="text" class="form-control" id="editSuggestion" name="suggestion" value="${suggestion.suggestion}" required>

                <div class="form-group mt-2">
                    <label for="styleSelect">Choose a style:</label>
                    <select class="form-control" id="styleSelect" name="style" required>
                        <option value="" disabled selected>Select a style</option>

                        <c:forEach var="style" items="${styles}">
                            <option value="${style.id}">${style.style}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-primary">Edit</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
