package com.dycn.airportconsumer.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liq
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("airport_worker")
public class AirportWorker extends BaseEntity implements  Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键，自增 无意义
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上级部门
     */
    @TableField("p_dept")
    private String parentDept;

    /**
     * 部门
     */
    @TableField("dept")
    private String dept;

    /**
     * 相关工作区域
     */
    @TableField("work_dept")
    private String workDept;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 在职否
     */
    @TableField("on_job")
    private String onJob;

    /**
     * 证件号码
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 证件类型
     */
    @TableField("id_type")
    private String idType;

    /**
     * 户籍地址
     */
    @TableField("address")
    private String address;

    /**
     * 居住地址
     */
    @TableField("local_address")
    private String localAddress;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

    /**
     * 岗位名称
     */
    @TableField("job_name")
    private String jobName;

    /**
     * 检测频率
     */
    @TableField("testing_frequency")
    private Integer testingFrequency;

    /**
     * 风险等级 A,B,C
     */
    @TableField("risk_level")
    private String riskLevel;

    /**
     * 检测次数
     */
    @TableField("test_count")
    private Integer testCount;

    /**
     * 是否核酸检测过
     */
    @TableField("is_testing")
    private String isTesting;

    /**
     * 最后一次核算检测时间
     */
    @TableField("last_test_time")
    private LocalDate lastTestTime;

    /**
     * 是否接种疫苗
     */
    @TableField("is_vaccination")
    private String isVaccination;

    @TableField("inner_dept")
    private String innerDept;

    /**
     * 最近一次接种疫苗时间
     */
    @TableField("last_vaccination_time")
    private LocalDate lastVaccinationTime;

    /**
     * 下次核算检测时间
     */
    @TableField("next_test_time")
    private LocalDate nextTestTime;


    /**
     * 人脸下发状态 1.已发 2.未发
     */
    @TableField("face_status")
    private Integer faceStatus;

    /**
     * 同行状态 1.允许 2.禁止 3.即将过期
     */
    @TableField("pass_status")
    private Integer passStatus;

    /**
     * 疫苗接种第一针
     */
    @TableField("first_vaccinate_time")
    private LocalDate firstVaccinateTime;

    /**
     * 疫苗接种第二针
     */
    @TableField("second_vaccinate_time")
    private LocalDate secondVaccinateTime;

    @TableField("worker_department")
    private String workerDepartment;

    /**
     * 健康云用户id
     */
    @TableField("account_id")
    private String accountId;


    @TableField("img_url")
    private String imgUrl;


    /**
     * 健康推送状态 0未推送，1 ok、
     */
    @TableField("health_status")
    private Integer healthStatus;

    /**
     * 体温
     */
    @TableField("temperature")
    private Float temperature;

    /**
     * 体温时间
     */
    @TableField("temperature_time")
    private LocalDate temperatureTime;

    @TableField("push_status")
    private Integer pushStatus;

    @TableField("belong_dept")
    private String belongDept;

    @TableField("soc")
    private String soc;

    @TableField("nad_examine_result_status")
    private Integer nadExamineResultStatus;

    @TableField("ncov_vaccinate_status")
    private Integer ncovVaccinateStatus;


    @TableField("belongs_area")
    private String belongsArea;



    @TableField(value = "update_user",fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

    @TableField(value = "create_user",fill = FieldFill.INSERT)
    private String createUser;



}
