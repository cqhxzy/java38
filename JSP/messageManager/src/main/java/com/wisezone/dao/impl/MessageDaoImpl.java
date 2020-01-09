package com.wisezone.dao.impl;

import com.wisezone.dao.JdbcUtil;
import com.wisezone.dao.MessageDao;
import com.wisezone.entity.Author;
import com.wisezone.entity.Message;
import com.wisezone.util.ConverterUtil;

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
}
