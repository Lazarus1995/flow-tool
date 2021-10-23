package com.qu.flowcore.entity.vo;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

/**
 * 用户实体类
 * TODO 用户表完善后需更新该类
 *
 * @author zhangkaiyong
 * @date 2021/05/22 14:19
 */
@ApiModel(description = "用户数据实体 SysUser", value = "用户数据实体 SysUser")
public class SysUser {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4871008425084568555L;
    /**
     * 登录名
     */
    @ApiModelProperty(name = "loginName", value = "登录名")
    private String loginName;

    /**
     * 密码
     */
    @ApiModelProperty(name = "password", value = "密码")
    private String password;

    /**
     * 用户名
     */
    @ApiModelProperty(name = "name", value = "用户名")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(name = "mobile", value = "手机号")
    private String mobile;

    /**
     * 公司
     */
    @ApiModelProperty(name = "company", value = "公司")
    private String company;

    /**
     * 部门
     */
    @ApiModelProperty(name = "department", value = "部门")
    private String department;

    /**
     * 岗位
     */
    @ApiModelProperty(name = "post", value = "岗位")
    private String post;

    /**
     * 是否禁用1可用0禁用
     */
    @ApiModelProperty(name = "status", value = "是否禁用1可用0禁用")
    private Integer status;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(name = "lastLoginDate", value = "最后登录时间")
    private Long lastLoginDate;

    /**
     * 角色ID
     */
    @ApiModelProperty(name = "roleId", value = "角色ID")
    private String roleId;

    /**
     * 角色名
     */
    @ApiModelProperty(name = "roleName", value = "角色名")
    private String roleName;

    /**
     *
     */
    @ApiModelProperty(name = "parentArea", value = "所属省市域编码")
    private String parentArea;
    private String area;
    private String areaCode;
    private Integer roleType;

    private String vehicleType;

    /**
     *
     */
    @ApiModelProperty(name = "userValidity", value = "用户有效期")
    private Long userValidity;

    /**
     * 扩展字段，本次登录的token
     */
    private String token;

    /**
     * 扩展字段，csrfToken
     */
    private Set<String> csrfToken;

    /**
     * 业务参数用于校验密码是否一致和接收错误信息
     */
    private String confirmPwd;
    private String errorMsg;

    /**
     * 有效期
     */
    @ApiModelProperty(name = "validityDate", value = "有效期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date validityDate;

    /**
     * 是否禁用 0正常，1激活
     */
    @ApiModelProperty(name = "disableFlag", value = "是否禁用 0正常，1激活")
    private Integer disableFlag;

    public Integer getDisableFlag() {
        return disableFlag;
    }

    public void setDisableFlag(Integer disableFlag) {
        this.disableFlag = disableFlag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

//    public SysRole getRole() {
//        return role;
//    }
//
//    public void setRole(SysRole role) {
//        this.role = role;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getUserValidity() {
        return userValidity;
    }

    public void setUserValidity(Long userValidity) {
        this.userValidity = userValidity;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getParentArea() {
        return parentArea;
    }

    public void setParentArea(String parentArea) {
        this.parentArea = parentArea;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Set<String> getCsrfToken() {
        return csrfToken;
    }

    public void setCsrfToken(Set<String> csrfToken) {
        this.csrfToken = csrfToken;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }


    /**
     * 新增和修改参数验证
     */
    public boolean validateUser() {
        if (StringUtils.isBlank(loginName)) {
            setErrorMsg("登录名称不能为空");
            return false;
        }
        setLoginName(replaceAll(loginName));
        if (loginName.length() > 30) {
            setErrorMsg("登录名称长度不能超过30");
            return false;
        }
        if (StringUtils.isBlank(password)) {
            setErrorMsg("密码不能为空");
            return false;
        }
        if (StringUtils.isBlank(confirmPwd)) {
            setErrorMsg("确认密码不能为空");
            return false;
        }

        setPassword(replaceAll(password));
        setConfirmPwd(replaceAll(confirmPwd));
        if (!password.equals(confirmPwd)) {
            setErrorMsg("两次密码输入不一致");
            return false;
        }
        if (validityDate == null) {
            setErrorMsg("有效期不能为空");
            return false;
        }

        if (StringUtils.isBlank(name)) {
            setErrorMsg("姓名不能为空");
            return false;
        }
        setName(replaceAll(name));
        if (name.length() > 30) {
            setErrorMsg("姓名长度不能超过30");
            return false;
        }
        if (StringUtils.isNotBlank(department)) {
            setDepartment(replaceAll(department));
            if (department.length() > 30) {
                setErrorMsg("部门长度不能超过30");
                return false;
            }
        }

        if (StringUtils.isNotBlank(company)) {
            setCompany(replaceAll(company));
            if (company.length() > 30) {
                setErrorMsg("公司长度不能超过30");
                return false;
            }
        }

        if (StringUtils.isNotBlank(post)) {
            setPost(replaceAll(post));
            if (post.length() > 30) {
                setErrorMsg("岗位长度不能超过30");
                return false;
            }
        }
        return true;
    }

    private String replaceAll(String param) {
        param = param.replace(" ", "");
        return param;
    }
}
