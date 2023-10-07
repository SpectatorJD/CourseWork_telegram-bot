package pro.sky.telegrambot.components;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import pro.sky.telegrambot.configuration.TelegramBotConfiguration;
import pro.sky.telegrambot.service.NotificationService;

import java.util.List;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final NotificationService notificationService;

    private final TelegramBotConfiguration telegramBotConfiguration;

    final static String taskInfoTest = "Чтобы создать напоминания  введите дату и время в формате: ДД.ММ.ГГГГ ЧЧ:ММ текст задачи." + "\n"
            + "Пример напоминания: 01.01.2022 20:00 Сделать домашнюю работу!";


    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
