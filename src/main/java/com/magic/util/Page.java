package com.magic.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Page
 * @Author 罗璋||luozhang@cnpc.com.cn
 * Description TODO
 * @Date 2019/8/21 15:54
 * @Version 1.0
 */
@Data
public class Page<T> implements Serializable {
    private static final long serialVersionUID = -2020350783443768083L;
    //起始行
    private Integer beginNum;
    //当前页
    private Integer pageNum;
    //每页条数
    private Integer pageSize;
    //总条数
    private Integer allNum;
    //页数
    private Integer allSize;
    //数据
    private List<T> pageList;

    public Page(){
        super();
    }
    //pageNum 当前页数
    public Page(Integer pageNum,Integer pageSize,Integer allNum,List<T> pageList){
        super();
        this.pageNum = pageNum-1;
        this.beginNum = (pageNum-1)*pageSize;
        this.pageSize = pageSize;
        this.allSize = allNum%pageSize == 0 ? allNum/pageSize : allNum/pageSize + 1;
        this.pageList = pageList;

    }

}
