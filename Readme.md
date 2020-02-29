###Тест для Resliv
Используется телеграм бот. Параметры бота:
```
NAME = TestReslivbot
```
```
TOKEN = 1114859169:AAGT4HjZ1FwQXMNHPwQslp-OWoxOGEloG7w
```

###Запуск программы
####Порядок действий
1. Скачать проект
1. Компилировать
1. Запустить 

Действия выполняются в терминале.
####1. Скачивание проекта
```
git clone https://github.com/BrHouseLab/TestReslivForOffer.git
```
####2. Компиляция
```
> mvnw compile
```
####3. Запуск
```
mvnw -pl backend -DTELEGA_NAME=TestReslivbot -DTELEGA_TOKEN=1114859169:AAGT4HjZ1FwQXMNHPwQslp-OWoxOGEloG7w spring-boot:run
```
