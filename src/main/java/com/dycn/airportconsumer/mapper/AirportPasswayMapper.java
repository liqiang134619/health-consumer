package com.dycn.airportconsumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dycn.airportconsumer.entity.AirportPassway;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author liq
 * @date 2021/3/26
 */
@Mapper
public interface AirportPasswayMapper extends BaseMapper<AirportPassway> {

    @Select("select * from airport_passway where last_beat >  date_sub(NOW(),INTERVAL 10 minute)")
    List<AirportPassway> listOnline();
}
