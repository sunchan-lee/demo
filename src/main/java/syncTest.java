import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;

//테스트
public class syncTest {

    //키값 
    private static final String accessKey = "gIqC4VCzEMPOdHPRlrJn";  //NCP 인증키 (서브)
    private static final String secretKey = "fK1THw3U42JS83GdRfcNWsrF5I19rZXHOvwB5uim";  //NCP 비밀키 (서브)
    private static String apiDomain = "https://workplace.apigw.ntruss.com";  //api 주소 앞단
    private static String companyId = "72fe2107-30bd-48ed-ada4-f06083599921"; // 회사 아이디 (서브)
    private static String apiServer_Post_Department = "/organization/apigw/v2/company/"+companyId+"/department/"+"1052"; //부서

    public static String post_department() throws Exception{
         // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
         String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
         String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Post_Department, "POST", timestamp);
    
        // 헤더 설정
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
        requestHeaders.put("x-ncp-iam-access-key", accessKey);
        requestHeaders.put("x-ncp-apigw-signature-v2", signature);
        requestHeaders.put("Content-Type", "application/json;charset=utf-8");

        //다국어명 부분
        Map<String, String> i18nNames = new HashMap<>();
        i18nNames.put("ko_KR", "인사혁신팀");
        i18nNames.put("en_US", "HR");

        // RequsetBody 구간 (요청 Body 파라미터) 필수 항목만 
        Map<String, String> requestBodyMap = new LinkedHashMap<>();
        requestBodyMap.put("name", "인사혁신팀"); //
        requestBodyMap.put("i18nNames", "i18nNames"); //
        requestBodyMap.put("deptExternalKey", "1052"); //
        requestBodyMap.put("parentDeptExternalKey", "1004"); //
        requestBodyMap.put("deptEmailAddress", "sample123@mactest.co.kr"); //
        //requestBodyMap.put("externalEmailReceiveYn", false); //
        requestBodyMap.put("dispOrd", "17"); //

        // 결과 변환
        Gson gson = new Gson();
        String requestBody = gson.toJson(requestBodyMap);
        
        // api 호출
        String responseBody = ApiUtil.post(apiDomain + apiServer_Post_Department, requestHeaders, requestBody);
        System.out.println();
        System.out.println("responseBody 값 : " + responseBody);
        System.out.println();
        System.out.println("requestHeaders 값 : " + requestHeaders);
        System.out.println();
        System.out.println("signature 값 : " + signature);
        System.out.println();
        System.out.println("requestBody 값 : " + requestBody);
        System.out.println();

         return requestBody;
    }

    //실행
    public static void main(String[] args) throws Exception {
        post_department();
    }
    
}
