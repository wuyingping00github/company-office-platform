package company.office.control;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class GetCode {

    // 请求的地址
    private static final String QUERY_PATH = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
    // 开发者主账号id ACCOUNT_SID 由32位英文字母和阿拉伯数字组成的账号唯一标识符0
    private static final String ACCOUNT_SID = "3832ef3b8a434462ba3b987db0bcddd5";
    // token 签名用
    private static final String AUTH_TOKEN = "da47afd7203c40188830eaec650cfd3d";

    /**
     * 发送验证
     *
     * @param phone 电话号码
     * @return 短信验证码
     */
    private  String sendCode(String phone) {
        // 验证码
        String code = getCode();
        // 时间戳
        String timeStamp = getTimeStamp();

        // 获取签名
        String sig = getSig(ACCOUNT_SID, AUTH_TOKEN, timeStamp);

        // 内容
        String content = "【休阳科技】登录验证码：" + code + "，如非本人操作，请忽略此短信。";
        //输出流
        OutputStreamWriter writer = null;
        //输入流
        BufferedReader bufferedReader = null;
        //可变的字符串，拼接效率高一些
        StringBuilder sb = new StringBuilder();

        try {
            //发送短信的平台
            URL url = new URL(QUERY_PATH);
            //获得连接
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
            //post的发送模式
            httpUrlConnection.setRequestMethod("POST");
            // 是否允许写入
            httpUrlConnection.setDoInput(true);
            // 是否允许输出
            httpUrlConnection.setDoOutput(true);
            // 5秒
            httpUrlConnection.setConnectTimeout(5000);

            httpUrlConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            //设置输出字符编码
            writer = new OutputStreamWriter(httpUrlConnection.getOutputStream(), "UTF-8");
            // 请求的参数
            String url_para = getQueryPara(ACCOUNT_SID, content, phone, timeStamp, sig, "JSON");
            writer.write(url_para);
            System.out.println(url_para);
            writer.flush();
            /*
             * reader = new
             * InputStreamReader(httpUrlConnection.getInputStream(),"UTF-8");
             */
            bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
            String stringline = "";
            while ((stringline = bufferedReader.readLine()) != null) {
                sb.append(stringline);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        JSONObject json = JSONObject.parseObject(sb.toString());
        System.out.println(json);
        String defaultResponse = "00000";
        String str = (String) json.get("respCode");
        if (str.equals(defaultResponse)) {
            return code;
        } else {
            //如果发送失败，将会返回0000
            return defaultResponse;
        }


    }

    /**
     * 请求的参数集合
     *
     * @param accountSid
     * @param smsContent
     * @param to
     * @param timestamp
     * @param sig
     * @param resultDataType
     * @return
     */
    private  String getQueryPara(String accountSid, String smsContent,
                                      String to, String timestamp,
                                      String sig, String resultDataType) {

        String url = "accountSid=" + accountSid + "&smsContent=" + smsContent
                + "&to=" + to + "&timestamp=" + timestamp + "&sig=" + sig
                + "&respDataType=" + resultDataType;
        return url;
    }

    /**
     * 获取时间戳
     *
     * @return
     */
    private  String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    /**
     * 签名 MD5 加密
     *
     * @return 加密后的字符串
     */
    private  String getSig(String account_Sid, String auth_Token,
                                String timeStamp) {

        String sig = account_Sid + auth_Token + timeStamp;
        StringBuilder sb = new StringBuilder();
        // 获取 MD5 加密
        try {
            // 获取MD5加密类
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(sig.getBytes());
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    sb.append("0" + hex);
                } else {
                    sb.append(hex);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return sb.toString();
    }

    /**
     * 获取发送的验证码
     *
     * @return
     */
    private  String getCode() {
        String code = new Random().nextInt(1000000) + "";
        if (code.length() < 6) {
            return getCode();
        }
        return code;
    }

    public static void main(String[] args) {

        System.out.println(new GetCode().sendCode("13189031999"));
    }
}