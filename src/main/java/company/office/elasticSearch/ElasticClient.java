package company.office.elasticSearch;


import java.net.UnknownHostException;

public class ElasticClient  {

    /**
     * ElasticSearch 适用于海量的数据
     * 以文档的格式存储，
     * 创建index，也就是索引，也就是数据库
     * 数据库里面就会有表，索引里面就有type，也就是类型
     * 添加记录，也就是doucment文档。
     * 字段（filed）就相当于mapping,对于数据字段描述。
     * 倒排索引，基于索引来搜索，也有自己的查询语言，json格式的，
     * 也是支持restful的结构
     * curl www.baidu.com 请求百度首页的数据
     * @param ipAddress
     * @param port
     */
    public  ElasticClient(String ipAddress , Integer port) throws UnknownHostException {
            System.out.println("死亡如风，常伴吾身！");

    }


}
