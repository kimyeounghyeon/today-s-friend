<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2 {
	align-content : center;
	    text-align: center;
}</style>
</head>
<body>
	<h2>이미지를 눌러주세요</h2>
	
	<a id="channel-chat-button" href="http://pf.kakao.com/_CLEMs"
		onclick="void chatChannel();"> <img
		src="../../img/channel.png" />
	</a>
	<script type="text/javascript">
		function chatChannel() {
			Kakao.Channel.chat({
				channelPublicId : '_CLEMs',
			})
		}
	</script>

</body>
</html>
