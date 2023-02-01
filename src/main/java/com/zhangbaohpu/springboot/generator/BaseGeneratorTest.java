package com.zhangbaohpu.springboot.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.zhangbaohpu.springboot.common.base.BaseController;
import com.zhangbaohpu.springboot.common.base.SuperMapper;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;

/**
 * @author zhangbaohpu
 * @date 2022/12/7 11:59
 * @desc
 */
public class BaseGeneratorTest {
    /**
     * 执行数据库脚本
     */
    protected static void initDataSource(DataSourceConfig dataSourceConfig) throws SQLException {
        Connection conn = dataSourceConfig.getConn();
        InputStream inputStream = BaseGeneratorTest.class.getResourceAsStream("/sql/init.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig(String outputDir,String author) {
        return new GlobalConfig.Builder()
                .fileOverride() // 覆盖已生成文件
                .disableOpenDir() // 禁止打开输出目录
                .outputDir(outputDir)
                .author(author)
                .enableSwagger() // 开启 swagger 模式
                .commentDate("yyyy-MM-dd");
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig(String parent, String moduleName,String xmlPath) {
        return new PackageConfig.Builder()
                .parent(parent)
                .moduleName(moduleName)
                .entity("entity")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .controller("controller")
                .xml("mybatis")
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, xmlPath)) // 设置mapperXml生成路径
                ;
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder()
                .entity("/vm/entity.java.vm")
                .service("/vm/service.java.vm")
                .serviceImpl("/vm/serviceImpl.java.vm")
                .mapper("/vm/mapper.java.vm")
                .mapperXml("/vm/mapper.xml.vm")
                .controller("/vm/controller.java.vm")
                ;
    }

    /**
     * 策略配置
     */
    protected static StrategyConfig.Builder strategyConfig(String tableName, String tablePre,Class<?> superClazz,IdType idType) {
        StrategyConfig.Builder builder = new StrategyConfig.Builder()
                .enableSkipView() //开启大写命名
                .enableSkipView() //开启跳过视图
                .addInclude(tableName) // 需要生成的表
                .addTablePrefix(tablePre); //表前缀
        /**
         * entityBuilder
         */
        builder.entityBuilder().superClass(superClazz)
                .enableLombok() //开启lombok
                .enableTableFieldAnnotation() // 开启字段注释
                .enableActiveRecord() //开启 ActiveRecord 模型
                .logicDeleteColumnName("del_flag")
                .addSuperEntityColumns("remarks","create_by","create_date","update_by","update_date","del_flag")
                .idType(idType) // 主键类型
                .addTableFills(new Column("create_date", FieldFill.INSERT))
                .addTableFills(new Property("updateDate", FieldFill.INSERT_UPDATE));
        /**
         * mapperBuilder
         */
        builder.mapperBuilder().superClass(SuperMapper.class)
                .enableBaseResultMap() //启用 BaseResultMap 生成
                .enableBaseColumnList() //启用 BaseColumnList
                .formatMapperFileName("%sMapper")
                .formatXmlFileName("%sMapper");
        /**
         * serviceBuilder
         */
        builder.serviceBuilder().superServiceClass(IService.class)
                .superServiceImplClass(ServiceImpl.class)
                .formatServiceFileName("%sService")
                .formatServiceImplFileName("%sServiceImpl");
        /**
         * controllerBuilder
         */
        builder.controllerBuilder().superClass(BaseController.class)
                .formatFileName("%sController");
        return builder;
    }

    /**
     * 注入配置
     */
    protected static InjectionConfig.Builder injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        });
    }
}
