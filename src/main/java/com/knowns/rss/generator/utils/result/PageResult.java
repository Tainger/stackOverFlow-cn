package com.knowns.rss.generator.utils.result;

import java.util.List;

/**
 * 返回给客户端执行结果的消息类，带批量数据
 *
 * @author liying22923
 * @since 2020/6/24
 */
public class PageResult<T> extends BaseResult {

    private static final long serialVersionUID = -6673395649748854452L;

    /**
     * 当前返回的数据列表，其数目可以等于count，也可以小于count（分页时）
     */
    private List<T> data;

    /**
     * 在分页查询时，totalCount表示数据库数据总数
     */
    private int totalCount;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
