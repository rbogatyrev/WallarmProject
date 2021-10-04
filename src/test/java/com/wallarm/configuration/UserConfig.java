package com.wallarm.configuration;

import org.aeonbits.owner.Config;

public interface UserConfig extends Config {

    @DefaultValue("wal%s@mailinator.com")
    @Key("mailinator.template")
    String mailinatorTemplate();

    @DefaultValue("wal%s@yandex2.ru")
    @Key("yandex.template")
    String yandexTemplate();


}
