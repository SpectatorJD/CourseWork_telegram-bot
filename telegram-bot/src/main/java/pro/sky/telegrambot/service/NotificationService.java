package pro.sky.telegrambot.service;

import lombok.AllArgsConstructor;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.repository.NotificationTaskExecute;
import pro.sky.telegrambot.repository.NotificationTaskRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class NotificationService {
    NotificationTaskRepository notificationTaskRepository;
    static final Pattern pattern = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)");

    public void createNewTask(String message, long chatId) throws ParseException {
        NotificationTaskExecute notificationTask = this.parseTaskString(message);
        notificationTask.setChatId(chatId);
        notificationTaskRepository.save(notificationTask);
    }

    private NotificationTaskExecute parseTaskString(String message) throws ParseException {
        Matcher matcher = pattern.matcher(message);
        if (!matcher.matches()) {
            throw new RuntimeException("Нет соответствия шаблону! ");
        }
        NotificationTaskExecute notificationTask = new NotificationTaskExecute();
        notificationTask.setDateSendNotification(Timestamp.valueOf(LocalDateTime.parse(matcher.group(1), DateTimeFormatter.ISO_DATE)));
        notificationTask.setNotification(matcher.group(3));
        return notificationTask;
    }
}
