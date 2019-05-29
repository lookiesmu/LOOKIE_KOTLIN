# 상명대학교 루키 코틀린 스터디

5월 27일 과제

Ch. 7 게시판 구현 (과제 더 나갑니다)

XML
 activity - 로그인(메인), 회원가입, 글 목록, 글 작성, 상세 글
  로그인 : EditText 2개 (id, pw), Button 2개 (로그인, 회원가입)
  회원가입 : EditText 3개 (id, pw1, pw2), Button 1개 (회원가입)
  글 목록 : Recyclerview 1개 (글 목록), Menu 1개 (글 작성)
  글 작성 : EditText 2개 (제목, 내용), Button 1개 (글 작성)
  상세 글 : TextView 2개 (제목, 내용), Recyclerview 1개 (댓글 목록), Button 1개 (댓글 작성)
 view - 댓글 작성, 글, 댓글
  댓글 작성 : EditText 1개 (내용), AlertDialog(댓글 작성 다이얼로그)에 들어갈 CustomView
  글 : TextView 2개 (제목, 내용), 글 목록 Recyclerview에 들어갈 행 view
  댓글 : TextView 1개 (내용), 댓글 목록 Recyclerview에 들어갈 행 view
 item (class) - 글(인덱스, 제목, 내용), 댓글(글 인덱스, 인덱스, 내용)
  
설명 : 
 로그인 Activity : 아이디와 비밀번호를 입력 후 로그인 버튼 클릭 시 계정이 존재할 경우 글 목록 activity로 넘어간다. 단, 서버의 response의 값에 따라 로그인 성공 여부를 결정한다. (계정 없음, 로그인 성공)
 회원가입 Activity : 아이디와 비밀번호 (1차, 2차) 입력 후 회원가입 버튼 클릭 시 해당 페이지를 종료한 후 전 activity로 돌아간다. 단, 서버의 response 값에 따라 회원가입 성공 여부를 결정한다. (아이디 중복, 가입 성공) 또한 1차, 2차 비밀번호가 동일하지 않을 시 Toast 메세지 ("1차 2차 비밀번호가 다릅니다")를 출력 한다. 그럼으로 비밀번호가 같을 때 서버에 POST 요청을 보낸다. 
 글 목록 Activity : Recyclerview에 글 (index, 제목, 내용으로 구성됨)이 나온다. 글 작성 메뉴를 통해 글 작성 activity로 이동 가능, 글 목록의 글 클릭 시 (상세 글 activity) 로 이동한다.
 글 작성 Activity : 제목, 내용 입력 후 작성 버튼을 누르면 서버에 POST 방식으로 제목, 내용, 사용자 id를 보낸다. 단, 제목과 내용은 항상 1자 이상이여야 한다.
 상세 글 Activity : 글의 인덱스를 통하여 POST 요청 후 글 정보들을 서버에서 받아온다. (댓글 포함) 받아온 정보를 이용하여 activity 구성

 이번 과제는 꼭 다음주까지 완성하지 않으셔도 됩니다. 6월 3일 스터디때 서버팀과 함께 게시판 구현 스터디를 할 예정임으로 가능한 많은 부분을 만들어 오시면 집에가는 시간이 빨라질 것입니다. 과제를 진행 하실 땐 서버의 주소는 비워두시고 구현하세요, 스터디 당일 서버 인원이 만든 서버 주소를 사용하게 됩니다. 기타 문의사항, 질문 있으시면 카톡으로 연락 주시면 됩니다. ( 01 : 00 AM) 이후 연락 어렵습니다.

5월 20일 과제

Ch5, 6. Network (Okhttp), Action bar

main xml - Textview 1개, Action Menu 1개, Menu 2개(로그인, 로그아웃), Alert Dialog 1개
dialogview - EditText 2개(id, pw)

설명 : 메뉴의 로그인을 누르면 로그인 페이지 Dialog 표시, id, pw 입력 후 다이얼로그 버튼 이용 로그인 시도,
로그인 성공시 Main의 textview에 “id님 환영합니다” 표시
로그인 실패시 “아이디가 없습니다” Toast 메시지 출력
Okhttp 라이브러리를 이용 통신, 단 접근 방식은 post, 주소 : https://8731a4ed-d833-4a6e-9c6f-aea06ed7c599.mock.pstmn.io/smulookie_ch6


5월 6일 과제

Ch4. RecyclerView, Dialog

class file 3개 (main, student, studentAdapter)
XML file 3개 (main, studentview, dialogview)

class
 main - (-)
 student - 학생의 정보(이름, 나이, 전공)을 담을 클래스
 studentAdapter - main의 RecyclerView에 장착할 CustomAdapter
 
XML
 main - Button 1개, RecyclerView 1개
 studentview - TextView 3개 (이름, 나이, 전공)
 dialogview - EditText 3개 (이름, 나이, 전공)
 
설명 :
main화면의 Button 클릭 시 Dialog 보여진다.
Dialog내에서 3개의 값 입력후 추가 버튼 클릭 시 main화면에 해당 학생정보가 추가되고 Dialog가 종료된다.
취소 버튼 클릭 시 아무런 동작없이 Dialog가 종료된다.

조건 : 학생 정보는 항상 리스트의 가장 위에 추가된다.
Dialog의 editText값들이 채워지지 않은 경우는 고려하지 않는다. (예외처리 필요없음)

4월 29일 과제

Ch3. EditText, ImageView + (hashmap, Toast)

ImageView 1개, TextView 1개, EditText 1개, Button 1개를 배치

TextView에는 현재 가지고 있는 이미지들의 이름 목록이 보여진다.
EditText에 이미지 이름 입력 후 Button을 클릭 시 ImageView는 해당하는 이미지로 바뀐다.
만약 찾는 이미지가 없을 경우 Toast 메세지로 찾는 과일이 없음을 알려준다.

조건 : Hashmap 사용을 권장합니다.


4월 8일 과제 

Ch2. CheckBox, Radio button

메인 xml파일에 1개의 TextView, Button, CheckBox 2개의 Radio Button 세팅

Button 클릭 시 CheckBox의 상태에 따라 TextView의 Text가 다르게 바뀌게 구현
RadioButton을 각각 CheckBoxOn, CheckBoxOff로 설정, On버튼 체크시 CheckBox 활성화,
Off버튼 체크시 CheckBox 비활성화 기능 구현

조건 : RadioButton의 기본 상태는 CheckBoxOn 상태, 
RadioButton에서 Off버튼 체크 후 버튼 클릭 시 텍스트뷰 메세지가 CheckBox가 체크되지 않은 메시지를 출력하도록 구현


4월 1일 과제 

Ch1. Activity 실행, TextView, Button, Button Listener

메인 xml파일에 1개의 텍스트뷰, 3개의 버튼 세팅 (각 버튼의 Text는 다르게 설정)
버튼 클릭 시 해당 버튼의 text가 Textview에 보여짐

조건 : 버튼 리스너는 2가지 방법을 이용해서 구현 (가상 버튼 리스너,
 클래스형 버튼 리스너)
