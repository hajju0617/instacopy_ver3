package com.green.greengram.feed;

import com.green.greengram.feed.model.FeedPicPostDto;
import com.green.greengram.feed.model.FeedPostReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedMapper {
    int postFeed(FeedPostReq p);

    int postFeedPics(FeedPicPostDto p);

}
