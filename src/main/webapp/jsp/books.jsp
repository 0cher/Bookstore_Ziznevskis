<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Document</title>
</head>
<body>

      <h1>Get ALL BOOK</h1>
      <table>
      <thead>                
      
        <th>Book ID</th><th>Book name</th><th>Author</th><th>Boook ISBN</th>

      </thead>      
      <c:forEach var ="book" items="${requestScope.books}">
        <tbody>
          <tr>
            <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.bookAuthor}</td>
            <td>${book.isbn}</td>
          </tr>
        </tbody>

        </c:forEach>
       </table>

       <jsp:include page="block/getBook.jsp"/>

</body>
</html>