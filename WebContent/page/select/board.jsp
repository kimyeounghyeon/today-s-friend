<%@page import="java.util.List"%>
<%@page import="board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
   href="<%=request.getContextPath()%>/css/select.css">
<jsp:include page="../indexPage/header.jsp"></jsp:include>
<style>
.tdiv{
   text-align: center;
}
.pabouttitle{
   display : inline-block;
}
#tool {
   align-content: center;
   text-align: center;
}
#fdiv {
    border: 3px solid gray;
    width: 100%;
    height: 100;
    position: absolute;
    bottom: -350%;
    text-align: center;
}
#selloc{
   display : inline-block;
    width: 150px;
}
</style>
<script>
    $(function () {
           $("#btnSearch").click(function(){
            var frm = document.getElementById("frmSearch");
            frm.action = "<%=request.getContextPath()%>/page/board/boardread";
         frm.method = "post";
         frm.submit();
              });
           
         $("#selloc").change(function(){ 
          var locnum = $(this).val();
          location = "<%=request.getContextPath()%>/page/board/boardread?hobbyId=1&locnum="+locnum;
         });
      
   });
</script>
<% 
int hobbyId = (int)request.getAttribute("hobbyId");
String hobby = "";
switch(hobbyId){
case 1:
   hobby = "운동";
   break;
case 2:
   hobby = "영화";
   break;
case 3:
   hobby = "게임";
   break;
case 4:
   hobby = "음식";
   break;
case 5:
   hobby = "주식";
   break;
case 6:
   hobby = "자유";
   break;
}
int locnum = (int)request.getAttribute("locnum");
String loc = "";
switch(locnum){
case 1:
   loc = "서울";
   break;
case 2:
   loc = "경기";
   break;
case 3:
   loc = "인천";
   break;
case 4:
   loc = "충청";
   break;
case 5:
   loc = "강원";
   break;
case 6:
   loc = "경상";
   break;
case 7:
   loc = "전라";
   break;
case 8:
   loc = "제주";
   break;
}
int gradeId = (int)request.getAttribute("gradeId");
%>
<script>
function deleteBoard(inputbno) {
	var bno = inputbno;
    var answer = confirm('글을 정말 삭제하시겠습니까?');
    
    if(answer==true){
    	location ="<%=request.getContextPath()%>/page/board/delete1?bno="+bno+"&hobbyId=<%=hobbyId%>&locnum=<%=locnum%>"
       	alert('삭제되었습니다.')
    }
};
</script>
<div class="click"
   style="position: fixed; right: 100px; bottom: 50px; z-index: 100">
   <a
      href="<%=request.getContextPath()%>/page/board/boardwrite.jsp?hobbyId=<%=hobbyId%>"
      id="write" class="write"><img class="click" src="../../img/클릭.png"
      onmouseover="this.src='../../img/클릭.png'"
      onmouseout="this.src='../../img/클릭1.png'"> </a>
</div>
<section class="setop">
   <article id="hi">
      <div class="tdiv">
         <p class="pabouttitle"><%=hobby%>친구 - <%=loc%></p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<% if(gradeId>3){%> 
         <select id="selloc">
            <option value="">--지역 선택--</option>
            <option value="1">서울</option>
            <option value="2">경기</option>
            <option value="3">인천</option>
            <option value="4">충청</option>
            <option value="5">강원</option>
            <option value="6">경상</option>
            <option value="7">전라</option>
            <option value="8">제주</option>
         </select>
<%} %>
      </div>
      <br>
      <div id="tool">
