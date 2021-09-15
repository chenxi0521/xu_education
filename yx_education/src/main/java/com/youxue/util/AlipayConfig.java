package com.youxue.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author chenxi
 * @date 2021/9/14 16:49
 * @description
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000118617396";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDw3BiCpCE7uHBmzOR8uG8vI6h1xPtGZpL6j6p1ii37mbQrBUbWSDhtlzdl2HfC898tk54nLt8IprWl1QzeLOp24rw4oRwjb5cTUweZQ1LcF43QMUrsxSVVGobT0bqxJXApfuhTsijjfpExNp6MGv9LLZySbyWHORwjVLIxGi/z9yAebH5PeYCo8PkBpq6ewUgIsAraR5aGkpNMiyGyVkwvlXzbYUrIR5HHbVaPYTCpHDcdpvJn28FE1jfR1tmmhdmb5p6X/8DkW4UpriANOUHoFtj6HyGo0mTDzo2lGoZPYeKWYT9eTier/Zx4sAKwB91FmnNyn1TyFXVbkLtCfDPVAgMBAAECggEBAJYTXcZRBFAUzRyQwDGiLcz+d+HhufuUwDIVQE36qkoh7Gv93rR3zYkjdqYj6gN0NvRMDXg2sUvPrFFG3by12eX3wvW6FTFTP5wP2SU7GK8AkiFOBXRgJrHPVIE5Jg1o2WlRpOs5kFanr0ot0T5VOAscwXlQfd6yzACLrnf/7C8i78tGErZQf1lDa6ZU3cLQQnnYvSlZEB3L44YDnAn6BNLIsrg7T3HwF9PxIAv1l3woSYF0H/xQ2g3Vu4mjaqgJqlbHUDuN9Oh3qmx5YBRtDVkk9FCKVqFn7O9W08SLFLtgAVnRjgD1jWXhCrk15acXZdCRGavLFNnnoAtfcPdbPQUCgYEA+9zTnuhA2UwMSbxOwKWBy7uHcabbA+TVNrngsu0GdYNcXDmRBcRZ7SZx2PmYWdwtglVUC42Xu4nSn+3JQfw9Tj2TDta9vFz2KosPMuIuxTDG/nfofIk8Kd/MnQ3CO8PW3E3+TuuboB7/MnXqkOCV9hvfZwHn3ytHGVVI3k57SP8CgYEA9ND/hGq32ayU6RYbzUAyFJC+qAVDWa8S+IsSsCKj29Ve1uODjMub+5tHG+FROj45LeddV+hI1bLKT1eUuMNqECb0Drl203H4f1l+CpclIeTXvYkv2SPVdVemQ//qOoSxSwTEqeEkucuOlnuCx4wLkPZxhDZ1itjjuZj85qWADysCgYEA4P7rBcBRfk1ThON2Lt8rzobefocijJ32Ywc2VmEsLfqFndXHWjGIbDS167E9irkI5q+3fwKkk+KRiFFyQ0JEugqDvvPTV9xsBKFpmHk6cuoaOuV/iRFH79h//6V06NMQtInwLyyHQEmwjLGONJKNJOjNcEXhkBonT9hCWmYd+J0CgYAwYf2dldmv00O6rPvhnIZJOjHz0tZ0qvz80b9nv/DSSWDs5xnggXzaRN3QzL7Y2+NBBzCTZvy9/w+sjop92WDkwE4LeuvY7fVGddFLFoPoJuncM3iZWVOeVSwu1CzeU8sWIGMdj7lKXshXRSGbfjnq9EmK75hbUHHxBCM3Eg408QKBgQDgVhdD3v8omqdXhIclKPfdsCLPegZ87KEkALx0bHo72N923DxawaCL5C3BZxmoyRM9OFMmgxawhJkZNalvDRyLF4LT/2zLgdwxuly8oXd9/bqCJiRVgxc2ZQqOnR3Gv3nun9Nq3aWDUqbDRbTVE1LzqrGrKMuYfTcGVoc7I9koMA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnf36q5Ws7t/XWRAeqNrgMyKjPfoWZ86Qd9yuAvEa5cASodwGO/jyp0SaE0/pj4aILWv/l1NhsoPB+J0Slb5zNhHlQjhq0xU6zKC1+15NHLh6pq+DdS/vjfBSD9RfigC0VMHTMQ768+zL9jCo6d9LF3Y0YwhlL13Cym+uh9QG3uwT+uRFlTGcqcEYInteKT3TqZmAA/e9TVZ9Siibxaw/n+xIBxbPbpei05ZAoWQ/9PuQus24gzLXf4wgvWDR//h5T5rWz3W9E2Ed+G2b7aIsMPTAmO09vMJBZX7FvapGsotYgv9z1cpcabajQ9r3u6QyRMZc1l/XU3cK619+fe0/4wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


