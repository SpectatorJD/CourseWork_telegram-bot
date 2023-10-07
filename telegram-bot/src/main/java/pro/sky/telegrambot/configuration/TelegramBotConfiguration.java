package pro.sky.telegrambot.configuration;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class TelegramBotConfiguration {
    @Value("6525722850:AAFYXa-JL3cnu6tYyx_NNXCXn9HsBs0EQN8")
    private String token;
    @Value("My_course_work_by_skypro_bot")
    private String botName;

}
