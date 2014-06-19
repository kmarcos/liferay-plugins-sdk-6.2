package com.rivetlogic.training.hook.model;

import com.liferay.portal.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.model.BaseModelListener;
import com.liferay.portal.model.User;

public class UserListener extends BaseModelListener<User>{
    
    private static final Log log = LogFactoryUtil.getLog(UserListener.class);    

    @Override
    public void onAfterUpdate(User user) throws ModelListenerException {
        
        log.info (String.format("User %s has been updated", user.getScreenName()));
        sendUpadteMessage(user);      
    }
    
    private void sendUpadteMessage(User user){
        Message message = new Message();
        message.put("userId", user.getUserId());
        MessageBusUtil.sendMessage("notifications/update/user", message);
    }

}
