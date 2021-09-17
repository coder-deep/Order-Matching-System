package com.oms.service;

import com.oms.beans.Trade_log;

public interface ITrade_logService {

	Trade_log findById(int t_id);

	Trade_log addTrade(Trade_log trade);

}