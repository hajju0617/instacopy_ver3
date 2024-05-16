package com.green.greengram.user;

import com.green.greengram.user.model.PatchPasswordReq;
import com.green.greengram.user.model.SignUpPostReq;
import com.green.greengram.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int postUser(SignUpPostReq p);

    User getUserById(String p);

    int patchPassword(PatchPasswordReq p);

}
