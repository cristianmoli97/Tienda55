<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!-- Title Page -->  
<title>Login</title>
 
<!-- CSS -->
<link rel="stylesheet"  href="/static/css/styles.css" type="text/css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/static/js/main.js"> </script>
</head>

<body>
  <div id="login-button">
    <h1>Clickme</h1>
    <img src="/static/imagenes/login-w-icon.png"></img>
  </div>

  <div id="container">
    <h1>LogIn</h1>
    <span class="close-btn">
      <img src="/static/imagenes/close.png"></img>
    </span>
  
    <form action="loginform" method="POST"> 
     <div class="form-group">
      <input type="text" name="username" placeholder="User">
     </div>

     <div class="form-group">
      <input type="password" name="password" placeholder="Password">
     </div>
     
     <input type="submit" value="submit" name="entrar" class="boton-submit"/>
     <div id="remember-container">
       <span id="forgotten">Recuperar password</span>
     </div>
     <div class="response">
    	<div id="MensajeResponse"></div>
    </div>
    </form>
  </div>
  
  <!-- Contenedor recuperar -->
  <div id="container-recuperar">
    <h1>Recuperar</h1>
    <span class="close-btn">
      <img src="/static/imagenes/close.png"></img>
    </span>
  
    <form>
      <input type="email" name="password_err" placeholder="E-mail">
      <a href="#" class="recupass_btn">Nuevo Password</a>
    </form>
  </div>
  
      
</body>

</html>