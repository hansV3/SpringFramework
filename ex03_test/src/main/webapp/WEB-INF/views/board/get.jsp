<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../includes/header.jsp" %>

<script type="text/javascript">
//사용자가 버튼을 클릭하면 operForm이라는 id를 가진<form> 태그를 전송해야 하므로 추가적인 JavaScript처리가 필요
$(document).ready(function(){
	
	var operForm = $("#operForm");
	
	//사용자가 수정 버튼을 누르는 경우에는 bno값을 같이 전달하고 <form> 태그를 submit 시켜서 처리
	$("button[data-oper='modify']").on("click", function(e){
		operForm.attr("action", "/board/modify").submit();
	});
	
	//만일 사용자가 list로 이동하는 경우에는 아직 아무런 데이터도 필요하지 않으므로<form> 태그 내의 bno 태그를 지우고
	//submit을 통해서 리스트 페이지로 이동
	$("button[data-oper='list']").on("click", function(e){
		
		operForm.find("#bno").remove();
		operForm.attr("action", "/board/list");
		operForm.submit();
		
	});	
});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
		
			<div class="panel-heading">Board Read Page</div>
			
			<div class="panel-body">
			
				<div class="form-group">
					<label>Bno</label> <input class="form-control" name='bno' value='<c:out value="${board.bno}"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Title</label> <input class="form-control" name='title' value='<c:out value="${board.title}"/>' readonly="readonly">
				</div>
				
				<div class="form-group">
					<label>Content</label> <textarea class="form-control" rows="3" name='content' readonly="readonly"><c:out value="${board.content}"/></textarea>
				</div>
				
				<div class="form-group">
					<label>Writer</label> <input class="form-control" name='writer' value='<c:out value="${board.writer}"/>' readonly="readonly">
				</div>
			
				<button data-oper='modify' class="btn btn-default">Modify</button>				
				<button data-oper='list' class="btn btn-info" >List</button>
				 
				 <form id='operForm' action="/board/modify" method="get">
					<input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>				
					<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>				
					<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>				
					<input type='hidden' name='type' value='<c:out value="${cri.type}"/>'>				
					<input type='hidden' name='keyword' value='<c:out value="${cri.keyword}"/>'>				
					
				</form>
						
		

			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp" %>