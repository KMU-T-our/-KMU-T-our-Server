package com.example.tour.wallet.exchange;

import com.example.tour.wallet.exchange.dto.ExchangeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class ExchangeController {
    /* configuration 값 : 외부로 유출되면 안 되는 값, 고정된 값은 property로 관리
    // authKey : 발급 받은 api key, 보안 필요
    @Value("${ExchangeApi.authkey}")
    private String authKey;

    // callBackUrl : Request URL로 고정
    @Value("${ExchangeApi.callBackUrl")
    private String callBackUrl;

    // dataType : APO1 (환율) 로 고정
    @Value("${ExchangeApi.datatype")
    private String dataType;
    */
    private final String authKey = "w1rFjNClOwszKPrkvE1yKayBxOauuN6L";
    private final String requestUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
    private final String dataType = "AP01";

    @GetMapping("/api/exchange")
    public List<ExchangeResponse> callExchangeApi(
            // searchDate : 검색 요청 날짜, 요청에 따라 변하는 값
            // DEFAULT는 현재일 -> 처리 하는 방법 추가하기
            @RequestParam(value="searchDate", required = false) String searchDate
    ){

        // HttpsURLConnection : Java 애플리케이션과 URL 간의 연결에 대한 API 제공
        HttpsURLConnection urlConnection = null;
        // input 받는 거 수정해야 함
        InputStream inputStream = null;
        String resultString = null;
        List<ExchangeResponse> result = null;
        String urlStr = requestUrl + "?authkey=" + authKey + "&data=" + dataType;;
        if(searchDate != null) {
            urlStr += "&searchdate=" + searchDate;
        }

        try{
            // URL 형식이 잘못된 경우 MalformedURLException(IOExeption의 하위 클래스)을 throw
            URL url = new URL(urlStr);

            // I/O 오류 발생시 IOEXception 발생시킴
            urlConnection = (HttpsURLConnection) url.openConnection();
            inputStream = getNetworkConnection(urlConnection);
            resultString = readStreamToString(inputStream);
            ObjectMapper objectMapper = new ObjectMapper();
            result = Arrays.asList(objectMapper.readValue(resultString, ExchangeResponse[].class));

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

    // 수정 필요
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
