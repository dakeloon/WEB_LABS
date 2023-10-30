let count = 1;

const intervalId = setInterval(function () {
  console.log(`Прошло ${count} секунд`);
  count++;

  if (count === 6) {
    clearInterval(intervalId);
  }
}, 1000);

setTimeout(function () {
  console.log("Этот код выполнится через 2 секунды");
}, 2000);
