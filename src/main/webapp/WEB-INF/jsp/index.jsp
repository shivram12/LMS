<!<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Bootstrap CSS -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">



    <title>LMS</title>
</head>
<body>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<%--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>--%>
</body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="/">LMS <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">All Books</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="new-book">New Books</a>
            </li>

        </ul>
    </div>
</nav>

<div class="container">
    <c:choose>
        <c:when test="${mode=='BOOK_VIEW'}">

            <table class="table">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>BookName</th>
                    <th>Author</th>
                    <th>Purchase Date</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="book" items="${books}">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.bookName}</td>
                        <td>${book.author}</td>
                        <td>${book.purchaseDate}</td>
                        <td><a href="update-book?id=${book.id}"><div class="glyphicon glyphicon-pencil"></div></a></td>
                        <td><a href="delete-book?id=${book.id}"><div class="glyphicon glyphicon-trash"></div> </a></td>

                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </c:when>

        <c:when test="${mode=='BOOK_EDIT' || mode=='BOOK_NEW'}">

            <form action="saved" method="post">
                <input type="hidden" class="form-control" value="${book.id}" name="id" id="id">
                <div class="form-group">
                    <label for="bookName">Book Name:</label>
                    <input type="text" class="form-control" value="${book.bookName}" name="bookName" id="bookName">
                </div>
                <div class="form-group">
                    <label for="author">Author:</label>
                    <input type="text" class="form-control" value="${book.author}" name="author" id="author">
                </div>
                <div class="form-group">
                    <label for="purchaseDate">Purchase Date:</label>
                    <input type="date" class="form-control" value="${book.purchaseDate}" name="purchaseDate"
                           id="purchaseDate">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>

        </c:when>
    </c:choose>

</div>
</html>


