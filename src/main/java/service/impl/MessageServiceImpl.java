package service.impl;

import dao.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import service.MessageService;
import util.MessageDetail;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Flyme on 2017/1/30.
 */

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {


    @Autowired
    MessageDAO messageDAO;

    public boolean getMyAll(ModelMap model, HttpSession session) {
        String id = session.getAttribute("roleid").toString();
        List<MessageDetail> messages = messageDAO.getBySid(id);
        Date previous = null;
        long millis_a_day = 1000 * 24 * 60 * 60;
        for (MessageDetail m : messages) {
            Date thistime = m.getActiontime();
            boolean sameDay = previous == null?false:(thistime.getTime() - previous.getTime()) < millis_a_day && thistime.getDate() == previous.getDate();
            m.setSameday(sameDay);
            if(!sameDay){
                previous = thistime;
            }
        }
        model.addAttribute("messages", messages);
        return true;
    }

    public boolean delete(ModelMap model, String mid) {
        messageDAO.delete(mid);
        return true;
    }
}
