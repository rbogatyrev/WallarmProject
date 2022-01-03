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
        Infographics firstInfo = Infographics.WAF_AND_API_PROTECTION;
        Infographics secondInfo = Infographics.WALLARM_AI_ENGINE;

        return Stream.of(firstInfo, secondInfo);
    }


}
