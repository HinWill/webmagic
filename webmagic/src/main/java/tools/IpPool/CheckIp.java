package tools.IpPool;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import redis.clients.jedis.Jedis;

class CheckIp{

    //连接redis
    public static Jedis jedis = new Jedis("*********",6379);

    public static void checkProxyIp(Map<String, Integer> proxyIpMap, String reqUrl) {

        for (String proxyHost : proxyIpMap.keySet()) {
            Integer proxyPort = proxyIpMap.get(proxyHost);

            int statusCode = 0;
            try {
                HttpClient httpClient = new HttpClient();
                httpClient.getHostConfiguration().setProxy(proxyHost, proxyPort);

                // 连接超时时间（默认10秒 10000ms） 单位毫秒（ms）
                int connectionTimeout = 3000;
                // 读取数据超时时间（默认30秒 30000ms） 单位毫秒（ms）
                int soTimeout = 30000;
                httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);
                httpClient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);

                HttpMethod method = new GetMethod(reqUrl);

                statusCode = httpClient.executeMethod(method);
            } catch (Exception e) {
            }
            if(statusCode == 200 )
            {
                jedis.sadd("IP",proxyHost + ":" + proxyPort);
                System.out.format("%s:%s-->%s\n", proxyHost, proxyPort, statusCode);
            }
            else{
                if (jedis.sismember("IP",proxyHost + ":" + proxyPort)){
                    jedis.srem("IP",proxyHost + ":" + proxyPort);
                }
                System.out.format("%s:%s-->%s\n", proxyHost, proxyPort, statusCode);
            }

        }
    }

    /**
     * 代理IP有效检测
     * @param proxyIp
     * @param proxyPort
     * @param reqUrl
     */
    public static void checkProxyIp(String proxyIp, int proxyPort, String reqUrl) {
        Map<String, Integer> proxyIpMap = new HashMap<String, Integer>();
        proxyIpMap.put(proxyIp, proxyPort);
        checkProxyIp(proxyIpMap, reqUrl);
    }



    public static void main (Map<String,Integer> map) {

        Map<String, Integer> proxyIpMap = map;

        checkProxyIp(proxyIpMap, "http://t.sohu.com/new_index");

    }
}

