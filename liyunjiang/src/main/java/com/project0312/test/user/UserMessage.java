package com.project0312.test.user;

import com.project0312.test.IMessage;

public class UserMessage implements IMessage {
    @Override
    public String getMessage() {
        return "开车";
    }
}
