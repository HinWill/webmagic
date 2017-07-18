
import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

public class Test implements PageProcessor {

    private Site site = Site.me().setSleepTime(0).setRetryTimes(3);

    @Override
    public Site getSite() {
        List<String[]> poolHosts = new ArrayList<String[]>();

        /**
         * 旧版本的使用方法
         *
         * Map<String,String> map = XiCi.main();
         for(Map.Entry<String, String> enty: map.entrySet()){
         poolHosts.add(new String[]{"username","password",enty.getKey(),enty.getValue()});
         }
         site.setHttpProxyPool(poolHosts,false);
         */
        return site;
    }

    @Override
    public void process(Page page) {
//		String name = page.getHtml().xpath("//div[@class='name_box']/div/text()").toString();
//		page.putField("名字：", name);
//
//		for(int i=1;i<100;i++){
//			String url = "http://www.job9151.com/resume/resume-show-"+i+".htm";
//			page.addTargetRequest(url);
//		}

        List<String> ips = page.getHtml().xpath("//tr[@class='odd']/allText()").all();
        System.out.println(ips);
        for(int i=1;i<5;i++){
            String url = "http://www.xicidaili.com/nn/" + i;
            page.addTargetRequest(url);
        }

    }


    public static void main(String[] args){

        HttpClientDownloader httpClientDownloader = new HttpClientDownloader();
        /**
         * 旧版本中使用SimpleProxyPool类中的方法
         *
         * List<String[]> poolHosts = new ArrayList<String[]>();
         Map<String,String> map = XiCi.main();
         for(Map.Entry<String, String> enty: map.entrySet()){
         poolHosts.add(new String[]{"username","password",enty.getKey(),enty.getValue()});
         System.out.println(enty.getKey()+"   ----       "+enty.getValue());
         }
         SimpleProxyPool s = new SimpleProxyPool(poolHosts,false);
         */


//		Map<String,String> map = XiCi.main();
//		for(Map.Entry<String, String> enty: map.entrySet()){
//			httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy(enty.getKey(), Integer.parseInt(enty.getValue()))));
//			System.out.println(enty.getKey()+"   ----       "+enty.getValue());
//		 }
//		 				,new Proxy("171.13.37.145",808),new Proxy("111.155.116.219",8123)));

        httpClientDownloader.setProxyProvider(SimpleProxyProvider
                .from(new Proxy("110.73.9.37",8123)));


        Spider.create(new Test())
                .addUrl("http://www.xicidaili.com/nn/")
                .thread(2)
                //.setDownloader(httpClientDownloader)
                .run();

        System.out.println("爬取完毕");
    }
}
