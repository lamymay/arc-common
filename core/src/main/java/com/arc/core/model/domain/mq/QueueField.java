package com.arc.core.model.domain.mq;


import com.arc.core.model.domain.BaseModel;

/**
 * @author 叶超
 * @since 2019/5/21 16:06
 */
public class QueueField extends BaseModel {

    public static final String directNameForString = "queue_string";
    public static final String directNameForUser = "queue_user";


    public static String getDirectNameForUser() {
        return directNameForUser;
    }
}
