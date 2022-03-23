package com.example.demo;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KeyboardService {
    @Autowired
    private ChatConfigService chatConfigService;

    private final InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();


    public InlineKeyboardMarkup setChooseCityKeyboard(Long chatId){
        List<InlineKeyboardButton> keyboardRow = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();

        //текст на кнопке
        button1.setText(chatConfigService.getCity(chatId));

        //сообщение, которое она возвращает
        button1.setCallbackData(getCurrentCityNowButton(chatConfigService
                .getCity(chatId)));

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Другой");
        button2.setCallbackData(getChooseCityNowButtonData());

        keyboardRow.add(button1);
        keyboardRow.add(button2);
        keyboard.setKeyboard(Arrays.asList(keyboardRow));

        return keyboard;
    }

    public String getChooseCityNowButtonData(){
        return "Введите необходимый город";
    }

    public String getCurrentCityNowButton(String city){
        return "Сейчас " + city;
    }
}