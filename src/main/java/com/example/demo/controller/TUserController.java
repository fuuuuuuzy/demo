package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.TUser;
import com.example.demo.json.TUserJson;
import com.example.demo.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/tuser")
public class TUserController {
    @Autowired
    TUserService service;
    int verifyCode;

    @RequestMapping("/selectOne/{id}")
    @ResponseBody
    public TUser selectById(@PathVariable int id){
        TUser user = service.selectTUserById(id);
        return user;
    }

    @RequestMapping("/loginValid")
    @ResponseBody
    public TUserJson loginValid(@RequestParam("username")String username,@RequestParam("password")String password, Model model){
        TUserJson json = new TUserJson();
        TUser user = service.selectTUserByName(username);
        if ((md5Password(password)).equals(user.getTuserPassword())){
            json.setTuser(user);
            json.setFlag(true);
            json.setMsg("登录成功");
            model.addAttribute("user",user);
            return json;
        }else {
            json.setFlag(false);
            json.setMsg("用户名或密码错误");
            return json;
        }
    }

    @RequestMapping("/regist")
    public String showRegist(){
        return "regist";
    }

    /**
     * 注册验证，账号不可重复
     * @param userRegist
     * @return
     */
    @RequestMapping("/registValid")
    @ResponseBody
    public TUserJson registValid(@ModelAttribute TUser userRegist, @RequestParam("validNumber") int validNumber){
        TUserJson json = new TUserJson();
        String name = userRegist.getTuserName();
        if ((validNumber==verifyCode)||true){
            if ((service.selectTUserByName(name))!=null){
                json.setFlag(false);
                json.setMsg("账号已注册");
            }else {
                userRegist.setTuserPassword(md5Password(userRegist.getTuserPassword()));
                service.insertTUser(userRegist);
                json.setFlag(true);
                json.setTuser(userRegist);
                json.setMsg("注册成功");
            }
        }else {
            json.setFlag(false);
            json.setMsg("验证码输入错误");
        }
        return json;
    }

    @RequestMapping("/getValidNumber")
    @ResponseBody
    public String getValidNumber(){
        String url = "https://api.apishop.net/common/verify/getSimpleVerifyImage";
        Map<String, String> params = new HashMap<>();
        params.put("apiKey", "HhusY7x9b678604bf790809d14ffecaf8ea4eb99f3f5bf4");
        params.put("codeType", "1");
        String result = proxyToDesURL(url,params);
        if (result!=null){
            JSONObject jsonObject = JSONObject.parseObject(result);
            String status_code = jsonObject.getString("statusCode");
            if (status_code.equals("000000")) {
                String filename = jsonObject.getJSONObject("result").getString("fileName");
                verifyCode = jsonObject.getJSONObject("result").getInteger("verifyCode");
                return filename;
            }
        }else {
            System.out.println("发送请求失败");
        }
        return null;
    }

    public static String proxyToDesURL(String url, Map<String, String> params) {
        try {
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            HttpHeaders requestHeaders = new HttpHeaders();
            //处理请求参数
            MultiValueMap<String, String> paramList = new LinkedMultiValueMap<>();
            if (params != null && !params.isEmpty()) {
                Set<String> set = params.keySet();
                for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
                    String key = iterator.next();
                    String value = params.get(key);
                    paramList.add(key, value);
                }
            }
            requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(paramList, requestHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, params);
            return responseEntity.getBody();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return null;
    }

    /**
     * md5加盐
     * @param password
     * @return
     */
    public static String md5Password(String password) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }

    }

}
