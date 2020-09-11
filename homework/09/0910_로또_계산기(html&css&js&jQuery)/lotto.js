const N = 6; // 뽑는 갯수
const color = ["olive", "coral", "mediumpurple", "steelblue", "aqua", "lavender"]; // 번호 css 배경
var count = 0; // 페이지내 번호 갯수 저장을위한 전역 변수
var lotto = new Array(N);
var click = true;

$(document).ready(function () {
  // start 버튼 클릭시
  $("#start").click(function () {
    // 중복 실행 방지용 클릭 체크
    if (click) {
      console.log("실행");
      click = !click;
    } else {
      console.log("이미실행함");
      return;
    }

    // call-back, setInterval: 일정시간마다 반복실행
    let func = setInterval(function () {
      let randNum = Math.floor(Math.random() * 45) + 1;
      console.log(`뽑힌값: ${randNum}`);
      let flag = true; // 중복체크용 bool
      // 로또 중복값 확인 loop
      for (let i = 0; i < lotto.length; i++) {
        if (lotto[i] == randNum) {
          flag = false;
        }
      }
      console.log(lotto);
      console.log(flag);
      if (flag) {
        lotto[count] = randNum;
        let $new = $("<li></li>").text(randNum);
        $new.css("background-color", color[count]);
        $("#list").append($new);
        count++;
      }
      // 반복실행종료 조건
      if (count == N) {
        console.log(`최종값: ${lotto}`);
        clearInterval(func);
      }
    }, 500);
  });

  // 리셋 버튼 클릭시
  $("#reset").click(function () {
    console.log(list);
    // 자식 노드 모두 삭제
    $("#list").empty();

    click = true; // 전역값 초기화
    count = 0; // 전역값 초기화
  });
});
