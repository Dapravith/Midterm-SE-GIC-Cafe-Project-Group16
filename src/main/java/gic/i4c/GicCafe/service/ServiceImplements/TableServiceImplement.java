package gic.i4c.GicCafe.service.ServiceImplements;

import java.util.List;

import gic.i4c.GicCafe.model.Table_Seat;
import gic.i4c.GicCafe.repository.TableRepository;
import gic.i4c.GicCafe.service.TableService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImplement implements TableService {
    private TableRepository tableRepository;
    private JdbcTemplate jdbcTemplate;

    public TableServiceImplement(TableRepository tableRepository, JdbcTemplate jdbcTemplate) {
        super();
        this.tableRepository = tableRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Table_Seat> getAllTable() {
        return tableRepository.findAll();
    }

    @Override
    public void setNewTableAmount(Integer tableAmount) {
        Long rowsAmount = tableRepository.count();
        if(rowsAmount > tableAmount){
            for(int i=1; i<=rowsAmount; i++){
                if(i > tableAmount){
                    tableRepository.deleteById(i);
                }
            }
        }
        else if (rowsAmount < tableAmount){
            String sql = "ALTER TABLE table_seat AUTO_INCREMENT = 1";
            jdbcTemplate.execute(sql);
            for(int i = (int) (rowsAmount + 1); i<=tableAmount; i++){
                Table_Seat newTable = new Table_Seat();
                newTable.setNumber(i);
                newTable.setAvailability(1);
                tableRepository.save(newTable);
            }
        }
    }

    @Override
    public Long getTableAmount() {
        return tableRepository.count();
    }

    @Override
    public void setTableUnavailable(Integer tableID) {
        Table_Seat table = tableRepository.findById(tableID).get();
        table.setAvailability(0);
        tableRepository.save(table);

    }
    @Override
    public void setTableAvailable(Integer tableID) {
        Table_Seat table = tableRepository.findById(tableID).get();
        table.setAvailability(1);
        tableRepository.save(table);

    }

}
