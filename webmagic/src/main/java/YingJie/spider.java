package YingJie;

import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by gray- on 2017/7/25.
 */
public class spider implements PageProcessor{

    Site site = Site.me()
            .setSleepTime(0);
    private static String name;

    @Override
    public void process(Page page) {
        String n = page.getHtml().xpath("/html/body/div/div/a[2]/text()").
                toString().split(",")[1].split(":")[1].split("\"")[1]
                .replaceAll("\\\\u","\\\\u");
    }
    public static String decodeUnicode( String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();
    }


    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String id,String n){

        Spider.create(new spider())
                .addUrl("http://my.yjbys.com/resumemore/?id="+id)
                .thread(1)
                .run();

        System.out.println(n+"-----"+name);
    }
}
