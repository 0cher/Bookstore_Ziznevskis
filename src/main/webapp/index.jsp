<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</head>
<body>
    <form method="get" action="controller">
        <label for="book">Find By ID:</label><br>
        <input type="hidden" name="command" value="book"/>
        <input type="text" id="book" name="id" value=""><br>
        <input type="submit" value="Get Book">
      </form>

    <form method="get" action="controller">
        <label>Find All Book</label><br>
        <input type="hidden" name="command" value="books"/>
        <input type="submit" value="Get All Book">
    </form>

</body>
</html>