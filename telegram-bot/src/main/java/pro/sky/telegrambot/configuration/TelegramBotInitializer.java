package pro.sky.telegrambot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import pro.sky.telegrambot.components.TelegramBot;
@Component
public class TelegramBotInitializer {
    private final TelegramBot telegramBot;
    @Autowired
    public TelegramBotInitializer(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }
    @EventListener({ContextRefreshedEvent.class})
    public void init()throws org.telegram.telegrambots.meta.exceptions.TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try{
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e){
            System.out.println("При иницилизация бота возникла ошибка: " + e);
        }
    }

}
