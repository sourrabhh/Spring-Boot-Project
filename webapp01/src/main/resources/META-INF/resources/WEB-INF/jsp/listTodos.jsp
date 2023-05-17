<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <title>
        "ToDos"
    </title>

    <body>
        <div>"Welcome ${name} !!"</div>
        <hr>
        <h3> Your ToDos are : </h3>

        <table>   
            <thead>
                <tr>
                  <th>ID</th> 
                  <th>Description</th>
                  <th>Target Date </th>
                  <th>Is Done?</th>
                </tr>
            </thead> 
            <tbody>
                <c:forEach items="${todos}" var ="todo"> 
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
             </tbody>
        </table>

    </body>
</html>