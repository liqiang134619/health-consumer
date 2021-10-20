package com.dycn.airportconsumer.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dycn.airportconsumer.common.NoModel;
import com.dycn.airportconsumer.entity.AirportWorker;
import com.dycn.airportconsumer.mapper.AirportWorkerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liq
 * @date 2021/3/26
 */
@Service
@Slf4j
public class AirportWorkerServiceImpl extends ServiceImpl<AirportWorkerMapper, AirportWorker> implements IAirportWorkerService {
    @Override
    public List<NoModel> listfs() {
        return baseMapper.listfs();
    }
}
