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
 * Module Name: eurynome-cloud-upms-api
 * File Name: SysSecurityAttribute.java
 * Author: gengwei.zheng
 * Date: 2021/08/05 17:06:05
 */

package cn.herodotus.eurynome.upms.api.entity.system;

import cn.herodotus.eurynome.data.base.entity.BaseSysEntity;
import cn.herodotus.eurynome.upms.api.constants.UpmsConstants;
import cn.herodotus.eurynome.upms.api.entity.oauth.OAuth2Scopes;
import cn.herodotus.eurynome.upms.api.listener.entity.SysSecurityAttributeEntityListener;
import com.google.common.base.MoreObjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: 系统权限元数据 </p>
 *
 * @author : gengwei.zheng
 * @date : 2021/8/5 17:06
 */
@ApiModel(description = "系统权限元数据")
@Entity
@Table(name = "sys_security_attribute", indexes = {@Index(name = "sys_security_attribute_id_idx", columnList = "attribute_id")})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = UpmsConstants.REGION_SYS_SECURITY_ATTRIBUTE)
@EntityListeners(value = {SysSecurityAttributeEntityListener.class})
public class SysSecurityAttribute extends BaseSysEntity {

    @ApiModelProperty(value = "元数据ID")
    @Id
    @GeneratedValue(generator = "metadata-uuid")
    @GenericGenerator(name = "metadata-uuid", strategy = "cn.herodotus.eurynome.upms.api.generator.SysSecurityAttributeUUIDGenerator")
    @Column(name = "attribute_id", length = 64)
    private String attributeId;

    @ApiModelProperty(value = "URL")
    @Column(name = "url", length = 2048)
    private String url;

    @ApiModelProperty(value = "请求类型")
    @Column(name = "request_method", length = 20)
    private String requestMethod;

    @ApiModelProperty(value = "服务ID", notes = "如果是单体式架构，该值为空")
    @Column(name = "service_id", length = 128)
    private String serviceId;

    @ApiModelProperty(value = "默认权限代码", notes = "该值即authority_code值，如果没有设置其它权限，该值会被封装成hasAuthority('XX')作为默认权限, 是自动生成的默认权限")
    @Column(name = "attribute_code", length = 128)
    private String attributeCode;

    @ApiModelProperty(value = "表达式", notes = "Security和OAuth2涉及的表达式字符串，通过该值设置不同的权限")
    @Column(name = "expression", length = 128)
    private String expression;

    @ApiModelProperty(value = "IP地址", notes = "该表达式要符合WebExpressionVoter规则,根据配置的IP地址动态生成")
    @Column(name = "ip_address", length = 64)
    private String ipAddress;

    @ApiModelProperty(value = "指定表达式", notes = "预留字段，该值可手动设置具体的权限表达式，而不是通过Role、Scope等关联数据自动生成")
    @Column(name = "manual_setting", length = 256)
    private String manualSetting;

    @ApiModelProperty(value = "动态权限表达式", notes = "该表达式要符合WebExpressionVoter规则,根据配置动态生成")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = UpmsConstants.REGION_SYS_ROLE)
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "sys_role_authority",
            joinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "attribute_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<SysRole> roles = new HashSet<>();

    @ApiModelProperty(value = "动态权限表达式", notes = "该表达式要符合WebExpressionVoter规则,根据配置动态生成")
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = UpmsConstants.REGION_OAUTH_SCOPES)
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "oauth_scopes_authority",
            joinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "attribute_id")},
            inverseJoinColumns = {@JoinColumn(name = "scope_id", referencedColumnName = "scope_id")})
    private Set<OAuth2Scopes> scopes = new HashSet<>();

    @Override
    public String getLinkedProperty() {
        return null;
    }

    @Override
    public String getId() {
        return this.getAttributeId();
    }

    public String getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(String attributeId) {
        this.attributeId = attributeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAttributeCode() {
        return attributeCode;
    }

    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getManualSetting() {
        return manualSetting;
    }

    public void setManualSetting(String manualSetting) {
        this.manualSetting = manualSetting;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public Set<OAuth2Scopes> getScopes() {
        return scopes;
    }

    public void setScopes(Set<OAuth2Scopes> scopes) {
        this.scopes = scopes;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("attributeId", attributeId)
                .add("url", url)
                .add("requestMethod", requestMethod)
                .add("serviceId", serviceId)
                .add("attributeCode", attributeCode)
                .add("expression", expression)
                .add("ipAddress", ipAddress)
                .add("manualSetting", manualSetting)
                .toString();
    }
}
