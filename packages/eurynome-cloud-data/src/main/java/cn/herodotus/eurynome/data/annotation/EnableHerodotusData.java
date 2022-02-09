/*
 * Copyright (c) 2019-2021 Gengwei Zheng(herodotus@aliyun.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project Name: eurynome-cloud
 * Module Name: eurynome-cloud-data
 * File Name: EnableHerodotusData.java
 * Author: gengwei.zheng
 * Date: 2021/05/07 11:28:07
 */

package cn.herodotus.eurynome.data.annotation;

import cn.herodotus.eurynome.data.configuration.DataConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>Project: eurynome-cloud </p>
 * <p>File: EnableRedisStorage </p>
 *
 * <p>Description: 开启平台数据存储 </p>
 * <p>
 * 目前主要功能：
 * 1.开启JpaAuditing
 * 2.开启Redis存储
 * 3.开启JetCache缓存
 *
 * @author : gengwei.zheng
 * @date : 2020/2/3 17:13
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DataConfiguration.class)
public @interface EnableHerodotusData {
}