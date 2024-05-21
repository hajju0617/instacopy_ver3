package com.green.greengram.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
@Getter
public class CustomFileUtils {
    @Value("${file.directory}")

    private String uploadPath;
    public CustomFileUtils(@Value("${file.directory}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String makeFolders(String path) {
        File folder = new File(uploadPath, path);

        folder.mkdirs();
        return folder.getAbsolutePath();    // getAbsolutePath() : 절대 경로 (절대 주소값)
    }   // folder 객체는 uploadPath 아래 path에 해당하는 파일 또는 디렉토리를 가리키게 됨


    public String makeRandomFileName() {
        return UUID.randomUUID().toString();
    }   // 랜덤 문자열 얻음

    public String getExt(String fileName) {
        int idx = fileName.lastIndexOf(".");
        return fileName.substring(idx);
    }   // 파일명에서 확장자 추출
    // 이 코드는 fileName 에서 마지막 점(.)의 위치를 찾고 그 위치부터 문자열의 끝까지를 반환합니다. 이는 파일의 확장자를 추출하는 데 유용

    public String makeRandomFileName(String fileName) {
        return makeRandomFileName() + getExt(fileName);
    }   // 랜덤 파일명+확장자

    public String makeRandomFileName(MultipartFile mf) {
        return mf == null ? null : makeRandomFileName(mf.getOriginalFilename());
    }   // MultipartFile 객체를 매개변수로 받아서 그 파일의 원본 이름을 기반으로 랜덤 파일 이름을 생성하는 메서드

    public void transferTo(MultipartFile mf, String target) throws Exception {
        File savefile = new File(uploadPath, target);
        mf.transferTo(savefile);
    }   // 파일 저장
}
