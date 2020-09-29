# seventech-autotest-lessons

## Домашнее задание №1: 
1. Автоматизировать проверку API на 5+ методов c помощью Postman.
2. Желательно, чтобы была зависимость между методами, создание рандомных айди и т.п.
3. Запустить тесты с помощью [Newman](https://learning.postman.com/docs/running-collections/using-newman-cli/command-line-integration-with-newman/#:~:text=Newman%20is%20a%20command%20line,directly%20from%20the%20command%20line.&text=Newman%20maintains%20feature%20parity%20with,the%20collection%20runner%20in%20Postman.)

## Домашнее задание №2: 
1. Переделать свои тесты с постмана на REST Assured(примерно 5 методов). 
2. Желательно для вас самих, чтобы это не были 5 get методов, у которых вы проверяете статус 200.
3. Дефолтные проверки: статус, Content-Type ответа(например json), проверка нескольких значений из ответа
P.S. Если непонятно как что-то сделать, попробуйте поискать [здесь](https://github.com/rest-assured/rest-assured/wiki/Usage)

## Домашнее задание №3:
1. поставить себе [fake api](https://github.com/ob-ivan-kenobi/fake-api-7tech)
2. сделать проект с автотестом этого апи:
   1. сделать Before и After(выполняются перед каждым тестом) методы для создания и удаления товара
   2. сделать три теста
      1. тест get метода, чтобы проверить, что товар создался
      2. тест put метода, чтобы проверить, что товар меняется
      3. тест delete меотда, чтобы проверить, что товар удалился. тут нужно будет дополнительно вызвать get метод с id товара, чтобы проверить, что он действительно удалился
    3. данные брать из excel файла для каждого теста
    4. добавить авторизацию
    
## Домашнее задание №4:
1. Переделать автотесты ДЗ №3 под Cucumber    
