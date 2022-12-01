package com.ruoyi.system.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

/**
 * mybatis-plus
 * 代码生成器
 */
public class Generator {

    public static void main(String[] args) {
        generate();
    }

    private static void generate() {
        FastAutoGenerator.create("jdbc:mysql://:3306/insect_identification?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false",
                        "root", "030212")
                .globalConfig(builder -> {
                    builder.author("邹永靖") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\ZFiend\\Project\\RuoYi-Vue-master\\ruoyi-system\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.ruoyi.system") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\ZFiend\\Project\\RuoYi-Vue" +
                                    "-master\\ruoyi-system\\src\\main\\resources\\mapper\\system\\")); // 设置mapperXml
                    // 生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok(); //  提供lombok
                    builder.controllerBuilder().enableHyphenStyle()  // 开启驼峰转连字符
                            .enableRestStyle();  // 开启生成@RestController 控制器
                    builder.addInclude("detect") // 设置需要生成的表名
                            .addTablePrefix("t_", "sys_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