<% if(hobbyId==1){
%>   
         <a id="introducea" class="bar-item button" href="javascript:void(window.open('https://www.youtube.com/watch?v=tyiN2jjaX0g', '_blank'))">운동영상</a>
         <a id="introduceb" class="bar-item button" href="javascript:void(window.open('<%=request.getContextPath()%>/page/map/map.jsp', '_blank','width=500px, height=400px'))">따릉이
            대여</a> 
<%} else if(hobbyId==2){ %>   
         <a id="introducea" class="bar-item button" href="javascript:void(window.open('https://www.kobis.or.kr/kobis/business/stat/boxs/findDailyBoxOfficeList.do', '_blank'))">박스오피스</a>
         <a id="introduceb" class="bar-item button" href="javascript:void(window.open('https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EC%98%81%ED%99%94%EA%B4%80&oquery=%EC%98%81%ED%99%94%EA%B4%80+%EC%A7%80%EB%8F%84&tqi=h6vHXdp0JXossmX1p8NssssstmN-450682', '_blank'))">우리동네영화관</a>    
<%} else if(hobbyId==3){ %>   
         <a id="introducea" class="bar-item button" href="javascript:void(window.open('https://sports.news.naver.com/esports/news/index.nhn?isphoto=N&type=popular', '_blank'))">주요게임뉴스</a>
         <a id="introduceb" class="bar-item button" href="javascript:void(window.open('https://www.gamemeca.com/ranking.php', '_blank'))">인기게임순위</a>    
<%} else if(hobbyId==4){ %>   
         <a id="introducea" class="bar-item button" href="javascript:void(window.open('https://www.mangoplate.com/top_lists', '_blank'))">맛집리스트</a>
         <a id="introduceb" class="bar-item button" href="javascript:void(window.open('<%=request.getContextPath()%>/page/map/food.jsp', '_blank','width=500px, height=400px'))">우리동네치킨지도
            </a>    
<%} else if(hobbyId==5){ %>   
         <a id="introducea" class="bar-item button" href="javascript:void(window.open('https://news.naver.com/', '_blank'))">오늘의뉴스</a>
         <a id="introduceb" class="bar-item button" href="javascript:void(window.open('https://www.upbit.com/exchange?code=CRIX.UPBIT.KRW-BTC&__cf_chl_jschl_tk__=bf1f30c3ca80b1e76aef81483d38969bfc841686-1621161888-0-AaDHAKllbsFgNdmB922zkfedVpz62hLGXqlqMbkxqRqbOA8P7OosSXh9WKvgosmh2Cu9LqmruYB3NcKScFDB20H2ZRWS7Mp2j1ySudnyOnCKDB1ERIdIzzbhJF2Egx2WmnqTMOVlb_19CVs4RgSJZtstEQ6XQ-0ap5483mCrGF1W19l08lFqqhhuIMmTp_RYC3uEgAUGWJbR_TXOUgWvKsxG03_5kTh8GmGO3zsQkZyl1S47atlJ0Bah78HA2Z31WOW2bHKHMh9A7fgjUen99vFrOyIQmPCQQoPawIKQjp8sTq10E3GpsKtp-jaYNYXTKDv-pZBczxGb8tBl6ottr0rhTSe_pJS1lHU4KI7StBUMd1buKQ-0V1cZpulo31c_2zt3blRqy4YvWDbNazquqojMmB3yB8Q-2wCM3MHwZV5HcZBC7DvA5PIRgI5wacPrkQ', '_blank'))">업비트</a>
<%} else if(hobbyId==6){ %>   
         <a id="introducea" class="bar-item button" href="javascript:void(window.open('<%=request.getContextPath()%>/page/indexPage/main.jsp', '_blank'))">친구들후기</a>
         <a id="introduceb" class="bar-item button" href="javascript:void(window.open('<%=request.getContextPath()%>/page/indexPage/main.jsp', '_blank'))">인기글</a>  
<%} %>                  
         <a href="<%=request.getContextPath()%>/page/board/adread" id="introducec" class="bar-item button">공지사항</a> 
         <a id="introduced" class="bar-item button" href="javascript:void(window.open('<%=request.getContextPath()%>/page/channel/channel.jsp', '_blank','width=500px, height=400px'))">신고
            & 문의</a> 
         <a id="introducee" class="bar-item button" href="javascript:void(window.open('<%=request.getContextPath()%>/page/channel/chatting.jsp', '_blank','width=500px, height=700px'))">채팅하기</a>

      </div>
      <br>
      <c:if test="${not empty search }">
         <h1>${search }에 대한 검색 결과입니다.</h1>
         <h1>총 ${cnt }건입니다.</h1>
      </c:if>
      <c:if test="${empty blist }">
         <h1>게시물이 없습니다</h1>
         <h1>${search }글의 주인공이 되어주세요!</h1>
         <h1><a href="javascript:window.history.back();">돌아가기</a></h1>
      </c:if>
      <c:if test="${not empty blist }">
         <form id="frmSearch">
            <input type="text" name="search" id="search" placeholder="키워드로 검색"> 
            <input type="hidden" name="hobbyId" value="<%=hobbyId%>"> 
            <input type="hidden" name="locnum" value="<%=locnum%>"> 
            <input type="button" id="btnSearch" value="검색">
         </form>
         <c:forEach items="${blist }" var="v" varStatus="status">
            <table border="1" class="trd">
               <tr class="line" id="sub">
                  <td colspan=2;>&nbsp;${v.bsubject }</td>
               </tr>
               <tr class="nline" id="vid">
                  <td style="padding-left: 10px;" valign="top">${v.id }</td>
				<c:if test = "${id eq v.id}">
                  <td class="btnn" style="text-align: right">
                     <button type="button" class="btn" id="ed"
                        onclick="location.href='<%=request.getContextPath()%>/page/board/simread?bno=${v.bno}'">수정</button>
                     <button type="button" class="btn" id="btnbdel" onclick="deleteBoard(${v.bno });">삭제</button>
                  </td>
                  </c:if>
               </tr>
               <tr class="nline setrimg">
                  <td colspan="2" height="500" width="600">
               <c:if test="${not empty v.bfilePath }">
                     <img src="<%=request.getContextPath()%>/files/${v.bfilePath }">
               </c:if>
               <c:if test="${empty v.bfilePath }">
                     <img src="../../img/logo회색.png">
               </c:if>
                  </td>
               </tr>
               <tr class="nline" height="50">
                  <td valign="bottom" colspan="2">${v.bcontent }</td>
               </tr>
               <tr class="nline" height="20">
                  <td class="ar" colspan="2"
                     style="text-align: right; valign: bottom;">${v.fbno }</td>
               </tr>
               <tr class="nline" id="pan" bgcolor="#57d2b4">
                  <td colspan="2">
                     <button type="button" class="btn"
                        onclick="location.href='<%=request.getContextPath()%>/page/comment/commentlist?bno=${v.bno}'">댓글쓰러가기</button>
                  </td>
                  <form id="frmmod" class="frmmod">
                     <input type="hidden" name="bno" value="${v.bno }"> <input
                        type="hidden" name="id" value="${v.id }"> <input
                        type="hidden" name="bsubject" value="${v.bsubject }"> <input
                        type="hidden" name="bfilePath" value="${v.bfilePath }">
                     <input type="hidden" name="bcontent" value="${v.bcontent }">
                     <input type="hidden" name="hobbyId" value="<%=hobbyId%>">
                  </form>
            </table>
            <br>
         </c:forEach>
      </c:if>
      <div id="pagen">
         <c:if test="${startPage != 1 }">
            <a href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${startPage-1}&search=${search }&hobbyId=<%=hobbyId%>&locnum=<%=locnum%>">&#60;</a>
         </c:if>
         <c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
            <a
               href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${s }&search=${search }&hobbyId=<%=hobbyId%>&locnum=<%=locnum%>">${s }</a>
         </c:forEach>
         <c:if test="${endPage < pageCnt }">
            <a
               href="<%=request.getContextPath() %>/page/board/boardread?pageNum=${endPage+1}&search=${search }&hobbyId=<%=hobbyId%>&locnum=<%=locnum%>">&#62;</a>
         </c:if>
      </div>
   </article>
</section>
<jsp:include page="../indexPage/footer.jsp"></jsp:include>