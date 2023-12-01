package com.neu.his.bo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 聊天相关信息类
 * Created by szh on 2023-11-27
 *
 * @author szh
 */

@Data
@ToString
public class ChatMsg {

    private String from;

    private String to;

    private String content;

    private Date date;

    private String fromNickname;

}
