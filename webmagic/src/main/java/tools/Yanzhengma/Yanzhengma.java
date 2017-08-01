package tools.Yanzhengma;

import net.sourceforge.tess4j.Tesseract;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by gray- on 2017/7/20.
 */
public class Yanzhengma {



    public  String getcode() throws Exception{
//        download("http://vip.01hr.com/company/checkcode.do?t=1500544558384?t=1500544558384"
//                ,"11.jpg","E:/");

        File imageFile = new File("E:/11.jpg");
        Tesseract instance = new Tesseract();

        //将验证码图片的内容识别为字符串
        String result = instance.doOCR(imageFile);
        System.out.println(result);

        imageFile.delete();

        return result;
    }

    public  void download(String urlString, String filename,String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5*1000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }
}
