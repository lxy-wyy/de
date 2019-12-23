package com.buba.de.controller;

import com.buba.de.pojo.ApiOSSInfoDTO;
import com.buba.de.pojo.Limits;
import com.buba.de.pojo.User;
import com.buba.de.service.UserService;
import com.buba.de.utils.OSSUtils;
import com.buba.de.utils.OssConstant;
import com.buba.de.utils.Redis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService us;


    //登录
    @RequestMapping("login")
    @ResponseBody
    public User fun(String bianhao, HttpSession session, String password) {
        User user = new User();
        user.setBianhao(bianhao);
        user.setPassword(password);
        if (user != null) {
            User u = us.getUser(user);
            session.setAttribute("user", u);
            System.out.println(u);
            return u;
        } else {
            System.out.println(user);
            return user;
        }
    }


    //查询权限
    @RequestMapping("getlimits")
    @ResponseBody
    public List<Limits> fun2(HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getId());
        List<Limits> getlimits = us.getlimits(user.getId());
        return getlimits;
    }


    @RequestMapping("ossPic")
    public String fun33(MultipartFile file) throws IOException {
        ApiOSSInfoDTO info = new ApiOSSInfoDTO();
        //endpoint：阿里云服务器地址
        info.setEndopint(OssConstant.OSS_PARAMETER_ENDOPINT);
        //accessKeyId：连接阿里云的accessKeyId
        info.setAccessKeyId(OssConstant.OSS_PARAMETER_ACCESSKEYID);
        //accessKeySecret：连接阿里云的accessKeyScret
        info.setAccessKeySecret(OssConstant.OSS_PARAMETER_ACCESSKEYSECRET);
        //文件夹的名称，不存在即创建
        info.setDir(OssConstant.OSS_PARAMETER_DEMO_DIR);
        //bucketName：阿里云bucketName的名称
        info.setBucketName(OssConstant.OSS_PARAMETER_BUCKETNAME);
        List<File> files = new ArrayList<>();


        File file2 = new File("D://ppp//" + UUID.randomUUID().toString().replace("-", "") + ".jpg");
        file.transferTo(file2);

        //files：文件流
        files.add(file2);
        OSSUtils.putUpload(files);


        return "picoss";




      /*  JSONObject ret = new JSONObject();
        String key = "";
        String fileNames = "";
        ret.put("success", false);
        ret.put("msg", "请求失败[PU01]");
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                fileNames = file.getOriginalFilename();
                InputStream input = file.getInputStream();

                // 创建OSSClient实例
                OSSClient ossClient = new OSSClient(OssConstant.OSS_PARAMETER_ENDOPINT, OssConstant.OSS_PARAMETER_ACCESSKEYID, OssConstant.OSS_PARAMETER_ACCESSKEYSECRET);
                // 上传文件流
                ossClient.putObject(OssConstant.OSS_PARAMETER_DEMO_DIR, "yy/" + fileNames, input);
                ossClient.shutdown();
            }
            ret.put("success", true);
            ret.put("msg", key + fileNames);
            System.out.println(("图片上传阿里云 name=" + key + fileNames));

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //
    }


//    @RequestMapping("limits")
//    @ResponseBody
//    public List<Limits> fun3() {
//        List<Limits> getli = us.getli();
//        return getli;
//    }





    public void setJedis() {
        //连接redis服务器(在这里是连接本地的)
        Redis redis = new Redis();
        redis.setJedis();
        redis.getJedis();
        Jedis jedis  = new Jedis("127.0.0.1", 6379);

        System.out.println("连接服务成功");
    }


//    @RequestMapping("limits")
//    @ResponseBody
//    public List<Limits> fun6() {
//        Redis redis = new Redis();
//        redis.setJedis();
//        redis.getJedis();
//        List<Limits> getli = us.getli();
//        redis.getJedis().set("limits", String.valueOf(getli));
//        System.out.println(redis.getJedis().get("limits"));
//        return getli;
//    }
    @RequestMapping("limits")
    @ResponseBody
    public String fun4() {
        Redis redis = new Redis();
        redis.setJedis();
        redis.getJedis();
        List<Limits> getli = us.getli();
        redis.getJedis().set("limits", String.valueOf(getli));
        System.out.println(redis.getJedis().get("limits"));

        if(redis.getJedis().get("limits")!=null){
            return redis.getJedis().get("limits");
        }else {
            return String.valueOf(getli);
        }
    }




    @RequestMapping("dellimits")
    @ResponseBody
    public String fun5(String id) {
        Redis redis = new Redis();
        redis.setJedis();
        redis.getJedis();
        int getli = us.delLi(Integer.parseInt(id));
        redis.getJedis().del("limits");
        System.out.println(redis.getJedis().del("limits"));
        if(redis.getJedis().get("limits")!=null){
            return redis.getJedis().get("limits");
        }else {
            return String.valueOf(getli);
        }
    }




    @RequestMapping("uplimits")
    @ResponseBody
    public String fun7(Limits l) {
        Redis redis = new Redis();
        redis.setJedis();
        redis.getJedis();
        int updateli = us.updateli(l);
        redis.getJedis().set("limits", String.valueOf(l));
        System.out.println(redis.getJedis().get("limits"));

        if(redis.getJedis().get("limits")!=null){
            return redis.getJedis().get("limits");
        }else {
            return String.valueOf(l);
        }
    }





    @RequestMapping("addlimits")
    @ResponseBody
    public String fun9(Limits l) {
        Redis redis = new Redis();
        redis.setJedis();
        redis.getJedis();
        int i = us.insrtLimtis(l);
        redis.getJedis().append("limits", String.valueOf(l));
        System.out.println(redis.getJedis().get("limits"));

        if(redis.getJedis().get("limits")!=null){
            return redis.getJedis().get("limits");
        }else {
            return String.valueOf(l);
        }
    }
















//    @Test
//    public void fun7() {
//
//        Redis redis = new Redis();
//        redis.setJedis();
//        redis.getJedis();
//        List<Limits> getli = us.getli();
////        Limits limits = new Limits();
////        limits.setName("1111");
////        limits.setPid(11);
////        limits.setHref("http://localhost:8083/jsp/zTree.jsp");
////        limits.setId(1);
//
//        redis.getJedis().set("limits", String.valueOf(getli));
//        System.out.println(redis.getJedis().get("limits"));
//    }


}
