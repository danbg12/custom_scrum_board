## [REST API](http://localhost:8080/doc)

ДЛЯ ЗАПУСКА ПРОЕКТА НУЖНО СОЗДАТЬ В КОРНЕ ПРОЕКТА ФАЙЛ `.env` С СЛЕДУЮЩИМ СОДЕРЖИМОМ:

DB_URL= урл для подключения к бд\
DB_USERNAME= имя пользователя для подключения к бд\
DB_PASSWORD= пароль для подключения к бд\
GH_CLINET_ID= гтх id для подключения к github\
GH_CLIENT_SECRET= пароль для подключения к github\
GOOGLE_CLIENT_ID= идентификатор клиента для подключения к google\
GOOGLE_CLIENT_SECRET= пароль для подключения к google\
GITLAB_CLIENT_ID= гитлаб id для подключения к gitlab\
GITLAB_CLIENT_SECRET= пароль для подключения к gitlab\
MAIL_HOST= хост для почты\
MAIL_USERNAME= логин для почты\
MAIL_PASSWORD= пароль для почты

Библиотека `dotenv-java` автоматически загрузит эти переменные окружения при запуске приложения.

## Концепция:

- Spring Modulith
    - [Spring Modulith: достигли ли мы зрелости модульности](https://habr.com/ru/post/701984/)
    - [Introducing Spring Modulith](https://spring.io/blog/2022/10/21/introducing-spring-modulith)
    - [Spring Modulith - Reference documentation](https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/)

```
  url: jdbc:postgresql://localhost:5432/jira
  username: jira
  password: JiraRush
```

- Есть 2 общие таблицы, на которых не fk
    - _Reference_ - справочник. Связь делаем по _code_ (по id нельзя, тк id привязано к окружению-конкретной базе)
    - _UserBelong_ - привязка юзеров с типом (owner, lead, ...) к объекту (таска, проект, спринт, ...). FK вручную будем
      проверять

## Аналоги

- https://java-source.net/open-source/issue-trackers

## Тестирование

- https://habr.com/ru/articles/259055/

Список выполненных задач:\

Удалить социальные сети: vk, yandex.

Вынести чувствительную информацию в отдельный проперти файл:
    логин\
    пароль БД\
    идентификаторы для OAuth регистрации/авторизации\
    настройки почты

Сделать рефакторинг метода com.javarush.jira.bugtracking.attachment.FileUtil#upload чтоб он использовал современный подход для работы с файловой системмой. 
