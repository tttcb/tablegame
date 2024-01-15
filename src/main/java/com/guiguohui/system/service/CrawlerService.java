package com.guiguohui.system.service;

import com.guiguohui.system.domain.Web;
import com.guiguohui.system.domain.dto.WebUrl;
import com.guiguohui.system.mapper.CrawlerManager;
import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author tu.cb
 */
@Service
public class CrawlerService {


    private final String urlPrefix = "https://weixin.sogou.com";

    @Autowired
    private CrawlerManager crawlerManager;

    String[] ua = {"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586",
            "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
            "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; WOW64; Trident/6.0)",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)",
            "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1; WOW64; Trident/4.0)",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 BIDUBrowser/8.3 Safari/537.36",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36 Core/1.47.277.400 QQBrowser/9.4.7658.400",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 UBrowser/5.6.12150.8 Safari/537.36",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 TheWorld 7",
            "Mozilla/5.0 (Windows NT 6.1; W…) Gecko/20100101 Firefox/60.0"};

    public List<Web> getBaiduUrl() throws IOException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        int i = new Random().nextInt(14);
        map.put("waybillNo", "DD1838768852");
        String url = "https://weixin.sogou.com/weixin?type=1&query=%E6%A1%8C%E6%B8%B8&ie=utf8&s_from=input&_sug_=y&_sug_type_=";
        Document document = Jsoup.connect(url)
                .userAgent(ua[i])
                .timeout(1000)
                .data(map)
                .ignoreContentType(true)
                .header("referer", "https://weixin.sogou.com")
                .get();
        Elements dd = document.getElementsByTag("dd");
        List<Web> urls = Lists.newArrayList();
        getElements(dd, urls);
        return urls;
    }

    public List<WebUrl> getUrl() {
        return crawlerManager.selectList(null);
    }

    public void getElements(Elements elements, List urls) {
        elements.forEach(element -> {
            if (element.children() != null) {
                getElements(element.children(), urls);
            }
            if (!element.attributes().get("href").isEmpty()) {
                urls.add(new Web(element.text(),urlPrefix+element.attributes().get("href")));
            }
        });

    }

/*
    public List<Web> getContent(List<String> urls) throws IOException, InterruptedException {
        Map<String, String> map = new HashMap<>();
        int i = new Random().nextInt(14);
        map.put("waybillNo", "DD1838768852");
        List<Web> webs = new ArrayList<>();
        for (String url : urls) {
            Thread.sleep(2000);
            Document document = Jsoup.connect(urlPrefix + url)
                    .userAgent(ua[i])
                    .timeout(1000)
                    .data(map)
                    .ignoreContentType(true)
                    .header("referer", "https://weixin.sogou.com")
                    .get();
            Elements title = document.getElementsByTag("title");
            webs.add(new Web(title.text(), urlPrefix + url));
        }
        return webs;
    }*/


}
