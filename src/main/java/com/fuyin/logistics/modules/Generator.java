package com.fuyin.logistics.modules;

import com.fuyin.logistics.modules.sys.generator.JdbcGenUtils;

/**
 * 代码生成器
 */
public class Generator {

    public static void main(String[] args) throws Exception {

        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/testdb?useUnicode=true&characterEncoding=utf-8";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";

        String tablePrefix = "gen_";

        String javaModule = "test";
        String webModule = "test";

        JdbcGenUtils.generatorCode(jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword, tablePrefix, javaModule, webModule);

    }

}
