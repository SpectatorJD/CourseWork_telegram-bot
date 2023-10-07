package pro.sky.telegrambot.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.components.TelegramBot;
import pro.sky.telegrambot.repository.NotificationTaskRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SchedulerNotification {
    TelegramBot bot;
    NotificationTaskRepository notificationTaskRepository;

    @Scheduled(cron = "0 0/1 * * * *")
    public void sendNotification () {
        notificationTaskRepository.findAll()
                .stream().filter(t -> t.getDateSendNotification().toLocalDateTime().isEqual(
                        LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES))
                ).collect(Collectors.toList())
                .forEach(t -> bot.sendMessage(t.getChatId(), "Напоминаю: " + t.getNotification()));
    }
}

