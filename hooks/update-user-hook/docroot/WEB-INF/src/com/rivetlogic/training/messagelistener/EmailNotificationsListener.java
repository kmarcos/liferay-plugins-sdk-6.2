package com.rivetlogic.training.messagelistener;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class EmailNotificationsListener implements MessageListener {

    public static final String DESTINATION = "email_notifications/update";
    public static final String UPDATED_USER_ID = "updated_user_id";

    private static final Log log = LogFactoryUtil.getLog(EmailNotificationsListener.class);

    @Override
    public void receive(Message message) throws MessageListenerException {

        doReceive(message);
    }

    private void doReceive(final Message message) {

        String userId = message.getString(UPDATED_USER_ID);

        log.info(String.format("User with Id %s was updated", userId));
    }

}
