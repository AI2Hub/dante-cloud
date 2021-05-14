<h1 align="center"> Eurynome Cloud </h1>

---

<p align="center">
    <a href="https://www.oracle.com/java/technologies/javase-downloads.html" target="_blank"><img src="https://img.shields.io/badge/JDK-1.8%2B-green" alt="JDK 1.8+"></a>
    <a href="https://spring.io/projects/spring-boot" target="_blank"><img src="https://img.shields.io/badge/Spring%20Boot-2.4.5-blue" alt="Spring Boot 2.4.5"></a>
    <a href="https://spring.io/projects/spring-cloud" target="_blank"><img src="https://img.shields.io/badge/Spring%20Cloud-2020.0.2-blue" alt="Spring Cloud 2020.0.2"></a>
    <a href="https://github.com/alibaba/spring-cloud-alibaba" target="_blank"><img src="https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2021.1-blue" alt="Spring Cloud Alibaba 2021.1"></a>
    <a href="https://nacos.io/zh-cn/index.html" target="_blank"><img src="https://img.shields.io/badge/Nacos-2.0.1-brightgreen" alt="Nacos 2.0.1"></a>
    <a href="./LICENSE"><img src="https://img.shields.io/badge/License-Apache--2.0-blue" alt="License Apache 2.0"></a>
    <a href="https://blog.csdn.net/Pointer_v" target="_blank"><img src="https://img.shields.io/badge/Author-%E7%A0%81%E5%8C%A0%E5%90%9B-orange" alt="码匠君"></a>
    <a href="#" target="_blank"><img src="https://img.shields.io/badge/Version-2.4.5.48-red" alt="Version 2.4.5.48"></a>
    <a href="https://gitee.com/herodotus/eurynome-cloud"><img src="https://gitee.com/herodotus/eurynome-cloud/badge/star.svg?theme=dark" alt="Gitee star"></a>
    <a href="https://gitee.com/herodotus/eurynome-cloud"><img src="https://gitee.com/herodotus/eurynome-cloud/badge/fork.svg?theme=dark" alt="Gitee fork"></a>
</p>

# 如果您觉得有帮助，请点右上角 "Star" 支持一下，谢谢！

## Eurynome Cloud 微服务管理开发平台

Eurynome Cloud是一款从商业平台衍生而来的微服务管理开发平台。基于SpringBoot2.4.5、Spring Cloud 2020.0.2、Spring Cloud Alibaba 2021.1、Nacos 2.0.1等最新版本开发，遵循SpringBoot编程思想，高度模块化和可配置化。具备服务发现、配置、熔断、限流、降级、监控、多级缓存、分布式事务、工作流等功能，代码简洁，架构清晰，非常适合学习和企业作为基础框架使用。

## 1、功能介绍

<img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/eurynome.png"/>

特点：
* 优化的代码分包和包依赖，代码包职责明确，规避无意义的依赖以及重复依赖，对基础依赖组件进行高度封装，降低IDE索引时间，提升开发效率
* 遵循微服开发模式，强化整体的可配置性，依赖功能均可以通过@EnableXXX开启，支持策略化的注入改变部分核心代码的实现逻辑。提供的starter，开箱即用，可零配置创建服务，快速进行开发
* 基于JetCache自研缓存拓展，支持分页和条件查询缓存动态更新
* 拓展OAuth2默认登录，支持多种验证码和登录数据加密传输，可通过配置进行自定义设置。
* 多数据库支持，默认采用Postgresql数据库，同时支持Spring Data Jpa 和Mybatis
* 多种消息队列支持，适配RabbitMQ和Kafka，默认使用Kafka，支持消息总线(Spring Cloud Bus)
* Rest接口自动化扫描生成权限数据，支持扫描包和扫描注解动态配置
* 采用Camunda实现工作流服务，支持在线编辑
* 同时支持分布式和单体式两种架构，基于单体式架构可快速搭建基于OAuth2的前后端分离应用
* 共享式、统一化多环境配置模式，Yml、Docker均采用此方式配置，避免同类配置多出修改的问题

