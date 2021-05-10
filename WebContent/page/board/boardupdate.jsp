<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(function () {
	 $("#btnchange").click(function(){
		     var frmmod = document.getElementById("frm1");
		     frm1.action = "<%=request.getContextPath()%>/page/board/update";
			 frm1.method = "post";
			 frm1.submit();
		});
	});
</script>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
   <article>
      <br>
      <h1>수정하기</h1>
      <%Board board= (Board)request.getAttribute("board"); %>
      <form id="frm1" >
      <input type="hidden" name="hobbyId" value="1">
         <td><input type="hidden" name="bno" value=<%=board.getBno() %>></td>
         <table border="1">
            <tr>
               <td>글번호</td>
               <td><%=board.getBno() %></td>
            </tr>
            <tr>
               <td>제목</td>
               <td><input type="text" name="bsubject" value=<%=board.getBsubject()%>></td>
            </tr>
            <tr>
               <td>내용</td>
               <td><input type="text" name="bcontent" value=<%=board.getBcontent()%>></td>
            </tr>
            <tr>
               <td>파일선택-여러개</td>
               <td><input type="file" name="bfilepath" multiple="multiple" value=<%=board.getBfilePath()%>></td>
            </tr>
            <tr>
               <td colspan="2">
               		<button type="button" id="btnchange">글수정</button>
               		<input type="reset" value="다시작성">
                  	<input type="button" value="글목록" onclick="javascript:history.back();">
               	</td>
            </tr>
         </table>
         </form>
         
   </article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>