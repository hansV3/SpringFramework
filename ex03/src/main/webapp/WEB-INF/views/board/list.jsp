<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<button id='listBtn' type="button" ">Board List Page</button>
				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register
					New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<c:forEach items="${list }" var="board">
						<tr>
							<td><c:out value="${board.bno }" /></td>
							<!-- 제목을 클릭하면 조회 페이지로 이동 -->
							<td><a class='move' href='<c:out value="${board.bno}"/>'>
									<c:out value="${board.title }" />
							</a></td>
							<td><c:out value="${board.writer }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regdate }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updateDate }" /></td>
						</tr>
					</c:forEach>
				
				
					

				</table>
				<!-- /.table-responsive -->
				
				<!-- 목록 화면인 list.jsp에서 검색 조건과 키워드가 들어갈수 있게HTML을 수정 -->
				<div class='row'>
					<div class="col-lg-12">
						
						<form id='searchForm' action="/board/list" method='get'>
							<select name='type'>
								<option value=""
									<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
								<option value="T"
									<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}" />>제목</option>
								<option value="C"
									<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}" />>내용</option>
								<option value="W"
									<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}" />>작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}" />>제목 or 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}" />>제목 or 작성자</option>
								<option value="TWC"
									<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}" />>제목 or 내용 or 작성자</option>
							</select>
							<input type='text' name='keyword'
								value='<c:out value="${pageMaker.cri.keyword}"/>' />
							<input type='hidden' name='pageNum' 
								value='<c:out value="${pageMaker.cri.pageNum }"/>' />
							<input type='hidden' name='amount' 
								value='<c:out value="${pageMaker.cri.amount}"/>' />
							<button class='btn btn-default'>Search</button>	
											
						</form>
					</div>
				</div>
				
				
				
				
				<div class="pull-right">
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous">
								<a href="${pageMaker.startPage - 1 }">Previous</a>								
							</li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"	end="${pageMaker.endPage }">
							<!-- <li class="paginate_button"><a href="#">Next</a></li> -->
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}">
								<a href="${num }">${num }</a>
							</li> 
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next">
							<a href="${pageMaker.endPage + 1 }">Next</a></li>
						</c:if>
					</ul>
					
					
					<!-- 실제 페이지를 클릭하면 동작을 하는 부분은 별도의 <form> 태그를 이용해서 처리하도록 합니다. -->
					<!-- 페이지 번호를 클릭해서 이동할 때에도 검색 조건과 키워드는 같이 전달되어야 하므로 페이지 이동에 상요한 <form> 태그를 아래와 같이 수정 -->
					<form id='actionForm' action="/board/list" method='get'>
						<input type='hidden' name='pageNum'	value='${pageMaker.cri.pageNum }'> 
						<input type='hidden' name='amount' value='${pageMaker.cri.amount }'>
						<input type='hidden' name='type' value='<c:out value="${pageMaker.cri.type }"/>'>
						<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword }"/>'>
						
					</form>
				</div>
				<!-- end Pagination -->
				
				
				
				
				<!-- Modal 추가 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						</div>
					</div>

				</div>
				<!-- /.modal -->




			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<%@include file="../includes/footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function(){
		//재전송(redirect) 처리
		//result 생성된 게시물의 번호
		//새로운 게시물의 번호는 addFlashAttribute()로 저장되었기 때문에 한번도 사용된 적이 없다면 위와 같이
		//같을 만들어 내지만사용자가 /board/list를 호출하거나 새로고침을 통해서 호출하는 경우는 아래와같이 아무 내용이 없게 됩니다.
		//이를 이용해서 경고창이나 모달창 등을 보여주는 방식으로 처리할 수 있습니다.
		var result = '<c:out value="${result}"/>';
		
		//모달창을 보여주는 작업은 jQuery를 이용해서 처리할수 있다.
		checkModal(result);
		
		//조회 페이지에서 뒤로가기 문제
		history.replaceState({},null,null);
		
		
		
		function checkModal(result){
			
			if(result === '' || history.state){
				return;
			}
			if(parseInt(result)>0){
				$('.modal-body').html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$('#myModal').modal("show");
		}
		
		$('#listBtn').on("click", function(){
			self.location = "/board/list";
		});
		//Register New Board(글쓰기) 버튼 클릭했을때 동작
		$('#regBtn').on("click", function(){
			self.location = "/board/register";
		});
		
		
		//페이지 번호에 있는 <a> 태그가 원래의 동작을 못하도록 JavaScript 처리를 합니다.
		var actionForm = $("#actionForm");
		
		$('.paginate_button a').on('click', function(e){
			e.preventDefault();
			
			console.log('click');
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			//마지막 처리는 actionForm 자체를 submit() 시켜야 합니다.
			actionForm.submit();
		});
		
		//실제 클릭은 JavaScript를 통해서 게시물의 제목을 클릭했을때 이동하도록 이벤트 처리를 새로 작성합니다.
		//게시물의 제목을 클릭하면 <form> 태그에 추가로 bno 값을 전송하기 위해서 <input>태그를 만들어 추가하고
		//<form>태그의 action은 '/board/get'으로 변경합니다.
		$(".move").on("click", function(e){
			
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
			actionForm.attr("action","/board/get");
			actionForm.submit();
			
		});
		
		//검색 버튼의 이벤트 처리
		//검색 버튼을 클릭하면 검색은 1페이지를 하도록 수정하고, 화면에 검색 조건과 키워드가 보이게 처리하는 작업을 우선으로 진행
		var searchForm = $("#searchForm");
		
		$("#searchForm button").on("click",function(e){
			
			if(!searchForm.find("option:selected").val()){
				alert("검색종류를 선택하세요");
				return false;
			}
			
			if(!searchForm.find("input[name='keyword']").val()){
				alert("키워드를 입력하세요");
				return false;
			}
			//검색 버튼을 클릭하면 <form> 태그의 전송은 막고, 페이지의 번호는 1이 되도록 처리합니다.
			searchForm.find("input[name='pageNum']").val("1");
			e.preventDefault();
			
			searchForm.submit();
			
			
		});
		
		
	});
</script>










