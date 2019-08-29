package company.office.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Execl表的解析，由于execl的解析耦合度很高这里只是一个实例
 * @author 吴应平
 *
 */
public class ExeclUtil {
	
	public  void getExecl(FileInputStream file) throws IOException {

        /**
         * 1.先导入poi的依赖组建
         * 2.在读取需要的文件
         * 3.读取第一行表头
         * 4.读取execl有多少行
         * 5.根据行数，解析完成。
         */

        //1.字符流，读取文件
        InputStream stream = file; //new FileInputStream("D:\\xlxs\\test.xlsx");

        //2。根据字符流获得文件的操作权
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(stream);

        //3.读取表的第几张表，从0开始，得到表
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        //4根据得到的表，获得表的行数索引index
        int rowstart = xssfSheet.getFirstRowNum();
        //5.根据得到的表获取最后一条信息的索引，index
        int rowEnd = xssfSheet.getLastRowNum();

        //6.x循环去除表的信息
        for(int i=rowstart;i<=rowEnd;i++)
        {
            //6.1，根据表获得第I行，
            XSSFRow row = xssfSheet.getRow(i);
            //如果第i行为空跳到下一行
            if(null == row) continue;
            //6.2，根据行获得第一列，和最后一列的索引
            int cellStart = row.getFirstCellNum();

            int cellEnd = row.getLastCellNum();

            //6.3，for循环的到每一个坐标的内容
            for(int k=cellStart;k<=cellEnd;k++)
            {
                //6.3.1，获取每一列的信息类似于坐标了
                XSSFCell cell = row.getCell(k);
                if(null==cell) continue;
                //使用switch进行信息处理，不管是解析失败还是成功，都会处理
                switch (cell.getCellType())
                {
                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case HSSFCell.CELL_TYPE_STRING: // 字符串
                        System.out.print(cell.getStringCellValue()  + "\t");
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                        System.out.println(cell.getBooleanCellValue() + "\t");
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA: // 公式
                        System.out.print(cell.getCellFormula() + "\t");
                        break;
                    case HSSFCell.CELL_TYPE_BLANK: // 空值
                        System.out.println(" ");
                        break;
                    case HSSFCell.CELL_TYPE_ERROR: // 故障
                        System.out.println("信息无法识别，解析失败");
                        break;
                    default:
                        System.out.print("未知类型   "+cell);
                        break;
                }
            }
            System.out.print("\n");
        }

}

}
	