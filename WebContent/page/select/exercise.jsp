<%@page import="java.util.List"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<style type="text/css">
div.container {
	width: 90%;
	margin: 0 auto;
	padding: 2% 2%;
	text-align: center;
}

div.noticeInfo {
	margin: 2% 0;
}

div#title {
	width: 60%;
	margin: 5% 0 0 16%;
	border-top: 1px solid gray;
	padding-top: 1%;
	text-align: left;
	font-weight: bold;
}

div.register {
	display: inline-block;
	height: 70px;
	margin-top: 2%;
}

form .customHeight {
	height: 100px;
}

button.btnOK {
	position: relative;
	top: -50px;
	width: 100px;
	background-color: #4d4dff;
	color: #fff;
	border-style: none;
	cursor: pointer;
}

textarea#commentContents {
	font-size: 12pt;
}

div#viewComments {
	width: 60%;
	margin: 1% 0 0 16%;
	text-align: left;
	max-height: 300px;
	overflow: auto;
}

span.markColor {
	color: #ff0000;
}

div.customDisplay {
	display: inline-block;
	margin: 1% 3% 0 0;
}

div.commentDel {
	margin-bottom: 2%;
	font-size: 8pt;
	font-style: italic;
	cursor: pointer;
}
</style>
<script>
    $(function () {
          /*  func_init(); */
           $("#btnSearch").click(function(){
            var frm = document.getElementById("frmSearch");
            frm.action = "<%=request.getContextPath()%>/page/board/boardread";
			frm.method = "post";
			frm.submit();
		});
			
          <%--  $("button#btnOK").click(function(){
           	console.log("aaa");
               var queryString = $("form[name=commentFrm]").serialize();
               console.log(queryString);
               $.ajax({
             		url:"<%=request.getContextPath()%>/page/board/register",
               	type:"POST",
                	data:queryString,
                	
                   success:function(){	
       	  	   func_init();
       	    	   $("#commentContents").val("").focus();
                   },
       	    	error: function(request, status, error){
       		         alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
       		    }
                   
       	      }); 
            });
       		
           function func_init() {
          		$.ajax({
          		url:"<%=request.getContextPath()%>/page/board/list",
          		type:"GET",
          		dataType:"JSON",
          		success:function(json){
          			var html = "";
          			console.log(json);
          			if (json.length > 0) {
          				$.each(json, function(entryIndex, entry){
          					html += "<div> <span class='markColor'>▶</span> "+entry.commentContents+"</div>"
          					+ "<div class='customDisplay'>"+entry.writeDate+"</div>"
          					+ "<div class='customDisplay commentDel'>댓글삭제</div>";
          				});
          			}
          		
          			else {
          				html += "<div>데이터가 없습니다.</div>";
          			}
          			$("#viewComments").html(html);
              	},
          		error: function(request, status, error){
          			alert("code: "+request.status+"\n"+"message: "+request.responseText+"\n"+"error: "+error);
          		    }
          		});  
   	} --%>
         });
       	
</script>
<section class="setop">
	<article>
		<p class="pabouttitle">운동친구</p>
		<a href="<%=request.getContextPath()%>/page/board/boardwrite.jsp?hobbyId=1"
			id="write" class="write">글쓰기</a>
		<c:if test="${not empty search }">
			<h1>${search }에대한검색결과입니다.</h1>
		</c:if>
		<c:if test="${empty blist }">
			<h1>게시물이 없습니다</h1>
			<h1>${search }글의주인공이되어주세요!</h1>
		</c:if>
		<c:if test="${not empty blist }">
			<form id="frmSearch">
				<input type="text" name="search" id="search"> <input
					type="hidden" name="hobbyId" value="1"> <input
					type="button" id="btnSearch" value="검색">
			</form>
			<c:forEach items="${blist }" var="v" varStatus="status">
				<table border="1">
					<tr>
						<td>글번호</td>
						<td>${v.bno }</td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${v.id }</td>
					</tr>
					<tr>
						<td>제목</td>
						<td>${v.bsubject }</td>
					</tr>
					<tr>
						<td>파일경로</td>
						<td><img
							src="<%=request.getContextPath()%>/files/${v.bfilePath }"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td>${v.bcontent }</td>
					</tr>
					<tr>
						<td>댓글</td>
						<td>
							<button type="button" onclick="location.href='<%=request.getContextPath()%>/page/comment/commentlist?bno=${v.bno}'">댓글쓰러가기</button>
						</td>
					<tr>
						<td colspan="2">
							<!-- <button type="button" class="btnMod">수정</button> -->
							<button type="button"
								onclick="location.href='<%=request.getContextPath()%>/page/board/commentlist?bno=${v.bno}'">수정</button>
							<button type="button"
								onclick="location.href='<%=request.getContextPath()%>/page/board/delete1?bno=${v.bno}&hobbyId=1'">삭제</button>
						</td>
					</tr>
					<form id="frmmod" class="frmmod">
						<input type="hidden" name="bno" value="${v.bno }"> <input
							type="hidden" name="id" value="${v.id }"> <input
							type="hidden" name="bsubject" value="${v.bsubject }"> <input
							type="hidden" name="bfilePath" value="${v.bfilePath }"> <input
							type="hidden" name="bcontent" value="${v.bcontent }"> <input
							type="hidden" name="hobbyId" value="1">
					</form>
				</table>
				<br>
			</c:forEach>
		</c:if>
		<c:if test="${startPage != 1 }">
			<a
				href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${startPage-1}&search=${search }&hobbyId=1">이전</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
			<a
				href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${s }&search=${search }&hobbyId=1">${s }</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a
				href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${endPage+1}&search=${search }&hobbyId=1">다음</a>
		</c:if>
	</article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>