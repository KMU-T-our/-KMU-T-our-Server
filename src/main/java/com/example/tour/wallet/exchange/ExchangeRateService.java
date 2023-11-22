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

    public List<ExchangeRateResponse> callExchangeApi(String searchDate){

        // 가장 최근의 환율, 날짜
        ExchangeRate latestRate = resultCacheDeque.peekLast();
        List<ExchangeRateResponse> result;

        /* 앱 최초 실행 or 캐시에 정보 없는 경우 */
        if (latestRate == null) {
            result = getExchangeRate(searchDate);
        } else {
            List<ExchangeRateResponse> latestRateList = latestRate.getExchangeRateList();
            String latestDate = latestRate.getSearchDate();

            // 원하는 날짜의 환율 이미 캐시에 있는 경우
            if (searchDate.equals(latestDate)) {
                return latestRateList;
            }

            // 원하는 날짜의 환율 캐시에 없는 경우, API로부터 가져오기
            result = getExchangeRate(searchDate);

            // API 호출 실패하거나 결과가 없는 경우, 이전 날짜로 다시 시도
            while (result.isEmpty()) {
                LocalDate date = LocalDate.parse(searchDate);
                searchDate = date.minusDays(1).toString();
                result = getExchangeRate(searchDate);
            }
        }

        resultCacheDeque.addLast(new ExchangeRate(searchDate, result));
        if (resultCacheDeque.size() > 10) {
            resultCacheDeque.removeFirst();
        }
        return result;

    }

    private List<ExchangeRateResponse> getExchangeRate(String searchDate){
        HttpsURLConnection urlConnection = null;
        List<ExchangeRateResponse> result = null;
        try{
            // URL 형식이 잘못된 경우 MalformedURLException(IOException 의 하위 클래스)을 throw
            URL url = new URL(exchangeRateApi.getUrl(searchDate));

            // I/O 오류 발생시 IOException 발생
            urlConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = getNetworkConnection(urlConnection);
            ObjectMapper objectMapper = new ObjectMapper();

            result = Arrays.asList(objectMapper.readValue(readStreamToString(inputStream), ExchangeRateResponse[].class));

            if(inputStream != null) inputStream.close();

        } catch(IOException e){
            e.printStackTrace();
        } finally{
            if(urlConnection != null){
                urlConnection.disconnect();
            }
        }
        return result;
    }

    /* URLConnection을 전달받아 연결정보 설정 후 연결, 연결 후 수신한 InputStream 반환 */
    private InputStream getNetworkConnection(HttpsURLConnection urlConnection) throws IOException{
        // URLConnection 구성 : 타임아웃, 캐시, HTTP 요청 방법 등 client-server 간의 옵션 설정

        // setConnectTimeout : 연결이 설정 되기 전, 제한시간 만료되면 java.net.SocketTimeoutException 발생
        urlConnection.setConnectTimeout(3000);
        // setReadTimeout : 제한 시간이 만료되고, 연결의 입력 스트림에서 읽을 수 있는 데이터가 없으면 SocketTimeoutException 발생
        urlConnection.setReadTimeout(3000);
        // setRequestMethod : HTTP 메서드 GET을 URL 요청에 대한 메소드로 설정
        urlConnection.setRequestMethod("GET");
        // setDoInput : URLConnection을 서버에서 콘텐츠를 읽는 데 하용할 수 잇는지 여부를 설정
        urlConnection.setDoInput(true);

        if(urlConnection.getResponseCode() != HttpsURLConnection.HTTP_OK){
            throw new IOException("HTTPS error code : " + urlConnection.getResponseCode());
        }

        return urlConnection.getInputStream();
    }

    /* InputStream을 전달받아 문자열로 변환 후 반환 */
    private String readStreamToString(InputStream stream) throws IOException{
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

        String readLine;
        while((readLine = br.readLine()) != null){
            result.append(readLine + "\n\r");
        }
        br.close();

        return result.toString();
    }
}
