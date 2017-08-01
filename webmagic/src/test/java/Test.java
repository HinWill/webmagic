
import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import org.apache.commons.collections.CollectionUtils;

public class Test implements PageProcessor {

    private Site site = Site.me().setSleepTime(2000)
            .setRetryTimes(3)
            .addHeader("Authorization","Basic YWRtaW46MTIzNDU2");

    @Override
    public Site getSite() {

        return site;
    }

    @Override
    public void process(Page page) {

        System.out.println(page.getHtml());
    }


    public static void main(String[] args){


            Spider.create(new Test())
                    .addUrl("http://113.209.26.251:5000/")
                    .thread(5)
                    .run();
    }
}
