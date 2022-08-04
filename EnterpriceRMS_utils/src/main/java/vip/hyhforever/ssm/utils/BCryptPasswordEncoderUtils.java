package vip.hyhforever.ssm.utils;
/*
 * 作者：JokerShaco
 * 创建时间：2022/7/29 , 21:24
 * 功能描述：对项目中需要进行加密的内容进行加密的工具类
 * */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

/*    public static void main(String[] args) {
        String str = "123456";
        System.out.println(BCryptPasswordEncoderUtils.encodePassword(str));
    }*/
}
