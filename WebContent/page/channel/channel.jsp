<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고&문의</title>
<style type="text/css">
p {
	align-content : center;
	    text-align: center;
	    font-family: "GmarketSansMedium";
}

span{

 position: relative;

 animation:test 2s;

}

@keyframes test{

 0%{top:-300px;}

 100%{top:0;}

}
img{
	height: 90%;
	width: 90%;
}
</style>
</head>
<body>
	<p>이미지를 눌러주세요<p>
	<span>
	
	<a id="channel-chat-button" href="http://pf.kakao.com/_CLEMs"
		onclick="void chatChannel();"> <img
		src="../../img/channel.png" />
	</a>
	</span>
	<script type="text/javascript">
		function chatChannel() {
			Kakao.Channel.chat({
				channelPublicId : '_CLEMs',
			})
		}
	</script>

</body>
</html>
