package com.wisezone.dao;

import java.util.List;

/**
 * 通用的数据访问层的接口
 * 任何一个实体都有增、删、改、根据id查、分页查的方法
 * @param <T>
 */
public interface CommonDao<T> {
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
