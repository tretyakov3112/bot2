package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "bot_config")

// Аннотация @Component необходима, чтобы наш класс распознавался Spring, как полноправный Bean
@Component
// Наследуемся от TelegramLongPollingBot - абстрактного класса Telegram API
public class Bot {
    // Аннотация @Value позволяет задавать значение полю путем считывания из application.yaml
    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String accessToken;

    @Id
    private BigInteger id;

    private String nowWeatherApiTemp = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid=b269754c91bec9173eff8bc9d07099da&units=metric&lang=ru";

    private String telegramCallbackAnswerTemp = "https://api.telegram.org/bot{token}/answerCallbackQuery?callback_query_id={id}";

    private List<Command> commands;

    /*
    @Override

    public void onUpdateReceived(Update update) {
        try {
            SendMessage sendMessage = new SendMessage();
            Long chatId = update.getMessage().getChatId();
            String message = String.valueOf(update.getMessage().getText());
            sendMessage.setChatId(String.valueOf(chatId));
            sendMessage.setText(chatId+"  "+message);
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //e.printStackTrace();
        }
    }

    // Геттеры, которые необходимы для наследования от TelegramLongPollingBot
    public String getBotUsername() {
        return name;
    }

    public String getBotToken() {
        return accessToken;
    }
    */

}