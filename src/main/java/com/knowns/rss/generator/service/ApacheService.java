package com.knowns.rss.generator.service;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2023/7/29 11:30 AM
 */
public interface ApacheService {

    /**
     * 拉取
     * @param projectName
     * @return
     */
    String jiraProjectIssues(String projectName) throws IOException, FeedException;
}



    
