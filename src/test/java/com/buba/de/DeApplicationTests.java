package com.buba.de;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DeApplicationTests {

/*
    @Test
    void contextLoads() {

        File file = new File("D:\\kaoshi\\bj\\2019-12-04\\0855.txt");

        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());

    }
*/




  /*  @Test
    public void updateIndex(){
        try{

            String url="http://localhost:8080/solr/solrCore";
            //创建HttpSolrServer发送http请求
            HttpSolrServer server = new HttpSolrServer(url);

            //创建SolrInputDocument文档对象，封装提交到索引库的数据
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", "9999");
            doc.addField("product_name", "战斗机");
            doc.addField("product_price", 10000);
            doc.addField("picture", "1.png");

            //提交数据更新请求
            server.add(doc);

            //提交事务
            server.commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }



    @Test
    public void selectIndex(){

        try{
            String url="http://localhost:8080/solr/solrCore";
            //创建HttpSolrServer发送http请求
            HttpSolrServer server = new HttpSolrServer(url);

            //创建SolrParams对象org.apache.solr.common.params.SolrParams
            SolrQuery params=new SolrQuery();

            //给params对象中封装插叙条件

            //q关键字查询
            //params.set("q", "catalog_name:幽默杂货");
            params.setQuery("家天下情侣款仿真缝纫机音乐");

            //封装过滤查询的条件
            //params.addFilterQuery("product_name:家天下情侣款仿真缝纫机音乐");
            params.addFilterQuery("product_price:[0  TO  20]");

            //查询结果排序
            params.setSort("product_price", SolrQuery.ORDER.asc);

            //封装分页查询参数
            params.setStart(5);
            params.setRows(5);

            //指定需要查询的字段
            params.setFields("id","product_name");


            //指定默认查询字段
            params.set("df", "product_name");


            *//*
             * 实现数据的高亮显示
             * *//*

            //打开高亮显示效果
            params.setHighlight(true);
            //设置高亮字段
            params.addHighlightField("product_name");
            //设置高亮的前缀和后缀
            params.setHighlightSimplePre("<font color='red'>");
            params.setHighlightSimplePost("</font>");


            //查询索引库,返回查询结果
            QueryResponse repsonse = server.query(params);


            //获得响应的文档集合
            SolrDocumentList results = repsonse.getResults();

            //获得高亮数据
            Map<String, Map<String, List<String>>> hls = repsonse.getHighlighting();

            //遍历results集合
            for(SolrDocument doc:results){
                //获得商品id
                Object id = doc.getFieldValue("id");
                Object product_name=doc.getFieldValue("product_name");
                System.out.println(id);
                System.out.println(doc.getFieldValue("product_name"));
                System.out.println(doc.getFieldValue("catalog"));
                System.out.println(doc.getFieldValue("catalog_name"));
                System.out.println(doc.getFieldValue("product_price"));
                //System.out.println(doc.getFieldValue("product_description"));
                System.out.println(doc.getFieldValue("picture"));

                //获得某个商品对应高亮数据
                Map<String, List<String>> map = hls.get(id);

                //获得某个商品的某个字段对应高亮数据
                List<String> list = map.get("product_name");

                if(list!=null&&list.size()>0){
                    product_name=list.get(0);
                }
                System.out.println(product_name);
                System.out.println("=======================================");

                //
                //DocumentObjectBinder


            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
*/
}
