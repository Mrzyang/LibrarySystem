##                                 Java图书管理系统

> 基于jsp+servlet+JavaBean  (临时服务器访问异常，但是代码是没error的)
#### 基本信息：

- **开发环境**： windows+jdk1.8+Tomcat9+IDEA+mysql
注意：我用的IDE是`jetbrains IntelliJ IDEA`，不知道导入Eclipse会出现什么问题。
- **注意事项**：调试之前请创建名为library的数据库，相关sql脚本为项目根目录下`library.sql`.
- **存在问题**: 会因为Tomcat的版本而出现部分异常
- **关于图片**: 本项目涉及图片上传与富文本编辑器，但是，每当我们开始Run或者Debug项目，`tomcat/webapps/ROOT`这个项目会被清空然后重新写入编译好的Java代码。由于图片保存在本项目`src/main/webapp/assets/bookImg`下，所以每次运行，项目图片会清空。当然也可以将图片写入项目目录外部，但是前台展示图片用绝对路径的话就相当麻烦了，此处我不纠结了。只要tomcat一直开着，图片上传是完全没问题的。
- **在线预览**： [图书管理系统](http://zyang.top:8080/LibrarySystem),用户名密码都为`admin`。目前放在新浪SEA容器上(渣渣配置，只分配256M内存，按小时和流量计费，求各位大佬扫底部二维码施舍点)，如果你也想把项目部署到WEB上，不妨点击[此链接](https://www.sinacloud.com/public/login/inviter/gaimrn-mddmzeKWrhKW3aIF4jWh9eJtrfnymdg.html)注册`新浪SEA`并`实名认证`，可免费试用几天，还可以延长我的天数，何乐而不为呢！我的Centos服务器不知道为啥不能正常运行。
#### 项目预览：


1. **后台主页**：


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/home.png)

2. **修改信息**：


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/update.png)

3. **详细信息**：


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/detail.png)


4. **欢迎赞助**：
> 求打赏已买服务器继续折腾部署的问题


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/alipay.png)

    邮箱:   phpzy@foxmail.com  欢迎交流技术(应付作业的勿扰，该程序实现简单，个人时间有限)
    CSDN:https://blog.csdn.net/qq_32388977
    2018-4-14

