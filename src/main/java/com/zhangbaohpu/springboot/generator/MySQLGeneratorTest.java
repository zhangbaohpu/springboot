package com.zhangbaohpu.springboot.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.zhangbaohpu.springboot.common.base.BaseEntity;

import java.io.File;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 12:02
 * @desc 代码生成器，mybatis-plus-generator版本：3.5.1
 */
public class MySQLGeneratorTest extends BaseGeneratorTest{

    static String url = "jdbc:mysql://192.168.88.71:3306/db_springboot?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&noAccessToProcedureBodies=true";
    static String username = "root";
    static String password = "123456";
    static String database = "db_springboot";

    private static File file = new File("");
    private static String path = file.getAbsolutePath();
    static String outputDir = path+"/src/main/java"; //指定输出目录
    static String author = "zhangbaohpu";
    static String parent = "com.zhangbaohpu.springboot.module"; //父包名
    static String moduleName = "system"; //父包模块名
    static String tableName = "t_role";
    static String tablePre = "t_";
    static IdType idType = IdType.AUTO; // 表主键类型


    static String xmlPath = path+"/src/main/resources/mybatis/"+moduleName; //xml存放目录

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder(url, username, password)
            .schema(database)
            .typeConvert(new MySqlTypeConvert())
            .build();

    public static void main(String[] args) {
        //开始生成
        startGenerator();
    }

    public static void startGenerator() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.global(globalConfig(outputDir,author).build()); //全局配置
        generator.packageInfo(packageConfig(parent,moduleName,xmlPath).build()); //包配置
        generator.strategy(strategyConfig(tableName,tablePre, BaseEntity.class,idType).build()); //策略配置，各个类文件的自定义配置
        generator.template(templateConfig().build()); //模板配置，各个类的生成模板
        generator.execute();
    }
}
