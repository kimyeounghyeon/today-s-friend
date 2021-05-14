<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/update.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
function checkRno(inputreno, inputbno){
   var reno = inputreno;
   var bno = inputbno;
   console.log(reno);
   console.log(bno);
   
   $.ajax({
		type : "post",
		url : "<%=request.getContextPath()%>/page/comment/readcommnet",
		data : {
			reno : reno,
		},
		dataType : "json",
		success : function(data){
				$(".CModBg").css("display", "block");
			   	$(".CMod").css("display", "block");
			    $("#reno").attr('value',data.reno);
			    $("#bno").attr('value',data.bno);				    
				$(".cmodText").val(data.recontent);
		},
		error : function(data){
			alert('뭔가 오류');
			alert(data);
			}
		});    
}

function close_99(){
   console.log("aaa");
   $(".CModBg").css("display","none");
   $(".CMod").css("display","none");
}

function delComment(inputreno,inputbno){
      var reno = inputreno;
      var bno = inputbno;
      
      var answer = confirm('댓글을 삭제하시겠습니까?');
      
      if(answer==true){
         location = "<%=request.getContextPath()%>/page/comment/commentdelete?reno="+reno+"&bno="+bno;
         alert('삭제되었습니다.')
      }
   }
   $(function() {
             
      $("#modComment").click(function() {
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
      
      $("#btnWriteCom").click(function() {
          var frmComment = document.getElementById("frmComment");
          frmComment.action = "<%=request.getContextPath()%>/page/comment/commentwrite";
          frmComment.method = "post";
          frmComment.submit();
      });
   });
</script>
<%
      Board board = (Board) request.getAttribute("board");
      Member member = (Member) session.getAttribute("member");
%>
<section class="setop">
   <article>
      <h1><%=board.getBsubject()%></h1>
     		<!-- 댓글 수정 모달창 -->
        <div class="CModBg">
         <span id="close3" onclick="close_99();">&#10006;</span>
         <div class="CMod">
            <h1 class="subject">댓글 수정</h1>
             <table class="modModalT">
                <tr>
                	<form id="frmModComment">
	                	<input type="hidden" name="bno" id="bno">
	                	<input type="hidden" name="reno" id="reno">
	                   	<td class="modMoalTd"><textarea name="recontent" class="cmodText" ></textarea></td>
					</tr>
                	<tr>
	                   	<td class="modMoalTdR"><button id="btnCModWrite">수정 등록</button></td>
	                   	<tr>
                   </form>
             </table>
         </div>
      </div>
      <!-- 모달 끝! -->
      
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
                                 <td><button class="modComment" onclick="checkRno(${c.reno }, ${c.bno });">수정</button></td>
		                   <td><button class="btnCDel" onclick="delComment(${c.reno }, ${c.bno });">&#10006;</button></td></c:if>
                        </c:forEach>
                     </table>
                  </c:if>
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
   </article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>