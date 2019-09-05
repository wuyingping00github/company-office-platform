package company.office.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码生成，需要在web.xml中添加servlet
 * @author 吴应平
 *
 */
public class CheckCode extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
			doPost(request,response);
			}

			public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
			{
				//1、画一个矩形 2、填充背景颜色 3、画干扰的线条 4、验证数字

				//定义图片大小
				int width=90;
     			int height=40;
				//创建图片对象
				BufferedImage image=new BufferedImage(width,height,
				BufferedImage.TYPE_INT_RGB);
				Graphics g=image.createGraphics();//得到图片绘制的环境

				g.setColor(getRandColor(180,250));//2、填充图像背景 

				//1、画矩形 
				g.fillRect(0, 0, width, height);

				Random random=new Random();//产生随机数
				//3、画干扰的线条
				for(int i=0;i<6;i++)
				{
				g.setColor(getRandColor(50,100));
				int x=random.nextInt(width);
				int y=random.nextInt(height);
				g.drawOval(x, y, 5, 5); 
				}

				g.setFont(new Font("",Font.PLAIN,40));
				String sRand="";//随机数字
				for(int i=0;i<4;i++)
				{
				String rand=String.valueOf(random.nextInt(10));//产生0-9的随机数字
				sRand+=rand;
				g.setColor(new Color(20+random.nextInt(80),
				20+random.nextInt(100),20+random.nextInt(90)));
				//第一个参数是生成的字符串
				g.drawString(rand, (17+random.nextInt(3))*i+8, 34);
				//生成干扰线
				for(int k=0;k<12;k++)
				{
				int x1=random.nextInt(width);
				int y1=random.nextInt(height);

				int x2=random.nextInt(9);
				int y2=random.nextInt(9);
				g.drawLine(x1, y1, x1+x2, y1+y2);
				} 
				}

				request.getSession().setAttribute("randomNumber", sRand);
				g.dispose();//图像生效
				ImageIO.write(image, "JPEG", response.getOutputStream());//输出图像


				}

				//随机产生颜色  min颜色的最小值，max颜色的最大值 0-255
				public Color getRandColor(int min,int max)//调色板
				{
				Random random=new Random();//产生随机数
				if(min>255){
				min=255;
				}

				if(max>255){
				max=255;
				}

				int R=min+random.nextInt(max-min);
				int G=min+random.nextInt(max-min);
				int B=min+random.nextInt(max-min);

				return new Color(R,G,B);
				
			}


}
