package com.ruoyi.web.controller.main;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.entity.Files;
import com.ruoyi.system.service.IFileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * 文件相关接口
 */
@RestController
@RequestMapping("/file")
public class FileController {
    private final String serverIp = "localhost";

    @Resource
    private IFileService fileService;

    /**
     * 上传图片接口
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload/JPEG")
    public String uploadJPEG(MultipartFile file) throws IOException {
        return upload(file, "D:\\ZFiend\\Project\\RuoYi-Vue-master\\data\\allImages\\");
    }

    /**
     * 文件上传接口
     *
     * @param file
     * @return
     * @throws IOException
     */
    public String upload(MultipartFile file, String folder) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();
        /*  先存储到磁盘  */
        File uploadParentFile = new File(folder);
        //  判断配置的文件目录是否存在，不存在就创建新的文件目录
        if (!uploadParentFile.exists()) {
            uploadParentFile.mkdirs();
        }
        //  定义一个文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();
//        File uploadFile = new File(folder + uuid + StrUtil.DOT + type);
        //  获取文件的md5
        String md5 = SecureUtil.md5(file.getInputStream());
        //  查询文件的md5是否存在
        Files files = fileService.getOne(md5);

        //  获取文件的url
        String url;
        Files saveFile = new Files();
        url = "http://" + serverIp + ":9090/file/" + folder + uuid + StrUtil.DOT + type;
        //  通用属性
        saveFile.setUrl(url);
        saveFile.setSize(size / 1024);
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setDid(-1);
        saveFile.setTime(DateUtil.now());
        fileService.saveOrUpdate(saveFile);
        return url;
    }

    @GetMapping("/page")
    public AjaxResult getImgs() {
        return AjaxResult.success(fileService.getList());
    }

    @GetMapping("/run")
    public AjaxResult run() {

        // Java调用 dos命令
        String cmd = "D:\\ZFiend\\Project\\RuoYi-Vue-master\\detect.py";
        String command = "cmd.exe /c cd"
                + cmd //此处插入python文件的路径
                + "&& start python xxx.py " +
                "-f C:\\Users\\l00018749\\Desktop\\demo\\";//这里利用了python的命令行机制可以传入参数
        try {
            Process p = Runtime.getRuntime().exec(command);
            return AjaxResult.success();
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.error();
        }
    }
}
