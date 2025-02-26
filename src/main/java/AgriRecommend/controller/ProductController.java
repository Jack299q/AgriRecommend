package AgriRecommend.controller;

import AgriRecommend.aop.Log;
import AgriRecommend.core.AjaxResult;
import AgriRecommend.domain.Collect;
import AgriRecommend.domain.ProductDescription;
import AgriRecommend.service.ICollectService;
import AgriRecommend.service.IProductService;
import AgriRecommend.service.IUploadService;
import AgriRecommend.utils.JwtUtil;
import AgriRecommend.utils.UserHolder;
import cn.hutool.core.lang.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICollectService iCollectService;

    @Autowired
    private IUploadService iUploadService;

    @GetMapping("/listAllProduct")
    public AjaxResult listall() {
        return AjaxResult.success(iProductService.listAllProduct());
    }

    @GetMapping("/search")
    public AjaxResult searchProducts(@RequestParam String query) {
        return AjaxResult.success(iProductService.selectProductList(query));
    }

    @GetMapping("/getProduct/{id}")
    @Log
    public AjaxResult getProduct(@PathVariable("id") Long id) {
        return AjaxResult.success(iProductService.getProduct(id));
    }

    @PostMapping("/addProduct")
    public AjaxResult addProduct(@RequestBody ProductDescription productDescription) {
        return AjaxResult.success(iProductService.insertProduct(productDescription));
    }

    @PostMapping("/collectProduct/{id}")
    @Log
    public AjaxResult collectProduct(@PathVariable("id") Long id) {
        Long userId = UserHolder.getUser();
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setProductId(id);
        collect.setCollectTime(LocalDateTime.now());
        boolean success = iCollectService.collect(collect);
        if (success) {
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @PostMapping("/uploadPicture")
    public AjaxResult uploadPicture(@RequestParam("image") MultipartFile image, @RequestParam("productId") Long productId) throws IOException {
        boolean success = iUploadService.upload(image, productId);
        if (!success) {
            return AjaxResult.error();
        }
        return AjaxResult.success();
    }

    @GetMapping("/downloadPicture/{productId}")
    public AjaxResult downloadPicture(@PathVariable("productId") Long productId, HttpServletResponse response) throws IOException {
        File file = iUploadService.download(productId);
        if (file == null) {
            return AjaxResult.error("商品不存在");
        }
        byte[] bytes = new byte[1024];
        try (OutputStream os = response.getOutputStream();
             FileInputStream fis = new FileInputStream(file)) {
            while ((fis.read(bytes)) != -1) {
                os.write(bytes);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return AjaxResult.success();
    }

}
