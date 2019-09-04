package company.office.util;

import java.security.MessageDigest;

/**
 * MD5加密工具，无解密，验证方法就是加密后对比
 * @author 吴应平
 *
 */
public class MD5Util {

	/***
	 * MD5加码 生成32位md5码
	 */
	public static String getMD5String(String inStr){
		
		//获取MD5
		MessageDigest md5 = null;
		try{
			//获得MD5
			md5 = MessageDigest.getInstance("MD5");
			
		}catch (Exception e){
			
			System.out.println(e.toString());
			e.printStackTrace();
			
			return "";
		}
		//将字符串转化为字符数组
		char[] charArray = inStr.toCharArray();
		//得到字符串长度相同的byte空数组
		byte[] byteArray = new byte[charArray.length];
 
		//for循环，将加密后的字符，放到byte数组中去
		for (int i = 0; i < charArray.length; i++){
			//每个字符都转换为byte
			byteArray[i] = (byte) charArray[i];
		    }
		//每个byte都加密
		byte[] md5Bytes = md5.digest(byteArray);
		    //使用一个新的字符串来接受
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++){
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16){
				hexValue.append("0");}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
 
	}
 
 
	// 测试主函数
	public static void main(String args[]) {
		String s = new String("tangfuqiang");
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + getMD5String(s));
 
	}
}
