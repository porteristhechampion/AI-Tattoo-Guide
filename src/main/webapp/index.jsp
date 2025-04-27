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
            <div class="container text-center m-5">
                <h2>Welcome to the AI tattoo assistant!</h2>
                <h5>This is just the beginning, and only I have access to it!!!</h5>
                <a href="suggestions" class="btn btn-primary">View Suggestions</a>
            </div>
        </div>
    </body>
</html>
