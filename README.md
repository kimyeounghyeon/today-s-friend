# 오늘의친구
##### 팀원 : 김도영, 김영현, 오유진, 이은혜, 전계원, 정재만

---
## Contents
1. [프로젝트 소개](#프로젝트-소개)
2. [설계의 주안점](#설계목표와-기대효과)
3. [개발환경](#개발환경)
4. [프로젝트 기능구현](#프로젝트-기능구현)
5. [주요기능](#주요기능)
6. [Document](#Document)

---
## 프로젝트 소개
- 당근마켓을 모티브로 기획
- 같은 취미를 가진 친구를 같은 지역에서 만날 수 있는 지역 커뮤니티를 제공

---
## 설계목표와 기대효과
* 설계의 주안점
  - 지역 : 회원가입시 저장된 지역을 통하여 같은 지역 유저를 만날 수 있게한다.
  - 취미 : 지역 내 같은 취미를 가진 유저들의 만남을 연계한다.
  - 안정성 : 등급제도를 통한 안정성을 확보한다.

* 기대효과
  - 지역 커뮤니티의 활성화
  - 취미 커뮤니티의 활성화

---
## 개발환경
![environment](https://user-images.githubusercontent.com/82936574/125957241-02971626-a1f4-400a-95b4-8219c22470b7.png)


|Category|Detail|
|:--:|:--:|
|FrontEnd|HTML5, JavaScript, CSS3, JQuery, Bootstrap|
|BackEnd|Java(JDK 1.8), Servlet, JSP, Spring, MyBatis|
|OS|Windows 10|
|Libray&API|Apache Commons FileUpload, Imgscalr|
|IDE|Eclipse, VisualStudio, Spring Tool Suite|
|Server|Tomcat(v8.5)|
|Document|Google Drive, KakaoOven, ERDCloud, diagrams.net|
|CI|Github|
|DateBase|SQL Developer, Oracle(11g)|
|API|Investment Widget, Iamport Payment, Trading View, CKeditor5, Java.Mail.Sender, <br>Talk Plus, KaKao Channel


---
## 프로젝트 기능구현
- 이은혜
  - 발표, 유즈케이스 작성, 관리자 페이지 공지사항, 로그인 아이디/ 비밀번호 찾기. DB 설계, SQL 정리, 게시글 포인트, 댓글 게시판, 검색 기능, 게시판 지역별, 취미별 분류, 페이징 처리, 에러 페이지
- 김영현
  - PPT, 포인트 게시판, 픽토그램 및 CSS, 댓글 게시판, 관리자 페이지 등급 관리, 댓글작성 시 포인트, 모든 이미지 작업, 화면 설계, 메인 페이지/ 로그인 페이지 모달 
- 정재만
  - 게시판 글 추가, 로그인 회원가입, 관리자 페이지, 관리자 페이지 회원 관리, 가입 유효성 검사, 마이 페이지 정보 수정 
- 김도영
  - 조장, 게시판 글 삭제/ 업데이트, API (지도, 채팅, 신고), 관리자 페이지, 게시글 관리/ 인기 분석 
- 전계원
  - 클래스 다이어그램, 회의록 작성, 공지사항 게시판, 마이 페이지 자신이 쓴 글/ 회원 탈퇴
- 오유진
  - 화면 설계, 발표 일정, 게시판 CSS, 이미지(후기 사진)


---
## 주요기능
**1. 로그인**
<p align="center">
    <img src = "ReadMe/01.png", width="700px">
</p>

**8888. 랭킹**
<p align="center">
    <img src = "https://user-images.githubusercontent.com/82925724/125972371-b938481a-50f6-4803-8120-5a5e97600d82.gif" width="700" height="400">
</p>


**13. 공지사항**<br>
<left><img src="https://user-images.githubusercontent.com/82936574/126027457-7fc8c969-3720-43f7-a3b7-ede15c2f1134.gif"  width="700" height="400" /></left>

---
## Document
### 1. 개발일정
![schedule](https://user-images.githubusercontent.com/82936574/125962840-a5019046-daa8-4b37-9baf-523ee7572f41.png) <br>
[개발일정 전체보기](https://github.com/meta1mon/final01/files/6831288/_.xlsx)

### 2. 유스케이스
![usecase](https://user-images.githubusercontent.com/82936574/125957196-0a2b51df-9a06-4433-8781-34aae77a0c35.gif)

### 3. ERD
![물리적 설계](https://user-images.githubusercontent.com/78994909/126037674-6937205a-19d1-4fed-a37b-43e85bc22d94.jpg)
