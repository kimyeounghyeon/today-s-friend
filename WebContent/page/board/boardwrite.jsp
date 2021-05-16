<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/update.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
.wr,.rewr,.wlist {
 	width:80px;
    border: none;
    color:#fff;;
    padding: 10px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px;
    cursor: pointer;
    border-radius:10px;
    background-color: #1bcda9;
    font-family: "GmarketSansMedium";
    float : right;
}
section form {
	width:650px; 
	text-align : center;
	display : inline-block;
}

</style>

 
<jsp:include page="../indexPage/header.jsp"></jsp:include>
    <section class="setop">
        <article>
            <br>
            <h1>글쓰기</h1>
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
                <td><input type="text" name="bsubject" id="bsubject"></td>
            </tr>
            <tr>
                <td class="cont">내용</td>
                <td class="cont"><textarea rows="10" cols="150" name="bcontent"
								id="bcontent"></textarea></td>
            </tr>
             <tr>
                <td>첨부파일</td>
                <td><input type="file" class="filesel" name="bfilepaths" id="bfilepaths" multiple="multiple"></td>
            </tr> 
            <tr>
                <td colspan="2">
                    <input type="submit" class="wr" value="글등록">
                    <input type="reset" class="rewr" value="다시작성">
                    <input type="button" class="wlist" value="글목록" onclick="javascript:history.back();">
                </td>
            </tr>
        </table>

    </form>
        </article>
    </section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>