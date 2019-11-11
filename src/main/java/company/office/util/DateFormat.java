package company.office.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式转化！
 */
public class DateFormat {
    public static SimpleDateFormat formatDay = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat formatMinter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");

    /**
     *
     * @param object 输入的信息，只能是Date和String 类型
     * @param dateFormat 输入日期显示格式 如"yyyy-MM-dd HH:mm:ss";
     * @return 返回需要的值
     * @throws ParseException
     */
    public static Object formatDay(Object object,String  dateFormat) throws ParseException {
        if (object instanceof String) {
            if (dateFormat.equals("yyyy-MM-dd HH:mm:ss")){
                return formatDay.parse(object.toString());
            }else if (dateFormat.equals("yyyy-MM-dd")){
                return formatDay.parse(object.toString());
            }else {
                return "输入的日期格式有问题";
            }
        }
        if (object instanceof Date) {
            if (dateFormat.equals("yyyy-MM-dd HH:mm:ss")){
                return formatDay.format(object);
            }else if (dateFormat.equals("yyyy-MM-dd")){
                return formatDay.format(object);
            }else {
                return "输入的日期格式有问题";
            }
        }
        return  "输入类型有误！不是Date或者String类型";
    }


}
