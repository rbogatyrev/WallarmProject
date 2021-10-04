package com.wallarm.enums;

public enum Locals implements IEnumValue {
    WALLARM_SIGNUP_WELCOME_EN("Welcome to Wallarm!"),
    WALLARM_EMAIL_CONFIRMATION_SUBJECT_EN("[Wallarm] Activate your Wallarm WAF account"),
    WALLARM_THANKS_FOR_FILLING_FORM_MESSAGE_RU("Спасибо, что заполнили форму! Мы уже отправили документ на ваш почтовый ящик."),
    WALLARM_REQUEST_SENT_MESSAGE("Заявка принята, спасибо!"),
    WALLARM_DOCSPAGE_TITLE_RU("Документация Валарм");


    private String translation;

    Locals(String translation) {
        this.translation = translation;
    }

    @Override
    public String getValue() {
        return translation;
    }
}
