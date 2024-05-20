package com.green.greengram.userfollow.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class UserFollowReq {
    @BindParam("from_user_id")
    @Schema(example = "61", description = "팔로워 유저 아이디", requiredMode = Schema.RequiredMode.REQUIRED)
    private long fromUserId;

    @BindParam("to_user_id")
    @Schema(example = "62", description = "팔로잉 유저 아이디", requiredMode = Schema.RequiredMode.REQUIRED)
    private long toUserId;
}
