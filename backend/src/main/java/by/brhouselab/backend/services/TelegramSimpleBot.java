package by.brhouselab.backend.services;

import by.brhouselab.backend.models.CityEntity;
import by.brhouselab.backend.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Optional;

@Service
public class TelegramSimpleBot extends TelegramLongPollingBot {

    @Value("${TELEGA_NAME}")
    private String botName;
    @Value("${TELEGA_TOKEN}")
    private String botToken;

    private CityRepo cityRepo;

    public TelegramSimpleBot(DefaultBotOptions options, CityRepo cityRepo) {
        super(options);
        this.cityRepo = cityRepo;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() && !update.getMessage().hasText()) {
            return;
        }
        String city = update.getMessage().getText();
        Optional<CityEntity> result = cityRepo.findFirstByNameLikeIgnoreCase(city);

        SendMessage message = new SendMessage()
                .setChatId(update.getMessage().getChatId())
                .setText(result.map(CityEntity::getInfo).orElse("Такой город не найден:("));

        try {
            this.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
