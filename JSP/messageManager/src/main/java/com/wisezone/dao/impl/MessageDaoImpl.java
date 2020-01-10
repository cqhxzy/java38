package com.wisezone.dao.impl;

import com.wisezone.dao.JdbcUtil;
import com.wisezone.dao.MessageDao;
import com.wisezone.entity.Author;
import com.wisezone.entity.Message;
import com.wisezone.util.ConverterUtil;
import com.wisezone.util.PageUtil;
import com.wisezone.vo.MessageVo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MessageDaoImpl extends JdbcUtil implements MessageDao {
    @Override
    public int insert(Message message) {
        String sql = "insert into message (topic,content,mes_date,author) values (?,?,?,?)";
        Object[] params = {message.getTopic(), message.getContent(), new Date(), message.getAuthor().getId()};
        return super.executeUpdate(sql, params);
    }

    @Override
    public int update(Message message) {
        return 0;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }

    @Override
    public Message findById(int id) {
        return null;
    }

    @Override
    public List<Message> queryAll() {
        StringBuilder sql = new StringBuilder();
        sql.append("select m.id,m.topic,m.content,m.mes_date mesDate,a.id aId,a.author ")
                .append("from message m ")
                .append("INNER JOIN author a ")
                .append("on m.author = a.id ");
        List<Map<String, Object>> maps = super.executeQueryMap(sql.toString());


        return getMessage(maps);
    }

    @Override
    public PageUtil page(PageUtil pageUtil) {
        StringBuilder sql = new StringBuilder();
        sql.append("select m.id,m.topic,m.content,m.mes_date mesDate,a.id aId,a.author ")
                .append("from message m ")
                .append("INNER JOIN author a ")
                .append("on m.author = a.id ")
                .append("order by m.id desc ")
                .append("limit ?,? ");
        Object[] params = {(pageUtil.getPageIndex() - 1) * pageUtil.getPageSize(),pageUtil.getPageSize()};

        //开启事务
        super.startTransaction();

        List<Map<String, Object>> maps = super.executeQueryMap(sql.toString(),params);

        List<Message> message = getMessage(maps);
        List<MessageVo> list = message.stream().map(t -> {
            MessageVo vo = new MessageVo();
            vo.setId(t.getId());
            vo.setTopic(t.getTopic());
            vo.setContent(t.getContent());
            vo.setMesDate(ConverterUtil.date2String(t.getMesDate()));
            vo.setAuthroId(t.getAuthor().getId());
            vo.setAuthor(t.getAuthor().getAuthor());
            return vo;
        }).collect(Collectors.toList());

        pageUtil.setData(list);

        int total = total();
        pageUtil.setTotal(total);

        super.endTransaction();
        return pageUtil;
    }

    private List<Message> getMessage(List<Map<String,Object>> maps){
        List<Message> collect = maps.stream().map(t -> {
            //将List中的Map转换成为一个message类型的对象
            Message message = new Message();
            int id = (int) t.get("id");
            String topic = (String) t.get("topic");
            String content = (String) t.get("content");
            Timestamp timestamp = (Timestamp) t.get("mesDate");
            String authorName = (String) t.get("author");
            Integer aId = (Integer) t.get("aId");

            message.setId(id);
            message.setTopic(topic);
            message.setContent(content);
            Date mesDate = ConverterUtil.timeStamp2Date(timestamp);
            message.setMesDate(mesDate);

            //组将作者的对象
            Author author = new Author();
            author.setId(aId);
            author.setAuthor(authorName);

            message.setAuthor(author);
            return message;
        })
                .collect(Collectors.toList()); //终结操作，将stream中的左右元素转换为List集合

        return collect;
    }

    /**
     * 获取总共数据条数的方法中的sql语句的条件必须和上面的分页查询的条件完全相同
     * @return
     */
    @Override
    public int total() {
        StringBuilder sql = new StringBuilder();
        sql.append("select count(0) c ")
                .append("from message m ")
                .append("INNER JOIN author a ")
                .append("on m.author = a.id ");
        List<Map<String, Object>> maps = super.executeQueryMap(sql.toString());
        Map map = maps.size() > 0 ? maps.get(0) : null;
        Long total = (Long) map.get("c");
        return total.intValue();
    }
}
