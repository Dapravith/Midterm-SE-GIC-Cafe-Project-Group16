package gic.i4c.GicCafe.service;

import java.util.List;

import gic.i4c.GicCafe.model.Table_Seat;

public interface TableService {
    List<Table_Seat> getAllTable();
    void setNewTableAmount(Integer tableAmount);
    Long getTableAmount();
    void setTableUnavailable(Integer tabLeID);
    void setTableAvailable(Integer tabLeID);
    
}
