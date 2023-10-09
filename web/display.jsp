<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : display
    Created on : Sep 27, 2023, 12:27:36 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="home?value=search" method="post">
            <input type="text" name="tukhoa" placeholder="Nhap tu khoa can tim"/>
            <input type="submit" value="Search"/>
        </form>
        <br/>
        <button onclick="addFunction()">Add</button>
        <br/>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PASSWORD</th>
                    <th>ACTION</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${list}">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.password}</td>
                        <td>
                            <form action="home?value=delete&id=${o.id}" method="post">
                                <input type="submit" value="Delete"/>
                            </form>
                            <button onclick="updateFunction(`${o.id}`, `${o.name}`, `${o.password}`)">Update</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="home?value=add" method="post" style="display:none" id="add">
            <h1>Form Register</h1>
            Username<input type="text" name="username"/>
            <br/>
            Password<input type="password" name="password"/>
            <br/>
            <input type="submit" value="Register"/>
        </form>

        <form action="home?value=update" method="post" style="display:none" id="update">
            <h1>Form Change</h1>
            <input type="text" name="id" style="display:none"/>
            <br/>
            Username<input type="text" name="username"/>
            <br/>
            Password<input type="password" name="password"/>
            <br/>
            <input type="submit" value="Update"/>
        </form>

        <script>
            function addFunction() {
                let formAdd = document.getElementById("add");

                if (formAdd.style.display == "none") {
                    formAdd.style.display = "block";
                } else {
                    formAdd.style.display = "none";
                }
            }

            function updateFunction(id, username, password) {
                let formUpdate = document.getElementById("update");

                if (formUpdate.style.display == "none") {
                    formUpdate.style.display = "block";
                } else {
                    formUpdate.style.display = "none";
                }
                
                let idInput = document.querySelector("#update input[name='id']");
                let usernameInput = document.querySelector("#update input[name='username']");
                let passwordInput = document.querySelector("#update input[name='password']");
                
                idInput.value = id;
                usernameInput.value = username;
                passwordInput.value = password;
            }
        </script>
    </body>
</html>
