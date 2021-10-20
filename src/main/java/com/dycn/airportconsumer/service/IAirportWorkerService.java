package com.dycn.airportconsumer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dycn.airportconsumer.common.NoModel;
import com.dycn.airportconsumer.entity.AirportWorker;

import java.util.List;

/**
 * @author liq
 * @date 2021/3/26
 */
public interface IAirportWorkerService extends IService<AirportWorker> {
    List<NoModel> listfs();


}
