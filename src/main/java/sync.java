import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class sync {

        //자주 쓰는 값들 저장
        //private static final String accessKey = "pyMqSv2G7efrPyuaK3Sn";  //NCP 인증키 (맥플러스)
        private static final String accessKey = "gIqC4VCzEMPOdHPRlrJn";  //NCP 인증키 (서브)
        //private static final String accessKey = "2C568D35BE126508819B";  //NCP 인증키 (서브)


        //private static final String secretKey = "LmppNgYHhAwO5iEOhy6lS8AcRzzdwxYAN5vVvi6E";  //NCP 비밀키 (맥플러스)
        private static final String secretKey = "fK1THw3U42JS83GdRfcNWsrF5I19rZXHOvwB5uim";  //NCP 비밀키 (서브)
        //private static final String secretKey = "5FBD470FC8380902DABB2D427C4704F6D1E2E502";  //NCP 비밀키 (서브)


        private static String apiDomain = "https://workplace.apigw.ntruss.com";  //api 주소 앞단

        //private static String companyId = "befbe577-7124-43d5-b75d-aab42d78023c"; // 회사 아이디 (맥플러스)
        private static String companyId = "72fe2107-30bd-48ed-ada4-f06083599921"; // 회사 아이디 (서브)

        //private static String externalKey = "3001b183-3bae-46e9-a79c-0660732adacb"; // dev 계정 사원 외부키
        private static String externalKey = "EMP002"; //서브 외부키
    
        //조직연동 조회 GET
        private static String apiServer_Get_PlaceBiz = "/organization/apigw/v1/company/"+companyId+"/placebiz/"; //사업장
        private static String apiServer_Get_EmpType = "/organization/apigw/v2/company/"+companyId+"/empType"; //고용형태
        private static String apiServer_Get_Grade = "/organization/apigw/v2/company/"+companyId+"/grade"; //직급
        private static String apiServer_Get_Job = "/organization/apigw/v2/company/"+companyId+"/job"; //직책
        private static String apiServer_Get_Department = "/organization/apigw/v2/company/"+companyId+"/department"; //부서
        private static String apiServer_Get_Emp = "/organization/apigw/v2/company/"+companyId+"/employee"; //사원
        //private static String apiServer_Get_Addattr = ""; //추가정보   테스트
    
        //조직연동 POST
        private static String apiServer_Post_PlaceBiz = "/organization/apigw/v1/company/"+companyId+"/placebiz/"+externalKey; //사업장
        private static String apiServer_Post_EmpType = "/organization/apigw/v2/company/"+companyId+"/empType"; //고용형태
        private static String apiServer_Post_Grade = "/organization/apigw/v2/company/"+companyId+"/grade"; //직급
        private static String apiServer_Post_Job = "/organization/apigw/v2/company/"+companyId+"/job"; //직책
        private static String apiServer_Post_Department = "/organization/apigw/v2/company/"+companyId+"/department"; //부서
        private static String apiServer_Post_Emp = "/organization/apigw/v2/company/"+companyId+"/employee"; //사원
        //private static String apiServer_Post_Addattr = ""; //추가정보   테스트


        //조직연동 PUT
        //조직연동 DELETE

        /* 
         * 
         * 
         * GET 항목 메서드
         * 
         * 
        */
        //사업장 GET 항목
        public static String get_placebiz() throws Exception{
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
        public static String get_empType() throws Exception{
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

        //직급 GET
        public static String get_job() throws Exception{
            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Get_Job, "GET", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v2", signature);

            // api 호출
            String responseBody = ApiUtil.get(apiDomain + apiServer_Get_Job, requestHeaders);
            System.out.println("responseBody 값 : " + responseBody);
            System.out.println("requestHeaders 값 : " + requestHeaders);
            System.out.println("signature 값 : " + signature);

            // 결과 변환
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, Map.class);

            return responseBody;
        }
        
        // 직책 GET
        public static String get_grade() throws Exception{
            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Get_Grade, "GET", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v2", signature);

            // api 호출
            String responseBody = ApiUtil.get(apiDomain + apiServer_Get_Grade, requestHeaders);
            System.out.println("responseBody 값 : " + responseBody);
            System.out.println("requestHeaders 값 : " + requestHeaders);
            System.out.println("signature 값 : " + signature);

            // 결과 변환
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, Map.class);

            return responseBody;
        }

        // 부서 GET apiServer_Get_Department
        public static String get_department() throws Exception{
            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Get_Department, "GET", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v2", signature);

            // api 호출
            String responseBody = ApiUtil.get(apiDomain + apiServer_Get_Department, requestHeaders);
            System.out.println("responseBody 값 : " + responseBody);
            System.out.println("requestHeaders 값 : " + requestHeaders);
            System.out.println("signature 값 : " + signature);

            // 결과 변환
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, Map.class);

            return responseBody;
        }

        // 사원 GET apiServer_Get_Emp
        public static String get_emp() throws Exception{

            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Get_Emp, "GET", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v2", signature);
            requestHeaders.put("Content-Type", "application/x-www-form-urlencoded");



            // api 호출
            String responseBody = ApiUtil.get(apiDomain + apiServer_Get_Emp, requestHeaders);
            System.out.println("responseBody 값 : " + responseBody);
            System.out.println("requestHeaders 값 : " + requestHeaders);
            System.out.println("signature 값 : " + signature);

            // 결과 변환
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, Map.class);


            return responseBody;
        }

        /* 
         * 
         * 
         * POST 항목 메서드
         * 
         * 
        */
        //사업장 POST 항목
        public static String post_placebiz() throws Exception{
            // 헤더 설정
            // 방법에 따라서 GET, POST 등등 바꿔주면 된다.
            String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
            String signature = ApiUtil.makeSignature(accessKey, secretKey, apiServer_Post_PlaceBiz, "POST", timestamp);

            // api 주소에 따라서 v1 or v2를 사용해주면 된다.
            Map<String, String> requestHeaders = new HashMap<String, String>();
            requestHeaders.put("x-ncp-apigw-timestamp", timestamp);
            requestHeaders.put("x-ncp-iam-access-key", accessKey);
            requestHeaders.put("x-ncp-apigw-signature-v1", signature);

            // RequsetBody 구간 (요청 Body 파라미터) 필수 항목만 
            Map<String, Object> requestBodyMap = new HashMap<String, Object>();
            requestBodyMap.put("placeNm", "맥테스트"); //사업장명
            requestBodyMap.put("corporateNum", "12345678"); //법인번호 또는 대표자 주민번호
            requestBodyMap.put("corporateNm", "맥테스트"); //법인명 또는 상호
            requestBodyMap.put("corpRegistNum", "12345678"); //사업자등록번호
            requestBodyMap.put("bossNm", "맥맥테스트"); //사업장명
            requestBodyMap.put("useYn", "Y"); //사용여부

            // 결과 변환
            Gson gson = new Gson();
            //Map<String, String> map = gson.fromJson(responseBody, Map.class);
            String requestBody = gson.toJson(requestBodyMap);

             // api 호출
             String responseBody = ApiUtil.post(apiDomain + apiServer_Post_PlaceBiz, requestHeaders, requestBody);
             System.out.println("responseBody 값 : " + responseBody);
             System.out.println("requestHeaders 값 : " + requestHeaders);
             System.out.println("signature 값 : " + signature);
             System.out.println("requestBody 값 : " + requestBody);
             

            return requestBody;
        }




        //main class
        public static void main(String[] args) throws Exception {
            //get_placebiz();
            // get_empType();
            // get_job();
            // get_grade();
            // get_department();
            //get_emp();
            //post_placebiz();
        }


}
