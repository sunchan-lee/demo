import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class sync {

        //자주 쓰는 값들 저장
        private static final String accessKey = "pyMqSv2G7efrPyuaK3Sn";  //NCP 인증키
        private static final String secretKey = "LmppNgYHhAwO5iEOhy6lS8AcRzzdwxYAN5vVvi6E";  //NCP 비밀키
        private static String apiDomain = "https://workplace.apigw.ntruss.com";  //api 주소 앞단
        private static String companyId = "befbe577-7124-43d5-b75d-aab42d78023c"; // 회사 아이디
        private static String externalKey = "3001b183-3bae-46e9-a79c-0660732adacb"; // dev 계정 사원 외부키
    
        //조직연동 조회 GET
        private static String apiServer_Get_PlaceBiz = "/organization/apigw/v1/company/"+companyId+"/placebiz"; //사업장
        private static String apiServer_Get_EmpType = "/organization/apigw/v2/company/"+companyId+"/empType"; //고용형태
        private static String apiServer_Get_Grade = "/organization/apigw/v2/company/"+companyId+"/grade"; //직급
        private static String apiServer_Get_Job = "/organization/apigw/v2/company/"+companyId+"/job"; //직책
        private static String apiServer_Get_Company = "/organization/apigw/v2/company/"+companyId+"/department"; //부서
        private static String apiServer_Get_Emp = "/organization/apigw/v2/company/"+companyId+"/employee"; //사원
        private static String apiServer_Get_Addattr = ""; //추가정보
    
        //조직연동 POST
        //조직연동 PUT
        //조직연동 DELETE

        //사업장 GET 항목
        public static String placebiz() throws Exception{
            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Get_PlaceBiz, "GET", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v1", signature);

            // api 호출
            String responseBody = ApiUtil.get(apiDomain + apiServer_Get_PlaceBiz, requestHeaders);
            System.out.println("responseBody 값 : " + responseBody);
            System.out.println("requestHeaders 값 : " + requestHeaders);
            System.out.println("signature 값 : " + signature);

            // 결과 변환
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, Map.class);

            return responseBody;
        }

        //고용형태 GET 항목
        public static String empType() throws Exception{
            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Get_EmpType, "GET", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v2", signature);

            // api 호출
            String responseBody = ApiUtil.get(apiDomain + apiServer_Get_EmpType, requestHeaders);
            System.out.println("responseBody 값 : " + responseBody);
            System.out.println("requestHeaders 값 : " + requestHeaders);
            System.out.println("signature 값 : " + signature);

            // 결과 변환
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, Map.class);

            return responseBody;
        }




        public static void main(String[] args) throws Exception {
            placebiz();
        }


}
