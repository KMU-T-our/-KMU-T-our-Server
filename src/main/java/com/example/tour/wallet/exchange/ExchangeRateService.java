package com.example.tour.wallet.exchange;

import com.example.tour.wallet.exchange.domain.ExchangeRate;
import com.example.tour.wallet.exchange.domain.ExchangeRateApi;
import com.example.tour.wallet.exchange.dto.ExchangeRateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ExchangeRateApi exchangeRateApi ;
    private final Deque<ExchangeRate> resultCacheDeque = new ArrayDeque<>();
    private static final int MAX_CACHE_SIZE = 10;

    public List<ExchangeRateResponse> getExchangeRate(String searchDate) {

        ExchangeRate latestRate = resultCacheDeque.peekLast();

        if (latestRate == null || !searchDate.equals(latestRate.getSearchDate())) {
            List<ExchangeRateResponse> result = callExchangeRateApi(searchDate);

            while (result.isEmpty()) {
                LocalDate date = LocalDate.parse(searchDate);
                searchDate = date.minusDays(1).toString();
                result = callExchangeRateApi(searchDate);
            }

            cacheExchangeRate(searchDate, result);
            return result;
        }

        return latestRate.getExchangeRateList();
    }

    private void cacheExchangeRate(String searchDate, List<ExchangeRateResponse> result) {
        resultCacheDeque.addLast(new ExchangeRate(searchDate, result));
        if (resultCacheDeque.size() > MAX_CACHE_SIZE) {
            resultCacheDeque.removeFirst();
        }
    }

    private List<ExchangeRateResponse> callExchangeRateApi(String searchDate){
        try {
            URL url = new URL(exchangeRateApi.getUrl(searchDate));
            HttpsURLConnection urlConnection = setupUrlConnection(url);

            if (urlConnection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                throw new IOException("HTTPS error code : " + urlConnection.getResponseCode());
            }

            try (InputStream inputStream = urlConnection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
                ObjectMapper objectMapper = new ObjectMapper();
                return Arrays.asList(objectMapper.readValue(readStreamToString(br), ExchangeRateResponse[].class));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    private HttpsURLConnection setupUrlConnection(URL url) throws IOException {
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setConnectTimeout(3000);
        urlConnection.setReadTimeout(3000);
        urlConnection.setRequestMethod("GET");
        urlConnection.setDoInput(true);
        return urlConnection;
    }

    private String readStreamToString(BufferedReader reader) throws IOException {
        StringBuilder result = new StringBuilder();
        String readLine;
        while ((readLine = reader.readLine()) != null) {
            result.append(readLine).append("\n\r");
        }
        return result.toString();
    }
}
