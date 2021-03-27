package com.dycn.airportconsumer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liq
 * @since 2021-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("airport_passway")
public class AirportPassway extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;



    /**
     * 出入口标识
     */
    @TableField("entrance")
    private String entrance;

    /**
     * ip地址
     */
    @TableField("ip")
    private String ip;

    /**
     * 设备启用时间
     */
    @TableField("equipment_time")
    private LocalDateTime equipmentTime;

    /**
     * 设备ID
     */
    @TableField("equipment_id")
    private String equipmentId;

    /**
     * 设备在线离线状态  1在线 0离线
     */
    @TableField("online")
    private Integer online;

    /**
     * 设备状态 备用
     */
    @TableField("status")
    private Integer status;


    @TableField("area_id")
    private Integer areaId;

    @TableField("last_beat")
    private LocalDateTime lastBeat;


}
