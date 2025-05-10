package com.agric.myagric.controller;
import com.agric.myagric.pojo.*;
import com.agric.myagric.service.UserService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import com.agric.myagric.utils.JwtUtil;
import com.agric.myagric.utils.Md5Util;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"/user"},method = RequestMethod.OPTIONS)
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final String AVATAR_FOLDER = "D:/importantFiles/Graduation Design 2024/MyAgric/src/main/resources/static/user/avatars/";

    @PostMapping("/register")
    public Result Register(@Pattern(regexp = "^\\d{11}$") String phone, String userid, @Pattern(regexp = "^[a-zA-Z0-9]{1,9}$")String password){
        //查询用户
        System.out.println(phone);
//        if (phone!=null && username!= null && password!=null && phone.length()==11 && password.length()>=8){
        User u;
        u = userService.findByPhone(phone);
        if(u==null){
            userService.register(phone,userid,password);
            return Result.success();
        }else{
            return Result.error("手机号已注册");
        }
    }
    @PostMapping("/login")
    public Result<String> Login(String userid, String password){
        //根据电话号查询用户
        User loginUser = userService.findByPhone(userid);

        if (loginUser==null){
            return Result.error("账户不存在");
        }else{
            if (Md5Util.getMD5String(password).equals(loginUser.getPassword())){
                //登录成功
                Map<String, Object> claims = new HashMap<>();
                claims.put("userid", loginUser.getUserId());
                claims.put("username", loginUser.getUsername());
                String token = JwtUtil.genToken(claims);
                //把token存储到redis中
                ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
                operations.set(token,token,1, TimeUnit.HOURS);
                return Result.success(token);
            }
            else{
                return Result.error("密码错误");
            }
        }

    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(String userid) {
        //根据账户（电话号）查询用户
       /* Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");*/
//        Map<String, Object> map = ThreadLocalUtil.get();
//        String userid = (String) map.get("userid");
        User user = userService.findByPhone(userid);
        System.out.println(user.getAvatarurl());
        return Result.success(user);
    }

    //更新用户信息
    @PostMapping("/updateUserInfo")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PostMapping("/resetpwd")
    public Result resetpwd(String phone,String password) {
        userService.resetpwd(phone,password);
        return Result.success();
    }


    //短信验证
//    @ApiOperation(value = "发送短信")
    @GetMapping("/sendShortmsg")
    public Result<String> toSendMessage(String phone){
        String message = userService.toSendMessage(phone);
        return Result.success(message);
    }

    @GetMapping("/deleteUser")
    public Result<String> deleteUser(String userid){
        userService.deleteUser(userid);
        return Result.success();
    }
    @GetMapping("/addVerifyData")
    public Result addVerifyData(String userid,String realname,String idnumber,String verifytime){
        userService.addVerifyData(userid,realname,idnumber,verifytime);
        return Result.success();
    }
    @GetMapping("/addVerifyCompany")
    public Result addVerifyCompany(String userid,String companyname,String tellphone,String mainactivity,String verifytime){
        userService.addVerifyCompany(userid,companyname,tellphone,mainactivity,verifytime);
        return Result.success();
    }
    /**
     * 检验验证码和密码，校验成功后登录
     */
//    @ApiOperation(value = "检验验证码和密码，校验成功后登录")
    @GetMapping("/checkMsg")
    public Result<String> checkMsg(String phone,String code){
        String message = userService.checkMsg(phone,code);
        return Result.success(message);
    }

    @GetMapping("/getVerifyIDState")
    public Result<UserIdverifydata> getVerifyIDState(String userid){
        UserIdverifydata userIdverifydata = userService.getVerifyIDState(userid);
        return Result.success(userIdverifydata);
    }
    @GetMapping("/getVerifyCompanyState")
    public Result<UserCompanyverifydata> getVerifyCompanyState(String userid){
        UserCompanyverifydata userCompanyverifydata = userService.getVerifyCompanyState(userid);
        return Result.success(userCompanyverifydata);
    }
    @PostMapping("/uploadIDimg")
    public Result<String> uploadIDimg(@RequestParam("file") MultipartFile file,@RequestParam("userid") String userid)throws Exception{
        // 综合考虑：两个位置都上传文件
        //2. 指定文件上传的目录(target/classes/xxx)
        //2.1 文件存储到此位置，可以提供页面的访问（当前target中的内容不会打包上传到服务器上）
        String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/user/verify/idcardimg/";
        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 生成新的文件名
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = userid +extension;

        // 保存文件
        File newFile = new File(uploadDirectory + File.separator + newFilename);
        file.transferTo(newFile);

        // 返回文件的访问路径
        return Result.success("D:/importantFiles/Graduation Design 2024/MyAgric/src/main/resources/static"+"/user/verify/idcardimg/" + newFilename);
//        String path_target = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/user/verify/idcardimg/";
     }

    @PostMapping("/uploadCompanyFiles")
    public Result<String> uploadCompanyFiles(@RequestParam("file") MultipartFile file,@RequestParam("userid") String userid,@RequestParam("i") Integer i)throws Exception{
        // 综合考虑：两个位置都上传文件
        //2. 指定文件上传的目录(target/classes/xxx)
        //2.1 文件存储到此位置，可以提供页面的访问（当前target中的内容不会打包上传到服务器上）
        String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/user/verify/companyfiles/"+userid+"/";
        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 生成新的文件名
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = userid +"_"+String.valueOf(i) +extension;

        // 保存文件
        File newFile = new File(uploadDirectory + File.separator + newFilename);
        file.transferTo(newFile);

        // 返回文件的访问路径
        return Result.success("D:/importantFiles/Graduation Design 2024/MyAgric/src/main/resources/static"+"/user/verify/companyfiles/" + newFilename);
//        String path_target = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/user/verify/idcardimg/";
    }

    @PostMapping("/uploadAvatar")
    public Result<String> uploadAvatar(@RequestParam("file") MultipartFile file,@RequestParam("userid") String userid)throws Exception{
        // 综合考虑：两个位置都上传文件
        //2. 指定文件上传的目录(target/classes/xxx)
        //2.1 文件存储到此位置，可以提供页面的访问（当前target中的内容不会打包上传到服务器上）
        String uploadDirectory = System.getProperty("user.dir") + "/src/main/resources/static/user/avatars/";
        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 生成新的文件名
        String originalFilename = file.getOriginalFilename();
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = userid +extension;

        // 保存文件
        File newFile = new File(uploadDirectory + File.separator + newFilename);
        file.transferTo(newFile);

        // 返回文件的访问路径
        return Result.success(newFilename);
//        String path_target = ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/user/verify/idcardimg/";
    }

//    @GetMapping("/getAvatar1")
//    public ResponseEntity<Result<byte[]>> getAvatar1(String filePath){
//        byte[] xx= userService.getAvatar(filePath);
//        Result<byte[]> result = Result.success(xx);
//        ResponseEntity<Result<byte[]>> responseEntity = result.toResponseEntity();
//        return responseEntity;
//    }

    @GetMapping("/getAvatar")
    public byte[] getAvatar(String filePath){
        byte[] xx= userService.getAvatar(filePath);
        return xx;
    }

    @GetMapping("/getRecommendRecordTimeList")
    public Result<List<RecommendHistory>> getRecommendRecordTimeList(String userid){
        List<RecommendHistory> xx= userService.getRecommendRecordTimeList(userid);
        return Result.success(xx);
    }

    @GetMapping("/getAddressBycode")
    public Result<List<AreaVillages>> getAddressBycode(String areacode){
        List<AreaVillages> xx= userService.getAddressBycode(areacode);
        return Result.success(xx);
    }

    @GetMapping("/deleteRecommendRecord")
    public Result deleteRecommendRecord(String userid,String createtime){
        userService.deleteRecommendRecord(userid,createtime);
        return Result.success();
    }

    @GetMapping("/deleteRecommendRecordAll")
    public Result deleteRecommendRecordAll(String userid){
        userService.deleteRecommendRecordAll(userid);
        return Result.success();
    }

}
