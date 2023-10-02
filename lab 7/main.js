//Выведите на экран любое значение с помощью console.log
var text = "Любое значение";
console.log(text);

//Создайте две переменные с числами. Выведите их на экран
var numberOne = 1;
var numberTwo = 2;
console.log("Первое число: " + numberOne);
console.log("Второе число: " + numberTwo);

//Сложите две переменные и выведите результат на экран
var sum = numberOne + numberTwo;
console.log("Сумма: " + sum);

//Поищите в интернете функции для преобразования строки в верхний и нижний регистр.
//Выведите на экран два этих значения
console.log("Верхний регистр: " + text.toUpperCase());
console.log("Нижний регистр: " + text.toLowerCase());

//Запишите в свой скрипт реализацию каждой базовой операции над числами.
//Также посмотрите в интернете как возводить число в квадрат, получать остаток от деления
function add(a, b) {
  return a + b;
}

function sub(a, b) {
  return a - b;
}

function multiply(a, b) {
  return a * b;
}

function division(a, b) {
  if (b != 0) {
    return a / b;
  } else {
    return null;
  }
}

function square(a) {
  return a * a;
}

function mod(a, b) {
  if (b != 0) {
    return a % b;
  } else {
    return null;
  }
}

console.log("Сложение:", add(12, 24)); // 36
console.log("Вычитание:", sub(10, 2)); // 8
console.log("Умножение:", multiply(9, 2)); // 18
console.log("Деление:", division(27, 3)); // 9
console.log("Возведение в квадрат:", square(7)); // 49
console.log("Остаток от деления:", mod(10, 3)); // 1


