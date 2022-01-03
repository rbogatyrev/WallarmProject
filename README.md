<div class="row" align="right">
  <a href="/README.md"><img src="images/RU.png" title ="Switch to Russian"></a>
 <a href="/README_EN.md"><img src="images/EN.png" title ="Switch to English"></a>
</div>

# <p align="center"> <img src="images/Wallarm.png" width="100" height="70">  Автотесты для сайта [платформы по защите веб-приложений и API Валарм](https://www.wallarm.ru/) </p>
___
##  <p align="center"> Используемые технологии и инструменты </p>
| IntelliJ IDEA | Gradle | Java | Junit5 | Selenide | Selenoid | Jenkins | Allure Report | Allure TestOps | Telegram (notifications) |
|:------:|:----:|:----:|:------:|:------:|:--------:|:--------:|:-------------:|:---------:|:-------:|
| <img src="images/Intellij.svg" width="40" height="40"> | <img src="images/Gradle.svg" width="40" height="40"> | <img src="images/Java.svg" width="40" height="40"> | <img src="images/Junit5.svg" width="40" height="40"> | <img src="images/Selenide.svg" width="40" height="40"> | <img src="images/Selenoid.svg" width="40" height="40"> | <img src="images/Jenkins.svg" width="40" height="40"> | <img src="images/Allure Report.svg" width="40" height="40"> | <img src="images/Allure TestOps.svg" width="40" height="40"> | <img src="images/Telegram.svg" width="40" height="40"> |

___
## Реализованы следующие тестовые сценарии:

1. Регистрация нового пользователя Wallarm с переходом в ЛК из письма-подтверждения
2. Отправка вопроса поддержке с сайта 
3. Проверка получения сообщения об отправке методологии на указанный емейл после ее скачивания "Услуги"
4. Отправка с сайта заявки на становление партнером Wallarm
5. Переход на страницу документации с сайта
6. **(Parameterized)** Переход на страницу с историей успеха 
7. **(Parameterized)** Проверка получения сообщения об отправке инфографики на указанный емейл после ее скачивания 
* Parameterized - параметризованный тест для возможности проверки одного сценария с разными входными данными

___

## Пример прохождения теста в среде [**Selenoid**](https://selenoid.autotests.cloud/#/)
![Selenoid](images/SelenoidVideo.gif)

___

## Запуск в [**Jenkins**](https://jenkins.autotests.cloud/job/WallarmJob/build?delay=0sec)
Для запуска сборки необходимо указать следующие параметры:
![RunParameters](images/JenkinsBuildStart.jpg)
* **THREAD_NUMBER** - Число одновременных потоков, в которых будут запущены тесты. Для запуска тестов в одном потоке поле заполнять не нужно
* **CHROME_VERSION** - Версия хрома в среде Selenoid
* **REMOTE_DRIVER_URL** - адрес хоста Selenoid

После завершения выполнения сборки будет сформирован Allure-отчет, при переходе в который отобразится результат выполнения всех тестовых сценариев.
![BuildFinished](images/JenkinsBuildFinished.jpg)

Для получения более детальной информации необходимо нажать на интересующий тестовый сценарий. В появившейся вкладке отобразятся шаги выполнения теста и также будет прикреплено видео с его прохождением, а в случае если тест завершился падением, то дополнительно будет прикреплен скриншот и лог из консоли браузера.

![TestSuccess](images/AllureResult.png)
![TestFailed](images/AllureFailResult.png)

___
## Telegram-оповещения
После завершения выполнения сборки будет отправлено оповещение в предварительно настроенный telegram-канал с результатами прохождения тестов

![TelegramBot](images/TelegramNot.jpg)

