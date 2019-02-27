package cn.ideal.search.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author XINER
 * @create 2019-02-25 17:14
 * @desc
 **/
public class CustomMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            String text = textMessage.getText();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
