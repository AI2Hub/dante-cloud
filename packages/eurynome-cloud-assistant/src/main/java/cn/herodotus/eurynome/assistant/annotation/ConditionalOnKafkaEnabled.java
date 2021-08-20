/*
 * Copyright (c) 2019-2021 Gengwei Zheng (herodotus@aliyun.com)
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
 * File Name: ConditionalOnKafkaEnabled.java
 * Author: gengwei.zheng
 * Date: 2021/08/11 20:36:11
 */

package cn.herodotus.eurynome.assistant.annotation;

import cn.herodotus.eurynome.common.constant.magic.PropertyConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.*;

/**
 * <p>Description: kafka是否开启条件准基 </p>
 *
 * @author : gengwei.zheng
 * @date : 2021/8/11 20:36
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ConditionalOnProperty(value = PropertyConstants.ITEM_MANAGEMENT_KAFKA_ENABLED)
public @interface ConditionalOnKafkaEnabled {
}
