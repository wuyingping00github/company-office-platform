package test;

import company.office.entity.Customer;
import company.office.util.DateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * 基础测试用的累
 * @author 吴应平
 */
public class TestApi {

    //日期设置格式！
    public static void main(String[] args) throws ParseException {
        Customer customer = new Customer();
        String date = "2019-05-03 14:20:26";
        customer.setCustomerBirthday((Date)DateFormat.formatDay(date,"yyyy-MM-dd HH:mm:ss"));
        change(customer);
        System.out.println(DateFormat.formatDay(customer.getCustomerBirthday(),"yyyy-MM-dd HH:mm:ss").toString());
    }

    public  static void change(Customer customer) throws ParseException {
        customer.setCustomerBirthday(new Date());
        System.out.println(DateFormat.formatDay(customer.getCustomerBirthday(),"yyyy-MM-dd HH:mm:ss").toString());
    }

}
