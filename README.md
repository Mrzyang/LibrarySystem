##                                 Java图书管理系统

> 基于jsp+servlet+JavaBean  (临时服务器访问异常，但是代码是没error的)
#### 基本信息：

- **开发环境**： windows 10+jdk1.8+Tomcat9+IntelliJ IDEA+mysql 5.7
- **注意事项**： sql脚本为项目根目录下`library.sql`.
- **存在问题**: 会因为Tomcat的版本而出现部分异常
- **关于图片**: 本项目涉及图片上传与富文本编辑器，但是，每当我们开始Run或者Debug项目，`tomcat/webapps/ROOT`这个项目会被清空然后重新写入编译好的Java代码。由于图片保存在本项目`src/main/webapp/assets/bookImg`下，所以每次运行，项目图片会清空。当然也可以将图片写入项目目录外部，但是前台展示图片用绝对路径的话就相当麻烦了，此处我不纠结了。只要tomcat一直开着，图片上传是完全没问题的。
#### 项目预览：


1. **后台主页**：


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/home.png)

2. **修改信息**：


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/update.png)

3. **详细信息**：


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/detail.png)


4. **欢迎赞助**：
> 求打赏已买服务器继续折腾部署的问题


![image](https://github.com/Mrzyang/LibrarySystem/blob/master/src/main/webapp/assets/images/github/aw.png)

    邮箱:   phpzy@foxmail.com  欢迎交流技术
    本人大厂6年研发经验，接定制开发网站、app、微信小程序、毕业设计、学术论文
    2018-4-14

