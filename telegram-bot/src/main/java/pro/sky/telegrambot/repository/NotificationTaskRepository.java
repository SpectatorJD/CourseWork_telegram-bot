package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface NotificationTaskRepository extends JpaRepository<NotificationTaskExecute, BigInteger> {
}
