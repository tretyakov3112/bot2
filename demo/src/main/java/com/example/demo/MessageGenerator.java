package com.example.demo;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class MessageGenerator {
    @Autowired
    private BotService botConfigService;
    @Autowired
    private WeatherService weatherService;

    private String message;

    public String generateStartMessage(String name){
        return ("Привет, " + name + " :wave: \nЧтобы узнать, как мной пользоваться - введите /help");
    }

    public String generateHelpMessage(){
        message = "";
        message = ":sunny: Вот мои доступные команды :sunny:\n\n";
        botConfigService.getAllCommands()
                .forEach(command -> {
                    message = message + command.getName() + " - " + command.getDescription() + "\n";
                });
        return (message);
    }

    public String generateSuccessCancel(){
        return (":white_check_mark: Активная команда успешно отклонена");
    }

    public String generateSuccessSetCity(String city){
        return (":white_check_mark: Новый стандартный город - " + city);
    }

    public String generateErrorCity(){
        return (":x: Такого города не существует");
    }

    public String generateSuccessGetCity(String city){
        return (":cityscape: Стандартный город - " + city);
    }

    public String generateErrorGetCity(){
        return (":x: Стандартный город не назначен");
    }

    public String generateCurrentWeather(String city){
        WeatherNow weatherNow = weatherService.getCurrentWeather(city);
        return ("Текущая погода\n\n" +
                "В городе " + city + " " + weatherNow.getWeather().get(0).getDescription() + "\n" +
                ":thermometer: Температура: " + weatherNow.getMain().getTemp() + "°C, ощущается как " + weatherNow.getMain().getFeelsLike() + "°C");
    }
}

