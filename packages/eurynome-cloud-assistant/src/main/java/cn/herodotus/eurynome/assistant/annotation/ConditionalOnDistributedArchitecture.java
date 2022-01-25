/*
 * Copyright (c) 2019-2022 Gengwei Zheng (herodotus@aliyun.com)
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
 * Module Name: eurynome-cloud-assistant
 * File Name: ConditionalOnDistributedArchitecture.java
 * Author: gengwei.zheng
 * Date: 2022/01/11 14:53:11
 */

package cn.herodotus.eurynome.assistant.annotation;

import cn.herodotus.eurynome.assistant.condition.DistributedArchitectureCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * <p>Description: 分布式架构模式条件注解 </p>
 *
 * @author : gengwei.zheng
 * @date : 2022/1/11 14:53
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(DistributedArchitectureCondition.class)
public @interface ConditionalOnDistributedArchitecture {
}