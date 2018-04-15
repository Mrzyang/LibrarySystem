### Java图书管理系统

> 基于jsp+servlet+JavaBean
#### 基本信息：

- **开发环境**： windows+jdk1.8+Tomcat9+IDEA+mysql
注意：我用的IDE是`jetbrains IntelliJ IDEA`，不知道导入Eclipse会出现什么问题。
- **注意事项**：调试之前请创建名为library的数据库，相关sql脚本为项目根目录下`library.sql`.
- **存在问题**: `windows`上运行正常，但是当我部署到`linux`上时，出现验证码完全看不清，我尝试这关闭登录`Filter`，直接进入后台主页，发现无法进入，日后再折腾下，了解Java项目部署的大佬麻烦指点下。
- **关于图片**: 本项目涉及图片上传与富文本编辑器，但是，每当我们开始Run或者Debug项目，`tomcat/webapps/ROOT`这个项目会被清空然后重新写入编译好的Java代码。由于图片保存在本项目`src/main/webapp/assets/bookImg`下，所以每次运行，项目图片会清空。当然也可以将图片写入项目目录外部，但是前台展示图片用绝对路径的话就相当麻烦了，此处我不纠结了。只要tomcat一直开着，图片上传是完全没问题的。

#### 项目预览：
1. **后台主页**：
![image](https://note.youdao.com/yws/api/personal/file/69E496956FE24CB3B9B18A8E005D114B?method=download&shareKey=3564f8c41877cc553ca1664ff0c34dca)

2. **修改信息**：
![image](https://note.youdao.com/yws/api/personal/file/746CC6C604C54662916C0CB9B862EA99?method=download&shareKey=adcf0f218a661ed0449ed5c090108778)

3. **详细信息**：
![image](https://note.youdao.com/yws/api/personal/file/09BFCBCE2CC04D2FAAD7121FB99F74D2?method=download&shareKey=0263bdf82ce29a4d94bf3f81219cfaf9)


    QQ:   846965599  欢迎交流技术
    CSDN:https://blog.csdn.net/qq_32388977
    2018-4-14

