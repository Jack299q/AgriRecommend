package AgriRecommend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface IUploadService {

    boolean upload(MultipartFile file,Long productId) throws IOException;

    File download(Long productId) throws IOException;
}
