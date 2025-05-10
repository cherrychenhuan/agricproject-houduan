package com.agric.myagric.config;


import com.agric.myagric.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录接口和注册接口不拦截"/cropinfo/cropcategorylist"/user/userInfo"
//        registry.allowedOriginPatterns("*")  // 使用 allowedOriginPatterns
//                .allowCredentials(true)
//                .allowedMethods("*")   // 允许跨域的方法，可以单独配置
//                .allowedHeaders("*");  // 允许跨域的请求头，可以单独配置
//        registry.addInterceptor(loginInterceptor).excludePathPatterns("/area/citylist",
//               "/user/resetpwd","/user/checkMsg","/user/sendShortmsg", "/cropinfo/argomanagelist","/argom/argomanagelist","/cropinfo/getVarietyData","/cropinfo/getGenerictypeData","/cropinfo/getCropVarietyList","/cropinfo/getEcotypeList","/updatesoilcropdata","/addsoilcropdata","/recommend/getsoilname","/recommend/getsoilcropdata","/recommend/gethwsddata", "/recommend/getclimatedata" ,"/area/getlocation","/area/arealist","/area/provincelist","/cropinfo/cropcategoryalllist","/cropinfo/getSearchFilterList","/cropinfo/updatecategory","/cropinfo/getRowNum","/cropinfo/addcategory","/upload","/cropinfo/getGenusList","/cropinfo/getNewID","/user/login","/user/register","/cropinfo/cropcategorylist","/cropinfo/deletecategory","/user/userInfo","/face/face");
        //登录接口和注册接口不拦截
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/**","/upload","/cropinfo/**","/user/**","/area/**","/recommend/**","/weather/**","/argomanage/**");
//        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");


    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/res/**").addResourceLocations("file:D:/importantFiles/Graduation Design 2024/MyAgric/src/main/resources/static/user/avatars/");
        registry.addResourceHandler("/verifyid/**").addResourceLocations("file:D:/importantFiles/Graduation Design 2024/MyAgric/src/main/resources/static/user/verify/idcardimg/");
        registry.addResourceHandler("/verifycompany/**").addResourceLocations("file:D:/importantFiles/Graduation Design 2024/MyAgric/src/main/resources/static/user/verify/companyfiles/");
    }



}
