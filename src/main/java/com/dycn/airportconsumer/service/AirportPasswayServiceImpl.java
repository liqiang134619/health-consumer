package com.dycn.airportconsumer.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dycn.airportconsumer.entity.AirportPassway;
import com.dycn.airportconsumer.mapper.AirportPasswayMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liq
 * @date 2021/3/26
 */
@Service
public class AirportPasswayServiceImpl extends ServiceImpl<AirportPasswayMapper, AirportPassway> implements IAirportPasswayService {

    @Override
    public List<AirportPassway> listOnline() {
        return baseMapper.listOnline();
    }

}
