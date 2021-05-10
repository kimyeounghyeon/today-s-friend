<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../indexPage/header.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminWriting.css">

<%
Member member = (Member)session.getAttribute("member");

String phone = member.getPhone();

%>


<section class="setop">
   <h2>공지사항 글쓰기</h2>
   <form method=post action="<%= request.getContextPath()%>/page/admin/boardwrite">
   <div class=row>
      <table class="table" id="table">
         <thead>
            <tr>
               <th>제목</th>
               <th class="sub"><textarea name="title" cols="90" rows="1"></textarea></th>
         </thead>
         <tbody>
            <tr>
               <th>글쓰기</th>
               <td class="write"><textarea name="contents" cols="90"
                     rows="20"></textarea></td>
            </tr>
         </tbody>
      </table>
      <br>
      <input type="hidden" name="id" value="<%= member.getId()%>">
      <input class="changeBtn" type="submit"
        value="글 등록">
   </div>
   </form>


</section>



<jsp:include page="../indexPage/footer.jsp"></jsp:include>