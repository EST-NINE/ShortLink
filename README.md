# ShortLink 短链接项目开发

从零到一实现一个 SaaS短链接服务项目。

## 简介

短链接（Short Link）是指将一个原始的长 URL（Uniform Resource Locator）通过特定的算法或服务转化为一个更短、易于记忆的
URL。短链接通常只包含几个字符，而原始的长 URL 可能会非常长。

短链接的原理非常简单，通过一个原始链接生成个相对短的链接，然后通过访问短链接跳转到原始链接。

如果更细节一些的话，那就是：

1. **生成唯一标识符**：当用户输入或提交一个长 URL 时，短链接服务会生成一个唯一的标识符或者短码。
2. **将标识符与长 URL 关联**：短链接服务将这个唯一标识符与用户提供的长 URL 关联起来，并将其保存在数据库或者其他持久化存储中。
3. **创建短链接**：将生成的唯一标识符加上短链接服务的域名（例如：http://nine.ink ）作为前缀，构成一个短链接。
4. **重定向**：当用户访问该短链接时，短链接服务接收到请求后会根据唯一标识符查找关联的长 URL，然后将用户重定向到这个长 URL。
5. **跟踪统计**：一些短链接服务还会提供访问统计和分析功能，记录访问量、来源、地理位置等信息。

短链接经常出现在咱们日常生活中，大家总是能在某些活动节日里收到各种营销短信，里边就会出现短链接。帮助企业在营销活动中，识别用户行为、点击率等关键信息监控。

主要作用包括但不限于以下几个方面：

- **提升用户体验**：用户更容易记忆和分享短链接，增强了用户的体验。
- **节省空间**：短链接相对于长 URL 更短，可以节省字符空间，特别是在一些限制字符数的场合，如微博、短信等。
- **美化**：短链接通常更美观、简洁，不会包含一大串字符。
- **统计和分析**：可以追踪短链接的访问情况，了解用户的行为和喜好。

## 快速启动

### 一：后端(Java)
#### 1. 克隆项目到本地
```
git clone git@github.com:EST-NINE/shortlink.git
```
#### 2. 导入到 IDE
```
IDEA 导入 Maven 项目，等待依赖下载完成。(jdk版本要求为17，maven版本要求为3.9.6+)
```
#### 3. 配置数据库
```
在 admin，gateway，project 包下修改 application.yml 中配置 mysql，redis 数据库连接信息
执行 resource 包 link.sql 和 link_data.sql 初始化数据库表结构。
```
#### 4. 更改其他配置文件
```
1. 修改短链接的域名，默认为 nine.ink(如在本地测试，请修改为 http://localhost:8080)
2. 在 project 的application.yml 中配置跳转链接白名单，受限于网络安全规则，短链接跳转的目标网址仅支持 拿个offer、知乎、掘金、博客园、百度域名下所属链接。(本地测试可自行多加白名单)
```
#### 5. 启动项目
```
首先先在本地启动 redis，nacos 服务
然后再启动 admin，gateway，project 三个服务即可。
```

### 二：前端(Vue)
#### 1. 克隆项目到本地
```bash
git clone git@github.com:EST-NINE/shortlink.git
```
#### 2. 切换目录
```bash
cd console-vue
```
#### 3. 安装依赖
```bash
npm install
```
#### 4. 启动项目
```bash
npm run serve
```

## 技术架构
在系统设计中，采用最新 JDK17 + SpringBoot3&SpringCloud 微服务架构，构建高并发、大数据量下仍然能提供高效可靠的短链接生成服务。

## 官方文档
- 🔥官方 SaaS 短链接系统代码仓库：[https://gitee.com/nageoffer/shortlink](https://gitee.com/nageoffer/shortlink)
-  什么是 SaaS 短链接系统：[https://nageoffer.com/shortlink](https://nageoffer.com/shortlink)
-  官方 SaaS 短链接视频教程：[https://nageoffer.com/shortlink/video](https://nageoffer.com/shortlink/video)
---


