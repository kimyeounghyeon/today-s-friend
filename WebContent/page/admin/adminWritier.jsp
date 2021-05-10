<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/adminWriter.css">
    <jsp:include page="../indexPage/header.jsp"></jsp:include>
    <h2>공지사항 작성</h2>

    <section class="setop">
    <div class=row>
        <table class="table" id="table">
            <thead>

                <tr>
                    
                    <th>No.</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
            </thead>
            <tbody>
                <tr>
                    <td class="num">1</td>
                    <td class="sub">안녕하세요</td>
                    <td class="writer">000</td>
                    <td class="date">2021-04-29</td>
                </tr>
              
            </tbody>
        </table>
    </div>
</div>
<input class="change_btn" type="button" value="글쓰기">
</section>

<jsp:include page="../indexPage/footer.jsp"></jsp:include>