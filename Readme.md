### Тест для Resliv
Используется телеграм бот. Параметры бота:
```
NAME = TestReslivbot

TOKEN = 1114859169:AAGT4HjZ1FwQXMNHPwQslp-OWoxOGEloG7w
```

### Запуск программы

#### Порядок действий
1. Скачать проект
1. Компилировать
1. Запустить 

Действия выполняются в терминале.

#### 1. Скачивание проекта
```
git clone https://github.com/BrHouseLab/TestReslivForOffer.git

cd TestReslivForOffer
```
#### 2. Компиляция
```
mvnw compile
```
#### 3. Запуск
```
SET TELEGA_NAME=TestReslivbot

SET TELEGA_TOKEN=1114859169:AAGT4HjZ1FwQXMNHPwQslp-OWoxOGEloG7w

mvnw -pl backend spring-boot:run
```
