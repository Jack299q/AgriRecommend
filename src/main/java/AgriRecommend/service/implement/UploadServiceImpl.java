package AgriRecommend.service.implement;

import AgriRecommend.domain.ProductImage;
import AgriRecommend.mapper.ImageMapper;
import AgriRecommend.service.IUploadService;
import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UploadServiceImpl implements IUploadService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public boolean upload(MultipartFile image,Long productId) throws IOException {
        if (image == null) {
            return false;
        }
        String originalFilename = image.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFilename = UUID.randomUUID().toString() + extname;

        // 获取resources目录的路径
        String resourcesPath = getClass().getClassLoader().getResource("").getPath();
        String productImagePath = resourcesPath + "productImage/";

        // 确保productImage文件夹存在
        File productImageDir = new File(productImagePath);
        if (!productImageDir.exists()) {
            productImageDir.mkdirs();
        }

        // 创建新的文件对象，并将文件保存到指定路径
        File newFile = new File(productImagePath + newFilename);
        image.transferTo(newFile);

        ProductImage productImage = new ProductImage();
        productImage.setProductId(productId);
        productImage.setPath(productImagePath + newFilename);

        // 将新文件名和产品id保存到数据库
        imageMapper.insertImage(productImage);

        return true;
    }

    @Override
    public File download(Long productId) throws IOException {
        List<ProductImage> productImages = imageMapper.selectImageByProductId(productId);

        if(productImages==null||productImages.isEmpty()){
            return null;
        }
        return new File(productImages.get(0).getPath());
    }
}
