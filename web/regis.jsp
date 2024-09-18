<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="style1.css">
</head>
<body>
  <div class="login-container">
      <div class="auth-links">
        <a href="login.jsp">Login</a> | 
        <a href="regis.jsp">Sign Up</a>
    </div>
    <h2>Registration Page</h2>
  <form action="RegisCon" ">
      <label>Username:</label>
      <input type="text" name="u1" id="box" placeholder="Enter your Username"><br>
      
      <label>password:</label>
      <input type="password" name="u2" id="box" placeholder="Enter your password"><br>
      <label>Email:</label>
      <input type="email" name="u3" id="box" placeholder="Enter your email"><br><br>
      <input type="submit" value="Register">
     
  </form>
  
</body>
</html>