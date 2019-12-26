package com.wisezone.biz.impl;

import com.wisezone.biz.StudentBiz;
import com.wisezone.dao.StudentDao;
import com.wisezone.dao.impl.StudentDaoImpl;
import com.wisezone.entity.Student;
import com.wisezone.vo.StudentScoreVo;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 业务逻辑层的实现类
 * 通过调用数据访问层中的同名方法实现对数据的增、删、改、查
 */
public class StudentBizImpl implements StudentBiz {

    //引用数据访问层的对象
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public int insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int deleteById(int stuNo) {
        return studentDao.deleteById(stuNo);
    }

    @Override
    public Student findById(int stuNo) {
        return studentDao.findById(stuNo);
    }

    @Override
    public List<Student> queryAll() {
        return studentDao.queryAll();
    }

    @Override
    public List<Student> queryAllNoScore() {
        return studentDao.queryAllNoScore();
    }

    @Override
    public List<StudentScoreVo> queryStudentWithScore() {
        List<Map<String,Object>> maps = studentDao.queryStudentWithScore();
        /*List<StudentScoreVo> collect = maps.stream().map(t -> {
            //将一个map转换为一个StudentScoreVo的对象
            StudentScoreVo vo = new StudentScoreVo();

            Set<String> set = t.keySet(); //得到键的集合，而键就是查询的列明，列名和vo中的属性名一致
            set.stream().forEach(key -> {
                try {
                    BeanUtils.setProperty(vo,key,t.get(key));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
            return vo;
        }).collect(Collectors.toList());
        return collect;
        */

        List<StudentScoreVo> list = new ArrayList<>();
        for (Map map : maps) {
            //将一个map转换为一个StudentScoreVo的对象
            StudentScoreVo vo = new StudentScoreVo();

            Set<String> set = map.keySet(); //得到键的集合，而键就是查询的列明，列名和vo中的属性名一致
            for (String key : set) {
                try {
                    BeanUtils.setProperty(vo,key,map.get(key));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            list.add(vo);
        }
        return list;
    }
}
