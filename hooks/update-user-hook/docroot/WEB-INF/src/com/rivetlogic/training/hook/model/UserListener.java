package com.rivetlogic.training.hook.model;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;
import com.rivetlogic.training.messagelistener.EmailNotificationsListener;

public class UserListener extends BaseModelListener<User> {

    @Override
    public void onAfterUpdate(User user) throws ModelListenerException {
        sendUpadteMessage(user);
    }

    private void sendUpadteMessage(User user) {
        Message message = new Message();
        message.put(EmailNotificationsListener.UPDATED_USER_ID, user.getUserId());
        MessageBusUtil.sendMessage(EmailNotificationsListener.DESTINATION, message);
    }

}
