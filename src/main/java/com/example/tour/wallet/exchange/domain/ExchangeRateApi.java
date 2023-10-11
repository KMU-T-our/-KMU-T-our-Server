package com.example.tour.wallet.exchange.domain;

public class ExchangeRateApi {
    private final String authKey = "w1rFjNClOwszKPrkvE1yKayBxOauuN6L";
    private final String requestUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
    private final String dataType = "AP01";

    public String getUrl(String searchDate){
        String urlStr = requestUrl + "?authkey=" + authKey + "&data=" + dataType;

        if(searchDate != null) {
            urlStr += "&searchdate=" + searchDate;
        }

        return urlStr;
    }
}
