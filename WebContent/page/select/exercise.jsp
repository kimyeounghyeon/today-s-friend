<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../indexPage/header.jsp"></jsp:include>
<section class="setop">
    <article>
        <h1>글 읽기</h1>
        <c:forEach items="${boardcontent }" var="v"></c:forEach>
        
        <form id="frm">
            <table border="1">
                <tr>
                    <td>작성자</td>
                    <td>${v.id }</td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>${v.bsubject }</td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>${v.bcontent }</td>
                </tr>
                <tr>
                    <td>파일선택</td>
                    <td><a href="<%=request.getContextPath() %>/files/${v.bfilepath }"
                        download="${v.bfilepath }">${v.bfilepath }</a></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="답글작성"> 
                    <input type="button" value="수정" id="btnMod"> 
                    <input type="button" value="삭제" id="btndel">
                    <input type="button" value="목록">
                    </td>
                </tr>
            </table>
        </form>
    </article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>