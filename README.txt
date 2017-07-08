# AG-Admin
基于Spring Cloud的云分布式后台管理系统架构，核心技术采用Eureka、Fegin、Ribbon、Zuul、Hystrix、Security、Mybatis等主要框架和中间件，
UI采用Bootstrap、jquery等前端组件，数据库采用mysql。

AG-Admin具有常用的用户管理、菜单管理等功能.可以通过任意扩展服务，来做到多系统并行，目前仅初步实现用权限管理系统的部分功能。

---------

# 模块说明

### spring-cloud-center 服务注册中心
http://localhost:8761

### spring-cloud-monitor 监控中心
http://localhost:8764

### spring-cloud-admin 服务层
http://localhost:8763

### spring-cloud-gate 网关负载中心，统一请求入口
http://localhost:8765

### spring-cloud-ui 前端UI
http://localhost:8766

### spring-cloud-common 公共服务层

------------
# 启动指南

- 运行数据库脚本，创建库：ag_admin，脚本：init.sql，修改spring-cloud-admin配置文件中的数据库连接参数
- 依次运行main类：CenterBootstrap（spring-cloud-center）、GateBootstrap（spring-cloud-gate）、
			  AdminBootstrap（spring-cloud-admin）、UIBootstrap（spring-cloud-ui）、MonitorBootstrap（spring-cloud-monitor）
- 访问地址: http://localhost:8765/admin/index  账号/密码：admin/admin
---------

