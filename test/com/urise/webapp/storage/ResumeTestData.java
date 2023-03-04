package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.util.HashMap;
import java.util.Map;


public class ResumeTestData {
    private static final TextBlock objective = new TextBlock(SectionType.OBJECTIVE,
            "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
    private static final TextBlock personal = new TextBlock(SectionType.PERSONAL,
            "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
    private static final String[] achievementsData = {
            "Организация команды и успешная реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке " +
                    "Spring Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в " +
                    "проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
            "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. " +
                    "Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." +
                    " Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
            "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio," +
                    " DuoSecurity, Google Authenticator, Jira, Zendesk.",
            "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM," +
                    " CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка" +
                    " SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
            "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, " +
                    "ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
            "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, " +
                    "JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга " +
                    "Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
            "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, " +
                    "Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
    };

    private static final String[] qualificationsData = {
            "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
            "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
            "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL, HSQLDB",
            "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
            "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
            "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring " +
                    "(MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT)," +
                    " Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
            "Python: Django.",
            "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
            "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
            "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, " +
                    "JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
            "Инструменты: Maven + plugin development, Gradle, настройка Ngnix",
            "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis," +
                    " Bonita, pgBouncer",
            "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML," +
                    " функционального программирования",
            "Родной русский, английский \"upper intermediate\""
    };
    private static final ContactsBlock contacts = new ContactsBlock(
            "+7(921) 855-0482",
            new Link("skype:skype:grigory.kislin", "skype:grigory.kislin"),
            new Link("mailto:gkislin@yandex.ru", "gkislin@yandex.ru"),
            new Link("https://www.linkedin.com/in/gkislin", ContactsType.LINKED_IN),
            new Link("https://github.com/gkislin", ContactsType.GITHUB),
            new Link("https://stackoverflow.com/users/548473", ContactsType.STACK_OVERFLOW),
            new Link("http://gkislin.ru/", ContactsType.HOME_PAGE)
    );

    private static final ListBlock achievement = new ListBlock(SectionType.ACHIEVEMENT, achievementsData);
    private static final ListBlock qualifications = new ListBlock(SectionType.QUALIFICATIONS, qualificationsData);

    public static void main(String[] args) {
        Resume r = new Resume("Григорий Кислин", contacts, personal, objective, achievement, qualifications,
                getExperience(), getEducation());
        System.out.println(r.toString());

    }


    private static Map<String, Object> getExperience() {
        final Map<String, Object> experience = new HashMap<>();
        experience.put("Java Online Projects", new ExtraInfoBlock("10/2013", "Автор проекта.",
                "javaops.ru", "Создание, организация и проведение Java онлайн проектов и стажировок."));
        experience.put("Wrike", new ExtraInfoBlock("10/2014", "01/2016", "Старший разработчик (backend)",
                "www.wrike.com", "Проектирование и разработка онлайн платформы управления проектами Wrike" +
                " (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация," +
                " авторизация по OAuth1, OAuth2, JWT SSO."));
        experience.put("RIT Center", new ExtraInfoBlock("04/2012", "10/2014", "Java архитектор", null,
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование," +
                        " ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx)," +
                        " AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS," +
                        " BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). " +
                        "Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + " +
                        "plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, " +
                        "OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        experience.put("Luxoft (Deutsche Bank)", new ExtraInfoBlock("12/2010", "04/2012",
                "Ведущий программист", "luxoft.ru", "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate," +
                " Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация " +
                "RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического " +
                "трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        experience.put("Yota", new ExtraInfoBlock("03/2007", "06/2008", "Ведущий специалист", "yota.ru",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей " +
                        "кластерного J2EE приложения (OLAP, Data mining).)"));
        experience.put("Enkata", new ExtraInfoBlock("10/2014", "01/2016", "Разработчик ПО", "enkata.com",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, " +
                        "MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1," +
                        " OAuth2, JWT SSO."));
        experience.put("Siemens AG", new ExtraInfoBlock("01/2005", "02/2007", "Разработчик ПО",
                "siemens.com/ru/ru/home.html", "Разработка информационной модели, проектирование интерфейсов," +
                " реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        experience.put("Alcatel", new ExtraInfoBlock("09/1997", "01/2005",
                "Инженер по аппаратному и программному тестированию", "alcatel.ru",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        return experience;
    }

    private static Map<String, Object> getEducation() {
        final Map<String, Object> education = new HashMap<>();
        education.put("Coursera", new BaseInfoBlock("03/2013", "05/2013",
                "coursera.org/course/progfun", "'Functional Programming Principles in Scala' by Martin Odersky"));
        education.put("Luxoft", new BaseInfoBlock("03/2011", "04/2011",
                "luxoft-training.ru/training/catalog/course.html?ID=22366",
                "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML."));
        education.put("Siemens AG", new BaseInfoBlock("01/2005", "04/2005", "siemens.ru",
                "3 месяца обучения мобильным IN сетям (Берлин)"));
        education.put("Alcatel", new BaseInfoBlock("09/1997", "03/1998", "alcatel.ru",
                "6 месяцев обучения цифровым телефонным сетям (Москва)"));
        education.put("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                new BaseInfoBlock[]{
                        new BaseInfoBlock("09/1993", "07/1996", "ifmo.ru", "Аспирантура (программист С, С++)"),
                        new BaseInfoBlock("09/1987", "07/1993", "ifmo.ru", "Инженер (программист Fortran, C)")
                }
        );
        education.put("Заочная физико-техническая школа при МФТИ", new BaseInfoBlock("09/1984", "06/1987",
                "mipt.ru", "Закончил с отличием"));
        return education;
    }
}
