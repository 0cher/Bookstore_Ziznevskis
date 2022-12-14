<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>

      <h1>Get BOOK by ID</h1>
      
      <c:if test="${requestScope.book.id == 2}">
      <h2>Hello!!!!!</h2>
      </c:if>

        <p>Book name: ${requestScope.book.bookName}</p>
        <p>Author: ${requestScope.book.bookAuthor}</p>
        <p>Book ISBN: ${requestScope.book.isbn}</p>

        <jsp:include page="block/getBook.jsp"/>
        <jsp:include page="block/getBooks.jsp"/>

</body>
</html>