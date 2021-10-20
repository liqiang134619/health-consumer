package com.dycn.airportconsumer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dycn.airportconsumer.common.NoModel;
import com.dycn.airportconsumer.entity.AirportWorker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liq
 * @date 2021/3/26
 */
@Mapper
public interface AirportWorkerMapper extends BaseMapper<AirportWorker> {


    List<NoModel> listfs();

}
