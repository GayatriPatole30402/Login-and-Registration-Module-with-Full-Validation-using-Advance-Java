<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
  .vh-100 {
    height: 100vh;
  }
  .center-box {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
  }
  .box {
    border: 2px solid #28a745;
    border-radius: 10px;
    padding: 20px;
    text-align: center;
  }
</style>
</head>
<body>
<div class="vh-100" style="background-color: #eee;">
  <div class="row center-box">
    <div class="col-md-4">
      <div class="box" style="background-color: #ffffff;">
        <h2 class="text-success" >Registration Successful!</h2>
        <p class="mb-4">Thank you for registering. You can now exit or log in.</p>
        <div class="d-flex justify-content-around">
          <a href="register.jsp" class="btn btn-secondary btn-spacing">Exit</a>
          <a href="login.jsp" class="btn btn-primary">Login</a>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



	
</body>
</html>