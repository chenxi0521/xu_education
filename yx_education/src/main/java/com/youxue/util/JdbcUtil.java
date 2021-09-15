package com.youxue.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author chenxi
 * @date 2021/9/6 15:37
 * @description
 */
public class JdbcUtil {

    private static ComboPooledDataSource cs = new ComboPooledDataSource();
    private static QueryRunner qr = new QueryRunner(cs);

    public static QueryRunner getQueryRunner(){
        return qr;
    }


}
