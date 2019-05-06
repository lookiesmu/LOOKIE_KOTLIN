# 상명대학교 루키 코틀린 스터디

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
