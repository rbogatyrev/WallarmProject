package com.wallarm.tests;

import com.wallarm.enums.Infographics;
import com.wallarm.enums.SuccessCase;

import java.util.stream.Stream;

public class TestDataProvider {

    static Stream<SuccessCase> getSuccessCasesData() {
        SuccessCase firstCase = SuccessCase.BANK131;
        SuccessCase secondCase = SuccessCase.QIWI;
        SuccessCase thirdCase = SuccessCase.BKS;
        SuccessCase fourthCase = SuccessCase.SEMRUSH;
        SuccessCase fifthCase = SuccessCase.RAMBLER;
        SuccessCase sixthCase = SuccessCase.XSOLLA;
        SuccessCase seventhCase = SuccessCase.SBER_AUTO;

        return Stream.of(firstCase, secondCase, thirdCase, fourthCase, fifthCase, sixthCase, seventhCase);
    }

    static Stream<Infographics> getInfographicsData() {
        Infographics firstInfo = Infographics.RUSSIAN_COMPANIES_CYBER_RISKS;
        Infographics secondInfo = Infographics.FINTECH_COMPANIES_INFOSECURITY;

        return Stream.of(firstInfo, secondInfo);
    }


}
