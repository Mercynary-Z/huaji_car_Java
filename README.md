# 滑机车二手车交易系统

## 简介

滑机车是一个二手车交易平台，类似瓜子二手车直卖网。本网站提供车辆买卖、经纪人咨询等功能，提供完整的数据库管理后端页面。

## 相关技术介绍

本项目整体采用目前流行的 SSM 架构，使用了 Spring Boot 框架来构建项目，简化新 Spring 应用的初始搭建以及开发过程。

前端模版渲染采用了 Thymeleaf 框架，这也是 Spring Boot 官方建议使用的前端模版框架，代替了传统了 jsp 页面，使得前端开发好的 html 模版经过简单修改后即可当作动态页面使用，大大提高了开发效率。

前端模版主要使用 bootstrap 进行编写，因此使得编写好的网页可以支持响应式，符合当今对移动端浏览的要求，而且布局美观大方，功能合理。图片上传使用了 jQuery-upload 插件，表格展示使用了 jQuery-table 插件。

数据库则选用主流的 MySQL 数据库，完全符合我们网站的需求，将一些操作写成了触发器和事件，简化了代码结构。

WEB 服务器使用主流的 tomcat 服务器，而且由于使用了 Spring Boot 框架，我们只需要使用 Spring Boot 自带的 tomcat 服务器就能够进行部署，无需单独安装配置，十分便捷。另外，为了提高数据传输效率，我们开启了 gzip 压缩技术，减少了网络传输中的流量。

本项目调用了百度地图的 API 来实现地图定位功能，使用了网易七鱼的 API 来实现了客服功能。这些都是十分成熟且实用的 API，功能强大，实用效果很好。

对于原始汽车数据的获取，我们使用了 Python 的 beautifulsoup 库来解析 HTML 数据，使用 selenium 框架来突破瓜子二手车的反爬虫策略。

## 页面预览
![筛选](https://github.com/dream-fall/huaji_car_Java/raw/master/pic/image018.jpg)
![推荐](https://github.com/dream-fall/huaji_car_Java/raw/master/pic/image022.png)
![用户反馈](https://github.com/dream-fall/huaji_car_Java/raw/master/pic/image025.png)
![页脚](https://github.com/dream-fall/huaji_car_Java/raw/master/pic/image026.png)

>本项目为Java课程设计项目，详细设计内容可见/doc文件夹中的实验报告。