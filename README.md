## 基于Java+Springboot+Vue的宠物医院系统086

## 一、系统介绍

本项目前后端分离

本系统分为管理员、医生、用户三种角色

用户角色包含以下功能：
- 登录、注册、宠物列表、健康指南、预约列表、宠物日志、健康标准、宠物健康史、个人中心、密码修改

医生角色包含以下功能：
- 登录、宠物列表、健康指南、宠物日志、健康标准管理、预约列表管理、宠物健康史、个人中心、密码修改

管理员角色包含以下功能：
- 登录、数据报表、用户管理、宠物管理、健康指南、宠物日志、健康标准、预约列表、宠物健康史、角色管理、菜单管理、文件管理、个人中心、密码修改

## 二、所用技术

后端技术栈：

- Springboot
- MybatisPlus
- Mysql
- Jwt

前端技术栈：

- Elementui
- Vue
- Axios
- Vue-Router



## 三、环境介绍

基础环境 :IDEA/eclipse, JDK1.8, Mysql5.7及以上,Node.js(14),Maven3.6

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、页面截图

![contents](./picture/picture1.png)
![contents](./picture/picture2.png)
![contents](./picture/picture3.png)
![contents](./picture/picture4.png)
![contents](./picture/picture5.png)
![contents](./picture/picture6.png)
![contents](./picture/picture7.png)
![contents](./picture/picture8.png)
![contents](./picture/picture9.png)
![contents](./picture/picture10.png)
![contents](./picture/picture11.png)
![contents](./picture/picture12.png)
![contents](./picture/picture13.png)
![contents](./picture/picture14.png)
![contents](./picture/picture15.png)
![contents](./picture/picture16.png)
![contents](./picture/picture17.png)
![contents](./picture/picture18.png)
![contents](./picture/picture19.png)
![contents](./picture/picture20.png)
![contents](./picture/picture21.png)
![contents](./picture/picture22.png)
![contents](./picture/picture23.png)
![contents](./picture/picture24.png)
![contents](./picture/picture25.png)
![contents](./picture/picture26.png)
![contents](./picture/picture27.png)
![contents](./picture/picture28.png)
![contents](./picture/picture29.png)
![contents](./picture/picture30.png)
![contents](./picture/picture31.png)
![contents](./picture/picture32.png)
![contents](./picture/picture33.png)
![contents](./picture/picture34.png)

## 五、浏览地址

访问地址：http://localhost:8080

-用户账号/密码：user/123

-医生账号/密码：doctor/123

-管理员账号/密码：admin/admin

## 六、部署教程

1. 使用Navicat或者其它工具，在mysql中创建对应名称的数据库，并执行项目的sql文件；

2. 使用IDEA/Eclipse导入petService项目，若为maven项目请选择maven，等待依赖下载完成；

3. 进入src/main/resources修改application.yml 里面的数据库配置和文件目录地址

4. src/main/java/com/qingge/springboot/SpringbootApplication.java 启动后端项目

5. vscode或idea打开petWeb项目，

6. 在编译器中打开terminal，执行npm install 依赖下载完成后执行 npm run serve,执行成功后会显示访问地址