## 2、技术栈和版本说明

### Spring全家桶及核心技术版本
  
组件 | 版本 
---|---|---
Spring Boot | 2.4.5 
Spring Cloud | 2020.0.2 
Spring Cloud Alibaba | 2021.1
Spring Boot Admin | 2.4.1 
Nacos | 2.0.1 |
Sentinel | 1.8.0 |
Seata | 1.3.0 |

> Spring 全家桶版本对应关系，详见：[版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)

### 所涉及的相关的技术有： 

* JSON序列化：Jackson & FastJson 
* 消息队列：Kafka 适配RabbitMQ，支持消息总线(Spring Cloud Bus)
* 数据缓存：JetCache + Redis （两级缓存）
* 数据库： Postgresql，MySQL，Oracle ...
* 前端实现：Vue + Vuetify
* 持久层框架： Spring Data Jpa & Mybatis
* API网关：Gateway
* 服务注册&发现和配置中心: Nacos 
* 服务消费：OpenFeign & RestTemplate & OkHttp3
* 负载均衡：Ribbon
* 服务熔断&降级&限流：Sentinel
* 项目构建：Maven
* 分布式事务：Seata
* 服务监控：Spring Boot Admin
* 链路跟踪：Skywalking
* 文件服务：阿里云OSS/Minio
* 数据调试：p6spy
* 日志中心：ELK
* 日志收集：Logstash Logback Encoder

# 3、 版本号说明

本系统版本号，分为四段。

- 第一段和第二段，与Spring Boot 版本对应，根据采用的Spring Boot版本变更。例如，当前采用Spring Boot 2.4.5版本，那么就以2.4.X.X开头
- 第三段，表示系统功能的变化
- 第四段，表示系统功能维护及优化情况

## 4、工程结构
``` 
eurynome-cloud
├── configurations -- 配置文件脚本和统一Docker build上下文目录
├── dependencies -- 工程Maven顶级依赖，统一控制版本和依赖
├── documents -- 工程相关文档
├── packages -- 基础通用依赖包
├    ├── eurynome-cloud-common -- 公共工具类
├    ├── eurynome-cloud-data -- 数据持久化、数据缓存以及Redis等数据处理相关代码组件
├    ├── eurynome-cloud-rest -- Rest相关代码组件
├    ├── eurynome-cloud-crud -- CRUD相关代码组件
├    ├── eurynome-cloud-sercurity -- Security通用代码
├    ├── eurynome-cloud-oauth -- OAuth2通用代码
├    ├── eurynome-cloud-message -- 消息队列、BUG相关代码组件
├    ├── eurynome-cloud-kernel -- 微服务接入平台必备组件
├    ├── eurynome-cloud-oauth-starter -- 自定义OAuth2 Starter
├    ├── eurynome-cloud-starter -- 微服务核心Starter
├── platform -- 业务模块
├    ├── blade-desk -- 工作台模块 
├    ├── blade-log -- 日志模块 
├    ├── blade-system -- 系统模块 
├    └── blade-user -- 用户模块 
├── services -- 业务模块api封装
├    ├── blade-desk-api -- 工作台api 
├    ├── blade-dict-api -- 字典api 
├    ├── blade-system-api -- 系统api 
└──  └── blade-user-api -- 用户api 
```

## 交流反馈

