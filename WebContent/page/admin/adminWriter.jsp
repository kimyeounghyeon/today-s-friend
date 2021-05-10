<%@page import="java.sql.PreparedStatement"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminWriter.css">
    <jsp:include page="../admin/adminheader.jsp"></jsp:include>

    <section class="setop">
    
    <div class=row>
    <h2>공지사항 작성</h2>
        <c:if test="${not empty nlist }">
         <table class="table" id="table">
            <thead>
               <tr>
                  <th><input type="checkbox" id="checkall" /></th>
                  <th>No.</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
            </thead>
            <tbody>
   <c:forEach items="${noticelist }" var="n">
               <tr>
                  <td><input type="checkbox" name="item" /></td>
                  <td class="num">${n.bno}</td>
                  <td class="sub">${n.bsubject}</td>
                  <td class="writer">${n.id }</td>
                  <td class="date">${n.date}</td>
               </tr>
   	</c:forEach>
            </tbody>
         </table>
   	</c:if>
    </div>
<form action="/write" method="post">
	<div>
		<input id="fileup" class="change_btn" type="button" value="파일업로드" style="font-family: GmarketSansMedium;">
		<input class="change_btn" type="button" value="공지글쓰기" style="font-family: GmarketSansMedium;" onclick="location.href='<%=request.getContextPath()%>/page/admin/adminWriting.jsp'">
	</div>
</form>
</section>

<jsp:include page="../indexPage/footer.jsp"></jsp:include>
