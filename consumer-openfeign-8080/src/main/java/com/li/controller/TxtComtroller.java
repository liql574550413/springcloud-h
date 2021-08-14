package com.li.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


/**
 * @author liql
 * @date 2021/8/14
 */
@Controller
@Slf4j
public class TxtComtroller {

    @ResponseBody
    @PostMapping("/txt")
    public void text(MultipartFile file) throws IOException {
        String contentType = file.getContentType();
        System.out.println(contentType);
        Reader read = new InputStreamReader(file.getInputStream(), "GBK");
        BufferedReader reader = new BufferedReader(read);
        String tmpString = null;
        //一行一行的读取文件里面的内容
        StringBuilder ans=new StringBuilder(); ;
        while((tmpString = reader.readLine()) != null){
            ans.append(tmpString) ;//保存在ans里面
        }
//        if(ans == null || ){
//            System.out.println("内容为空");
//        }
        //String s = ans.toString().replaceAll(" ", "");
        log.info(ans.toString());
        try {
            JSONArray json =  new JSONArray(ans.toString() );
            System.out.println(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        JSONArray array = object.getJSONArray("Node"); // put in whatever your JSON data name here, this will get you an array of all the nodes
//
//        ArrayList<Node> nodeList = new ArrayList(array.length());
//        for(int i=0; i<array.length(); i++){ // loop through the nodes
//            JSONObject temp = array.getJSONObject(i);
//           // nodeList.get(i).setType(temp.getString("type")); //start setting the values for your node...
//
//        }

//        file.
//        try {
//            InputStreamReader isr = null;
//
//                isr = new InputStreamReader(new FileInputStream(file), "gbk");
//
//            BufferedReader br = new BufferedReader(isr);
//            StringBuffer resposeBuffer = new StringBuffer("");
//            String lineTxt = null;
//            while ((lineTxt = br.readLine()) != null) {
//                //lineTxt = new String(lineTxt.getBytes(), "utf-8");
//                JSONObject object = new JSONObject(lineTxt);
//                System.out.println(object);
//            }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
    }
}
