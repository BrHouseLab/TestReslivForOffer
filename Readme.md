### Тест для Resliv
Используется телеграм бот. Параметры бота:
```
NAME = Telegram_bot_name_plus_word_bot

TOKEN = Telegram_bot_token
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
SET TELEGA_NAME=Telegram_bot_name_plus_word_bot

SET TELEGA_TOKEN=Telegram_bot_token

mvnw -pl backend spring-boot:run
```
