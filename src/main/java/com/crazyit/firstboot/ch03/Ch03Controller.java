package com.crazyit.firstboot.ch03;

import com.crazyit.firstboot.ch03.domain.Book;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class Ch03Controller {
    // 定义文件上传的目录
    @Value("${file.upload-folder}")
    private String path;

    @PostMapping("/addMyBook")
    public String add(@Validated Book book, Errors errors, Model model, ServletRequest request) throws IOException {
        // 如果文件不是图片
        if (!book.getCover().getContentType().toLowerCase().startsWith("image")) {
            errors.rejectValue("cover", null, "只能上传图片");
        }
        // 如果文件大小大于2MB
        if (book.getCover().getSize() > 2 * 1024 * 1024) {
            errors.rejectValue("cover", null, "图片大小不能超过2MB");
        }
        // 如果校验失败
        if (errors.getErrorCount() > 0) {
            return "index";
        } else {
            var f = new File(path);
            // 如果path对应的路径不存在，则创建该目录
            if (!f.exists()) {
                f.mkdir();
            }
            System.out.println(f.getAbsoluteFile());
            // 调用MultipartFile的getOriginalFilename()方法获取原始文件名
            // 然后调用StringUtils的getFilenameExtension获取扩展名
            var extName = StringUtils.getFilenameExtension(book.getCover().getOriginalFilename());
            var targetName = UUID.randomUUID().toString() + "." + extName;
            // 调用MultipartFile的transferTo()方法完成文件复制
            book.getCover().transferTo(new File(path + targetName));
            book.setTargetName(targetName);
            System.out.println("添加的图书: " + book.getName());
            model.addAttribute("tip",book.getName()+"图书添加成功!");
            return "success";
        }
    }
}
