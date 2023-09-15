let date = new Date();
let firstday = new Date('2023-08-24');
let meetday = date - firstday;
meetday = Math.floor(meetday / (1000*60*60*24));
let accent = document.querySelector('#accent');
accent.innerHTML = `${meetday}일`;

function calcDay(days) {
  let f_day = firstday.getTime() + days*(24*60*60*1000);
  f_day = new Date(f_day);
  console.log(f_day.toLocaleDateString());
  let year = f_day.getFullYear();
  let month = f_day.getMonth() + 1;
  let day = f_day.getDate();
  let result = `${year}년 ${month}월 ${day}일`;        
  document.querySelector(`#date${days}`).innerHTML = result;
}

calcDay(100);
calcDay(200);
calcDay(365);
calcDay(500);
