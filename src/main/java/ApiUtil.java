import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

// GET, POST 등등 요청하는 항목

public class ApiUtil {

    public static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        
        //예외처리
        try{
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setDoInput(true);

            // 키앤 밸류 값
            for(Map.Entry<String, String> header :requestHeaders.entrySet()){
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            //responsecode = 응답코드
            int responseCode = con.getResponseCode();
            
            //응답코드가 httpURLConnection 이랑 일치하면
            //진행, 틀리다면 에러를 반환
            if(responseCode == HttpURLConnection.HTTP_OK){
                return readBody(con.getInputStream());
            }else{
                return readBody(con.getErrorStream());
            }
        //예외처리 발생시 아래 메시지를 반환
        }catch (IOException e){
            throw new RuntimeException("API 요청 및 응답 예외 발생 : ", e);
        }
        //성공 및 예외처리 발생 상관없이 진행되는 작업
        //연결 끊기
        finally{
            con.disconnect();
        }
    }

    //post section
    public static String post(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
        HttpURLConnection con = connect(apiUrl);

        try {
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);

            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestBody.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readBody(con.getInputStream());
            } else {
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청/응답 예외 발생", e);
        } finally {
            con.disconnect();
        }
    }

        //put section
        public static String put(String apiUrl, Map<String, String> requestHeaders, String requestBody) {
            HttpURLConnection con = connect(apiUrl);
    
            //예외처리
            try {
                con.setRequestMethod("PUT");
                con.setDoOutput(true);
                con.setDoInput(true);
    
                for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                    con.setRequestProperty(header.getKey(), header.getValue());
                }
    
                //
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.write(requestBody.getBytes());
                    wr.flush();
                }
    
                //응답코드가 httpURLConnection 이랑 일치하면
                //진행, 틀리다면 에러를 반환
                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    return readBody(con.getInputStream());
                } else {
                    return readBody(con.getErrorStream());
                }
            } catch (IOException e) {         //예외처리 발생시 아래 메시지를 반환
                throw new RuntimeException("API 요청/응답 예외 발생", e);
            } finally 
            {
            //성공 및 예외처리 발생 상관없이 진행되는 작업
            //연결 끊기
                con.disconnect();
            }
        }


    public static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답 읽기 실패 : ", e);
        }
    }


    //connect 메소드 생성
    public static HttpURLConnection connect(String apiUrl) {
        try{
            URL url = new URL(apiUrl);                      //해당 url로 연결 시도
            return (HttpURLConnection)url.openConnection();
        } catch (IOException e){                            //예외처리시 연결실패 메시지 반환
            throw new RuntimeException("연결실패 : ", e);
        }
    }

    //요청에 맞게 StringToSign을 생성하고 SecretKey로 HmacSHA256 알고리즘으로 암호화한 후 Base64로 인코딩합니다.
    public static String makeSignature(String accessKey, String secretKey,  String url, String method, String timestamp) throws Exception{
        String space = " ";      //one space
        String newLine = "\n";  //개행문자는 \n을 사용합니다. , new line

        //String accessKey = "027E03DA7D7A9D9DD8DB"; // sub account 에서 발급받을수 있는 키
       // String secretKey = "5D5E47D6DDABAB4E566C56BB44E59B3B14DF408A"; // sub account 에서 발급받을수 있는 키 
       // String url = "GET/organization/apigw/v2/company/befbe577-7124-43d5-b75d-aab42d78023c/department?offset=0&limit=10";        //url 주소
        //String method = "GET";     // get, post 방식
       // String timestamp = "{timestamp}"; // 시간 관련

        //api 주소 빌더
        String message = new StringBuilder()
            .append(method)
            .append(space)
            .append(url)
            .append(newLine)
            .append(timestamp)
            .append(newLine)
            .append(accessKey)
            .toString();
            
            //암호화 과정 -> HmacSHA256
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);
    
            //인코딩 과정 -> Base64로
            byte[] rawHmac = mac.doFinal(message.getBytes("UTF-8"));
            String encodeBase64String = Base64.encodeBase64String(rawHmac);
            //apache commons codec 디펜던시 추가해야함
    
            //Base64로 인코딩 한것을 반환
            return encodeBase64String;
    }
    
    















    




    
    
}
