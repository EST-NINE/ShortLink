# 🔥SaaS 短链接项目开发

从零到一实现一个 SaaS短链接服务项目。

## 简介

短链接（Short Link）是指将一个原始的长 URL（Uniform Resource Locator）通过特定的算法或服务转化为一个更短、易于记忆的
URL。短链接通常只包含几个字符，而原始的长 URL 可能会非常长。

短链接的原理非常简单，通过一个原始链接生成个相对短的链接，然后通过访问短链接跳转到原始链接。

如果更细节一些的话，那就是：

1. **生成唯一标识符**：当用户输入或提交一个长 URL 时，短链接服务会生成一个唯一的标识符或者短码。
2. **将标识符与长 URL 关联**：短链接服务将这个唯一标识符与用户提供的长 URL 关联起来，并将其保存在数据库或者其他持久化存储中。
3. **创建短链接**：将生成的唯一标识符加上短链接服务的域名（例如：https://nine.ink 或者 [nine.ink](https://nine.ink) ）作为前缀，构成一个短链接。
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
IDEA 导入 Maven 项目，等待依赖下载完成。( jdk 版本要求为17，maven 版本要求为3.9.6+)
```
#### 3. 配置 Mysql 数据库
```
1. 在 admin，gateway 包下修改 shardingsphere-config-dev.yaml 中配置 mysql 数据库连接信息

2. 执行 resources/database 包 link.sql 和 link_data.sql 初始化数据库表结构。
```

#### 4. 配置 Redis 服务
```
在 admin，gateway，project 包下修改 application.yml 中配置 redis 连接信息
（注：这里的 redis 版本要求为5.0+，不然启动会报错）
```

#### 5. 更改其他配置文件(修改 project 包下的 application.yml)
```
1. 配置短链接的域名${short-link.domain.default}，默认为 nine.ink
(注：如在本地测试，请修改为 http://localhost:8081)

2. 配置跳转链接白名单，默认全部开放
(注：正式上线部署需注意网络安全规则，将${short-link.goto-domain.white-list.enable} 设置为 true，并配置${short-link.goto-domain.white-list.details}，防止恶意跳转)

3. 如需使用高德地图统计短链接访问地理位置，自行${short-link.stats.locale.amap-key}
(注：不配置也不影响正常使用)
```

#### 6. 启动项目
```
1. 首先先在本地启动 redis，nacos 服务

2. 然后再依次启动 project, admin, gateway， 三个服务即可。
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
npm run dev
```

## 技术架构
在系统设计中，采用最新 JDK17 + SpringBoot3&SpringCloud 微服务架构，构建高并发、大数据量下仍然能提供高效可靠的短链接生成服务。

## 项目亮点
短链接项目采用 SaaS 方式开发。"SaaS"代表“软件即服务”（Software as a Service），与传统的软件模型不同，SaaS 不需要用户在本地安装和维护软件，而是通过互联网直接访问在线应用程序。

- **海量并发**：可能会面对大量用户同时访问的情况，尤其在高峰期，这会对系统的性能和响应速度提出很高的要求。
- **海量存储**：可能需要存储大量的用户数据，包括数据库、缓存等，需要足够的存储空间和高效的存储管理方案。
- **多租户场景**：通常支持多个租户共享同一套系统，需要保证租户间的数据隔离、安全性和性能。
- **数据安全性**：需要保证用户数据的安全性和隐私，防止未经授权的访问和数据泄露。
- **扩展性&可伸缩性**：需要具备良好的扩展性，以应对用户数量和业务规模的增长。


## 官方文档
-  官方 SaaS 短链接系统代码仓库：[https://github.com/nageoffer/shortlink](https://github.com/nageoffer/shortlink)
-  什么是 SaaS 短链接系统：[https://nageoffer.com/shortlink](https://nageoffer.com/shortlink)
-  官方 SaaS 短链接视频教程：[https://nageoffer.com/shortlink/video](https://nageoffer.com/shortlink/video)
---


