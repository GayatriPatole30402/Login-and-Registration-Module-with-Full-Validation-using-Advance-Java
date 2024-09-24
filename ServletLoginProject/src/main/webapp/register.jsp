<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Registration form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<section class="vh-100" style="background-color:gray;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign
										up</p>

									<form class="mx-1 mx-md-4" action="register" method="post">

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<input type="text" id="name" name="name" class="form-control" />
												<label class="form-label" for="form3Example1c">Your
													Name</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<input type="email" id="email" name="email" class="form-control" />
												<label class="form-label" for="form3Example3c">Your
													Email</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<input type="password" id="pass" name="pass"
													class="form-control" /> <label class="form-label"
													for="form3Example4c">Password</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div data-mdb-input-init class="form-outline flex-fill mb-0">
												<input type="password" id="repass" name="repass"
													class="form-control" /> <label class="form-label"
													for="form3Example4cd">Repeat your password</label>
											</div>
										</div>

										<div class="form-check d-flex justify-left-center mb-5">
											<input class="form-check-input me-2" type="checkbox" value="agree"
												id="check" name="check"/> <label class="form-check-label"
												for="form2Example3"> I agree all statements in <a
												href="#!">Terms of service</a>
											</label>
										</div>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" data-mdb-button-init 
												data-mdb-ripple-init class="btn btn-primary btn-lg">Register</button>
										</div>

										<p class="text-center text-muted mt-0 mb-0">
											Have already an account? <a  class="link-danger" href="login.jsp"
												class="medium fw-bold text-body" ><u>Login here</u></a>
										</p>


									</form>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	  <!-- JavaScript for pop-up alerts -->
  <script>
    // Check if an error message is present and show it in a pop-up
    <% if (request.getAttribute("errorMessage") != null) { %>
        alert('<%= request.getAttribute("errorMessage") %>');
    <% } %>
</script>


</body>
</html>