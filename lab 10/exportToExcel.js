const express = require('express');
const excel = require('exceljs');
const fs = require('fs');
const bodyParser = require('body-parser');

const app = express();
const port = 3000;

// Парсинг данных формы
app.use(bodyParser.urlencoded({ extended: false }));

// Обработчик POST-запроса для отправки данных в Excel-файл
app.post('/sendToExcel', (req, res) => {
  const data = req.body;
  let invoice = data.invoice;
  if (invoice != null) {
      invoice = "Да";
  } else {
      invoice = "Нет";
  }

  console.log(data.type1);
  console.log(data.type2);
  console.log(data.info);
  // Путь к вашему Excel-файлу
  const excelFilePath = 'data.xlsx';

  // Создаем новую книгу Excel или открываем существующую
  const workbook = new excel.Workbook();
  let worksheet;

  if (fs.existsSync(excelFilePath)) {
    // Если файл существует, открываем его
    workbook.xlsx.readFile(excelFilePath)
      .then(() => {
        worksheet = workbook.getWorksheet(1);
        // Добавляем новые данные в файл
        worksheet.addRow([data.lastname, data.initial, data.password,data.address, data.quantity, data.type1,data.type2,data.user_age,invoice,data.info]); // Замените на свои поля
        return workbook.xlsx.writeFile(excelFilePath);
      })
      .then(() => {
        res.send('Данные успешно добавлены в Excel-файл.');
      })
      .catch((err) => {
        console.error(err);
        res.status(500).send('Произошла ошибка при записи в Excel-файл.');
      });
  } else {
    // Если файл не существует, создаем новый
    worksheet = workbook.addWorksheet('Sheet 1');
    worksheet.addRow(['Фамилия', 'Инициалы', 'Пароль','Адрес доставки','Количество','Вид яиц','Качество','Доставка','Требуется накладная','Дополнительная информация']); // Замените на свои заголовки
    worksheet.addRow([data.lastname, data.initial, data.password,data.address, data.quantity, data.type1,data.type2,data.user_age,invoice,data.info]); // Замените на свои поля
    workbook.xlsx.writeFile(excelFilePath)
      .then(() => {
        res.send('Excel-файл создан, и данные успешно добавлены.');
      })
      .catch((err) => {
        console.error(err);
        res.status(500).send('Произошла ошибка при создании Excel-файла и записи данных.');
      });
  }
});

app.listen(port, () => {
  console.log(`Сервер запущен на порту ${port}`);
});


  app.get('/', (req, res) => {
    res.sendFile(__dirname + '/form.html');
});
  