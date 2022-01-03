package com.wallarm.enums;

import lombok.Getter;

@Getter
public enum SuccessCase {
    BANK131("/walarm-i-bank-131","Валарм и Банк 131: NG WAF как превентивная защита приложений и API"),
    QIWI("/walarm-waf-i-qiwi", "Валарм WAF и QIWI: 7 лет эффективной защиты приложений"),
    BKS("/walarm-waf-i-bks", "Валарм & БКС: решение класса WAF на страже цифровой инфраструктуры лидера финрынка"),
    SEMRUSH("/walarm-i-semrush","Semrush: уверенное и безопасное развитие SEO-бизнеса"),
    RAMBLER("/walarm-i-rambler", "Валарм WAF: обязательный инструмент безопасности приложений Рамблер"),
    XSOLLA("/walarm-waf-i-xsolla", "Xsolla и миллионы защищенных платформой Wallarm микротранзакций"),
    SBER_AUTO("/walarm-i-sberavto", "Валарм: Гибкая и эффективная защита API для СберАвто");


private String urlPart;
private String headerMessage;

SuccessCase(String url, String headerMessage){
    this.urlPart = url;
    this.headerMessage = headerMessage;
}

}
