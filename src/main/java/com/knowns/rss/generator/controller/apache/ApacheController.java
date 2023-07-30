package com.knowns.rss.generator.controller.apache;

import com.knowns.rss.generator.service.ApacheService;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author jiazhiyuan
 * @date 2023/7/29 10:47 AM
 */

@RestController()
@RequestMapping("/apache")
public class ApacheController {
    private static final String UTF_8_SUFFIX = ";charset=UTF-8";

    private static final String XML_INVALID_CHAR = "[\\x00-\\x1F\\x7F]";

    private static final String XML_MEDIA_TYPE = MediaType.APPLICATION_XML_VALUE + UTF_8_SUFFIX;


    @Autowired
    private ApacheService apacheService;


    @GetMapping("/jira/project/{projectName}/issues")
    public String jiraProjectIssues(@PathVariable("projectName") String projectName) throws IOException, FeedException {
        return apacheService.jiraProjectIssues(projectName);
    }

    @GetMapping(value = "/jira2/project/issues")
    public String jiraProjectIssues2() throws IOException, FeedException {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rss xmlns:atom=\"http://www.w3.org/2005/Atom\" version=\"2.0\"\n" +
                "\n" +
                "\n" +
                ">\n" +
                "    <channel>\n" +
                "        <title><![CDATA[10月论坛更新公告 - 公告和反馈 - Minecraft(我的世界)中文论坛 -]]></title>\n" +
                "        <link>https://www.mcbbs.net/forum.php?authorid=3038&#38;mod=viewthread&#38;ordertype=1&#38;tid=915861</link>\n" +
                "        <atom:link href=\"http://localhost:1200/mcbbs/post/915861/3038\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "        <description><![CDATA[10月论坛更新公告 - 大家好，虽然发帖的时候还是9月，但是这是10月的论坛大规模更新情报，因为国庆有个很长的假期让我们不方便进行更新，所以这次更新将会提前！本次更新的内容很多，还请耐心 ...  - Made with love by RSSHub(https://github.com/DIYgod/RSSHub)]]></description>\n" +
                "        <generator>RSSHub</generator>\n" +
                "        <webMaster>i@diygod.me (DIYgod)</webMaster>\n" +
                "        \n" +
                "        \n" +
                "        \n" +
                "        <language>zh-cn</language>\n" +
                "        \n" +
                "        <lastBuildDate>Sun, 30 Jul 2023 04:46:34 GMT</lastBuildDate>\n" +
                "        <ttl>5</ttl>\n" +
                "        \n" +
                "        <item>\n" +
                "            <title><![CDATA[混乱 发表于 2019-9-27 18:25:41]]></title>\n" +
                "            <description><![CDATA[混乱 发表于 2019-9-27 18:25:41]]></description>\n" +
                "            <pubDate>Fri, 27 Sep 2019 10:25:41 GMT</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.mcbbs.net/forum.php?mod=redirect&#38;goto=findpost&#38;ptid=915861&#38;pid=15655037</guid>\n" +
                "            <link>https://www.mcbbs.net/forum.php?mod=redirect&#38;goto=findpost&#38;ptid=915861&#38;pid=15655037</link>\n" +
                "            \n" +
                "            \n" +
                "            \n" +
                "            <author><![CDATA[混乱]]></author>\n" +
                "            \n" +
                "                \n" +
                "            \n" +
                "            \n" +
                "        </item>\n" +
                "        \n" +
                "        <item>\n" +
                "            <title><![CDATA[混乱 发表于 2019-9-27 17:23:50]]></title>\n" +
                "            <description><![CDATA[<div class=\"attach_nopermission attach_tips\">\n" +
                "<div>\n" +
                "<h3><strong>\n" +
                "您尚未登录，立即登录享受更好的浏览体验！</strong></h3>\n" +
                "<p>您需要 <a href=\"https://www.mcbbs.net/member.php?mod=logging&amp;action=login\" onclick=\"showWindow('login', this.href);return false;\">登录</a> 才可以下载或查看，没有帐号？<a href=\"https://www.mcbbs.net/member.php?mod=register\" title=\"注册帐号\">注册(register)</a> </p>\n" +
                "</div>\n" +
                "<span class=\"atips_close\" onclick=\"this.parentNode.style.display='none'\">x</span>\n" +
                "</div>\n" +
                "<p style=\"line-height:30px;text-indent:2em;text-align:left\"><font face=\"微软雅黑\"><font size=\"3\">大家好，虽然发帖的时候还是9月，但是这是10月的论坛大规模更新情报，因为国庆有个很长的假期让我们不方便进行更新，所以这次更新将会提前！本次更新的内容很多，还请耐心阅读！</font></font></p><hr class=\"l\"><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "论坛PC模板更新：<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">右上角UI焕然一新；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">道具、勋章页面素材更新；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">道具图标全面换为MC中的道具；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">爱心勋章改版为粉色底色，很COOL；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">其他小修改略过；<br>\n" +
                "</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "新增插件：服务器发帖增强<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">通过正则公式自动识别标题是否符合格式，拯救小白腐竹的绿宝石！<br>\n" +
                "</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "新增插件：代码高亮<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">添加Cascadia Code字体用于代码显示；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">联动markdown；<br>\n" +
                "</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "新增插件：Markdown识别<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">加入可识别markdown语法的bbcode；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">也支持在markdown中的代码高亮；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">改为使用parsedown；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复了大量bug后终于可以用了；<br>\n" +
                "</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "新增插件：自定义水印<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">现在你可以用自己的ID做水印了；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">可以在个人设置中调整水印所在的位置；<br>\n" +
                "</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "新增 Minecon专题页<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">敬请期待最新的MC资讯；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">将接入网易CC与BILIBILI直播源；</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">9月29日0点直播不见不散！<br>\n" +
                "</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "其他更新：<br>\n" +
                "</font></font><ul><li><font face=\"微软雅黑\"><font size=\"3\">修改 html5通知 调整通知数量</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 视频解析组件 B站播放器更新</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 B站播放器解析 修复解析地址错误的问题并增加Flash版播放器</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 mc皮肤预览插件 修改解析部分的代码</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 核心 修改判断机制，将默认使用html5播放器</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 游客在设置禁止访问权限时访问Archiver跳转出错的问题</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 .php模板被修改时，某些情况下无法自动更新模板缓存的BUG【官方】</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 被搜索的分类信息表或字段不存在时触发系统错误【官方】</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 远程下载图片功能，精确匹配src属性，修改正则表达式【官方】</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 限定forumdefstyle的cookie值，防止可能出现的xss风险【官方】</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 删除外部指定编码逻辑，防止可能出现的xss漏洞【官方】</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 主题评价扩展 去jquery化，使用原生代码</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 核心 修复因搜索域名跳转判定导致部分目录无法访问的Bug</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 核心 修复手机版无法评分的Bug</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修复 核心 修复上传头像后头像不刷新的问题</font></font></li><li><font face=\"微软雅黑\"><font size=\"3\">修改 核心 修正部分情况刷新头像缓存可能无效的问题</font></font><br>\n" +
                "</li></ul><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "</font></font><br>\n" +
                "<div align=\"right\"><font face=\"微软雅黑\"><font size=\"3\"><br>\n" +
                "</font></font></div><br>\n" +
                "<hr class=\"l\"><div align=\"right\">MCBBS管理组</div><br>\n" +
                "<br>\n" +
                "<div align=\"right\">2019年9月27日</div><br>\n" +
                "]]></description>\n" +
                "            <pubDate>Fri, 27 Sep 2019 09:23:50 GMT</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.mcbbs.net/thread-915861-1-1.html</guid>\n" +
                "            <link>https://www.mcbbs.net/thread-915861-1-1.html</link>\n" +
                "            \n" +
                "            \n" +
                "            \n" +
                "            <author><![CDATA[混乱]]></author>\n" +
                "            \n" +
                "                \n" +
                "            \n" +
                "            \n" +
                "        </item>\n" +
                "        \n" +
                "    </channel>\n" +
                "</rss>\n";
    }
}



    
