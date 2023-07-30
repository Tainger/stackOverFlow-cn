package com.knowns.rss.generator.service;

import com.jayway.jsonpath.JsonPath;
import com.rometools.rome.feed.rss.Guid;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;
import com.jayway.jsonpath.Configuration;
import com.rometools.rome.feed.rss.Channel;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2023/7/29 11:31 AM
 */

@Service
@Slf4j
public class ApacheServiceImpl implements ApacheService {

    /**
     * issue ids
     */
    private final String issueIdsUrl = "https://issues.apache.org/jira/rest/issueNav/1/issueTable";

    /**
     * issue item page
     */
    private final String issuePage = "https://issues.apache.org/jira/rest/issueNav/1/issueTable/stable";

    /**
     * issue 详情
     */
    private final String issueDetail = "https://issues.apache.org/jira/secure/AjaxIssueAction!default.jspa?issueKey=CAMEL-19679&decorator=none&prefetch=false&shouldUpdateCurrentProject=false&loadFields=false&_=1690601203563";

    /**
     * cookie
     */
    private String cookie = "JSESSIONID=86AD11712F11FE1CDA84367CA90BE12E; atlassian.xsrf.token=A5KQ-2QAV-T4JA-FDED_efab161bd8b208b66c0fe1012d874d40cc543877_lout";

    /**
     * todo configure url and postBody
     */
    private Request.Builder basicBuilder = new Request.Builder().header("Accept", "*/*").header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive").header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").header("Cookie", cookie).header("Origin", "https://issues.apache.org").header("Referer", "https://issues.apache.org/jira/issues/?jql=project%20%3D%20CAMEL%20ORDER%20BY%20created%20DESC").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "same-origin").header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36").header("X-Atlassian-Token", "no-check").header("X-Requested-With", "XMLHttpRequest").header("__amdModuleName", "jira/issue/utils/xsrf-token-header").header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"").header("sec-ch-ua-mobile", "?0").header("sec-ch-ua-platform", "\"macOS\"");


    private Configuration configuration = Configuration.defaultConfiguration();


    @Override
    public String jiraProjectIssues(String projectName) throws IOException, FeedException {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder().add("startIndex", "0").add("jql", "project = CAMEL ORDER BY created DESC").add("layoutKey", "split-view").build();

        Request request = new Request.Builder().url(issueIdsUrl).post(formBody).header("Accept", "*/*").header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive").header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").header("Cookie", cookie).header("Origin", "https://issues.apache.org").header("Referer", "https://issues.apache.org/jira/issues/?jql=project%20%3D%20CAMEL%20ORDER%20BY%20created%20DESC").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "same-origin").header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36").header("X-Atlassian-Token", "no-check").header("X-Requested-With", "XMLHttpRequest").header("__amdModuleName", "jira/issue/utils/xsrf-token-header").header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"").header("sec-ch-ua-mobile", "?0").header("sec-ch-ua-platform", "\"macOS\"").build();
        Response response = client.newCall(request).execute();
//        String responseStr = response.body().string();
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(responseStr);
        String result = response.body().string();
        log.info("issueTable' id is {}", result);

        Configuration conf = Configuration.defaultConfiguration();
        List<Integer> issueIds = JsonPath.using(conf).parse(result).read("$.issueTable.issueIds");
        log.info("issueIds is {}", issueIds);

        OkHttpClient client2 = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("layoutKey", "split-view");

        for (Integer issueId : issueIds) {
            builder.add("id", String.valueOf(issueId));
        }
        FormBody formBody2 = builder.build();
        Request request2 = new Request.Builder().url(issuePage).post(formBody2).header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive").header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").header("Cookie", cookie).header("Origin", "https://issues.apache.org").header("Referer", "https://issues.apache.org/jira/browse/CAMEL-19682?jql=project%20%3D%20CAMEL%20ORDER%20BY%20created%20DESC").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "same-origin").header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36").header("X-Atlassian-Token", "no-check").header("X-Requested-With", "XMLHttpRequest").header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"").header("sec-ch-ua-mobile", "?0").header("sec-ch-ua-platform", "\"macOS\"").build();

        Response response2 = client2.newCall(request2).execute();

        Configuration conf2 = Configuration.defaultConfiguration();

        String string = response2.body().string();
        log.info("issue detail  is  {}", string);
        List<Map<String, Object>> issues = JsonPath.using(conf2).parse(string).read("$.issueTable.table[*]['id', 'key', 'status', 'summary', 'type']");
        log.info("issues is {}", issues);


//        for (Map<String, Object> issue : issues) {
//
//            String key = (String) issue.get("key");
//
//            Request request3 = new Request.Builder().url("https://issues.apache.org/jira/secure/AjaxIssueAction!default.jspa?issueKey=CAMEL-19632&decorator=none&prefetch=false&shouldUpdateCurrentProject=false&loadFields=false&_=1690648984505").header("Accept", "*/*").header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive").header("Cookie", "JSESSIONID=622F58E3D31124B9984A5182BE00A9A5; atlassian.xsrf.token=A5KQ-2QAV-T4JA-FDED_3bed0c214c8a75665681221391dbe6f78d24a602_lout").header("Referer", "https://issues.apache.org/jira/browse/CAMEL-19632?jql=project%20%3D%20CAMEL%20ORDER%20BY%20created%20DESC").header("Sec-Fetch-Dest", "empty").header("Sec-Fetch-Mode", "cors").header("Sec-Fetch-Site", "same-origin").header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36").header("X-Requested-With", "XMLHttpRequest").header("X-SITEMESH-OFF", "true").header("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"").header("sec-ch-ua-mobile", "?0").header("sec-ch-ua-platform", "\"macOS\"").build();
//
//            Response response3 = client.newCall(request3).execute();
//            String string1 = response3.body().string();
//            log.info("issue detail is {}",string1);
//        }
        SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
        Channel channel = new Channel("rss_2.0");
        channel.setTitle("Example RSS Feed");
        channel.setDescription("This is an example RSS feed generated using Rome.");
        channel.setLink("https://www.example.com");
        channel.setLanguage("en-us");
        channel.setPubDate(new Date());
        for (Map<String, Object> issue : issues) {
            Object id = issue.get("id");
            Object key = issue.get("key");
            Object status = issue.get("status");
            Object summary = issue.get("summary");
            Map type = (Map) issue.get("type");
            String description = (String) type.get("description");
            Item item1 = new Item();
            item1.setTitle((String) summary);
            item1.setLink("https://www.example.com/item1");
            item1.setPubDate(new Date());
            item1.setGuid(new Guid());
            item1.getGuid().setValue("https://www.example.com/item1");
            channel.getItems().add(item1);
        }
        SyndFeed syndFeed = new SyndFeedImpl(channel);
        String rss = syndFeedOutput.outputString(syndFeed);
        return rss;
    }
}



    
