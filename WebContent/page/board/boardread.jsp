<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/update.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<%
		Board board = (Board) request.getAttribute("board");
		Member member = (Member) session.getAttribute("member");
%>
<section class="setop">
<script>
function modComment(inputreno,inputbno){
	var reno = inputreno;
	var bno = inputbno;

	 $(".CModBg").css("display", "block");
	 $("#reno").attr('value',reno);
	 $("#bno").attr('value',bno);
}

function delComment(inputreno,inputbno){
	var reno = inputreno;
	var bno = inputbno;
	
	var answer = confirm('댓글를 삭제하시겠습니까?');
	
	if(answer==true){
		location = "<%=request.getContextPath()%>/page/comment/commentdelete?reno="+reno+"&bno="+bno;
		alert('삭제되었습니다.')
	}
}

	$(function() {
		$(".CModBg").css("display","none");
				 
		$("#btnWriteCom").click(function() {
			var frmComment = document.getElementById("frmComment");
			frmComment.action = "<%=request.getContextPath()%>/page/comment/commentwrite";
			frmComment.method = "post";
			frmComment.submit();
		});
	
		$("#btnCModWrite").click(function() {
			var frmModComment = document.getElementById("frmModComment");
			frmModComment.action = "<%=request.getContextPath()%>/page/comment/commentmod";
			frmModComment.method = "post";
			frmModComment.submit();
		});
	});
</script>
	<article>
		<h1><%=board.getBsubject()%></h1>
		<div id="center">
			<br>
			<table border="1" id="table">
				<tr>
					<td>글번호</td>
					<td><%=board.getBno()%></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><%=board.getBsubject()%></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><%=board.getBcontent()%></td>
				<tr>
					<td>파일선택-여러개</td>
					<td><img
						src="<%=request.getContextPath()%>/files/<%=board.getBfilePath()%>">

					</td>
				</tr>
				<tr>
					<td rowspan="2">댓글보기</td>
					<td><c:if test="${empty comment }">
							댓글이 없습니다.
							</c:if> <c:if test="${not empty comment }">
							<table id="tabRe">
								<c:forEach items="${comment }" var="c" varStatus="status">
									<tr>
										<td class="writeid">${c.id }</td>
										<td>${c.recontent }</td>
										<td>${c.redate }</td>
										<c:if test = "${id eq c.id}">
											<td><button class="btnCMod" onclick="modComment(${c.reno }, ${c.bno });">수정</button></td>
											<td><button class="btnCDel" onclick="delComment(${c.reno }, ${c.bno });">&#10006;</button></td>
										</c:if>
									</tr>
								</c:forEach>
							</table>
						</c:if>
					<td>
				</tr>
				<tr>
					<td>
						<div id="btn_group">
							<form id="frmComment">
								<input type="hidden" name="bno" value="<%=board.getBno()%>">
								<input type="hidden" name="id" value="<%=member.getId()%>">
								<textarea name="recontent" cols="100" rows="7"
									class="customHeight" id="recontent"></textarea>
							</form>
							<button type="button" id="btnWriteCom">댓글등록</button>
							<button type="button" id="listbtn"
								onclick="javascript:history.back();">글목록</button>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!-- 댓글 수정 모달창 -->
        <div class="CModBg" id="CModBg">
         <div class="CMod">
            <span id=close2>&#10006;</span>
             <table>
                <tr>
                	<form id="frmModComment">
	                	<input type="hidden" name="bno" id="bno">
	                	<input type="hidden" name="reno" id="reno">
	                   	<td><textarea name="recontent" class="cmodText"></textarea></td>
	                   	<td><button id="btnCModWrite">수정 등록</button></td>
                   </form>
                </tr>
             </table>
         </div>
      </div>
      <!-- 모달 끝! -->
	</article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>