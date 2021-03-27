package com.dycn.airportconsumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dycn.airportconsumer.entity.AirportPassway;

import java.util.List;

/**
 * @author liq
 * @date 2021/3/26
 */
public interface IAirportPasswayService extends IService<AirportPassway> {

    List<AirportPassway> listOnline();

}
