package com.wisezone.biz;

import java.util.List;

public interface CommonBiz<T> {
    /**
     * 插入一个T的实体
     * @return
     */
    int insert(T t);

    /**
     * 根据学号修改学生信息
     * @return
     */
    int update(T t);

    /**
     * 根据学号删除学生
     * @return
     */
    int deleteById(int id);

    /**
     * 根据学号查询学生信息
     * @return
     */
    T findById(int id);

    /**
     * 查询所有的学生信息
     * @return
     */
    List<T> queryAll();
}
