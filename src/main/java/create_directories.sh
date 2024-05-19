#!/bin/bash

# 创建主目录结构
mkdir -p com/domain/expansion/Sukuna

# 创建 apigateway 服务的目录结构
mkdir -p com/domain/expansion/Sukuna/apigateway/controller
mkdir -p com/domain/expansion/Sukuna/apigateway/service
mkdir -p com/domain/expansion/Sukuna/apigateway/config

# 创建 auth 服务的目录结构
mkdir -p com/domain/expansion/Sukuna/auth/controller
mkdir -p com/domain/expansion/Sukuna/auth/service
mkdir -p com/domain/expansion/Sukuna/auth/repository
mkdir -p com/domain/expansion/Sukuna/auth/config

# 创建 cicd 服务的目录结构
mkdir -p com/domain/expansion/Sukuna/cicd/config

# 创建 comms 服务的目录结构
mkdir -p com/domain/expansion/Sukuna/comms/controller
mkdir -p com/domain/expansion/Sukuna/comms/service
mkdir -p com/domain/expansion/Sukuna/comms/config

# 创建 dbs_cache 服务的目录结构
mkdir -p com/domain/expansion/Sukuna/dbs_cache/entity
mkdir -p com/domain/expansion/Sukuna/dbs_cache/repository
mkdir -p com/domain/expansion/Sukuna/dbs_cache/config

# 创建 docs_testings 的目录结构
mkdir -p com/domain/expansion/Sukuna/docs_testings/swagger
mkdir -p com/domain/expansion/Sukuna/docs_testings/postman
mkdir -p com/domain/expansion/Sukuna/docs_testings/tests

# 创建 exceptions 的目录结构
mkdir -p com/domain/expansion/Sukuna/exceptions/handler
mkdir -p com/domain/expansion/Sukuna/exceptions/config

# 创建 monitors_logs 的目录结构
mkdir -p com/domain/expansion/Sukuna/monitors_logs/config
mkdir -p com/domain/expansion/Sukuna/monitors_logs/alerts

# 创建 msgQueue 服务的目录结构
mkdir -p com/domain/expansion/Sukuna/msgQueue/kafka
mkdir -p com/domain/expansion/Sukuna/msgQueue/rabbitmq
mkdir -p com/domain/expansion/Sukuna/msgQueue/config

# 提示创建成功
echo "所有目录已创建成功。"
