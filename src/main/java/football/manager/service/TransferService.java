package football.manager.service;

import football.manager.model.Transfer;
import java.util.List;

public interface TransferService {
    Transfer createTransfer(Transfer transfer);

    Transfer get(Long id);

    List<Transfer> getAll();
}
