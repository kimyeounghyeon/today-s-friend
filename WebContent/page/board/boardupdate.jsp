<%@page import="board.model.vo.Board"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> 
<jsp:include page="../indexPage/header.jsp"></jsp:include>
    <section class="setop">
        <article>
            <br>
            <h1>수정하기</h1>
    <form action="<%=request.getContextPath() %>/page/board/write" method="post" enctype="multipart/form-data">
        <table border="1">
<%
Member member = (Member)session.getAttribute("member");

%>
<input type="hidden" name="id" id="id" value="${member.id }">
<input type="hidden" name="locNum" id="locNum" value="${member.locnum }">
<input type="hidden" name="hobbyId" id="hobbyId" value="${param.hobbyId }">

            <tr>
                <td>제목</td>
                <td><input type="text" name="bsubject" id="bsubject" value="${param.bsubject }"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><input type="text" name="bcontent" id="bcontent" value="${param.bcontent }"></td>
            </tr>
             <tr>
                <td>파일선택-여러개</td>
                <td><input type="file" name="bfilepaths" id="bfilepaths" multiple="multiple" value="${param.bfilepaths }"></td>
            </tr> 
            <tr>
                <td colspan="2">
                    <input type="submit" value="글등록" onclick="location.href='<%=request.getContextPath()%>/page/board/update?bno=${v.bno}&hobbyId=1'">
                    <input type="reset" value="다시작성">
                    <input type="button" value="글목록" onclick="javascript:history.back();">
                    
                </td>
            </tr>
        </table>

    </form>
        </article>
    </section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>