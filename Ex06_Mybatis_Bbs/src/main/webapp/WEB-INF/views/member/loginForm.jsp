<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@ include file="../include/header.jsp"%>



</div>
<div class="container">
	<div class="row">

		<form action="${loginUrl}" method="post">

			<div class="offset-md-4 col-md-4 mb-3">
				<input type="text" class="form-control" name="site_username" />
			</div>
			<div class="offset-md-4 col-md-4 mb-3">
				<input type="text" class="form-control" name="site_password" />
			</div>
			<div class="offset-md-4 col-md-4">
				<input type="submit"  class="btn btn-primary" value="로그인" />
			</div>
		</form>


	</div>
</div>






<%@ include file="../include/footer.jsp"%>