* 欢迎提交[ISSUS](https://gitee.com/herodotus/eurynome-cloud/issues) ，请写清楚问题的具体原因，重现步骤和环境(上下文)
* 博客：https://zlt2000.gitee.io
* 邮箱：zltdiablo@163.com
个人公众号：陶陶技术笔记
GitChat：https://gitbook.cn/gitchat/author/5b2362320398d50d7b7ab29e

界面预览

<table>
    <tr>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/ui1.png"/></td>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/ui2.png"/></td>
    </tr>
    <tr>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/ui3.png"/></td>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/nacos.png"/></td>
    </tr>
    <tr>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/skywalking.png"/></td>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/sentinel.png"/></td>
    </tr>
    <tr>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/spring-boot-admin-1.png"/></td>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/spring-boot-admin-2.png"/></td>
    </tr>
    <tr>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/oauth2-login1.png"/></td>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/oauth2-login2.png"/></td>
    </tr>
    <tr>
        <td><img src="https://gitee.com/herodotus/eurynome-cloud/blob/master/documents/readme/elk"/></td>
        <td></td>
    </tr>
</table>

# 主要技术栈说明：


logstash-logback-encoder | 6.6 | 使用该组件直接向ELK发送日志
MySQL | 8.0.22 |
PostgreSQL | 12.3-1 |
Redis | 3.2.100 | 为了图省事，还是用的可以在Windows下直接安装版本老版本。使用最新版也可，只要支持lettuce就行。
Docker Desktop for Window | latest

> 相关组件版本配关系，地址： [https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E][官网说明地址]

# 开源协议

Apache Licence 2.0 [（英文原文）](https://www.apache.org/licenses/LICENSE-2.0.html) Apache Licence是著名的非盈利开源组织Apache采用的协议。该协议和BSD类似，同样鼓励代码共享和尊重原作者的著作权，同样允许代码修改，再发布（作为开源或商业软件）。 需要满足的条件如下：

- 需要给代码的用户一份Apache Licence
- 如果你修改了代码，需要在被修改的文件中说明。 
- 在延伸的代码中（修改和有源代码衍生的代码中）需要带有原来代码中的协议，商标，专利声明和其他原来作者规定需要包含的说明。 
- 如果再发布的产品中包含一个Notice文件，则在Notice文件中需要带有Apache Licence。你可以在Notice中增加自己的许可，但不可以表现为对Apache Licence构成更改。 Apache Licence也是对商业应用友好的许可。使用者也可以在需要的时候修改代码来满足需要并作为开源或商业产品发布/销售。
## 组件版本关系

Spring Cloud Alibaba Version | Sentinel Version | Nacos Version | RocketMQ Version | Dubbo Version | Seata Version
---|---|---|---|---|---
2.2.3.RELEASE or 2.1.3.RELEASE or 2.0.3.RELEASE | 1.8.0 | 1.3.3 | 4.4.0 | 2.7.8 | 1.3.0
2.2.1.RELEASE or 2.1.2.RELEASE or 2.0.2.RELEASE | 1.7.1 | 1.2.1 | 4.4.0 | 2.7.6 | 1.2.0
2.2.0.RELEASE | 1.7.1 | 1.1.4 | 4.4.0 | 2.7.4.1 | 1.0.0
2.1.2.RELEASE or 2.0.2.RELEASE | 1.7.1 | 1.2.1 | 4.4.0 | 2.7.6 | 1.1.0
2.1.1.RELEASE or 2.0.1.RELEASE or 1.5.1.RELEASE | 1.7.0 | 1.1.4 | 4.4.0 | 2.7.3 | 0.9.0
2.1.0.RELEASE or 2.0.0.RELEASE or 1.5.0.RELEASE | 1.6.3 | 1.1.1 | 4.4.0 | 2.7.3 | 0.7.1

## 毕业版本依赖关系(推荐使用)

Spring Cloud Version | Spring Cloud Alibaba Version | Spring Boot Version
---|---|---
Spring Cloud Hoxton.SR8 | 2.2.3.RELEASE | 2.3.2.RELEASE
Spring Cloud Greenwich.SR6 | 2.1.3.RELEASE | 2.1.13.RELEASE
Spring Cloud Hoxton.SR8 | 2.2.2.RELEASE | 2.3.2.RELEASE
Spring Cloud Hoxton.SR3 | 2.2.1.RELEASE | 2.2.5.RELEASE
Spring Cloud Hoxton.RELEASE | 2.2.0.RELEASE | 2.2.X.RELEASE
Spring Cloud Greenwich | 2.1.2.RELEASE | 2.1.X.RELEASE
Spring Cloud Finchley | 2.0.2.RELEASE | 2.0.X.RELEASE
Spring Cloud Edgware | 1.5.1.RELEASE(停止维护，建议升级) | 1.5.X.RELEASE