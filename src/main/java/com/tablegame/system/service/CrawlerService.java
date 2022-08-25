package com.tablegame.system.service;

import com.tablegame.system.domain.Web;
import com.tablegame.system.domain.dto.WebUrl;
import com.tablegame.system.mapper.CrawlerManager;
import org.assertj.core.util.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tu.cb
 */
@Service
public class CrawlerService {


    private final String urlPrefix = "https://weixin.sogou.com";

    @Autowired
    private CrawlerManager crawlerManager;

    public List<Web> getBaiduUrl() throws IOException {
        Document document = Jsoup.parse(new URL("https://weixin.sogou.com/weixin?type=1&query=%E6%A1%8C%E6%B8%B8&ie=utf8&s_from=input&_sug_=y&_sug_type_="), 1000);
        //获取title的内容
        Elements dd = document.getElementsByTag("dd");
        List<String> urls = Lists.newArrayList();
        getElements(dd, urls);
        return getContent(urls);
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
                urls.add(element.attributes().get("href"));
            }
        });

    }

    public List<Web> getContent(List<String> urls) throws IOException {
        List<Web> webs = new ArrayList<>();
        for (String url : urls) {
            Document document = Jsoup.parse(new URL(urlPrefix+url), 1000);
            Elements title = document.getElementsByTag("title");
            webs.add(new Web(title.text(), urlPrefix+url));
        }
        return webs;
    }


}
