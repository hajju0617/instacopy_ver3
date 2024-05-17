package com.green.greengram.feed.model;

import com.green.greengram.common.GlobalConst;
import com.green.greengram.common.model.Paging;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

@Getter
@Setter
@ToString
public class FeedGetReq extends Paging {

    private long signedUserId;  // 좋아요 처리 구분하기 위해서

    public FeedGetReq(Integer page, Integer size, @BindParam("signed_user_id") long signedUserId) {
        super(page, size == null ? GlobalConst.FEED_PAGING_SIZE : size);
        this.signedUserId = signedUserId;
    }
}
