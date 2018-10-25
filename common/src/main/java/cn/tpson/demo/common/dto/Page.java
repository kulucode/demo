package cn.tpson.demo.common.dto;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by Zhangka in 2018/10/24
 */
public class Page<E> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6562202911735793539L;
    /**
     * 默认页码
     */
    public static final Integer DEFAULT_PAGE_NO = 1;
    /**
     * 默认页面大小
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    /**
     * 默认的快速导航页码显示个数
     */
    public static final Integer DEFAULT_PAGE_NAV_SIZE = 5;

    private Integer pageNo = DEFAULT_PAGE_NO; // 页码
    private Integer pageSize = DEFAULT_PAGE_SIZE; // 页面大小
    private Integer pageNaviSize = DEFAULT_PAGE_NAV_SIZE; // 页码快速导航显示的个数
    private Integer totalCount; // 总的记录数
    private List<E> resultList; // 返回的查询结果集

    public Page() {
        super();
    }

    public Page(Integer pageNo, Integer pageSize) {
        super();
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageNaviSize) {
        this(pageNo, pageSize);
        setPageNaviSize(pageNaviSize);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = DEFAULT_PAGE_NO;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getResultList() {
        return resultList;
    }

    public void setResultList(List<E> resultList) {
        this.resultList = resultList;
    }

    public Integer getPageNaviSize() {
        return pageNaviSize;
    }

    /**
     * 返回快速导航页码
     *
     * @return
     */
    public Integer[] getPageNavis() {
        // 先运算出左，右边界
        Integer start, end;
        Integer a = pageNaviSize / 2;
        start = pageNo - a;
        if (pageNaviSize % 2 == 0) {
            end = pageNo + a - 1;
        } else {
            end = pageNo + a;
        }
        // 分三种情况处理
        Integer totalPages = getTotalPage();
        Integer[] b = new Integer[pageNaviSize];
        // 左边界
        if (start < 1) {
            for (Integer i = 0, step = 1; i < pageNaviSize; i++, step++) {
                if (step <= totalPages) {
                    b[i] = step;
                } else {
                    break;
                }
            }
        } else if (end > totalPages) {    // 右边界
            for (Integer i = pageNaviSize - 1, step = totalPages; i >= 0; i--, step--) {
                if (step > 0) {
                    b[i] = step;
                } else {
                    break;
                }
            }
        } else {    // 中间
            for (Integer i = 0; i < pageNaviSize; i++) {
                b[i] = start++;
            }
        }
        return b;
    }

    public void setPageNaviSize(Integer pageNaviSize) {
        if (pageNaviSize < 1) {
            pageNaviSize = DEFAULT_PAGE_NAV_SIZE;
        }
        this.pageNaviSize = pageNaviSize;
    }

    /**
     * 获得总的页码数量
     *
     * @return
     */
    public Integer getTotalPage() {
        if (totalCount % pageSize > 0) {
            return totalCount / pageSize + 1;
        } else {
            return totalCount / pageSize;
        }
    }

    /**
     * 获取从哪一条记录开始查询
     *
     * @return
     */
    public Integer getFirstIndex() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 获取最后一条记录的下标数（不包含）
     *
     * @return
     */
    public Integer getLastIndex() {
        return getFirstIndex() + pageSize;
    }

    /**
     * 判断是否还有下一页
     *
     * @return
     */
    public boolean isHasNextPage() {
        return (pageNo + 1) <= getTotalPage();
    }

    /**
     * 获取下一个页码，在调用之前先调用<code>isHasNextPage()</code>方法进行判断
     *
     * @return
     */
    public Integer getNextPage() {
        return pageNo + 1;
    }

    /**
     * 判断是否还有上一页
     *
     * @return
     */
    public boolean isHasPrePage() {
        return (pageNo - 1) > 0;
    }

    /**
     * 获取上一个页码，在调用之前先调用<code>isHasPrePage()</code>方法进行判断
     *
     * @return
     */
    public Integer getPrePage() {
        return pageNo - 1;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Page.class.getSimpleName() + "[", "]")
                .add("pageNo=" + pageNo)
                .add("pageSize=" + pageSize)
                .add("pageNaviSize=" + pageNaviSize)
                .add("totalCount=" + totalCount)
                .add("resultList=" + resultList)
                .toString();
    }
}
