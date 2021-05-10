<%@page import="member.model.vo.Member"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminpagemember.css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<jsp:include page="../admin/adminheader.jsp"></jsp:include>

<section class="setop">

   <div class="mypagelist">
      <h2>회원 관리</h2>
      <div class="search">
         <form class="search_form" action="#" method="get">
             <input class="search_bar" type="text" name="keyword" placeholder="회원아이디로 검색" style="font-family: GmarketSansMedium;">
             <button class="search_btn" type="submit" style="font-family: GmarketSansMedium;">검색</button>
           </form>
      <c:if test="${not empty search}">
      <h1>${search}에 대한 검색 결과입니다.</h1>
      <table border="1">
         <tr>
         <th><input type="checkbox" id="checkall" /></th>
            <th>No</th>
            <th>아이디</th>
            <th>이름</th>
            <th>연락처</th>
         </tr>
      <c:forEach items="${mlist }" var="m">
         <tr>
            <td><input type="checkbox" name="item" /></td>
            <td>1</td>
            <td>${m.id }</td>
            <td>${m.name }</td>
            <td>${m.phone }</td>
         </tr>      
      </c:forEach>
      </table>
   </c:if>
      </div>

      <div class=row>
      <c:if test="${empty mlist}">
      등록 된 회원이 없습니다.
      </c:if>
      <c:if test="${not empty mlist }">
         <table class="table" id="table">
            <thead>
               <tr>
                  <th><input type="checkbox" id="checkall" /></th>
                  <th>No.</th>
                  <th>아이디</th>
                  <th>이름</th>
                  <th>연락처</th>
            </thead>
            <tbody>
   <c:forEach items="${mlist }" var="m">
               <tr>
                  <td><input type="checkbox" name="item" /></td>
                  <td class="num">1</td>
                  <td class="id">${m.id }</td>
                  <td class="name">${m.name }</td>
                  <td class="pnum">${m.phone }</td>
               </tr>
   </c:forEach>
            </tbody>
         </table>
      </div>
   </c:if>
   </div>
   <input class="Withdrawal" type="button" value="회원탈퇴" style="font-family: GmarketSansMedium;">
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>