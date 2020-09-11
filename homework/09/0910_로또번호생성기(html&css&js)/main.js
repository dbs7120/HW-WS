var count = 0; // 페이지내 번호 갯수 저장을위한 전역 변수
var N = 6;
var lotto = new Array(N);

function make() {
  if (count == N) {
    return;
  }
  let list = document.getElementById("list");

  // call-back, setInterval: 일정시간마다 반복실행
  let func = setInterval(function () {
    let randNum = Math.floor(Math.random() * 45) + 1;
    console.log(`뽑힌값 ${randNum}`);
    let flag = true;
    // 로또 중복값 확인
    for (let i = 0; i < lotto.length; i++) {
      if (lotto[i] == randNum) {
        flag = false;
      }
    }
    console.log(lotto);
    console.log(flag);
    if (flag) {
      lotto[count] = randNum;
      let list_item = document.createElement("li");
      list_item.appendChild(document.createTextNode(randNum));
      list.appendChild(list_item);
      count++;
    }
    // 반복실행종료 조건
    if (count == N) {
      clearInterval(func);
    }
    flag = true;
  }, 100);
}

function reset() {
  var list = document.getElementById("list");
  console.log(list);

  // 다음자식값 존재 파악
  while (list.hasChildNodes()) {
    list.removeChild(list.firstChild);
  }
  count = 0;
}
