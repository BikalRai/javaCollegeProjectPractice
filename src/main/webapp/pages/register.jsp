<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
    <h1>Registration</h1>

    <div class="container mt-5 ms-auto">
        <form method="POST" action="user?page=register">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" aria-describedby="usernameHelp" name="username" placeholder="Enter username">
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="Enter address here">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Address</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter password here">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <p>Already a member? <a href="user?page=index">Login</a></p>

        </form>
    </div>
</body>
</html>
