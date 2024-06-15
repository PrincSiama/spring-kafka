<h1 align="center">Kafka</h1>

<h3 align="center">Система мониторинга с использованием Spring Boot и Apache Kafka</h3>

Система состоит из двух модулей: metrics-producer и metrics-consumer.

Микросервис metrics-producer запущен на порту 8080 и отправляет метрики в формате Json в Kafka в топик "metrics-topic".

Микросервис metrics-consumer запущен на порту 8000 и принимает метрики из топика "metrics-topic" и сохраняет в базу данных Postgres.

Для запуска сервера Kafka использован docker-compose. 
Запуск Kafka предусмотрен без сервера Zookeeper с использованием протокола KRaft. 

Для подключения своей базы данных необходимо обновить параметры в application.properties. 

В metrics-consumer реализован REST API для работы с метриками.

Документация API создана с использованием swagger и представлена по ссылкам:
http://localhost:8000/swagger-ui/index.html#/ и http://localhost:8080/swagger-ui/index.html#/

Для тестирования сервиса можно использовать приложенную Postman-коллекцию.

Хронология запуска:
1. Запускаем Kafka из docker-compose.yml
2. Запускаем MetricsProducerApplication для создания топика
3. Запускаем MetricsConsumerApplication